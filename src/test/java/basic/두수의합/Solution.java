package basic.두수의합;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigInteger;

public class Solution {
    @Test
    void 두수의합() {
        Assertions.assertThat(solution("18446744073709551615",  "287346502836570928366"))
                .isEqualTo("305793246910280479981");
    }

    /*
        문제: 두수의 합
        https://school.programmers.co.kr/learn/courses/30/lessons/181846

        접근방법>
            자리수가 많아보이니 고민없이 BigInteger 나 BigDecimal 쓰면 될거 같음.
            근데 정수니까 BigInteger 사용
        베스트풀이 확인>
            동일
     */
    public String solution(String a, String b) {
        BigInteger n1 = new BigInteger(a);
        BigInteger n2 = new BigInteger(b);
        return n1.add(n2).toString();
    }
}
