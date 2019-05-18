package com.vip.jdk12.example.switchexpression;

import com.vip.jdk12.example.Employee;

import java.util.ArrayList;

/**
 * Switch expression JDK 12, preview feature.
 */

enum Designation{
    MD,
    ED,
    VP,
    SeniorAssociate,
    Associate;
}

public class ExperimentSwitchJDK12 {

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

        System.out.println("Old switch syntax");
        employees.forEach(employee ->
                System.out.println(employee.getName() + " gets Bonus " + getYearlyBonus_statement_colonSyntax_looksLikeExpression(employee.getDesignation()) + " %"));

        System.out.println("getYearlyBonus_statement_colonSyntax");
        employees.forEach(employee ->
                System.out.println(employee.getName() + " gets Bonus " + getYearlyBonus_statement_colonSyntax(employee.getDesignation()) + " %"));

        System.out.println();
        System.out.println("JDK12 switch syntax");
        employees.forEach(employee ->
                System.out.println(employee.getName() + " gets Bonus " + getYearlyBonusExperienceMatters_statement_arrowSyntax(employee) + " %"));


        System.out.println();
        System.out.println("JDK12 switch syntax");
        employees.forEach(employee ->
                System.out.println(employee.getName() + " gets Bonus " + getYearlyBonus_expression_arrowSyntax(employee.getDesignation()) + " %"));

        System.out.println();
        System.out.println("JDK12 switch syntax getYearlyBonus_expression_colonSyntax");
        employees.forEach(employee ->
                System.out.println(employee.getName() + " gets Bonus " + getYearlyBonus_expression_colonSyntax(employee.getDesignation()) + " %"));

