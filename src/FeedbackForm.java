import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class FeedbackForm {
                                                            private static final String URL = "jdbc:postgresql://localhost:5432/Feedback_db";
                                                            private static final String USER = "postgres";
                                                            private static final String PASSWORD = "12345678";

                                                            public static void main(String[] args) {
                                                                try {
                                                                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                                                                    Class.forName("org.postgresql.Driver");
                                                                    Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
                                                                    System.out.println("Connected to the database!");
                                                                    JFrame frame = new JFrame("Java Course Feedback Form");
                                                                    frame.getRootPane().setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
                                                                    JTabbedPane tabbedPane = new JTabbedPane();
                                                                    tabbedPane.setFont(new Font("Arial", Font.PLAIN, 12));

                                                                    // Tab 1: Personal Information
                                                                    JPanel personalInfoPanel = new JPanel(new GridLayout(5, 2, 10, 10));
                                                                    personalInfoPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
                                                                    personalInfoPanel.add(new JLabel("Name:"));
                                                                    JTextField nameField = new JTextField(15);
                                                                    personalInfoPanel.add(nameField);
                                                                    personalInfoPanel.add(new JLabel("Roll no.:"));
                                                                    JTextField rollField = new JTextField(15);
                                                                    personalInfoPanel.add(rollField);
                                                                    personalInfoPanel.add(new JLabel("Email:"));
                                                                    JTextField emailField = new JTextField(15);
                                                                    personalInfoPanel.add(emailField);
                                                                    personalInfoPanel.add(new JLabel("Department:"));
                                                                    JTextField deptField = new JTextField(15);
                                                                    personalInfoPanel.add(deptField);
                                                                    personalInfoPanel.add(new JLabel("Semester:"));
                                                                    JTextField semesterField = new JTextField(15);
                                                                    personalInfoPanel.add(semesterField);
                                                                    tabbedPane.addTab("Personal Info", personalInfoPanel);

                                                                    // Tab 2: Course Feedback
                                                                    JPanel feedbackPanel = new JPanel(new GridLayout(12, 1, 5, 5));
                                                                    feedbackPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
                                                                    JLabel ratingLabel = new JLabel("How would you rate the course content?");
                                                                    ratingLabel.setFont(new Font("Arial", Font.BOLD, 12));
                                                                    feedbackPanel.add(ratingLabel);
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

                                                                    JLabel instructorLabel = new JLabel("How satisfied were you with the instructor?");
                                                                    instructorLabel.setFont(new Font("Arial", Font.BOLD, 12));
                                                                    feedbackPanel.add(instructorLabel);
                                                                    JComboBox<String> instructorRating = new JComboBox<>(new String[]{"Very Satisfied", "Satisfied", "Neutral", "Dissatisfied"});
                                                                    feedbackPanel.add(instructorRating);

                                                                    JLabel paceLabel = new JLabel("How would you rate the pace of the course?");
                                                                    paceLabel.setFont(new Font("Arial", Font.BOLD, 12));
                                                                    feedbackPanel.add(paceLabel);
                                                                    JComboBox<String> paceRating = new JComboBox<>(new String[]{"Too Fast", "Just Right", "Too Slow"});
                                                                    feedbackPanel.add(paceRating);

                                                                    JLabel materialsLabel = new JLabel("How would you rate the course materials provided?");
                                                                    materialsLabel.setFont(new Font("Arial", Font.BOLD, 12));
                                                                    feedbackPanel.add(materialsLabel);
                                                                    JComboBox<String> materialsRating = new JComboBox<>(new String[]{"Excellent", "Good", "Average", "Poor"});
                                                                    feedbackPanel.add(materialsRating);

                                                                    JLabel recommendLabel = new JLabel("Would you recommend this course to others?");
                                                                    recommendLabel.setFont(new Font("Arial", Font.BOLD, 12));
                                                                    feedbackPanel.add(recommendLabel);
                                                                    JComboBox<String> recommendRating = new JComboBox<>(new String[]{"Definitely", "Maybe", "No"});
                                                                    feedbackPanel.add(recommendRating);
                                                                    tabbedPane.addTab("Course Feedback", feedbackPanel);

                                                                    // Tab 3: Course Improvements
                                                                    JPanel suggestionsPanel = new JPanel(new GridLayout(8, 1, 5, 5));
                                                                    suggestionsPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
                                                                    JLabel improvementsLabel = new JLabel("What would you like to see improved?");
                                                                    improvementsLabel.setFont(new Font("Arial", Font.BOLD, 12));
                                                                    suggestionsPanel.add(improvementsLabel);
                                                                    JCheckBox feature1 = new JCheckBox("More practical exercises");
                                                                    JCheckBox feature2 = new JCheckBox("More theoretical explanations");
                                                                    JCheckBox feature3 = new JCheckBox("More code examples");
                                                                    JCheckBox feature4 = new JCheckBox("Additional study materials");
                                                                    JCheckBox feature5 = new JCheckBox("More interactive sessions");
                                                                    JCheckBox feature6 = new JCheckBox("Better assignment feedback");
                                                                    JCheckBox feature7 = new JCheckBox("More real-world projects");
                                                                    suggestionsPanel.add(feature1);
                                                                    suggestionsPanel.add(feature2);
                                                                    suggestionsPanel.add(feature3);
                                                                    suggestionsPanel.add(feature4);
                                                                    suggestionsPanel.add(feature5);
                                                                    suggestionsPanel.add(feature6);
                                                                    suggestionsPanel.add(feature7);
                                                                    tabbedPane.addTab("Improvements", suggestionsPanel);

                                                                    // Submit Button
                                                                    JButton submitButton = new JButton("Submit Feedback");
                                                                    submitButton.setBackground(new Color(00, 00, 32));
                                                                    submitButton.setForeground(Color.WHITE);
                                                                    submitButton.setFocusPainted(false);
                                                                    submitButton.setFont(new Font("Arial", Font.BOLD, 14));
                                                                    submitButton.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
                                                                    submitButton.addActionListener(new ActionListener() {
                                                                        @Override
                                                                        public void actionPerformed(ActionEvent e) {
                                                                            String name = nameField.getText();
                                                                            String rollNo = rollField.getText();
                                                                            String email = emailField.getText();
                                                                            String dept = deptField.getText();
                                                                            String semester = semesterField.getText();
                                                                            String courseRating = excellent.isSelected() ? "Excellent" : good.isSelected() ? "Good" : "Average";
                                                                            String instructorSatisfaction = (String) instructorRating.getSelectedItem();
                                                                            String paceFeedback = (String) paceRating.getSelectedItem();
                                                                            String materialsFeedback = (String) materialsRating.getSelectedItem();
                                                                            String recommendFeedback = (String) recommendRating.getSelectedItem();
                                                                            StringBuilder improvements = new StringBuilder();
                                                                            if (feature1.isSelected()) improvements.append("More practical exercises ");
                                                                            if (feature2.isSelected()) improvements.append("More theoretical explanations ");
                                                                            if (feature3.isSelected()) improvements.append("More code examples ");
                                                                            if (feature4.isSelected()) improvements.append("Additional study materials ");
                                                                            if (feature5.isSelected()) improvements.append("More interactive sessions ");
                                                                            if (feature6.isSelected()) improvements.append("Better assignment feedback ");
                                                                            if (feature7.isSelected()) improvements.append("More real-world projects ");

                                                                            // Database insertion logic
                                                                            try {
                                                                                String insertSQL = "INSERT INTO feedback (name, roll_no, email, department, semester, course_rating, instructor_satisfaction, pace_feedback, materials_feedback, recommend_feedback, improvements) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
                                                                                PreparedStatement preparedStatement = connection.prepareStatement(insertSQL);
                                                                                preparedStatement.setString(1, name);
                                                                                preparedStatement.setString(2, rollNo);
                                                                                preparedStatement.setString(3, email);
                                                                                preparedStatement.setString(4, dept);
                                                                                preparedStatement.setString(5, semester);
                                                                                preparedStatement.setString(6, courseRating);
                                                                                preparedStatement.setString(7, instructorSatisfaction);
                                                                                preparedStatement.setString(8, paceFeedback);
                                                                                preparedStatement.setString(9, materialsFeedback);
                                                                                preparedStatement.setString(10, recommendFeedback);
                                                                                preparedStatement.setString(11, improvements.toString());

                                                                                int rowsAffected = preparedStatement.executeUpdate();
                                                                                if (rowsAffected > 0) {
                                                                                    JOptionPane.showMessageDialog(frame, "Feedback submitted successfully!");
                                                                                } else {
                                                                                    JOptionPane.showMessageDialog(frame, "Failed to submit feedback.");
                                                                                }
                                                                            } catch (SQLException ex) {
                                                                                ex.printStackTrace();
                                                                                JOptionPane.showMessageDialog(frame, "Error while submitting feedback: " + ex.getMessage());
                                                                            }
                                                                        }
                                                                    });

                                                                    frame.setLayout(new BorderLayout());
                                                                    frame.add(tabbedPane, BorderLayout.CENTER);
                                                                    JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
                                                                    buttonPanel.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0));
                                                                    buttonPanel.add(submitButton);
                                                                    frame.add(buttonPanel, BorderLayout.SOUTH);
                                                                    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                                                                    frame.setSize(600, 500);
                                                                    frame.setLocationRelativeTo(null);
                                                                    frame.setVisible(true);
                                                                } catch (ClassNotFoundException | SQLException | UnsupportedLookAndFeelException | IllegalAccessException | InstantiationException e) {
                                                                    e.printStackTrace();
                                                                }
                                                            }
}


