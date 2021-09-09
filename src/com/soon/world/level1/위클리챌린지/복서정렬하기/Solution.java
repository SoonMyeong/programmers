package com.soon.world.level1.위클리챌린지.복서정렬하기;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Solution {

    class Player {
        int idx;
        int weight;
        double winRate;
        int winCount;

        Player(int idx, int weight, double winRate, int winCount) {
            this.idx = idx;
            this.weight = weight;
            this.winRate = winRate;
            this.winCount = winCount;
        }

        @Override
        public String toString() {
            return "Player{" +
                    "idx=" + idx +
                    ", weight=" + weight +
                    ", winRate=" + winRate +
                    ", winCount=" + winCount +
                    '}';
        }
    }

    public int[] solution(int[] weights, String[] head2head) {
        int[] answer = {};
        List<Player> list = new ArrayList<>();
        for(int i=0; i<weights.length; i++) {
            String[] head = head2head[i].split("");
            int count = 0;
            int winCount = 0;
            for(int j=0; j<head.length; j++) {
                if(head[j].equals("W")) {
                    count++;
                    if(weights[i]<weights[j]) {
                        winCount++;
                    }
                }
            }
            double winRate = Double.parseDouble(String.format("%.2f",(double) count/(head.length-1)));

            list.add(new Player(i+1,weights[i],winRate,winCount));
        }
        
        return answer;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] weights = {50,82,75,120};
        String[] head2head = {"NLWL","WNLL","LWNW","WWLN"};

        System.out.println(Arrays.toString(solution.solution(weights, head2head)));
    }
}
