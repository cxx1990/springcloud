package com.cxx.product.service;



import com.cxx.product.dataobject.ProductCategory;

import java.util.List;

/**
 * 类目
 * Created by cxx
 * 2017-12-09 22:06
 */
public interface CategoryService {

    List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList);
}
