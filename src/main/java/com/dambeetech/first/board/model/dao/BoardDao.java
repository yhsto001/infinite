package com.dambeetech.first.board.model.dao;

import java.util.ArrayList;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dambeetech.first.board.model.vo.Board;
import com.dambeetech.first.board.model.vo.BoardComment;
import com.dambeetech.first.board.model.vo.BoardReply;
import com.dambeetech.first.common.CommonPage;

@Repository("boardDao")
public class BoardDao {

	
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	
	public ArrayList<Board> boardList(CommonPage cpage){
		List<Board> list = sqlSession.selectList("boardMapper.boardList",cpage);
		return (ArrayList<Board>) list;
	}


	public int boardListCount(CommonPage cpage) {
		return sqlSession.selectOne("boardMapper.boardListCount",cpage);
	}


	public int boardWrite(Board board) {
		
		return sqlSession.insert("boardMapper.boardWrite",board);
	}


	public Board boardDetail(int boardno) {
		
		return sqlSession.selectOne("boardMapper.boardDetail",boardno);
	}


	public int boardReadCount(int boardno) {
		
		return sqlSession.update("boardMapper.boardReadCount",boardno);
	}


	public int boardDelete(Board board) {
	
		return sqlSession.delete("boardMapper.boardDelete",board);
	}


	public int boardChange(Board board) {
		
		return sqlSession.update("boardMapper.boardChange",board);
	}


	public int boardChange2(Board board) {

		return sqlSession.update("boardMapper.boardChange2",board);
	}


	public ArrayList<BoardComment> boardCommentList(int boardno) {
		
		List<BoardComment> list = sqlSession.selectList("boardMapper.boardCommentList",boardno);
		return (ArrayList<BoardComment>) list;
	}


	public int boardCommentAdd(BoardComment boardComment) {
		
		return sqlSession.insert("boardMapper.boardCommentAdd",boardComment);
	}


	public int boardCommentDel(BoardComment boardComment) {
	
		return sqlSession.delete("boardMapper.boardCommentDel",boardComment);
	}


	public int boardCommnetChange(BoardComment boardComment) {
	
		return sqlSession.update("boardMapper.boardCommnetChange",boardComment);
	}


	public ArrayList<BoardReply> replylist() {
		List<BoardReply> replylist = sqlSession.selectList("boardMapper.replylist");
		return (ArrayList<BoardReply>) replylist;
	}


	public int boardReplySelect(int boardReply) {
	
		return sqlSession.selectOne("boardMapper.boardReplySelect",boardReply);
	}


	public int boardReplyEnroll(BoardReply boardReply) {
		
		return sqlSession.insert("boardMapper.boardReplyEnroll",boardReply);
	}


	public BoardReply boardReplySelect2(int replyno) {
		return sqlSession.selectOne("boardMapper.boardReplySelect2",replyno);
	}


	public int boardReplyNoUpdate(BoardReply boardReply2) {
		
		return sqlSession.update("boardMapper.boardReplyNoUpdate",boardReply2);
	}


	public int boardReplyInsert(BoardReply boardReply) {
		return sqlSession.insert("boardMapper.boardReplyInsert",boardReply);
	}


	public int boardReplyDelete(int replyno) {
		
		return sqlSession.update("boardMapper.boardReplyDelete",replyno);
	}


	public int boardParentUpdate(Board board) {

		return sqlSession.update("boardMapper.boardParentUpdate",board);
	}


	public int boardReplyAdd(Board board) {

		return sqlSession.insert("boardMapper.boardReplyAdd",board);
	}


	public int boardreUpdate(Board board) {

		return sqlSession.update("boardMapper.boardreUpdate",board);
	}


	public int boardDeleteUpdate(Board board) {

		return sqlSession.update("boardMapper.boardDeleteUpdate",board);
	}



}
