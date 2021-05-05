package com.soon.world.level2.영어_끝말잇기;

import java.util.HashMap;
import java.util.Map;

/**
 * 문제 풀이 과정
 * 1. words 배열 길이만큼 순회 해야 한다.
 * 2. 단어 중복 이거나 n 번째 단어의 마지막 알파벳과 n+1번째 단어의 시작 알파벳이 같으면 탈락자 발생
 * 3. 결과: [n 번째사람,자신의 m 번째 차례] , 1번째사람부터 시작이므로 인덱스 값에 +1 을 더함
 *
 */
class Solution {
    public int[] solution(int n, String[] words) {
        int [] answer = {0,0};
        Map<String,Integer> word = new HashMap<>();
        char alphaEnd = words[0].charAt(words[0].length()-1);
        word.put(words[0], 1);

        for(int i=1; i<words.length; i++){
            word.putIfAbsent(words[i], 0);
            word.put(words[i],word.get(words[i])+1);

            char alphaStart = words[i].charAt(0);

            if(word.get(words[i])>1 || alphaEnd != alphaStart){
                answer[0] = (i%n) +1;
                answer[1] = (i/n) +1;
                break;
            }
            alphaEnd = words[i].charAt(words[i].length()-1);
        }

        return answer;
    }
}