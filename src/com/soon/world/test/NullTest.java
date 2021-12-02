package com.soon.world.test;


import java.util.Optional;

class Soon {
    private String lastName;
    private String firstName;

    Soon(){};

    Soon(String firstName, String lastName) {
        this.firstName= firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }
}

public class NullTest {

    public static void main(String[] args) {
        firstProblem();
        antiOptionalCase();
        rightNullCheck();
    }


    public static void firstProblem() {
        Soon soon = getSoonInstance();
        System.out.println(soon.getFirstName());
        System.out.println("------------------FIRST---");
    }

    //https://stackoverflow.com/questions/67698766/sonar-compliant-way-to-map-enum-to-name
   //https://community.sonarsource.com/t/java-optional-used-as-replacement-for-local-null-check/43842
    public static void antiOptionalCase() {
        //이게 단순 null 체크를 위한 optional 사용 예
        Soon soon = Optional.ofNullable(getSoonInstance()).orElseGet(()-> new Soon("순명","권"));

        // 아래 지점에서의 getter 함수 호출 시 NPE 이 나올 수 있는 가능성을 배제 시키기 위해
        // (soon 오브젝트가 null 일 경우)
        System.out.println(soon.getFirstName());
        System.out.println("------------------ANTI OPTIONAL---");
    }

    public static void rightNullCheck() {
        Soon soon = getSoonInstance();
        //단순 null 체크를 위한 optional 사용 예 2
        if(soon ==null) {
            soon = new Soon("순명", "권");
        }
        System.out.println(soon.getFirstName());
    }

    public static Soon getSoonInstance() {
        return null;
    }

}
