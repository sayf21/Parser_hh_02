package com.parsing.domain;


import javax.persistence.*;

@Entity
@Table(name = "publish")
public class PublishedResult {

    @Id
    private Integer id;

    String idPublishVacancy;

    String datePublishVacancy;

    public PublishedResult() {

    }

    public PublishedResult(Integer id, String idPublishVacancy, String datePublishVacancy) {
        this.id = id;
        this.idPublishVacancy = idPublishVacancy;
        this.datePublishVacancy = datePublishVacancy;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getIdPublishVacancy() {
        return idPublishVacancy;
    }

    public void setIdPublishVacancy(String idPublishVacancy) {
        this.idPublishVacancy = idPublishVacancy;
    }

    public String getDatePublishVacancy() {
        return datePublishVacancy;
    }

    public void setDatePublishVacancy(String datePublishVacancy) {
        this.datePublishVacancy = datePublishVacancy;
    }
}

