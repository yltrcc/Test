import java.util.Arrays;
import java.util.List;

/**
 * // 输入一个无序整数数组，调整数组中数字的顺序， 使得所有偶数位于所有奇数的前方。
 * // 要求时间复杂度为O(n)。
 * //     输入描述:
 * //         给定无序数组。
 * //         长度不超过1000000。
 * //     输出描述:
 * //         如果有多个答案可以输出任意一个正确答案。
 * //     示例1
 * //         输入
 * //         2 4 5 7 8 1
 * //         输出
 * //         2 4 8 7 5 1
 */
public class ReorderArray {

    static public void reorderArray(int[] a) {

        int low = 0, high = a.length - 1;
        int cnt = -1;
        while (low <= high) {
            // 填入算法
            if (Math.abs(a[low]) % 2 == 0 && cnt != -1) {
                int tmp = a[cnt];
                a[cnt] = a[low];
                a[low] = tmp;
                cnt = Math.min(cnt+1, low);
            }

            if (Math.abs(a[low]) % 2 == 1) {
                if (cnt == -1)
                    cnt = low;
            }
            low++;
        }
    }

    public static void main(String[] args) throws Exception {
        // 测试用例1
        int[] a = {0};
        reorderArray(a);

        if (!checkResult(a)) {
            System.out.println("测试用例1未通过");
        }
        // 测试用例2
        a = new int[]{2,4, 5 ,7, 8, 1};
        reorderArray(a);
        if (!checkResult(a)) {
            System.out.println("测试用例2未通过");
        }
        // 测试用例3
        a = new int[]{-1, -2, -3, 100, 200};
        reorderArray(a);
        if (!checkResult(a)) {
            System.out.println("测试用例3未通过");
        }

    }

    /**
     * 检查数组 a 是否满足所有偶数在奇数前（无需修改）
     *
     * @param a
     * @return
     */
    static private Boolean checkResult(int[] a) {
        if (a == null || a.length == 0) {
            return true;
        }
        int i = 0;
        while (i < a.length && ((a[i] & 1) == 0)) {
            ++i;
        }
        while (i < a.length && ((a[i] & 1) == 1)) {
            ++i;
        }
        return i == a.length;
    }
}
