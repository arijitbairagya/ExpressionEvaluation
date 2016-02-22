/*
 * Copyright (c) 2016 General Electric Company. All rights reserved.
 *
 * The copyright to the computer software herein is the property of
 * General Electric Company. The software may be used and/or copied only
 * with the written permission of General Electric Company or in accordance
 * with the terms and conditions stipulated in the agreement/contract
 * under which the software has been supplied.
 */
 
package com.test;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

import org.nfunk.jep.JEP;

import com.test.bo.Item;
import com.test.bo.Order;

/**
 * 
 * @author 385220
 */
@SuppressWarnings(
{
        "javadoc", "nls"
})
public class FormulaEval
{

    /**
     * @param args
     */

    public static void main(String[] args)
    {

        Map<String, Double> fpprParamMap = new HashMap<String, Double>();
        fpprParamMap.put("vat", 14.6);
        fpprParamMap.put("profit", 5.0);

        String purchaseCostIncVat = " purchaseCost * (1 + vat/100)";
        String mrp = " purchaseCostIncVat + purchaseCostIncVat * profit";

        Map<String, String> frmlResultDescMap = new HashMap<String, String>(); // formula should be ordered
        frmlResultDescMap.put("purchaseCostIncVat", purchaseCostIncVat);
        frmlResultDescMap.put("mrp", mrp);

        JEP eveluator = new JEP();
        eveluator.addStandardFunctions();

        // add fppr parameters from map
        addEvalParameters(fpprParamMap, eveluator);


        // TODO this object will be domain model
        Order order = new Order();
        Item item = new Item();
        item.setPurchaseCost(100);
        order.getItemList().add(item);

        // add variables from class like purchase cost
        Map<String, Double> classLvlPropVals = getPropertyParameterMap(item);
        System.out.println("Class Level params -" + classLvlPropVals);
        addEvalParameters(classLvlPropVals, eveluator);

        // parse expression
        for (String outPutParam : frmlResultDescMap.keySet())
        {
            Map<String, Double> resultParamMap = new HashMap<String, Double>();
            eveluator.parseExpression(frmlResultDescMap.get(outPutParam));
            
            resultParamMap.put(outPutParam, eveluator.getValue());
            addEvalParameters(resultParamMap, eveluator);
        }
        eveluator.parseExpression(purchaseCostIncVat);

        // get the output
        System.out.println("Error - " + eveluator.getErrorInfo());
        System.out.println("Value - "+ eveluator.getValue());
    }

    /**
     * @param fpprParamMap
     * @param eveluator
     */
    private static void addEvalParameters(Map<String, Double> fpprParamMap, JEP eveluator)
    {
        for (String param : fpprParamMap.keySet())
        {
            eveluator.addVariable(param, fpprParamMap.get(param));
        }
    }

    /**
     * @return
     */
    private static Map<String, Double> getPropertyParameterMap(Object obj)
    {

        Map<String, Double> classParamsMap = new HashMap<String, Double>();

        Class<?> c = obj.getClass();
        Field[] declaredFields = c.getDeclaredFields();

        try
        {
            for (Field field : declaredFields)
            {
                field.setAccessible(true);
                classParamsMap.put(field.getName(), Double.valueOf(field.get(obj).toString()));
            }
        }
        catch (Exception ex)
        {
            System.out.println(ex);
        }

        return classParamsMap;
    }

}
