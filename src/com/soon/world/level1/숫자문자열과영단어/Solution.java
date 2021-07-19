package com.soon.world.level1.숫자문자열과영단어;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;


/**
 *
 * String[] digits = {"0","1","2","3","4","5","6","7","8","9"};
 * String[] alphabets = {"zero","one","two","three","four","five","six","seven","eight","nine"};
 *
 *  for(int i=0; i<10; i++){
 *      s = s.replaceAll(alphabets[i],digits[i]);
 *  }
 * --> 이렇게 쉽게 풀 수 있음...쩝.. replaceAll.. 코드 작성간에도 자주 쓰는데..ㅠ
 *
 */
public class Solution {

    public int solution(String s) {
        Map<String,Integer> stringConvertInteger = new HashMap<>();
        stringConvertInteger.put("zero",0);
        stringConvertInteger.put("one",1);
        stringConvertInteger.put("two",2);
        stringConvertInteger.put("three",3);
        stringConvertInteger.put("four",4);
        stringConvertInteger.put("five",5);
        stringConvertInteger.put("six",6);
        stringConvertInteger.put("seven",7);
        stringConvertInteger.put("eight",8);
        stringConvertInteger.put("nine",9);

        StringBuilder answer = new StringBuilder();
        StringBuilder number = new StringBuilder();

        for(int i=0; i<s.length(); i++) {
            if(String.valueOf(s.charAt(i)).matches("[0-9]")) {
                answer.append(s.charAt(i));
            }else {
                number.append(s.charAt(i));
                if(stringConvertInteger.containsKey(number.toString())) {
                    answer.append(stringConvertInteger.get(number.toString()));
                    number.delete(0,number.length());
                }
            }
        }
        return Integer.parseInt(answer.toString());
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = "one4seveneight";
        System.out.println(solution.solution(s));
    }
}
