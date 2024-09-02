package introduction.토이;

import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.stream.Collectors;

public class Solution {

    @Test
    void test2() {
//        int[] input = {4,4,4,4,3}; odd case
        int[] input = {4,3,3};
        List<List<Integer>> combinations = generateCombinations(input, 8);


        System.out.println(combinations);
        System.out.println("----------------------");

        List<List<List<Integer>>> rr = findAllCompleteCombinations(combinations, input).stream()
                .distinct()
                .collect(Collectors.toList());
        final var result = new ArrayList<List<List<Integer>>>();
        for(int i = 0; i< rr.size(); i++) {
            result.add(rr.get(i));
        }

        System.out.println("Complete Combinations: " + result);
        System.out.println("-------------------");

        List<List<Integer>> bestGroup = findBestGroup(result);
        System.out.println("Best Group: " + bestGroup);

        if(bestGroup.size() % 2 != 0) {
            final var res = new ArrayList<List<List<Integer>>>();
            List<List<Integer>> front = new ArrayList<>();
            List<List<Integer>> back = new ArrayList<>();
            for(int i = 0; i<bestGroup.size() -1; i++) {
                front.add(bestGroup.get(i));
            }
            for(int i = 1; i<bestGroup.size(); i++) {
                back.add(bestGroup.get(i));
            }
            res.add(front);
            res.add(back);
            List<List<Integer>> finalRes = findBestGroup(res);
            System.out.println("Final Group :" + finalRes);
        }

    }
    // 가능한 조합을 생성하는 메소드
    public static List<List<Integer>> generateCombinations(int[] input, int maxSum) {
        List<List<Integer>> combinations = new ArrayList<>();

        for (int i = 0; i < input.length; i++) {
            for (int length = 1; length <= 3 && i + length <= input.length; length++) {
                List<Integer> combination = new ArrayList<>();
                int sum = 0;

                for (int j = 0; j < length; j++) {
                    sum += input[i + j];
                    combination.add(input[i + j]);
                }
                if (sum <= maxSum) {
                    combinations.add(combination);
                }
            }
        }

        return combinations;
    }
    // 모든 조합을 사용하여 입력 배열을 완전히 사용하는 조합을 찾는 메소드
    public static List<List<List<Integer>>> findAllCompleteCombinations(List<List<Integer>> combinations, int[] input) {
        List<List<List<Integer>>> result = new ArrayList<>();
        findCombinationsRecursive(combinations, 0, input, new ArrayList<>(), result);
        return result;
    }

    // 재귀적으로 조합을 찾는 메소드
    private static void findCombinationsRecursive(List<List<Integer>> combinations, int startIndex,
                                                  int[] input, List<List<Integer>> currentCombination, List<List<List<Integer>>> result) {

        if (isValidCombination(currentCombination, input)) {
            result.add(new ArrayList<>(currentCombination));
            return;
        }

        for (int i = startIndex; i < combinations.size(); i++) {
            List<Integer> combination = combinations.get(i);
            currentCombination.add(combination);
            findCombinationsRecursive(combinations, i + 1, input, currentCombination, result);
            currentCombination.remove(currentCombination.size() - 1);
        }
    }

    // 현재 조합이 입력 배열을 완전히 사용하는지 확인하는 메소드
    private static boolean isValidCombination(List<List<Integer>> currentCombination, int[] input) {
        List<Integer> combinedList = new ArrayList<>();
        for (List<Integer> comb : currentCombination) {
            combinedList.addAll(comb);
        }
        if (combinedList.size() != input.length) return false;
        for (int i = 0; i < input.length; i++) {
            if (!combinedList.get(i).equals(input[i])) return false;
        }
        return true;
    }

    // 가장 적은 차이값을 가지는 그룹을 찾는 메소드
    public static List<List<Integer>> findBestGroup(List<List<List<Integer>>> groups) {
        List<List<Integer>> bestGroup = null;
        int minDifference = Integer.MAX_VALUE;

        for (List<List<Integer>> group : groups) {
            int difference = calculateMinDifferenceForGroup(group);
            if (difference < minDifference) {
                minDifference = difference;
                bestGroup = new ArrayList<>(group); // 올바르게 깊은 복사
            }
        }

        return bestGroup;
    }

    // 그룹의 페어 간 차이의 최소값을 계산하는 메소드
    public static int calculateMinDifferenceForGroup(List<List<Integer>> group) {
        int minDifference = 0;

        for (int i = 0; i < group.size() - 1; i++) {
            List<Integer> firstPair = group.get(i);
            List<Integer> secondPair = group.get(i + 1);
            int diff = Math.abs(sumList(firstPair) - sumList(secondPair));
            minDifference = Math.max(minDifference, diff);
        }

        return minDifference;
    }

    // 리스트의 합을 계산하는 메소드
    public static int sumList(List<Integer> list) {
        int sum = 0;
        for (int num : list) {
            sum += num;
        }
        return sum;
    }
}
