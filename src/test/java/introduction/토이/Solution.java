package introduction.토이;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Solution {
    /*
   2,2,2,2,4,3

   2,2,2/2,4/3
   2,2/2,2/4,3

   ---
   2,2,2,2,1,2
   2,2,2,2/1,2
   2,2,2/2,1,2
   2,2/2,2/1,2
    */
    @Test
    void test() {
        List<Integer> elements = List.of(2,2,2,2,4,3);
        int maxGroupSize = 3;
        int maxSum = 8;

        List<List<List<Integer>>> result = findValidGroupings(elements, maxGroupSize, maxSum)
                .stream().distinct().collect(Collectors.toList());

        // 결과 출력
        for (List<List<Integer>> grouping : result) {
            System.out.println(grouping);
        }

        System.out.println("---------------위 결과 정렬------------------------");
        // 정렬 수행
        List<List<List<Integer>>> sortedGroupings = sortByGroupDifference(result);

        // 결과 출력
        for (List<List<Integer>> grouping : sortedGroupings) {
            System.out.println(grouping);
        }

    }

    private static List<List<List<Integer>>> findValidGroupings(List<Integer> elements, int maxGroupSize, int maxSum) {
        List<List<List<Integer>>> allGroupings = new ArrayList<>();

        // 첫 번째 그룹을 최소 2개의 원소로 구성하기 위한 그룹 탐색
        for (int i = 2; i <= Math.min(maxGroupSize, elements.size()); i++) {
            List<Integer> firstGroup = elements.subList(0, i);
            int firstGroupSum = firstGroup.stream().mapToInt(Integer::intValue).sum();

            if (firstGroupSum <= maxSum) {
                List<Integer> remainingElements = elements.subList(i, elements.size());
                List<List<Integer>> currentGrouping = new ArrayList<>();
                currentGrouping.add(new ArrayList<>(firstGroup));
                findGroupings(remainingElements, maxGroupSize, maxSum, currentGrouping, allGroupings);
            }
        }
        return allGroupings;
    }

    private static void findGroupings(List<Integer> elements, int maxGroupSize, int maxSum,
                                      List<List<Integer>> currentGrouping,
                                      List<List<List<Integer>>> allGroupings) {
        if (elements.isEmpty()) {
            // 모든 원소를 그룹화한 경우 결과에 추가
            allGroupings.add(new ArrayList<>(currentGrouping));
            return;
        }

        // 그룹을 만드는 시작점
        for (int i = 2; i <= Math.min(maxGroupSize, elements.size()); i++) {
            List<Integer> group = elements.subList(0, i);
            int sum = group.stream().mapToInt(Integer::intValue).sum();

            if (sum <= maxSum) {
                // 유효한 그룹이면 나머지 원소로 재귀 호출
                List<Integer> remainingElements = elements.subList(i, elements.size());
                List<List<Integer>> newGrouping = new ArrayList<>(currentGrouping);
                newGrouping.add(new ArrayList<>(group));

                // 재귀 호출
                findGroupings(remainingElements, maxGroupSize, maxSum, newGrouping, allGroupings);
            }
        }

        // 남은 원소들 처리: 나머지 그룹이 1개만 남은 경우 그 그룹을 추가
        if (elements.size() > 0) {
            List<Integer> lastGroup = elements;
            int lastGroupSum = lastGroup.stream().mapToInt(Integer::intValue).sum();

            // 마지막 그룹의 합이 최대 합 이하인 경우만 추가
            if (lastGroupSum <= maxSum) {
                List<List<Integer>> newGrouping = new ArrayList<>(currentGrouping);
                newGrouping.add(new ArrayList<>(lastGroup));
                allGroupings.add(new ArrayList<>(newGrouping));
            }
        }
    }

    private static List<List<List<Integer>>> sortByGroupDifference(List<List<List<Integer>>> groupings) {
        return groupings.stream()
                .sorted((g1, g2) -> {
                    double diff1 = calculateGroupDifference(g1);
                    double diff2 = calculateGroupDifference(g2);
                    return Double.compare(diff1, diff2);
                })
                .collect(Collectors.toList());
    }

    private static double calculateGroupDifference(List<List<Integer>> grouping) {
        // 그룹의 합을 계산
        List<Integer> sums = new ArrayList<>();
        for (List<Integer> group : grouping) {
            sums.add(group.stream().mapToInt(Integer::intValue).sum());
        }

        // 그룹 간의 합 차이를 계산
        int n = sums.size();
        if (n < 2) return 0; // 그룹이 하나만 있을 때 차이는 0

        int totalDifference = 0;
        int count = 0;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                totalDifference += Math.abs(sums.get(i) - sums.get(j));
                count++;
            }
        }

        // 평균 차이 계산
        return count > 0 ? (double) totalDifference / count : 0;
    }
}
