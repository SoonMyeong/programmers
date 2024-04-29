package basic.왼쪽오른쪽;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class Solution {
    @Test
    void 왼쪽_오른쪽() {
        Assertions.assertThat(solution(new String[]{"u","u","l","r"})).isEqualTo(new String[] {"u","u"});
        Assertions.assertThat(solution(new String[]{"l"})).isEqualTo(new String[] {});
        Assertions.assertThat(solution(new String[]{"u", "u", "d", "r", "d"})).isEqualTo(new String[] {"d"});
    }

    /*
        문제 : 왼쪽 오른쪽
        https://school.programmers.co.kr/learn/courses/30/lessons/181890

        접근방법>
        무조건 answer 리스트에 요소를 담다가
        l를 만나면 그 리스트 그대로 리턴. r을 만나면 리스트 비우고 끝까지 채우고 리턴
        했더니 예외 걸림 -> u,u,r,a,r 일 때 빈값이 나오는게 아니고 "a","r" 이 나와야 되나?
        (문제설명 진짜.. 후)
        결국 flag 값을 두고 해결하긴 했음

        베스트답안 확인>
        나처럼 로직 다돌리고 복잡한 if 문으로 처리 안하고
        l 만나면 0부터 i까지 배열 복사
        만약 r 만나면
        i+1 부터 끝까지 배열 복사
        --> 아주 심플하다.
        ""l"과 "r" 중 먼저 나오는 문자열이 "l"이라면 해당 문자열을 기준으로 왼쪽에 있는 문자열들을 순서대로 담은 리스트를,
         먼저 나오는 문자열이 "r"이라면 해당 문자열을 기준으로 오른쪽에 있는 문자열"
         여기에 잘못 인식해서 아주 삽질을 해버렷다.
         난 "u,u,l,u,l" 일때 "u,u,l,u" 가 나오는줄 알았지..
         이런건 기본 케이스로 얹어 줘야 안 헤깔릴꺼아니냐... 쩝
     */
    public String[] solution(String[] str_list) {
        List<String> collect = Arrays.stream(str_list)
                .collect(toList());
        int l = -1;
        boolean lflag = true;
        int r = -1;
        boolean rflag = true;
        for(int i = 0; i< str_list.length; i++) {
            if(str_list[i].equals("l") && lflag) {
                l = i;
                lflag = false;
            }
            if(str_list[i].equals("r") && rflag) {
                r = i;
                rflag = false;
            }
        }

        if(l < r) {
            if(l != -1) {
                return collect.subList(0, l).toArray(String[]::new);
            }
            return collect.subList(r+1, collect.size()).toArray(String[]::new);
        }
        if(l > r) {
            if(r != -1) {
                return collect.subList(r+1, collect.size()).toArray(String[]::new);
            }
            return collect.subList(0, l).toArray(String[]::new);
        }

        return new String[] {};
    }
}
