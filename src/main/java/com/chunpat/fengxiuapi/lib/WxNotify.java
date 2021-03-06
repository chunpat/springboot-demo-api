package com.chunpat.fengxiuapi.lib;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class WxNotify {
    public static String fail(){
        return "false";
    }

    public static String success(){
        return "<xml><return_code><![CDATA[SUCCESS]]></return_code><return_msg><![CDATA[OK]]></return_msg></xml>";
    }

    public static String readNotify(InputStream stream){
        BufferedReader reader = new BufferedReader(new InputStreamReader(stream));
        StringBuilder builder = new StringBuilder();

        String line;
        try {
            while (((line = reader.readLine()) != null)) {
                    builder.append(line + "\n");
            };
        } catch (IOException e) {
            e.printStackTrace();
        }
        return builder.toString();//return xml
    }
}
