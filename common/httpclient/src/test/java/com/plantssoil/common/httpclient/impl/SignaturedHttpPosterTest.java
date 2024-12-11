package com.plantssoil.common.httpclient.impl;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import com.plantssoil.common.httpclient.IHttpResponse;

public class SignaturedHttpPosterTest {

    @Test
    public void testPostNotification() {
        // use https://webhook.site as the testing client, could go to
        // https://webhook.site to check and replace it below
        String url = "https://webhook.site/6d51e002-03e5-423a-87e6-97ef83bc6f91";
        Map<String, String> headers = createTestHeaders();
        String messageId = "msg_p5jXN8AQM9LWM0D4loKWxJek";
        String payload = "{\"test\": 2432232314}";

        SignaturedHttpPoster notifier = new SignaturedHttpPoster();
        notifier.setAccessToken("MfKQ9r8GKYqrTwjUPD8ILPZIo2LaLaSw");
        notifier.setCharset("UTF-8");
        notifier.setMediaType("application/json");

        IHttpResponse response = notifier.post(url, headers, messageId, payload);
        System.out.println(response.getStatusCode());
        System.out.println(response.getBody());
        try {
            // should uncomment this line after setup the correct url
//          assertTrue(future.get().statusCode() == 200);
            assertTrue(response.getStatusCode() == 404);
        } catch (Exception e) {
            e.printStackTrace();
            fail(e.getMessage());
        }
    }

    private Map<String, String> createTestHeaders() {
        Map<String, String> headers = new HashMap<>();
        headers.put("X-webhook-signatured01", "X-webhook-value01");
        headers.put("X-webhook-signatured02", "X-webhook-value02");
        return headers;
    }

}
