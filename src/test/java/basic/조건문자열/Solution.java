package basic.조건문자열;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution {
    @Test
    void 조건문자열() {
        Assertions.assertThat(solution("<", "=", 20, 50)).isEqualTo(1);
        Assertions.assertThat(solution(">", "!", 41, 78)).isEqualTo(0);
    }

    /*
        문제 : 조건 문자열
        https://school.programmers.co.kr/learn/courses/30/lessons/181934

        접근방법>
         ineq : > or <
         eq : = or !
         총 4가지 조건이 나오는데 4가지 조건 분리만 하면 될거 같음

        베스트풀이 확인>
        다들 비슷함, 근데 좋아요 가장많이 받은 풀이는 신박하긴 함.
        BiFunction<Integer, Integer, Boolean> 을 이용한 방법임
        BiFunction 의 경우 순서대로 <입력타입1, 입력타입2, 리턴타입> 으로 구성된 functionalInterface 임 (function 의 확장 형태)
        (a,b) -> a>=b
        (a,b) -> a<=b
        (a,b) -> a>b
        (a,b) -> a<b
        이렇게 문제에서 나올 수 있는 4가지 조건에 대해 BiFunction 을 만들어놓고
        키값으로 ">=" ,">" , "<=", "<" 으로 설정한 Map 을 하나 만들어 놓고
        ineq+eq 로 해당하는 BiFunction 을 불러와서 적용시켜서 품
        -> functions.get(ineq + eq).apply(n, m) ? 1 : 0;
        그냥 BiFunction 연습 하고싶어서 이렇게 한거같은데.. 이게 젤 좋아요가 많다니...
     */
    public int solution(String ineq, String eq, int n, int m) {
        int answer = 0;

        if(ineq.equals("<")) {
            if(eq.equals("=")) {
                return n <= m ? 1 : 0;
            }
            if(eq.equals("!")) {
                return n < m ? 1 : 0;
            }
        }
        if(ineq.equals(">")) {
            if(eq.equals("=")) {
                return n >= m ? 1 : 0;
            }
            if(eq.equals("!")) {
                return n > m ? 1 : 0;
            }
        }

        return answer;
    }

}
