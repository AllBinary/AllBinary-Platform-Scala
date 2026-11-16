/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.data.tables.user.commerce.money.payment.transaction

import _root_.org.allbinary.business.user.commerce.money.payment.gateway.transaction.TransactionResultInterface
import _root_.org.allbinary.data.tables.BasicDataTableInterface

trait TransactionResultEntityInterface extends BasicDataTableInterface {

    def getTransactionResultInterface(orderNumber : String) : TransactionResultInterface

    def remove(userName : String, orderNumber : String) : Unit

    def add(userName : String, orderNumber : String, resultInterface : TransactionResultInterface) : Unit

}


