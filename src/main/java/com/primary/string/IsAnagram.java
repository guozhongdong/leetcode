package com.primary.string;

/**
 * @author gzd
 * @create 2018-06-02 9:15
 * @desc 思路：利用字符数组法，
 **/
public class IsAnagram {
    public static void main(String[] args){
        boolean l = new IsAnagram().isAnagram("anagram","angaram");
        System.out.println(l);
    }

    public boolean isAnagram(String s, String t) {
        int[] alpha = new int[26];
        for(int i=0;i<s.length();i++){
            alpha[s.charAt(i)-'a']++;
        }
        for(int j=0;j<t.length();j++){
            alpha[t.charAt(j)-'a']--;
        }

        for (int i = 0; i < alpha.length ; i++) {
            if (alpha[i] != 0){
                return false;
            }
        }
        /*for (int i = 0; i < alpha.length; i++) {
            System.out.println(alpha[i]);
        }*/
        return true;
    }


}
