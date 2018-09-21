package com.hanming.serviceImpl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.hanming.mapper.ServiceMapper;
import com.hanming.po.PageInfo;
import com.hanming.service.ClubService;
@Service
public class ClubServiceImpl implements ClubService {
	

	@Resource
	private ServiceMapper serviceMapper;
	

	@Override
	public List<Object> getAllClub() {
		return serviceMapper.getAllClub();
	}


	@Override
	public String clubinfo(String cid) {
		// TODO Auto-generated method stub
		return serviceMapper.clubinfo(cid);
	}


	@Override
	public List<Object> getAllType() {
		// TODO Auto-generated method stub
		return serviceMapper.getType();
	}
	
	@Override
	public PageInfo queryByPage(PageInfo pageInfo) {
		//记录总数
		if (pageInfo.getTotal() == null || pageInfo.getTotal() == 0) {
			pageInfo.setTotal(serviceMapper.queryTotal(pageInfo.getInfo()));
		}
		
		//每页显示个数
		
		if (pageInfo.getCount() == null) {
			pageInfo.setCount(2);
		
		}
		
		if (pageInfo.getPage() == null || pageInfo.getPage() < 1) {
			pageInfo.setPage(1);
		}
		
		if (pageInfo.getPage() > pageInfo.getTotal() / pageInfo.getCount()+0.5) {
			pageInfo.setPage(pageInfo.getTotal() / pageInfo.getCount()+1);
		}
		
		pageInfo.setRows(serviceMapper.queryAll(pageInfo.getInfo(),(pageInfo.getPage()-1)*pageInfo.getCount(),pageInfo.getCount()));

		return pageInfo;
	}


	@Override
	public int queryTotal(String info) {
		// TODO Auto-generated method stub
		return serviceMapper.queryTotal(info);
	}


	@Override
	public String getType(int type) {
		// TODO Auto-generated method stub
		String t;		
		if((t=serviceMapper.getOneType(type))!=null)
			return t;
		return "其他";
	}


	@Override
	public List<Object> getClubWithType(int type) {
		// TODO Auto-generated method stub
		return serviceMapper.getClubWithType(type);
	}

}
