package com.lpj.wxgzhh.domain.button;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.xml.bind.annotation.XmlElement;
import java.util.ArrayList;
import java.util.List;

public class SubButtonMenuButton extends MenuButton {

    @JsonProperty("sub_button")
    private List<MenuButton> subButton =new ArrayList<>();

    public List<MenuButton> getSubButton() {
        return subButton;
    }

    public void setSubButton(List<MenuButton> subButton) {
        this.subButton = subButton;
    }

    public SubButtonMenuButton(String name) {
        super(name);
    }
}
