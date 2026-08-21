package view;

import Controller.CaculatorListener;
import java.awt.*;
import java.awt.event.ActionListener;
import javax.swing.*;
import model.CaculatorModel;

public class CaculatorView extends JFrame {
    private CaculatorModel caculatorModel;
    private JTextField displayField; 

    public CaculatorView() {
        this.caculatorModel = new CaculatorModel();
        this.init();
    }

    public void init() {
        this.setTitle("Calculator");
        this.setSize(300, 350);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout());
        
        ActionListener ac = new CaculatorListener(this);
        
        displayField = new JTextField();
        displayField.setFont(new Font("Arial", Font.BOLD, 20));
        displayField.setEditable(false);
        displayField.setHorizontalAlignment(JTextField.RIGHT); 
        
        JPanel panelNorth = new JPanel(new BorderLayout());
        panelNorth.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        panelNorth.add(displayField, BorderLayout.CENTER);
        this.add(panelNorth, BorderLayout.NORTH);
        
        JPanel panelButtons = new JPanel();
        panelButtons.setLayout(new GridLayout(4, 4, 5, 5)); 
        
        // Tạo các nút bấm và gắn ActionListener
        JButton btn7 = new JButton("7"); btn7.addActionListener(ac);
        JButton btn8 = new JButton("8"); btn8.addActionListener(ac);
        JButton btn9 = new JButton("9"); btn9.addActionListener(ac);
        JButton btnDiv = new JButton("/"); btnDiv.addActionListener(ac);
        
        JButton btn4 = new JButton("4"); btn4.addActionListener(ac);
        JButton btn5 = new JButton("5"); btn5.addActionListener(ac);
        JButton btn6 = new JButton("6"); btn6.addActionListener(ac);
        JButton btnMul = new JButton("*"); btnMul.addActionListener(ac);
        
        JButton btn1 = new JButton("1"); btn1.addActionListener(ac);
        JButton btn2 = new JButton("2"); btn2.addActionListener(ac);
        JButton btn3 = new JButton("3"); btn3.addActionListener(ac);
        JButton btnSub = new JButton("-"); btnSub.addActionListener(ac);
        
        JButton btn0 = new JButton("0"); btn0.addActionListener(ac);
        JButton btnC = new JButton("C"); btnC.addActionListener(ac);
        JButton btnEquals = new JButton("="); btnEquals.addActionListener(ac);
        JButton btnSum = new JButton("+"); btnSum.addActionListener(ac);

        panelButtons.add(btn7); panelButtons.add(btn8); panelButtons.add(btn9); panelButtons.add(btnDiv);
        panelButtons.add(btn4); panelButtons.add(btn5); panelButtons.add(btn6); panelButtons.add(btnMul);
        panelButtons.add(btn1); panelButtons.add(btn2); panelButtons.add(btn3); panelButtons.add(btnSub);
        panelButtons.add(btn0); panelButtons.add(btnC); panelButtons.add(btnEquals); panelButtons.add(btnSum);
        
        panelButtons.setBorder(BorderFactory.createEmptyBorder(0, 10, 10, 10));
        this.add(panelButtons, BorderLayout.CENTER);
        this.setVisible(true);
    }

    public void sum() {
        try {
            double value = Double.parseDouble(displayField.getText());
            caculatorModel.setFirstValue(value);
            caculatorModel.setMathOperation("+");
            displayField.setText(""); 
        } catch (Exception e) {
            displayField.setText("Loi nhap lieu");
        }
    }

    public void sub() {
        try {
            double value = Double.parseDouble(displayField.getText());
            caculatorModel.setFirstValue(value);
            caculatorModel.setMathOperation("-");
            displayField.setText("");
        } catch (Exception e) {
            displayField.setText("Loi nhap lieu");
        }
    }

    public void mul() {
        try {
            double value = Double.parseDouble(displayField.getText());
            caculatorModel.setFirstValue(value);
            caculatorModel.setMathOperation("*");
            displayField.setText("");
        } catch (Exception e) {
            displayField.setText("Loi nhap lieu");
        }
    }

    public void div() {
        try {
            double value = Double.parseDouble(displayField.getText());
            caculatorModel.setFirstValue(value);
            caculatorModel.setMathOperation("/");
            displayField.setText("");
        } catch (Exception e) {
            displayField.setText("Loi nhap lieu");
        }
    }

    public void equals() {
        try {
            double value = Double.parseDouble(displayField.getText());
            caculatorModel.setSecondValue(value);
            String operation = caculatorModel.getMathOperation();
            
            if (operation == null) {
                return;
            }

            switch (operation) {
                case "+":
                    caculatorModel.sum();
                    break;
                case "-":
                    caculatorModel.sub();
                    break;
                case "*":
                    caculatorModel.mul();
                    break;
                case "/":
                    try {
                        caculatorModel.div();
                    } catch (Exception e) {
                        displayField.setText(e.getMessage());
                        return;
                    }
                    break;
                default:
                    displayField.setText("Phep tinh khong hop le");
                    return;
            }
            displayField.setText(String.valueOf(caculatorModel.getResult()));
        } catch (Exception e) {
            displayField.setText("Loi nhap lieu");
        }
    }

    public void clear() {
        caculatorModel.clear();
        this.displayField.setText("");
    }

    public void append(String s) {
        String currentText = displayField.getText();
        if (currentText.equals("Loi chia cho khong") || currentText.equals("Loi nhap lieu") || currentText.equals("Phep tinh khong hop le")) {
            currentText = ""; 
        }
        displayField.setText(currentText + s);
    }
}