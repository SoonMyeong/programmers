package com.soon.world.level1.완주하지못한선수;

import java.util.HashMap;

/**
 * 문제 해결 과정 ( 해시 문제 ??) -> sort 로 해결함
 * 1. 각각의 배열을 오름차순 정렬 해둔 상태로 진행하여 for 문을 1번만 돌게끔 함
 * 2. 정렬 했을 때 completion 배열에 없으며 participant 마지막 인덱스에 값이 존재할 수 있다.
 * ---
 * 해시로도 풀어보자 , 풀이 자체는 어렵지 않은거 같다. 그래서 레벨1이겠지
 */
public class Solution {

    public String solution(String[] participant, String[] completion) {
       String answer = "";
       HashMap<String,Integer> map = new HashMap<>();
       for(String user : participant) {
            map.put(user,map.getOrDefault(user,0)+1);
       }
       for(String user : completion) {
           map.put(user,map.get(user)-1); //경주 완료된 유저는 -1로 빼준다.
       }

       //결국 map 을 순회하면서 key 값이 0 이 아닌 값이 있다면..? 완주 못한거지
       for(String key : map.keySet()){
           if(map.get(key)!=0){
               answer = key;
           }
       }

       return answer;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String [] part = {"leo","kiki","eden"};
        String [] comp = {"eden","kiki"};

        System.out.println(solution.solution(part,comp));
    }
}
