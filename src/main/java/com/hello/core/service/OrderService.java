package com.hello.core.service;

import com.hello.core.order.Order;

public interface OrderService {

    Order createOrder(Long memberId, String itemName, int itemPrice);

}
