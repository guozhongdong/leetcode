package com.sum2021.strings.zhengshu;

/**
 * @author guozhongdong
 * @date 2021/1/24 16:31
 *
 * string字符串转成整数
 * 如"123" 转成 123
 * 空指针
 * 符号
 * 最大数和最小数
 * 转换的思路 n 是原数，每一次计算 原数 * 10 + 后数
 */
public class StringToInt {

    public static void main(String[] args) {
        String str = "-123";
        System.out.println(new StringToInt().toInt(str));
    }


    public int toInt(String str){
        int max = Integer.MAX_VALUE;
        int min = Integer.MIN_VALUE;
        if (str == null){
            return 0;
        }
        int n = 0;
        int sign = 1;
        //处理空格
        for (int i = 0; i < str.length(); i++) {
            if (Character.isSpaceChar(str.charAt(i))){
                continue;
            }
            //有负号
            if (str.charAt(i) == '-'){
                sign = -1;
            }
        }
        for (int i = 0; i < str.length(); i++) {

            if (Character.isDigit(str.charAt(i))){
                int c = str.charAt(i)-'0';
                if (sign > 0 && (n > max/10 || (n == max/10 && c > max%10))){
                    n = max;
                    break;
                }else if (sign < 0 && (n > Math.abs(min /10) || (n == Math.abs(min/10) && c > Math.abs(min)%10))){
                    n = min;
                    break;
                }
                n = n*10 + c;

            }

        }

        return sign > 0 ? n : -n;
    }
}
