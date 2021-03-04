package com.example.ComplexNum;
import java.math.BigDecimal;

public class ComplexNumOperations implements Operation {
    ComplexNum c1;
    ComplexNum c2;

    ComplexNumOperations(ComplexNum c1, ComplexNum c2){
        this.c1 = c1;
        this.c2 = c2;
    }

    // print out result
    private String printComplexNum(ComplexNum result){
        String res = result.real + " + " + result.img + "i";
        return res;

    }

    @Override
    public String sum(){
        double newReal = c1.real + c2.real;
        double newImg = c1.img + c2.img;

        ComplexNum newComplexNum = new ComplexNum(newReal, newImg);
        String result = printComplexNum(newComplexNum);

        return result;
    }

    @Override
    public String diff(){
        double newReal = c1.real - c2.real;
        double newImg = c1.img - c2.img;

        ComplexNum newComplexNum = new ComplexNum(newReal, newImg);
        String result = printComplexNum(newComplexNum);

        return result;

    }

    @Override
    public String multiply(){
        double newReal = (c1.real*c2.real) - (c1.img*c2.img);
        double newImg = (c1.real*c2.img) + (c1.img*c2.real);

        ComplexNum newComplexNum = new ComplexNum(newReal, newImg);
        String result = printComplexNum(newComplexNum);

        return result;

    }

    @Override
    public String divide(){
        double newReal = Math.round(((c1.real/c2.real) - (c1.img/c2.img))*100.0) / 100.0;
        double newImg = Math.round(((c1.real/c2.img) + (c1.img/c2.real))*100.0) / 100.0;

        ComplexNum newComplexNum = new ComplexNum(newReal, newImg);
        String result = printComplexNum(newComplexNum);

        return result;

    }


}
