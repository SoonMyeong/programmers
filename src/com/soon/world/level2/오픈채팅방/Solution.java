package com.soon.world.level2.오픈채팅방;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    class Member {
        String id;
        String nickname;
        String word;
        public Member(String word, String id, String nickname) {
            this.word = word;
            this.id = id;
            this.nickname = nickname;
        }

        public String getNickname() {
            return nickname;
        }
        public String getId() {
            return id;
        }
        public String getWord() {
            return word;
        }
        public void setNickname(String nickname) {
            this.nickname = nickname;
        }
    }
    public String[] solution(String[] record) {
        List<String> result = new ArrayList<>();
        List<Member> answer = new ArrayList<>();

        for(String str : record) {
            String[] subStr = str.split(" ");

            if(subStr[0].equals("Enter")) {
                for(Member m : answer) {
                    if(m.getId().equals(subStr[1])) {
                        m.setNickname(subStr[2]);
                    }
                }
                answer.add(new Member(subStr[0],subStr[1],subStr[2]));
            }
            if(subStr[0].equals("Leave")) {
                String nickname = "";
                for(Member m : answer) {
                    if(m.getId().equals(subStr[1])) {
                        nickname = m.nickname;
                        break;
                    }
                }
                answer.add(new Member(subStr[0],subStr[1],nickname));
            }
            if(subStr[0].equals("Change")) {
                for(Member m : answer) {
                    if(m.getId().equals(subStr[1])) {
                        m.setNickname(subStr[2]);
                    }
                }
            }

        }

        for(Member m : answer) {
            if(m.getWord().equals("Enter")) {
                result.add(m.nickname+"님이 들어왔습니다.");
            }
            if(m.getWord().equals("Leave")) {
                result.add(m.nickname+"님이 나갔습니다.");
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
