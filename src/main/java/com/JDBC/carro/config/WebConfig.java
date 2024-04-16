package com.JDBC.carro.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**") // Permite acessar todos as requisições
            .allowedOrigins("http://localhost:3000") // Permitir apenas requisições da origem confiável
            .allowedMethods("GET", "POST", "PUT", "DELETE") // Métodos HTTP permitidos
            .allowedHeaders("*"); // Cabeçalhos permitidos
    }
}

//registry.addMapping("/**"): Esta linha está adicionando um mapeamento de CORS para todos os caminhos do aplicativo. O "/**" indica que esse mapeamento se aplica a todos os endpoints do seu aplicativo.
// poderia ser registry.addMapping("/api/**"), assim só endpoint /api esta liberado

//exemplos, pode usar mais de uma....
// registry.addMapping("/api/public/**")
//     .allowedOrigins("http://localhost:3000")
//     .allowedMethods("GET", "POST");

// registry.addMapping("/api/private/**")
//     .allowedOrigins("http://localhost:3000")
//     .allowedMethods("GET", "POST", "PUT", "DELETE");

