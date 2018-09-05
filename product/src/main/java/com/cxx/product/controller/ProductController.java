package com.cxx.product.controller;


import com.cxx.product.VO.ProductInfoVO;
import com.cxx.product.utils.ResultVoUtil;
import com.cxx.product.dataobject.ProductCategory;
import com.cxx.product.dataobject.ProductInfo;
import com.cxx.product.VO.ProductVO;
import com.cxx.product.VO.ResultVo;
import com.cxx.product.service.CategoryService;
import com.cxx.product.service.ProductService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 商品
 * @author cxx
 */
@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    public CategoryService categoryService;
    @Autowired
    public ProductService productService;


    @GetMapping("list")
    public ResultVo<ProductVO> list(){
        List<ProductInfo> productInfoList = productService.findUpAll();
        List<Integer> categroyTypeList = productInfoList.stream().map(ProductInfo::getCategoryType).collect(Collectors.toList());
        List<ProductCategory>  productCategoryList = categoryService.findByCategoryTypeIn(categroyTypeList);

        List<ProductVO> productVOList =new ArrayList<>();
        for (ProductCategory productCategory:productCategoryList){
            ProductVO productVO = new ProductVO();
            productVO.setCategoryName(productCategory.getCategoryName());
            productVO.setCategoryType(productCategory.getCategoryType());

             List<ProductInfoVO> productInfoVOList =new ArrayList<>();
            for (ProductInfo productInfo : productInfoList){
                if(productInfo.getCategoryType().equals(productCategory.getCategoryType())){
                    ProductInfoVO productInfoVo1 =new ProductInfoVO();
                    BeanUtils.copyProperties(productInfo,productInfoVo1);
                    productInfoVOList.add(productInfoVo1);
                }
            }
            productVO.setProductInfoVOList(productInfoVOList);
            productVOList.add(productVO);
        }
        return ResultVoUtil.success(productVOList);


    }

}
