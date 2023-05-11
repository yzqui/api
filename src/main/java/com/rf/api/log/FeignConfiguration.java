package com.rf.api.log;

import feign.Logger;
import org.springframework.context.annotation.Bean;

/**
 * @author cdd
 * @date 2022/12/21
 */
public class FeignConfiguration {
    @Bean
    public Logger.Level feignLogLevel(){
        return Logger.Level.BASIC;
    }

    @Bean
    Logger feignLogger() {
        return new MyFeignLogger();
    }

}