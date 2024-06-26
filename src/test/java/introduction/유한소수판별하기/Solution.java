package introduction.유한소수판별하기;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    @Test
    void 유한소수_판별하기() {
        Assertions.assertThat(solution(7,20)).isEqualTo(1);
        Assertions.assertThat(solution(11,22)).isEqualTo(1);
        Assertions.assertThat(solution(12,21)).isEqualTo(2);
    }

    /*
        문제 : 유한소수 판별하기
        https://school.programmers.co.kr/learn/courses/30/lessons/120878

        접근 방법 :
        일단 이 문제.. 유한소수가 뭔지 모르거나 소인수분해 하는 방법을 모르면 문제를 풀 수 없다
        유한소수 조건의 경우 다행히 조건에 주어진다.
        (유한소수 조건 : 기약분수로 나타내었을 때, 분모의 소인수가 2와 5만 존재해야 한다.)
        소인수분해 하는 방법은 가장작은 소수인 2로 먼저 나누고 그 몫에 대해
        다음 소수인 3으로 나누고.. 그다음 소수인 5로 나누고.. 몫이 1이 될 때 까지 반복하면 된다.
        (소수는 약수가 1과 나 자신 밖에 없는 수를 소수라고 한다.)

        1. a/b 일 때 최대한 약분한다.
        -> a와 b의 최대공약수로 나누게 되면 한번에 기약분수가 된다.
        2. 분모 b 에 대해 소인수 분해를 한다.
        3. 소인수분해한 결과값에 2,5 외에 다른 숫자가 존재하면 무한소수, 아니면 유한소수 이다.

        다른사람 풀이 :
        기약분수로 만든 후 2로 나눈 나머지가 0이 아닐때 까지 나누고
        5로 나눈 나머지가 0이 아닐때 까지 나눳을 때 결과가 1이면 유한소수고
        아니면 무한소수로 풀이함
        while (b != 1) {
            if (b % 5 == 0) {
                b /= 5;
                continue;
            }
            if (b % 2 == 0) {
                b /= 2;
                continue;
            }
            return 2;
        }
        return 1;
     */
    public int solution(int a, int b) {
        int fraction = b / gcd(a, b);
        for(int num : primeFactorization(fraction)) {
            if( num != 2 && num != 5) {
                return 2;
            }
        }
        return 1;
    }

    private Set<Integer> primeFactorization(int fraction) {
        Set<Integer> set = new HashSet<>();
        for(int i = 2 ; i<=fraction; i++) {
            if(isPrime(i) && fraction % i == 0) {
                set.add(i);
            }
        }
        return set;
    }

    private boolean isPrime(int n) {
        if(n == 2) {
            return true;
        }
        for(int i = 2; i<= Math.sqrt(n); i++) {
            if(n % i == 0) {
                return false;
            }
        }
        return true;
    }

    private int gcd(int num1, int num2) {
        if (num1 % num2 == 0) {
            return num2;
        }
        return gcd(num2, num1 % num2);
    }
}
