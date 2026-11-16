/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.business.user.commerce.shipping.modules

import _root_.org.allbinary.business.user.commerce.inventory.basket.BasketInterface
import _root_.org.allbinary.business.user.commerce.inventory.order.OrderInterface
import _root_.org.allbinary.business.user.commerce.money.Money
import _root_.org.allbinary.string.CommonStrings

class BasicWeightShippingModule() extends ShippingInterface {

    val commonStrings : CommonStrings = CommonStrings.getInstance()

    private val name : String = "Basic Shipping (5 to 7 working days)"

    private val description : String = "We will soon provide a variety of shipping methods."

    def getCost(order : OrderInterface) : Money = {
        var basket : BasketInterface = order.getBasket()
        var money : Money = new Money()
        money.add(basket.getTotalWeight())
        money.multiply(1)
        money.add("3.50")
        return money
    }

    def getDescription() : String = {
        return this.description
    }

    def getName() : String = {
        return this.name
    }

}


