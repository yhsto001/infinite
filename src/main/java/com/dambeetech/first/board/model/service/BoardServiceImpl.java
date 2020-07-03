package com.dambeetech.first.board.model.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dambeetech.first.board.model.dao.BoardDao;
import com.dambeetech.first.board.model.vo.Board;
import com.dambeetech.first.board.model.vo.BoardComment;
import com.dambeetech.first.board.model.vo.BoardReply;
import com.dambeetech.first.common.CommonPage;

@Service("boardService")
public class BoardServiceImpl implements BoardService{

	@Autowired
	private BoardDao boardDao;
	
	@Override
	public 	ArrayList<Board> boardList(CommonPage cpage){
		return boardDao.boardList(cpage);
	}
	@Override
	public int boardListCount(CommonPage cpage) {

		return boardDao.boardListCount(cpage);
	}
	@Override
	public int boardWrite(Board board) {
		
		return boardDao.boardWrite(board);
	}
	@Override
	public Board boardDetail(int boardno) {
		return boardDao.boardDetail(boardno);
	}
	
	@Override
	public int boardReadCount(int boardno) {
		return boardDao.boardReadCount(boardno);
	}
	
	@Override
	public int boardDelete(Board board) {
		return boardDao.boardDelete(board);
	}

	
	@Override
	public int boardChange(Board board) {
		return boardDao.boardChange(board);
	}

	@Override
	public int boardChange2(Board board) {
		return boardDao.boardChange2(board);
	}
	
	@Override
	public ArrayList<BoardComment> boardCommentList(int boardno){
		return boardDao.boardCommentList(boardno);
	}
	
	@Override
	public int boardCommentAdd(BoardComment boardComment) {
		return boardDao.boardCommentAdd(boardComment);
	}
	
	@Override
	public int boardCommentDel(BoardComment boardComment) {
		return boardDao.boardCommentDel(boardComment);
	}
	
	@Override
	public int boardCommnetChange(BoardComment boardComment) {
		return boardDao.boardCommnetChange(boardComment);
	}
	
	@Override
	public ArrayList<BoardReply> replylist(){
		return boardDao.replylist();
	}
	
	@Override
	public int boardReplySelect(int boardReply) {
		return boardDao.boardReplySelect(boardReply);
	}
	
	@Override
	public int boardReplyEnroll(BoardReply boardReply) {
		return boardDao.boardReplyEnroll(boardReply);
	}
	
	@Override
	public BoardReply boardReplySelect2(int replyno) {
		return boardDao.boardReplySelect2(replyno);
	}
	@Override
	public int boardReplyNoUpdate(BoardReply boardReply2) {
		return boardDao.boardReplyNoUpdate(boardReply2);
	}
	
	@Override
	public int boardReplyInsert(BoardReply boardReply) {
		return boardDao.boardReplyInsert(boardReply);
	}
	@Override
	public int boardReplyDelete(int replyno) {
		return boardDao.boardReplyDelete(replyno);
	}
	
	@Override
	public int boardParentUpdate(Board board) {
		return boardDao.boardParentUpdate(board);
	}
	
	@Override
	public int boardReplyAdd(Board board) {
		return boardDao.boardReplyAdd(board);
	}
	
	@Override
	public int boardreUpdate(Board board) {
		return boardDao.boardreUpdate(board);
	}
	
	@Override
	public int boardDeleteUpdate(Board board) {
		return boardDao.boardDeleteUpdate(board);
	}
}
