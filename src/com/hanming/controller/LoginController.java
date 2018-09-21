package com.hanming.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hanming.po.Student;
import com.hanming.service.StudentService;
import com.hanming.util.IDPool;

import org.springframework.stereotype.Controller;

@Controller
public class LoginController {

	@Resource
	private StudentService studentService;

	@RequestMapping("/login/{id}/{pwd}")
	@ResponseBody
	public Boolean login(HttpSession session,@PathVariable String id,@PathVariable String pwd) {
		Student student=new Student();
		student.setsId(id);
		student.setsPwd(pwd);
		student = studentService.login(student);
	
		if (student != null) {
			System.out.println(student.getsId()+"登陆");
			session.setAttribute("stu", student);
			IDPool.sessionMaps.put(student.getsId(), session);
			return true;//"html/welcome.html";
		}
		return false;//"html/fail.html";
	}

	@RequestMapping("/logout")
	@ResponseBody
	public Boolean logout(HttpSession session,HttpServletRequest request) {
		Student student = (Student) session.getAttribute("stu");
		HttpSession session2 = (HttpSession) IDPool.sessionMaps.get(student.getsId());
		System.out.println(student.getsId()+"登出");
		session2.invalidate();
		request.getSession().invalidate();
		return true;
	}





	@RequestMapping(value = "/test4.do", method = RequestMethod.GET)
	@ResponseBody
	public List<Object> test4() {

		return studentService.getAllStudent();
	}



	@RequestMapping("/test5.do")
	@ResponseBody
	public Integer reg5(@RequestParam(defaultValue = "88", value = "sno", required = true) Integer id) {

		return id;
	}

	@RequestMapping("/test6.do")
	public String reg6(HttpServletRequest request) {
		request.setAttribute("name", "njupt");
		return "forward:test7.do";
	}

	@RequestMapping("/{idd}/test7.do")
	@ResponseBody
	public String reg7(@PathVariable("idd") String id) {
		System.out.println(id);
		return id;
	}
}
