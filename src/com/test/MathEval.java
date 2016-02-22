
 
package com.test;

import org.nfunk.jep.JEP;

/**
 * 
 * @author 385220
 */
public class MathEval
{

    /**
     * @param args
     */
    public static void main(String[] args)
    {
        JEP j = new JEP();
        j.addStandardFunctions();

        // add variables
        j.addVariable("a", 10);
        j.addVariable("b", 20);
        j.addVariable("c", 30);

        // xyz = CYIS

        // x = a + b;

        // purchaseCost = Contract.customer.item.purchaseValue

        // double totalCost = Contract.customer.item.purchaseValue + localTax;

        // parse expression
        j.parseExpression("(a+ cost1) * 2 + 30");



        // get the output
        System.out.println("Result -" + j.getValue());


        long startTime = System.currentTimeMillis();

        for (int i = 0; i < 1000; i++)
        {
            j.parseExpression("(a+b+c) * 2 ");
        }

        System.out.println("Time taken for 1000 expressions-" + (System.currentTimeMillis() - startTime));
    }

}
