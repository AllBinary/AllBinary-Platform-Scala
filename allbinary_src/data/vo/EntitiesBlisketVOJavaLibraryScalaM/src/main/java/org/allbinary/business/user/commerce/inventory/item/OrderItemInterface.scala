/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.business.user.commerce.inventory.item

import _root_.org.allbinary.business.user.address.StreetAddress

trait OrderItemInterface extends ItemInterface {

    def setGroup(value : String) : Unit

    def setTax(value : String) : Unit

    def setShippingType(value : String) : Unit

    def setShippingCost(value : String) : Unit

    def setShippingAddress(value : StreetAddress) : Unit

    def setSpecial(value : String) : Unit

    def getGroup() : String

    def getTax() : String

    def getShippingType() : String

    def getShippingCost() : String

    def getShippingAddress() : StreetAddress

    def getSpecial() : String

}


