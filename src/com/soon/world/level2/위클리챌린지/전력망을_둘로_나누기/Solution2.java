package com.soon.world.level2.위클리챌린지.전력망을_둘로_나누기;


import java.util.*;

/**
 * 연결리스트 사용한 DFS ,BFS 풀이
 */
public class Solution2 {

    static List<List<String>> list;
    static boolean [] visited;
    static int count = 0;
    public int solution(int n, int[][] wires) {
        int answer = Integer.MAX_VALUE;
        int cnt = 0;
        list = new ArrayList<>();

        for(int i=0; i<=n; i++) {
            list.add(new ArrayList<>());
        }
        visited = new boolean[n+1];

        for(int i=0; i<wires.length; i++) {
            list.get(wires[i][0]).add(String.valueOf(wires[i][1]));
            list.get(wires[i][1]).add(String.valueOf(wires[i][0]));
        }

        while(cnt<wires.length) {

            list.get(wires[cnt][0]).remove(String.valueOf(wires[cnt][1]));
            list.get(wires[cnt][1]).remove(String.valueOf(wires[cnt][0]));

//            dfs(1,n);
            bfs(1,n);

            list.get(wires[cnt][0]).add(String.valueOf(wires[cnt][1]));
            list.get(wires[cnt][1]).add(String.valueOf(wires[cnt][0]));

            Arrays.fill(visited, false);

            /**
             * n- count 또 다른 송전탑 개수
             * 이 두개의 송전탑 개수의 차
             * n-count - count = n- 2*count
             */
            answer = Math.min(answer,Math.abs(n- (2*count)));
            count = 0;
            cnt++;
        }


        return answer;
    }

    private static void bfs(int i, int n) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(i);
        visited[i] = true;
        count++;

        while(!queue.isEmpty()) {
            int j = queue.poll();

            for(int k=1; k<=n; k++) {
                if(!visited[k] && list.get(i).contains(String.valueOf(k))) {
                    bfs(k,n);
                }
            }

        }

    }

    private static void dfs(int i, int n) {
        visited[i] = true;
        count++;
        for(int j=1; j<=n; j++) {
            if(!visited[j]&& list.get(i).contains(String.valueOf(j))) {
                dfs(j,n);
            }
        }
    }


    public static void main(String[] args) {
//        int[][] wires = {{1,2},{2,3},{3,4}};
        int[][] wires = {{1,3},{2,3},{3,4},{4,5},{4,6},{4,7},{7,8},{7,9}};
        int n = 9;
        Solution2 solution = new Solution2();
        System.out.println(solution.solution(n,wires));

        /**
         *
         *
         */

    }
}
