package com.gungoronline.recce.Model;

public class MODEL_SPINNER_1IMG_1TXT {
    private String txt;
    private int img;
    public MODEL_SPINNER_1IMG_1TXT(String txt, int img) {
        this.txt = txt;
        this.img = img;
    }
    public MODEL_SPINNER_1IMG_1TXT() {
    }
    public String getTxt() {
        return txt;
    }
    public void setTxt(String txt) {
        this.txt = txt;
    }
    public int getImg() {
        return img;
    }
    public void setImg(int img) {
        this.img = img;
    }
}
