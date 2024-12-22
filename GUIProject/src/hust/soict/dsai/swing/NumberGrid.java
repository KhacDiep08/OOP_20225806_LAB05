package hust.soict.dsai.swing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class NumberGrid extends JFrame {
    private JButton[] btnNumbers = new JButton[10];
    private JButton btnDelete, btnReset;
    private JTextField tfDisplay;

    public NumberGrid() {
        tfDisplay = new JTextField();
        tfDisplay.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);

        JPanel panelButtons = new JPanel(new GridLayout(4, 3));
        addButtons(panelButtons);

        Container cp = getContentPane();
        cp.setLayout(new BorderLayout());
        cp.add(tfDisplay, BorderLayout.NORTH);
        cp.add(panelButtons, BorderLayout.CENTER);

        setTitle("Number Grid");
        setSize(200, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    private void addButtons(JPanel panelButtons) {
        ButtonListener btnListener = new ButtonListener();

        // Tạo các nút số từ 1 đến 9
        for (int i = 1; i <= 9; i++) {
            btnNumbers[i] = new JButton(String.valueOf(i));
            panelButtons.add(btnNumbers[i]);
            btnNumbers[i].addActionListener(btnListener);
        }

        // Tạo nút xóa
        btnDelete = new JButton("DEL");
        panelButtons.add(btnDelete);
        btnDelete.addActionListener(btnListener);

        // Tạo nút reset
        btnReset = new JButton("C");
        panelButtons.add(btnReset);
        btnReset.addActionListener(btnListener);
    }

    private class ButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String buttonText = e.getActionCommand();

            if (Character.isDigit(buttonText.charAt(0))) {
                tfDisplay.setText(tfDisplay.getText() + buttonText);
            } else if (buttonText.equals("DEL")) {
                String currentText = tfDisplay.getText();
                if (currentText.length() > 0) {
                    tfDisplay.setText(currentText.substring(0, currentText.length() - 1));
                }
            } else if (buttonText.equals("C")) {
                tfDisplay.setText("");
            }
        }
    }

    public static void main(String[] args) {
        new NumberGrid();
    }
}
