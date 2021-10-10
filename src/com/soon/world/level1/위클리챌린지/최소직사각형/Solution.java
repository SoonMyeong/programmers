package com.soon.world.level1.위클리챌린지.최소직사각형;

public class Solution {

    /**
     * 명함 사이즈들을 받아서 명함들을 다 집어넣을 수 있는 가장 작은 지갑 만들기
     * 단, 명함은 가로와 세로를 바꿀 수 있다. (예를들어 명함을 세로로 넣을거를 가로로 넣는다)
     *
     * 명함 | 가로 | 세로
     * 1 | 60 | 50
     * 2 | 30 | 70
     * 3 | 60 | 30
     * 4 | 80 | 40
     *
     * 내 풀이의 경우 2N의 시간복잡도가 나오는데, 이거 참 다른분들 풀이 보니 원리만 알면 N으로 쉽게 풀 수 있다.
     * 2차원 배열에 로우 마다 최대 값과 최소값을 구해서 기존의 최대값 보다 클 경우 최대값 갱신
     * ** 최소값의 경우가 다른게 이 문제의 키포인트. 최소값은 기존 값보다 작은걸로 하지말고 기존 값보다 클 경우 최소값을 갱신!
     * 
     * 내 풀이의 경우 아래와 같다.
     * 숫자 전체의 최대값을 찾은 뒤 그 해당 전체 숫자가 있는 컬럼 (가로 or 세로) 에 다가 
     *  로우 별 두 컬럼값들을 비교해서 큰 값을 몰아넣은 뒤 남아 있는 최소값들 중 max 값과 전체 최대값의 곱으로 표현함
     * 예를들어 위 예제의 경우 전체 최대값은 80이 된다.
     * 따라서 로우 별로 가로와 세로를 비교해서 세로가 더 클 경우 가로와 값을 바꿔 준다. (우리가 원하는 값을 얻기만 하면 되니 덮어 써버리면 된다.)
     * 60 | 50
     * 70 | 30
     * 60 | 30
     * 80 | 40
     * 위 와 같은 결과가 된다. 여기서 세로값들의 최대값은 50이 되고, 전체 최대값 80 과 50의 곱인 4000이 답이 된다.
     *
     *
     * @param sizes
     * @return
     */
    public int solution(int[][] sizes) {
        int[] colOne = new int[sizes.length];
        int[] colTwo = new int[sizes.length];
        int colOneMax = 0;
        int colTwoMax = 0;

        for(int i=0; i< sizes.length; i++) {
            colOne[i] = sizes[i][0];
            colTwo[i] = sizes[i][1];

            if(colOneMax<colOne[i]) {
                colOneMax = colOne[i];
            }
            if(colTwoMax < colTwo[i]) {
                colTwoMax = colTwo[i];
            }
        }

        if(colOneMax > colTwoMax) {
            colTwoMax = 0;
            for(int i=0; i<sizes.length; i++) {
                if(colTwo[i]>colOne[i]) {
                    colTwo[i] = colOne[i];
                }
                if(colTwoMax < colTwo[i]) {
                    colTwoMax = colTwo[i];
                }
            }
        }else {
            colOneMax = 0;
            for(int i=0; i<sizes.length; i++) {
                if(colOne[i]>colTwo[i]) {
                    colOne[i] = colTwo[i];
                }
                if(colOneMax < colOne[i]) {
                    colOneMax = colOne[i];
                }
            }
        }
        return colOneMax * colTwoMax;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] sizes = {{10, 7}, {12, 3}, {8, 15}, {14, 7}, {5,15}};
        System.out.println(solution.solution(sizes));
    }
}
