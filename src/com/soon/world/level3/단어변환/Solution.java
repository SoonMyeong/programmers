package com.soon.world.level3.단어변환;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 이건 어떻게..?
 * 아무래도 최단을 구하는 문제니까 BFS 로 해결해야 할거같긴 한데..
 * 그래프 문제는 좀 많이 풀어 봐야 될듯..
 * 구글링 참고해서 풀어보니..풀만하다..
 */
public class Solution {
    class Node {
        String nextWord;
        int count;

        public Node(String nextWord, int count) {
            this.nextWord = nextWord;
            this.count =count;
        }
    }

    /**
     * word 문자 와 cmp 문자간 차이가 1개까지 나는지 확인하는 메소드
     * 즉, 문자 1개만 다를 경우까지만 true , 1개이상 차이나면 false
     * 이게 관건이네.
     * @param word
     * @param cmp
     * @return
     */
    private boolean isDifferent(String word, String cmp) {
        int cnt = 0;
        for(int i=0; i<word.length(); i++) {
            if(word.charAt(i) != cmp.charAt(i))
                cnt++;
            if(cnt>1)
                return false;
        }
        return true;
    }

    public int solution(String begin, String target, String[] words) {
        int answer = 0;
        Queue<Node> queue = new LinkedList<>();
        boolean[] visited = new boolean[words.length];
        queue.add(new Node(begin,0));

        while(!queue.isEmpty()) {
            Node n = queue.poll();

            if(n.nextWord.equals(target)) {
                answer = n.count;
                break;
            }
            for(int i=0; i<words.length; i++) {
                if(!visited[i] && isDifferent(n.nextWord, words[i])) {
                    visited[i] = true;
                    queue.add(new Node(words[i],n.count+1));
                }
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String start = "hit";
        String end =  "cog";
        String[] wordTest = {"hot","dot","dog","lot","log","cog"};

        System.out.println(solution.solution(start,end,wordTest));
    }
}
