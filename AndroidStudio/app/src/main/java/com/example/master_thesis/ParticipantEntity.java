package com.example.master_thesis;


public class ParticipantEntity {

    int id;
    String NameTxt = "Name";
    String name;
    String AgeTxT = "Age";
    int age;
    String AddressTxt = "Address";
    String address;
    String GenderTxt = "Gender";
    String gender;

    String EducationTxt = "Education";
    String education;

    public int getExperimentTime() {
        return experimentTime;
    }

    public void setExperimentTime(int experimentTime) {
        this.experimentTime = experimentTime;
    }

    int experimentTime;

    public String getNameTxt() {
        return NameTxt;
    }

    public String getAgeTxT() {
        return AgeTxT;
    }

    public String getAddressTxt() {
        return AddressTxt;
    }

    public String getGenderTxt() {
        return GenderTxt;
    }

    public String getEducationTxt() {
        return EducationTxt;
    }

    String groupAllocation;

    public String getGroupAllocation() {
        return groupAllocation;
    }

    public void setGroupAllocation(String groupAllocation) {
        this.groupAllocation = groupAllocation;
    }

    public ParticipantEntity(int id){
        setId(id);
    };

    public int getId() {
        return id;
    }

    private void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }
}
