package com.ecpss.message.soa;

import com.ecpss.message.api.hessian.HessianService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.remoting.caucho.HessianServiceExporter;

import javax.annotation.Resource;

/**
 * Created by chenpang on 2018/2/9.
 */
@Configuration
public class HessianExpertor{
    Logger logger = LoggerFactory.getLogger(getClass());
    @Resource
    private HessianService hessianService;


    @Bean(name = "/hessian/hessianService")
    public HessianServiceExporter getHessianBean() {
        logger.info("发布hessian服务，服务地址:" + "/hessian/hessianService");
        HessianServiceExporter exporter = new HessianServiceExporter();
        exporter.setServiceInterface(HessianService.class);
        exporter.setService(hessianService);
        return exporter;
    }
}
