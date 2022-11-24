package com.spring.kafka.kafkaboot.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@Configuration
public class SwaggerConfig {
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.any()) // 특정 패키지경로를 API문서화 한다. 1차 필터
                .paths(PathSelectors.any()) // apis중에서 특정 path조건 API만 문서화 하는 2차 필터
                .build()
                .groupName("API 1.0.0") // group별 명칭을 주어야 한다.
                .pathMapping("/")
                .apiInfo(apiInfo())
                .useDefaultResponseMessages(false); // 400,404,500 .. 표기를 ui에서 삭제한다.
    }
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("카프카 기능 탐색 프로젝트")
                .description("카프카를 사용하여 메시지 보내기/받기 API 호출 테스트용도.")
                .version("1.0.0")
                .termsOfServiceUrl("http://iosys.co.kr")
                .contact(new Contact("iosys","iosys.co.kr","iosys@iosys.co.kr"))
                .license("Commercial and other licenses")
                .licenseUrl("http://iosys.co.kr")
                .build()
                ;
    }
}