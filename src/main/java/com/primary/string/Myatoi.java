package com.primary.string;

/**
 * @author gzd
 * @create 2018-06-05 9:10
 * @desc:字符串转整数
 **/
public class Myatoi {

    public static void main(String[] args){
        int f = new  Myatoi().myAtoi("-91283472332");
        System.out.println(f);
    }
    public int myAtoi(String str) {

/*
        if (str == null || str.replaceAll(" ","").length() ==0
                ){
            return 0;
        }
        if (!Character.isDigit(str.replaceAll(" ","").charAt(0)) && str.replaceAll(" ","").charAt(0) != '+'
                && str.replaceAll(" ","").charAt(0) != '-'){
            return  0 ;
        }

        String s = str.replaceAll(" ","");
        char[] chs = s.toCharArray();
        char[] ch2 = new char[chs.length];

        if (chs[0] == '+' || chs[0] == '-' || Character.isDigit(chs[0])){
            ch2[0] = chs[0];
            for (int i = 1; i < chs.length; i++) {
                if (Character.isDigit(chs[i])){
                    ch2[i] = chs[i];
                }else{
                    break;
                }
            }
        }

        Integer num = Integer.parseInt(new String(ch2).trim());
        if (num > Integer.MAX_VALUE){
            return Integer.MAX_VALUE;
        }else if(num < Integer.MIN_VALUE){
            return Integer.MIN_VALUE;
        }
        System.out.println(num);
        //System.out.println(new String(ch2));
        //System.out.println(str.replaceAll(" ",""));
        return 1;*/
        if (str.isEmpty()) return 0;
        // 正负号标记
        int sign = 1;

        // 转换值
        int base = 0;

        // 索引位数
        int i = 0;

        // 剔除开始空白字符
        while (str.charAt(i) == ' ')
            i++;
        // 判断正负号
        if (str.charAt(i) == '-' || str.charAt(i) == '+')
            sign = str.charAt(i++) == '-' ? -1 : 1;
        // 索引有效数字字符
        while (i < str.length() && str.charAt(i) >= '0' && str.charAt(i) <= '9') {

            // that statement is used to test if the num is bigger than INT_MAX after the str[i] is handled, if base > INT_MAX/10,
            // then base10+ str[i] -‘0’> base10>INT_MAX, or when base== INT_MAX/10, that means all the places are the same as INT_MAX except the ones place, so str[i]>‘7’ is needed.
            // 上面这段是LeetCode国外站对下面代码的解释。
            // 简单来说就是
            // 如果`base > MAX_VALUE/10`，那么`base*10 + new_value` > `base*10` > `MAX_VALUE`。这个应该很容易理解，这种情况下就会发生溢出。
            // 若`base == INT_MAX/10`，而且`new_value = str.charAt(i++) - '0'`大于`7`，也会发生溢出。因为`MAX_VALUE = 2147483647`
            if (base > Integer.MAX_VALUE / 10 || (base == Integer.MAX_VALUE / 10 && str.charAt(i) - '0' > 7)) {
                return (sign == 1) ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }

            // 计算转换值
            base = 10 * base + (str.charAt(i++) - '0');
        }

        // 计算结果值
        return base * sign;
    }
}
