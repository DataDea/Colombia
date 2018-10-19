package com.springcloudstudy.zuulserver.common;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.Random;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 * @author yanghai
 */
public class CommonUtils {

    private static Random random = new Random();

    /**
     * 根据时间戳生成一个唯一整数ID
     */
    public static long createId() {
        return Long.parseLong(String.format("%d%03d", System.currentTimeMillis() % 1000000000000L,
                Thread.currentThread().getId()));
    }

    /**
     * 校验字符串是否是数字
     */
    public static boolean isNotNumber(String string) {
        if (string == null){
            return false;
        }
        Pattern pattern = Pattern.compile("^-?\\d+(\\.\\d+)?$");
        return !pattern.matcher(string).matches();
    }

    /**
     * 生成一个纯字符串的UUID
     */
    public static String createUuid() {
        return UUID.randomUUID().toString().replace("-", "");
    }

    /**
     * 检测手机号是否合法
     */
    public static boolean checkValidPhone(String phone) {
        String regPhone = "^\\d{5,11}$";
        Pattern p = Pattern.compile(regPhone);
        Matcher m = p.matcher(phone);
        return m.matches();
    }

    /**
     * 检测邮箱是否合法
     */
    public static boolean checkValidEmail(String email) {
        String regEmail = "^\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*$";
        Pattern p = Pattern.compile(regEmail);
        Matcher m = p.matcher(email);
        return m.matches();
    }

    /**
     * 生成一个指定长度的字符串
     */
    public static String genRandomString(int length) {
        String base = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYAC0123456789";
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            sb.append(base.charAt(random.nextInt(base.length())));
        }
        return sb.toString();
    }

    /**
     * 对字符串做MD5加密
     */
    public static String getMD5(String str) {
        try {
            // 生成一个MD5加密计算摘要
            MessageDigest md = MessageDigest.getInstance("MD5");
            // 计算md5函数
            md.update(str.getBytes());
            // digest()最后确定返回md5 hash值，返回值为8为字符串。因为md5 hash值是16位的hex值，实际上就是8位的字符
            // BigInteger函数则将8位的字符串转换成16位hex值，用字符串来表示；得到字符串形式的hash值
            return new BigInteger(1, md.digest()).toString(32);
        } catch (Exception e) {
            return null;
        }
    }

}
