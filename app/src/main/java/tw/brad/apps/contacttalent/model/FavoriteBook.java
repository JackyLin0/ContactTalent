package tw.brad.apps.contacttalent.model;

import java.io.Serializable;

/**
 * Created by hungming on 2017/4/18.
 */

public class FavoriteBook implements Serializable {
    private long id;
    private String favorite_photo;
    private String favorite_stroke;
    private String favorite_name;
    private String favorite_dept; //0:客,1:廠,2:員
    private String favorite_phone;
    private String favorite_mobile;
    private String favorite_company;
    private String favorite_city;
    private String favorite_area;

    public FavoriteBook() {
    }

    public FavoriteBook(long id,String favorite_photo, String favorite_stroke,  String favorite_name
            , String favorite_dept, String favorite_phone
            , String favorite_mobile, String favorite_company
            , String favorite_city, String favorite_area) {
        this.id = id;
        this.favorite_photo = favorite_photo;
        this.favorite_stroke = favorite_stroke;
        this.favorite_name = favorite_name;
        this.favorite_dept = favorite_dept;
        this.favorite_phone = favorite_phone;
        this.favorite_mobile = favorite_mobile;
        this.favorite_company = favorite_company;
        this.favorite_city = favorite_city;
        this.favorite_area = favorite_area;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFavorite_stroke() {
        return favorite_stroke;
    }

    public void setFavorite_stroke(String favorite_stroke) {
        this.favorite_stroke = favorite_stroke;
    }

    public String getFavorite_photo() {
        return favorite_photo;
    }

    public void setFavorite_photo(String favorite_photo) {
        this.favorite_photo = favorite_photo;
    }

    public String getFavorite_name() {
        return favorite_name;
    }

    public void setFavorite_name(String favorite_name) {
        this.favorite_name = favorite_name;
    }

    public String getFavorite_dept() {
        return favorite_dept;
    }

    public void setFavorite_dept(String favorite_dept) {
        this.favorite_dept = favorite_dept;
    }

    public String getFavorite_phone() {
        return favorite_phone;
    }

    public void setFavorite_phone(String favorite_phone) {
        this.favorite_phone = favorite_phone;
    }

    public String getFavorite_mobile() {
        return favorite_mobile;
    }

    public void setFavorite_mobile(String favorite_mobile) {
        this.favorite_mobile = favorite_mobile;
    }

    public String getFavorite_company() {
        return favorite_company;
    }

    public void setFavorite_company(String favorite_company) {
        this.favorite_company = favorite_company;
    }

    public String getFavorite_city() {
        return favorite_city;
    }

    public void setFavorite_city(String favorite_city) {
        this.favorite_city = favorite_city;
    }

    public String getFavorite_area() {
        return favorite_area;
    }

    public void setFavorite_area(String favorite_area) {
        this.favorite_area = favorite_area;
    }


    @Override
    public String toString() {
        return "FavoriteBook{" +
                "id=" + id +
                ", favorite_photo='" + favorite_photo + '\'' +
                ", favorite_stroke='" + favorite_stroke + '\'' +
                ", favorite_name='" + favorite_name + '\'' +
                ", favorite_dept='" + favorite_dept + '\'' +
                ", favorite_phone='" + favorite_phone + '\'' +
                ", favorite_mobile='" + favorite_mobile + '\'' +
                ", favorite_company='" + favorite_company + '\'' +
                ", favorite_city='" + favorite_city + '\'' +
                ", favorite_area='" + favorite_area + '\'' +
                '}';
    }
}
