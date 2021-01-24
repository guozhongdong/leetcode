package com.sum2021.strings.zhengshu;

/**
 * @author guozhongdong
 * @date 2021/1/24 16:55
 *
 * 扩展训练 转换成double
 *
 * 类似上一题，需要考虑几个点，
 * 一个是小数，另一个是临界的最大值和最小值
 * 遇到小数点后，需要除以10 ,在加上当前的数
 *
 * 计算的时候分为小数点前和小数点后的部分
 */
public class StringToDouble {

    public static void main(String[] args) {
        double a = 12;
        System.out.println(a/10);
        String str = "-123.56";
        System.out.println(new StringToDouble().toDouble(str));
    }

    public double toDouble(String str){
        double max = Double.MAX_VALUE;
        double min = Double.MIN_VALUE;

        if (str == null){
            return 0;
        }
        double n = 0;
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

            if (Character.isDigit(str.charAt(i)) ){

                int dou = str.charAt(i)-'0';
                if (sign > 0 && (n > max/10 || (n == max/10 && dou > max%10))){
                    n = max;
                    break;
                }else if (sign < 0 && (n > Math.abs(min /10) || (n == Math.abs(min/10) && dou > Math.abs(min)%10))){
                    n = min;
                    break;
                }
                n = n*10 + dou;

            }else if (str.charAt(i) == '.'){
                break;
            }
           

        }
        double n1 = 0;
        int dian = 0;
        int wei = 1;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '.' || Character.isDigit(str.charAt(i))){
                dian = 1;
                continue;
            }
            if (dian > 0){
                int dou = str.charAt(i)-'0';

                if (sign > 0 && (n > max/10 || (n == max/10 && dou > max%10))){
                    n = max;
                    break;
                }else if (sign < 0 && (n > Math.abs(min /10) || (n == Math.abs( min/10) && dou > Math.abs(min)%10))){
                    n = min;
                    break;
                }
                n1 = n1 +  dou/(Math.pow(10,wei));
                wei++;
            }
        }

        return sign > 0 ? n+n1 : -(n+n1);
    }
}
