package com.dambeetech.first.board.model.vo;

import java.sql.Date;

import org.springframework.stereotype.Component;

@Component
public class Board implements java.io.Serializable{
	private static final long serialVersionUID = 1002L;
	private int BOARDNO;
	private int USERNO;
	private String BOARDTITLE;
	private String BOARDCONTENT;
	private java.sql.Date BOARDDATE;
	private int BOARDREADCOUNT = 0;
	private String USERNAME;
	private String BOARDORIGINALFILE;
	private String BOARDRENAMEFILE;
	private int BOARDTOTALNO; //ROWNUM으로 가져옴
	private int BOARDGROUP;
	private int BOARDGROUPNO;
	private int BOARDDEPTH;
	private int BOARDKEY;
	private int BOARDPARENT;
	private String BOARDTITLE2;
	private String BOARDDELETESTATE;
	public Board() {}
	public Board(int bOARDNO, int uSERNO, String bOARDTITLE, String bOARDCONTENT, Date bOARDDATE, int bOARDREADCOUNT,
			String uSERNAME, String bOARDORIGINALFILE, String bOARDRENAMEFILE, int bOARDTOTALNO, int bOARDGROUP,
			int bOARDGROUPNO, int bOARDDEPTH, int bOARDKEY, int bOARDPARENT, String bOARDTITLE2,
			String bOARDDELETESTATE) {
		super();
		BOARDNO = bOARDNO;
		USERNO = uSERNO;
		BOARDTITLE = bOARDTITLE;
		BOARDCONTENT = bOARDCONTENT;
		BOARDDATE = bOARDDATE;
		BOARDREADCOUNT = bOARDREADCOUNT;
		USERNAME = uSERNAME;
		BOARDORIGINALFILE = bOARDORIGINALFILE;
		BOARDRENAMEFILE = bOARDRENAMEFILE;
		BOARDTOTALNO = bOARDTOTALNO;
		BOARDGROUP = bOARDGROUP;
		BOARDGROUPNO = bOARDGROUPNO;
		BOARDDEPTH = bOARDDEPTH;
		BOARDKEY = bOARDKEY;
		BOARDPARENT = bOARDPARENT;
		BOARDTITLE2 = bOARDTITLE2;
		BOARDDELETESTATE = bOARDDELETESTATE;
	}
	@Override
	public String toString() {
		return "Board [BOARDNO=" + BOARDNO + ", USERNO=" + USERNO + ", BOARDTITLE=" + BOARDTITLE + ", BOARDCONTENT="
				+ BOARDCONTENT + ", BOARDDATE=" + BOARDDATE + ", BOARDREADCOUNT=" + BOARDREADCOUNT + ", USERNAME="
				+ USERNAME + ", BOARDORIGINALFILE=" + BOARDORIGINALFILE + ", BOARDRENAMEFILE=" + BOARDRENAMEFILE
				+ ", BOARDTOTALNO=" + BOARDTOTALNO + ", BOARDGROUP=" + BOARDGROUP + ", BOARDGROUPNO=" + BOARDGROUPNO
				+ ", BOARDDEPTH=" + BOARDDEPTH + ", BOARDKEY=" + BOARDKEY + ", BOARDPARENT=" + BOARDPARENT
				+ ", BOARDTITLE2=" + BOARDTITLE2 + ", BOARDDELETESTATE=" + BOARDDELETESTATE + "]";
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
	public String getBOARDTITLE() {
		return BOARDTITLE;
	}
	public void setBOARDTITLE(String bOARDTITLE) {
		BOARDTITLE = bOARDTITLE;
	}
	public String getBOARDCONTENT() {
		return BOARDCONTENT;
	}
	public void setBOARDCONTENT(String bOARDCONTENT) {
		BOARDCONTENT = bOARDCONTENT;
	}
	public java.sql.Date getBOARDDATE() {
		return BOARDDATE;
	}
	public void setBOARDDATE(java.sql.Date bOARDDATE) {
		BOARDDATE = bOARDDATE;
	}
	public int getBOARDREADCOUNT() {
		return BOARDREADCOUNT;
	}
	public void setBOARDREADCOUNT(int bOARDREADCOUNT) {
		BOARDREADCOUNT = bOARDREADCOUNT;
	}
	public String getUSERNAME() {
		return USERNAME;
	}
	public void setUSERNAME(String uSERNAME) {
		USERNAME = uSERNAME;
	}
	public String getBOARDORIGINALFILE() {
		return BOARDORIGINALFILE;
	}
	public void setBOARDORIGINALFILE(String bOARDORIGINALFILE) {
		BOARDORIGINALFILE = bOARDORIGINALFILE;
	}
	public String getBOARDRENAMEFILE() {
		return BOARDRENAMEFILE;
	}
	public void setBOARDRENAMEFILE(String bOARDRENAMEFILE) {
		BOARDRENAMEFILE = bOARDRENAMEFILE;
	}
	public int getBOARDTOTALNO() {
		return BOARDTOTALNO;
	}
	public void setBOARDTOTALNO(int bOARDTOTALNO) {
		BOARDTOTALNO = bOARDTOTALNO;
	}
	public int getBOARDGROUP() {
		return BOARDGROUP;
	}
	public void setBOARDGROUP(int bOARDGROUP) {
		BOARDGROUP = bOARDGROUP;
	}
	public int getBOARDGROUPNO() {
		return BOARDGROUPNO;
	}
	public void setBOARDGROUPNO(int bOARDGROUPNO) {
		BOARDGROUPNO = bOARDGROUPNO;
	}
	public int getBOARDDEPTH() {
		return BOARDDEPTH;
	}
	public void setBOARDDEPTH(int bOARDDEPTH) {
		BOARDDEPTH = bOARDDEPTH;
	}
	public int getBOARDKEY() {
		return BOARDKEY;
	}
	public void setBOARDKEY(int bOARDKEY) {
		BOARDKEY = bOARDKEY;
	}
	public int getBOARDPARENT() {
		return BOARDPARENT;
	}
	public void setBOARDPARENT(int bOARDPARENT) {
		BOARDPARENT = bOARDPARENT;
	}
	public String getBOARDTITLE2() {
		return BOARDTITLE2;
	}
	public void setBOARDTITLE2(String bOARDTITLE2) {
		BOARDTITLE2 = bOARDTITLE2;
	}
	public String getBOARDDELETESTATE() {
		return BOARDDELETESTATE;
	}
	public void setBOARDDELETESTATE(String bOARDDELETESTATE) {
		BOARDDELETESTATE = bOARDDELETESTATE;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
}
