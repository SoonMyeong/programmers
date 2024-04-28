package basic.배열만들기6;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    @Test
    void 배열만들기6() {
        Assertions.assertThat(solution(new int[] {0,1,1,1,0})).isEqualTo(new int[] {0,1,0});
        Assertions.assertThat(solution(new int[] {0,1,0,1,0})).isEqualTo(new int[] {0,1,0,1,0});
        Assertions.assertThat(solution(new int[] {0,1,1,0})).isEqualTo(new int[] {-1});
    }

    /*
        문제 : 배열 만들기 6
        https://school.programmers.co.kr/learn/courses/30/lessons/181859
        접근방법>
        문제 조건대로 i 초기값 0, i는 arr 의 길이와 크거나 같아질때까지 while 문 돌리고
        그 안에서 조건 3개를 처리하면 될 거 같음
        조건 중 원소를 제거하는 로직이 있으니 List 를 이용해 제거 로직 쉽게 해결 가능

        베스트풀이 확인>
        조건2개가 모두 마지막 원소 유무를 확인하는거라 LIFO 인 스택을 사용하였음 (마지막원소 확인 & 제거 메서드 있음)
        재밌는건 마지막 배열을 뽑기위에선 FIFO 방식으로 뽑아야되는데, 이를 위애 stream 을 사용하여 뽑아냄
        스택도 Stream 돌리면 구조 상관없이 FIFO 방식이구만..
     */
    public int[] solution(int[] arr) {
        List<Integer> stk = new ArrayList<>();
        int i = 0;
        while(i < arr.length) {
            if(stk.isEmpty()) {
                stk.add(arr[i]);
                i++;
                continue;
            }
            if(stk.get(stk.size() -1) == arr[i]) {
                stk.remove(stk.size() - 1);
                i++;
                continue;
            }
            if(stk.get(stk.size() -1) != arr[i]) {
                stk.add(arr[i]);
                i++;
            }
        }

        if(stk.isEmpty()) {
            stk.add(-1);
        }
        return stk.stream()
                .mapToInt(Integer::intValue)
                .toArray();
    }
}
