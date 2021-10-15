package com.soon.world.level3.다단계_칫솔_판매;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution {

    class User {
        String name;
        int money;
        User parent;

        public User(String name, User user) {
            this.name = name;
            this.parent = user;
        }

        public void calculateMoney(int money) {
            int benefit = money / 10;
            this.money+= money -benefit;

            if(this.parent !=null && benefit >=1) {
                this.parent.calculateMoney(benefit);
            }
        }
    }

    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        Map<String,User> map = new HashMap<>();
        int[] answer = new int[enroll.length];

        for(String user : enroll) {
            map.put(user,new User(user,null));
        }

        for(int i=0; i<referral.length; i++) {
            if(referral[i].equals("-")) {
                continue;
            }
            map.get(enroll[i]).parent = map.get(referral[i]);
        }

        for(int i=0; i< seller.length; i++) {
            map.get(seller[i]).calculateMoney(amount[i]*100);
        }

        for(int i=0; i< enroll.length; i++) {
            answer[i] = map.get(enroll[i]).money;
        }

        return answer;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String[] enroll = {"john", "mary", "edward", "sam", "emily", "jaimie", "tod", "young"};
        String[] referral = {"-", "-", "mary", "edward", "mary", "mary", "jaimie", "edward"};
        String[] seller = {"young", "john", "tod", "emily", "mary"};
        int[] amount = {12, 4, 2, 5, 10};

        System.out.println(Arrays.toString(solution.solution(enroll, referral, seller, amount)));
    }
}
