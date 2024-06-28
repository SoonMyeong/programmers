package introduction.로그인성공;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution {
    @Test
    void 로그인성공() {
        Assertions.assertThat(solution(new String[]{"meosseugi", "1234"}, new String[][] {
                {"rardss", "123"}, {"yyoom", "1234"}, {"meosseugi", "1234"}}))
                .isEqualTo("login");
    }

    /*
        문제 : 로그인 성공?
        https://school.programmers.co.kr/learn/courses/30/lessons/120883
        접근 방법 :
        db 순회하면서 id 같은거 없으면 fail
        db 순회하면서 id 같은데 pw 다르면 wrong pw
        db 순회하면서 id,pw 같으면 login

        좋아요 많은 풀이 :
        같음..
     */
    public String solution(String[] id_pw, String[][] db) {
        for(String[] row : db) {
            if(id_pw[0].equals(row[0])) {
                if(id_pw[1].equals(row[1])) {
                    return "login";
                }
                return "wrong pw";
            }
        }
        return "fail";
    }

}
