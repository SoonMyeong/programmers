package basic.빈배열에추가삭제하기;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    @Test
    void 빈_배열에_추가_삭제_하기() {
        Assertions.assertThat(solution(new int[]{3,2,4,1,3}, new boolean[]{true,false,true,false,false}))
                .isEqualTo(new int[]{3,3,3,3,4,4,4,4});
    }

    /*
        문제 : 빈 배열에 추가/삭제 하기
        https://school.programmers.co.kr/learn/courses/30/lessons/181860

        접근 방법 :
        flag 값 true : 배열X 에 arr[i] 를 arr[i] x2 번 추가
        flag 값 false : 배열X 의 마지막 arr[i] 개의 원소 제거
        결국 배열 사이즈를 늘리고 줄이고를 자유롭게 할 수 있는지 물어보는 문제인거 같음
        리스트로 해결 가능해보임

        베스트 풀이 확인 :
        숫자를 String 으로 바꿔서 repeat 메서드와 substring 메서드를 활용한 내용이
        좋아요를 가장 많이 받았음, 결국 for 문 안쓰려고 노력한걸로 보이는데..
        나머진 다 나랑 비슷함, 지우는 부분에서 나는 subList 메서드 활용해서 for 문 하나를 줄였음
     */
    public int[] solution(int[] arr, boolean[] flag) {
        List<Integer> answer = new ArrayList<>();
        for(int i =0; i<flag.length; i++) {
            if(flag[i]) {
                for(int j = 0; j<arr[i] * 2; j++) {
                    answer.add(arr[i]);
                }
            }else {
                answer = answer.subList(0, answer.size() - arr[i]);
            }
        }
        return answer.stream()
                .mapToInt(Integer::intValue)
                .toArray();
    }

}
