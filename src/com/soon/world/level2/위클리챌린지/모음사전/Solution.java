package com.soon.world.level2.위클리챌린지.모음사전;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    /**
     * A
     * AA
     * AAA
     * AAAA
     * AAAAA
     * AAAAE
     * AAAAI
     * AAAAO
     * AAAAU
     * AAAE
     * AAAEA
     * AAAEE
     * AAAEI
     * AAAEO
     * AAAEU
     * AAAI
     * AAAIA
     * AAAIE
     * AAAIO
     * AAAIU
     * ...
     * AAE
     * AAEA
     * AAEAA
     *
     * @param word
     * @return
     */
    private static int count = 0;
    public int solution(String word) {
        int answer = 0;
        Map<String,Integer> map = new HashMap<>();
        dfs(map,0,null);

        answer = map.get(word);

        return answer;
    }

    private void dfs(Map<String, Integer> map, int depth, String preStr) {
        String[] words = {"A","E","I","O","U"};
        for(int i=0; i< words.length; i++) {
            count++;
            if(preStr!=null) {
                System.out.println(preStr+words[i] +" cnt : "+ count);
                map.put(preStr+words[i],count);

                if(depth< words.length-1) {
                    dfs(map, depth + 1, preStr+words[i]);
                }
            }else {
                System.out.println(words[i]);
                map.put(words[i],count);

                if(depth< words.length-1) {
                    dfs(map, depth + 1, words[i]);
                }

            }
        }
    }

    /**
     * 와 난 재귀돌렸는데 다른사람 풀이보니까...대박ㅋㅋㅋ11
     * @param args
     */
    public static void main(String[] args) {
        Solution solution = new Solution();
        String word = "AAAAE";
        System.out.println(solution.solution(word));
    }
}
