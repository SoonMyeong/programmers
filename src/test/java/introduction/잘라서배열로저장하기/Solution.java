package introduction.잘라서배열로저장하기;


import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution {
    @Test
    void 잘라서_배열로_저장하기() {
        Assertions.assertThat(solution("abc1Addfggg4556b", 6)).isEqualTo(new String[] {"abc1Ad", "dfggg4", "556b"});
    }

    /*
        문제 : 잘라서 배열로 저장하기
        https://school.programmers.co.kr/learn/courses/30/lessons/120913
        접근 방법 :
        substring 을 이용해 풀어볼 수 있다.
        단, 처음 answer 배열 길이를 구할 때 length/n 값이 0이 아니면 한칸 더 늘려줘야 한다.
        -> 나머지들을 입력할 공간을 만들어줘야 하므로

        좋아요 많은 풀이 :
        다들 화끈하게 풀었구만, 이런건 while 문이 더 보기 좋던데
     */
    public String[] solution(String my_str, int n) {
        int answerLen = my_str.length() % n != 0 ? (my_str.length() / n) +1 : my_str.length() / n;
        String[] answer = new String[answerLen];
        int idx = 0;
        int start = 0;
        int end = n;

        while(idx < answer.length) {
            if(end >= my_str.length()) {
                answer[idx] = my_str.substring(start);
            }else {
                answer[idx] = my_str.substring(start, end);
            }
            idx++;
            start += n;
            end += n;
        }

        return answer;
    }
}
