package basic.리스트자르기;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution {
    @Test
    void 리스트자르기() {
        Assertions.assertThat(solution(1,new int[]{1,3,2}, new int[]{1,2,3,4}))
                .isEqualTo(new int[]{1,2, 3, 4});
        Assertions.assertThat(solution(2,new int[]{1,3,2}, new int[]{1,2,3,4}))
                .isEqualTo(new int[]{2, 3, 4});
        Assertions.assertThat(solution(3,new int[]{1,5,2}, new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9}))
                .isEqualTo(new int[]{2, 3, 4, 5, 6});
        Assertions.assertThat(solution(4,new int[]{1,5,2}, new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9}))
                .isEqualTo(new int[]{2, 4, 6});
    }

    /*
        문제 : 리스트 자르기
        https://school.programmers.co.kr/learn/courses/30/lessons/181897

        접근방법 :
        List 의 subList 를 쓸까 했는데 n =4 인 조건을 만족하는 메서드가 존재하지 않아서
        그냥 배열로 풀고 조건이 4개정도 되길래 스위치로 풀어봄
        개선된 switch 문인데 동작하는거보면 프로그래머스 컴파일하는 자바 버전 14 이상인가봄

        베스트풀이 확인 :
        if 아니면 스위치로 거의 해결
        결국 이 문제의 핵심은 n 숫자 별 answer 배열 사이즈크기 정하는 로직인데 같음
     */
    public int[] solution(int n, int[] slicer, int[] num_list) {
        int[] answer = {};

        return switch (n) {
            case 1 -> {
                answer = new int[slicer[1] +1];
                for(int i = 0; i<=slicer[1]; i++) {
                    answer[i] = num_list[i];
                }
                yield answer;
            }
            case 2 -> {
                answer = new int[num_list.length - slicer[0]];
                int idx = 0;
                for(int i = slicer[0]; i<num_list.length; i++) {
                    answer[idx] = num_list[i];
                    idx++;
                }
                yield answer;
            }
            case 3 -> {
                answer = new int[slicer[1] - slicer[0] +1];
                int idx = 0;
                for(int i = slicer[0]; i<=slicer[1]; i++) {
                    answer[idx] = num_list[i];
                    idx++;
                }
                yield answer;
            }
            case 4 -> {
                answer = new int[((slicer[1] - slicer[0]) / slicer[2]) + 1];
                int idx = 0;
                for(int i = slicer[0]; i<=slicer[1]; i+= slicer[2]) {
                    answer[idx] = num_list[i];
                    idx++;
                }
                yield answer;
            }
            default -> throw new IllegalStateException("Unexpected value: " + n);
        };
    }

}
