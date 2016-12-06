package com.bizi.study.files;

import com.bizi.sdk.tools.JsonMapper;

import java.io.*;
import java.util.*;

/**
 * 描述：
 * Created by GuoFangBi on 16-2-1.
 */
public class FileTool {
    public static void readFile() throws IOException {
        File file = new File("/home/guo/Desktop/test.csv");
        BufferedReader reader = new BufferedReader(new FileReader(file));
        String line ;

        Set<String> set = new HashSet<>();
        while((line = reader.readLine())!=null){
            String[] lineList = line.split(",");
            System.err.println(lineList[0]+";\t\t\t"+lineList.length+"\t"+lineList[lineList.length-1]);
        }
        System.err.println(JsonMapper.toNonNullJson(set));
    }

    public static void main(String[] args) {
        try {
            readFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
