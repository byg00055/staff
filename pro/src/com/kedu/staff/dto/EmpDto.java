package com.kedu.staff.dto;

import java.sql.Timestamp;

public class EmpDto {
	
//	EMPID	NOT NULL	CHAR(10)
//	PASS	NOT NULL	VARCHAR2(20)
//	EMPNM	NOT NULL	VARCHAR2(20)
//	JUMIN	NOT NULL	VARCHAR2(13)
//	EMP_IMG		VARCHAR2(500)
//	DEPTCD	NOT NULL	VARCHAR2(10)
//	RANKCD	NOT NULL	VARCHAR2(10)
//	POSTNUM	NOT NULL	VARCHAR2(6)
//	BASEPOST		VARCHAR2(200)
//	SEMIPOST		VARCHAR2(200)
//	EMAIL	NOT NULL	VARCHAR2(50)
//	PHONE	NOT NULL	VARCHAR2(11)
//	SALARY	NOT NULL	NUMBER(10)
//	INDATE	NOT NULL	DATE
//	OUTDATE		DATE
//	ADMIN	NOT NULL	NUMBER(1)
//	REGDATE		DATE
	
//	emp table의 값을 처리하는 Dto 클래스.
	
	private String		empid;
	private String		pass;
	private	String		empnm;
	private String		jumin;
	private String		emp_img;
	private String		deptcd;
	private String		rankcd;
	private String		postnum;
	private String		basepost;
	private String		semipost;
	private String		email;
	private String		phone;
	private int			salary;
	private Timestamp	indate;
	private Timestamp	outdate;
	private int			admin;
	private Timestamp	regdate;
	
	public String getEmpid() {
		return empid;
	}
	public void setEmpid(String empid) {
		this.empid = empid;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public String getEmpnm() {
		return empnm;
	}
	public void setEmpnm(String empnm) {
		this.empnm = empnm;
	}
	public String getJumin() {
		return jumin;
	}
	public void setJumin(String jumin) {
		this.jumin = jumin;
	}
	public String getEmp_img() {
		return emp_img;
	}
	public void setEmp_img(String emp_img) {
		this.emp_img = emp_img;
	}
	public String getDeptcd() {
		return deptcd;
	}
	public void setDeptcd(String deptcd) {
		this.deptcd = deptcd;
	}
	public String getRankcd() {
		return rankcd;
	}
	public void setRankcd(String rankcd) {
		this.rankcd = rankcd;
	}
	public String getPostnum() {
		return postnum;
	}
	public void setPostnum(String postnum) {
		this.postnum = postnum;
	}
	public String getBasepost() {
		return basepost;
	}
	public void setBasepost(String basepost) {
		this.basepost = basepost;
	}
	public String getSemipost() {
		return semipost;
	}
	public void setSemipost(String semipost) {
		this.semipost = semipost;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	public Timestamp getIndate() {
		return indate;
	}
	public void setIndate(Timestamp indate) {
		this.indate = indate;
	}
	public Timestamp getOutdate() {
		return outdate;
	}
	public void setOutdate(Timestamp outdate) {
		this.outdate = outdate;
	}
	public int getAdmin() {
		return admin;
	}
	public void setAdmin(int admin) {
		this.admin = admin;
	}
	public Timestamp getRegdate() {
		return regdate;
	}
	public void setRegdate(Timestamp regdate) {
		this.regdate = regdate;
	}
	
	@Override
	public String toString() {
		return "EmpDto [empid=" + empid + ", pass=" + pass + ", empnm=" + empnm + ", jumin=" + jumin + ", emp_img="
				+ emp_img + ", deptcd=" + deptcd + ", rankcd=" + rankcd + ", postnum=" + postnum + ", basepost="
				+ basepost + ", semipost=" + semipost + ", email=" + email + ", phone=" + phone + ", salary=" + salary
				+ ", indate=" + indate + ", outdate=" + outdate + ", admin=" + admin + ", regdate=" + regdate + "]";
	}
	
	
	
	
	
	
}
