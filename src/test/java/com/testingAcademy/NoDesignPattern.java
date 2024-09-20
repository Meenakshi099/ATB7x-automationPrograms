package com.testingAcademy;

public class NoDesignPattern {
    public void step1(){
        System.out.println("Step 1");
    }

    public void step2(){
        System.out.println("Step 2");
    }

    public void step3(String param1){
        System.out.println("Step 3");
    }
    public void step4(String param1){
        System.out.println("Step 4");
    }

    public static void main(String[] args) {
        NoDesignPattern np = new NoDesignPattern();
        np.step1();
        np.step2();
        np.step3("Pramod");
        np.step4("Meenu");
      //  System.out.println(np);
    }
}

