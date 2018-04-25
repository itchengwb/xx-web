package com.noriental.propertises.controller;


import com.noriental.propertises.service.ProService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class PropertiesController {
	/**
	 * logger
	 */
	private static Logger logger = LoggerFactory.getLogger(PropertiesController.class);

	@Autowired
	ProService proService;


	/**
	 * 统一配置文件测试
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/pro",method = {RequestMethod.GET,RequestMethod.POST})
	@ResponseBody
	public Object pro(HttpServletRequest request, HttpServletResponse response, ModelMap model) {
		//入参输出日志
		logger.info("===need add req_parmeters ===");

		proService.pro();

		logger.info("login  test;{}","success");

		return new String("success");
	}




}