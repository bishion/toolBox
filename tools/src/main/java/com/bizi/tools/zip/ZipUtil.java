package com.bizi.tools.zip;

import org.apache.tools.zip.ZipEntry;
import org.apache.tools.zip.ZipFile;

import java.io.*;
import java.util.Enumeration;
import java.util.zip.ZipInputStream;

/**
 * desc：
 * aithor：guofangbi
 * date:2015/4/17
 */
public class ZipUtil {

	public static void main(String[] args) {
		try {

			ZipFile zipFile = new ZipFile("D:/中国人.zip");
			InputStream in = new BufferedInputStream(new FileInputStream("D:/中国人.zip"));
			ZipInputStream zin = new ZipInputStream(in);

			Enumeration<ZipEntry> enu = (Enumeration<ZipEntry>) zipFile.getEntries();
			while (enu.hasMoreElements()) {
				ZipEntry zipElement = enu.nextElement();
				if (!zipElement.isDirectory()) {//是否为文件 （文件带有路径如：/images/a.jpg）
					BufferedReader sBuffer = new BufferedReader(new InputStreamReader(zipFile.getInputStream(zipElement)));
					System.out.println("文件名字为"+zipElement.getName());
					InputStream is = zipFile.getInputStream(zipElement);
					int tempchar ;
					while ((tempchar = is.read()) != -1){
						if (((char) tempchar) != '\r') {
							System.out.print((char)tempchar);
						}
					}
					System.out.println();
				}else{
					System.out.println("文件夹名字为："+zipElement.getName());
				}

			}
			}catch(IOException e){
				e.printStackTrace();
			}
		}

	}
