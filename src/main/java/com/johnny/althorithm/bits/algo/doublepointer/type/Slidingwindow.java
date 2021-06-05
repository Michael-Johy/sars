package com.johnny.althorithm.bits.algo.doublepointer.type;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Slidingwindow {
    public static void main(String[] args) {
        Slidingwindow slidingwindow = new Slidingwindow();
//        String a = slidingwindow.min("ADOBECODEBANC", "ABC");
//        System.out.println(a);

        boolean contains = slidingwindow.contains("eidabbabc000", "abc");
        System.out.println(contains);

        Set<Integer> startIndexs = slidingwindow.findAllStartIndexs("cbaebabacd", "abc");
        startIndexs = slidingwindow.findAllStartIndexs("babbac", "abc");
        System.out.println(startIndexs);

        String result = slidingwindow.find("abcdedcba");
        System.out.println(result);
    }

    /**
     * 问题：最小覆盖字串问题
     * 解法：字符串source包含target所有元素
     */
    public String min(String source, String target) {
        Map<Character, Integer> need = new HashMap<>();
        char[] targets = target.toCharArray();
        for (char item : targets) {
            need.put(item, need.getOrDefault(item, 0) + 1);
        }

        Map<Character, Integer> window = new HashMap<>();
        char[] sources = source.toCharArray();
        int length = sources.length;

        int left = 0;
        int right = 0;

        int resultLength = Integer.MAX_VALUE;
        int start = 0;

        int validSize = 0;
        while (right < length) {
            char s = sources[right];
            right++;
            if (need.containsKey(s)) {
                if (!window.containsKey(s)) {
                    validSize++;
                }
                window.put(s, window.getOrDefault(s, 0) + 1);
            }
            while (validSize == need.size()) {
                resultLength = right - left;
                start = left;
                char l = sources[left];
                left++;
                if (need.containsKey(l)) {
                    int count = window.getOrDefault(l, 0);
                    if (count == 1) {
                        window.remove(l);
                        validSize--;
                    } else {
                        window.put(l, --count);
                    }
                }
            }
        }
        return resultLength == Integer.MAX_VALUE ? null : source.substring(start, start + resultLength);
    }


    /**
     * 问题：source  target  source是否包含target排列组合的一种
     * 解法：字符串source包含target所有元素，且不包含其它元素
     */
    public boolean contains(String source, String target) {
        Map<Character, Integer> need = new HashMap<>();
        char[] targets = target.toCharArray();
        for (char item : targets) {
            need.put(item, need.getOrDefault(item, 0) + 1);
        }
        Map<Character, Integer> real = new HashMap<>();
        char[] sources = source.toCharArray();
        int left = 0, right = 0;
        int validCount = 0;
        while (right < sources.length) {
            char r = sources[right];
            right++;
            if (need.containsKey(r)) {
                real.put(r, real.getOrDefault(r, 0) + 1);
                if (real.get(r).equals(need.get(r))) {
                    validCount++;
                }
            }
            if (right - left >= targets.length) {
                if (validCount == need.size() && (right - left) == targets.length) {
                    return true;
                }
                char d = sources[left];
                left++;
                if (need.containsKey(d)) {
                    real.put(d, real.get(d) - 1);
                    if (!real.get(d).equals(need.get(d))) {
                        validCount--;
                    }
                }
            }
        }
        return false;
    }

    /**
     * 问题：找出source中所有是target的字母异位词的字串，返回索引
     * 解法：字符串source包含target所有元素，且不包含其它元素, 会不会重复
     */
    public Set<Integer> findAllStartIndexs(String source, String target) {
        Map<Character, Integer> need = new HashMap<>();
        char[] targets = target.toCharArray();
        for (char item : targets) {
            need.put(item, need.getOrDefault(item, 0) + 1);
        }
        Map<Character, Integer> real = new HashMap<>();
        char[] sources = source.toCharArray();
        int left = 0, right = 0;
        int validCount = 0;

        Set<Integer> result = new HashSet<>();
        while (right < sources.length) {
            char r = sources[right];
            right++;
            if (need.containsKey(r)) {
                real.put(r, real.getOrDefault(r, 0) + 1);
                if (real.get(r).equals(need.get(r))) {
                    validCount++;
                }
            }
            while (right - left >= targets.length) {//可替换成if
                if (validCount == need.size() && (right - left) == targets.length) {
                    result.add(left);
                }
                char d = sources[left];
                left++;
                if (need.containsKey(d)) {
                    real.put(d, real.get(d) - 1);
                    if (!real.get(d).equals(need.get(d))) {
                        validCount--;
                    }
                }
            }
        }
        return result;
    }

    /**
     * 最长无重复字串
     */
    public String find(String source) {
        char[] sources = source.toCharArray();
        int left = 0;
        int right = 0;

        Set<Character> window = new HashSet<>();

        int length = Integer.MIN_VALUE;
        String result = null;
        while (right < sources.length) {
            char r = sources[right];
            right++;

            while (window.contains(r)) {
                int nowLength = right - left - 1;
                if (nowLength > length) {
                    length = nowLength;
                    result = source.substring(left, right - 1);
                }
                char l = sources[left];
                left++;
                window.remove(l);
            }
            window.add(r);
        }
        return null == result ? source : result;
    }
}
