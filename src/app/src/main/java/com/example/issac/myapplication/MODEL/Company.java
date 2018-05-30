package com.example.issac.myapplication.MODEL;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class Company extends Model
{
    protected int id;
    private String stringId;
    private String name;        // le texte que l'utilisateur compléte
    private String address1;
    private String address2;
    private String pc;
    private String num;
    private String fax;
    private String interName;
    private String interNickName;
    private String interNum;
    private String interFax;
    private String mail;
    private String interMail;
    private String city;

    public Company() {
        super("company");
    }

    @Override
    public void putInObj(JSONObject json) {
        try {
            this.stringId = String.valueOf(json.getInt("id"));
            this.name = json.getString("name");
            this.address1 = json.getString("address1");
            this.address2 = json.getString("address2");
            this.pc = json.getString("pc");
            this.num = json.getString("num");
            this.fax = json.getString("fax");
            this.interName = json.getString("intername");
            this.interNickName = json.getString("internickname");
            this.interNum = json.getString("internum");
            this.interFax = json.getString("interfax");
            this.mail = json.getString("mail");
            this.interMail = json.getString("intermail");
            this.city = json.getString("city");
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Company> JSONArrayToCompanies(ArrayList<JSONObject> table) {
        ArrayList<Company> lesCompanies = new ArrayList<Company>();
        int i;
        for(i=0;i<table.size();i++) {
            Company uneCompany = new Company();
            uneCompany.putInObj(table.get(i));
            lesCompanies.add(uneCompany);
        }
        return lesCompanies;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }

    public String getStringId() {
        return stringId;
    }

    public void setStringId(String stringid) {
        stringId = stringid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress1() {
        return address1;
    }

    public void setAddress1(String address1) {
        this.address1 = address1;
    }

    public String getAddress2() {
        return address2;
    }

    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPc() {
        return pc;
    }

    public void setPc(String pc) {
        this.pc = pc;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getInterName() {
        return interName;
    }

    public void setInterName(String interName) {
        this.interName = interName;
    }

    public String getInterNickName() {
        return interNickName;
    }

    public void setInterNickName(String interNickName) {
        this.interNickName = interNickName;
    }

    public String getInterNum() {
        return interNum;
    }

    public void setInterNum(String interNum) {
        this.interNum = interNum;
    }

    public String getInterFax() {
        return interFax;
    }

    public void setInterFax(String interFax) {
        this.interFax = interFax;
    }

    public String getInterMail() {
        return interMail;
    }

    public void setInterMail(String interMail) {
        this.interMail = interMail;
    }
}
