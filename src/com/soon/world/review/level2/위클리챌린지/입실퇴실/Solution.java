package com.soon.world.review.level2.위클리챌린지.입실퇴실;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Solution {


    /**
     *
     *  로직 설명
     *  enter = [1,4,2,3]
     *  leave = [2,1,3,4]
     *  room = []
     *  먼저, 회의실에 사람을 입장 시킵니다. 언제까지 입실시키냐면 leave 배열 첫번째 인덱스에 값과 마지막에 입실한 사람이 같을 때 까지 입니다.
     *  room = [1,4,2]  enter index = 2, leave index = 0 인 상태가 됩니다.
     *  이제 방안에 있는사람들을 보고 계산을 하는데, 2번은 이제 나갈 사람입니다. 즉 2번은 1,4 두명과 반드시 만나게 됩니다.
     *  정리하면 2번은 나갈 때 방에 있는 모든 사람과 만난다는 말과 같게 됩니다. (room 에 남아있는 사람의 수만큼)
     *  room = [1,4]   enter index = 2, leave index =0 , answer =[0,2,0,0] --> 2번의 경우 실제로는 1번째 인덱스에 들어가게됩니다. (예시를 보면 알 수 있습니다)
     *  다음으로 방에 남아있는 인원에 대해 처리해 줍니다. 방금 나간 2번이 1번과 4번을 만났으니 반대로 1번과 4번 입장에서는 2번을 반드시 만난게 되겠죠?
     *  따라서 answer = [1,2,0,1] 인 상태가 됩니다. (방에 남아있는 사람들 번호에서 -1 한 값에 +1씩 넣어주면 되겠죠? 인덱스는 0부터 시작이니까요)
     *  이제 다시 다음 사람을 퇴실시키기 위해 leave 배열을 확인 합니다. 0번째 인덱스는 처리했으니 1번째 인덱스를 봐야겠죠
     *  정리하면 현재 room = [1,4] , enter index = 2 , leave index = 0+1 이 됩니다.
     *  leave index 1 값인 1은 현재 room 안에 들어있습니다. 아까와 마찬가지로 방에서 퇴실 시킨 후 계산 합니다.
     *  room=[4] 가 될 것이고 퇴실한 1은 반드시 4를 만나게 됩니다. 마찬가지로 room 에 남아있는 사람 수만큼을 인덱스에 더해줍니다. answer=[2,2,0,1]
     *  이제 4번도 1번과 반드시 만난 것이니 마찬가지로 4번이 들어갈 인덱스 자리에 +1을 해줍니다. answer=[2,2,0,2]
     *  이제 다음 퇴실할 사람을 또 찾아봅시다. leave index = 2 가 되겠죠
     *  leave index 2 값인 3은 현재 room 안에 없습니다. 없으니 나머지 사람들 입실 시켜야 겠죠?
     *  현재 enter index =2 , leave index = 2 , room = [4] 인 상태 입니다.
     *
     *  입실 시킵니다. room = [4,3] 이 되고 마지막 입실한 3 은 leave index 2 값인 3과 동일합니다. 이제 조건을 탈출 합니다.
     *  자 이제 다시 퇴실 시킵니다.
     *  room = [4] 가 되며 3이 나올겁니다. 3은 나오면서 4를 반드시 만난게 됩니다. 따라서 3이 들어갈 인덱스자리에 방안에 있는 사람수를 더해줍니다. answer=[2,2,1,2]
     *  마찬가지로 방안에 있는 4도 3을 반드시 만난거니까 4가 들어갈 인덱스값도 +1 해줘야겠죠?
     *  answer = [2,2,1,3] 가 됩니다. 또 leave index 를 늘려주고 다음 퇴실할 사람이 방에 있는지 찾아봅니다. 현재 leave index 는 3이 됩니다.
     *  leave index 3 인 값 4는 room 에 들어있죠? 그럼 4를 뺍니다. 4를 뺏더니 방에 있는사람이 없네요 그럼 방 사이즈만큼 더해도 +0을 더한것과 같게 됩니다. (방에 사람이 없으니까요)
     *  이제 leave index 는 4가 되고 인덱스 최대를 벗어납니다. 따라서 조건을 완전 탈출 시킵니다.
     *
     *  이제 모든 처리가 끝났습니다. answer=[2,2,1,3]
     *
     *
     *
     *
     * @param enter
     * @param leave
     * @return
     */
    public int[] solution(int[] enter, int[] leave) {
        int[] answer = new int[enter.length]; //인덱스 자리에 회의실 사람 번호의 만난 횟수를 입력해야 합니다. 인덱스는 0부터 시작이니까 집어넣을때 해당 사람번호에서 -1해서 넣어줘야겠죠?
                                                // 예를들면 결과에서 1번사람의 만난 횟수는 인덱스 0번에 저장됩니다.
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
                        j++;  //j값을 늘려놔야 위 room 로직 처리 후 바로 다음사람부터 회의실에 넣을 수 있으므로 값을 늘려줍니다. (이 부분이 이해하기 힘들었습니다)
                        break;
                    }else {
                        j++; //다음사람을 회의실에 넣기 위해 처리해줘야 합니다.
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
