package basic.배열만들기4;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Stack;

public class Solution {
    @Test
    void 배열만들기4() {
        Assertions.assertThat(solution(new int[] {1,4,2,5,3})).isEqualTo(new int[]{1,2,3});
    }


    /*
        문제 : 배열만들기4
        https://school.programmers.co.kr/learn/courses/30/lessons/181918?language=java

        접근방법 :
        만들어야 될 배열 (stk) 에서 체크하는게 마지막 값만 보고
        조건에 따라 제거되거나 제거함.
        스택써도 될 거 같고, LinkedList 써도 될 거 같음
        변수명이 stk 이니까 스택 써보자
        스택은 FILO 인데 어떻게 배열로? 저번 문제 풀다 익혔음
        Stack 도 스트림으로 순회하면 FIFO 로 뺄 수 있다는 사실을 ㅎㅎ

        베스트풀이 확인 :
        리턴 타입을 스택으로 바꿔논게 왜 베스트인데...ㅡㅡ;
        LinkedList 쓴 거 한명 보이고 거의 다 스택 아니면 배열이네
     */
    public int[] solution(int[] arr) {
        Stack<Integer> stk = new Stack<>();
        int i = 0;
        int size = arr.length;
        while(i < size) {
            if(stk.isEmpty()) {
                stk.push(arr[i]);
                i++;
                continue;
            }
            if(stk.peek() < arr[i]) {
                stk.push(arr[i]);
                i++;
            }else {
                stk.pop();
            }
        }

        return stk.stream()
                .mapToInt(Integer::intValue)
                .toArray();
    }

}
