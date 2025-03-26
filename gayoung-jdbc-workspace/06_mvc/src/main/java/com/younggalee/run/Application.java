package com.younggalee.run;

public class Application {
    public static void main(String[] args) {

               /*
            ## MVC 패턴 ##
            1. 자바 백엔드에서 가장 대중적으로 사용되는 패턴
            2. 데이터(Model), UI담당(View), 요청처리(Controller)을 역할별로 명확히 분리해서 작성
            3. 장점
               - 개발 속도 향상
               - 재사용성 증가
               - 유지보수성 증가
               - 확장성
         */

        /*
            ## 패키지 설계 방식 ##
            1. 계층형 (소규모에 적합)
               - 분리기준 : MVC 패턴 역할별
               - 예시
                 com.example.myapp
                    ├── controller
                    ├── service
                    ├── dao
                    └── dto
               - 장점 : 역할이 명확하여 코드 계층 파악이 쉬움
                 단점 : 대규모 프로젝트에서 계층 내부가 복잡해질 수 있음

            2. 도메인형 (대규모에 적합)
               - 분리기준 : 업무 도메인별 (쉽게 서비스별)
               - 예시
                 com.example.myapp
                    ├── user
                    │   ├── controller
                    │   ├── service
                    │   ├── dao
                    │   └── dto
                    ├── order
                    │   ├── controller
                    │   ├── service
                    │   ├── dao
                    └── └── dto
               - 장점 : 특정 도메인의 모든 코드가 한곳에 있어 응집도 높음
                 단점 : 업무 단위가 많으면 패키지가 지나치게 많아질 수 있음
         */




        new MainView().mainMenuView();

    }

    /* 패키지 설계 방식
    1. 계층형 (소규모)

    2. 도메인형 (대규모)
     */
}