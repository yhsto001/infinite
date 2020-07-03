package com.dambeetech.first.board.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.dambeetech.first.board.model.service.BoardService;
import com.dambeetech.first.board.model.vo.Board;
import com.dambeetech.first.board.model.vo.BoardComment;
import com.dambeetech.first.board.model.vo.BoardReply;
import com.dambeetech.first.common.CommonPage;
import com.dambeetech.first.user.controller.UserController;

@Controller
public class BoardController {

	
	private static final Logger logger = LoggerFactory.getLogger(UserController.class);

	@Autowired
	private BoardService boardService;

	//보드 상세보기
	@RequestMapping("boardView.do")
	public String boardDetail(HttpServletRequest request, Model model) {
		int boardno = Integer.parseInt(request.getParameter("boardno"));
		System.out.println(boardno);
		model.addAttribute("no",boardno);
		return "board/boardDetail";
	}
	
	//ajax 보드 상세보기 내용
	@RequestMapping("boardDetail.do")
	@ResponseBody
	public Board boardDetailView(HttpServletRequest request, Model model, Board board) {
		int boardno = Integer.parseInt(request.getParameter("no"));
		int result = boardService.boardReadCount(boardno);
		board = boardService.boardDetail(boardno);
		System.out.println(board);
		
	return board;
	}

		//ajax 보드 상세보기 답글
		@RequestMapping("boardDetailComment.do")
		@ResponseBody
		public List<BoardComment> boardDetailComment(HttpServletRequest request, Model model, Board board,BoardComment boardcomment) {
			int boardno = Integer.parseInt(request.getParameter("no"));
			ArrayList<BoardComment> list = boardService.boardCommentList(boardno);

		return list;
		}
		
	@RequestMapping("boardWrite.do")
		public String boardWrite() {
			
			return "board/boardWrite";
		}

	@RequestMapping("boardReplyWrite.do")
	public String boardReplyWrite(Board board, Model model) {
		board = boardService.boardDetail(board.getBOARDNO());
		model.addAttribute("board", board);
		System.out.println(board);
		return "board/boardReplyWrite";
	}
		//게시판 리스트 //검색 + 페이징 
		@RequestMapping("boardList.do")
		public String boardView(@RequestParam(value = "page", required = false, defaultValue = "1")int currentPage, CommonPage cpage, Model model) {
			ArrayList<BoardReply> replylist = boardService.replylist();
			model.addAttribute("replylist", replylist);
			return "board/boardView";
		}
		
		//boardList 테이블 리스트
		@RequestMapping("boardListTable")
		@ResponseBody
		public List<Board> boardListTable(@RequestParam(value = "page", required = false, defaultValue = "1")int currentPage, CommonPage cpage, Model model){

			int listCount = 0;
			listCount = boardService.boardListCount(cpage);
			cpage.pageUpdate(10, 5, listCount, currentPage);
			cpage.setStartList(cpage.getStartList()-1);
			cpage.setEndList(10);
			System.out.println(cpage +"리스트");
			//마리아디비 바이바티스에서는 startList,endList 시작이 0부터시작한다. 디비실행시와 다름 -1 해줘야함 
			//마리아디비 limit 에서는 몇번째부터, 몇개까지 인지설정.
				ArrayList<Board> list = boardService.boardList(cpage);
				System.out.println(list);
				
				/*model.addAttribute("commonPage", cpage);*/
			
			return list;
		}
		
		//테이블 페이지
		@RequestMapping("boardListTable2")
		@ResponseBody
		public CommonPage boardListTable2(@RequestParam(value = "page", required = false, defaultValue = "1")int currentPage, CommonPage cpage, Model model,HttpServletRequest request){
			int listCount = 0;
			listCount = boardService.boardListCount(cpage);
			cpage.pageUpdate(10, 5, listCount, currentPage);
			cpage.setStartList(cpage.getStartList()-1);
			cpage.setEndList(10);
			System.out.println(cpage +"페이징");
			//마리아디비 바이바티스에서는 startList,endList 시작이 0부터시작한다. 디비실행시와 다름 -1 해줘야함 
			//마리아디비 limit 에서는 몇번째부터, 몇개까지 인지설정.
			return cpage;
		}
		
