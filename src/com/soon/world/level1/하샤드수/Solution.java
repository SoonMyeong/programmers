package com.soon.world.level1.하샤드수;

/**
 *  문제 해결 과정
 *  근데 하샤드 수 라는게 수학에서 나온 말일테니 수학적으로? 접근!
 *  코드 작성 간 다소 실수 (sum%x 하는 등..)가 조금 있었지만 해결
 */
class Solution {
    public boolean solution(int x) {
        int quotient = x/10;
        int sum = x%10;

        while(quotient>0){
            sum += quotient%10;
            quotient /= 10;
        }

        return (x % sum == 0);
    }
}
