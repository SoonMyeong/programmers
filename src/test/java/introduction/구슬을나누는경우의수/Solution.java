package introduction.구슬을나누는경우의수;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigInteger;

public class Solution {
    @Test
    void 구슬을_나누는_경우의수() {
        Assertions.assertThat(solution(3, 2)).isEqualTo(3);
        Assertions.assertThat(solution(5, 3)).isEqualTo(10);
        Assertions.assertThat(solution(5, 3)).isEqualTo(10);
    }

    /*
        문제 : 구슬을 나누는 경우의 수
        https://school.programmers.co.kr/learn/courses/30/lessons/120840
        접근 방법:
        조합에 대한 문제, 힌트에 수식까지 알려주므로
        그 수식을 그대로 대입해서 풀어본다.
        근데 숫자범위가 너무 커서.. 이럴때 대표적으로 숫자 줄이는 값인 1_000_000_007 를 사용해서
        팩토리얼 계산 할 때마다 mod 값으로 나눈 나머지들로 가지고 계산해서 풀었음
        BigInteger 를 이렇게까지 다뤄본건 처음임;

        좋아요 많은 풀이 :
        대부분 리턴타입을 long 으로 바꿔서 품
        int 로 풀어낼라면 매번 계산할 때마다 저장공간을 줄이기 위한 나누기작업을 해야할 듯
        결국 이 문제의 의도는 자료형 범위를 넘어서는 예외를 어떻게 해결할 것인가.. 뭐 이런게 아니려나 싶음
     */
    public int solution(int balls, int share) {
        if(balls - share == 0) {
            return 1;
        }
        BigInteger convertBalls = BigInteger.valueOf(balls);
        BigInteger convertShare = BigInteger.valueOf(share);
        BigInteger convertBallsMinusShare = BigInteger.valueOf(balls-share);

        BigInteger mod = BigInteger.valueOf(1_000_000_007);

        BigInteger ballFactoial = factorial(convertBalls).mod(mod);
        BigInteger nMinusShareFactorial = factorial(convertBallsMinusShare).mod(mod);
        BigInteger shareFactorial =  factorial(convertShare).mod(mod);
        BigInteger bunmo = nMinusShareFactorial.multiply(shareFactorial).mod(mod);

        return ballFactoial.multiply(bunmo.modInverse(mod)).mod(mod).intValue();
    }

    private BigInteger factorial(BigInteger num) {
        if(num.intValue() == 1) {
            return BigInteger.ONE;
        }
        return num.multiply(factorial(num.subtract(BigInteger.ONE)));
    }
}
