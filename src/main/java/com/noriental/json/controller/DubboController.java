package com.noriental.json.controller;



import com.noriental.json.service.DboService;
import com.noriental.validate.util.ValidateUtil;
import com.noriental.xxsvr.bean.Course;
import com.noriental.xxsvr.bean.GetDataRequest;
import com.noriental.xxsvr.bean.GetDataRsp;
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
public class DubboController {
	/**
	 * logger
	 */
	private static Logger logger = LoggerFactory.getLogger(DubboController.class);


	@Resource
	DboService dboService;

	/**
	 * dubbo test
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/sayHello",method = RequestMethod.GET)
	@ResponseBody
	public Object sayHello(HttpServletRequest request, HttpServletResponse response, ModelMap model) {
		//入参输出日志
		logger.info("===need add req_parmeters ===");

		String str = " duboo!!";

		str = dboService.sayHello(str);

		model.addAttribute("info",str);

		return model;
	}
	/**
	 * dubbo test
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/getData",method = RequestMethod.GET)
	@ResponseBody
	public Object dubboTest( ModelMap model) {
		//入参输出日志
		logger.info("===need add req_parmeters ===");

		//构造参数
		GetDataRequest request = new GetDataRequest();
		request.setName("cccc");
		request.setiFlag(0);

		//请求dubbo服务
		GetDataRsp getDataRsp = new GetDataRsp();
		try{
			getDataRsp = dboService.getServiceData(request);
			logger.info("Get data from dubbo success!");
		}catch (Exception e){
			logger.error("Get getDataRsp from dubbo error! {}",e);
		}

		//返回对象校验
		if(!getDataRsp.success()) {
			logger.info("GetDataRsp value= {}", getDataRsp);
			return getDataRsp;
		}else{
			try{
				ValidateUtil.validate(getDataRsp);
			}catch (Exception e){
				Course course = getDataRsp.getCourse();
				logger.error("validate error! {}",course);
				logger.info("error="+course);
			}
			return getDataRsp;
		}

	}

}