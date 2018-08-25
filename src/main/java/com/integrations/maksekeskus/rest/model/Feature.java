package com.integrations.maksekeskus.rest.model;

import com.google.gson.annotations.SerializedName;

public class Feature {

    @SerializedName(value = "enabled")
    private boolean enabled;

    @SerializedName(value = "name")
    private String name;

    @SerializedName(value = "object")
    private String object;

    public Feature() {
    }

    public Feature(boolean enabled, String name, String object) {
        this.enabled = enabled;
        this.name = name;
        this.object = object;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getObject() {
        return object;
    }

    public void setObject(String object) {
        this.object = object;
    }
}
