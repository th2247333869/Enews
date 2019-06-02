package com.news.demo.Module.Enews;

public class Enews {

    private String eCode;

    private String eHead;

    private String eAuthor;

    private String eCreatdate;

    private String eOrigin;

    private String ePictureQuantity;

    private String ePictureUrls;

    private String eData;

    public Enews(){}

    public Enews(String eCode, String eHead, String eAuthor, String eCreatdate, String eOrigin, String ePictureQuantity, String ePictureUrls) {
        this.eCode = eCode;
        this.eHead = eHead;
        this.eAuthor = eAuthor;
        this.eCreatdate = eCreatdate;
        this.eOrigin = eOrigin;
        this.ePictureQuantity = ePictureQuantity;
        this.ePictureUrls = ePictureUrls;
    }

    public Enews(String eCode, String eHead, String eAuthor, String eCreatdate, String eOrigin, String ePictureQuantity, String ePictureUrls, String eData) {
        this.eCode = eCode;
        this.eHead = eHead;
        this.eAuthor = eAuthor;
        this.eCreatdate = eCreatdate;
        this.eOrigin = eOrigin;
        this.ePictureQuantity = ePictureQuantity;
        this.ePictureUrls = ePictureUrls;
        this.eData = eData;
    }

    public String geteCode() {
        return eCode;
    }

    public void seteCode(String eCode) {
        this.eCode = eCode;
    }

    public String geteHead() {
        return eHead;
    }

    public void seteHead(String eHead) {
        this.eHead = eHead;
    }

    public String geteAuthor() {
        return eAuthor;
    }

    public void seteAuthor(String eAuthor) {
        this.eAuthor = eAuthor;
    }

    public String geteCreatdate() {
        return eCreatdate;
    }

    public void seteCreatdate(String eCreatdate) {
        this.eCreatdate = eCreatdate;
    }

    public String geteOrigin() {
        return eOrigin;
    }

    public void seteOrigin(String eOrigin) {
        this.eOrigin = eOrigin;
    }

    public String getePictureQuantity() {
        return ePictureQuantity;
    }

    public void setePictureQuantity(String ePictureQuantity) {
        this.ePictureQuantity = ePictureQuantity;
    }

    public String getePictureUrls() {
        return ePictureUrls;
    }

    public void setePictureUrls(String ePictureUrls) {
        this.ePictureUrls = ePictureUrls;
    }

    public String geteData() {
        return eData;
    }

    public void seteData(String eData) {
        this.eData = eData;
    }
}
