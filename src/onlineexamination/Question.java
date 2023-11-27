package onlineexamination;

/**
 *
 * @author Prasant
 */
public class Question {
    private String question, option1, option2, option3, option4, answer;
    private int marks;

    public Question() {
    }

    public Question(String question, String option1, String option2, String answer, int marks) {
        this.question = question;
        this.option1 = option1;
        this.option2 = option2;
        this.option3 = "NAN";
        this.option4 = "NAN";
        this.answer = answer;
        this.marks = marks;
    }

    public Question(String question, String option1, String option2, String option3, String answer, int marks) {
        this.question = question;
        this.option1 = option1;
        this.option2 = option2;
        this.option3 = option3;
        this.option4 = "NAN";
        this.answer = answer;
        this.marks = marks;
    }

    public Question(String question, String option1, String option2, String option3, String option4, String answer, int marks) {
        this.question = question;
        this.option1 = option1;
        this.option2 = option2;
        this.option3 = option3;
        this.option4 = option4;
        this.answer = answer;
        this.marks = marks;
    }

    public String getQuestion() {
        return question;
    }

    public String getOption1() {
        return option1;
    }

    public String getOption2() {
        return option2;
    }

    public String getOption3() {
        return option3;
    }

    public String getOption4() {
        return option4;
    }

    public String getAnswer() {
        return answer;
    }
    
    public int getMarks() {
        return marks;
    }
}
