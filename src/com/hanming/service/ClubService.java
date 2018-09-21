package com.hanming.service;

import java.util.List;

import com.hanming.po.PageInfo;

public interface ClubService {
	
	public abstract List<Object> getAllClub();
	public abstract List<Object> getClubWithType(int type);
	
	public abstract String clubinfo(String cid);
	
	public abstract List<Object> getAllType();
	public abstract String getType(int type);
	
	public abstract PageInfo queryByPage(PageInfo pageInfo);
	
	public abstract int queryTotal(String info);

}
