package com.hewie.leet;

/**
 * 实现字符转化
 * 根据示例 1，需要去掉前导空格；
 * 根据示例 2，需要判断第 1 个字符为 + 和 - 的情况，因此，可以设计一个变量 sign，初始化的时候为 1，如果遇到 - ，将 sign 修正为 -1；
 * 判断是否是数字，可以使用字符的 ASCII 码数值进行比较，即 0 <= c <= '9'；
 * 根据示例 3 和示例 4 ，在遇到第 1 个不是数字的字符的情况下，转换停止，退出循环；
 * 根据示例 5，如果转换以后的数字超过了 int 类型的范围，需要截取。这里不能将结果 res 变量设计为 long 类型，
 * 注意：由于输入的字符串转换以后也有可能超过 long 类型，因此需要在循环内部就判断是否越界，只要越界就退出循环，
 * 这样也可以减少不必要的计算；
 * 由于涉及下标访问，因此全程需要考虑数组下标是否越界的情况。
 * */
public class Leet8 {
    public int myAtoi(String s) {

        //字符串转换为整数
        char[] cs = s.toCharArray();
        int len = s.length();

        //去除前面的空格，转换字符串经常用到
        int index = 0;
        while(index < len && cs[index] == ' '){
            index ++;
        }
        // 如果全是空格
        if(index == len){
            return 0;
        }

        //判断第一个字符
        int sign = 1;
        if(cs[index] == '-'){
            index ++;
            sign = -1;
        }else if (cs[index] == '+'){
            index ++;
        }

        //pre 保存处理之前的值，用来判断是否溢出
        int res = 0;
        int pre = 0;
        while(index < len){
            char temp = cs[index];
            //第一个字符不是数字
            if(temp < '0' || temp > '9'){
                break;
            }
            int num = temp - '0';
            pre = res;
            res = res * 10 + num ;
            //判断是否溢出
            if(res / 10 != pre){
                return (sign == 1)? Integer.MAX_VALUE:Integer.MIN_VALUE;
            }
            //向后移动一位
            index ++ ;
        }
        return  sign * res;
    }
}
