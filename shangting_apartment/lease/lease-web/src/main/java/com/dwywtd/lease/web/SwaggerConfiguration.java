package com.dwywtd.lease.web;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.mybatis.spring.annotation.MapperScan;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfiguration {


    @Bean
    public OpenAPI adminOpenAPI() {
        return new OpenAPI().info(new Info()
                .title("Lease Admin API")
                .version("1.0")
                .contact(new Contact().name("hanliukui").email("hanliukui@163.com"))
                .description("Lease Admin API")
        );
    }

    @Bean
    public GroupedOpenApi userGroupOpenApi() {
        return GroupedOpenApi.builder()
                .group("系统管理")
                .pathsToMatch("/admin/**")
                .build();
    }
}
