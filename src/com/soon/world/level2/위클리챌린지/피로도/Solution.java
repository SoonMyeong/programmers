package com.soon.world.level2.위클리챌린지.피로도;

import java.util.*;

public class Solution {

    /**
     * ( 최소피로도 - 사용되는 피로도 ) 값으로 정렬하면 될거같았는데.. 3가지 케이스에서 걸린다.
     *  질문하기 봤더니 이거 순열 문제였음.. (DFS or BFS)
     *
     */

    static boolean visited[];
    static int answer = 0;

    public int solution(int k, int[][] dungeons) {
        visited = new boolean[dungeons.length];
        dfs(k,dungeons,0);

        return answer;
    }

    // dfs 를 통해 배열을 통해 이뤄질 수 있는 모든 순서를 체크할 수 있다. true 하고 false 해주는 이유임
    private void dfs(int k, int[][] dungeons, int cnt) {
        for(int i=0; i<dungeons.length; i++) {
            if(!visited[i] && dungeons[i][0]<=k) {
                visited[i] = true;
                dfs(k-dungeons[i][1],dungeons,cnt+1);
                visited[i] = false;
            }
        }
        answer = Math.max(answer,cnt); //모든 케이스의 cnt 값들 중 최대 값
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int k = 80;
        int[][]dungeons = {{80,20},{50,40},{30,10}};
        System.out.println(solution.solution(k,dungeons));
    }
}
