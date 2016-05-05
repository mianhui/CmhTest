package com.zhaogang.demo.formbean;

import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * 修改表单Bean
 * 
 * @author 陈绵慧
 * @since 2015年11月17日
 * @version 1.0
 */
public class ChangeFormbean {

	/**
	 * 测试ID
	 */
	private String testId;

	/**
	 * 测试姓名
	 */
	private String testName;

	/**
	 * 测试年龄
	 */
	private Integer testAge;

	/**
	 * 测试生日
	 */
	private String testBrithday;

	public ChangeFormbean() {
		super();
	}

	public String getTestId() {
		return testId;
	}

	public void setTestId(String testId) {
		this.testId = testId;
	}

	public String getTestName() {
		return testName;
	}

	public void setTestName(String testName) {
		this.testName = testName;
	}

	public Integer getTestAge() {
		return testAge;
	}

	public void setTestAge(Integer testAge) {
		this.testAge = testAge;
	}

	public String getTestBrithday() {
		return testBrithday;
	}

	public void setTestBrithday(String testBrithday) {
		this.testBrithday = testBrithday;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}

}