		//게시글작성
		@RequestMapping("boardenroll.do")
		public String boardEnroll(Board board, MultipartHttpServletRequest mtfRequest,HttpServletRequest request) {
		        MultipartFile mf = mtfRequest.getFile("file");
		       /* String savePath = request.getSession().getServletContext().getRealPath("resources/boardfile");*/
		        String savePath = "C:\\down";
		        if (!mf.isEmpty()) {
		        	String originalFileName = null;
					String renameFileName = null;
					try {
						mf.transferTo(new File(savePath + "\\" + mf.getOriginalFilename()));
						originalFileName = mf.getOriginalFilename();  //오리지널 파일네임 생성
						if (originalFileName != null) {
							SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
							renameFileName = sdf.format(new java.sql.Date(System.currentTimeMillis())) + "."
									+ originalFileName.substring(originalFileName.lastIndexOf(".") + 1);
							// 파일명을 바꾸려면 File 객체의 renameTo() 사용함
							File originFile = new File(savePath + "\\" + originalFileName);
							File renameFile = new File(savePath + "\\" + renameFileName);
							// 파일 이름바꾸기 실행함 >> 실패한 경우에는 직접 바꾸기함
							if (!originFile.renameTo(renameFile)) {
								// 파일 입출력 스트림 생성하고, 원본을 읽어서 바꿀이름 파일에 기록함
								int read = -1;
								byte[] buf = new byte[1024]; // 한 번에 읽어서 저장할 바이트 배열
								FileInputStream fin = new FileInputStream(originFile);
								FileOutputStream fout = new FileOutputStream(renameFile);
								while ((read = fin.read(buf, 0, buf.length)) != -1) {
									fout.write(buf, 0, read);
								}
								fin.close();
								fout.close();
								originFile.delete(); // 원본 파일 삭제함.
							}
						}
					} catch (IOException e) {
						e.printStackTrace();
					}
					board.setBOARDORIGINALFILE(originalFileName);
					board.setBOARDRENAMEFILE(renameFileName);
		        }
		        //결과값에따라 에러페이지 또는 성공페이지
		        String page;
		        System.out.println(board.getBOARDORIGINALFILE());
		        int result = boardService.boardWrite(board);
		        if(result >= 1) {
		        	page = "redirect:boardList.do";
		        }else {
		        	page = "common/loginfail";  //임시
		        }
		        
			return page;
		}
		
		//파일다운로드 뷰리졸버
		@RequestMapping("boardfiledown.do")
		public ModelAndView fileDown(HttpServletRequest request, Board board, ModelAndView modelAndView) {
			/*String savePath = request.getSession().getServletContext().getRealPath("/resources/boardfile");*/
			String savePath = "C:\\down";
			
			System.out.println(board + "실행됨");
			File downFile = new File(savePath + "/" + board.getBOARDRENAMEFILE());
			System.out.println(downFile);
			modelAndView.addObject("fileDown", downFile);
			modelAndView.addObject("originalFileName", board.getBOARDORIGINALFILE());
			modelAndView.setViewName("downFile");
			return modelAndView;
		}
		
		//게시글 삭제
		@RequestMapping("boardDelete.do")
		public String boardDelete(Board board) {
			System.out.println("삭제"+board);
			board = boardService.boardDetail(board.getBOARDNO());
			System.out.println("삭제하꺼 " + board);
			if(board.getBOARDPARENT() == 0) {
				int result = boardService.boardDelete(board);
			}else {
				int deleteUpdate = boardService.boardDeleteUpdate(board);
			}

			return "redirect:boardList.do";
		}
		
