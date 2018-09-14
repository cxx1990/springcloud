package com.cxx.product.service;


import com.cxx.common.DecreaseStockInput;
import com.cxx.common.ProductInfoOutput;
import com.cxx.product.dataobject.ProductInfo;

import java.util.List;

/**
 * Created by cxx
 * 2017-12-09 21:57
 */
public interface ProductService {

    /**
     * 查询所有在架商品列表
     */
    List<ProductInfo> findUpAll();

    /**
     * 查询商品列表
     *
     * @param productIdList
     * @return
     */
    List<ProductInfo> findList(List<String> productIdList);

    /**
     * 扣库存
     *
     * @param decreaseStockInputList
     */
    void decreaseStock(List<DecreaseStockInput> decreaseStockInputList);
}
