package com.johnny.althorithm.bits.algo.qujian;

import java.util.Arrays;
import java.util.Vector;

/**
 * 区间问题
 */
public class Solution {

    public Vector<Vector<Integer>> fuGai(Vector<Vector<Integer>> lines) {
        lines.sort((a, b) -> {
            if (a.get(0).intValue() == b.get(0)) {
                return b.get(1).compareTo(a.get(1));
            }
            return a.get(0).compareTo(b.get(0));
        });

        Vector<Vector<Integer>> result = new Vector<>();

        int max = lines.get(0).get(1);

        for (int i = 1; i < lines.size(); i++) {
            int right = lines.get(i).get(1);
            if (right <= max) {
                result.add(lines.get(i));
            } else {
                max = right;
            }
        }

        return result;
    }


    public Vector<Vector<Integer>> chongDieHeBing(Vector<Vector<Integer>> lines) {
        lines.sort((a, b) -> {
            if (a.get(0).intValue() == b.get(0)) {
                return b.get(1).compareTo(a.get(1));
            }
            return a.get(0).compareTo(b.get(0));
        });

        Vector<Vector<Integer>> result = new Vector<>();

        int min = lines.get(0).get(0);
        int max = lines.get(0).get(1);

        for (int i = 1; i < lines.size(); i++) {
            int left = lines.get(i).get(0);
            int right = lines.get(i).get(1);

            if (left > max) {
                max = right;
                min = left;
            } else {
                if (right > max) { //重叠
                    Vector<Integer> v = new Vector<>();
                    v.add(min);
                    v.add(right);
                    result.add(v);
                    max = right;
                }
            }
        }

        return result;
    }

    public Vector<Vector<Integer>> jiaoji(Vector<Vector<Integer>> lines1, Vector<Vector<Integer>> lines2) {

        Vector<Vector<Integer>> result = new Vector<>();

        int i = 0;
        int j = 0;
        while (i < lines1.size() && j < lines2.size()) {
            int l1 = lines1.get(i).get(0);
            int r1 = lines1.get(i).get(1);

            int l2 = lines2.get(j).get(0);
            int r2 = lines2.get(j).get(1);


            if (!(l1 > r2 || l2 > r1)) {//有相交
                int start = Math.max(l1, l2);
                int end = Math.min(r1, r2);
                Vector<Integer> v = new Vector<>();
                v.add(start);
                v.add(end);
                result.add(v);
            }
            if (r1 > r2) {
                j++;
            } else if (r1 == r2) {
                i++;
                j++;
            } else {
                i++;
            }
        }
        return result;
    }


    public Vector<Vector<Integer>> fuGai(int[][] lines) {
        Arrays.sort(lines, (a, b) -> {
            if (a[0] == b[0]) {
                return b[1] - a[1];
            } else {
                return a[0] - b[0];
            }
        });

        Vector<Vector<Integer>> result = new Vector<>();

        int[] line0 = lines[0];
        int max = line0[1];
        for (int i = 1; i < lines.length; i++) {
            int[] lineI = lines[i];
            if (lineI[1] <= max) {
                Vector<Integer> v = new Vector<>();
                v.add(lineI[0]);
                v.add(lineI[1]);
                result.add(v);
            } else {
                max = lineI[1];
            }
        }
        return result;
    }

    public static void main1(String[] args) {
        Solution solution = new Solution();
        Vector<Vector<Integer>> lines = new Vector<>();
        Vector<Integer> l1 = new Vector<>();
        l1.add(1);
        l1.add(4);
        lines.add(l1);

        Vector<Integer> l2 = new Vector<>();
        l2.add(3);
        l2.add(6);
        lines.add(l2);

        Vector<Integer> l3 = new Vector<>();
        l3.add(2);
        l3.add(8);
        lines.add(l3);

        Vector<Vector<Integer>> result = solution.fuGai(lines);
        System.out.println(result);

        int[][] arrLines = new int[][]{{1, 4}, {3, 6}, {2, 8}};
        Vector<Vector<Integer>> result1 = solution.fuGai(arrLines);
        System.out.println(result1.size());
    }

    public static void main2(String[] args) {
        Solution solution = new Solution();
        Vector<Vector<Integer>> lines = new Vector<>();
        Vector<Integer> l1 = new Vector<>();
        l1.add(1);
        l1.add(3);
        lines.add(l1);

        Vector<Integer> l2 = new Vector<>();
        l2.add(2);
        l2.add(6);
        lines.add(l2);

        Vector<Integer> l3 = new Vector<>();
        l3.add(8);
        l3.add(10);
        lines.add(l3);

        Vector<Integer> l4 = new Vector<>();
        l4.add(15);
        l4.add(18);
        lines.add(l4);

        Vector<Vector<Integer>> result = solution.chongDieHeBing(lines);
        System.out.println(result);
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        Vector<Vector<Integer>> lines = new Vector<>();
        Vector<Integer> l1 = new Vector<>();
        l1.add(0);
        l1.add(2);
        lines.add(l1);
        Vector<Integer> l2 = new Vector<>();
        l2.add(5);
        l2.add(10);
        lines.add(l2);
        Vector<Integer> l3 = new Vector<>();
        l3.add(13);
        l3.add(23);
        lines.add(l3);
        Vector<Integer> l4 = new Vector<>();
        l4.add(24);
        l4.add(25);
        lines.add(l4);

        Vector<Vector<Integer>> lines2 = new Vector<>();
        Vector<Integer> l21 = new Vector<>();
        l21.add(1);
        l21.add(5);
        lines2.add(l21);
        Vector<Integer> l22 = new Vector<>();
        l22.add(8);
        l22.add(12);
        lines2.add(l22);
        Vector<Integer> l23 = new Vector<>();
        l23.add(15);
        l23.add(24);
        lines2.add(l23);
        Vector<Integer> l24 = new Vector<>();
        l24.add(25);
        l24.add(26);
        lines2.add(l24);

        Vector<Vector<Integer>> result = solution.jiaoji(lines, lines2);
        System.out.println(result);

    }

}
