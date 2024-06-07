package introduction.겹치는선분길이;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class Solution {
    @Test
    void 겹치는_선분의_길이() {
        Assertions.assertThat(solution(new int[][] {{0,1},{2,5},{3,9}})).isEqualTo(2);
        Assertions.assertThat(solution(new int[][] {{-1,1},{1,3},{3,9}})).isEqualTo(0);
        Assertions.assertThat(solution(new int[][] {{0,5},{3,9},{1,10}})).isEqualTo(8);
        Assertions.assertThat(solution(new int[][] {{4,7},{4,5},{6,7}})).isEqualTo(2);
        Assertions.assertThat(solution(new int[][] {{1,12},{3,6},{2,4}})).isEqualTo(4);
        Assertions.assertThat(solution(new int[][] {{0,8},{0,2},{6,8}})).isEqualTo(4);
        Assertions.assertThat(solution(new int[][] {{0,6},{0,6},{2,4}})).isEqualTo(6);
        Assertions.assertThat(solution(new int[][] {{0,2},{-3,-1},{-2,1}})).isEqualTo(2);
    }

    /*
        문제 : 겹치는 선분의 길이
        https://school.programmers.co.kr/learn/courses/30/lessons/120876
        접근 방법 :
        먼저, 구할 수 있는 가지 수는 3가지 이다. (1,2)/(1,3)/(2,3)
        ( [중요] 반드시 정렬 후 위 경우의 수로 계산해야 한다..ㅠㅠ
        이거 떄매 시간 엄청날렸네.. 테스트케이스 하나만 정렬해야 풀 수 있게 해놨네 이놈들 ㅠ
        )
        결국 두 선을 비교하여 겹치는 부분의 최소,최대값을 구하는 함수를 만들어 구해낸다.
        겹치는 부분이 0개라면 0 리턴
        겹치는 부분이 1개라면 바로 최대값 - 최소값
        겹치는 부분이 2개라면 각 범위 값을 계산 후 합산 하여 리턴
        겹치는 부분이 3개라면 두개의 겹치는 공간이 나온거기 떄문에
        가장 작은 숫자와 가장 큰숫자를 구한다음 가장큰숫자 - 가장작은숫자가 답이 된다.

        그럼 겹치는 구간은 어떻게 구할까?
        [0,1] [2,5] 이 구간은 인간이 보기엔 바로 겹치지 않는걸 알 수 있다.
        [0,1] 의 최대값인 1이 [2,5] 의 최소값인 2보다 작으니까,
        그럼 [2,5] [3,9] 이 구간은 어떤가? [3,5] 구간이 겹치는걸 인간은 알 수 있다
        어떻게? [2,5]의 최대값인 5가 [3,9]의 최소값 보다 크기 때문에 일단 겹친다는걸 알 수 있고
        5 이상부터는 겹치지 않을게 예측이 된다. 결국 [3,5]가 겹치는걸 알 수 있음
        일반화 하면 [a,b] [c,d] 가 있을 때
        (b > c 일 때) [Math.max(a,c) , Math.min(b,d)] 가 성립함을 구해볼 수 있다.
        단, 두 범위의 부호가 다르면 만나지 않기에 조건은 성립하지 않는다.

        좋아요 많은 풀이 :
        속도만 놓고보면 내 코드가 2배이상 빠르지만 생각보다 주먹구구식 풀이가 가독성이 훨씬 좋음..
        왜 주먹구구식이냐면, line 범위 해당하는 값들 전부 map 에 때려박은다음에
        한번 이상 겹쳐진 숫자들의 합을 구한거임
        Map<Integer, Integer> map = new HashMap<>();
        for (int[] line : lines) {
            for (int i =  line[0]; i < line[1]; i++) {
                map.merge(i, 1, Integer::sum);
            }
        }
        return (int) map.values().stream().filter(i -> i > 1).count();

     */
    public int solution(int[][] lines) {
        sortLines(lines);
        int[] range1 = minMaxRangeLines(lines[0], lines[1]);
        int[] range2 = minMaxRangeLines(lines[0], lines[2]);
        int[] range3 = minMaxRangeLines(lines[1], lines[2]);

        if(range1[0] == -101 && range2[0] == -101 && range3[0] == -101) {
            return 0;
        }

        if(range1[0] != -101 && range2[0] != -101 && range3[0] != -101) {
            int max = Math.max(range1[1], Math.max(range2[1], range3[1]));
            int min = Math.min(range1[0], Math.min(range2[0], range3[0]));
            return max - min;
        }

        if(range1[0] != -101 && range2[0] != -101) {
            return (range1[1] - range1[0]) + (range2[1] - range2[0]);
        }
        if(range1[0] != -101 && range3[0] != -101) {
            return (range1[1] - range1[0]) + (range3[1] - range3[0]);
        }
        if(range2[0] != -101 && range3[0] != -101) {
            return (range2[1] - range2[0]) + (range3[1] - range3[0]);
        }

        if(range1[0] != -101) {
            return range1[1] - range1[0];
        }
        if(range2[0] != -101) {
            return range2[1] - range2[0];
        }

        return range3[1] - range3[0];
    }

    private int[] minMaxRangeLines(int[] line, int[] line1) {
        //단, 두 범위의 부호가 다르면 만나지 않기에 조건은 성립하지 않는다.
        if(line1[0] < 0 && line1[1] < 0 && line[0] >= 0 && line[1] >= 0) {
            return new int[] {-101};
        }
        if(line[1] <= line1[0]) {
            return new int[] {-101};
        }
        return new int[] {Math.max(line[0], line1[0]), Math.min(line[1], line1[1])};
    }

    public void sortLines(int[][] lines) {
        Arrays.sort(lines, (a, b) -> {
            if (a[0] == b[0]) {
                return Integer.compare(a[1], b[1]);
            }
            return Integer.compare(a[0], b[0]);
        });
    }

}
