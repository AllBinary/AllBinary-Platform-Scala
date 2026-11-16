/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.data.tables.user.commerce.money.payment

import _root_.org.allbinary.util.BasicArrayList
import _root_.org.allbinary.util.BasicArrayListD
import _root_.org.allbinary.business.user.commerce.money.payment.PaymentInterface
import _root_.org.allbinary.data.tables.BasicDataTableInterface

trait PaymentEntityInterface extends BasicDataTableInterface {

    def getLastId(userName : String) : String

    def setDefault(userName : String, index : Integer) : Unit

    def getDefault(userName : String) : PaymentInterface

    def get(userName : String) : BasicArrayList

    def add(userName : String, paymentInterface : PaymentInterface) : Unit

    def remove(userName : String, index : Integer) : Unit

    def insert(values : BasicArrayList) : Unit

}


