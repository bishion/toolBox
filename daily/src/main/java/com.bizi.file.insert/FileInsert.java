package com.bizi.file.insert;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

/**
 * 描述：
 * Created by GuoFangBi on 16-4-6.
 */
public class FileInsert {
    public static void insertStrToFile(String data,String fileName){
        try {
            List<String> file = Files.readAllLines(Paths.get(fileName));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
