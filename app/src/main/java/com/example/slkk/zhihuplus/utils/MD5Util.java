package com.example.slkk.zhihuplus.utils;

import java.io.File;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by slkk on 2016/5/26.
 */
public class MD5Util {

    public static String digest(String url) {
        StringBuilder builder = new StringBuilder();
        try {
            MessageDigest msgDitest = MessageDigest.getInstance("MD5");
            msgDitest.update(url.getBytes());
            byte[] digests = msgDitest.digest();
            for(int i = 0;i<digests.length;i++) {
                builder.append(Integer.toHexString(digests[i] & 0xff));
            }
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return builder.toString();
    }
}
