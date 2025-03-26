package com.younggalee.order.controller;

import com.younggalee.menu.model.dto.MenuDto;
import com.younggalee.order.model.dto.OrderDto;
import com.younggalee.order.model.dto.OrderMenuDto;
import com.younggalee.order.model.service.OrderService;
import com.younggalee.order.view.PrintResultView;

import java.io.IOError;
import java.util.List;
import java.util.Map;

public class OrderController {
    private OrderService orderService = new OrderService();
    private PrintResultView printResultView = new PrintResultView();

    public List<MenuDto> selectOrderableMenuList(String categoryNum){
        // 조회하기 위한 서비스 호출해야함.
        // 컨트롤러에서는 데이터 가공처리등이 이루어짐
        int categoryCode = Integer.parseInt(categoryNum);
        List<MenuDto> list = orderService.selectOrderableMenuList(categoryCode);
        return list;
    }

    public void registOrder(Map<String, Object> requestParam){
        // 요청시 전달값 뽑기
        List<OrderMenuDto> orderMenuList = (List<OrderMenuDto>)requestParam.get("orderMenuList"); // ob부모 > list자식으로 다운캐스팅
        int totalPrice = (int)requestParam.get("totalPrice");

         // DTO 담기 : orderDTO
        OrderDto order = new OrderDto();
        order.setTotalOrderPrice(totalPrice); // 오더dto에는 totalprice 넣을 곳은 있지만 list넣을 필드는 없다 따라서 만들어줘야됨
        order.setOrderMenuList(orderMenuList);


        int result = orderService.registOrder(order);

        if (result > 0 ){
            printResultView.displaySuccessMessage("order");
        } else {
            printResultView.displayFailMessage("order");
        }
    }


    public List<OrderDto> selectOrderList(){
        List<OrderDto> list = orderService.selectOrderList();
        return list;
    }

    public List<OrderMenuDto> selectOrderDetail(String code){
        int orderCode = Integer.parseInt(code);
        List<OrderMenuDto> list = orderService.selectOrderDetail(orderCode);
        return list;
    }

    public void selectMenuByName(String search){
        MenuDto menu = orderService.selectMenuByName(search);

        if(menu == null){ // 검색결과가 없을 경우
            printResultView.displayFailMessage("search");
        }else{ // 검색결과 있을 경우
            printResultView.displaySearchResult(menu);
        }
    }
}
