package com.example.networks2.Modal;

public class ProfessionModel  {
        int img,id;
        String title;

        public ProfessionModel(int id, String title) {
            this.id = id;
            this.title = title;
        }

        public int getImg() {
            return img;
        }

        public void setImg(int img) {
            this.img = img;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }
}
