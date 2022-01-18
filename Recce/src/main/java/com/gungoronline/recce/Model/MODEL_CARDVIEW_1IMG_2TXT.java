package com.gungoronline.recce.Model;

public class MODEL_CARDVIEW_1IMG_2TXT {
    private String txt1;
    private String txt2;
    private int img;
    public MODEL_CARDVIEW_1IMG_2TXT(String txt1, String txt2, int img) {
        this.txt1 = txt1;
        this.txt2 = txt2;
        this.img = img;
    }
    public String getTxt1() {
        return txt1;
    }
    public void setTxt1(String txt1) {
        this.txt1 = txt1;
    }
    public String getTxt2() {
        return txt2;
    }
    public void setTxt2(String txt2) {
        this.txt2 = txt2;
    }
    public int getImg() {
        return img;
    }
    public void setImg(int img) {
        this.img = img;
    }
}
