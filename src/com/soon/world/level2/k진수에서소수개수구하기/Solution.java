package com.soon.world.level2.k진수에서소수개수구하기;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * 양의 정수 n이 주어집니다. 이 숫자를 k진수로 바꿨을 때, 변환된 수 안에 아래 조건에 맞는 소수(Prime number)가 몇 개인지 알아보려 합니다.
 *
 * 0P0처럼 소수 양쪽에 0이 있는 경우
 * P0처럼 소수 오른쪽에만 0이 있고 왼쪽에는 아무것도 없는 경우
 * 0P처럼 소수 왼쪽에만 0이 있고 오른쪽에는 아무것도 없는 경우
 * P처럼 소수 양쪽에 아무것도 없는 경우
 * 단, P는 각 자릿수에 0을 포함하지 않는 소수입니다.
 * 예를 들어, 101은 P가 될 수 없습니다.
 * 예를 들어, 437674을 3진수로 바꾸면 211020101011입니다.
 * 여기서 찾을 수 있는 조건에 맞는 소수는 왼쪽부터 순서대로 211, 2, 11이 있으며, 총 3개입니다. (211, 2, 11을 k진법으로 보았을 때가 아닌, 10진법으로 보았을 때 소수여야 한다는 점에 주의합니다.)
 * 211은 P0 형태에서 찾을 수 있으며, 2는 0P0에서, 11은 0P에서 찾을 수 있습니다.
 *
 * 정수 n과 k가 매개변수로 주어집니다. n을 k진수로 바꿨을 때, 변환된 수 안에서 찾을 수 있는 위 조건에 맞는 소수의 개수를 return 하도록 solution 함수를 완성해 주세요.
 *
 *   n	    k	result
 * 437674	3	3
 * 110011	10	2
 *
 *
 * [생각 정리]
 * 0을 만날때까지 읽다가 0만나면 이전까지 읽었던 숫자가 소수인지 확인
 *    - 소수면 위 조건에 맞는지 확인
 *
 *
 *  이 문제의 핵심은 결국 소수 구할때 루트값 까지만 구해서 구하는지가 핵심..
 *  문제 이해를 잘못함
 *
 *
 *
 */
public class Solution {

    public int solution(int n, int k) {
        int answer = 0;
        StringBuilder sb = new StringBuilder();

        while(n/k !=0) {
            sb.insert(0,n%k);
            n = n/k;
        }
        sb.insert(0,n);

        String jinsu = sb.toString();
        long temp = 0;

        for(int i=0; i<jinsu.length(); i++) {
            char c = jinsu.charAt(i);

            if(c == '0') {
                if(temp !=0 && check_prime(temp)) {
                    answer++;
                }
                temp = 0L;
            }else {
              temp = temp * 10 + c - '0';
            }
        }

        //Check 0P ..
        if(temp % 10 != 0L && check_prime(temp)) {
            answer++;
        }


        return answer;
    }

    private boolean check_prime(long num) {
        if(num == 1 ) {
            return false;
        }

        int sqrt = (int) Math.sqrt(num);

        for(int i=2; i<=sqrt; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution(437674,3));
    }
}
