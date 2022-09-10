/*
 * Copyright 2022 Alibaba.com All right reserved. This software is the
 * confidential and proprietary information of Alibaba.com ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Alibaba.com.
 */

import java.util.HashMap;
import java.util.Map;

/**
 * 利用字符重复出现的次数编程实现一个字符串压缩算法,
 * 比如字符串“aaabccxxyzzzzz”经过上述压缩算法后会被压缩成“a3bc2x2yz5”,
 * 若用该算法压缩后的字符串跟原字符串相比长度没有变短,则返回原先的字符串。
 * 
 * 
 * 测试1 输入：s = "aac"   输出："a2c"
 * 测试2 输入：s = "aaabccxxyzzzzz"   输出："a3bc2x2yz5"
 * 测试3 输入：s = "aabbccddeeff"   输出："aabbccddeeff"
 */

public class CompressStr {
    static public String compress(String a) {
        String compressString = "";
        // 填写算法
        HashMap<String, Integer> map = new HashMap<>();

        for (int i=0; i<a.length(); i++)  {
            String tmp = String.valueOf(a.charAt(i));
            map.merge(tmp, 1, Integer::sum);
        }
        for (Map.Entry<String, Integer> entry: map.entrySet()) {
            if (entry.getValue() == 1) {
                compressString += entry.getKey();
            }else {
                compressString += entry.getKey() + entry.getValue();
            }
        }
        
        return compressString.length() == a.length() ? a: compressString;
    }

    public static void main(String[] args) {
        // 测试1 输入：s = "aac"   输出："a2c"
        System.out.println("测试1开始");
        String a = "aac";
        System.out.println("测试1结果, a:" + a + ",结果:" + compress(a));

        // 测试2 输入：s = "aaabccxxyzzzzz"   输出："a3bc2x2yz5"
        System.out.println("测试2开始");
        a = "aaabccxxyzzzzz";
        System.out.println("测试2结果, a:" + a + ",结果:" + compress(a));
        
        // 测试3 输入：s = "aabbccddeeff"   输出："aabbccddeeff"
        System.out.println("测试2开始");
        a = "aabbccddeeff";
        System.out.println("测试2结果, a:" + a + ",结果:" + compress(a));
    }
}
