/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.business.user.commerce.money.payment.types


class TenderTypeFactory {
    import _root_.org.allbinary.business.user.commerce.money.payment.types.TenderTypeFactory.{*}

    val CREDITCARD : TenderType = new TenderType("Credit Card")

    val CHECK : TenderType = new TenderType("Check")

    val ACH : TenderType = new TenderType("Ach")

}

object TenderTypeFactory {
    private val instance : TenderTypeFactory = new TenderTypeFactory()

    def getInstance() : TenderTypeFactory = {
        return TenderTypeFactory.instance
    }

}


