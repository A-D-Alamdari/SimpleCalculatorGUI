import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Calculator implements ActionListener {
    JFrame frame;
    JTextField textField;
    JButton[] numberedButtons = new JButton[10];
    JButton[] functionButtons = new JButton[10];
    JButton addButton, subButton, mulButton, divButton;
    JButton decButton, equButton, delButton, clrButton, negButton, modButton;
    JPanel panel;

    Font myFont = new Font("Noteworthy", Font.BOLD, 30);

    double num1 = 0;
    double num2 = 0;
    double result = 0;
    char operator;

    Calculator() {
        frame = new JFrame("Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(380, 435);
        frame.setLayout(null);
        frame.setBackground(Color.darkGray);
        frame.setForeground(Color.darkGray);
        frame.setResizable(false);

        textField = new JTextField();
        textField.setBounds(6, 10, 365, 80);
        textField.setFont(myFont);
        textField.setEditable(false);
        textField.setBackground(Color.darkGray);
        textField.setForeground(Color.white);

        addButton = new JButton("+");
        addButton.setOpaque(true);
        addButton.setContentAreaFilled(true);
        addButton.setBorderPainted(false);
        addButton.setFocusPainted(true);
        addButton.setBackground(Color.orange);
        addButton.setForeground(Color.white);

        subButton = new JButton("-");
        subButton.setOpaque(true);
        subButton.setContentAreaFilled(true);
        subButton.setBorderPainted(false);
        subButton.setFocusPainted(true);
        subButton.setBackground(Color.orange);
        subButton.setForeground(Color.white);

        mulButton = new JButton("x");
        mulButton.setOpaque(true);
        mulButton.setContentAreaFilled(true);
        mulButton.setBorderPainted(false);
        mulButton.setFocusPainted(true);
        mulButton.setBackground(Color.orange);
        mulButton.setForeground(Color.white);

        divButton = new JButton("/");
        divButton.setOpaque(true);
        divButton.setContentAreaFilled(true);
        divButton.setBorderPainted(false);
        divButton.setFocusPainted(true);
        divButton.setBackground(Color.orange);
        divButton.setForeground(Color.white);

        decButton = new JButton(".");
        decButton.setOpaque(true);
        decButton.setContentAreaFilled(true);
        decButton.setBorderPainted(false);
        decButton.setFocusPainted(true);
        decButton.setBackground(Color.gray);
        decButton.setForeground(Color.white);

        equButton = new JButton("=");
        equButton.setOpaque(true);
        equButton.setContentAreaFilled(true);
        equButton.setBorderPainted(false);
        equButton.setFocusPainted(true);
        equButton.setBackground(Color.orange);
        equButton.setForeground(Color.white);

        modButton = new JButton("%");
        modButton.setOpaque(true);
        modButton.setContentAreaFilled(true);
        modButton.setBorderPainted(false);
        modButton.setFocusPainted(true);
        modButton.setBackground(Color.gray);
        modButton.setForeground(Color.white);

        negButton = new JButton("±");
        negButton.setOpaque(true);
        negButton.setContentAreaFilled(true);
        negButton.setBorderPainted(false);
        negButton.setFocusPainted(true);
        negButton.setBackground(Color.gray);
        negButton.setForeground(Color.white);

        delButton = new JButton("Del");
        delButton.setOpaque(true);
        delButton.setContentAreaFilled(true);
        delButton.setBorderPainted(false);
        delButton.setFocusPainted(true);
        delButton.setBackground(Color.red);
        delButton.setForeground(Color.white);

        clrButton = new JButton("Clr");
        clrButton.setOpaque(true);
        clrButton.setContentAreaFilled(true);
        clrButton.setBorderPainted(false);
        clrButton.setFocusPainted(true);
        clrButton.setBackground(Color.gray);
        clrButton.setForeground(Color.white);

        functionButtons[0] = addButton;
        functionButtons[1] = subButton;
        functionButtons[2] = mulButton;
        functionButtons[3] = divButton;
        functionButtons[4] = decButton;
        functionButtons[5] = equButton;
        functionButtons[6] = delButton;
        functionButtons[7] = clrButton;
        functionButtons[8] = negButton;
        functionButtons[9] = modButton;

        for (int i = 0; i < functionButtons.length; i++) {
            functionButtons[i].addActionListener(this);
            functionButtons[i].setFont(myFont);
            functionButtons[i].setFocusable(false);
        }

        for (int i = 0; i < numberedButtons.length; i++) {
            numberedButtons[i] = new JButton(String.valueOf(i));
            numberedButtons[i].addActionListener(this);
            numberedButtons[i].setFont(myFont);
            numberedButtons[i].setFocusable(false);

            numberedButtons[i].setOpaque(true);
            numberedButtons[i].setContentAreaFilled(true);
            numberedButtons[i].setBorderPainted(false);
            numberedButtons[i].setFocusPainted(true);
            numberedButtons[i].setBackground(Color.lightGray);
            numberedButtons[i].setForeground(Color.white);
        }


        panel = new JPanel();
        panel.setBounds(10, 95, 360, 300);
        panel.setLayout(new GridLayout(5, 4, 5, 10));


        // First Row
        panel.add(clrButton);
        panel.add(negButton);
        panel.add(modButton);
        panel.add(divButton);
        // Second Row
        panel.add(numberedButtons[7]);
        panel.add(numberedButtons[8]);
        panel.add(numberedButtons[9]);
        panel.add(mulButton);
        // Third Row
        panel.add(numberedButtons[4]);
        panel.add(numberedButtons[5]);
        panel.add(numberedButtons[6]);
        panel.add(subButton);
        // Fourth Row
        panel.add(numberedButtons[1]);
        panel.add(numberedButtons[2]);
        panel.add(numberedButtons[3]);
        panel.add(addButton);
        // Fifth Row
        panel.add(delButton);
        panel.add(numberedButtons[0]);
        panel.add(decButton);
        panel.add(equButton);



        frame.add(panel);

        frame.add(textField);


        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Adding functionality to number buttons
        for (int i = 0; i < numberedButtons.length; i++) {
            if (e.getSource() == numberedButtons[i]) {
                textField.setText(textField.getText().concat(String.valueOf(i)));
            }
        }

        // Add functionality to other buttons
        if (e.getSource() == decButton) {
            textField.setText(textField.getText().concat(String.valueOf(".")));
        }

        if (e.getSource() == addButton) {
            num1 = Double.parseDouble(textField.getText());
            operator = '+';
            textField.setText("");
        }

        if (e.getSource() == subButton) {
            num1 = Double.parseDouble(textField.getText());
            operator = '-';
            textField.setText("");
        }

        if (e.getSource() == mulButton) {
            num1 = Double.parseDouble(textField.getText());
            operator = 'x';
            textField.setText("");
        }

        if (e.getSource() == modButton) {
            num1 = Double.parseDouble(textField.getText());
            operator = '%';
            textField.setText("");
        }

        if (e.getSource() == divButton) {
            num1 = Double.parseDouble(textField.getText());
            operator = '/';
            textField.setText("");
        }

        // Add functionality to equal button
        if (e.getSource() == equButton) {
            num2 = Double.parseDouble(textField.getText());
            switch (operator) {
                case '+':
                    result = num1 + num2;
                    break;
                case '-':
                    result = num1 - num2;
                    break;
                case 'x':
                    result = num1 * num2;
                    break;
                case '/':
                    result = num1 / num2;
                    break;
                case '%':
                    result = num1 % num2;
                    break;
            }
            textField.setText(String.valueOf(result));
            num1 = result;
        }

        // Add functionality to clear button
        if (e.getSource() == clrButton) {
            textField.setText("");
        }

        // Add functionality to delete button
        if (e.getSource() == delButton) {
            String string = textField.getText();
            textField.setText("");
            for (int i = 0; i < string.length() - 1; i++) {
                textField.setText(textField.getText() + string.charAt(i));
            }
        }

        // Add functionality to negate button
        if (e.getSource() == negButton) {
            double temp = Double.parseDouble(textField.getText());
            temp *= -1;
            textField.setText(String.valueOf(temp));
        }

    }
}
