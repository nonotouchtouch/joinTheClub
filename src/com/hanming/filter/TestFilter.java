package com.hanming.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebFilter("/html/*")
public class TestFilter implements Filter {
    public TestFilter() {      
    }
	public void destroy() {	
	}
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// place your code here
		request.setCharacterEncoding("utf-8");
		System.out.print("filter ");

		 HttpSession session=((HttpServletRequest)request).getSession();
		 if(session.getAttribute("stu") == null) {
				((HttpServletResponse) response).sendRedirect("/joinTheClub/login.html");
				System.out.println("deny");
		 }
		 else {
			System.out.println("approve");
	     	chain.doFilter(request, response);
		 }
	}


	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
