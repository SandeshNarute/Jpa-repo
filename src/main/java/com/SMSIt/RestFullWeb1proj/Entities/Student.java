package com.SMSIt.RestFullWeb1proj.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Student {
	@Id
private int sid;
private String sfname;
private String slname;
private String saddress;
private String shobby;
public int getSid() {
	return sid;
}
public void setSid(int sid) {
	this.sid = sid;
}
public String getSfname() {
	return sfname;
}
public void setSfname(String sfname) {
	this.sfname = sfname;
}
public String getSlname() {
	return slname;
}
public void setSlname(String slname) {
	this.slname = slname;
}
public String getSaddress() {
	return saddress;
}
public void setSaddress(String saddress) {
	this.saddress = saddress;
}
public String getShobby() {
	return shobby;
}
public void setShobby(String shobby) {
	this.shobby = shobby;
}
@Override
public String toString() {
	return "Student [sid=" + sid + ", sfname=" + sfname + ", slname=" + slname + ", saddress=" + saddress + ", shobby="
			+ shobby + "]";
}
public Student(int sid, String sfname, String slname, String saddress, String shobby) {
	super();
	this.sid = sid;
	this.sfname = sfname;
	this.slname = slname;
	this.saddress = saddress;
	this.shobby = shobby;
}
public Student() {
	super();
	// TODO Auto-generated constructor stub
}


}
