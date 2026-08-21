import javax.swing.*;

public class MyCaculator extends JFrame {
    public MyCaculator(){
        this.setTitle("Caculator");
        this.setSize(300,300);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }
    public static void main(String[] args){
        new MyCaculator();
    }
}
