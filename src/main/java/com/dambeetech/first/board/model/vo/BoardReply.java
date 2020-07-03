package com.dambeetech.first.board.model.vo;

import java.sql.Date;

import org.springframework.stereotype.Component;

@Component
public class BoardReply implements java.io.Serializable{
	private static final long serialVersionUID = 1031L;
	private int REPLYNO;
	private int REPLYGROUP;
	private int REPLYGROUPNO;
	private int REPLYDEPTH;
	private String REPLYNAME;
	private java.sql.Date REPLYDATE;
	private String REPLYCONTENT;
	private int BOARDNO;
	private int USERNO;
	private String REPLYDELETE;
	public BoardReply() {}
	public BoardReply(int rEPLYNO, int rEPLYGROUP, int rEPLYGROUPNO, int rEPLYDEPTH, String rEPLYNAME, Date rEPLYDATE,
			String rEPLYCONTENT, int bOARDNO, int uSERNO, String rEPLYDELETE) {
		super();
		REPLYNO = rEPLYNO;
		REPLYGROUP = rEPLYGROUP;
		REPLYGROUPNO = rEPLYGROUPNO;
		REPLYDEPTH = rEPLYDEPTH;
		REPLYNAME = rEPLYNAME;
		REPLYDATE = rEPLYDATE;
		REPLYCONTENT = rEPLYCONTENT;
		BOARDNO = bOARDNO;
		USERNO = uSERNO;
		REPLYDELETE = rEPLYDELETE;
	}
	@Override
	public String toString() {
		return "BoardReply [REPLYNO=" + REPLYNO + ", REPLYGROUP=" + REPLYGROUP + ", REPLYGROUPNO=" + REPLYGROUPNO
				+ ", REPLYDEPTH=" + REPLYDEPTH + ", REPLYNAME=" + REPLYNAME + ", REPLYDATE=" + REPLYDATE
				+ ", REPLYCONTENT=" + REPLYCONTENT + ", BOARDNO=" + BOARDNO + ", USERNO=" + USERNO + ", REPLYDELETE="
				+ REPLYDELETE + "]";
	}
	public int getREPLYNO() {
		return REPLYNO;
	}
	public void setREPLYNO(int rEPLYNO) {
		REPLYNO = rEPLYNO;
	}
	public int getREPLYGROUP() {
		return REPLYGROUP;
	}
	public void setREPLYGROUP(int rEPLYGROUP) {
		REPLYGROUP = rEPLYGROUP;
	}
	public int getREPLYGROUPNO() {
		return REPLYGROUPNO;
	}
	public void setREPLYGROUPNO(int rEPLYGROUPNO) {
		REPLYGROUPNO = rEPLYGROUPNO;
	}
	public int getREPLYDEPTH() {
		return REPLYDEPTH;
	}
	public void setREPLYDEPTH(int rEPLYDEPTH) {
		REPLYDEPTH = rEPLYDEPTH;
	}
	public String getREPLYNAME() {
		return REPLYNAME;
	}
	public void setREPLYNAME(String rEPLYNAME) {
		REPLYNAME = rEPLYNAME;
	}
	public java.sql.Date getREPLYDATE() {
		return REPLYDATE;
	}
	public void setREPLYDATE(java.sql.Date rEPLYDATE) {
		REPLYDATE = rEPLYDATE;
	}
	public String getREPLYCONTENT() {
		return REPLYCONTENT;
	}
	public void setREPLYCONTENT(String rEPLYCONTENT) {
		REPLYCONTENT = rEPLYCONTENT;
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
	public String getREPLYDELETE() {
		return REPLYDELETE;
	}
	public void setREPLYDELETE(String rEPLYDELETE) {
		REPLYDELETE = rEPLYDELETE;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}


}
