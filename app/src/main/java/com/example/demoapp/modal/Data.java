package com.example.demoapp.modal;

import java.util.List;

public class Data {

    private List<Hamburger_menu> hamburger_menu;

    public Data(List<Hamburger_menu> hamburger_menu) {
        this.hamburger_menu = hamburger_menu;
    }

    public List<Hamburger_menu> getHamburger_menu() {
        return hamburger_menu;
    }

    public void setHamburger_menu(List<Hamburger_menu> hamburger_menu) {
        this.hamburger_menu = hamburger_menu;
    }
}
