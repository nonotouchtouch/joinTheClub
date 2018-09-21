package com.hanming.controller;


import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hanming.po.PageInfo;
import com.hanming.service.ClubService;

@Controller
public class ClubController {
	
	@Resource
	private ClubService clubService;
	
	
	@RequestMapping("getAllClub")
	@ResponseBody
	public List<Object> getAllClub() {
		return clubService.getAllClub();
	}
	
	@RequestMapping("getClubWithType")
	@ResponseBody
	public List<Object> getClubWithType(int type) {
		return clubService.getClubWithType(type);
	}
	

	@RequestMapping(value="info" ,produces={"text/html;charset=UTF-8;","application/json;"})
	@ResponseBody
	public String info(String clubID) {
    	return clubService.clubinfo(clubID);
	}

	@RequestMapping(value="getalltype" ,produces={"text/html;charset=UTF-8;","application/json;"})
	@ResponseBody
	public List<Object> getType() {
    	return clubService.getAllType();
	}
	
	@RequestMapping(value="getonetype" ,produces={"text/html;charset=UTF-8;","application/json;"})
	@ResponseBody
	public String getType(int type) {
    	return clubService.getType(type);
	}
	
	
	
	@RequestMapping("show")
	@ResponseBody
	public PageInfo showMembers(int page,String info) {
		PageInfo pageInfo = new PageInfo();

		pageInfo.setPage(page);
		pageInfo.setInfo(info);//社团id
		pageInfo = clubService.queryByPage(pageInfo);
		System.out.println(pageInfo.getTotal());
		return pageInfo;
	}
	
	@RequestMapping("membersNum")
	@ResponseBody
	public int membersNum(String cid) {		
		return clubService.queryTotal(cid);
	}
	
}
