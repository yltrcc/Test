/*
 * Copyright 2022 Alibaba.com All right reserved. This software is the
 * confidential and proprietary information of Alibaba.com ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Alibaba.com.
 */

/**
 * 斐波那契数列指的是这样一个数列：1、1、2、3、5、8、13、21、34、……
 * 在数学上，斐波那契数列以如下被以递推的方法定义：F(1)=1，F(2)=1, F(n)=F(n - 1)+F(n - 2)
 * 
 * 用递归实现一个斐波那契数列 方法： fibo
 * 
 * 测试例1： 输入1  输出1
 * 测试例2： 输入2  输出1
 * 测试例3： 输入3  输出2
 * 测试例10： 输入9  输出34
 */

public class Fibonacci {
    static public int fibo(int i) {
        // 填写算法

        if (i == 1 || i  == 2) {
            return 1;
        }

        return fibo(i-1) + fibo(i-2);
    }

    public static void main(String[] args) {
        // 测试例1： 输入1  输出1
        System.out.println("测试1 输入1,结果:" + fibo(1));
        
        // 测试例2： 输入2  输出1
        System.out.println("测试2 输入2,结果:" + fibo(2));
        
        // 测试例3： 输入3  输出2
        System.out.println("测试3 输入3,结果:" + fibo(3));
        
        // 测试例4： 输入9  输出34
        System.out.println("测试4 输入4,结果:" + fibo(9));
    }
}
