package com.soon.world.level1.신규아이디추천;

import java.util.Locale;

public class Solution {


    /**
     * 문제에 나와있는 7단계를 구현할 수 있냐는 문제, 내용 그대로 구현 하면 되므로 레벨 1에 해당함
     * 정규식 평소에 잘 안썼는데 이 기회에 다시 보게 될 수 있는 기회가 됨
     * ------------------------------------------------------
     * 1단계 new_id의 모든 대문자를 대응되는 소문자로 치환합니다.
     * 2단계 new_id에서 알파벳 소문자, 숫자, 빼기(-), 밑줄(_), 마침표(.)를 제외한 모든 문자를 제거합니다.
     * 3단계 new_id에서 마침표(.)가 2번 이상 연속된 부분을 하나의 마침표(.)로 치환합니다.
     * 4단계 new_id에서 마침표(.)가 처음이나 끝에 위치한다면 제거합니다.
     * 5단계 new_id가 빈 문자열이라면, new_id에 "a"를 대입합니다.
     * 6단계 new_id의 길이가 16자 이상이면, new_id의 첫 15개의 문자를 제외한 나머지 문자들을 모두 제거합니다.
     *      만약 제거 후 마침표(.)가 new_id의 끝에 위치한다면 끝에 위치한 마침표(.) 문자를 제거합니다.
     * 7단계 new_id의 길이가 2자 이하라면, new_id의 마지막 문자를 new_id의 길이가 3이 될 때까지 반복해서 끝에 붙입니다.
     *
     * @param new_id
     * @return
     */

    public String solution(String new_id) {

        //step 1
        String tmp = new_id.toLowerCase();

        //step 2
        // \w :알파벳이나 숫자 , \-_. : 빼기, 밑줄, 마침표
        //[] 안에 ^를 쓸 경우 not 의 의미가 된다. [] 밖에 쓰면 ~로 시작하는 문자
        tmp = tmp.replaceAll("[^\\w\\-_.]*","");

        //step 3
        // .{2,} : .이 2번이상 쓰인 경우  {2,}: 2회 이상
        tmp = tmp.replaceAll("\\.{2,}",".");

        //step 4
        //^[.] : 마침표로 시작하거나 [.]$ : 마침표로 끝나는 경우
        tmp = tmp.replaceAll("^[.]|[.]$","");

        //step 5
        if(tmp.equals("")) {
            tmp ="a";
        }
        //step 6
        if(tmp.length() >=16) {
            tmp = tmp.substring(0,15);
            tmp = tmp.replaceAll("[.]$","");
        }
        //step 7
        if(tmp.length() <=2) {
            while(tmp.length()<3) {
                String finalStr = tmp.substring(tmp.length() - 1);
                tmp += finalStr;
            }
        }
        return tmp;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String new_id = "...!@BaT#*..y.abcdefghijklm";
        System.out.println(solution.solution(new_id));
    }

}
