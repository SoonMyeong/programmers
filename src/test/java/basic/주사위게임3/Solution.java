package basic.주사위게임3;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution {
    @Test
    void 주사위게임3() {
        Assertions.assertThat(solution(2,2,2,2)).isEqualTo(2222);
        Assertions.assertThat(solution(4,1,4,4)).isEqualTo(1681);
        Assertions.assertThat(solution(6,3,3,6)).isEqualTo(27);
        Assertions.assertThat(solution(2,5,2,6)).isEqualTo(30);
        Assertions.assertThat(solution(6,4,2,5)).isEqualTo(2);
        Assertions.assertThat(solution(1,1,4,1)).isEqualTo(196);
        Assertions.assertThat(solution(4,2,5,5)).isEqualTo(8);
    }


    /*
    문제 : 주사위 게임3
    https://school.programmers.co.kr/learn/courses/30/lessons/181916

    접근방법>
    설명 그대로 구현
    주사위 4개 모두 같을 때 (isFourNumberEquals)
    주사위 3개 모두 같을 때 (isThreeNumberEquals)
    주사위 2개씩 같은 값 나올 때 (isTwoNumberEquals)
    주사위 2개는 같고 나머지 2개는 다를 때 (isOnlyTwoNumberEquals)
    주사위 4개 모두 다를 때 (isNotEqualsNumbers)

    답안확인>
    단순한 풀이를 확인 해 보니 배열을 정렬 후 계산 시 로직이 단순해진다.
    why? 똑같은 값이 존재하는 케이스를 범위로 지정 가능 해짐.
    ex)
    4개 같을 경우 : index[0] == index[3]
    3개 같을 경우 : index[0] == index[2] || index[1] == index[3]
    2개,1개 같을 경우는 지금 내 풀이와 비슷

   */
    int solution(int a, int b, int c, int d) {
        if(a == b && b == c && c == d){
            return 1111 * a;
        }

        if(isThreeNumberEquals(a,b,c,d)) {
            return calculateEqualsThreeNumber(a, b, c, d);
        }

        if(isTwoNumberEquals(a,b,c,d)) {
            return calculateEqualsTwoNumber(a, b, c, d);
        }

        if(isOnlyTwoNumberEquals(a,b,c,d)) {
            return calculateEqualsOnlyTwoNumber(a, b, c, d);
        }

        return Math.min(d,Math.min(Math.min(a,b), c));
    }

    private int calculateEqualsOnlyTwoNumber(int a, int b, int c, int d) {
        int q = 0;
        int r = 0;
        if(a == b) {
            q = c;
            r = d;
        }
        if(a == c) {
            q = b;
            r = d;
        }
        if(a == d) {
            q = b;
            r = c;
        }
        if(b == c) {
            q = a;
            r = d;
        }
        if(b == d) {
            q = a;
            r = c;
        }
        if(c == d) {
            q = a;
            r = b;
        }
        return q * r;
    }

    private boolean isOnlyTwoNumberEquals(int a, int b, int c, int d) {
        return (a==b) || (a==c) || (a==d) || (b==c) || (b==d) || (c==d);
    }

    private int calculateEqualsTwoNumber(int a, int b, int c, int d) {
        int p = 0;
        int q = 0;
        if(a == b && c == d && a!=c) {
            p = a;
            q = c;
        }
        if(a == c && b == d && a!=b) {
            p = a;
            q = b;
        }
        if(a == d && b == c && a!=b) {
            p = a;
            q = b;
        }
        return (p + q) * Math.abs(p - q);
    }

    private boolean isTwoNumberEquals(int a, int b, int c, int d) {
        return (a==b && c==d) || (a==c && b==d) || (a==d && b==c);
    }

    private int calculateEqualsThreeNumber(int a, int b, int c, int d) {
        int p  = 0;
        int q = 0;

        if(a == b && b == c) {
            p = a;
            q = d;
        }
        if(a == c && c == d) {
            p = a;
            q = b;
        }
        if(b == c && c == d) {
            p = b;
            q = a;
        }
        if(a == b && b == d) {
            p = a;
            q = c;
        }
        return (int) Math.pow(10 * p + q, 2);
    }

    private boolean isThreeNumberEquals(int a, int b, int c, int d) {
        return (a == b && b == c) || (a == b && b == d) || (a == c && c == d) || (b == c && c == d);
    }

}
