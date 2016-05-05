package com.zhaogang.demo.controller;

import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zhaogang.demo.dao.TestMapper;
import com.zhaogang.demo.formbean.ChangeFormbean;
import com.zhaogang.demo.formbean.RegisterFormbean;
import com.zhaogang.demo.model.Test;

/**
 * 测试Controller
 * 
 * @author 程凯
 * @since 2015年11月17日
 * @version 1.0
 */
@Controller
public class TestController {

	private Logger logger = LoggerFactory.getLogger(TestController.class);

	@Autowired
	private TestMapper testMapper;

	/**
	 * 注册
	 */
	@RequestMapping("/register")
	@ResponseBody
	public String register(RegisterFormbean registerFormbean) throws Exception {
		logger.info("开始注册[registerFormbean=" + registerFormbean + "]");

		// 验证参数合法性
		if (StringUtils.isBlank(registerFormbean.getTestId())) {
			throw new RuntimeException("注册时测试ID为空");
		}
		if (StringUtils.isBlank(registerFormbean.getTestName())) {
			throw new RuntimeException("注册时测试姓名为空");
		}
		if (registerFormbean.getTestAge() == null) {
			throw new RuntimeException("注册时测试年龄为空");
		}
		if (StringUtils.isBlank(registerFormbean.getTestBrithday())) {
			throw new RuntimeException("注册时测试生日为空");
		}

		// 添加
		Test test = buildTest(registerFormbean);
		SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
		test.setTestBrithday(dateFormat.parse(registerFormbean.getTestBrithday()));
		testMapper.add(test);

		logger.info("结束注册");

		return "SUCCESS";
	}

	/**
	 * 删除
	 */
	@RequestMapping("/delete")
	@ResponseBody
	public String delete(HttpServletRequest request, HttpServletResponse response) {
		String testId = request.getParameter("testId");
		logger.info("开始删除[testId=" + testId + "]");

		// 验证参数合法性
		if (StringUtils.isBlank(testId)) {
			throw new RuntimeException("删除时测试ID为空");
		}

		// 删除
		testMapper.delete(testId);

		logger.info("删除结束");

		return "SUCCESS";
	}

	/**
	 * 修改
	 */
	@RequestMapping("/change")
	@ResponseBody
	public String change(HttpServletResponse response, ChangeFormbean changeFormbean) throws Exception {
		logger.info("开始修改[changeFormbean=" + changeFormbean + "]");

		// 验证参数合法性
		if (StringUtils.isBlank(changeFormbean.getTestId())) {
			throw new RuntimeException("注册时测试ID为空");
		}
		if (StringUtils.isBlank(changeFormbean.getTestName())) {
			throw new RuntimeException("注册时测试姓名为空");
		}
		if (changeFormbean.getTestAge() == null) {
			throw new RuntimeException("注册时测试年龄为空");
		}
		if (StringUtils.isBlank(changeFormbean.getTestBrithday())) {
			throw new RuntimeException("注册时测试生日为空");
		}

		// 修改
		Test test = buildTest(changeFormbean);
		SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
		test.setTestBrithday(dateFormat.parse(changeFormbean.getTestBrithday()));
		testMapper.update(test);

		logger.info("修改结束");

		return "SUCCESS";
	}

	/**
	 * 查询所有
	 */
	@RequestMapping("/queryAll")
	@ResponseBody
	public List<Test> queryAll() {
		logger.info("开始查询所有");
		List<Test> testList = testMapper.get();
		logger.info("查询所有结束[testList=" + testList + "]");
		return testList;
	}

	/**
	 * 根据测试ID查询
	 */
	@RequestMapping("/queryByTestId")
	@ResponseBody
	public Test queryByTestId(HttpServletRequest request) {
		String testId = request.getParameter("testId");
		logger.info("开始根据测试ID查询[testId=" + testId + "]");

		// 验证参数合法性
		if (StringUtils.isBlank(testId)) {
			throw new RuntimeException("根据测试ID查询时测试ID为空");
		}

		// 查询
		Test test = testMapper.getByTestId(testId);

		logger.info("根据测试ID查询结束[test=" + test + "]");

		return test;
	}

	/**
	 * 构建测试对象
	 */
	private <T> Test buildTest(T frombean) {
		Test test = new Test();
		String[] ignoreProperties = new String[] { "testBrithday" };
		BeanUtils.copyProperties(frombean, test, ignoreProperties);
		return test;
	}

}
