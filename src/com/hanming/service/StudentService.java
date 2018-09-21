package com.hanming.service;

import java.util.List;

import com.hanming.po.PageInfo;
import com.hanming.po.Student;


public interface StudentService {
	
	public abstract Student login(Student stu);
	public abstract boolean signup(Student stu);
	public abstract String getMaxID();
	public abstract List<Object> getAllStudent();
	
	public abstract boolean changepwd(Student stu);
	
	public abstract boolean join(String date,String sid,String cid);
	
	public abstract List<Object> myapplication(String sid);
	public abstract Integer getAppCount(String id);
	public abstract List<Object> myApplication(PageInfo pageInfo);
	
	
	public abstract boolean deleteStu(String sno);
	public abstract boolean updateStudent(Student stu);
	public abstract boolean save(Student stu);

//院系
	public abstract List<Object>  getDept();

}
