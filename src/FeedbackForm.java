import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FeedbackForm {
        public static void main(String[] args) {
            JFrame frame = new JFrame("Java Course Feedback Form");
            JTabbedPane tabbedPane = new JTabbedPane();

            // Tab 1: Personal Information
            JPanel personalInfoPanel = new JPanel();
            personalInfoPanel.setLayout(new GridLayout(3, 2, 5, 5));
            personalInfoPanel.add(new JLabel("Name:"));
            JTextField nameField = new JTextField(15);
            personalInfoPanel.add(nameField);
            personalInfoPanel.add(new JLabel("Email:"));
            JTextField emailField = new JTextField(15);
            personalInfoPanel.add(emailField);
            tabbedPane.addTab("Personal Info", personalInfoPanel);

            // Tab 2: Course Feedback
            JPanel feedbackPanel = new JPanel();
            feedbackPanel.setLayout(new GridLayout(7, 1));
            feedbackPanel.add(new JLabel("How would you rate the course content?"));
            ButtonGroup ratingGroup = new ButtonGroup();
            JRadioButton excellent = new JRadioButton("Excellent");
            JRadioButton good = new JRadioButton("Good");
            JRadioButton average = new JRadioButton("Average");
            ratingGroup.add(excellent);
            ratingGroup.add(good);
            ratingGroup.add(average);
            feedbackPanel.add(excellent);
            feedbackPanel.add(good);
            feedbackPanel.add(average);
            feedbackPanel.add(new JLabel("How satisfied were you with the instructor?"));
            JComboBox<String> instructorRating = new JComboBox<>(new String[]{"Very Satisfied", "Satisfied", "Neutral", "Dissatisfied"});
            feedbackPanel.add(instructorRating);
            tabbedPane.addTab("Course Feedback", feedbackPanel);

            // Tab 3: Course Improvements
            JPanel suggestionsPanel = new JPanel();
            suggestionsPanel.setLayout(new GridLayout(5, 1));
            suggestionsPanel.add(new JLabel("What would you like to see improved?"));
            JCheckBox feature1 = new JCheckBox("More practical exercises");
            JCheckBox feature2 = new JCheckBox("More theoretical explanations");
            JCheckBox feature3 = new JCheckBox("More code examples");
            JCheckBox feature4 = new JCheckBox("Additional study materials");
            suggestionsPanel.add(feature1);
            suggestionsPanel.add(feature2);
            suggestionsPanel.add(feature3);
            suggestionsPanel.add(feature4);
            tabbedPane.addTab("Improvements", suggestionsPanel);

            // Submit Button
            JButton submitButton = new JButton("Submit Feedback");
            submitButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String name = nameField.getText();
                    String email = emailField.getText();
                    String courseRating = excellent.isSelected() ? "Excellent" : good.isSelected() ? "Good" : "Average";
                    String instructorSatisfaction = (String) instructorRating.getSelectedItem();
                    StringBuilder improvements = new StringBuilder("Requested Improvements: ");
                    if (feature1.isSelected()) improvements.append("More practical exercises ");
                    if (feature2.isSelected()) improvements.append("More theoretical explanations ");
                    if (feature3.isSelected()) improvements.append("More code examples ");
                    if (feature4.isSelected()) improvements.append("Additional study materials ");

                    JOptionPane.showMessageDialog(frame,
                            "Name: " + name + "\nEmail: " + email + 
                            "\nCourse Rating: " + courseRating + 
                            "\nInstructor Rating: " + instructorSatisfaction +
                            "\n" + improvements.toString());
                }
            });

            frame.setLayout(new BorderLayout());
            frame.add(tabbedPane, BorderLayout.CENTER);
            frame.add(submitButton, BorderLayout.SOUTH);

            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(400, 300);
            frame.setVisible(true);
        }
}