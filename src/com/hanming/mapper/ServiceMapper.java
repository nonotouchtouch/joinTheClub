package com.hanming.mapper;

import java.util.List;

import com.hanming.po.Joinclublog;
import com.hanming.po.Student;



public interface ServiceMapper {
	//Student
	public abstract Student login(Student stu);
	public abstract boolean signup(Student stu);
	public abstract String getMaxID();
	public abstract List<Object> getAllStudent();
	public abstract boolean deleteStu(String value);
	
	public abstract boolean changepwd(Student stu);
	public abstract boolean join(Joinclublog joinclublog);
	public abstract List<Object> alreadyin(Joinclublog joinclublog);//已加入或者正在申请
	public abstract List<Object> myapplication(String sid);
	public abstract Integer myApplicationCount(String id);
	public abstract List<Object> myApplication(String info,int a,int b);
	
	//club
	public abstract List<Object> getAllClub();
	public abstract List<Object> getClubWithType(int type);
	public abstract String clubinfo(String cid);
	public abstract List<Object> getType();
	public abstract String getOneType(Integer type);
	
	//club members分页
	public abstract int queryTotal(String info);
	public abstract List<Object> queryAll(String info,int a,int b);
	
	
	
	//专业
	public abstract List<Object> getAllDept();
}
