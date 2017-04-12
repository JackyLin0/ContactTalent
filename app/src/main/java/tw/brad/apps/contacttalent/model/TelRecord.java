package tw.brad.apps.contacttalent.model;

import java.io.Serializable;

/**
 * Created by hungming on 2017/4/12.
 */

public class TelRecord implements Serializable {
    private long key_id;
    private String photo;
    private String name;
    private String dept;
    private String phone;
    private String mobile;
    private String company;
    private String dTime;
    private String style;

    @Override
    public String toString() {
        return "TelRecord{" +
                "key_id=" + key_id +
                ", photo='" + photo + '\'' +
                ", name='" + name + '\'' +
                ", dept='" + dept + '\'' +
                ", phone='" + phone + '\'' +
                ", mobile='" + mobile + '\'' +
                ", company='" + company + '\'' +
                ", dTime='" + dTime + '\'' +
                ", style='" + style + '\'' +
                '}';
    }

    public TelRecord() {}


    public TelRecord(long key_id, String photo, String name, String dept
            , String phone, String mobile, String company, String dTime, String style) {
        this.key_id = key_id;
        this.photo = photo;
        this.name = name;
        this.dept = dept;
        this.phone = phone;
        this.mobile = mobile;
        this.company = company;
        this.dTime = dTime;
        this.style = style;
    }


    public long getKey_id() {
        return key_id;
    }

    public void setKey_id(long key_id) {
        this.key_id = key_id;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getdTime() {
        return dTime;
    }

    public void setdTime(String dTime) {
        this.dTime = dTime;
    }

    public String getStyle() {
        return style;
    }

    public void setStyle(String style) {
        this.style = style;
    }
}
