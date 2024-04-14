package basic.정수를나선형으로배치;

import org.junit.jupiter.api.Test;

public class Solution {
    @Test
    void 정수를_나선형으로_배치하기() {
        print(solution(4));
        System.out.println("-------");
        print(solution(5));
    }

    private void print(int[][] example1) {
        for (int[] ints : example1) {
            for (int j = 0; j < example1.length; j++) {
                System.out.print(ints[j] + " ");
            }
            System.out.println();
        }
    }

    /*

     문제> 정수를 나선형으로 배치하기
     - https://school.programmers.co.kr/learn/courses/30/lessons/181832
     양의 정수 n이 매개변수로 주어집니다.
     n × n 배열에 1부터 n2 까지 정수를 인덱스 [0][0]부터
     시계방향 나선형으로 배치한 이차원 배열을 return 하는 solution 함수를 작성해 주세요.

     접근방법>
     동서남북으로 나누어 n -1개씩 추가하게끔 나누면
     모두 똑같은 개수로 맞출 수 있음.
     순서는 북->동->남->서 로 작성

     북쪽 : 열을 증가하면서 값 추가
     서쪽 : 행을 증가하면서 값 추가
     남쪽 : 열을 감소하면서 값 추가
     서쪽 : 행을 감소하면서 값 추가
     ex)
     n = 3일 때 (홀수)
     북쪽 : 1,2
     동쪽 : 3,4
     남쪽 : 5,6
     서쪽 : 7,8

     마지막 북쪽 : 9

     n = 4 일 때 (짝수)
     북쪽 : 1,2,3
     동쪽 : 4,5,6
     남쪽 : 7,8,9
     서쪽 : 10,11,12

     북쪽 : 13
     동쪽 : 14
     남쪽 : 15
     서쪽 : 16

     n = 5일 경우 ...
     n =3 일 때와 똑같은 위치에서 끝남
     n = 6일 경우 ...
     n =4 일 때와 똑같은 위치에서 끝남

     즉, 2가지 케이스만 고려 하여 작성
   */
    public int[][] solution(int n) {
        int[][] answer = new int[n][n];
        int num = 1;
        int count = 0;
        while(num < n*n) {
            //북쪽
            for(int i =count; i<n-count-1; i++) {
                answer[count][i] = num++;

            }
            //동쪽
            for(int i =count; i<n-count-1; i++) {
                answer[i][n-1-count] = num++;

            }
            //남쪽
            for(int i =n-1-count; i>count; i--) {
                answer[n-1-count][i] = num++;

            }
            //서쪽
            for(int i =n-1-count; i>count; i--) {
                answer[i][count] = num++;
            }
            count++;
        }

        //n이 홀수일 경우 마지막 값을 입력받기 위한 case
        if(n%2 != 0) {
            answer[count][count] = num;
        }

        return answer;
    }
}
