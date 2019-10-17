# springboot-spark
使用springboot构建rest api远程提交spark任务，博客地址：https://blog.csdn.net/hlp4207/article/details/100831384

**使用方法：**
1. 前台调用Restful接口，传入spark任务所需参数
2. 后台接收到参数，使用SparkLauncher构建远程提交spark任务对象
```
SparkLauncher launcher = new SparkLauncher()
				.setAppResource(sparkAppParams.getJarPath())
				.setMainClass(sparkAppParams.getMainClass())
				.setMaster(sparkAppParams.getMaster())
				.setDeployMode(sparkAppParams.getDeployMode())
				.setConf("spark.driver.memory", sparkAppParams.getDriverMemory())
				.setConf("spark.executor.memory", sparkAppParams.getExecutorMemory())
				.setConf("spark.executor.cores", sparkAppParams.getExecutorCores());
```
3. 使用CountDownLatch阻塞线程，当任务结束后，调用spark api获取执行结果
