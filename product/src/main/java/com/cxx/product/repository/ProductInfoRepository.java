package com.cxx.product.repository;


import com.cxx.product.dataobject.ProductInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author cxx
 */
public interface ProductInfoRepository extends JpaRepository<ProductInfo, String> {

    /**
     * @param productStatus
     * @return
     */
    List<ProductInfo> findByProductStatus(Integer productStatus);

    /**
     * @param productLidtId
     * @return
     */
    List<ProductInfo> findByProductIdIn(List<String> productLidtId);
}
