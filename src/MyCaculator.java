import javax.swing.*;

public class MyCaculator extends JFrame {
    public MyCaculator(){
        this.setTitle("Caculator");
        this.setSize(300,300);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JTextField jtextfeild = new JTextField();
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
        
        this.setVisible(true);
    }
    public static void main(String[] args){
        new MyCaculator();
    }
}
