package onlineexamination;

/**
 *
 * @author Prasant
 */
public class Student {
    private static String id, password, name, dob, branch, collegeID;
    private static int totalExams;
    private static float avgPercentage;
    
    public Student() {
    }

    public Student(String id, String name, String dob, String branch, String collegeID) {
        this.id = id;
        this.name = name;
        this.dob = dob;
        this.branch = branch;
        this.collegeID = collegeID;
    }

    public static String getId() {
        return id;
    }

    public static void setId(String id) {
        Student.id = id;
    }

    public static String getPassword() {
        return password;
    }

    public static void setPassword(String password) {
        Student.password = password;
    }

    public static String getName() {
        return name;
    }

    public static void setName(String name) {
        Student.name = name;
    }

    public static String getDob() {
        return dob;
    }

    public static void setDob(String dob) {
        Student.dob = dob;
    }

    public static String getBranch() {
        return branch;
    }

    public static void setBranch(String branch) {
        Student.branch = branch;
    }

    public static String getCollegeID() {
        return collegeID;
    }

    public static void setCollegeID(String collegeID) {
        Student.collegeID = collegeID;
    }
    
    public static int getTotalExams() {
        return totalExams;
    }

    public static void setTotalExams(int totalExams) {
        Student.totalExams = totalExams;
    }

    public static float getAvgPercentage() {
        return avgPercentage;
    }

    public static void setAvgPercentage(float avgPercentage) {
        Student.avgPercentage = avgPercentage;
    }
}
