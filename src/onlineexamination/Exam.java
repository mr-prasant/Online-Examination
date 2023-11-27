package onlineexamination;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.JOptionPane;
import javax.swing.Timer;

/**
 *
 * @author Prasant
 */

public class Exam extends javax.swing.JFrame {

    /**
     * Creates new form Exam
     */
    private Timer timer;
    private int time = 0;
    private int min = 5;
    private int sec = 00;
    private int remTime = 0;

    private ArrayList<Question> questions;
    private int quesNum = 1;
    Question ques;

    Student student;
    private int marks = 0;
    private int fullMarks = 70;

    public Exam() {
        initComponents();
        counter.setText(format(min) + ":" + format(sec));
        remTime = min * 60 + sec;

        student = new Student();
        name.setText(student.getName());
        ID.setText(student.getId());
        branch.setText(student.getBranch());

        timer = new Timer(1000, new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                count();
                checkTime();
            }

        });

        timer.start();
        loadQuestions();
    }
    
    private String format(int num) {
        return (num < 10)? "0"+num : num+"";
    }

    private void count() {
        time++;
        int m = (remTime - time) / 60;
        int s = (remTime - time) % 60;
        counter.setText(format(m) + ":" + format(s));
    }

    private void checkTime() {
        if (time >= remTime) {

            if (option1.isSelected() || option2.isSelected() || option3.isSelected() || option4.isSelected()) {
                String opt = "";

                if (option1.isSelected()) {
                    opt = "a";
                } else if (option2.isSelected()) {
                    opt = "b";
                } else if (option3.isSelected()) {
                    opt = "c";
                } else if (option4.isSelected()) {
                    opt = "d";
                }

                evaluateAnswer(opt);
                resetQuestion();
            }

            submit();
            timer.stop();
        }
    }

    private void showQuestion() {
        ques = questions.get(quesNum - 1);
        quesMarks.setText(ques.getMarks() + " marks");
        question.setText("<html><p>Q" + quesNum + ". " + ques.getQuestion() + "</p></html>");
        option1.setText(ques.getOption1());
        option2.setText(ques.getOption2());

        if (ques.getOption3().equals("NAN")) {
            option3.setVisible(false);
            option4.setVisible(false);
        } else if (ques.getOption4().equals("NAN")) {
            option3.setText(ques.getOption3());
            option4.setVisible(false);
        } else {
            option3.setText(ques.getOption3());
            option4.setText(ques.getOption4());
        }

        if (quesNum == questions.size()) {
            button.setText("Submit");
        }
    }

    private void resetQuestion() {
        buttonGroup1.clearSelection();
        option3.setVisible(true);
        option4.setVisible(true);
        button.setBackground(Color.LIGHT_GRAY);
        button.setForeground(Color.BLACK);
    }

    private void evaluateAnswer(String opt) {
        System.out.println(ques.getMarks());
        marks += (ques.getAnswer().toLowerCase().equals(opt.toLowerCase())) ? ques.getMarks() : 0;
    }

    private void submit() {
        Result result = new Result(student.getId(), student.getName(), student.getBranch(), marks, fullMarks, (double)(marks*100)/fullMarks);
        storeMarks(result);
        new ReportCard().setVisible(true);
        setVisible(false);
    }
    
    private void storeMarks(Result result) {
        try {
            DBConnection dBConnection = new DBConnection();
            Connection con = dBConnection.connection();
            Statement st = con.createStatement();
            String query = "INSERT INTO Attendies VALUES ('"+result.getId()+"', '"+result.getMarks()+"', '"+result.getFullMarks()+"', '"+result.getPercentage()+"');";
            st.executeUpdate(query);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage() ,"Error! Result not saved.", 1);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        name = new javax.swing.JLabel();
        branch = new javax.swing.JLabel();
        counter = new javax.swing.JLabel();
        ID = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        question = new javax.swing.JLabel();
        option1 = new javax.swing.JRadioButton();
        option2 = new javax.swing.JRadioButton();
        option3 = new javax.swing.JRadioButton();
        option4 = new javax.swing.JRadioButton();
        quesMarks = new javax.swing.JLabel();
        button = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setAlwaysOnTop(true);
        setBackground(new java.awt.Color(204, 204, 204));
        setForeground(java.awt.Color.lightGray);
        setMaximumSize(new java.awt.Dimension(1920, 1080));
        setUndecorated(true);
        setPreferredSize(new java.awt.Dimension(1920, 1080));
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));
        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        name.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        name.setText("Prasant Chandra Poddar");

        branch.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        branch.setText("CSE-DS");

        counter.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        counter.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        counter.setText("15:30");

        ID.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        ID.setText("STUD2507");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(name, javax.swing.GroupLayout.PREFERRED_SIZE, 619, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ID, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(branch, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(counter, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(133, 133, 133))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(name, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ID, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(counter, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(branch, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setMaximumSize(new java.awt.Dimension(1920, 1080));
        jPanel2.setName(""); // NOI18N
        jPanel2.setOpaque(false);

        question.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        question.setText("QUESTION IS LOADING...");

        option1.setBackground(new java.awt.Color(204, 204, 204));
        buttonGroup1.add(option1);
        option1.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        option1.setText("Option1");
        option1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        option1.setMinimumSize(new java.awt.Dimension(150, 31));
        option1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                option1ActionPerformed(evt);
            }
        });

        option2.setBackground(new java.awt.Color(204, 204, 204));
        buttonGroup1.add(option2);
        option2.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        option2.setText("Option2");
        option2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        option2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                option2ActionPerformed(evt);
            }
        });

        option3.setBackground(new java.awt.Color(204, 204, 204));
        buttonGroup1.add(option3);
        option3.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        option3.setText("Option3");
        option3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        option3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                option3ActionPerformed(evt);
            }
        });

        option4.setBackground(new java.awt.Color(204, 204, 204));
        buttonGroup1.add(option4);
        option4.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        option4.setText("Option4");
        option4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        option4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                option4ActionPerformed(evt);
            }
        });

        quesMarks.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        quesMarks.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        quesMarks.setText("10 marks");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(option1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(option2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(option3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(option4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 1307, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(question, javax.swing.GroupLayout.PREFERRED_SIZE, 1307, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 373, Short.MAX_VALUE)
                .addComponent(quesMarks, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(134, 134, 134))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(quesMarks, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addComponent(question, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(64, 64, 64)
                        .addComponent(option1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(option2)
                        .addGap(18, 18, 18)
                        .addComponent(option3)
                        .addGap(18, 18, 18)
                        .addComponent(option4)))
                .addContainerGap(44, Short.MAX_VALUE))
        );

        button.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        button.setText("Next");
        button.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(button, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(145, 145, 145))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 156, Short.MAX_VALUE)
                .addComponent(button, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(59, 59, 59))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void option2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_option2ActionPerformed
        if (quesNum < questions.size()) {
            button.setBackground(Color.BLUE);
            button.setForeground(Color.WHITE);
        } else {
            button.setBackground(Color.GREEN);
            button.setForeground(Color.BLACK);
        }
    }//GEN-LAST:event_option2ActionPerformed

    private void buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonActionPerformed

        if (option1.isSelected() || option2.isSelected() || option3.isSelected() || option4.isSelected()) {
            String opt = "";

            if (option1.isSelected()) {
                opt = "a";
            } else if (option2.isSelected()) {
                opt = "b";
            } else if (option3.isSelected()) {
                opt = "c";
            } else if (option4.isSelected()) {
                opt = "d";
            }

            quesNum++;
            evaluateAnswer(opt);
            if (quesNum <= questions.size()) {
                resetQuestion();
                showQuestion();
            } else {
                submit();
            }
        }

        // TODO add your handling code here:
    }//GEN-LAST:event_buttonActionPerformed

    private void option1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_option1ActionPerformed
        if (quesNum < questions.size()) {
            button.setBackground(Color.BLUE);
            button.setForeground(Color.WHITE);
        } else {
            button.setBackground(Color.GREEN);
            button.setForeground(Color.BLACK);
        }
    }//GEN-LAST:event_option1ActionPerformed

    private void option3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_option3ActionPerformed
        if (quesNum < questions.size()) {
            button.setBackground(Color.BLUE);
            button.setForeground(Color.WHITE);
        } else {
            button.setBackground(Color.GREEN);
            button.setForeground(Color.BLACK);
        }
    }//GEN-LAST:event_option3ActionPerformed

    private void option4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_option4ActionPerformed
        if (quesNum < questions.size()) {
            button.setBackground(Color.BLUE);
            button.setForeground(Color.WHITE);
        } else {
            button.setBackground(Color.GREEN);
            button.setForeground(Color.BLACK);
        }
    }//GEN-LAST:event_option4ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Exam.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Exam.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Exam.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Exam.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Exam().setVisible(true);
            }
        });
    }

    private void loadQuestions() {
        questions = new ArrayList<>();
        String[] ques = {
            "Number of primitive data types in Java are?",
            "What is the size of float and double in java?",
            "Automatic type conversion is possible in which of the possible cases?",
            "When an array is passed to a method, what does the method receive?",
            "Select the valid statement to declare and initialize an array."
        };

        String[][] opts = {
            {
                "6",
                "7",
                "8",
                "9"
            },
            {
                "32 and 64",
                "32 and 32",
                "64 and 64",
                "64 and 32",},
            {
                "Byte to Int",
                "Int to Long",
                "Long to Int"
            },
            {
                "The reference of the array.",
                "A copy of the array.",
                "Length of the array.",
                "Copy of first element."
            },
            {
                "int[] arr = { };",
                "int[] arr = {1, 2, 3};",
                "int[] arr = (1, 2, 3);",
                "int[][] arr = {1, 2, 3};"
            }
        };

        String[] ans = {"c", "a", "b", "a", "b"};
        int[] marks = {10, 10, 10, 20, 20};

        for (int i = 0; i < ques.length; i++) {
            switch (opts[i].length) {
                case 2:
                    questions.add(new Question(ques[i], opts[i][0], opts[i][1], ans[i], marks[i]));
                    break;
                case 3:
                    questions.add(new Question(ques[i], opts[i][0], opts[i][1], opts[i][2], ans[i], marks[i]));
                    break;
                default:
                    questions.add(new Question(ques[i], opts[i][0], opts[i][1], opts[i][2], opts[i][3], ans[i], marks[i]));
            }
        }

        showQuestion();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel ID;
    private javax.swing.JLabel branch;
    private javax.swing.JButton button;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel counter;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel name;
    private javax.swing.JRadioButton option1;
    private javax.swing.JRadioButton option2;
    private javax.swing.JRadioButton option3;
    private javax.swing.JRadioButton option4;
    private javax.swing.JLabel quesMarks;
    private javax.swing.JLabel question;
    // End of variables declaration//GEN-END:variables
}
