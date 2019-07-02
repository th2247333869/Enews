package com.news.demo.Utils;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.news.demo.Utils.API.TencentAPI;
import com.news.demo.model.BaseEntity.ResponseEntity;
import jodd.http.HttpRequest;
import jodd.http.HttpResponse;
import java.lang.reflect.Type;
import java.util.Map;

public final class HttpRequestUtils<T> {

    // ================================================================
    // Constants
    // ================================================================

    // ================================================================
    // Fields
    // ================================================================

    private static final Gson GSON = SpringContextHolder.getBean(Gson.class);


    // ================================================================
    // Constructors
    // ================================================================

    // ================================================================
    // Methods from/for super Interfaces or SuperClass
    // ================================================================

    // ================================================================
    // Public or Protected Methods
    // ================================================================

    public static <T> ResponseEntity<T> post(Map<String, Object> param,
                                             Map<String, Object> header) {
        HttpResponse response =
                HttpRequest.post(TencentAPI.NLP_TEXTPOLAR).form(param)
                        .send();
        String resp = response.bodyText();

        Type type = new TypeToken<ResponseEntity<T>>() {
        }.getType();
        ResponseEntity<T> entity = GSON.fromJson(resp, type);
        return entity;
    }


    // ================================================================
    // Getter & Setter
    // ================================================================

    // ================================================================
    // Private Methods
    // ================================================================


    // ================================================================
    // Inner or Anonymous Class
    // ================================================================

    // ================================================================
    // Test Methods
    // ================================================================

}
