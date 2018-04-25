package com.noriental.jspview.controller;

import com.noriental.velocity.service.InfoService;
import com.noriental.velocity.vo.Info;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

@Controller
public class JspViewController {

	@Resource
	InfoService infoService;

	/**
	 * 总入口：
	 * 返回ModelAndView
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/",method = RequestMethod.GET)
	public ModelAndView jspView(HttpServletRequest request, HttpServletResponse response, ModelMap model) {

		/*
		test.jsp
		 */
		return new ModelAndView("test");
	}



}