		//게시글 수정 뷰
			@RequestMapping("boardChangeView.do")
			public String boardChangeView(HttpServletRequest request, Model model) {
				System.out.println("왓당");
			int boardno = Integer.parseInt(request.getParameter("BOARDNO"));
			System.out.println(boardno);
			model.addAttribute("no",boardno);
			return "board/boardChange";
		}
			
			
				//게시글 수정
				@RequestMapping("boardUpdate.do")
				public String boardUpdate(Board board, MultipartHttpServletRequest mtfRequest,HttpServletRequest request) {
				        MultipartFile mf = mtfRequest.getFile("file");
				       /* String savePath = request.getSession().getServletContext().getRealPath("resources/boardfile");*/
				        String savePath = "C:\\down";
				        int result = 0;
				        int result2 = 0;
				        if (!mf.isEmpty()) {
				        	String originalFileName = null;
							String renameFileName = null;
							try {
								mf.transferTo(new File(savePath + "\\" + mf.getOriginalFilename()));
								originalFileName = mf.getOriginalFilename();  //오리지널 파일네임 생성
								if (originalFileName != null) {
									SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
									renameFileName = sdf.format(new java.sql.Date(System.currentTimeMillis())) + "."
											+ originalFileName.substring(originalFileName.lastIndexOf(".") + 1);
									// 파일명을 바꾸려면 File 객체의 renameTo() 사용함
									File originFile = new File(savePath + "\\" + originalFileName);
									File renameFile = new File(savePath + "\\" + renameFileName);
									// 파일 이름바꾸기 실행함 >> 실패한 경우에는 직접 바꾸기함
									if (!originFile.renameTo(renameFile)) {
										// 파일 입출력 스트림 생성하고, 원본을 읽어서 바꿀이름 파일에 기록함
										int read = -1;
										byte[] buf = new byte[1024]; // 한 번에 읽어서 저장할 바이트 배열
										FileInputStream fin = new FileInputStream(originFile);
										FileOutputStream fout = new FileOutputStream(renameFile);
										while ((read = fin.read(buf, 0, buf.length)) != -1) {
											fout.write(buf, 0, read);
										}
										fin.close();
										fout.close();
										originFile.delete(); // 원본 파일 삭제함.
									}
								}
							} catch (IOException e) {
								e.printStackTrace();
							}
							board.setBOARDORIGINALFILE(originalFileName);
							board.setBOARDRENAMEFILE(renameFileName);
							
							System.out.println("여기까지옴");
							result = boardService.boardChange(board);
				        }
				        //결과값에따라 에러페이지 또는 성공페이지
				        String page;
				       
				        if (mf.isEmpty()) {
				        	 System.out.println("여기까지옴2");
				        	 System.out.println(board);
				        result2 = boardService.boardChange2(board);
				        }
				        if(result >= 1 || result2 >= 1) {
				        	page = "redirect:boardList.do";
				        }else {
				        	page = "common/loginfail";  //임시
				        }
					return page;
				}
				//게시글 답글 등록
				@RequestMapping("commentAdd.do")
				public String commentAdd(BoardComment BoardComment,HttpServletRequest request) {
					System.out.println(BoardComment + "왓당");
					int result = boardService.boardCommentAdd(BoardComment);
					if(result >= 1) {
			        	System.out.println("성공");
			        }else {
			        System.out.println("실패");
			        }
					return "redirect:boardView.do?boardno="+BoardComment.getBOARDNO();
				}
				//게시글 삭제
				@RequestMapping("boardCommentDel.do")
				public String boardCommentDel(BoardComment BoardComment) {
					
					int result = boardService.boardCommentDel(BoardComment);
					
					return "redirect:boardView.do?boardno="+BoardComment.getBOARDNO();
				}
				
