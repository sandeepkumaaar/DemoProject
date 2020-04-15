package com.example.demoapp.modal;

import java.util.List;

public class DataMenu {

    private String id;
    private String order;
    private String title;
    private String type;
    private String web_url;
    private String icon_url;
    private String isNew;
    private String has_subcategory;
    private String personalization_title;
    private String personalization_tile_color;
    private String personalization_tile_image;
    private List<Object> subcategory;
    private String app_card;
    private String cat_card;

    public DataMenu(String id, String order, String title,
                    String type, String web_url, String icon_url,
                    String isNew, String has_subcategory,
                    String personalization_title, String personalization_tile_color,
                    String personalization_tile_image, List<Object> subcategory,
                    String app_card, String cat_card) {

        this.id = id;
        this.order = order;
        this.title = title;
        this.type = type;
        this.web_url = web_url;
        this.icon_url = icon_url;
        this.isNew = isNew;
        this.has_subcategory = has_subcategory;
        this.personalization_title = personalization_title;
        this.personalization_tile_color = personalization_tile_color;
        this.personalization_tile_image = personalization_tile_image;
        this.subcategory = subcategory;
        this.app_card = app_card;
        this.cat_card = cat_card;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getOrder() {
        return order;
    }

    public void setOrder(String order) {
        this.order = order;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getWeb_url() {
        return web_url;
    }

    public void setWeb_url(String web_url) {
        this.web_url = web_url;
    }

    public String getIcon_url() {
        return icon_url;
    }

    public void setIcon_url(String icon_url) {
        this.icon_url = icon_url;
    }

    public String getIsNew() {
        return isNew;
    }

    public void setIsNew(String isNew) {
        this.isNew = isNew;
    }

    public String getHas_subcategory() {
        return has_subcategory;
    }

    public void setHas_subcategory(String has_subcategory) {
        this.has_subcategory = has_subcategory;
    }

    public String getPersonalization_title() {
        return personalization_title;
    }

    public void setPersonalization_title(String personalization_title) {
        this.personalization_title = personalization_title;
    }

    public String getPersonalization_tile_color() {
        return personalization_tile_color;
    }

    public void setPersonalization_tile_color(String personalization_tile_color) {
        this.personalization_tile_color = personalization_tile_color;
    }

    public String getPersonalization_tile_image() {
        return personalization_tile_image;
    }

    public void setPersonalization_tile_image(String personalization_tile_image) {
        this.personalization_tile_image = personalization_tile_image;
    }

    public List<Object> getSubcategory() {
        return subcategory;
    }

    public void setSubcategory(List<Object> subcategory) {
        this.subcategory = subcategory;
    }

    public String getApp_card() {
        return app_card;
    }

    public void setApp_card(String app_card) {
        this.app_card = app_card;
    }

    public String getCat_card() {
        return cat_card;
    }

    public void setCat_card(String cat_card) {
        this.cat_card = cat_card;
    }
}
