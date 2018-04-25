package com.noriental.velocity.controller;

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
@RequestMapping("/vm")
public class VMController {

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
	public ModelAndView intface(HttpServletRequest request, HttpServletResponse response, ModelMap model) {

		//tips
		String tips = "Welcome.输入以下三个请求，查看返回结果：";

		//List
		List<String> list = new ArrayList<String>();

		String str = "<a href=\"http://localhost:8888/vm/home#\">请点url#</a>";

		for(int i=1;i<=3;i++){
			str = str.replaceAll("#", "" + i);
			list.add(str+i);
			str = str.replaceAll(""+i,"#");
		}

		model.addAttribute("tips",tips);
		model.addAttribute("list",list);
		/*
		home：为site目录下的视图名home.vm
		str：为vm模版接收的参数名
		 */
		return new ModelAndView("hello");
	}

	/**
	 * 返回ModelAndView
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/home1",method = RequestMethod.GET)
	public ModelAndView printWelcome(HttpServletRequest request, HttpServletResponse response, ModelMap model) {

		String str = "hello";

		model.addAttribute("message", "Welcome hello world!");

		/*
		home：为site目录下的视图名home.vm
		str：为vm模版接收的参数名
		 */
		return new ModelAndView("site/home", "str", str);
	}

	/**
	 * 返回ModelAndView
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/home2",method = RequestMethod.GET)
	public ModelAndView printWelcome1(HttpServletRequest request, HttpServletResponse response, ModelMap model) {

		ModelAndView modelAndView = new ModelAndView();

		String str = "中文乱码测试";
		//modelAndView携带返回值
		modelAndView.addObject("str",str);
		//model携带返回值
		model.addAttribute("message", "Welcome hello world!");
		/*
		site/home：为site目录下的视图名home.vm
		str：为vm模版接收的参数名
		 */
		//此处指定vm文件所在路径
		modelAndView.setViewName("site/home");

		return modelAndView;
	}


	/**
	 *返回String path 中文
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/home3",method = RequestMethod.GET)
	public String printWelcome2(HttpServletRequest request, HttpServletResponse response, ModelMap model) {

		String str = "中文乱码测试";
		String url = "<a href=\"http://localhost:8888/vm/example\">请访问</a>";
		model.addAttribute("str",str);
		model.addAttribute("url",url);
		model.addAttribute("message", "Hello world!");

		//此处指定vm文件所在路径
		return "site/home";
	}


	/**
	 *返回对象Bean
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/example",method = RequestMethod.GET)
	public String printBean(HttpServletRequest request, HttpServletResponse response, ModelMap model) {

		Info info = infoService.getInfo();

		model.addAttribute("info", info);
		model.addAttribute("req_art", "req_art_parmeter");

		request.setAttribute("req_art","req_art_parmeter");

		//此处指定vm文件所在路径
		return "site/example";
	}



}