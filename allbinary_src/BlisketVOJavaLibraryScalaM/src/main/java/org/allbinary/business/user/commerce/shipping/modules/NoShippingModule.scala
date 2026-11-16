/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.business.user.commerce.shipping.modules

import _root_.org.allbinary.business.user.commerce.inventory.order.OrderInterface
import _root_.org.allbinary.business.user.commerce.money.Money
import _root_.org.allbinary.string.CommonStrings

class NoShippingModule() extends ShippingInterface {

    val commonStrings : CommonStrings = CommonStrings.getInstance()

    private val name : String = "No Shipping"

    private val description : String = "This shipping method is for items that are not shipped."

    def getCost(order : OrderInterface) : Money = {
        return new Money()
    }

    def getDescription() : String = {
        return this.description
    }

    def getName() : String = {
        return this.name
    }

}


