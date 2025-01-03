package com.plantssoil.common.httpclient.impl;

import java.util.Map;

/**
 * Call client url without any kind of Signature
 * 
 * @author danialdy
 * @Date 26 Oct 2024 9:02:28 am
 */
public class BlankHttpPoster extends AbstractHttpPoster {

    @Override
    protected void beforePost(String url, Map<String, String> headers, String requestId, String payload) {
        super.beforePost(url, headers, requestId, payload);
        headers.put(HEADER_WEBHOOK_ID, requestId);
        headers.put(HEADER_WEBHOOK_TIMESTAMP, String.valueOf(System.currentTimeMillis()));
    }

}
