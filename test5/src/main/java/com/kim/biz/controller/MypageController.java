package com.kim.biz.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.kim.biz.member.MemberVO;
import com.kim.biz.member.impl.MemberDAO;

public class MypageController implements Controller{

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		MemberVO mVO=new MemberVO();
		MemberDAO mDAO=new MemberDAO();
		mVO.setMid(request.getParameter("mid"));
		
		mVO=mDAO.selectOneMember(mVO);
		
		ModelAndView mav=new ModelAndView();
		mav.addObject("member", mVO);
		mav.setViewName("mypage.jsp");
		
		return mav;
	}

}
