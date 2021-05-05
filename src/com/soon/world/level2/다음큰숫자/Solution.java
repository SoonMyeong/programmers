package com.soon.world.level2.다음큰숫자;

/**
 *  문제 해결 과정
 *  1. 입력받은 값을 2진수 변환 및 1의 개수 계산 -> 1_1 하샤드_수와 비슷
 *  2. 입력받은 수에서 +1씩 증가하며 2진수 변환 및 1의 개수 계산 후 1번값과 비교
 *  3. 2의 결과가 동일 하면 리턴
 */
public class Solution {
    public int solution(int n) {
        int answer = 0;
        int originCnt = binaryOneCount(n);

        do {
            answer = ++n;
        } while (originCnt != binaryOneCount(answer));

        return answer;
    }
    public int binaryOneCount(int n){
        int quotient = n/2;
        int sum = n%2;
        while(quotient >0) {
            sum += quotient%2;
            quotient /= 2;
        }
        return sum;
    }
}
