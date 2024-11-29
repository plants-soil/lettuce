package com.plantssoil.webhook.beans;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.Table;

@Entity
@Table(name = "LETTUCE_WEBHOOKEVENTLOGLINE", indexes = { @Index(name = "idx_wheventlogline_requestid", columnList = "requestId"),
        @Index(name = "idx_wheventlogline_subscriberId", columnList = "subscriberId") })
public class WebhookEventLogLine implements java.io.Serializable {
    private static final long serialVersionUID = 5368565382734058399L;
    @Id
    private String logLineId;
    private String subscriberId;
    private String subscriberAppId;
    private String requestId;
    private long executeMillseconds;
    private int responseCode;
    private String responseMessage;

    public String getLogLineId() {
        return logLineId;
    }

    public void setLogLineId(String logLineId) {
        this.logLineId = logLineId;
    }

    public String getSubscriberId() {
        return subscriberId;
    }

    public void setSubscriberId(String subscriberId) {
        this.subscriberId = subscriberId;
    }

    public String getSubscriberAppId() {
        return subscriberAppId;
    }

    public void setSubscriberAppId(String subscriberAppId) {
        this.subscriberAppId = subscriberAppId;
    }

    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }

    public long getExecuteMillseconds() {
        return executeMillseconds;
    }

    public void setExecuteMillseconds(long executeMillseconds) {
        this.executeMillseconds = executeMillseconds;
    }

    public int getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(int responseCode) {
        this.responseCode = responseCode;
    }

    public String getResponseMessage() {
        return responseMessage;
    }

    public void setResponseMessage(String responseMessage) {
        this.responseMessage = responseMessage;
    }

}