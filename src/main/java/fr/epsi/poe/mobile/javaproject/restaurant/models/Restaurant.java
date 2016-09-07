package fr.epsi.poe.mobile.javaproject.restaurant.models;

/**
 * @author Yannis Mazzer <yannis@ioweb.fr>
 * @created_on 19/07/16
 */
public class Restaurant {

    private String name;

    private String address;

    private String url;

    private String googleId;

    private String photoReference;

    private String photoType;

    private byte[] photo;

    private String icon;

    public Restaurant() {

    }

    public Restaurant(String nameToDefine) {
        this.name = nameToDefine;
        address = "";
    }

    public Restaurant(String name, String address) {
        this.name = name;
        this.address = address;
    }

    public Restaurant(String name, String address, String icon, String photoReference) {
        this.name = name;
        this.address = address;
        this.photoReference = photoReference;
        this.icon = icon;
    }


    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getPhotoReference() {
        return photoReference;
    }

    public void setPhotoReference(String photoReference) {
        this.photoReference = photoReference;
    }

    public byte[] getPhoto() {
        return photo;
    }

    public void setPhoto(byte[] photo) {
        this.photo = photo;
    }

    public String getPhotoType() {
        return photoType;
    }

    public void setPhotoType(String photoType) {
        this.photoType = photoType;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getGoogleId() {
        return googleId;
    }

    public void setGoogleId(String googleId) {
        this.googleId = googleId;
    }
}
