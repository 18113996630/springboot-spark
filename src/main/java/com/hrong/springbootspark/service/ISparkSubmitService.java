package com.hrong.springbootspark.service;

import com.hrong.springbootspark.entity.SparkApplicationParam;

import java.io.IOException;

/**
 * @Author hrong
 * @description spark任务提交service
 **/
public interface ISparkSubmitService {
	/**
	 * 提交spark任务入口
	 * @param sparkAppParams spark任务运行所需参数
	 * @param otherParams 单独的job所需参数
	 * @return 结果
	 * @throws IOException          io
	 * @throws InterruptedException 线程等待中断异常
	 */
	String submitApplication(SparkApplicationParam sparkAppParams, String... otherParams) throws IOException, InterruptedException;
}
