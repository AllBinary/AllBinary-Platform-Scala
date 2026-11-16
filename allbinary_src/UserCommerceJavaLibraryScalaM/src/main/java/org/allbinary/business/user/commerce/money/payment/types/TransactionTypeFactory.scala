/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.business.user.commerce.money.payment.types


class TransactionTypeFactory {
    import _root_.org.allbinary.business.user.commerce.money.payment.types.TransactionTypeFactory.{*}

    val SALE : TransactionType = new TransactionType("Sale")

    val CREDIT : TransactionType = new TransactionType("Credit")

    val AUTHORIZATION : TransactionType = new TransactionType("Authorization")

    val DELAYEDCAPTURE : TransactionType = new TransactionType("Delayed Capture")

    val VOID : TransactionType = new TransactionType("Void")

    val INQUIRY : TransactionType = new TransactionType("Inquiry")

}

object TransactionTypeFactory {
    private val instance : TransactionTypeFactory = new TransactionTypeFactory()

    def getInstance() : TransactionTypeFactory = {
        return TransactionTypeFactory.instance
    }

}


