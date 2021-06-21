package com.soonworld.java;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class Solution {

    class Node{
        int x;
        int y;
        int depth;

        Node(int x, int y, int depth){
            this.x = x;
            this.y = y;
            this.depth = depth;
        }
    }
    private static final String RIGHT = "right";

    public String solution(int[] numbers, String hand) {
        String answer = "";
        Map<Integer,Integer> leftKeyPad = new HashMap<>();
        Map<Integer,Integer> rightKeyPad = new HashMap<>();
        int leftHand = -1;
        int rightHand = -1;

        leftKeyPad.put(1,1);
        leftKeyPad.put(4,1);
        leftKeyPad.put(7,1);

        rightKeyPad.put(3,1);
        rightKeyPad.put(6,1);
        rightKeyPad.put(9,1);

        for(int i=0; i<numbers.length; i++) {
            if(leftKeyPad.containsKey(numbers[i]))  {
                answer +="L";
                leftHand = numbers[i];
            }else if(rightKeyPad.containsKey(numbers[i])) {
                answer += "R";
                rightHand = numbers[i];
            }else {
                if(calculate(leftHand,numbers[i]) > calculate(rightHand,numbers[i])) {
                    answer += "R";
                    rightHand = numbers[i];
                }else if (calculate(leftHand,numbers[i]) < calculate(rightHand,numbers[i])) {
                    answer +="L";
                    leftHand = numbers[i];
                }else {
                    if(hand.equals(RIGHT)) {
                        answer += "R";
                        rightHand = numbers[i];
                    }else {
                        answer +="L";
                        leftHand = numbers[i];
                    }
                }
            }
        }

        return answer;
    }

    public int calculate(int start, int end) {
        Queue<Node> queue = new LinkedList<>();
        int[][] arr = {{1,2,3},{4,5,6},{7,8,9},{-1,0,-1}};
        boolean[][] visited = new boolean[4][3];
        int cnt = 0;
        int endX = 0;
        int endY = 0;

        for(int i=0; i<4; i++) {
            for(int j=0; j<3; j++) {
                if(arr[i][j]==start) {
                    queue.add(new Node(i,j,0));
                }
                if(arr[i][j]==end) {
                    endX = i;
                    endY = j;
                }
            }
        }

        while(!queue.isEmpty()) {
            Node node = queue.poll();
            visited[node.x][node.y] = true;
            if(visited[endX][endY]) {
                cnt = node.depth;
                break;
            }
            //위
            if(node.x-1>=0 && node.x<4 && !visited[node.x-1][node.y]) {
                queue.add(new Node(node.x-1,node.y,node.depth+1));
            }
            //오른
            if(node.y+1 >=0 && node.y+1 <3 && !visited[node.x][node.y+1]) {
                queue.add(new Node(node.x,node.y+1,node.depth+1));
            }
            //아래
            if(node.x+1 >=0 && node.x+1<4 && !visited[node.x+1][node.y]) {
                queue.add(new Node(node.x+1,node.y,node.depth+1));
            }
            //왼
            if(node.y-1 >=0 && node.y <3 && !visited[node.x][node.y-1]) {
                queue.add(new Node(node.x,node.y-1,node.depth+1));
            }
        }

        return cnt;
    }



    public static void main(String[] args) {
        Solution solution = new Solution();
        int [] numbers = {1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5};
        String hand  = "right";
        System.out.println(solution.solution(numbers,hand));
    }
}
