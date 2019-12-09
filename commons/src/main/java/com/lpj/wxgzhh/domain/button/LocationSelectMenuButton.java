package com.lpj.wxgzhh.domain.button;

public class LocationSelectMenuButton extends MenuButton {

    private String type;

    private String key;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public LocationSelectMenuButton(String name,String key) {
        super(name);
        this.type ="location_select";
        this.key = key;
    }
}
