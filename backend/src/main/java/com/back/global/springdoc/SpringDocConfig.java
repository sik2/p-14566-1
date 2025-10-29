package com.back.global.springdoc;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(info = @Info(title="API 서버", version="beta", description = "API 서버 문서입니다."))
@SecurityScheme(
        name = "bearerAuth",
        type= SecuritySchemeType.HTTP,
        bearerFormat="JWT",
        scheme = "bearer"
)
public class SpringDocConfig {
    @Bean
    public GroupedOpenApi groupApiV1() {
        return GroupedOpenApi.builder()
                .group("apiV1") // 그룹이름
                .pathsToMatch("/api/v1/**") // api/v1/ ** 경로 매칭
                .build();
    }

    @Bean
    public GroupedOpenApi groupController() {
        return GroupedOpenApi.builder()
                .group("non-api") // 그룹이름
                .pathsToExclude("/api/**") // api/ ** 경로 제외
                .pathsToMatch("/**") // 모든 경로 포함
                .build();
    }
}
