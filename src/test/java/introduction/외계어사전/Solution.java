package introduction.외계어사전;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;


public class Solution {
    @Test
    void 외계어사전() {
        Assertions.assertThat(solution(new String[] {"p","o","s"}, new String[] {"sod","eocd","qixm","adio","soo"}))
                .isEqualTo(2);
        Assertions.assertThat(solution(new String[] {"z","d","x"}, new String[] {"def", "dww", "dzx", "loveaw"}))
                .isEqualTo(1);
        Assertions.assertThat(solution(new String[] {"z","d","x","x"}, new String[] {"def", "dww", "dzxx", "loveaw"}))
                .isEqualTo(1);
        Assertions.assertThat(solution(new String[] {"s", "o", "m", "d"}, new String[] {"moos", "dzx", "smm", "sunmmo", "som"}))
                .isEqualTo(2);
    }

    /*
        문제 : 외계어 사전
        https://school.programmers.co.kr/learn/courses/30/lessons/120869
        접근 방법 :
        spell 배열을 순회하면서 dic 배열 원소에 spell 원소를 포함할 경우 공백으로 바꿔줘서
        spell 배열 순회를 끝냈을 때 dic 배열에 ""인 값이 있으면 1 아니면 2
        근데 유의사항에 반드시 spell 원소들을 한번씩 사용해야 된다고 한다.
        그렇기 떄문에 spell 을 전부 다 사용했는지에 대한 상태관리로 counts 배열을 하나 둬서
        spell 원소를 포함할 경우 공백으로 바꿔주면서 count 값도 늘려준다.

        좋아요많은 풀이 확인:
        제한사항 : spell 모두 중복된 원소를 갖지 않습니다. 을 확인안하고 풀어서 상태관리까지 하게 됐는데
        중복된 원소를 갖지 않으니.. 그냥 contains 하고 count 값 늘려주면 됨... 더 괜히 어렵게품

     */
    public int solution(String[] spell, String[] dic) {
        int[] counts = new int[dic.length];
        for(String s : spell) {
            for(int i = 0; i< dic.length; i++) {
                if(dic[i].contains(s)) {
                    dic[i] = dic[i].replaceFirst(s, "");
                    counts[i]++;
                }
            }
        }
        for(int i = 0; i<dic.length; i++) {
            if("".equals(dic[i]) && counts[i] == spell.length) {
                return 1;
            }
        }
        return 2;
    }
}
