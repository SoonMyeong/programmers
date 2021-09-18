package com.soon.world.review.level2.위클리챌린지.입실퇴실;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Solution {

    public int[] solution(int[] enter, int[] leave) {
        int[] answer = new int[enter.length];
        Set<Integer> room = new HashSet<>(); //ArrayList 를 쓸 경우 remove 시 내부 인덱스 옮기는 작업이 전체 작업시간에 부하를 일으킬 수 있습니다.
        int i = 0;
        int j = 0;
        //퇴실하는 순번을 만나기 전까지는 입실 시켜준다.
        while(i<leave.length) {
            if (room.contains(leave[i])) {  //회의실에 퇴실에 적힌 i번째 사람이 존재한다면
                room.remove(leave[i]);  //그사람을 회의실에서 빼준 뒤
                answer[leave[i]-1] += room.size(); //그사람 자리에 대해 회의실에 있는 사이즈만큼 더해준다. //왜냐?-> 1,4,2 에서 2가 나올경우 2는 1과 4를 모두 만났기 때문에 사이즈만큼이 된다.

                for (int num : room) { //회의실에 남아있는 사람에 대해
                    answer[num-1]++; //그 사람들은 각각 1씩 더해준다. // 왜냐? -> 아까 나간애가 혼자만난건 아니잖아요? 방에 만난 상대에 대해 +1씩 더해줘야 합니다.
                                    //위에 예로 얘기하자면 2의 경우 값은 2가되고 1 과 4는 2를 만났으니까 1과 4에 각각 1씩 더해주는 겁니다.
                }
                i++; //일련의 작업이 끝났으니 다음 나간 사람을 찾기 위해 변수를 늘려줍니다.
            }else {
                while(j<enter.length) {
                    room.add(enter[j]); //회의실 퇴실에 적힌사람이 없으면 퇴실에 적힌 사람이 나올때 까지 회의실에 사람을 집어넣습니다. 왜냐? -> 그래야 퇴실순서대로 퇴실 시키니까
                    if (enter[j] == leave[i]) { //드디어 퇴실할 순번이 되었다면
                        j++;  //j값을 늘려놔야 위 처리 후 바로 다음사람부터 회의실에 넣을 수 있으므로 값을 늘려줍니다. (이 부분이 이해하기 힘들었습니다)
                        break;
                    }else {
                        j++; //enter 에 들어있는 사람이 나가게 하기위해 다음사람을 회의실에 넣기 위해 처리해줘야 합니다.
                    }
                }
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] enter = {1,4,2,3};
        int[] leave = {2,1,3,4};
        System.out.println(Arrays.toString(solution.solution(enter, leave)));
    }
}
