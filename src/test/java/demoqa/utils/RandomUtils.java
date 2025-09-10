package demoqa.utils;

import org.apache.commons.lang3.RandomStringUtils;


public class RandomUtils {

//    static String randomString(int len){
//        String AB = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
//        SecureRandom rnd = new SecureRandom();
//        StringBuilder sb = new StringBuilder(len);
//        for(int i=1; i<len; i++)
//            sb.append(AB.charAt(rnd.nextInt(AB.length())));
//        return sb.toString();
//    }

    public static String randomString(int len, boolean useLetters, boolean useNumbers){
        return RandomStringUtils.random(len, useLetters, useNumbers);
    }

    public static String randomEmail(int len){
        return randomString(len, true, true).toLowerCase()+"@mail.ru";
    }

    public static String randomPhone(){
        //return prefix + randomString(10, false, true);
        return randomString(10, false, true);
    }

}
