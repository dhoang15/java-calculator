package test;

import model.CaculatorModel;
import model.EvalException; 

public class test {
    public static void main(String[] args) {
        CaculatorModel s1 = new CaculatorModel();
        //trường hợp cộng
        s1.setFirstValue(4);
        s1.setSecondValue(2);
        s1.sum();
        System.out.println(s1.getResult());
        s1.clear();
        //trường hợp trừ
        s1.setFirstValue(4);
        s1.setSecondValue(2);
        s1.sub();
        System.out.println(s1.getResult());
        s1.clear();
        //trường hợp nhân        
        s1.setFirstValue(4);
        s1.setSecondValue(2);
        s1.mul();
        System.out.println(s1.getResult());
        s1.clear();
        //trường hợp chia
        s1.setFirstValue(4);
        s1.setSecondValue(2);
        try {
            s1.div();
            System.out.println(s1.getResult());
            
        } catch (EvalException e) {
            System.out.println(e.getMessage());
        }finally{
            s1.clear();
        }
    }
}