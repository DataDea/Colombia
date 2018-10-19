package com.springcloudstudy.zuulserver.common;

import java.security.MessageDigest;

/**
 *
 * @author yanghai
 * @date 14-12-12
 */
public class Signer {

    public static void checkSigner(long timestamp, long timeout, String nonce, String token, String signature) {
        String stringToSign = genSignString(timestamp, timeout, nonce, token);
        if (!genSignature(stringToSign).equals(signature)) {
            return;
        }
    }

    private static String genSignString(long timestamp, long timeout, String nonce, String token) {
        return String.valueOf(timeout) +
                String.valueOf(timestamp) +
                nonce +
                token;
    }

    private static String genSignature(String stringToSign) {
        String signature = "";
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            md.update(stringToSign.getBytes("UTF-8"));
            byte[] result = md.digest();

            StringBuilder sb = new StringBuilder();

            for (byte b : result) {
                int i = b & 0xff;
                if (i <= 0xf) {
                    sb.append(0);
                }
                sb.append(Integer.toHexString(i));
            }
            signature = sb.toString();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return signature;
    }

}
