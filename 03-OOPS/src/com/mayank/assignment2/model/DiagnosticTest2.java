package com.mayank.assignment2.model;

public class DiagnosticTest2 extends HospitalService2 {

   public DiagnosticTest2(int id, String name, double fee) throws InvalidServiceException2 {
        super(id, name, fee);
        System.out.println("Diagnostic Test Constructor Called");
    }

    public boolean validateService() {
        return fee >= 200;
    }
}