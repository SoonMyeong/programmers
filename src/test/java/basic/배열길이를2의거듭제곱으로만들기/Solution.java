package basic.배열길이를2의거듭제곱으로만들기;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution {
    @Test
    void 배열길이를_2의_거듭제곱으로_만들기() {
        Assertions.assertThat(solution(new int[]{1,2,3,4,5,6}))
                .isEqualTo(new int[] {1,2,3,4,5,6,0,0});
        Assertions.assertThat(solution(new int[]{58, 172, 746, 89}))
                .isEqualTo(new int[] {58, 172, 746, 89});
    }

    /*
        문제 : 배열길이를 2의 거듭제곱으로 만들기
        https://school.programmers.co.kr/learn/courses/30/lessons/181857

        문제접근 :
        arr 의 길이가 2의 거듭제곱인지 확인하고 arr 의 길이가 2의 거듭제곱이면 그대로 리턴
        거듭제곱 아니면 arr 의 현재 길이와 가장 가까운 다음 2의 거듭제곱이 몇인지 구해내는게 키 포인트 임
        제한사항을 보면 arr 의 길이는 최대 1,000임.
        이 말은 arr 의 최대 길이인 1,000 으로 입력되도 가장 가까운 다음 2의 거듭제곱은 10인 1024니까
        arr 의 길이보다 큰 2의 거듭제곱들 중 가장 작은 거듭제곱 수를 찾을 때 2의 1 거듭제곱부터 하나씩 늘려가면서
        체크를 해도 (최대 생각해도 10번 밖에 안됨) 무리가 없어 보일 거 같다.

        베스트풀이 확인 :
        구하는 로직은 거의 똑같고 표현하는 방식의 차이가 좀 있었다.
        초기 length 값을 1로 잡고 계산하면
        Arrays.copyOf(arr, length)
        위 내용 한 줄로 내 풀이의 remainder 체크하는 로직과 복사하는 부분을 하나로 합쳐서 표현해냈다.

     */
    public int[] solution(int[] arr) {
        int[] answer = {};
        int len = arr.length;
        int remainder = 0;

        for(int i = 0; i<=10; i++) {
            double pow = Math.pow(2, i);
            if(len <= pow) {
                remainder = (int) pow - len;
                break;
            }
        }

        if(remainder == 0) {
            return arr;
        }

        answer = new int[arr.length + remainder];
        System.arraycopy(arr,0,answer,0,arr.length);

        return answer;
    }
}
