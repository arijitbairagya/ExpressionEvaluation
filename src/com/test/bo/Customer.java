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

import java.util.ArrayList;
import java.util.List;

/**
 * The Class Customer.
 *
 * @author 385220
 */
public class Customer
{

    /** The orders. */
    private List<Order> orders = new ArrayList<Order>();

    /**
     * Gets the orders.
     *
     * @return the orders
     */
    public List<Order> getOrders()
    {
        return this.orders;
    }

    /**
     * Sets the orders.
     *
     * @param orders the new orders
     */
    public void setOrders(List<Order> orders)
    {
        this.orders = orders;
    }

}
