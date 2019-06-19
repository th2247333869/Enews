package com.news.demo.Utils;

import com.news.demo.webconfig.TencentAiConfig;
import org.springframework.util.DigestUtils;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class TencentAISignHolder {

    // ================================================================
    // Constants
    // ================================================================

    // ================================================================
    // Fields
    // ================================================================

    private static final TencentAiConfig CONFIG = SpringContextHolder.getBean(TencentAiConfig.class);

    // ================================================================
    // Constructors
    // ================================================================

    // ================================================================
    // Methods from/for super Interfaces or SuperClass
    // ================================================================

    // ================================================================
    // Public or Protected Methods
    // ================================================================

    /**
     * SIGN签名生成算法-JAVA版本 通用。默认参数都为UTF-8适用
     *
     * @param params 请求参数集，所有参数必须已转换为字符串类型
     * @return 签名
     * @throws IOException
     */
    public static String getSignature(Map<String, Object> params) throws IOException {
        Map<String, Object> sortedParams = new TreeMap<>(params);
        Set<Map.Entry<String, Object>> entrys = sortedParams.entrySet();
        StringBuilder baseString = new StringBuilder();
        for (Map.Entry<String, Object> param : entrys) {
            if (param.getValue() != null && !"".equals(param.getKey().trim()) &&
                    !"sign".equals(param.getKey().trim()) && !"".equals(param.getValue())) {
                baseString.append(param.getKey().trim()).append("=")
                        .append(URLEncoder.encode(param.getValue().toString(), "UTF-8")).append("&");
            }
        }
        if (baseString.length() > 0) {
            baseString.deleteCharAt(baseString.length() - 1).append("&app_key=")
                    .append(CONFIG.getAppKey());
        }
        try {
            String sign = DigestUtils.md5DigestAsHex(baseString.toString().getBytes());
            System.out.println("sign:" + sign.toUpperCase());
            return sign.toUpperCase();
        } catch (Exception ex) {
            throw new IOException(ex);
        }
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
