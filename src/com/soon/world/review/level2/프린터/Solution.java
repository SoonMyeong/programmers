package com.soon.world.review.level2.프린터;


import java.util.*;

/**
 *  예제
 *  (A,B,C,D) , 중요도 2 1 3 2
 *  -> BCDA
 *  -> CDAB
 *  -> C 출력
 *  -> DAB
 *  -> D 출력
 *  -> A 출력
 *  -> B 출력
 *
 * 1. 인쇄 대기목록의 가장 앞에 있는 문서(J)를 대기목록에서 꺼냅니다.
 * 2. 나머지 인쇄 대기목록에서 J보다 중요도가 높은 문서가 한 개라도 존재하면 J를 대기목록의 가장 마지막에 넣습니다.
 * 3. 그렇지 않으면 J를 인쇄합니다.
 *
 * Logic (queue 활용)
 * 우선순위가 높은 순서대로 출력 되는게 포인트, priorities 를 미리 정렬 후 작업 한다.
 * 1. queue 에서 맨 앞 데이터 값을 조회 한다.
 * 2. 우선순위가 가장 높은 값과 조회한 값의 우선순위값이 같을 경우 location 비교
 * 3. 그렇지 않으면 조회한 데이터 꺼낸 후 맨뒤로 보낸다.
 */
public class Solution {
    class Node {
        int priority;
        int location;

        public Node(int priority, int location) {
            this.priority = priority;
            this.location = location;
        }
        public int getLocation() {
            return this.location;
        }
    }
    public int solution(int[] priorities, int location) {
        int answer = 0;
        Queue<Node> queue  = new LinkedList<>();

        for(int i=0; i<priorities.length; i++) {
            queue.add(new Node(priorities[i],i));
        }
        Arrays.sort(priorities);
        int count = 1;

        while(!queue.isEmpty()) {
            if(queue.peek().priority == priorities[priorities.length-count]) {
                answer++;
                if(queue.peek().location == location) {
                    break;
                }
                count++;
                queue.poll();
            } else {
                queue.add(queue.poll());
            }
        }

        return answer;
    }
    public static void main(String[] args) {
        int[] priorities = {1,1,9,1,1,1};
        int location = 0;
        Solution solution  = new Solution();
        System.out.println(solution.solution(priorities,location));
    }
}
