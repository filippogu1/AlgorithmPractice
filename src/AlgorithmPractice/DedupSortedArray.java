package AlgorithmPractice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DedupSortedArray {

    // Dedup the array so that we only keep 1 copy of each element.
    public int[] dedup1(int[] arr) {
        int lastIndex = 0;
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < arr.length; i++) {
            if (arr[lastIndex] == arr[i]) continue;
            list.add(arr[lastIndex]);
            lastIndex = i;
        }

        if (arr[lastIndex] == arr[arr.length - 1]) {
            list.add(arr[lastIndex]);
        }

        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }

        return res;
    }

    // Dedup the array so that we only keep unique nums, and remove all duped nums
    public int[] dedup2(int[] arr) {
        int lastIndex = 0;
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < arr.length; i++) {
            if (arr[lastIndex] == arr[i]) continue;
            if (i - lastIndex == 1) {
                list.add(arr[lastIndex]);
            }
            lastIndex = i;
        }

        if (arr[lastIndex] == arr[arr.length - 1]) {
            list.add(arr[arr.length - 1]);
        }

        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }

        return res;
    }

    public static void main(String[] args) {
        DedupSortedArray d = new DedupSortedArray();
        int[] arr1 = new int[]{1, 2, 2, 3, 3, 3, 4, 4};
        System.out.println(Arrays.toString(d.dedup1(arr1)));
        System.out.println(Arrays.toString(d.dedup2(arr1)));
    }
}
