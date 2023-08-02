package com.example.releaseme.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.servlet.config.annotation.EnableWebMvc
import springfox.documentation.builders.ApiInfoBuilder
import springfox.documentation.builders.PathSelectors
import springfox.documentation.builders.RequestHandlerSelectors
import springfox.documentation.service.ApiInfo
import springfox.documentation.spi.DocumentationType
import springfox.documentation.spring.web.plugins.Docket
import springfox.documentation.swagger2.annotations.EnableSwagger2

@Configuration
@EnableWebMvc
@EnableSwagger2
class SpringFoxConfig {
    @Bean
    fun api(): Docket {
        return Docket(DocumentationType.SWAGGER_2)
            .select()
            .apis(RequestHandlerSelectors.basePackage("com.example.releaseme"))
            .paths(PathSelectors.ant("/**"))
            .build()
            .apiInfo(apiInfo())
            .useDefaultResponseMessages(false)
    }

    private fun apiInfo(): ApiInfo {
        val title = "Swagger API Documents" // 스웨거 UI 타이틀
        val version = "1.0.0"
        val license = "Dongmin All rights reserved"
        return ApiInfoBuilder()
            .title(title)
            .version(version)
            .license(license)
            .build()
    }
}
