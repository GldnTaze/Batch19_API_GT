
package com.eurotech.apiPOJOTemplates.euroTech;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class Education {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("school")
    @Expose
    private String school;
    @SerializedName("degree")
    @Expose
    private String degree;
    @SerializedName("study")
    @Expose
    private String study;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("fromdate")
    @Expose
    private String fromdate;
    @SerializedName("todate")
    @Expose
    private String todate;
    @SerializedName("date")
    @Expose
    private String date;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Education() {
    }

    public Education(Integer id, String school, String degree, String study, String description, String fromdate, String todate, String date) {
        super();
        this.id = id;
        this.school = school;
        this.degree = degree;
        this.study = study;
        this.description = description;
        this.fromdate = fromdate;
        this.todate = todate;
        this.date = date;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }

    public String getStudy() {
        return study;
    }

    public void setStudy(String study) {
        this.study = study;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getFromdate() {
        return fromdate;
    }

    public void setFromdate(String fromdate) {
        this.fromdate = fromdate;
    }

    public String getTodate() {
        return todate;
    }

    public void setTodate(String todate) {
        this.todate = todate;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

}
