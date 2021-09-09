package com.soon.world.level1.위클리챌린지.복서정렬하기;

import java.util.ArrayList;
import java.util.Arrays;
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
        int[] answer = new int[weights.length];
        List<Player> list = new ArrayList<>();
        for(int i=0; i<weights.length; i++) {
            String[] head = head2head[i].split("");
            int count = 0;
            int winCount = 0;
            int nCount = 0;
            int lCount = 0;
            double winRate = 0;
            for(int j=0; j<head.length; j++) {
                if(head[j].equals("W")) {
                    count++;
                    if(weights[i]<weights[j]) {
                        winCount++;
                    }
                }
                if(head[j].equals("L")) {
                    lCount++;
                }
                if(head[j].equals("N")) {
                    nCount++;
                }
            }
            if(nCount==head.length) {
                winRate = 0;
            }else {
                winRate =  (double) count / (count+lCount);
            }
            System.out.println(winRate);

            list.add(new Player(i+1,weights[i],winRate,winCount));
        }
        list.sort((o1, o2) -> {
            if(o1.winRate!=o2.winRate) {
                return Double.compare(o2.winRate, o1.winRate);
            }
            if(o1.winCount!=o2.winCount) {
                return o2.winCount - o1.winCount;
            }
            if(o1.weight != o2.weight) {
                return o2.weight - o1.weight;
            }
            if(o1.idx != o2.idx) {
                return o1.idx - o2.idx;
            }
            return 0;
        });

        for(int i=0; i<list.size(); i++) {
            answer[i] = list.get(i).idx;
        }

        return answer;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
//        int[] weights = {50,82,75,120};
//        String[] head2head = {"NLWL","WNLL","LWNW","WWLN"};
        int[] weights = {145,92,86};
        String[] head2head = {"NLW","WNL","LWN"};

        System.out.println(Arrays.toString(solution.solution(weights, head2head)));
    }
}
