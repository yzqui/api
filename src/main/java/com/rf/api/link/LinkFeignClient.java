package com.rf.api.link;

import com.github.seanyinx.wing.spring.common.Response;
import com.rf.api.log.FeignConfiguration;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

@FeignClient(value = "link", url = "http://localhost:8070",
        configuration = FeignConfiguration.class)
public interface LinkFeignClient {

    @PostMapping(value = "/link/save")
    Response<String> shortUrls(@RequestBody Object param);

    @GetMapping(value = "/link/getByShortUrl/")
    Response<String> getOriginalUrlByShortUrl(@RequestParam("shortUrl") String shortUrl);

    @GetMapping(value = "/link/getTopLinks/")
    Response<List<Map<String, Object>>> getTopLinks(@RequestParam("n") Object n);

}
