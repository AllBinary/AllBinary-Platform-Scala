/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.business.user.commerce.inventory.basket

import _root_.java.util.HashMap
import _root_.java.util.Set
import _root_.org.allbinary.business.user.commerce.money.Money
import _root_.org.allbinary.business.user.commerce.money.MoneyException

trait BasketInterface {

    def addItem(id : String, num : String) : Unit

    def removeItem(id : String) : Unit

    def adjustItem(id : String, num : String) : Unit

    def getTotalWeight() : String

    def getNumberOfItems() : Integer

    def getIds() : Set[Object]

    def getItems() : HashMap[Object, Object]

    def getNumberOf(product : String) : Integer

    def getSubTotal() : Money

}


