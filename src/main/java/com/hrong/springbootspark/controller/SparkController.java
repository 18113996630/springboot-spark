package com.hrong.springbootspark.controller;

import com.hrong.springbootspark.service.ISparkSubmitService;
import com.hrong.springbootspark.vo.DataBaseExtractorVo;
import com.hrong.springbootspark.vo.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.io.IOException;

/**
 * @Author hrong
 **/
@Slf4j
@Controller
public class SparkController {
	@Resource
	private ISparkSubmitService iSparkSubmitService;
	/**
	 * 调用service进行远程提交spark任务
	 * @param vo 页面参数
	 * @return 执行结果
	 */
	@ResponseBody
	@PostMapping("/extract/database")
	public Object dbExtractAndLoad2Hdfs(@RequestBody DataBaseExtractorVo vo){
		try {
			return iSparkSubmitService.submitApplication(vo.getSparkApplicationParam(),
					vo.getUrl(),
					vo.getTable(),
					vo.getUserName(),
					vo.getPassword(),
					vo.getTargetFileType(),
					vo.getTargetFilePath());
		} catch (IOException | InterruptedException e) {
			e.printStackTrace();
			log.error("执行出错：{}", e.getMessage());
			return Result.err(500, e.getMessage());
		}
	}
}
