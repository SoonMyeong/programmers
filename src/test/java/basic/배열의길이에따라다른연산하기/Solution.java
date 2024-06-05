package basic.배열의길이에따라다른연산하기;


import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;


public class Solution {
    @Test
    void 배열의_길이에따라_다른연산하기(){
        Assertions.assertThat(solution(new int[] {49,12,100,276,33},27))
                .isEqualTo(new int[] {76,12,127,276,60});

    }

    /*
        문제 : 배열의 길이에 따라 다른 연산하기
        https://school.programmers.co.kr/learn/courses/30/lessons/181854
        접근 방법 :
        배열 길이가 홀수면 짝수 자리에 n 만큼 더하고
        배열 길이가 짝수면 홀수 자리에 n 만큼 더하고..
        다른사람 풀이 :
        풀면서 이거 분명 로직 단순화한 결과물 있을거 같았는데 역시나 있었음
        시작 index 가 0이냐 1이냐를 길이가지고 판단하면 끝임
        for(int idx=arr.length%2==0?1:0; idx<arr.length; idx+=2) {
            arr[idx]+=n;
        }
     */
    public int[] solution(int[] arr, int n) {
        int len = arr.length;
        int[] answer = new int[len];

        if(len %2 == 0) {
            for(int i = 0; i<arr.length; i++) {
                if(i%2 != 0) {
                    answer[i] = arr[i] + n;
                }else {
                    answer[i] = arr[i];
                }
            }
        }else {
            for(int i = 0; i<arr.length; i++) {
                if(i%2 == 0) {
                    answer[i] = arr[i] + n;
                }else {
                    answer[i] = arr[i];
                }
            }
        }

        return answer;
    }
}
