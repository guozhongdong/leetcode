package com.sum2020.array;


/**
 * @author gzd
 * @date 2020/4/3 下午9:45
 *
 * 给定一个排序数组，你需要在原地删除重复出现的元素，使得每个元素最多出现两次，返回移除后数组的新长度。
 *
 * 不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。
 *
 * 示例 1:
 *
 * 给定 nums = [1,1,1,2,2,3],
 *
 * 函数应返回新长度 length = 5, 并且原数组的前五个元素被修改为 1, 1, 2, 2, 3 。
 *
 * 你不需要考虑数组中超出新长度后面的元素。
 * 示例 2:
 *
 * 给定 nums = [0,0,1,1,1,1,2,3,3],
 *
 * 函数应返回新长度 length = 7, 并且原数组的前五个元素被修改为 0, 0, 1, 1, 2, 3, 3 。
 *
 * 你不需要考虑数组中超出新长度后面的元素。
 * 说明:
 *
 * 为什么返回数值是整数，但输出的答案是数组呢?
 *
 * 请注意，输入数组是以“引用”方式传递的，这意味着在函数里修改输入数组对于调用者是可见的。
 *
 * 你可以想象内部操作如下:
 *
 * // nums 是以“引用”方式传递的。也就是说，不对实参做任何拷贝
 * int len = removeDuplicates(nums);
 *
 * // 在函数里修改输入数组对于调用者是可见的。
 * // 根据你的函数返回的长度, 它会打印出数组中该长度范围内的所有元素。
 * for (int i = 0; i < len; i++) {
 *     print(nums[i]);
 * }
 *
 * 思路：不适用外部空间，空间复杂度O(1)，时间复杂度 没要求，
 * 提示点： 引用传递，可以删除遍历数组元素，关键点，说明原地删除，移动后的元素也在原数组，
 * 所以只需要返回新数组前面的元素，可以用i动态记录。
 *
 */
public class RemoveDuplicatesII {

    public static void main(String[] args) {
        int[] nums = {1,1,1,2,2,3};
        //int[] nums = {0,0,1,1,1,1,2,3,3};
        //System.out.println(new RemoveDuplicatesII().removeDuplicates(nums));
        System.out.println(new RemoveDuplicatesII().removeDuplicates2(nums));
    }


    // 解法一
    public int removeDuplicates(int[] nums) {

        int n = nums.length;
        int k = 1;
        int i ;
        for ( i = 1; i < n; i++) {

            if (nums[i] == nums[i-1]){
                k++;
                if (k > 2){
                    removeElement(nums,i);
                    i--;
                    n--;
                }

            } else{
                k = 1 ;
            }
        }

        return i;
    }

    public void removeElement(int[] nums,int index){

        for (int i = index+1; i < nums.length; i++) {
            nums[i-1] = nums[i];
        }

    }


    /**
     * 优秀解法，重复利用排序的特性，
     *  如果i 不小于2 ，或者是等于2 ，且 n 也不大于 nums[i-2],即第三个元素不大于第一个，说明重复的已经有三个了，
     *  1 ，1，1，2，2，3
     *  则 i 不动，n继续遍历，，满足 n > nums[i-2]了，把 n 替换到前面一个元素上，依次推下去。
     *
     * */
    public int removeDuplicates2(int[] nums){
        int i = 0;
        for (int n : nums) {
            if (i < 2 || n > nums[i-2])
                nums[i++] = n;
        }
        return i;

    }
}
