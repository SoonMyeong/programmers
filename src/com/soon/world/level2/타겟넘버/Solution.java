package com.soon.world.level2.타겟넘버;

/**
 *
 * DFS/BFS 문제인데..
 * -> DFS 문제
 * 재귀는 항상 끝나는 조건 과 점화식을 잘 생각 해야 한다.( 그만큼 어렵다는 뜻.. 이거 레벨2 인디..)
 *
 * 이 문제에서 점화식은 결국 현재 값에서 + 한 재귀와, -한 재귀의 합을 구하는 것이고,
 * 끝나는 조건은 계속 더해지는 index 값이 numbers 배열 길이와 같을 때 끝난다.(배열 순회 다 한거니까)
 * 또한, 끝나는 조건에서 target 과 sum 이 같을 경우에만 1을 리턴하므로 ,
 * 결국 모든 값들의 합은 target 값을 만든 경우의 수들의 합이 된다.!
 *
 */
public class Solution {
    public int solution(int[] numbers, int target) {
        return dfs(numbers,target,0,0);
    }

    public int dfs(int[] numbers, int target, int index, int sum) {
        if(index == numbers.length) {
            return target==sum ? 1: 0 ;
        }
        return dfs(numbers,target,index+1,sum+numbers[index])
            + dfs(numbers,target,index+1,sum-numbers[index]);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] test = {1,1,1,1,1};
        int testTarget = 3;
        System.out.println(solution.solution(test,testTarget));
    }
}
