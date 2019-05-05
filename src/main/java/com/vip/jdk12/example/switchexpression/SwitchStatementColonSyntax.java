package com.vip.jdk12.example.switchexpression;

import com.vip.jdk12.example.Employee;

import java.util.ArrayList;

/**
 * Switch expression JDK 12, preview feature.
 */

public class SwitchStatementColonSyntax {

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
                System.out.println(employee.getName() + " gets Bonus " + getYearlyBonus_statement_colonSyntax(employee.getDesignation()) + " %"));


    }


    /**
     * 1.   This is typical example of Old Switch statement using break, works in JDK8 as well.
     * 2.   Missing break statement can cause fallthrough.
     */
    private static double getYearlyBonus_statement_colonSyntax(String designation) {
        double bonus;
        switch (designation) {
            case "MD": {
                double temp = 1.;
                bonus = 50.0 + temp;
                break;
            }
            case "ED": {
                double temp = 1.;
                bonus = 25.0 + temp;
                break;
            }
            case "VP", "SeniorAssociate" :
                bonus= 20.0;
                break;
            case "Manager": throw new RuntimeException("I dont know what is Manager designation");
            default : {
                bonus = 10.0;
                break;
            }
        }
        return bonus;
    }
}