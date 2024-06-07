package introduction.두수의합;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution {
    @Test
    void 두수의합() {
        Assertions.assertThat(solution(1,2)).isEqualTo(3);
    }

    public int solution(int num1, int num2) {
        return num1 + num2;
    }
}
