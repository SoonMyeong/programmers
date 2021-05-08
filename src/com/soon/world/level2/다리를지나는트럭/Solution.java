package com.soon.world.level2.다리를지나는트럭;

import java.util.*;

/**
 * 문제 풀이 과정
 * 트럭이 다리를 건넌다?
 * 근데 queue 에 현재 다리를 얼마나 건너고 있는지에 대한 상태 값을 함께 넣고, 매 시간마다 업데이트 해줘야 되는데..
 * 흠..문제 해결을 위한 정리가 잘 안되서 구글링 해봄
 * 소스 대신 풀이 과정을 먼저 확인 후 다시 접근 해봄 (아래 소스와는 다른 풀이임)
 *  --> 점점 느끼는건 문제를 빠르게 해결하기 위해서는 문제 파악을 한 뒤 정리를 잘 해야 문제도 쉽게 풀린다는걸 느낌..
 * 1. truck 들을 대기열인 queue 에 넣어 준다.
 * 2. queue 가 비어있을 경우 트럭을 큐에 넣고, 트럭무게의 합 변수와 시간인 answer 를 +1 씩 더해 준다.
 * 3. queue size 와 다리 길이가 같을 경우 다리에 트럭으로 가득 찼다는 말이기 때문에 가장 앞에 있는 트럭을 빼고, sum 을 poll 한 트럭 무게만큼 빼준다.
 * 4. 위 두 조건에 만족하기 않을 경우 새로 진입할 트럭의 무게와 기존 sum 의 합이 다리가 버틸 수 있는 무게 보다 크다면
 * 5. queue 에 0 값을 넣어 queue 에 트럭을 못 넣게끔 한다. 그렇지 않다면 queue 에 트럭을 넣어 주고, 2번 처럼
 *    sum 과 answer 를 +1 씩 더 해준다.
 * 6. 마지막으로 모든 트럭이 queue 에서 빠져 나간뒤의 시간을 구하는 것이므로 answer 에 다리 길이만큼을 더해 리턴한다.
 * --------
 * 다른사람들 풀이를 보니 아.. 내가 처음에 고민했던 매 시간마다 업데이트...객체 새로만들어서 어떻게 처리해야 하나
 * 고민했었는데.. 음.. 잘 읽어보고 작성해보기 .
 * --> 아무래도 queue 2개쓰고 그러다보니 기존 구글링해서 나온 풀이법보단 속도가 좀 안나오긴한다.
 *
 */
public class Solution {
    static class Truck {
        int weight;
        int move;

        public Truck(int weight){
            this.weight = weight;
            this.move = 1;
        }
        public void move(){
            this.move++;
        }
    }
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        int currentWeight = 0;

        Queue<Truck> waiting = new LinkedList<>();
        Queue<Truck> moving = new LinkedList<>();

        for(int t : truck_weights) {
            waiting.add(new Truck(t));
        }

        if (moving.isEmpty()) {
            Truck truck = waiting.poll();
            currentWeight += truck.weight;
            moving.add(truck);
            answer++;
        }

        while(!waiting.isEmpty() || !moving.isEmpty()) {
            answer++;

            for (Truck t : moving) {
                t.move();
            }

            if (moving.peek().move > bridge_length) {
                Truck truck = moving.poll();
                currentWeight -= truck.weight;
            }

            if (!waiting.isEmpty() && currentWeight + waiting.peek().weight <= weight) {
                Truck t = waiting.poll();
                currentWeight += t.weight;
                moving.add(t);
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        int a = 2;
        int b = 10;
        int[] c = {7,4,5,6};

        Solution solution = new Solution();
        System.out.println(solution.solution(a,b,c));
    }
}
