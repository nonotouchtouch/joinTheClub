package com.hanming.po;

public class ClubInfo {
	private String clubId;
	private String cName;
	private String cDate;
	private int cType;
	private String cTypestr;
	public String getcTypestr() {
		return cTypestr;
	}
	public void setcTypestr(String cTypestr) {
		this.cTypestr = cTypestr;
	}
	private int cStar;
	private int cMembers;
	private String cIntro;
	
	
	public String getcIntro() {
		return cIntro;
	}
	public void setcIntro(String cIntro) {
		this.cIntro = cIntro;
	}
	public String getClubId() {
		return clubId;
	}
	public void setClubId(String clubId) {
		this.clubId = clubId;
	}
	public String getcName() {
		return cName;
	}
	public void setcName(String cName) {
		this.cName = cName;
	}
	public String getcDate() {
		return cDate;
	}
	public void setcDate(String cDate) {
		this.cDate = cDate;
	}
	public int getcType() {
		return cType;
	}
	public void setcType(int cType) {
		this.cType = cType;
	}
	public int getcStar() {
		return cStar;
	}
	public void setcStar(int cStar) {
		this.cStar = cStar;
	}
	public int getcMembers() {
		return cMembers;
	}
	public void setcMembers(int cMembers) {
		this.cMembers = cMembers;
	}


}
