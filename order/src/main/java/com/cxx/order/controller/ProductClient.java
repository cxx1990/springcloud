package com.cxx.order.controller;

import com.cxx.common.DecreaseStockInput;
import com.cxx.order.dataobject.ProductInfo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient(name="product")
public interface ProductClient {
    @GetMapping("msg")
    String profuctFeign();

    @PostMapping("/product/listForOrder")
    List<ProductInfo> listForOrder(@RequestBody List<String> strings);

    @PostMapping("/product/decreaseStock")
      void decreaseStock(@RequestBody List<DecreaseStockInput> decreaseStockInputList);

}
