package com.sxp.common;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

/**
 * 资源文件工具类
 *
 * @author Shawpin Shi
 * @since 2018/6/7
 */
public class ResourceUtils {
	private static final Logger logger = LoggerFactory.getLogger(ResourceUtils.class);
	private static final String NEW_LINE = "\n";

	/**
	 * 读取资源文件的内容至一个列表
	 *
	 * @author Shawpin Shi
	 * @since 2018/6/7
	 */
	public static String readContent(String resourcePath, Charset charset) {
		StringBuilder sb = new StringBuilder();

		try (
				InputStream in = ResourceUtils.class.getClassLoader().getResourceAsStream(resourcePath);
				Reader reader = new InputStreamReader(in, charset);
				BufferedReader bf = new BufferedReader(reader);
		) {
			String line;
			while ((line = bf.readLine()) != null) {
				sb.append(line);
				sb.append(NEW_LINE);
			}
		} catch (NullPointerException e) {
			logger.error("资源文件[" + resourcePath + "]不存在，请确认", e);
			throw e;
		} catch (IOException e) {
			logger.error(e.getMessage(), e);
		}

		return sb.toString();
	}

	/**
	 * 读取资源文件的内容至一个列表
	 *
	 * @author Shawpin Shi
	 * @since 2018/6/7
	 */
	public static List<String> readContent2List(String resourcePath, Charset charset) {
		List<String> result = new ArrayList<>();

		try (
				InputStream in = ResourceUtils.class.getClassLoader().getResourceAsStream(resourcePath);
				Reader reader = new InputStreamReader(in, charset);
				BufferedReader bf = new BufferedReader(reader);
		) {
			String line;
			while ((line = bf.readLine()) != null) {
				result.add(line);
			}
		} catch (NullPointerException e) {
			logger.error("资源文件[" + resourcePath + "]不存在，请确认", e);
			throw e;
		} catch (IOException e) {
			logger.error(e.getMessage(), e);
		}

		return result;
	}
}
