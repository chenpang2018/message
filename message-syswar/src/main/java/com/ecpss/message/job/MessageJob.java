package com.ecpss.message.job;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * Created by chenpang on 2018/5/9 15:14.
 */
@Component
public class MessageJob {
    @Scheduled(cron = "0/10 * * * * ?")
    public void publishMessageJob() {
        System.out.println("MESSAGE JOB -----");
    }
}
