package com.soon.world.level1.다트게임;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public int solution(String dartResult) {
        int answer = 0;
        int num = 0;
        boolean tenNum = false;
        List<Integer> arr = new ArrayList<>();

        for(char ch : dartResult.toCharArray()) {
            if('0'<= ch && ch <='9'){
                arr.add(num);
                if(ch=='1') {
                    tenNum = true;
                }
                if (ch=='0'){
                  if(tenNum) {
                      num = 10;
                      arr.remove(arr.size()-1);
                      continue;
                  }
                }
                num = Integer.parseInt(String.valueOf(ch));
            }
            if(ch =='S' || ch == 'D' || ch == 'T') {
                tenNum = false;
                num = powBonus(num,ch);
            }
            if(ch=='*' || ch=='#') {
                tenNum = false;
                num = addOptions(num,ch,arr);
            }
        }
        arr.add(num); // 마지막 값

        for(int a : arr) {
            answer += a;
        }

        return answer;
    }

    private int addOptions(int num, char ch, List<Integer> arr) {
        if(ch=='*') {
            if (arr.size() >= 1) {
                int tmp = arr.get(arr.size() - 1);
                arr.remove(arr.size() - 1);
                arr.add(tmp * 2);
            }
            return num * 2;
        }else {
            return num * -1;
        }
    }

    private int powBonus(int num, char ch) {
        if(ch=='S') {
            return (int) Math.pow(num,1);
        }else if(ch =='D') {
            return (int) Math.pow(num,2);
        }else {
            return (int) Math.pow(num,3);
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
//        String dartResult = "1S2D*3T";
//        String dartResult = "1D2S#10S";
        String dartResult = "1D2S0T";
        System.out.println(solution.solution(dartResult));
    }
}
