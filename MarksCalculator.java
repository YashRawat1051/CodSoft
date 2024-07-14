import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class MarksCalculator extends JFrame
{
    private JTextField hindiField,englishField,mathsField,scienceField,socialScienceField;
    private JLabel totalMarksLabel,averagePercentageLabel,gradeLabel;
    
    public MarksCalculator() {
        setTitle("Marks Calculator");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(8, 2));

        add(new JLabel("Hindi:"));
        hindiField = new JTextField();
        add(hindiField);

        add(new JLabel("English:"));
        englishField = new JTextField();
        add(englishField);

        add(new JLabel("Maths:"));
        mathsField = new JTextField();
        add(mathsField);

        add(new JLabel("Science:"));
        scienceField = new JTextField();
        add(scienceField);

        add(new JLabel("Social Science:"));
        socialScienceField = new JTextField();
        add(socialScienceField);

        JButton calculateButton = new JButton("Calculate");
        calculateButton.addActionListener(new CalculateButtonListener());
        add(calculateButton);

        totalMarksLabel = new JLabel("Total Marks: ");
        add(totalMarksLabel);

        averagePercentageLabel = new JLabel("Average Percentage: ");
        add(averagePercentageLabel);

        gradeLabel = new JLabel("Grade: ");
        add(gradeLabel);

        setVisible(true);
    }

    private class CalculateButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                int hindi = Integer.parseInt(hindiField.getText());
                int english = Integer.parseInt(englishField.getText());
                int maths = Integer.parseInt(mathsField.getText());
                int science = Integer.parseInt(scienceField.getText());
                int socialScience = Integer.parseInt(socialScienceField.getText());

                int totalMarks = hindi + english + maths + science + socialScience;
                double averagePercentage = totalMarks / 5.0;
                String grade;

                if (averagePercentage >= 85) {
                    grade = "A";
                } else if (averagePercentage >= 70) {
                    grade = "B";
                } else if (averagePercentage >= 55) {
                    grade = "C";
                } else if (averagePercentage >= 40) {
                    grade = "D";
                } else {
                    grade = "F";
                }

                totalMarksLabel.setText("Total Marks: " + totalMarks);
                averagePercentageLabel.setText("Average Percentage: " + averagePercentage);
                gradeLabel.setText("Grade: " + grade);
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Please enter valid marks.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    public static void main(String[] args) {
        MarksCalculator a1 =new MarksCalculator();
    }
}
