package com.cxx.order.controller;

import com.cxx.common.DecreaseStockInput;
import com.cxx.order.dataobject.ProductInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
public class ClientController {
   /* @GetMapping("/getproductmsg")
    public  String getproductMsg(){
        RestTemplate restTemplate = new RestTemplate();
      String rep = restTemplate.getForObject("http://localhost:8090/msg",String.class);
        return  rep;
    }

*/
/*    @Autowired
    private LoadBalancerClient loadBalancerClient;*/
   @Autowired
   private ProductClient productClient;

    @GetMapping("/getproductmsg1")
    public  String getproductMsg1(){
       /* RestTemplate restTemplate = new RestTemplate();*/

      /*  ServiceInstance serviceInstance = loadBalancerClient.choose("PRODUCT");*/
        String rep = productClient.profuctFeign();
                //restTemplate.getForObject(String.format("http://%s:%s",serviceInstance.getHost(),serviceInstance.getPort()+"/msg"),String.class);
        return  rep;
    }


    @PostMapping("/getproductList")
    public  List<ProductInfo> getProductList(){
        List<ProductInfo>  hh =  productClient.listForOrder(Arrays.asList("157875196366160022"));
     return null;
    }


    @PostMapping("/decreaseStock")
    public  String decreaseStock(){
        List<DecreaseStockInput> list = new ArrayList<>();
        DecreaseStockInput decreaseStockInput = new DecreaseStockInput();
        decreaseStockInput.setProductId("164103465734242707");
        decreaseStockInput.setProductQuantity(1);
        list.add(decreaseStockInput);
        productClient.decreaseStock(list);
        return null;
    }




  /* @Autowired
    public RestTemplate restTemplate;

    @GetMapping("/getproductmsg")
    public  String getproductMsg1() {
        String re = restTemplate.getForObject("http://PRODUCT/msg", String.class);
        return re;
    }*/


}
