package com.soon.world.level2.오픈채팅방;

import java.util.*;

public class Solution {

    public String[] solution(String[] record) {
        List<String> result = new ArrayList<>();
        Map<String,String> map = new HashMap<>();

        for(String str : record) {
            String[] subStr = str.split(" ");

            if(subStr[0].equals("Enter") || subStr[0].equals("Change") ) {
                map.put(subStr[1],subStr[2]);
            }
        }

        for(String str : record) {
            String[] subStr = str.split(" ");

            if(subStr[0].equals("Enter")) {
                result.add(map.get(subStr[1])+"님이 들어왔습니다.");
            }
            if(subStr[0].equals("Leave")) {
                result.add(map.get(subStr[1])+"님이 나갔습니다.");
            }
        }

        return result.stream().toArray(String[]::new);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String[] record = {"Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"};
        System.out.println(Arrays.toString(solution.solution(record)));
    }
}
