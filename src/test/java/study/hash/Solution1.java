package study.hash;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

public class Solution1 {
    @Test
    void ransomNote() {
        Assertions.assertThat(isIsomorphic("abcdefghijklmnopqrstuvwxyzva", "abcdefghijklmnopqrstuvwxyzck"))
                .isFalse();
    }

    // 좀 더 개선 된 for 문
    /**
     *
     * for (int i = 0; i < s.length(); i++) {
     *             if (!charIndexS.containsKey(s.charAt(i))) {
     *                 charIndexS.put(s.charAt(i), i);
     *             }
     *
     *             if (!charIndexT.containsKey(t.charAt(i))) {
     *                 charIndexT.put(t.charAt(i), i);
     *             }
     *
     *             if (!charIndexS.get(s.charAt(i)).equals(charIndexT.get(t.charAt(i)))) {
     *                 return false;
     *             }
     *         }
     *
     *         return true;
     *    }
     *
     *
     */
    public boolean isIsomorphic(String s, String t) {
        final var ss = s.toCharArray();
        final var tt = t.toCharArray();
        final var sMap = new HashMap<Character, Integer>();
        final var tMap = new HashMap<Character, Integer>();
        var index = 0;

        for(var c : ss) {
            sMap.put(c, index++);
        }
        index = 0;
        for(var c : tt) {
            tMap.put(c, index++);
        }

        String sIndex ="";
        for(var c : ss) {
            sIndex += sMap.get(c);
        }
        String tIndex ="";
        for(var c : tt) {
            tIndex += tMap.get(c);
        }

        return sIndex.equals(tIndex);
    }
}
