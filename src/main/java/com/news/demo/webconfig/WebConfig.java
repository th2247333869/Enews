package com.news.demo.webconfig;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializerProvider;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.io.IOException;


@Configuration
@EnableAutoConfiguration(exclude = {
        org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration.class
})
public class WebConfig  implements WebMvcConfigurer {

    @Bean
    public JwtInterceptor myInterceptor(){
        return new JwtInterceptor();
    }

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        System.out.println("-----------跨域请求设置成功-----------");
        registry.addMapping("/**")
                .allowedOrigins("*")
                .allowCredentials(true)
                .allowedMethods("GET", "POST", "DELETE", "PUT","OPTIONS")
                .maxAge(3600);
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //添加拦截器
        registry.addInterceptor(myInterceptor()).addPathPatterns("/**")
                //.excludePathPatterns("/login", "/register","/creatDeviceId","/test","/wxlogin");
                .excludePathPatterns("/*");
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
        WebMvcConfigurer.super.addResourceHandlers(registry);
    }

    /*@Bean
    @Primary
    @ConditionalOnMissingBean(ObjectMapper.class)
    public ObjectMapper jacksonObjectMapper(Jackson2ObjectMapperBuilder builder) {
        ObjectMapper objectMapper = builder.createXmlMapper(false).build();
        *//*
     * 返回的JSON字符串中含有我们并不需要的字段，那么当对应的实体类中不含有该字段时，会抛出一个异常，告诉你有些字段没有在实体类中找到
     *//*
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        SerializerProvider serializerProvider = objectMapper.getSerializerProvider();
        // 允许单引号
        //objectMapper.configure(JsonParser.Feature.ALLOW_SINGLE_QUOTES, true);
        // 字段和值都加引号
        //objectMapper.configure(JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES, true);
        // 数字也加引号
        //objectMapper.configure(JsonGenerator.Feature.WRITE_NUMBERS_AS_STRINGS, true);
        //objectMapper.configure(JsonGenerator.Feature.QUOTE_NON_NUMERIC_NUMBERS, true);
        //Null值输出空字符串
        serializerProvider.setNullValueSerializer(new JsonSerializer<Object>() {
            @Override
            public void serialize(Object o, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException, JsonProcessingException {
                jsonGenerator.writeString("");
            }
        });
        return objectMapper;
    }*/
}
