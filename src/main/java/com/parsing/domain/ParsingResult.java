package com.parsing.domain;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "parsing")
public class ParsingResult implements Serializable {

    @Id
    private Integer id;

    String idVacancy;
    String langProg;
    String exper;
    String nameVacancy;
    String dateVacancy;
    String salary;
    String company;
    String companyLink;
    String country;
    String city;
    String metro;
    String descriptionVacancy1;
    String descriptionVacancy2;
    String linlImg;
    String workExperience;
    String linkVacancy;
    String responseVacancy;
    String typeOfEmpoyment;
    String schedule;



    public ParsingResult() {

    }


    public ParsingResult(Integer id, String idVacancy, String langProg, String exper, String nameVacancy, String dateVacancy, String salary, String company, String companyLink, String country, String city, String metro, String descriptionVacancy1, String descriptionVacancy2, String linlImg, String workExperience, String linkVacancy, String responseVacancy, String typeOfEmpoyment, String schedule) {
        this.langProg = langProg;
        this.exper = exper;
        this.nameVacancy = nameVacancy;
        this.dateVacancy = dateVacancy;
        this.salary = salary;
        this.company = company;
        this.companyLink = companyLink;
        this.country = country;
        this.city = city;
        this.metro = metro;
        this.descriptionVacancy1 = descriptionVacancy1;
        this.descriptionVacancy2 = descriptionVacancy2;
        this.linlImg = linlImg;
        this.workExperience = workExperience;
        this.linkVacancy = linkVacancy;
        this.responseVacancy = responseVacancy;
        this.typeOfEmpoyment = typeOfEmpoyment;
        this.schedule = schedule;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getIdVacancy() {
        return idVacancy;
    }

    public void setIdVacancy(String idVacancy) {
        this.idVacancy = idVacancy;
    }

    public String getLangProg() {
        return langProg;
    }

    public void setLangProg(String langProg) {
        this.langProg = langProg;
    }

    public String getExper() {
        return exper;
    }

    public void setExper(String exper) {
        this.exper = exper;
    }

    public String getNameVacancy() {
        return nameVacancy;
    }

    public void setNameVacancy(String nameVacancy) {
        this.nameVacancy = nameVacancy;
    }

    public String getDateVacancy() {
        return dateVacancy;
    }

    public void setDateVacancy(String dateVacancy) {
        this.dateVacancy = dateVacancy;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getCompanyLink() {
        return companyLink;
    }

    public void setCompanyLink(String companyLink) {
        this.companyLink = companyLink;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getMetro() {
        return metro;
    }

    public void setMetro(String metro) {
        this.metro = metro;
    }

    public String getDescriptionVacancy1() {
        return descriptionVacancy1;
    }

    public void setDescriptionVacancy1(String descriptionVacancy1) {
        this.descriptionVacancy1 = descriptionVacancy1;
    }

    public String getDescriptionVacancy2() {
        return descriptionVacancy2;
    }

    public void setDescriptionVacancy2(String descriptionVacancy2) {
        this.descriptionVacancy2 = descriptionVacancy2;
    }

    public String getLinlImg() {
        return linlImg;
    }

    public void setLinlImg(String linlImg) {
        this.linlImg = linlImg;
    }

    public String getWorkExperience() {
        return workExperience;
    }

    public void setWorkExperience(String workExperience) {
        this.workExperience = workExperience;
    }

    public String getLinkVacancy() {
        return linkVacancy;
    }

    public void setLinkVacancy(String linkVacancy) {
        this.linkVacancy = linkVacancy;
    }

    public String getResponseVacancy() {
        return responseVacancy;
    }

    public void setResponseVacancy(String responseVacancy) {
        this.responseVacancy = responseVacancy;
    }

    public String getTypeOfEmpoyment() {
        return typeOfEmpoyment;
    }

    public void setTypeOfEmpoyment(String typeOfEmpoyment) {
        this.typeOfEmpoyment = typeOfEmpoyment;
    }

    public String getSchedule() {
        return schedule;
    }

    public void setSchedule(String schedule) {
        this.schedule = schedule;
    }


}
