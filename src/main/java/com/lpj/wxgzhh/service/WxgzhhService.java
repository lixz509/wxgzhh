package com.lpj.wxgzhh.service;





import org.springframework.stereotype.Service;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

@Service
public class WxgzhhService {

    private static final String TOKEN="lpj";

    public static boolean chexk(String signature, String timestamp, String nonce) {
        String[] strs=new String[]{TOKEN,timestamp,nonce};
        Arrays.sort(strs);
        String str=strs[0]+strs[1]+strs[2];
        String mysig=sha1(str);
        return mysig.equalsIgnoreCase(signature);
    }

    private static String sha1(String src) {
        try {
            //获取一个加密对象
            MessageDigest md = MessageDigest.getInstance("sha1");
            //加密
            byte[] digest =md.digest(src.getBytes());
            char[] chars={'1','2','3','4','5','6','7','8','9','a','b','c','d','e','f'};
            StringBuilder sb=new StringBuilder();
            for (byte b:digest){
                sb.append(chars[(b>>4)&15]);
                sb.append(chars[b&15]);
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return null;
    }
}
