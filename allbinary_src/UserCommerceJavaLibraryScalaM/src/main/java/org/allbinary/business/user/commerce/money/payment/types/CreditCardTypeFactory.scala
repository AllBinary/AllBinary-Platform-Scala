/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.business.user.commerce.money.payment.types


class CreditCardTypeFactory {
    import _root_.org.allbinary.business.user.commerce.money.payment.types.CreditCardTypeFactory.{*}

    val VISA : CreditCardType = new CreditCardType("Visa")

    val MASTERCARD : CreditCardType = new CreditCardType("MasterCard")

    val DISCOVER : CreditCardType = new CreditCardType("Discover")

    val AMERICANEXPRESS : CreditCardType = new CreditCardType("AMX")

}

object CreditCardTypeFactory {
    private val instance : CreditCardTypeFactory = new CreditCardTypeFactory()

    def getInstance() : CreditCardTypeFactory = {
        return CreditCardTypeFactory.instance
    }

}


