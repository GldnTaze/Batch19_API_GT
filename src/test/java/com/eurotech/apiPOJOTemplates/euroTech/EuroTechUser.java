//
//package com.eurotech.apiPOJOTemplates.euroTech;
//
//import com.google.gson.annotations.Expose;
//import com.google.gson.annotations.SerializedName;
//
//import java.util.List;
//
//
//public class EuroTechUser {
//
//    @SerializedName("id")
//    @Expose
//    private Integer id;
//    @SerializedName("name")
//    @Expose
//    private String name;
//    @SerializedName("email")
//    @Expose
//    private String email;
//    @SerializedName("password")
//    @Expose
//    private String password;
//    @SerializedName("about")
//    @Expose
//    private String about;
//    @SerializedName("terms")
//    @Expose
//    private String terms;
//    @SerializedName("date")
//    @Expose
//    private String date;
//    @SerializedName("job")
//    @Expose
//    private String job;
//    @SerializedName("company")
//    @Expose
//    private String company;
//    @SerializedName("website")
//    @Expose
//    private String website;
//    @SerializedName("location")
//    @Expose
//    private String location;
//    @SerializedName("skills")
//    @Expose
//    private List<String> skills;
//    @SerializedName("github")
//    @Expose
//    private String github;
//    @SerializedName("twitter")
//    @Expose
//    private String twitter;
//    @SerializedName("facebook")
//    @Expose
//    private String facebook;
//    @SerializedName("youtube")
//    @Expose
//    private String youtube;
//    @SerializedName("linkedin")
//    @Expose
//    private String linkedin;
//    @SerializedName("instagram")
//    @Expose
//    private String instagram;
//    @SerializedName("avatar")
//    @Expose
//    private String avatar;
//    @SerializedName("admin")
//    @Expose
//    private String admin;
//    @SerializedName("education")
//    @Expose
//    private List<eurotech.apiPOJOTemplates.euroTech.Education> education;
//    @SerializedName("experience")
//    @Expose
//    private List<eurotech.apiPOJOTemplates.euroTech.Experience> experience;
//
//    /**
//     * No args constructor for use in serialization
//     *
//     */
//    public EuroTechUser() {
//    }
//
//    public EuroTechUser(Integer id, String name, String email, String password, String about, String terms, String date, String job, String company, String website, String location, List<String> skills, String github, String twitter, String facebook, String youtube, String linkedin, String instagram, String avatar, String admin, List<eurotech.apiPOJOTemplates.euroTech.Education> education, List<eurotech.apiPOJOTemplates.euroTech.Experience> experience) {
//        super();
//        this.id = id;
//        this.name = name;
//        this.email = email;
//        this.password = password;
//        this.about = about;
//        this.terms = terms;
//        this.date = date;
//        this.job = job;
//        this.company = company;
//        this.website = website;
//        this.location = location;
//        this.skills = skills;
//        this.github = github;
//        this.twitter = twitter;
//        this.facebook = facebook;
//        this.youtube = youtube;
//        this.linkedin = linkedin;
//        this.instagram = instagram;
//        this.avatar = avatar;
//        this.admin = admin;
//        this.education = education;
//        this.experience = experience;
//    }
//
//    public Integer getId() {
//        return id;
//    }
//
//    public void setId(Integer id) {
//        this.id = id;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public String getEmail() {
//        return email;
//    }
//
//    public void setEmail(String email) {
//        this.email = email;
//    }
//
//    public String getPassword() {
//        return password;
//    }
//
//    public void setPassword(String password) {
//        this.password = password;
//    }
//
//    public String getAbout() {
//        return about;
//    }
//
//    public void setAbout(String about) {
//        this.about = about;
//    }
//
//    public String getTerms() {
//        return terms;
//    }
//
//    public void setTerms(String terms) {
//        this.terms = terms;
//    }
//
//    public String getDate() {
//        return date;
//    }
//
//    public void setDate(String date) {
//        this.date = date;
//    }
//
//    public String getJob() {
//        return job;
//    }
//
//    public void setJob(String job) {
//        this.job = job;
//    }
//
//    public String getCompany() {
//        return company;
//    }
//
//    public void setCompany(String company) {
//        this.company = company;
//    }
//
//    public String getWebsite() {
//        return website;
//    }
//
//    public void setWebsite(String website) {
//        this.website = website;
//    }
//
//    public String getLocation() {
//        return location;
//    }
//
//    public void setLocation(String location) {
//        this.location = location;
//    }
//
//    public List<String> getSkills() {
//        return skills;
//    }
//
//    public void setSkills(List<String> skills) {
//        this.skills = skills;
//    }
//
//    public String getGithub() {
//        return github;
//    }
//
//    public void setGithub(String github) {
//        this.github = github;
//    }
//
//    public String getTwitter() {
//        return twitter;
//    }
//
//    public void setTwitter(String twitter) {
//        this.twitter = twitter;
//    }
//
//    public String getFacebook() {
//        return facebook;
//    }
//
//    public void setFacebook(String facebook) {
//        this.facebook = facebook;
//    }
//
//    public String getYoutube() {
//        return youtube;
//    }
//
//    public void setYoutube(String youtube) {
//        this.youtube = youtube;
//    }
//
//    public String getLinkedin() {
//        return linkedin;
//    }
//
//    public void setLinkedin(String linkedin) {
//        this.linkedin = linkedin;
//    }
//
//    public String getInstagram() {
//        return instagram;
//    }
//
//    public void setInstagram(String instagram) {
//        this.instagram = instagram;
//    }
//
//    public String getAvatar() {
//        return avatar;
//    }
//
//    public void setAvatar(String avatar) {
//        this.avatar = avatar;
//    }
//
//    public String getAdmin() {
//        return admin;
//    }
//
//    public void setAdmin(String admin) {
//        this.admin = admin;
//    }
//
//    public List<eurotech.apiPOJOTemplates.euroTech.Education> getEducation() {
//        return education;
//    }
//
//    public void setEducation(List<eurotech.apiPOJOTemplates.euroTech.Education> education) {
//        this.education = education;
//    }
//
//    public List<eurotech.apiPOJOTemplates.euroTech.Experience> getExperience() {
//        return experience;
//    }
//
//    public void setExperience(List<eurotech.apiPOJOTemplates.euroTech.Experience> experience) {
//        this.experience = experience;
//    }
//
//}
