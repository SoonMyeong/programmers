package com.soon.world.level3.보석쇼핑;

import java.util.*;

/**
 *
 * 투포인터 방식이나 슬라이딩윈도우 알고리즘으로 해결 할 수 있는 문제
 *
 * 나는 슬라이딩윈도우 알고리즘으로 해결해 볼 생각.
 * ---
 * 근데 아무리 생각해도 투포인터가 그나마 풀릴거 같다는 생각을 함.. 
 * 슬라이딩 윈도우 알고리즘을 쓸라면 일정한 범위가 있고 그 범위를 움직이며 뭔가를 계산해야되는데..
 * 모르겠다.. 투포인터로 다른사람들 풀이 참고 해보자
 * ---
 * ex) "AA", "AB", "AC", "AA", "AC"
 * set size = 3
 *
 * idx = 0 )
 * map = [{"AA",1}]
 * queue = "AA"
 * to = 0;
 *
 * idx = 1 )
 * map = [{"AA",1}, {"AB",1}]
 * queue = "AA" , "AB"
 * to = 0;
 *
 * idx = 2 )
 * map = [{"AA",1}, {"AB",1"}, {"AC",1}]
 * queue = "AA" , "AB", "AC"
 * to = 0;
 *
 * idx = 3 )
 * map = [{"AA",2}, {"AB",1"}, {"AC",1}]
 * queue = "AB", "AC", "AA"
 * to = 1;
 * map = [{"AA",1}, {"AB",1"}, {"AC",1}]
 * len = 3;
 *
 * idx = 4 )
 * map = [{"AA",1}, {"AB",1"}, {"AC",2}]
 * queue = "AB", "AC", "AA" , "AC"
 * to = 2;
 * map = [{"AA",1}, {"AB",1"}, {"AC",1}]
 * from = 0;
 *
 * ---
 * 아니 이 풀이로 내가 뭘 얻어가나.. 현타오네..
 *
 *
 *
 *
 *
 */
public class Solution {
    public int[] solution(String[] gems) {
        int[] answer = new int[2];
        Set<String> set = new HashSet<>(Arrays.asList(gems));
        Map<String,Integer> map = new HashMap<>();
        Queue<String> queue = new LinkedList<>();
        int len = Integer.MAX_VALUE;
        int from = 0;
        int to = 0;

        for(int i=0; i< gems.length; i++) {
            map.put(gems[i], map.getOrDefault(gems[i],0) + 1);
            queue.offer(gems[i]);

            while(true) {
                String temp = queue.peek();

                if(map.get(temp) > 1) {
                    map.put(gems[i],map.get(gems[i]) - 1);
                    queue.poll();
                    to++;
                }else {
                    break;
                }
            }

            if(map.size() == set.size() && len > queue.size()) {
                len = queue.size();
                from = to;
            }
        }
        return new int[]{from + 1, from + len};
    }

    public static void main(String[] args) {
//        String[] gems = {"DIA", "RUBY", "RUBY", "DIA", "DIA", "EMERALD", "SAPPHIRE", "DIA"};
        String[] gems = {"AA", "AB", "AC", "AA", "AC"};
        Solution solution = new Solution();
        int[] result = solution.solution(gems);

        for (int res : result) {
            System.out.println(res);
        }
    }
}
