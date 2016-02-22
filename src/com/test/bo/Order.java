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
 * The Class Order.
 *
 * @author 385220
 */
public class Order
{

    /** The item list. */
    private List<Item> itemList = new ArrayList<Item>();

    /**
     * Gets the item list.
     *
     * @return the item list
     */
    public List<Item> getItemList()
    {
        if ( this.itemList == null ) this.itemList = new ArrayList<Item>();
        return this.itemList;
    }

    /**
     * Sets the item list.
     *
     * @param itemList the new item list
     */
    public void setItemList(List<Item> itemList)
    {
        this.itemList = itemList;
    }
}
