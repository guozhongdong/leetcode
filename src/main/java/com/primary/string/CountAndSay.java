package com.primary.string;

/**
 * @author gzd
 * @create 2018-06-06 9:13
 * @desc 数数并说
 * 例如： 1 读作 1个1， 则为11
 *       11 读作2个1 ，则为21
 *       21 读作1个2，1个1 ，则为1211
 *
 **/
public class CountAndSay {

    public static void main(String[] args){
        String s = new CountAndSay().countAndSay(5);
        System.out.println(s);
    }

    public String countAndSay(int n) {
        if (n <= 0 )
            return "-1";
        String result = "1";
        for (int i = 1; i < n ; i++) {
            // 创建一个 StringBuilder 拼接最终的结果
            StringBuilder sb = new StringBuilder();
            int index = 0; // 遍历的记录为
            while (index < result.length()){
                // 记录值
                char val = result.charAt(index);
                // 记录个数
                int count = 0;
                // 记录连续数，碰到不相等的就调出来，
                while (index<result.length() && result.charAt(index) == val){
                    index++;
                    count++;
                }
                sb.append(String.valueOf(count));
                sb.append(val);
            }
            result = sb.toString();
        }

        return result;
    }
}
