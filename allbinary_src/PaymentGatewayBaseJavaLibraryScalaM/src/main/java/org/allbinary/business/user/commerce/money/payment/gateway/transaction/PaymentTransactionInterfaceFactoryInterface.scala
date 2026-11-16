/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.business.user.commerce.money.payment.gateway.transaction

import _root_.org.allbinary.business.user.commerce.inventory.order.OrderHistory
import _root_.org.allbinary.business.user.commerce.money.payment.types.TenderType

trait PaymentTransactionInterfaceFactoryInterface {

    def getInstance(orderHistory : OrderHistory) : PaymentTransactionInterface

    def getSaleTransaction(tenderType : TenderType) : PaymentTransactionInterface

    def getCreditTransaction(tenderType : TenderType) : PaymentTransactionInterface

    def getAuthorizationTransaction(tenderType : TenderType) : PaymentTransactionInterface

    def getCaptureDelayedTransaction(tenderType : TenderType) : PaymentTransactionInterface

    def getVoidTransaction(tenderType : TenderType) : PaymentTransactionInterface

    def getInquiryTransaction(tenderType : TenderType) : PaymentTransactionInterface

}


