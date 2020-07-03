package com.dambeetech.first.user.model.vo;

import org.springframework.stereotype.Component;

@Component
public class User implements java.io.Serializable{
	private static final long serialVersionUID = 1001L;
	
	private int USERNO;
	private String USERID;
	private String USERPW;
	private String USERNAME;
	private String USERPHONE;
	private String USERMAIL;
	
	public User() {}

	public int getUSERNO() {
		return USERNO;
	}

	public void setUSERNO(int uSERNO) {
		USERNO = uSERNO;
	}

	public String getUSERID() {
		return USERID;
	}

	public void setUSERID(String uSERID) {
		USERID = uSERID;
	}

	public String getUSERPW() {
		return USERPW;
	}

	public void setUSERPW(String uSERPW) {
		USERPW = uSERPW;
	}

	public String getUSERNAME() {
		return USERNAME;
	}

	public void setUSERNAME(String uSERNAME) {
		USERNAME = uSERNAME;
	}

	public String getUSERPHONE() {
		return USERPHONE;
	}

	public void setUSERPHONE(String uSERPHONE) {
		USERPHONE = uSERPHONE;
	}

	public String getUSERMAIL() {
		return USERMAIL;
	}

	public void setUSERMAIL(String uSERMAIL) {
		USERMAIL = uSERMAIL;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public User(int uSERNO, String uSERID, String uSERPW, String uSERNAME, String uSERPHONE, String uSERMAIL) {
		super();
		USERNO = uSERNO;
		USERID = uSERID;
		USERPW = uSERPW;
		USERNAME = uSERNAME;
		USERPHONE = uSERPHONE;
		USERMAIL = uSERMAIL;
	}

	@Override
	public String toString() {
		return "User [USERNO=" + USERNO + ", USERID=" + USERID + ", USERPW=" + USERPW + ", USERNAME=" + USERNAME
				+ ", USERPHONE=" + USERPHONE + ", USERMAIL=" + USERMAIL + "]";
	}
}
