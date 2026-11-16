/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.business.user.commerce.inventory.order

import _root_.org.allbinary.business.user.commerce.inventory.basket.BasketInterface

trait OrderInterface {

    //public void setBasket(BasketInterface basket);
    def setShippingMethod(shippingType : String) : Unit

    def setPaymentMethod(value : String) : Unit

    def setSpecial(special : String) : Unit

    def setStoreName(value : String) : Unit

    def setUserComments(value : String) : Unit

    def setUserCancelComments(value : String) : Unit

    def setStoreComments(value : String) : Unit

    def setStoreCancelComments(value : String) : Unit

    def getBasket() : BasketInterface

    def getShippingMethod() : String

    def getPaymentMethod() : String

    def getSpecial() : String

    def getId() : String

    def getStoreName() : String

    def getUserComments() : String

    def getUserCancelComments() : String

    def getStoreComments() : String

    def getStoreCancelComments() : String

}


