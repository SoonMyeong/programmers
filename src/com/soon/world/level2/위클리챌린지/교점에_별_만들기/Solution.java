package com.soon.world.level2.위클리챌린지.교점에_별_만들기;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    /**
     * 아.. 이거 배열로 할땐 되는데 객체로하니까 메모리 초과나네..?!
     */

    static long minX  = Integer.MAX_VALUE;
    static long minY = Integer.MAX_VALUE;
    static long maxX = Integer.MIN_VALUE;
    static long maxY = Integer.MIN_VALUE;

    static class Point {
        long x;
        long y;
        Point(long x, long y) {
            this.x = x;
            this.y = y;
        }

        public long getX() {
            return x;
        }

        public long getY() {
            return y;
        }

        @Override
        public String toString() {
            return "Point{" +
                    "x=" + x +
                    ", y=" + y +
                    '}';
        }
    }

    public String[] solution(int[][] line) {
        List<Point> list = new ArrayList<>();
        for(int i=0; i<line.length-1; i++) {
            for(int j=i+1; j< line.length; j++) {
                long a = line[i][0];
                long b = line[i][1];
                long e = line[i][2];

                long c = line[j][0];
                long d = line[j][1];
                long f = line[j][2];

                long denominator = (a*d) - (b*c);
                long moleculeX = (b*f) - (e*d);
                long moleculeY = (e*c) - (a*f);
                long x, y;

                if(denominator ==0) continue;
                if(moleculeX % denominator != 0 || moleculeY % denominator != 0) continue;

                x = moleculeX / denominator;
                y = moleculeY / denominator;

                minX = Math.min(minX,x);
                minY = Math.min(minY,y);
                maxX = Math.max(maxX,x);
                maxY = Math.max(maxY,y);

                list.add(new Point(x,y));
            }
        }

        List<String> board = new ArrayList<>();
        StringBuilder boardSb = new StringBuilder();
        for(long i=minY; i<=maxY; i++) {
            for(long j=minX; j<=maxX; j++) {
                boardSb.append(".");
            }
            board.add(boardSb.toString());
            boardSb.setLength(0);
        }

        //교점 처리
        for(Point point : list ) {
            int idx = Math.toIntExact(Math.abs(point.getY() - maxY));
            StringBuilder sb = new StringBuilder(board.get(idx));
            sb.setCharAt(Math.toIntExact(Math.abs(point.getX() - minX)),'*');
            board.set(idx,sb.toString());
        }

        String[] answer = new String[board.size()];
        for(int i=0; i<answer.length; i++) {
            answer[i] = board.get(i);
        }

        return answer;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] line = {{2, -1, 4}, {-2, -1, 4}, {0, -1, 1}, {5, -8, -12}, {5, 8, 12}};
        String[] result = solution.solution(line);

        for(String str : result) {
            System.out.println(str);
        }

    }
}
