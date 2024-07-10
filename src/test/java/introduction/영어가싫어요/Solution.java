package introduction.영어가싫어요;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution {
    @Test
    void 영어가_싫어요() {
        Assertions.assertThat(solution("onetwothreefourfivesixseveneightnine")).isEqualTo(123456789);
        Assertions.assertThat(solution("onefourzerosixseven")).isEqualTo(14067);
    }

    /*
        문제 : 영어가 싫어요
        https://school.programmers.co.kr/learn/courses/30/lessons/120894
        접근 방법 :
        영어를 숫자로 바꿔주면 됨
        0~9 까지 순회하면서 영어단어 숫자로 replace 해주기
        알파벳과 숫자를 매핑시켜줘야 하는데, Map 안쓰고 꼼수를 부려보자.
        인덱스 번호가 숫자니까 이를 활용하면 될거 같음

        좋아요 많은 풀이 :
        똑같음, replaceAll 을 체이닝해서 한번에 푼 답안도 있음
        replace vs replaceAll: 둘다 존재하는 모든 기존값을 바꿔주는데, replaceAll 은 정규식을 쓸 수 있음.
     */
    public long solution(String numbers) {
        String[] numberNames = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
        for(int i = 0; i< numberNames.length; i++) {
            numbers = numbers.replace(numberNames[i], String.valueOf(i));
        }

        return Long.parseLong(numbers);
    }
}
