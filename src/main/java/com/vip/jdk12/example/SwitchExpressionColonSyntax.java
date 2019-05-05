package com.vip.jdk12.example;

import java.util.ArrayList;

public class SwitchExpressionColonSyntax {

    public static void main(String[] args) {
        Employee vipin = new Employee(1, "Vipin", "MD", 10);
        Employee nitin = new Employee(2, "Nitin", "ED", 10);
        Employee ekta = new Employee(3, "Ekta", "VP", 7);
        Employee mudita = new Employee(3, "Mudita", "VP", 5);
        Employee teena = new Employee(3, "Teena", "VP", 16);
        Employee tanay = new Employee(4, "Tanay", "SeniorAssociate", 11);
        Employee mini = new Employee(4, "Mini", "Associate", 5);

        ArrayList<Employee> employees = new ArrayList();
        employees.add(vipin);
        employees.add(nitin);
        employees.add(ekta);
        employees.add(mudita);
        employees.add(teena);
        employees.add(tanay);
        employees.add(mini);

        System.out.println("");
        employees.forEach(employee ->
                System.out.println(employee.getName() + " gets Bonus " + getYearlyBonus_expresion_colonSyntax(employee.getDesignation()) + " %"));


    }

    /**
     * 1.   Only change is converting arrow into :
     */

    private static double getYearlyBonus_expresion_colonSyntax(String designation) {
        double bonus = switch (designation) {
            case "MD": {
                break 50.0 + 1.;
            }
            case "ED": {
                double temp = 1.;
                break 25.0 + temp;
            }
            case "VP", "SeniorAssociate": break 20.0;
            case "Manager": throw new RuntimeException("I dont know what is Manager designation");
            default: break 10.0;
        };
        return bonus;
    }
}