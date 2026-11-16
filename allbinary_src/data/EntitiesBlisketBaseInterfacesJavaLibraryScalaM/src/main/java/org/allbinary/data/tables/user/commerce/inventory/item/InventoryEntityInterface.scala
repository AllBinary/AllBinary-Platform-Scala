/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.data.tables.user.commerce.inventory.item

import _root_.java.util.HashMap
import _root_.org.allbinary.util.BasicArrayList
import _root_.org.allbinary.util.BasicArrayListD
import _root_.org.allbinary.business.context.modules.storefront.StoreFrontInterface
import _root_.org.allbinary.business.user.commerce.inventory.item.ItemInterface
import _root_.org.allbinary.business.user.commerce.money.MoneyException
import _root_.org.allbinary.data.tables.BasicDataTableInterface

trait InventoryEntityInterface extends BasicDataTableInterface {

    def getItem(id : String) : ItemInterface

    def getItems(storeFrontInterface : StoreFrontInterface) : BasicArrayList

    def getWeight(id : String) : String

    //public BasicArrayList getColumnWhereLike(String columnName,String key,String value);
    def deleteWhere(key : String, value : String) : Unit

    def insert(values : BasicArrayList) : Unit

    def update(updatedValues : HashMap[Object, Object]) : Unit

}


