package com.lpj.wxgzhh.domain.button;

import java.util.ArrayList;
import java.util.List;

public class Button {

    private List<MenuButton> button=new ArrayList<MenuButton>();

    public List<MenuButton> getButton() {
        return button;
    }

    public void setButton(List<MenuButton> button) {
        this.button = button;
    }
}
