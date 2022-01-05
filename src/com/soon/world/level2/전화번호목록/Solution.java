package com.soon.world.level2.전화번호목록;

import java.util.*;

/**
 * 문제 해결 과정
 * 2중 포문 + startswith 메소드를 활용 해봤는데 테스트 2건 실패에 효율성에서 완전 떨어지게 되었다.
 * ---
 * 음... 결국 2중포문은 돌아야 한다. 단 이 풀이법이 기존 startswith 방식 (String 비교) 과 다른건
 * phone_book 의 인덱스 값을 한글자~ length-1 글자 까지 쪼개서 map 에 넣어 넣고
 * 마지막에 map 을 순회하면서 phone_book 의 인덱스가 key 로 존재하는지 파악하고 끝낸다는 점이다.
 *  해시가 진짜 빠르긴하네.. 막 집어넣어서 더 느릴거같았는데..
 *  ( length -1로 두는 이유는 자기 자신의 인덱스가 key 로 존재하지 않게 하기 위함 )
 *  //
 *
 */
public class Solution {
    public boolean solution(String[] phone_book) {
        boolean answer = true;
        HashMap<String,String> map = new HashMap<>();
        HashSet<String> set = new HashSet<>(Arrays.asList(phone_book));

        for (String book : set) {
            for (int i = 1; i < book.length(); i++) {
                if (set.contains(book.substring(0, i))) {
                    return false;
                }
            }
        }


        return answer;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String[] test = {"119", "97674223", "1195524421"};
        System.out.println(solution.solution(test));
    }
}
