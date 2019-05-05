package com.vip.jdk12.example;

import java.util.ArrayList;

/**
 * Switch expression JDK 12, preview feature.
 */

public class SwitchStatementArrowSyntax {

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
                System.out.println(employee.getName() + " gets Bonus " + getYearlyBonus_statement_arrowSyntax(employee.getDesignation()) + " %"));


    }


    private static double getYearlyBonus_statement_arrowSyntax(String designation) {
        double bonus;
        switch (designation) {
            case "MD" -> {
                double temp = 1.;
                bonus = 50.0 + temp;
            }
            case "ED" -> {
                double temp = 1.;
                bonus = 25.0 + temp;
            }
            case "VP", "SeniorAssociate" ->
                bonus= 20.0;
            case "Manager" -> throw new RuntimeException("I dont know what is Manager designation");
            default -> {
                bonus = 10.0;
            }
        }
        return bonus;
    }
}