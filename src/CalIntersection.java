

import java.util.*;

/**
 * 输入两个List，输出两个List的交集
 * 找出 calIntersection calIntersection2 中存在的错误
 * 使程序可以运行通过
 */
public class CalIntersection {
    static public List<Integer> calIntersection(List<Integer> a, List<Integer> b) {

        if (a == null || b == null) {
            return new ArrayList<>();
        }
        Set<Integer> result = new HashSet<>();
        Set<Integer> intersection = new HashSet<>(a);
        b.forEach(numberB -> {
            if (intersection.contains(numberB)) {
                result.add(numberB);
            }
        });
        return new ArrayList<>(result);
    }

    static public List<Integer> calIntersection2(List<Integer> a, List<Integer> b) {

        if (a == null || b == null) {
            return new ArrayList<>();
        }

        Collections.sort(a);
        Collections.sort(b);
        Set<Integer> result = new HashSet<>();
        int i = 0, j = 0;
        while (i < a.size() && j < b.size()) {
            Integer aValue = a.get(i);
            Integer bValue = b.get(j);
            if (aValue.intValue() == bValue.intValue()) {
                result.add(a.get(i));
                i++;
                j++;
            } else if (aValue < bValue) {
                ++i;
            } else {
                ++j;
            }
        }
        return new ArrayList<>(result);
    }

    public static void main(String[] args) {
        System.out.println("测试1开始");
        List<Integer> a = null, b = null;
        if(calIntersection(a, b).size() != 0) {
            System.out.println( "测试用例1错误");
        }
        if (calIntersection2(a, b).size() != 0) {
            System.out.println( "测试用例1错误");
        }

        System.out.println("测试2开始");
        a = Arrays.asList(1001, 1002, 1003);
        b = Arrays.asList(1002, 1003, 1004);
        if (!equals(calIntersection(a, b), Arrays.asList(1002, 1003))) {
            System.out.println( "测试用例2错错误");
        }
        if (!equals(calIntersection2(a, b), Arrays.asList(1002, 1003))) {
            System.out.println( "测试用例2错错误");
        }

        System.out.println("测试3完成");
        a = Arrays.asList(3, 2, 2, 1);
        b = Arrays.asList(2, 2, 3, 3, 4);

        if (!equals(calIntersection(a, b), Arrays.asList(2, 3))) {
            System.out.println( "测试用例3-1错错误");
        }
        if (!equals(calIntersection2(a, b), Arrays.asList(2, 3))) {
            System.out.println( "测试用例3-2错错误");
        }
        System.out.println("测试完成!");
    }

    /**
     * 判断两个数组是否相同（无需修改）
     * @param a
     * @param b
     * @return
     */
    static private Boolean equals(List<Integer> a, List<Integer> b) {
        if (a == b) {
            return true;
        }
        if (a == null || b == null || a.size() != b.size()) {
            return false;
        }
        for(Integer i = 0; i < a.size(); ++i) {
            if (!a.get(i).equals(b.get(i))) {
                return false;
            }
        }
        return true;
    }
}