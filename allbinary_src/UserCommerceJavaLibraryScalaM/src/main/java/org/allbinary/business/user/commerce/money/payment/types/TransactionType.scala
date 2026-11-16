/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.business.user.commerce.money.payment.types


class TransactionType(param_name : String) {

    private var name : String = null

    //Constructor
    {
        val name : String = param_name
        this.name = name
    }

    def isEqual(transactionType : TransactionType) : Boolean = {
        if (this.toString().compareTo(transactionType.toString()) == 0) {
            return true
        } else {
            return false
        }
        throw new IllegalStateException()
    }

    override def toString() : String = {
        return this.name
    }

}


