package com.dambeetech.first.board.model.service;

import java.util.ArrayList;

import com.dambeetech.first.board.model.vo.Board;
import com.dambeetech.first.board.model.vo.BoardComment;
import com.dambeetech.first.board.model.vo.BoardReply;
import com.dambeetech.first.common.CommonPage;

public interface BoardService {

	ArrayList<Board> boardList(CommonPage cpage);

	int boardListCount(CommonPage cpage);

	int boardWrite(Board board);

	Board boardDetail(int boardno);

	int boardReadCount(int boardno);

	int boardDelete(Board board);

	int boardChange(Board board);

	int boardChange2(Board board);

	ArrayList<BoardComment> boardCommentList(int boardno);

	int boardCommentAdd(BoardComment boardComment);

	int boardCommentDel(BoardComment boardComment);

	int boardCommnetChange(BoardComment boardComment);

	ArrayList<BoardReply> replylist();

	int boardReplySelect(int boardno);

	int boardReplyEnroll(BoardReply boardReply);

	BoardReply boardReplySelect2(int replyno);

	int boardReplyNoUpdate(BoardReply boardReply2);

	int boardReplyInsert(BoardReply boardReply);

	int boardReplyDelete(int replyno);

	int boardParentUpdate(Board board);

	int boardReplyAdd(Board board);

	int boardreUpdate(Board board);

	int boardDeleteUpdate(Board board);

	

}
