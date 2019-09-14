package com.hrong.job.etl;

import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SparkSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Author hrong
 * @Description 将数据库中的表数据保存到hdfs上
 **/
public class DbTableEtl {
	private static Logger log = LoggerFactory.getLogger(DbTableEtl.class);

	public static void main(String[] args) {
		SparkSession spark = SparkSession.builder()
				.appName(DbTableEtl.class.getSimpleName())
				.getOrCreate();
		String url = args[0];
		String dbtable = args[1];
		String user = args[2];
		String password = args[3];
		String targetFileType = args[4];
		String targetFilePath = args[5];
		Dataset<Row> dbData = spark.read()
				.format("jdbc")
				.option("url", url)
				.option("dbtable", dbtable)
				.option("user", user)
				.option("password", password)
				.load();
		log.info("展示部分样例数据，即将开始导入到hdfs");
		dbData.show(20, false);
		dbData.write().mode("overwrite").format(targetFileType).save(targetFilePath);
	}
}
