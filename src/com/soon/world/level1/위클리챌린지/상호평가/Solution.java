package com.soon.world.level1.위클리챌린지.상호평가;


public class Solution {

    public String solution(int[][] scores) {
        String answer = "";

        for(int i=0; i<scores.length; i++) {
            int [] scoreList = new int[scores.length];
            for(int j=0; j<scores.length; j++) {
                scoreList[j] = scores[j][i];
            }
            answer += calculateScore(i,scoreList);
        }

        return answer;
    }

    public String calculateScore(int col,int[] scoreList) {
        int sum = 0;
        double avg = 0;
        int max = 0;
        int maxCount = 0;
        int min = Integer.MAX_VALUE;
        int minCount = 0;
        int tmp =scoreList[col];
        int quotient = scoreList.length;

        for(int i=0; i<scoreList.length; i++) {
            if(max<=scoreList[i]) {
                max = scoreList[i];
            }
            if(min>=scoreList[i]) {
                min = scoreList[i];
            }
            sum += scoreList[i];
        }

        for(int i : scoreList) {
            if(max==i){
                maxCount++;
            }
            if(min==i) {
                minCount++;
            }
        }


        if((max==tmp && maxCount==1) || (min==tmp && minCount==1) ){
            sum -= tmp;
            quotient--;
        }

        avg = (double) sum/quotient;

        if(avg >=90) {
            return "A";
        }else if(avg>=80) {
            return "B";
        }else if(avg>=70) {
            return "C";
        }else if(avg>=50) {
            return "D";
        }else {
            return "F";
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] scores = {{100,90,98,88,65}
                ,{50,45,99,85,77}
                ,{47,88,95,80,67}
                ,{61,57,100,80,65}
                ,{24,90,94,75,65}};
        System.out.println(solution.solution(scores));
    }
}
