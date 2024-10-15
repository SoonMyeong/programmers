package study.hash;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution2938 {
    @Test
    void test() {
        Assertions.assertThat(minimumSteps("100")).isEqualTo(2);
    }

    /*
        https://leetcode.com/problems/separate-black-and-white-balls/description/?envType=daily-question&envId=2024-10-15
        검은돌 1, 흰돌 0이 랜덤하게 여러개 주어질 때
        인접한 돌만 교환할 수 있다는 조건때문에
        흰돌을 모두 앞쪽에 배치시키려면 0을 만나기 전까지의 지나온 거리만큼 0을 이동시켜야 한다.
        코드는 단순한데 인접한 돌을 몇번 교환해야되는지 고민하면 풀기 어려워진다.
     */
    public long minimumSteps(String s) {
        var arr = s.split("");
        var total = 0L;
        var count = 0L;
        for(var str : arr) {
            if("0".equals(str)) {
                total += count;
            }else {
                count++;
            }
        }
        return total;
    }

}