					@RequestMapping("boardCommentChange.do")
				public String boardCommentChange(BoardComment BoardComment) {
					
					int result = boardService.boardCommnetChange(BoardComment);
					
					return "redirect:boardView.do?boardno="+BoardComment.getBOARDNO();
				}
					//ajax 게시글 첫번째 댓글작성
					@RequestMapping("boardReplyEnroll.do")
					@ResponseBody
					public BoardReply boardReplyEnroll(HttpServletRequest request, Model model,BoardReply boardReply) {
						int boardno = boardReply.getBOARDNO();
						int replygroupno = boardService.boardReplySelect(boardno);
						System.out.println(replygroupno);
						boardReply.setREPLYGROUP(replygroupno);
						int result = boardService.boardReplyEnroll(boardReply);
					return boardReply;
					}
					//ajax 게시글 대댓글작성
					@RequestMapping("boardReplyEnroll2.do")
					@ResponseBody
					public BoardReply boardReplyEnroll2(HttpServletRequest request, Model model,BoardReply boardReply) {
						int replyno = boardReply.getREPLYNO();
						//원글 조회
						BoardReply boardReply2 = boardService.boardReplySelect2(replyno);
						//대댓글 인서트 전 groupno순서 업데이트 원글no + 1 한숫자 윗숫자들 +1 씩해주고 인서트 값은 +1 한값으로 넣어줌
						int replynoUpdate = boardService.boardReplyNoUpdate(boardReply2);
						//대댓글 인서트 하기위해 셋팅 깊이를 +1 하고 원본 순서에 +1 을해준다.
						boardReply.setBOARDNO(boardReply2.getBOARDNO());
						boardReply.setREPLYGROUP(boardReply2.getREPLYGROUP());
						boardReply.setREPLYGROUPNO(boardReply2.getREPLYGROUPNO() + 1);
						boardReply.setREPLYDEPTH(boardReply2.getREPLYDEPTH() + 1);
						int replyinsert = boardService.boardReplyInsert(boardReply);
					return boardReply;
					}
					
					//ajax 게시글 대댓글작성
					@RequestMapping("boardReplyDelete.do")
					@ResponseBody
					public BoardReply boardReplyDelete(HttpServletRequest request, Model model,BoardReply boardReply) {
						int replyno = boardReply.getREPLYNO();
						int replyDelete = boardService.boardReplyDelete(replyno);
					return boardReply;
					}
		
					//게시글 리플작성
					@RequestMapping("boardReplyAdd.do")
					public String boardReplyEnroll(Board board, MultipartHttpServletRequest mtfRequest,HttpServletRequest request) {
					        MultipartFile mf = mtfRequest.getFile("file");
					  /*      String savePath = request.getSession().getServletContext().getRealPath("resources/boardfile");*/
					        String savePath = "C:\\down";
					        if (!mf.isEmpty()) {
					        	String originalFileName = null;
								String renameFileName = null;
								try {
									mf.transferTo(new File(savePath + "\\" + mf.getOriginalFilename()));
									originalFileName = mf.getOriginalFilename();  //오리지널 파일네임 생성
									if (originalFileName != null) {
										SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
										renameFileName = sdf.format(new java.sql.Date(System.currentTimeMillis())) + "."
												+ originalFileName.substring(originalFileName.lastIndexOf(".") + 1);
										// 파일명을 바꾸려면 File 객체의 renameTo() 사용함
										File originFile = new File(savePath + "\\" + originalFileName);
										File renameFile = new File(savePath + "\\" + renameFileName);
										// 파일 이름바꾸기 실행함 >> 실패한 경우에는 직접 바꾸기함
										if (!originFile.renameTo(renameFile)) {
											// 파일 입출력 스트림 생성하고, 원본을 읽어서 바꿀이름 파일에 기록함
											int read = -1;
											byte[] buf = new byte[1024]; // 한 번에 읽어서 저장할 바이트 배열
											FileInputStream fin = new FileInputStream(originFile);
											FileOutputStream fout = new FileOutputStream(renameFile);
											while ((read = fin.read(buf, 0, buf.length)) != -1) {
												fout.write(buf, 0, read);
											}
											fin.close();
											fout.close();
											originFile.delete(); // 원본 파일 삭제함.
										}
									}
								} catch (IOException e) {
									e.printStackTrace();
								}
								board.setBOARDORIGINALFILE(originalFileName);
								board.setBOARDRENAMEFILE(renameFileName);
					        }
					        //결과값에따라 에러페이지 또는 성공페이지
					        String page;

					        if(board.getBOARDPARENT() == 0) {
					        int parentUpdate = boardService.boardParentUpdate(board);	
					        board.setBOARDPARENT(board.getBOARDNO());
					        int replyinsert = boardService.boardReplyAdd(board);
					    	page = "redirect:boardList.do";
					        }else {
					        	 int Update = boardService.boardreUpdate(board);	
					        	board.setBOARDPARENT(board.getBOARDNO());
					        	 int replyinsert = boardService.boardReplyAdd(board);
					        /*	page = "common/loginfail";*/
					        	 page = "redirect:boardList.do";
					        }
						return page;
					
					}
}
