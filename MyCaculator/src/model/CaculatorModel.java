package model;

public class CaculatorModel {
    private double firstValue;
    private double secondValue;
    private  double result ;
    private String mathOperation;
    public CaculatorModel(){
        this.result = 0;
    }
    public CaculatorModel(double firstValue,double secondValue,double result,String mathOperation){
        this.firstValue = firstValue;
        this.secondValue = secondValue;
        this.result = result;
        this.mathOperation = mathOperation;
    }
    public void sum(){
        result = firstValue + secondValue;
    }
    public void sub(){
        result = firstValue - secondValue;
    }
    public void mul(){
        result = firstValue * secondValue;
    }
    public void div() throws EvalException {
    if (secondValue == 0) {
        throw new EvalException("Loi chia cho khong");
    } else {
        result = firstValue / secondValue;
    }
}
    public void clear(){
        firstValue = 0;
        secondValue = 0;
        result = 0;
        mathOperation = "";
    }
    public double getFirstValue() {
        return firstValue;
    }

    public void setFirstValue(double firstValue) {
        this.firstValue = firstValue;
    }

    public double getSecondValue() {
        return secondValue;
    }

    public void setSecondValue(double secondValue) {
        this.secondValue = secondValue;
    }

    public double getResult() {
        return result;
    }

    public void setResult(double result) {
        this.result = result;
    }

    public String getMathOperation() {
        return mathOperation;
    }

    public void setMathOperation(String mathOperation) {
        this.mathOperation = mathOperation;
    }
    
    }
