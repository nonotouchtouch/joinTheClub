package com.hanming.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hanming.po.PageInfo;
import com.hanming.po.Student;
import com.hanming.service.StudentService;

@Controller
public class StudentContoller {

	@Resource
	private StudentService studentService;

	@RequestMapping("getDept")
	@ResponseBody
	public List<Object> getDept() {
		return studentService.getDept();

	}

	@RequestMapping("signup")
	@ResponseBody
	public boolean signup(Student student) {
		if (student.getsName() == "" || student.getsDate() == "" || student.getsDept() == 0 || student.getsPwd() == "")
			return false;
		return studentService.signup(student);

	}

	@RequestMapping("/getid.do")
	@ResponseBody
	public String getStuID() {
		return studentService.getMaxID();
	}

	@RequestMapping("changepwd")
	@ResponseBody
	public boolean changepwd(String oldpwd, String newpwd,HttpServletRequest request) {
		Student stu = (Student) request.getSession().getAttribute("stu");
		if (!stu.getsPwd().equals(oldpwd)) {
			System.out.println(stu.getsPwd()+"老密码错误"+oldpwd);
			return false;
		}
		stu.setsPwd(newpwd);
		System.out.println("更新");
		return studentService.changepwd(stu);

	}
	
	

	@RequestMapping("join")
	@ResponseBody
	public boolean join(String clubID, HttpServletRequest request) {
		System.out.println("申请加入社团");
		Student stu = (Student) request.getSession().getAttribute("stu");
		String sId=stu.getsId();
		
	    System.out.println(stu.getsId());
	    System.out.println(clubID);
	    
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date date = new Date();
		String b = sdf.format(date);
	
		return studentService.join(b,sId,clubID);

	}
	
	@RequestMapping("myapplication")
	@ResponseBody
	public List<Object> myapplication(HttpServletRequest request) {
		Student stu = (Student) request.getSession().getAttribute("stu");
		String sId=stu.getsId();		
	    System.out.println(stu.getsId());
		return studentService.myapplication(sId);

	}
	@RequestMapping("myapplication/{page}")
	@ResponseBody
	public PageInfo myApplication(HttpServletRequest request,@PathVariable Integer page) {
		System.out.println("我的申请");
		Student stu = (Student) request.getSession().getAttribute("stu");
		String sId=stu.getsId();	
		if(page<1)page=1;
		if(page>(studentService.getAppCount(sId)+1)/2)page=(studentService.getAppCount(sId)+1)/2;
		PageInfo pageInfo=new PageInfo();
		pageInfo.setTotal(studentService.getAppCount(sId));
		pageInfo.setCount(2);
		pageInfo.setPage(page);
		pageInfo.setInfo(sId);
		pageInfo.setRows(studentService.myApplication(pageInfo));
	
	    System.out.println(stu.getsId());
		return pageInfo;

	}
	
	
}
