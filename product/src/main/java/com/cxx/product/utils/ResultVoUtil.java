package com.cxx.product.utils;

import com.cxx.product.VO.ResultVo;

public class ResultVoUtil {

    public static ResultVo success(Object object) {
        ResultVo resultVO = new ResultVo();
        resultVO.setCode(0);
        resultVO.setMsg("成功");
        resultVO.setData(object);
        return resultVO;
    }
}