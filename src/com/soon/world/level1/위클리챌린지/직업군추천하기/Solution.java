package com.soon.world.level1.위클리챌린지.직업군추천하기;

import java.util.*;

public class Solution {
    static class ResultStore {
        String type;
        int sum;
        ResultStore(String type, int sum) {
            this.type = type;
            this.sum = sum;
        }

        public int getSum() {
            return sum;
        }

        public String getType() {
            return type;
        }
    }
    public String solution(String[] table, String[] languages, int[] preference) {
        int max = 0;
        Map<String,List<String>> map = calculateTable(table);
        List<ResultStore> resultList = new ArrayList<>();
        List<String> resultJobs = new ArrayList<>();

        max = storeSum(resultList, map, languages, preference,0);

        for (ResultStore resultStore : resultList) {
            if (resultStore.getSum() == max) {
                resultJobs.add(resultStore.getType());
            }
        }

        resultJobs.sort(Comparator.naturalOrder());


        return resultJobs.get(0);
    }


    public int storeSum(List<ResultStore> resultList, Map<String, List<String>> map, String[] languages, int[] preference, int max) {
        for(String key : map.keySet()) {
            int sum = 0;
            for(int i=0; i<languages.length; i++) {
                for(int j=0; j<map.get(key).size(); j++) {
                    if(map.get(key).get(j).equals(languages[i])) {
                        sum += (j+1)*preference[i];
                    }
                }
            }
            resultList.add(new ResultStore(key,sum));

            if(sum>max) {
                max = sum;
            }
        };
        return max;
    }

    public Map<String,List<String>> calculateTable(String[] table) {
        Map<String,List<String>> calculateTable = new HashMap<>();
        for(String str : table) {
            String[] splitStr = str.split(" ");
            List<String> languageScore = new ArrayList<>();

            for(int i=splitStr.length-1; i>0; i--) {
                languageScore.add(splitStr[i]);
            }
            calculateTable.put(splitStr[0],languageScore);
        }
        return calculateTable;
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        String[] table = {"SI JAVA JAVASCRIPT SQL PYTHON C#", "CONTENTS JAVASCRIPT JAVA PYTHON SQL C++", "HARDWARE C C++ PYTHON JAVA JAVASCRIPT", "PORTAL JAVA JAVASCRIPT PYTHON KOTLIN PHP", "GAME C++ C# JAVASCRIPT C JAVA"};
        String[] languages = {"PYTHON", "C++", "SQL"};
        int[] preference = {7,5,5};

        System.out.println(solution.solution(table,languages,preference));
    }

}
