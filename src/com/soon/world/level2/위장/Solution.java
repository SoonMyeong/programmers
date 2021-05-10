package com.soon.world.level2.위장;

import java.util.*;

import static java.util.stream.Collectors.*;

/**
 * 문제 해결 과정
 * 해시를 이용 해보았으나, 경우의 수 계산하는 거때매 좀 막혔던 문제
 * ----
 * 람다를 이용해 한번에 하는걸 봐서 신기해서 재작성 해봄
 */
public class Solution {
    public int solution(String[][] clothes) {
        int answer = 1;
        return Arrays.stream(clothes) //String[][] 을 stream 화 하고
                .collect(groupingBy(m -> m[1], counting())) //key : clothes[1] , value: count 의 map 으로 컬렉션화
                .values() //해당 컬렉션의 값들을 나열
                .stream() // 나열된 값들을 스트림 화
                .reduce(1L, (total, n) -> total * (n + 1)).intValue()-1; //스트림의 연산 작업 결과
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String[][] test = {{"yellowhat", "headgear"},{"bluesunglasses", "eyewear"},{"green_turban", "headgear"}};
        System.out.println(solution.solution(test));
    }
}