        System.out.println();
        System.out.println("Switch expression without method, since not necessarily write it in a different method," +
                "This particular case it looks little ugly though");
        employees.forEach(employee ->
                System.out.println(employee.getName() + " gets Bonus " +
                        switch (employee.getDesignation()) {
                            case "MD" -> 70.0;
                            case "ED" -> 50.0;
                            case "VP", "SeniorAssociate" -> 40;
                            default -> 30.0;
                        } +
                        " %"));


    }


    private static double getYearlyBonus_expression_arrow_enum(Designation designation) {
        return switch(designation){
            case MD -> 50.0 + 1.0;
            case ED -> 24.0 + 1.0;
            case VP, SeniorAssociate ->  20.0;
            default -> 10;
        };
    }

    /**
     * Compilation failure case.
     */
    /*private static double getYearlyBonus_expression_arrow_enum_compilationerror(Designation designation) {
        return switch(designation){
            case MD -> 50.0 + 1.0;
            case ED -> 24.0 + 1.0;

        };
    }*/


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
            case "Manager":
                throw new RuntimeException("I dont know what is Manager designation");
            default: {
                bonus = 10.0;
                break;
            }
        }
        return bonus;
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
            case "Manager" ->
                throw new RuntimeException("I dont know what is Manager designation");
            default -> {
                bonus = 10.0;
            }
        }
        return bonus;
    }


    private static double getYearlyBonus_expresion_arrowSyntax(String designation) {
        double bonus = switch (designation) {
            case "MD" -> 50.0;
            case "ED" -> {
                double temp = 1.;
                break 25.0 + temp;
            }
            case "Manager" -> throw new RuntimeException("I dont know what is Manager designation");
            default -> {
                break 10.0;
            }
        };
        return bonus;
    }


    /**
     * 1.   Only change is converting arrow into :
     */

    private static double getYearlyBonus_expresion_colonSyntax(String designation) {
        double bonus = switch (designation) {
            case "MD" : break 50.0;
            case "ED" : {
                double temp = 1.;
                break 25.0 + temp;
            }
            case "Manager" : throw new RuntimeException("I dont know what is Manager designation");
            default : {
                break 10.0;
            }
        };
        return bonus;
    }



    /**
     * 1.   This is switch statement using arrow syntax, JDK12 specific.
     * 2.   Code right to arrow -> can be expression, a block, or a throw statement.This is example of block.
     * 3.   This is example of switch statement
     * 4.   Block effectively provides scoping as well, we can define variable in block scope.
     */
    private static double getYearlyBonusExperienceMatters_statement_arrowSyntax(Employee employee) {
        double bonus;
        switch (employee.getDesignation()) {
            case "MD" -> {
                double experienceBasedBonus = employee.getExperienceYears() * .5;
                bonus = 70.0 + experienceBasedBonus;
            }
            case "ED" -> {
                double experienceBasedBonus = employee.getExperienceYears() * .4;
                bonus = 50.0 + experienceBasedBonus;
            }
            case "VP", "SeniorAssociate" -> {
                double experienceBasedBonus = employee.getExperienceYears() * .3;
                bonus = 40.0 + experienceBasedBonus;
            }
            default -> {
                double experienceBasedBonus = employee.getExperienceYears() * .2;
                bonus = 30.0 + experienceBasedBonus;
            }
        }
        return bonus;
    }


    private static double getYearlyBonusExperienceMatters_statement_arrowSyntax_convert_into_Expression(Employee employee) {
        double bonus =
                switch (employee.getDesignation()) {
                    case "MD" -> {
                        double experienceBasedBonus = employee.getExperienceYears() * .5;
                        break 70.0 + experienceBasedBonus;
                    }
                    case "ED" -> {
                        double experienceBasedBonus = employee.getExperienceYears() * .4;
                        break 50.0 + experienceBasedBonus;
                    }
                    case "VP", "SeniorAssociate" -> {
                        double experienceBasedBonus = employee.getExperienceYears() * .3;
                        break 40.0 + experienceBasedBonus;
                    }
                    default -> {
                        double experienceBasedBonus = employee.getExperienceYears() * .2;
                        break 30.0 + experienceBasedBonus;
                    }
                };
        return bonus;
    }


    /**
     * 1.   This is switch expression using arrow syntax, DK12 specific.
     * 2.   Arrow (->) points to returned value.
     * 3.   Code right to arrow -> can be expression, a block, or a throw statement. This is example of switch expression
     *      where right to -> we have block and expression and Exception all 3 cases.
     *      In case 40.0 looks confusing for an expression you can write 40.0 + 0.0 it may make sense now.
     * 4.   Using arrow syntax (->) we get assurance of no fallthrough.
     * 5.   Multiple command separated labels supported like here:   case "VP", "SeniorAssociate" -> 40;
     */
    private static double getYearlyBonus_expression_arrowSyntax(String designation) {
        return switch (designation) {
            case "MD" -> 70.0;
            case "ED" -> 50.0;
            case "VP", "SeniorAssociate" -> {
                System.out.println("We printed inside block");
                break 40.0;
            }
            case "Manager" -> throw new RuntimeException("I dont know what is Manager designation");
            default -> 30.0;
        };
    }

    /**
     * 1.   This is Switch expression using old colon syntax, JDK12 specific.
     * 2.   Here we are using block {} in case of VP and traditional approach in case of SeniorAssociate which is not block,
     *      Block effectively provides scoping as well, we can define variable in block scope.
     * 3.   We have to use break in all cases, if omitted we get compilation error which makes in fallthrough safe.
     */
    private static double getYearlyBonus_expression_colonSyntax(String designation) {
        return switch (designation) {
            case "MD":
                break 70.0;
            case "ED":
                break 50.0;
            case "VP": {
                System.out.println("We printed inside VP block");
                break 40.0;
            }
            case "SeniorAssociate":
                System.out.println("We printed inside SeniorAssociate block");
                break 40.0;
            case "Manager":
                throw new RuntimeException("I dont know what is Manager designation");
            default:
                break 30.0;
        };
    }


    /**
     * 1.   This is example of Old Switch statement using break, works in JDK8 as well.
     * 2.   It looks similar to switch expression but it is not, we return values explicitly.
     *      Since Old Switch statement does not return value in case of below code we are explicitly returning value.
     * 3.   It looks similar to switch expression but this is return statement not switch expression.
     */
    private static double getYearlyBonus_statement_colonSyntax_looksLikeExpression(String designation) {
        switch (designation) {
            case "MD":
                return 50.0;
            case "ED":
                return 25.0;
            default:
                return 10.0;
        }
    }

}

