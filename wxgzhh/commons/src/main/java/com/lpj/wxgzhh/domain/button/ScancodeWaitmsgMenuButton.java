package com.lpj.wxgzhh.domain.button;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

public class ScancodeWaitmsgMenuButton extends MenuButton {
    private String key;

    private String type;

    @JsonProperty("sub_button")
    private List<MenuButton> subButton =new ArrayList<>();

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<MenuButton> getSubButton() {
        return subButton;
    }

    public void setSubButton(List<MenuButton> subButton) {
        this.subButton = subButton;
    }

    public ScancodeWaitmsgMenuButton(String name,String key) {
        super(name);
        this.type="scancode_waitmsg";
        this.key=key;
    }
}
