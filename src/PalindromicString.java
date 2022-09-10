/*
 * Copyright 2022 Alibaba.com All right reserved. This software is the
 * confidential and proprietary information of Alibaba.com ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Alibaba.com.
 */

/**
 * “回文串”是一个正读和反读都一样的字符串，比如“level”或者“noon”等等就是回文串。
 * 
 * 实现算法判断字符串是不是回文串
 * 
 * 测试例1： 输入level  输出true
 * 测试例2： 输入12321  输出true
 * 测试例3： 输入hello  输出false
 */

public class PalindromicString {
    static public Boolean palindromic(String str) {
        Boolean result = true;
        // 填写算法
        StringBuilder sb = new StringBuilder();
        int n = str.length();
        for (int i=n-1; i>=0; i--) {
            sb.append(str.charAt(i));
        }
        return str.equals(sb.toString());
    }

    public static void main(String[] args) {
        // 测试例1： 输入level  输出true
        String str = "level";
        System.out.println("测试1 输入:" + str + ",结果:" + palindromic(str));
        
        // 测试例2： 输入12321  输出true
        str = "12321";
        System.out.println("测试1 输入:" + str + ",结果:" + palindromic(str));
        
        // 测试例3： 输入hello  输出false
        str = "hello";
        System.out.println("测试1 输入:" + str + ",结果:" + palindromic(str));
    }
}
