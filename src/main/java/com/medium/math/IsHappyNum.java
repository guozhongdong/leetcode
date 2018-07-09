package com.medium.math;

/**
 * @author gzd
 * @create 2018-07-09 12:47
 * @desc 快乐数
 * 思路：先将整数的各个位置的数字得到，通过 取余法，
 *      然后计算判断 结果是否为1，不满足则递归调用这个方法
 *      判断==4 是因为 出现4的话，肯定是不满足情况，为了减少时间复杂度，
 **/
public class IsHappyNum {

    public boolean isHappy(int n) {
        if (n < 0){
            return false;
        }
        int sum = 0;
        while (n > 0){

            sum += (n%10)*((n%10));
            n = n/10;
        }
        if (sum == 1){
            return true;
        }else if (sum == 4){
            return false;
        }
       // System.out.println(sum);
        //System.out.println(n);
        //Integer num = new Integer(n);

        if (isHappy(sum)){
            return true;
        }
        return false;
    }

    public static void main(String[] args){
        int num = 9;
        boolean flag = new IsHappyNum().isHappy(num);
        System.out.println(flag);
        //System.out.println(2/10);
        //System.out.println(29%10);
    }
}
