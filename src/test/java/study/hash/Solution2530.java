package study.hash;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Collections;
import java.util.PriorityQueue;

public class Solution2530 {
    @Test
    void test() {
        maxKelements(new int[] {672579538,806947365,854095676,815137524}, 3);
    }
    /*
        https://leetcode.com/problems/maximal-score-after-applying-k-operations/description/?envType=daily-question&envId=2024-10-14
        K 연산 적용 후 "최대" 점수
        - 선택지가 여러 개 있고 K 만큼 골라서 "최대"를 구해내야 된다.
        - 문제에서 k 번 시도 하면서 점수는 num[i] 만큼 더하기 때문에 계속 가장 큰 원소를 찾아 더해주는 게 중요하다.
        - k 번 최대 값을 찾아야되는데 k의 범위는 10^5 까지다.
        - 최대 힙을 활용하면 될 거 같다.
        - 범위가 커서 BiDecimal 을 이용함
     */
    public BigDecimal maxKelements(int[] nums, int k) {
        final var queue = new PriorityQueue<BigDecimal>(Collections.reverseOrder());
        var sum = BigDecimal.ZERO;
        for(var n : nums) {
            queue.add(new BigDecimal(n));
        }
        for(var i = 0; i < k; i++) {
            var n =queue.poll();
            sum = sum.add(n);
            queue.add(n.divide(new BigDecimal(3.0), RoundingMode.CEILING));
        }
        return sum;
    }
}
