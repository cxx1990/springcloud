package com.cxx.order.service;


import com.cxx.order.dto.OrderDTO;

public interface OrderService {

     /**
     * 创建订单
     * @param orderDTO
     * @return*/

    OrderDTO create(OrderDTO orderDTO);
}
