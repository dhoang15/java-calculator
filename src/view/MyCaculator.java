package view;

import javax.swing.*;
import java.awt.*;

public class MyCaculator extends JFrame {
    public MyCaculator(){
        this.setTitle("Caculator");
        this.setSize(300,300);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JTextField jtextfeild = new JTextField(50);
        JPanel jpanel_head = new JPanel();
        BorderLayout f1 = new BorderLayout();
        jpanel_head.setLayout(f1);
        jpanel_head.add(jtextfeild,BorderLayout.CENTER);
        JButton jbutton = new JButton("0");
        JButton jbutton1 = new JButton("1");
        JButton jbutton2 = new JButton("2");
        JButton jbutton3 = new JButton("3");
        JButton jbutton4 = new JButton("4");
        JButton jbutton5 = new JButton("5");
        JButton jbutton6 = new JButton("6");
        JButton jbutton7 = new JButton("7");
        JButton jbutton8 = new JButton("8");
        JButton jbutton9 = new JButton("9");
        JButton jbutton_cong = new JButton("+");
        JButton jbutton_tru = new JButton("-");
        JButton jbutton_nhan = new JButton("*");
        JButton jbutton_chia = new JButton("/");
        JButton jbutton_bang = new JButton("=");
        JPanel button = new JPanel();
        button.setLayout(new GridLayout(5,3));
        button.add(jbutton);
        button.add(jbutton1);
        button.add(jbutton2);
        button.add(jbutton3);
        button.add(jbutton4);
        button.add(jbutton5);
        button.add(jbutton6);
        button.add(jbutton7);
        button.add(jbutton8);
        button.add(jbutton9);
        button.add(jbutton_cong);
        button.add(jbutton_tru);
        button.add(jbutton_nhan);
        button.add(jbutton_chia);
        button.add(jbutton_bang);
        this.setLayout(new BorderLayout());
        this.add(jpanel_head,BorderLayout.NORTH);
        this.add(button,BorderLayout.CENTER);
        this.setVisible(true);
    }
    public static void main(String[] args){
        try{
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            new MyCaculator();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
