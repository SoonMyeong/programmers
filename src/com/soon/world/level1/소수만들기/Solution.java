package com.soon.world.level1.소수만들기;
/**
 * 문제 해결 과정
 * 1. 서로 다른 3개의 수를 골라 더하면 소수가 되는 경우
 * 1.1. 소수 인지 확인 하는 방법 :
 * 2. 3중 포문돌려 모든 경우의 수 확인
 * 3. i+j+k 합이 소수이면 count 증가
 */
class Solution {
    public int solution(int[] nums) {
        int answer = 0;

        for(int i=0; i<nums.length-2; i++){
            for(int j=i+1; j<nums.length-1; j++){
                for(int k=j+1; k<nums.length; k++){
                    if(checkPrime(nums[i]+nums[j]+nums[k])){
                        answer++;
                    }
                }
            }
        }

        return answer;
    }
    public boolean checkPrime(int num){
        for(int i=2; i*i<=num; i++){
            if(num %i ==0)
                return false;
        }
        return true;
    }
}