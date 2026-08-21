package Controller;

import java.awt.event.ActionListener;
import view.CaculatorView;

public class CaculatorListener implements ActionListener {
    private CaculatorView caculatorView;
    public CaculatorListener(CaculatorView caculatorView){
        this.caculatorView = caculatorView;
    }
    @Override
    public void actionPerformed(java.awt.event.ActionEvent e) {
        System.out.println("Ban da nhan nut");
    }

}
