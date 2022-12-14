package org.example.utils.Impl;

import org.example.model.Books;
import org.example.utils.BookUtils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BookUtilsImpl implements BookUtils {
    private final String PATH = "src/main/resources/Books - Sheet1.csv";
    public List<Books> readBookFile(){
        List<Books> bookList = new ArrayList<>();
        String line="";
        try(BufferedReader br = new BufferedReader(new FileReader(PATH))) {
            br.readLine();
            while ((line= br.readLine()) !=null) {
                String[] column = line.split(",");
                bookList.add(new Books(column[0], column[1], column[2], Integer.parseInt(column[3])));
            }
        }catch(IOException e){
            e.printStackTrace();
        }
        return bookList;
    }

    public List<String> readHeader() {
        List<String> header = new ArrayList<>();
        try(BufferedReader bufferedReader = new BufferedReader(new FileReader(PATH))) {
            String[] col = bufferedReader.readLine().split(",");
            header.addAll(Arrays.asList(col[0], col[1], col[2], col[3]));
        }catch(IOException e){
            e.printStackTrace();
        }
        return header;
    }




}
