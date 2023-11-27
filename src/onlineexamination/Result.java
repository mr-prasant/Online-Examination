package onlineexamination;

/**
 *
 * @author Prasant
 */
public class Result {
    private static String id, name, branch;
    private static int marks;
    private static int fullMarks;
    public static double percentage;

    public Result() {
    }

    public Result(String id, String name, String branch, int marks, int fullMarks, double percentage) {
        this.id = id;
        this.name = name;
        this.branch = branch;
        this.marks = marks;
        this.fullMarks = fullMarks;
        this.percentage = percentage;
    }

    public static int getFullMarks() {
        return fullMarks;
    }

    public static double getPercentage() {
        return percentage;
    }

    public static String getId() {
        return id;
    }

    public static String getName() {
        return name;
    }

    public static String getBranch() {
        return branch;
    }

    public static int getMarks() {
        return marks;
    }   
}
