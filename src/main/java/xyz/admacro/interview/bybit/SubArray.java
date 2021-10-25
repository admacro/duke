/* 
    实现 indexOf(int[] array, int[] subArray)，找到在 array 中第一次出现 subArray 的下标，如果不存在，返回 -1
    
    e.g.
    indexOf([10, 11, 12, 13], [12, 13]): 2
    indexOf([10, 11, 12, 22, 12, 13], [12, 13]): 4
    indexOf([10, 11, 12], [11, 13]): -1 # array 参数中不存在连续的 [11, 13] 子串
    indexOf([10, 11, 12], [10]): 0 
*/
package xyz.admacro.interview.bybit;

public class SubArray {
    public static int indexOf(int[] array, int[] subArray) {
        if (subArray.length == 0) {
            return 0;
        } else if (subArray.length > array.length) {
            return -1;
        }

        int matchingIndex = -1;
        int subMatchingIndex = -1;
        for (int i = 0; i < array.length; i++) {
            int j = subMatchingIndex + 1;
            while (j < subArray.length) {
                if (array[i] != subArray[j]) {
                    subMatchingIndex = -1;
                    break;
                } else {
                    subMatchingIndex = j;
                    if (j == 0) {
                        matchingIndex = i;
                    }
                    break;
                }
            }
            if (subMatchingIndex == subArray.length - 1) {
                return matchingIndex;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        System.out.println(SubArray.indexOf(new int[] { 10, 11, 12, 13 }, new int[] { 12, 13 })); // 2
        System.out.println(SubArray.indexOf(new int[] { 10, 11, 12, 22, 12, 13 }, new int[] { 12, 13 })); // 4
        System.out.println(SubArray.indexOf(new int[] { 10, 11, 12 }, new int[] { 11, 13 })); // -1
        System.out.println(SubArray.indexOf(new int[] { 10 }, new int[] { 10, 11 })); // -1
        System.out.println(SubArray.indexOf(new int[] { 10, 10 }, new int[] { 10 })); // 0
        System.out.println(SubArray.indexOf(new int[] {}, new int[] {})); // 0
    }
}
