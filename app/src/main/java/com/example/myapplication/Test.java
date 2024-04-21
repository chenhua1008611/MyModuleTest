package com.example.myapplication;

import android.util.Base64;

import java.nio.charset.StandardCharsets;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class Test {

    public static byte[] base64ToDecode(String str) {
        byte[] byteStr = Base64.decode(str, Base64.DEFAULT);
        return byteStr;
    }

    public static String encode(byte[] key) {
        return Base64.encodeToString(key, Base64.DEFAULT);
    }

    /**
     * 加密
     *
     * @param content 需要加密的内容
     * @param key     加密密码
     * @return
     */
    public static String encrypt(String content, String key) {
        return encrypt(content,key.getBytes());
    }

    public static String encrypt(String content, byte[] key) {
        try {
            //构造密钥
            SecretKeySpec skey = new SecretKeySpec(key, "utf-8");
            //创建初始向量iv用于指定密钥偏移量(可自行指定但必须为128位)，因为AES是分组加密，下一组的iv就用上一组加密的密文来充当
            IvParameterSpec iv = new IvParameterSpec(key, 0, 16);
            //创建AES加密器
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            byte[] byteContent = content.getBytes(StandardCharsets.UTF_8);
            //使用加密器的加密模式
            cipher.init(Cipher.ENCRYPT_MODE, skey, iv);
            // 加密
            byte[] result = cipher.doFinal(byteContent);
            //使用BASE64对加密后的二进制数组进行编码
            return encode(result);
        } catch (Exception e) {
            e.printStackTrace();
            return content;
        }
    }

    /**
     * 解密
     * @param content
     * @param key
     * @return
     */
    public static String decrypt(String content,  byte[] key) {
        try {

            SecretKeySpec skey = new SecretKeySpec(key, "utf-8");
            IvParameterSpec iv = new IvParameterSpec(key, 0, 16);
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            //解密时使用加密器的解密模式
            // 初始化
            cipher.init(Cipher.DECRYPT_MODE, skey, iv);
            byte[] result = cipher.doFinal(base64ToDecode(content));
            // 解密
            return new String(result);
        } catch (Exception e) {
            return content;
        }
    }

}
