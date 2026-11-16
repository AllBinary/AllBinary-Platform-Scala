/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.business.user.commerce.shipping.modules

import _root_.org.allbinary.business.user.commerce.inventory.order.OrderInterface
import _root_.org.allbinary.business.user.commerce.money.Money

class FedExShippingModule() extends ShippingInterface {

    private val name : String = "FedEx"

    private val description : String = "Fast Mail"

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


