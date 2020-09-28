package gaopei;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Question349 {

    public int[] intersection(int[] nums1, int[] nums2) {
        if (nums1 == null || nums1.length == 0) {
            return new int[0];
        }
        if (nums2 == null || nums2.length == 0) {
            return new int[0];
        }
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int index1 = 0;
        int index2 = 0;
        Set<Integer> result = new HashSet<>();
        while (index1 < nums1.length && index2 < nums2.length) {
            if (nums1[index1] == nums2[index2]) {
                result.add(nums1[index2]);
                if (index1 < nums1.length - 2) {
                    index1++;
                }
                if (index2 < nums2.length - 2) {
                    index2++;
                }
                continue;
            }
            if (nums1[index1] > nums2[index2]) {
                if (index2 < nums2.length - 2) {
                    index2++;
                }
                continue;
            }
            if (index1 < nums1.length - 2) {
                index1++;
            }
        }
        int[] array = new int[result.size()];
        Iterator<Integer> it = result.iterator();
        for (int i = 0; i < result.size(); i++) {
            array[i] = it.next();
        }
        return array;
    }

    public static void main(String[] args) {
        Question349 question349 = new Question349();
        System.out.println(Arrays.toString(question349.intersection(new int[]{4, 9, 5}, new int[]{9, 4, 9, 8, 4})));
        System.out.println(Arrays.toString(question349.intersection(new int[]{1, 2, 2, 1}, new int[]{2, 2})));

    }
}
