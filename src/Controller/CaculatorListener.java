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
        // System.out.println("Ban da nhan nut");
        String src = e.getActionCommand();
        System.out.println(src);
       if (src.equals("0") || src.equals("1") || src.equals("2") || src.equals("3") || 
    src.equals("4") || src.equals("5") || src.equals("6") || src.equals("7") || 
    src.equals("8") || src.equals("9")){
        caculatorView.append(src);
    }
        else if(src.equals("+")){
            caculatorView.sum();
        }else if(src.equals("-")){
            caculatorView.sub();
        }else if(src.equals("*")){
            caculatorView.mul();
        }
        else if(src.equals("/")){
            caculatorView.div();
        }else if(src.equals("C")){
            caculatorView.clear();
    }else if(src.equals("=")){
        caculatorView.equals();
    }
    }
}
