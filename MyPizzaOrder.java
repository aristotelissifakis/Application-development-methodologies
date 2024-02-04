package mypizzaorder;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;

public class MyPizzaOrder extends JFrame {
    private static final int WIDTH = 300;
    private static final int HEIGHT = 300;

    private JRadioButton small, medium, large;
    private JCheckBox pepperoni, anchovies;
    private JComboBox<String> inOrOut;
    private String[] inOrOutChoices = {"(Select a delivery option)",
                                       "Eat-in", "Take out", "Home Delivery"};
    private JLabel message = new JLabel("Message goes here");
    private JButton completeOrderButton;

    public MyPizzaOrder() {
        small = new JRadioButton("Small");
        small.setActionCommand("Small");
        medium = new JRadioButton("Medium");
        medium.setActionCommand("Medium");
        large = new JRadioButton("Large");
        large.setActionCommand("Large");
        ButtonGroup sizeGroup = new ButtonGroup();
        sizeGroup.add(small);
        sizeGroup.add(medium);
        sizeGroup.add(large);
        SizeListener sl = new SizeListener();
        small.addActionListener(sl);
        medium.addActionListener(sl);
        large.addActionListener(sl);
        JPanel p1 = new JPanel();
        p1.add(small);
        p1.add(medium);
        p1.add(large);
        p1.setBorder(new TitledBorder(new EtchedBorder(), "Size"));

        pepperoni = new JCheckBox("Pepperoni");
        anchovies = new JCheckBox("Anchovies");
        ToppingListener tl = new ToppingListener();
        pepperoni.addItemListener(tl);
        anchovies.addItemListener(tl);
        JPanel p2 = new JPanel();
        p2.add(pepperoni);
        p2.add(anchovies);
        p2.setBorder(new TitledBorder(new EtchedBorder(), "Toppings"));

        inOrOut = new JComboBox<>(inOrOutChoices);
        inOrOut.setEditable(false);
        inOrOut.addActionListener(new DeliveryListener());
        JPanel p3 = new JPanel();
        p3.add(inOrOut);
        p3.setBorder(new TitledBorder(new EtchedBorder(), "Delivery"));

        completeOrderButton = new JButton("Complete order");
        completeOrderButton.addActionListener(new CompleteOrderListener());

        Container pane = getContentPane();
        pane.setLayout(new FlowLayout());
        pane.add(p1);
        pane.add(p2);
        pane.add(p3);
        pane.add(completeOrderButton);
        pane.add(message);
        setSize(WIDTH, HEIGHT);
    }

    private class SizeListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String size = e.getActionCommand();
            message.setText("Size = " + size);
        }
    }

    private String getSelectedSize() {
        if (small.isSelected()) {
            return "Small";
        } else if (medium.isSelected()) {
            return "Medium";
        } else if (large.isSelected()) {
            return "Large";
        } else {
            return "";
        }
    }

    private class ToppingListener implements ItemListener {
        public void itemStateChanged(ItemEvent e) {
            String topping;
            if (e.getItemSelectable() == pepperoni) {
                topping = "Pepperoni";
            } else {
                topping = "Anchovies";
            }

            if (e.getStateChange() == ItemEvent.SELECTED) {
                message.setText("Topping " + topping + " added.");
            } else if (e.getStateChange() == ItemEvent.DESELECTED) {
                message.setText("Topping " + topping + " deleted.");
            }
        }
    }

    private String getSelectedToppings() {
        String toppings = "";
        if (pepperoni.isSelected()) {
            toppings += "Pepperoni";
        }
        if (anchovies.isSelected()) {
            if (!toppings.isEmpty()) {
                toppings += ", ";
            }
            toppings += "Anchovies";
        }
        return toppings;
    }

    private class DeliveryListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            JComboBox<String> cb = (JComboBox<String>) e.getSource();
            String deliveryMethod;

            int selectedIndex = cb.getSelectedIndex();
            if (selectedIndex == 0) {
                deliveryMethod = "";
            } else {
                deliveryMethod = inOrOutChoices[selectedIndex];
            }
            message.setText("Delivery = " + deliveryMethod);
        }
    }

    private String getSelectedDeliveryMethod() {
        int selectedIndex = inOrOut.getSelectedIndex();
        if (selectedIndex == 0) {
            return "";
        } else {
            return inOrOutChoices[selectedIndex];
        }
    }

    private class CompleteOrderListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String size = getSelectedSize();
            String toppings = getSelectedToppings();
            String deliveryMethod = getSelectedDeliveryMethod();

            if (size.isEmpty() || toppings.isEmpty() || deliveryMethod.isEmpty()) {
                message.setText("Please complete all the options.");
            } else {
                String order = size + ", " + toppings + ", " + deliveryMethod;
                message.setText(order);
            }
        }
    }

    public static void main(String s[]) {
        MyPizzaOrder frame = new MyPizzaOrder();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
