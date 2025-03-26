package com.younggalee.order.view;

import com.younggalee.menu.model.dto.MenuDto;

public class PrintResultView {
    public void displaySuccessMessage(String code){
        switch(code){
            case "order" :
                System.out.println("주문 등록 성공");

        }
    }


    public void displayFailMessage(String code){
        switch(code){
            case "order" :
                System.out.println("주문 등록 실패"); break;
            case "search":
                System.out.println("검색결과가 없습니다."); break;
        }
    }

    public void displaySearchResult(MenuDto menu){
        System.out.println("검색결과가 다음과 같습니다.");
        System.out.println(menu);
    }

}
