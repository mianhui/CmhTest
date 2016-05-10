package com.zhaogang.demo.model;

import java.util.Date;

import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * 测试实体
 * 
 * @author 陈绵慧
 * @since 2016年05月10日
 * @version 1.0
 * cmhV1.0.2
 */
public class Test {

	/**
	 * 测试ID
	 */
	private String testId;

	/**
	 * 测试名称
	 */
	private String testName;

	/**
	 * 测试年龄
	 */
	private Integer testAge;

	/**
	 * 测试生日
	 */
	private Date testBrithday;

	/**
	 * 创建时间
	 */
	private Date createTime;

	/**
	 * 最后更新时间
	 */
	private Date lastModifyTime;

	public Test() {
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

	public Date getTestBrithday() {
		return testBrithday;
	}

	public void setTestBrithday(Date testBrithday) {
		this.testBrithday = testBrithday;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getLastModifyTime() {
		return lastModifyTime;
	}

	public void setLastModifyTime(Date lastModifyTime) {
		this.lastModifyTime = lastModifyTime;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}

}
