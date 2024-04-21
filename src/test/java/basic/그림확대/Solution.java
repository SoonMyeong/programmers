package basic.그림확대;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    @Test
    void 그림확대() {
        String[] picture1 = {".xx...xx.", "x..x.x..x", "x...x...x", ".x.....x.", "..x...x..", "...x.x...", "....x...."};
        Assertions.assertThat(solution(picture1, 2))
                .isEqualTo(new String[] {"..xxxx......xxxx..","..xxxx......xxxx..", "xx....xx..xx....xx",
                        "xx....xx..xx....xx", "xx......xx......xx",
                        "xx......xx......xx", "..xx..........xx..", "..xx..........xx..",
                        "....xx......xx....", "....xx......xx....", "......xx..xx......",
                        "......xx..xx......", "........xx........", "........xx........"});
    }


    /*
        문제 : 그림확대
        https://school.programmers.co.kr/learn/courses/30/lessons/181836

        접근방법 >
        흠.. 규칙이 뭐지....
        뚫어져라 보다보니 배열 원소도 k배로 되고 그 안에 string 길이도 k배가 됨.
        점과 x 상관 없이 그냥 String 을 자른 charArray 도 k배 하고 String 배열길이도 k배 설정

        베스트풀이 확인 >
        베스트풀이의 경우 맥락은 같음
     */
    public String[] solution(String[] picture, int k) {
        List<String> enlargedPicture = new ArrayList<>();

        // 각 줄을 k배로 늘리고, 각 줄을 k번 복제하여 새로운 그림 파일 생성
        for (String row : picture) {
            StringBuilder newRow = new StringBuilder();
            for (char c : row.toCharArray()) {
                newRow.append(String.valueOf(c).repeat(k));
            }
            for (int i = 0; i < k; i++) {
                enlargedPicture.add(newRow.toString());
            }
        }

        return enlargedPicture.toArray(new String[0]);
    }
}
