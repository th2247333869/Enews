package com.news.demo;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class PyApplication {

    public static void main(String[] args) throws  Exception {

        String[] arguments = new String[] {"python", "D:\\test.py", "huzhiwei", "25"};
        try {
            Process process = Runtime.getRuntime().exec(arguments);
            BufferedReader in = new BufferedReader(new InputStreamReader(process.getInputStream(),"UTF-8"));
            String line = null;
            while ((line = in.readLine()) != null) {
                System.out.println(line);
            }
            in.close();
            int re = process.waitFor();
            System.out.println(re);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}

