package introduction.A로B만들기;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    @Test
    void A로B만들기() {
        Assertions.assertThat(solution("olleh", "hello"));
    }

    /*
        문제 : A로 B 만들기
        https://school.programmers.co.kr/learn/courses/30/lessons/120886
        접근 방법 :
        사용된 알파벳과 개수가  before, after 동일하면 만들 수 있음
        알파벳과 개수를 저장하고 있어야하니 Map 자료구조를 이용해봄

        좋아요 많은 풀이 :
        오~ 두개 charArray 로 만들어서 오름차순 정렬한다음 두 문자열 같은지 비교함

     */
    public int solution(String before, String after) {
        Map<String, Integer> map = new HashMap<>();
        for(String str : after.split("")) {
            map.put(str, map.getOrDefault(str, 0) + 1);
        }

        for(String str : before.split("")) {
            if(map.containsKey(str) && map.get(str) > 0) {
                map.put(str, map.get(str) -1);
            }else {
                return 0;
            }
        }
        return 1;
    }

}
