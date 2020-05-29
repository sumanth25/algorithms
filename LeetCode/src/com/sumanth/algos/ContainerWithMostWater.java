package com.sumanth.algos;
/*
Container With Most Water
Medium

Given n non-negative integers a1, a2, ..., an , where each represents a point at
coordinate (i, ai). n vertical lines are drawn such that the two endpoints of line i
is at (i, ai) and (i, 0). Find two lines, which together with x-axis forms a container,
such that the container contains the most water.

Note: You may not slant the container and n is at least 2.
 */
public class ContainerWithMostWater {
    public static void mostWaterAlgo(){
        int[] heights=new int[]{1,8,6,2,5,4,8,3,7};
        int result = maxArea(heights);
            System.out.println(result);
    }

    /*
     *   Algorithm
     */
    public static int maxArea(int[] height) {
        int maxarea = 0, l = 0, r = height.length - 1;
        while (l < r) {
            maxarea = Math.max(maxarea, Math.min(height[l], height[r]) * (r - l));
            if (height[l] < height[r])
                l++;
            else
                r--;
        }
        return maxarea;
    }
}
/*
Two Pointer Approach

Algorithm

The intuition behind this approach is that the area formed between the lines will always be
limited by the height of the shorter line. Further, the farther the lines, the more will be
the area obtained.

We take two pointers, one at the beginning and one at the end of the array constituting the
length of the lines. Futher, we maintain a variable maxarea to store
the maximum area obtained till now. At every step, we find out the area formed between them,
update maxarea and move the pointer pointing to the shorter line towards the other end by one step.

 Complexity Analysis

    Time complexity : O(n). Single pass.

    Space complexity : O(1). Constant space is used.

 */