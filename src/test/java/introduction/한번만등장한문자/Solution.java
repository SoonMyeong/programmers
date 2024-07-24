package introduction.한번만등장한문자;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.stream.Collectors;

public class Solution {
    @Test
    void 한번만등장한문자() {
        Assertions.assertThat(solution("hello")).isEqualTo("eho");
    }

    /*
        문제 : 한 번만 등장한 문자
        https://school.programmers.co.kr/learn/courses/30/lessons/120896
        접근 방법 :
        알파벳이 몇개나왓는지 체크해야되니까.. Map 자료구조 쓰고..
        1개인 알파벳들만 빼서 arr 정렬하고 String 으로 만들기

        좋아요 많은 풀이 :
        int[] alpha = new int[26];
        for(char c : s.toCharArray()){
            alpha[c - 'a']++;
        }
        이런식으로 map 대신 alpha 라는 알파벳 자리를 모두 가지는 배열을 둬서 계산했음.
     */
    public String solution(String s) {
        Map<String, Integer> map = new HashMap<>();
        List<String> list = new ArrayList<>();
        for(String str : s.split("")) {
            map.put(str, map.getOrDefault(str, 0) + 1);
        }
        for(String str : map.keySet()) {
            if(map.get(str) == 1) {
                list.add(str);
            }
        }
        List<String> collect = list.stream()
                .sorted()
                .collect(Collectors.toList());

        return String.join("", collect);
    }
}
