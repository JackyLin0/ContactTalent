package tw.brad.apps.contacttalent.model;

import java.io.Serializable;

/**
 * Created by hungming on 2017/4/12.
 */

public class ContactBook implements Serializable {
    private long key_id;
    private  String contact_id;
    private  String contact_photo;
    private  String contact_name ;
    private  String contact_dept; //0:客,1:廠,2:員
    private  String contact_phone;
    private  String contact_mobile;
    private  String contact_company;
    private  String contact_postal;
    private  String contact_address;

    public ContactBook(){}
    public ContactBook(long key_id,String contact_id, String contact_photo, String contact_name, String contact_dept, String contact_phone, String contact_mobile
            , String contact_company, String contact_postal, String contact_address) {
        this.key_id = key_id;
        this.contact_id = contact_id;
        this.contact_photo = contact_photo;
        this.contact_name = contact_name;
        this.contact_dept = contact_dept;
        this.contact_phone = contact_phone;
        this.contact_mobile = contact_mobile;
        this.contact_company = contact_company;
        this.contact_postal = contact_postal;
        this.contact_address = contact_address;
    }

    @Override
    public String toString() {
        return "ContactBook{" +
                "key_id=" + key_id +
                ", contact_id='" + contact_id + '\'' +
                ", contact_photo='" + contact_photo + '\'' +
                ", contact_name='" + contact_name + '\'' +
                ", contact_dept='" + contact_dept + '\'' +
                ", contact_phone='" + contact_phone + '\'' +
                ", contact_mobile='" + contact_mobile + '\'' +
                ", contact_company='" + contact_company + '\'' +
                ", contact_postal='" + contact_postal + '\'' +
                ", contact_address='" + contact_address + '\'' +
                '}';
    }

    public String getContact_id() {
        return contact_id;
    }

    public void setContact_id(String contact_id) {
        this.contact_id = contact_id;
    }

    public long getKey_id() {
        return key_id;
    }

    public void setKey_id(long key_id) {
        this.key_id = key_id;
    }

    public String getContact_photo() {
        return contact_photo;
    }

    public void setContact_photo(String contact_photo) {
        this.contact_photo = contact_photo;
    }

    public String getContact_name() {
        return contact_name;
    }

    public void setContact_name(String contact_name) {
        this.contact_name = contact_name;
    }

    public String getContact_dept() {
        return contact_dept;
    }

    public void setContact_dept(String contact_dept) {
        this.contact_dept = contact_dept;
    }

    public String getContact_phone() {
        return contact_phone;
    }

    public void setContact_phone(String contact_phone) {
        this.contact_phone = contact_phone;
    }

    public String getContact_mobile() {
        return contact_mobile;
    }

    public void setContact_mobile(String contact_mobile) {
        this.contact_mobile = contact_mobile;
    }

    public String getContact_company() {
        return contact_company;
    }

    public void setContact_company(String contact_company) {
        this.contact_company = contact_company;
    }

    public String getContact_postal() {
        return contact_postal;
    }

    public void setContact_postal(String contact_postal) {
        this.contact_postal = contact_postal;
    }

    public String getContact_address() {
        return contact_address;
    }

    public void setContact_address(String contact_address) {
        this.contact_address = contact_address;
    }

}
