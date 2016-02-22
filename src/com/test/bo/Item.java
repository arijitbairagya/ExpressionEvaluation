/*
 * Copyright (c) 2016 General Electric Company. All rights reserved.
 *
 * The copyright to the computer software herein is the property of
 * General Electric Company. The software may be used and/or copied only
 * with the written permission of General Electric Company or in accordance
 * with the terms and conditions stipulated in the agreement/contract
 * under which the software has been supplied.
 */
 
package com.test.bo;

/**
 * The Class Item.
 *
 * @author 385220
 */
public class Item
{

    /** The count. */
    private int    count = 0;

    /** The price. */
    private double price = 0.0;

    /** The purchase cost. */
    private double purchaseCost = 0.0;

    /**
     * Gets the count.
     *
     * @return the count
     */
    public int getCount()
    {
        return this.count;
    }

    /**
     * Sets the count.
     *
     * @param count the new count
     */
    public void setCount(int count)
    {
        this.count = count;
    }

    /**
     * Gets the price.
     *
     * @return the price
     */
    public double getPrice()
    {
        return this.price;
    }

    /**
     * Sets the price.
     *
     * @param price the new price
     */
    public void setPrice(double price)
    {
        this.price = price;
    }

    /**
     * Gets the purchase cost.
     *
     * @return the purchase cost
     */
    public double getPurchaseCost()
    {
        return this.purchaseCost;
    }

    /**
     * Sets the purchase cost.
     *
     * @param purchaseCost the new purchase cost
     */
    public void setPurchaseCost(double purchaseCost)
    {
        this.purchaseCost = purchaseCost;
    }

}
