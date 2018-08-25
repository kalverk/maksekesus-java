package com.integrations.maksekeskus.rest.model;

public class Environment {
    private String platform;
    private String module;

    public Environment() {
    }

    public Environment(String platform, String module) {
        this.platform = platform;
        this.module = module;
    }

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }

    public String getModule() {
        return module;
    }

    public void setModule(String module) {
        this.module = module;
    }
}
