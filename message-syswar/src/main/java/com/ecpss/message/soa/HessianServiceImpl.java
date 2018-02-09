package com.ecpss.message.soa;

import com.ecpss.message.api.hessian.HessianService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * Created by chenpang on 2018/2/9.
 */
@Service("hessianService")
public class HessianServiceImpl implements HessianService {
    Logger logger = LoggerFactory.getLogger(getClass());
    @Override
    public void hessianWelcome(String s) {
        logger.info("接受hessian请求，参数:" + s);
        System.out.println("welcome to hessian:" + s);
    }
}
