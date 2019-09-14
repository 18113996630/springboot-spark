package com.hrong.springbootspark.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.List;

/**
 * @Author hrong
 **/
public class HttpUtil {
	public static String httpGet(String urlStr, List<String> urlParam) throws IOException, InterruptedException {
		// 实例一个URL资源
		URL url = new URL(urlStr);
		HttpURLConnection connection = null;
		int i = 0;
		while (connection == null || connection.getResponseCode() != 200) {
			connection = (HttpURLConnection) url.openConnection();
			connection.setRequestMethod("GET");
			connection.setRequestProperty("Charset", "UTF-8");
			connection.setRequestProperty("Content-Type", "application/json");
			// 连接超时 单位毫秒
			connection.setConnectTimeout(15000);
			// 读取超时 单位毫秒
			connection.setReadTimeout(15000);
			i++;
			if (i == 50) {
				break;
			}
			Thread.sleep(500);
		}
		//将返回的值存入到String中
		BufferedReader brd = new BufferedReader(new InputStreamReader(connection.getInputStream(), StandardCharsets.UTF_8));
		StringBuilder sb = new StringBuilder();
		String line;
		while ((line = brd.readLine()) != null) {
			sb.append(line);
		}
		brd.close();
		connection.disconnect();
		return sb.toString();
	}
}
