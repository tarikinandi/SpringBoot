package com.tarikinandi.scheduled;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class scheduledExample {

    @Scheduled(cron = "0 14 1 * * *")
    public void write1To10(){
        for(int i=1;i<=10;i++){
            System.out.print(i + " ");
        }
    }

}
