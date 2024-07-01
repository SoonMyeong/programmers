package introduction.직사각형넓이구하기;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    @Test
    void 직사각형_넓이_구하기() {
        Assertions.assertThat(solution(new int[][] {{1,1},{2,1},{2,2},{1,2}})).isEqualTo(1);
        Assertions.assertThat(solution(new int[][] {{-1,-1},{1,1},{1,-1},{-1,1}})).isEqualTo(4);
    }

    /*
        문제 : 직사각형 넓이 구하기
        https://school.programmers.co.kr/learn/courses/30/lessons/120860
        접근 방법 :
        하나의 dot 좌표를 기준으로 나머지 3개의 좌표까지의 거리를 각각 구해보면
        가장 긴 길이는 대각선의 길이가 이다.
        직사각형 넓이는 가로 x 세로 이므로 가장 긴 길이인 대각선의 길이만 빼고
        남은 두 거리를 곱해주면 된다.

        좋아요 많은 풀이 :
        내 풀이보다 좀 더 머리를 써서 풀었다.
        직사각형이기 때문에 네 점의 위치는 두 점은 반드시 같은 x 선상과 y 선상에 놓이게 된다.
        따라서 dots[0][0] 을 기준으로
        다른 점의 x 좌표가 기준점과 같은 선상에 놓여 있을 때 두 점의 차이를 구하면 세로 값이 나오고
        다른 점의 y 좌표가 기준점과 같은 선상에 놓여 있을 때 두 점의 차이를 구하면 가로 값이 나온다.
        for(int i = 1; i<dots.length; i++){
            if(dots[i][0] == tmp){
                tmp2 = Math.abs(dots[i][1] - dots[0][1]);
            }else{
                tmp3 = Math.abs(dots[i][0] - dots[0][0]);
            }
        }
     */
    public int solution(int[][] dots) {
        int[] standardDot = new int[2];
        standardDot[0] = dots[0][0];
        standardDot[1] = dots[0][1];

        List<Double> list = new ArrayList<>();
        for(int i = 1; i< dots.length; i++) {
            double dot =Math.sqrt(Math.pow(dots[i][0] - standardDot[0], 2)
                    + Math.pow(dots[i][1] - standardDot[1], 2));
            list.add(dot);
        }

        int[] collect = list.stream()
                .sorted()
                .mapToInt(Double::intValue)
                .toArray();

        return collect[0] * collect[1];
    }
}
