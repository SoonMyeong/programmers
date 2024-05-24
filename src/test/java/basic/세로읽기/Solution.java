package basic.세로읽기;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution {
    @Test
    void 세로읽기() {
        Assertions.assertThat(solution("ihrhbakrfpndopljhygc", 4,2))
                .isEqualTo("happy");
        Assertions.assertThat(solution("programmers", 1,1))
                .isEqualTo("programmers");
    }

    /*
        문제 : 세로 읽기
        https://school.programmers.co.kr/learn/courses/30/lessons/181904
        접근 방법 :
        가볍게 접근해보면 my_string 를 길이 m 씩 자르면서 c 번째 위치의 문자만 모아서 응답하면 됨
        제한사항에 m 은 my_string 의 약수로 주어진다니까 for 문에서 +m 개씩 더해도 되겠네

        베스트풀이 확인 :
        내 풀이는 결국 반쪽짜리 이중루프를 돌게 된 샘인데
        for (int i = c - 1; i < my_string.length(); i += m) {
            answer += my_string.charAt(i);
        }
       이렇게 하면 굳이 중첩을 할 필요가 없었네ㅋㅋ 쫌만 더 생각해볼껄 그랬나 암튼 굳
     */
    public String solution(String my_string, int m, int c) {
        StringBuilder answer = new StringBuilder();
        for(int i = 0; i<my_string.length(); i+=m) {
            StringBuilder temp = new StringBuilder();
            for(int j = i; j< i + m; j++) {
                temp.append(my_string.charAt(j));
            }
            answer.append(temp.charAt(c - 1));
        }
        return answer.toString();
    }

}
