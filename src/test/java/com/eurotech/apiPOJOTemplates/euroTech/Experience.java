
package com.eurotech.apiPOJOTemplates.euroTech;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class Experience {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("job")
    @Expose
    private String job;
    @SerializedName("company")
    @Expose
    private String company;
    @SerializedName("location")
    @Expose
    private String location;
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
    public Experience() {
    }

    public Experience(Integer id, String job, String company, String location, String description, String fromdate, String todate, String date) {
        super();
        this.id = id;
        this.job = job;
        this.company = company;
        this.location = location;
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

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
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
