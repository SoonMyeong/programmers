package com.soon.world.level2.방문길이;

/**
 * 문제 해결 과정
 * 정점 (2차원 배열) 으로는 계산이 되는데.. 길 계산은 어찌..? -> 다른 사람들의 풀이를 찾아 힌트를 얻어봤습니다. (양방향 처리를 위한 4차원배열 이용)
 * 1. 문자열 자르기
 * 2. 길의 범위 안에 있으면서 새로운 길에 방문 시 (시작점,도착점) , (도착점,시작점) 에 대해 방문 처리 (길은 양방향) 및 Add answer count
 *
 */
class Solution {
    public static boolean[][][][] arr = new boolean[11][11][11][11];
    public int x = 5;
    public int y = 5;

    public int solution(String dirs) {
        String [] ways = dirs.split("");
        int answer = 0;

        for(String way : ways){
            if(y-1 >= 0 && way.equals("L")) {
                if(!arr[x][y][x][y-1]) {
                    arr[x][y][x][y-1] = true;
                    arr[x][y-1][x][y] = true;
                    answer++;
                }
                y--;
            }
            if(y+1 <= 10 && way.equals("R")) {
                if(!arr[x][y][x][y+1]) {
                    arr[x][y][x][y+1] = true;
                    arr[x][y+1][x][y] = true;
                    answer++;
                }
                y++;
            }
            if(x-1 >=0 && way.equals("U")) {
                if(!arr[x][y][x-1][y]) {
                    arr[x][y][x-1][y] = true;
                    arr[x-1][y][x][y] = true;
                    answer++;
                }
                x--;
            }
            if(x+1 <=10 && way.equals("D")) {
                if(!arr[x][y][x+1][y]) {
                    arr[x][y][x+1][y] = true;
                    arr[x+1][y][x][y] = true;
                    answer++;
                }
                x++;
            }
        }

        return answer;
    }
}
