package com.zhaogang.demo.dao;

import java.util.List;

import com.zhaogang.demo.model.Test;


/**
 * 测试Dao
 * 
 * @author 程凯
 * @since 2015年11月17日
 * @version 1.0
 */
public interface TestMapper {

    /**
     * 添加
     * 
     * @param test
     *            测试
     */
    public void add(Test test);

    /**
     * 根据测试Id删除
     * 
     * @param testId
     *            测试Id
     */
    public void delete(String testId);

    /**
     * 更新
     * 
     * @param test
     *            测试
     */
    public void update(Test test);

    /**
     * 获取列表
     * 
     * @return 测试列表
     */
    public List<Test> get();

    /**
     * 根据测试Id获取
     * 
     * @param testId
     *            测试Id
     * @return 测试
     */
    public Test getByTestId(String testId);

}
