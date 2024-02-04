package calculator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Calculator extends JFrame {
    private JTextField displayField;
    private String currentInput;
    private double result;
    private char operator;

    public Calculator() {
        setTitle("Calculator");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        displayField = new JTextField();
        displayField.setEditable(false);
        displayField.setHorizontalAlignment(JTextField.RIGHT);
        add(displayField, BorderLayout.NORTH);

        JPanel buttonPanel = new JPanel(new GridLayout(4, 4));

        String[] buttonLabels = {
                "7", "8", "9", "/",
                "4", "5", "6", "*",
                "1", "2", "3", "-",
                "0", ".", "=", "+"
        };

        for (String label : buttonLabels) {
            JButton button = new JButton(label);
            button.addActionListener(new ButtonClickListener());
            buttonPanel.add(button);
        }

        add(buttonPanel, BorderLayout.CENTER);

        pack();
        setLocationRelativeTo(null);
        setVisible(true);

        currentInput = "";
        result = 0.0;
        operator = ' ';
    }

    private class ButtonClickListener implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            String buttonLabel = ((JButton) event.getSource()).getText();

            if (buttonLabel.equals("=")) {
                if (!currentInput.isEmpty()) {
                    double number = Double.parseDouble(currentInput);
                    calculateResult(number);
                }
            } else if (buttonLabel.equals("C")) {
                clearCalculator();
            } else {
                if (buttonLabel.equals("-")) {
                    // Handle subtraction operator
                    if (currentInput.isEmpty()) {
                        currentInput += "-";
                        displayField.setText(currentInput);
                    } else {
                        double number = Double.parseDouble(currentInput);
                        calculateResult(number);
                        operator = '-';
                    }
                } else {
                    currentInput += buttonLabel;
                    displayField.setText(currentInput);
                }
            }
        }
    }

    private void calculateResult(double number) {
        if (!currentInput.isEmpty()) {
            String expression = result + " " + operator + " " + currentInput;
            try {
                result = evaluateExpression(expression);
                displayField.setText(Double.toString(result));
            } catch (Exception e) {
                displayField.setText("Error: " + e.getMessage());
            }
        } else {
            result = number;
            displayField.setText(Double.toString(result));
        }

        currentInput = "";
    }

    private double evaluateExpression(String expression) {
        String[] tokens = expression.split("\\s+");
        double num1 = Double.parseDouble(tokens[0]);
        char operator = tokens[1].charAt(0);
        double num2 = Double.parseDouble(tokens[2]);

        switch (operator) {
            case '+':
                return num1 + num2;
            case '-':
                return num1 - num2;
            case '*':
                return num1 * num2;
            case '/':
                if (num2 != 0) {
                    return num1 / num2;
                } else {
                    throw new ArithmeticException("Division by zero");
                }
            default:
                throw new IllegalArgumentException("Invalid operator: " + operator);
        }
    }

    private void clearCalculator() {
        currentInput = "";
        result = 0.0;
        operator = ' ';
        displayField.setText("");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new Calculator();
            }
        });
    }
}

