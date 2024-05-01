package basic.문자개수세기;


import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution {
    @Test
    void 문자개수세기() {
        Assertions.assertThat(solution("Programmers"))
                .isEqualTo(new int[] {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0,
                        0, 0, 1, 0, 0, 0, 1, 0, 1, 0, 0, 0, 0, 0, 2, 0, 1, 0, 0, 3, 1, 0, 0, 0, 0, 0, 0, 0});

    }


    /*
        문제: 문자개수세기
        https://school.programmers.co.kr/learn/courses/30/lessons/181902

        접근방법>
        문자열에서 알파밧을 종류별로 몇개씩 존재하는지 구하는 문제인데,
        배열 원소 자리가 순서대로 A-z 까지로 고정해놨으니
        예를들어 A 일 때 배열 0번째 인덱스 자리 값 추가! 이렇게 설정만 하면 끝남.
        알파벳에 매핑된 숫자의 경우 우리에겐 아스키코드가 있다 ㅎㅎ
        이를 활용해볼 예정
        A-Z : 아스키코드 65 ~ 90
        a-z : 아스키코드 97 ~ 122

        베스트풀이 확인>
        다들 아스키코드를 활용하긴 함, 근데 내 코드는 매직변수에 이름 안지어주면
        그 값이 의미하는바를 한눈에 알아보긴 어려움. (풀면서 알파벳 개수 헤깔려서 실수나왔었음)
        if(c >= 'a')
            answer[c - 'a' + 26]++;
        else
            answer[c - 'A']++;

        이 방식이 더 좋은거 같다.
     */
    public int[] solution(String my_string) {
        int[] answer = new int[52];

        for (char c : my_string.toCharArray()) {
            int tempCount = c - 65;
            if(tempCount > 25) {
                int upperCount = c - 71;
                answer[upperCount]++;
            }else {
                answer[tempCount]++;
            }
        }

        return answer;
    }
}
