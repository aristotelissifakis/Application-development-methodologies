package calculatorapp;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalculatorApp extends JFrame {
    private JTextField number1Field;
    private JTextField number2Field;
    private JButton addButton;
    private JButton subtractButton;
    private JButton multiplyButton;
    private JButton divideButton;
    private JButton clearButton;
    private JLabel answerLabel;

    public CalculatorApp() {
        setTitle("Calculator");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Top panel with input fields
        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new FlowLayout());
        number1Field = new JTextField(10);
        number2Field = new JTextField(10);
        inputPanel.add(number1Field);
        inputPanel.add(number2Field);

        // Bottom panel with buttons
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout());
        addButton = new JButton("Add");
        subtractButton = new JButton("Subtract");
        multiplyButton = new JButton("Multiply");
        divideButton = new JButton("Divide");
        clearButton = new JButton("Clear");
        buttonPanel.add(addButton);
        buttonPanel.add(subtractButton);
        buttonPanel.add(multiplyButton);
        buttonPanel.add(divideButton);
        buttonPanel.add(clearButton);

        // Answer label
        answerLabel = new JLabel("Answer goes here");

        // Add components to the frame
        add(inputPanel, BorderLayout.NORTH);
        add(buttonPanel, BorderLayout.CENTER);
        add(answerLabel, BorderLayout.SOUTH);

        pack();
        setVisible(true);

        // Action listeners for the buttons
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                performAddition();
            }
        });

        subtractButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                performSubtraction();
            }
        });

        multiplyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                performMultiplication();
            }
        });

        divideButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                performDivision();
            }
        });

        clearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clearFields();
            }
        });
    }

    private void performAddition() {
        String number1Text = number1Field.getText();
        String number2Text = number2Field.getText();

        if (!number1Text.isEmpty() && !number2Text.isEmpty()) {
            try {
                int number1 = Integer.parseInt(number1Text);
                int number2 = Integer.parseInt(number2Text);
                int result = number1 + number2;
                answerLabel.setText(number1 + " + " + number2 + " = " + result);
            } catch (NumberFormatException e) {
                answerLabel.setText("Invalid input. Please enter valid integers.");
            }
        } else {
            answerLabel.setText("Please enter numbers in both fields.");
        }
    }

    private void performSubtraction() {
        String number1Text = number1Field.getText();
        String number2Text = number2Field.getText();

        if (!number1Text.isEmpty() && !number2Text.isEmpty()) {
            try {
                int number1 = Integer.parseInt(number1Text);
                int number2 = Integer.parseInt(number2Text);
                int result = number1 - number2;
                answerLabel.setText(number1 + " - " + number2 + " = " + result);
            } catch (NumberFormatException e) {
                answerLabel.setText("Invalid input. Please enter valid integers.");
            }
        } else {
            answerLabel.setText("Please enter numbers in both fields.");
        }
    }

    private void performMultiplication() {
        String number1Text = number1Field.getText();
        String number2Text = number2Field.getText();

        if (!number1Text.isEmpty() && !number2Text.isEmpty()) {
            try {
                int number1 = Integer.parseInt(number1Text);
                int number2 = Integer.parseInt(number2Text);
                int result = number1 * number2;
                answerLabel.setText(number1 + " * " + number2 + " = " + result);
            } catch (NumberFormatException e) {
                answerLabel.setText("Invalid input. Please enter valid integers.");
            }
        } else {
            answerLabel.setText("Please enter numbers in both fields.");
        }
    }

    private void performDivision() {
        String number1Text = number1Field.getText();
        String number2Text = number2Field.getText();

        if (!number1Text.isEmpty() && !number2Text.isEmpty()) {
            try {
                int number1 = Integer.parseInt(number1Text);
                int number2 = Integer.parseInt(number2Text);

                if (number2 != 0) {
                    int result = number1 / number2;
                    answerLabel.setText(number1 + " / " + number2 + " = " + result);
                } else {
                    answerLabel.setText("Cannot divide by zero.");
                }
            } catch (NumberFormatException e) {
                answerLabel.setText("Invalid input. Please enter valid integers.");
            }
        } else {
            answerLabel.setText("Please enter numbers in both fields.");
        }
    }

    private void clearFields() {
        number1Field.setText("");
        number2Field.setText("");
        answerLabel.setText("Answer goes here");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new CalculatorApp());
    }
}

