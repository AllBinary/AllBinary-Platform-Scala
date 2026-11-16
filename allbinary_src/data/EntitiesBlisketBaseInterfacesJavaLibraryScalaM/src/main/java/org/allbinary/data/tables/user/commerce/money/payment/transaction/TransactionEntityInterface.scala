/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.data.tables.user.commerce.money.payment.transaction

import _root_.org.allbinary.business.user.commerce.money.payment.gateway.transaction.PaymentTransactionInterface
import _root_.org.allbinary.data.tables.BasicDataTableInterface

trait TransactionEntityInterface extends BasicDataTableInterface {

    //public PaymentTransactionInterface getTransactionInterface(String storeName, String orderNumber);
    def remove(userName : String, orderNumber : String) : Unit

    def add(userName : String, orderNumber : String, paymentTransactionInterface : PaymentTransactionInterface) : Unit

}


