package Model;

public class Teacher {
    private String firstName;
    private String secondName;
    private String thirdName;
    private String faculty;
    private String chair;
    private String academicTitle;
    private String academicDegree;
    private int workExperience;

    public Teacher() {
        firstName = ""; // имя
        secondName = ""; //фамилия
        thirdName = "";
        faculty = "";
        chair = "";
        academicTitle = "";
        academicDegree = "";
        workExperience = 0;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getThirdName() {
        return thirdName;
    }

    public String getName() {
        return getSecondName() + " " + getFirstName() + " " + getThirdName() + " ";
    }

    public void setThirdName(String thirdName) {
        this.thirdName = thirdName;
    }

    public String getFaculty() {
        return faculty;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

    public String getChair() {
        return chair;
    }

    public void setChair(String chair) {
        this.chair = chair;
    }

    public String getAcademicTitle() {
        return academicTitle;
    }

    public void setAcademicTitle(String academicTitle) {
        this.academicTitle = academicTitle;
    }

    public String getAcademicDegree() {
        return academicDegree;
    }

    public void setAcademicDegree(String academicDegree) {
        this.academicDegree = academicDegree;
    }

    public Integer getWorkExperience() {
        return workExperience;
    }

    public void setWorkExperience(int workExperience) {
        this.workExperience = workExperience;
    }
}
