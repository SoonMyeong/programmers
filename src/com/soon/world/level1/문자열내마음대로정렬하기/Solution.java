package com.soon.world.level1.문자열내마음대로정렬하기;

import java.util.*;

/**
 *  Comparator 사용은 알고있었지만 (정렬), 그 안에서 alphabet 을 가지고 정렬을 또 하는거에 대한 생각을 못하여
 *  다른 방식으로 풀었다가 테스트 1번케이스에서 컴파일 에러가 났던 문제!
 *  이번 기회로 확실히 Comparator , Comparable 에 대해 짚고 넘어 가기
 */
public class Solution {
    public String[] solution(String[] strings, int n) {
        Arrays.sort(strings, (o1, o2) -> {
            char c1 = o1.charAt(n);
            char c2 = o2.charAt(n);

            if(c1 == c2){
                return o1.compareTo(o2);
            }else{
                return c1-c2;
            }
        });

        return strings;
    }
}
