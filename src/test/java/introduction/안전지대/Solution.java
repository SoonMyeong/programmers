package introduction.안전지대;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution {
    @Test
    void 안전지대() {
        Assertions.assertThat(solution(new int[][]{
                {0, 0, 0, 0, 0}
                , {0, 0, 0, 0, 0}
                , {0, 0, 0, 0, 0}
                , {0, 0, 1, 0, 0}
                , {0, 0, 0, 0, 0}})).isEqualTo(16);

        Assertions.assertThat(solution(new int[][]{
                {0, 0, 0, 0, 0}
                , {0, 0, 0, 0, 0}
                , {0, 0, 0, 0, 0}
                , {0, 0, 1, 1, 0}
                , {0, 0, 0, 0, 0}})).isEqualTo(13);

        Assertions.assertThat(solution(new int[][]{
                {1, 1, 1, 1, 1}
                , {1, 1, 1, 1, 1}
                , {1, 1, 1, 1, 1}
                , {1, 1, 1, 1, 1}
                , {1, 1, 1, 1, 1}})).isEqualTo(0);

    }

    /*
        문제 : 안전지대
        https://school.programmers.co.kr/learn/courses/30/lessons/120866
        접근 방법 :
        지뢰찾기 게임과 동일함
        쉽게 접근해보면 시간복잡도 2N 으로 풀어내는 방법으로
        배열을 순회하면서 1을 찾고, 1을 찾을 때 마다 인접한 위 아래 좌우 대각선을 표시해준다.
        그 다음 다시 배열을 순회하면서 0의 개수를 구한다.
        n이 최대 100이니까 최대 2만번 정도 순회하는거니까 괜찮을거 같다.

        좋아요 많은 풀이 :
        나같은 경우 대각선은 dia 배열로 뺐는데 빼지말고 dx, dy 로 구성해서 8개로 for 문 돌렸으면
        시간복잡도 N 으로 풀 수 있었네

     */
    public static int[] dx = {-1,1,0,0};
    public static int[] dy = {0,0,1,-1};
    public static int[] dia ={-1,1};
    public int solution(int[][] board) {
        int answer = 0;
        for(int i = 0; i<board.length; i++) {
            for(int j = 0; j<board[i].length; j++) {
                if(board[i][j] == 1) {
                    checkX(board, i, j);
                }
            }
        }

        for (int[] ints : board) {
            for (int anInt : ints) {
                if (anInt == 0) {
                    answer++;
                }
            }
        }
        return answer;
    }

    private void checkX(int[][] board, int i, int j) {
        for(int k = 0; k < 2; k++) {
            if((i + dx[k] >= 0 && i + dx[k] < board.length) && (j + dy[k] >= 0 && j + dy[k] < board.length)) {
                if(board[i + dx[k]][j + dy[k]] != 1) {
                    board[i + dx[k]][j + dy[k]] = -1;
                }
                for(int l = 0; l<2; l++) {
                    if((j + dy[k] + dia[l] >= 0 && j + dy[k] + dia[l] < board.length)) {
                        if(board[ i + dx[k] ][ j+dy[k]+dia[l] ] != 1) {
                            board[ i + dx[k] ][ j+dy[k]+dia[l] ] = -1;
                        }
                    }
                }
            }
        }

        for(int k = 2; k < 4; k++) {
            if((i + dx[k] >= 0 && i + dx[k] < board.length) && (j + dy[k] >= 0 && j + dy[k] < board.length)) {
                if(board[i + dx[k]][j + dy[k]] != 1) {
                    board[i + dx[k]][j + dy[k]] = -1;
                }
                for(int l = 0; l<2; l++) {
                    if((i + dx[k] + dia[l] >= 0 && i + dx[k] + dia[l] < board.length)) {
                        if(board[ i+dx[k]+dia[l] ][ j + dy[k] ] != 1) {
                            board[ i+dx[k]+dia[l] ][ j + dy[k] ] = -1;
                        }
                    }
                }
            }
        }
    }

}
