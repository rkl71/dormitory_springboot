package com.hanyang.configuration;
import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/**
 * ClassName: PageConfiguration
 * Package: com.hanyang.configuration
 * Description:
 *
 * @Author: renkelin
 * @Create: 2023/4/15 - 21:54
 * @Version: v1.0
 */

@Configuration
public class PageConfiguration {

    @Bean
    public PaginationInterceptor paginationInterceptor(){
        return new PaginationInterceptor();
    }
}

