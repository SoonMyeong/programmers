package com.soon.world.level2.위클리챌린지.전력망을_둘로_나누기;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    //흠.. 인접그래프 구현해서 하면 될거같았는데...안된다....

    class Node {
        int num;
        Node link;
    }

    class NodeList{
        Node[] list = new Node[200];
        List<Integer> result = new ArrayList<>();
        int sum = 0;

        void connect(int v1, int v2) {
            Node node = new Node();
            node.num = v2;
            for(Node n : list) {
                if(n!=null && n.num == v1) {
                    n.link = node;
                    return ;
                }
            }
            node.link = list[v1];
            list[v1] = node;
        }
        void print() {
            for(int i=0; i<4; i++) {
                Node node = list[i];
                int count = 0;
                while(node !=null) {
                    count++;
                    System.out.println("-----"+i+"-----" + node.num);
                    node = node.link;
                }
                result.add(count);

                if(count !=0) {
                    sum -= count;
                    sum = Math.abs(sum);
                }
            }
            for(int a : result) {
                System.out.println(a);
            }
            System.out.println("------------------");
        }

        int getSum() {
            return sum;
        }

    }

    public int solution(int n, int[][] wires) {
        int answer = Integer.MAX_VALUE;
        List<Integer> resultList = new ArrayList<>();

        for(int i=0; i<wires.length-1; i++) {
            NodeList nodeList = new NodeList();
            for (int j = 0; j<wires.length; j++) {
                if(j!=i) {
                    nodeList.connect(wires[j][0], wires[j][1]);
                }
            }
            nodeList.print();
            answer = Math.min(answer, nodeList.getSum());
        }
        return answer;
    }

    public static void main(String[] args) {
        int[][] wires = {{1,2},{2,3},{3,4}};
//        int[][] wires = {{1,3},{2,3},{3,4},{4,5},{4,6},{4,7},{7,8},{7,9}};
        int n = 4;
        Solution solution = new Solution();
        System.out.println(solution.solution(n,wires));
    }
}
