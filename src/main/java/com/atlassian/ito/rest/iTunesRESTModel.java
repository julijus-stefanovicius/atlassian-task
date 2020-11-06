package com.atlassian.ito.rest;

import javax.xml.bind.annotation.*;
@XmlRootElement(name = "message")
@XmlAccessorType(XmlAccessType.FIELD)
public class iTunesRESTModel {

    @XmlElement(name = "value")
    private String message;

    @XmlAttribute
    private String key;

    public iTunesRESTModel() {
    }

    public iTunesRESTModel(String message) {
        this.message = message;
    }

    public iTunesRESTModel(String key, String message) {
        this.key = key;
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getKey() {
        return key;
    }
      
     public void setKey(String key) {
        this.key = key;
    }
}