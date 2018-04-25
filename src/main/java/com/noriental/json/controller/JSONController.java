package com.noriental.json.controller;


import com.noriental.velocity.service.InfoService;
import com.noriental.velocity.vo.Info;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class JSONController {
	/**
	 * logger
	 */
	private static Logger logger = LoggerFactory.getLogger(JSONController.class);


	@Resource
	InfoService infoService;


	/**
	 * 返回json
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/json",method = RequestMethod.GET)
	@ResponseBody
	public Object json(HttpServletRequest request, HttpServletResponse response, ModelMap model) {
		//入参输出日志
		logger.info("===need add req_parmeters ===");

		Info info = infoService.getInfo();

		model.addAttribute("info",info);

		return model;
	}


}