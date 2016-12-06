package com.bizi.tools.files;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class FileUtil {

	public static File[] getFiles(String path){
		File root = new File(path);
		if(root.isFile()){
			return null;
		}else{
			return root.listFiles();
		}
	}
	
	public static void readFile(File file) throws Exception{
		InputStreamReader read = new InputStreamReader(new FileInputStream(file),"gbk");     
		BufferedReader br=new BufferedReader(read);     
		String data = br.readLine();//一次读入一行，直到读入null为文件结束
		while( data!=null){
		      System.out.println(data);
		      data = br.readLine(); //接着读下一行
		}
		br.close();
	}
}
