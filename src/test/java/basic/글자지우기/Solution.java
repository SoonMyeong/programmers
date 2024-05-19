package basic.글자지우기;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Solution {
    @Test
    void 글자지우기() {
        Assertions.assertThat(solution("apporoograpemmemprs", new int[] {1, 16, 6, 15, 0, 10, 11, 3}))
                .isEqualTo("programmers");

    }

    /*
        문제 : 글자 지우기
        https://school.programmers.co.kr/learn/courses/30/lessons/181900

        접근방법:
        indices 배열에 해당하는 숫자를 가지고 매칭되는 my_string 의 index 를 제거하고
        이어붙이면 될 거 같음

        베스트풀이 확인:
        indices 배열에 있는 숫자를 가진 my_string 의 인덱스에 해당하는 값을 "" 로 바꾼다음
        다시 for 문 돌면서 합쳐주고 있음
        나처럼 contains 메서드 쓴사람 없나 찾아보니까 hashSet 으로 만들어서 추가한 사람 발견
     */
    public String solution(String my_string, int[] indices) {
        List<Integer> indexList = Arrays.stream(indices)
                .boxed()
                .collect(Collectors.toList());
        String answer = "";

        for(int i = 0; i<my_string.length(); i++) {
            if(!indexList.contains(i)) {
                answer += my_string.charAt(i);
            }
        }

        return answer;
    }
}
