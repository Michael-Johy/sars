package com.johnny.sars.rule.java.entity;

import java.util.Date;

/**
 * Description:统一编译对象
 * <p>
 * Author: johnny
 * Date  : 2017-11-09 16:24
 */
public class Rule {
    private String id;
    private String content;
    private boolean enabled;
    private Date upt;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public Date getUpt() {
        return upt;
    }

    public void setUpt(Date upt) {
        this.upt = upt;
    }
}
