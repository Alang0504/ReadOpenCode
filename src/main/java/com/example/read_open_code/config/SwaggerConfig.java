package com.example.read_open_code.config;

import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import io.swagger.annotations.ApiOperation;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.RequestHandler;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.List;


@Configuration
@EnableSwagger2
public class SwaggerConfig {
    @Bean
    public Docket api(ApiInfo apiInfo, Predicate<RequestHandler>[] predicates) {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo)
                .select()
                .apis(Predicates.or(predicates))
                .paths(PathSelectors.any())
                .build();
    }

    @Bean
    public Predicate<RequestHandler> csPredicate() {
        List<Predicate<RequestHandler>> list = new ArrayList<>();
        list.add(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class));
        return Predicates.or(list);
    }

    @Bean
    public ApiInfo swaggerApiInfo() {
        return new ApiInfoBuilder()
                .title("开奖结果分析-接口文档")
                .description("开奖结果")
                .version("1.0")
                .build();
    }
    /**
     * Calibur的接口文档
     */
    @Bean
    public Docket caliburDocket() {

        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(caliburApiInfo())
                .groupName("Calibur")
                // 配置扫描信息
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.example.read_open_code.controller.calibur"))
                .apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class))
                .build();
    }

    /**
     * 编写API信息
     */
    public ApiInfo caliburApiInfo() {

        return new ApiInfoBuilder()
                .title("小说API文档")
                .description("小说相关api")
                .version("v1.0")
                //作者信息
                .contact(new Contact("Calibur","","437526758@qq.com"))
                .build();
    }
}
