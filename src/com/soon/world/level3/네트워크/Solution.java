package com.soon.world.level3.네트워크;

/**
 * DFS 문제!
 * 인접행렬 방문에 관한 문제.
 * DFS 에 대해 다시 한번 생각해 볼 수 있는 계기가 되었다.
 * --> dfs 한번이 끝났다는건 연결된 네트워크 한 depth 가 끝났다는 의미기 때문에
 * dfs 를 한 뒤에 answer 값을 +1 해 준다.
 */
public class Solution {
    public int solution(int n, int[][] computers) {
        int answer = 0;
        boolean[] visited = new boolean[n];

        for(int i=0; i<n; i++) {
            if(!visited[i]) {
                dfs(i,visited,computers);
                answer++;
            }
        }

        return answer;
    }

    public void dfs(int index, boolean[] visited, int[][] computers) {
        visited[index] = true;
        for(int i=0; i<computers.length; i++) {
            if(!visited[i] && computers[index][i]==1) {
                dfs(i,visited,computers);
            }
        }
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        int t = 3;
        int[][] test = {{1,1,0},{1,1,0},{0,0,1}};
        System.out.println(solution.solution(t,test));
    }
}
