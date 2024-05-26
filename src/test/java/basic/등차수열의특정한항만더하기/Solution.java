package basic.등차수열의특정한항만더하기;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;


public class Solution {
    @Test
    void 등차수열의_특정한_항만_더하기() {
        Assertions.assertThat(solution(3,4, new boolean[] {true,false,false,true,true})).isEqualTo(37);
        Assertions.assertThat(solution(7,1, new boolean[] {false,false,false,true,false,false,false})).isEqualTo(10);
    }

    /*
        문제 : 등차수열의 특정한 항만 더하기
        https://school.programmers.co.kr/learn/courses/30/lessons/181931

        접근 방법 :
        등차수열이므로 식을 구해보면 dN + a 가 된다.
        N에 해당하는 값이 included 배열의 인덱스가 되며 값이 true 인 인덱스들만 모아서
        N에 인덱스를 대입하여 나온 숫자들의 합을 구하면 된다.

        베스트풀이 확인 :
        동일
     */
    public int solution(int a, int d, boolean[] included) {
        int answer = 0;
        for(int i = 0; i<included.length; i++) {
            if(included[i]){
                answer += (d * i) + a;
            }
        }
        return answer;
    }

}
