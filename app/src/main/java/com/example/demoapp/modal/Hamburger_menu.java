package com.example.demoapp.modal;

import java.util.List;

public class Hamburger_menu {

    private String menu_label;
    private List<DataMenu> menu;

    public Hamburger_menu(String menu_label, List<DataMenu> menu) {
        this.menu_label = menu_label;
        this.menu = menu;
    }

    public String getMenu_label() {
        return menu_label;
    }

    public void setMenu_label(String menu_label) {
        this.menu_label = menu_label;
    }

    public List<DataMenu> getMenu() {
        return menu;
    }

    public void setMenu(List<DataMenu> menu) {
        this.menu = menu;
    }
}
