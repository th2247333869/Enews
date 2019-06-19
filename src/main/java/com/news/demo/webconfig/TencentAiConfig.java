package com.news.demo.webconfig;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
* @Description:    获取配置信息
* @Author:         GEBILAOHU
* @CreateDate:     2019/6/19 21:15
* @UpdateUser:     GEBILAOHU
* @UpdateDate:     2019/6/19 21:15
* @UpdateRemark:   修改内容
* @Version:        1.0
*/
@Configuration
@ConfigurationProperties(prefix = TencentAiConfig.TENCENTAICONFIG_PREFIX)
public class TencentAiConfig {

    // ================================================================
    // Constants
    // ================================================================

    public static final String TENCENTAICONFIG_PREFIX = "tencent";

    // ================================================================
    // Fields
    // ================================================================

    private String appID;
    private String appKey;

    // ================================================================
    // Constructors
    // ================================================================

    // ================================================================
    // Methods from/for super Interfaces or SuperClass
    // ================================================================

    // ================================================================
    // Public or Protected Methods
    // ================================================================


    // ================================================================
    // Getter & Setter
    // ================================================================

    public String getAppID() {
        return appID;
    }

    public void setAppID(String appID) {
        this.appID = appID;
    }

    public String getAppKey() {
        return appKey;
    }

    public void setAppKey(String appKey) {
        this.appKey = appKey;
    }


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


