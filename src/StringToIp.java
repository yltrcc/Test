/*
 * Copyright 2022 Alibaba.com All right reserved. This software is the
 * confidential and proprietary information of Alibaba.com ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Alibaba.com.
 */

import java.util.ArrayList;
import java.util.List;

/**
      给定一个只包含数字的字符串，复原它并返回所有可能的 IP 地址格式。
      字符串长度小于1000大于0
      如果无法复原出有效的IP地址，则输出一个空集合
    例如： 
    输入：s = "25525511135"
    输出：["255.255.11.135","255.255.111.35"]


    测试：
    输入：s = "0000"
    输出：["0.0.0.0"]

    输入：s = "55555"
    输出：["55.5.5.5", "5.55.5.5", "5.5.55.5", "5.5.5.55"]

    输入：s = "101023"
    输出：["1.0.10.23","1.0.102.3","10.1.0.23","10.10.2.3","101.0.2.3"]

    输入：s = "99999999999"
    输出：[]
 */
public class StringToIp {

    static Integer[] seg = new Integer[4];
    static List<String> ipList = new ArrayList<>();
    static public List<String> toIp(String a) {

        // 填写
        find(a, 0, 0);

        return ipList;
    }

    static public void find(String s, int count, int index) {

        //标记结束
        if (count == 4 ) {
            //判断是否是正确结果
            if (index == s.length()) {
                StringBuilder ip = new StringBuilder();
                for (int i=0; i<4; i++) {
                    ip.append(seg[i]);
                    if (i != 3) {
                        ip.append(".");
                    }
                }
                ipList.add(ip.toString());
            }
            return;
        }
        if (count<4 && index == s.length()) {
            return;
        }

        //开始遍历结果,可能值
        int tmp = 0;
        for (int i = index; i<s.length(); i++) {
            //最多三位
            tmp = tmp * 10 + (s.charAt(i) - '0');
            if (tmp >=0 && tmp <= 255) {
                seg[count] = tmp;
                find(s, count + 1, i+1);
            }else {
                return;
            }
        }

    }


    public static void main(String[] args) {
        // 测试1 输入：s = "0000"   输出：["0.0.0.0"]
        System.out.println("测试1开始");
        String a = "0000";
        System.out.println("测试1结果, a:" + a + ",结果:" + toIp(a).toString());
        ipList = new ArrayList<>();
        // 测试2 输入：s = "55555"  输出：["55.5.5.5", "5.55.5.5", "5.5.55.5", "5.5.5.55"]
        System.out.println("测试2开始");
        a = "55555";
        System.out.println("测试2结果, a:" + a + ",结果:" + toIp(a).toString());
        ipList = new ArrayList<>();
        // 测试3 输入：s = "101023" 输出：["1.0.10.23","1.0.102.3","10.1.0.23","10.10.2.3","101.0.2.3"]
        System.out.println("测试3开始");
        a = "101023";
        System.out.println("测试3结果, a:" + a + ",结果:" + toIp(a).toString());
        ipList = new ArrayList<>();
        // 测试4 输入：s = "99999999999" 输出：[]
        System.out.println("测试4开始");
        a = "99999999999";
        System.out.println("测试4结果, a:" + a + ",结果:" + toIp(a).toString());
    }
}
