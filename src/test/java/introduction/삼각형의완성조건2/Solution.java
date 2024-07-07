package introduction.삼각형의완성조건2;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution {
    @Test
    void 삼각형의_완성조건_2() {
        Assertions.assertThat(solution(new int[] {1,2})).isEqualTo(1);
        Assertions.assertThat(solution(new int[] {3,6})).isEqualTo(5);
        Assertions.assertThat(solution(new int[] {11,7})).isEqualTo(13);
    }

    /*
        문제 : 삼각형의 완성조건 2
        https://school.programmers.co.kr/learn/courses/30/lessons/120868
        접근 방법 :
        일단 문제가 아주 불친절함 -_-
        입출력 예만 가지고는 추론해낼 수가 없음. 분명 수학적 법칙이 있을거라 생각하고 검색 해봄
        찾아낸 삼격형의 성립 조건
        삼각형 세 변의 길이를 a,b,c 라 할 때
        1. a + b > c (condition One)
        2. a + c > b (condition Two)
        3. b + c > a (condition Three)
        위 3가지 조건을 만족해야 함. 이걸 미리 알려줬어야지
        여기서 두변의 길이는 sides 배열로 주어지니까 나머지 하나를 x 변수로 두고 x의 범위값을 찾아내서 개수를 뽑아내면 됨.

        좋아요 많은 풀이 :
        다양한 풀이법이 있는데 삼각형 성립 조건만 알면 그냥 풀리는 문제임..
     */
    public int solution(int[] sides) {
        int answer = 0;
        int a = Math.min(sides[0], sides[1]);
        int b = Math.max(sides[0], sides[1]);
        int conditionOne = a + b;
        int conditionTwo = b - a;

        for(int i = conditionTwo + 1; i < conditionOne; i++) {
            answer++;
        }

        return answer;
    }
}
