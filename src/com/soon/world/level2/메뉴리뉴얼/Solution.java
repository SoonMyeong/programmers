package com.soon.world.level2.메뉴리뉴얼;

import java.util.*;

/**
 * 부분집합 구하는 조합 알고리즘 알면 쉽게 풀 수 있는 문제
 * 조합을 구하는 방법으로는 백트래킹 , 재귀 방법이 있다.
 */
public class Solution {
    static int max;
    public String[] solution(String[] orders, int[] course) {
        List<String> answer = new ArrayList<>();

        for (int i : course) {
            Map<String,Integer> map = new HashMap<>();
            max = 0;
            for (String str : orders) {
                String[] splitStr = str.split("");
                Arrays.sort(splitStr);
                combination(splitStr, map, new boolean[splitStr.length], 0, splitStr.length, i);
            }

            for(String key : map.keySet()) {
                if(max>1 && map.get(key)==max) {
                    answer.add(key);
                }
            }
        }


        answer.sort(String::compareTo);

        return answer.toArray(new String[0]);
    }

    /**
     * 백트래킹을 이용한 조합 구하는 메소드
     *
     * @param arr : 조합을 구할 배열
     * @param visited : 인덱스 방문 여부
     * @param start : 시작 값
     * @param n : arr의 길이
     * @param r : 조합의 길이
     */
    private void combination(String[] arr, Map<String,Integer>map, boolean[] visited, int start, int n, int r) {
        if(r == 0) {
            StringBuilder result = new StringBuilder();
            for (int i = 0; i < n; i++) {
                if (visited[i]) {
                    result.append(arr[i]);
                }
            }
            map.put(result.toString(), map.getOrDefault(result.toString(),0)+1);
            max = Math.max(max,map.get(result.toString()));
            return;
        }

        if(r>n) {
            return ;
        }

        for(int i=start; i<n; i++) {
            visited[i] = true;
            combination(arr, map, visited, i + 1, n, r - 1);
            visited[i] = false;
        }
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        String[] orders = {"ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"};
//        String[] orders = {"XYZ", "XWY", "WXA"};
        int[] course = {2,3,4};
        System.out.println(Arrays.toString(solution.solution(orders, course)));
    }
}
