package basic.커피심부름;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution {
    @Test
    void 커피심부름() {
        Assertions.assertThat(solution(new String[] {"cafelatte", "americanoice", "hotcafelatte", "anything"}))
                .isEqualTo(19000);
        Assertions.assertThat(solution(new String[] {"americanoice", "americano", "iceamericano"}))
                .isEqualTo(13500);
    }

    /*
        문제 : 커피심부름
        https://school.programmers.co.kr/learn/courses/30/lessons/181837
        접근방식 :
        문제 누가 만들었나 -_-
        아메리카노 주세요 이러면 뜨아가 디폴트지 왜 아아가 디폴트야
        그냥 조건만 처리하면 되서 if 문 or switch 문으로 하면 됨
        근데 그냥 이름에 아메리카노 들어가면 4500원
        라테 들어가면 5000원 이니까 if 문 2개면 될 거 같으니 if 문으로 함

        베스트풀이 확인 :
        cafelatte 면 += 5000원 else 4500원 으로 처리 함
        별차이 없음
    */
    public int solution(String[] order) {
        int answer = 0;

        for(String o : order) {
            if(o.contains("americano") || o.equals("anything")) {
                answer += 4500;
            }
            if(o.contains("cafelatte")) {
                answer += 5000;
            }
        }

        return answer;
    }

}
