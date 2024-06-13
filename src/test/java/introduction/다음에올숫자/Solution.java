package introduction.다음에올숫자;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution {
    @Test
    void 다음에_올_숫자() {
        Assertions.assertThat(solution(new int[]{1,2,3,4})).isEqualTo(5);
        Assertions.assertThat(solution(new int[]{2,4,8})).isEqualTo(16);
    }

    /*
        문제 : 다음에 올 숫자
        https://school.programmers.co.kr/learn/courses/30/lessons/120924
        접근 방법 :
        이 문제는 등차수열인지 등비수열인지 규칙을 찾아야 한다.
        제한조건에서 무조건 등차 or 등비수열 이라고 제한해줬음.
        또한 공비가 0 인 등비수열은 없다고 제한 함.
        common 의 연속된 일부 원소를 가지고 차이를 보고 구해내면 되겠다.
        입출력 예를 가지고 한번 생각해보자.
        common : [1,2,3,4], 증가되는 값 : [1,1,1] = 값이 일정하다, 공차가 1인 등차수열
        common : [2,4,8] , 증가되는 값 : [2,4] = 값이 일정하지않다? 등비수열임.
        등비수열인게 확인 됐으니 2x = 4 , x = 2 공비가 2인 등비수열

        등차수열은 최초 원소들의 증가폭이 모두 일정하다.
        그렇지 않으면 등비수열이고 현재 값 / 이전값 으로 공비를 구할 수 있다.

        좋아요 많은 풀이 :
        똑같음
     */
    public int solution(int[] common) {
        int[] incrementValues = new int[common.length -1];

        for(int i = 0; i<2; i++) {
            incrementValues[i] = common[i+1] - common[i];
        }

        //등차니?
        if(incrementValues[0] == incrementValues[1]) {
            return common[common.length -1] + incrementValues[0];
        }

        return common[common.length -1] * (incrementValues[1] / incrementValues[0]);
    }
}
