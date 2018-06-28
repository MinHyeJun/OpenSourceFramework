package com.ssu.member;
//VO Value Object
public class MemberVO {
	private int seq;  //property
	private String mid;
	private String mpw;
	private String mname;
	private String mgubun;
	private String regdate;
	
	public int getSeq() {
		return seq;
	}
	public void setSeq(int seq) {
		this.seq = seq;
	}
	public String getMid() {
		return mid;
	}
	public void setMid(String mid) {
		this.mid = mid;
	}
	public String getMpw() {
		return mpw;
	}
	public void setMpw(String mpw) {
		this.mpw = mpw;
	}
	public String getMname() {
		return mname;
	}
	public void setMname(String mname) {
		this.mname = mname;
	}
	public String getMgubun() {
		return mgubun;
	}
	public void setMgubun(String mgubun) {
		this.mgubun = mgubun;
	}
	public String getRegdate() {
		return regdate;
	}
	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}
	
//	public void setSeq(int sss) {
//		this.seq = sss;
//	}
//	
//	public int getSeq() {
//		return this.seq;
//	}
	
	
}
