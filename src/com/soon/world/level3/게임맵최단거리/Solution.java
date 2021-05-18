package com.soon.world.level3.게임맵최단거리;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * BFS 최단 거리 문제!
 */
public class Solution {
    class Node {
        int x;
        int y;
        Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    public int solution(int[][] maps) {
        int m = maps.length; int n = maps[0].length;
        int[][] visited = new int[m][n];
        for (int[] ints : visited) {
            Arrays.fill(ints, -1);
        }
        bfs(new Node(0,0),visited,maps);
        return visited[m-1][n-1];
    }

    public void bfs(Node node, int[][] visited, int[][] maps) {
        int[] dx = {0,1,0,-1};
        int[] dy = {-1,0,1,0};
        visited[0][0] = 1;
        Queue<Node> queue = new LinkedList<>();
        queue.add(node);

        while (!queue.isEmpty()) {
            Node n = queue.poll();

            for(int i=0; i<4; i++) {
                Node nextNode = new Node(n.x+dx[i],n.y+dy[i]);

                if(0<=nextNode.x && nextNode.x< maps[0].length && 0<=nextNode.y && nextNode.y <maps.length) {
                    if(visited[nextNode.y][nextNode.x] ==-1 && maps[nextNode.y][nextNode.x]==1) {
                        visited[nextNode.y][nextNode.x] = visited[n.y][n.x] + 1;
                        queue.add(nextNode);
                    }
                }
            }
        }
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] map={{1,0,1,1,1},{1,0,1,0,1},{1,0,1,1,1},{1,1,1,0,1},{0,0,0,0,1}};
        System.out.println(solution.solution(map));
    }
}
