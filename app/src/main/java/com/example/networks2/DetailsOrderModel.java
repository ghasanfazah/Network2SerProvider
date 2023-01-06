package com.example.networks2;

public class DetailsOrderModel {


    private String nameUser,nameService,imgUrl;
    private int id,userId;

    public DetailsOrderModel(String nameUser, String nameService, String imgUrl, int id, int userId) {
        this.nameUser = nameUser;
        this.nameService = nameService;
        this.imgUrl = imgUrl;
        this.id = id;
        this.userId = userId;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNameUser() {
        return nameUser;
    }

    public void setNameUser(String nameUser) {
        this.nameUser = nameUser;
    }

    public String getNameService() {
        return nameService;
    }

    public void setNameService(String nameService) {
        this.nameService = nameService;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}


