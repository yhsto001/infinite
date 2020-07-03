package com.dambeetech.first.board.model.vo;

import java.sql.Date;

import org.springframework.stereotype.Component;

@Component
public class BoardComment implements java.io.Serializable{
	private static final long serialVersionUID = 1030L;
	private int COMMENTNO;
	private String COMMENTNAME;
	private java.sql.Date COMMENTDATE;
	private String COMMENTCONTENT;
	private int BOARDNO;
	private int USERNO;
	public BoardComment() {}
	@Override
	public String toString() {
		return "BoardComment [COMMENTNO=" + COMMENTNO + ", COMMENTNAME=" + COMMENTNAME + ", COMMENTDATE=" + COMMENTDATE
				+ ", COMMENTCONTENT=" + COMMENTCONTENT + ", BOARDNO=" + BOARDNO + ", USERNO=" + USERNO + "]";
	}
	public BoardComment(int cOMMENTNO, String cOMMENTNAME, Date cOMMENTDATE, String cOMMENTCONTENT, int bOARDNO,
			int uSERNO) {
		super();
		COMMENTNO = cOMMENTNO;
		COMMENTNAME = cOMMENTNAME;
		COMMENTDATE = cOMMENTDATE;
		COMMENTCONTENT = cOMMENTCONTENT;
		BOARDNO = bOARDNO;
		USERNO = uSERNO;
	}
	public int getCOMMENTNO() {
		return COMMENTNO;
	}
	public void setCOMMENTNO(int cOMMENTNO) {
		COMMENTNO = cOMMENTNO;
	}
	public String getCOMMENTNAME() {
		return COMMENTNAME;
	}
	public void setCOMMENTNAME(String cOMMENTNAME) {
		COMMENTNAME = cOMMENTNAME;
	}
	public java.sql.Date getCOMMENTDATE() {
		return COMMENTDATE;
	}
	public void setCOMMENTDATE(java.sql.Date cOMMENTDATE) {
		COMMENTDATE = cOMMENTDATE;
	}
	public String getCOMMENTCONTENT() {
		return COMMENTCONTENT;
	}
	public void setCOMMENTCONTENT(String cOMMENTCONTENT) {
		COMMENTCONTENT = cOMMENTCONTENT;
	}
	public int getBOARDNO() {
		return BOARDNO;
	}
	public void setBOARDNO(int bOARDNO) {
		BOARDNO = bOARDNO;
	}
	public int getUSERNO() {
		return USERNO;
	}
	public void setUSERNO(int uSERNO) {
		USERNO = uSERNO;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}



	
}
