package com.rf.api.controller;

import com.github.seanyinx.wing.spring.common.Response;
import com.rf.api.link.LinkFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/")
public class FeignController {

    @Autowired
    private LinkFeignClient linkFeignClient;

    @PostMapping("/shortUrls")
    public Response<String> shortUrls(@RequestBody Object req){
        return linkFeignClient.shortUrls(req);
    }

    @GetMapping("/shortUrls")
    public Response<String> getOriginalUrlByShortUrl(@RequestParam String shortUrl){
        return linkFeignClient.getOriginalUrlByShortUrl(shortUrl);
    }

    @GetMapping("/urlStats")
    public Response<List<Map<String, Object>>> getTopLinks(@RequestParam Integer n){
        return linkFeignClient.getTopLinks(n);
    }
}
