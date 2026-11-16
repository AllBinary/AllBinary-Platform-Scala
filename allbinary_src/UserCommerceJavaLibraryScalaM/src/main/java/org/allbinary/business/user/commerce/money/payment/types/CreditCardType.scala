/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.business.user.commerce.money.payment.types


class CreditCardType(param_cardType : String) {
    import _root_.org.allbinary.business.user.commerce.money.payment.types.CreditCardType.{MAXLEN as _, *}
    def MAXLEN : Int = _root_.org.allbinary.business.user.commerce.money.payment.types.CreditCardType.MAXLEN

    private var name : String = null

    //Constructor
    {
        val cardType : String = param_cardType
        this.name = cardType
    }

    override def toString() : String = {
        return this.name
    }

}

object CreditCardType {
    val MAXLEN : Int = 19

}


