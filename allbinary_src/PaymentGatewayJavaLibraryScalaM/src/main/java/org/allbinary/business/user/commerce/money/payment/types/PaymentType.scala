/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.business.user.commerce.money.payment.types

import _root_.java.util.HashMap
import _root_.org.allbinary.util.BasicArrayList
import _root_.org.allbinary.util.BasicArrayListD
import _root_.org.allbinary.business.user.commerce.money.payment.gateway.PaymentGatewayData
import _root_.org.allbinary.business.user.commerce.money.payment.gateway.processor.PaymentProcessorInterfaceFactoryInterface
import _root_.org.allbinary.business.user.commerce.money.payment.gateway.transaction.PaymentTransactionInterfaceFactoryInterface
import _root_.org.allbinary.logic.StdUtil

class PaymentType private () {

    private var basicPaymentType : BasicPaymentType = null

    private var paymentTransactionInterfaceFactoryInterface : PaymentTransactionInterfaceFactoryInterface = null

    private var paymentProcessorInterfaceFactoryInterface : PaymentProcessorInterfaceFactoryInterface = null

    def this(basicPaymentType : BasicPaymentType, paymentTransactionInterfaceFactoryInterface : PaymentTransactionInterfaceFactoryInterface, paymentProcessorInterfaceFactoryInterface : PaymentProcessorInterfaceFactoryInterface) = {
        this()
        this.basicPaymentType = basicPaymentType
        this.paymentTransactionInterfaceFactoryInterface = paymentTransactionInterfaceFactoryInterface
        this.paymentProcessorInterfaceFactoryInterface = paymentProcessorInterfaceFactoryInterface
        PaymentTypeUtil.getInstance().add(this)
    }

    def this(basicPaymentType : BasicPaymentType) = {
        this()
        this.basicPaymentType = basicPaymentType
        this.paymentTransactionInterfaceFactoryInterface = null
        this.paymentProcessorInterfaceFactoryInterface = null
        PaymentTypeUtil.getInstance().add(this)
    }

    def getPaymentTransactionInterfaceFactoryInterface() : PaymentTransactionInterfaceFactoryInterface = {
        if (this.paymentTransactionInterfaceFactoryInterface == null) {
            throw new Exception("PaymentTransactionInterfaceFactoryInterface is Null")
        }
        return this.paymentTransactionInterfaceFactoryInterface
    }

    def getPaymentProcessorInterfaceFactoryInterface() : PaymentProcessorInterfaceFactoryInterface = {
        if (this.paymentProcessorInterfaceFactoryInterface == null) {
            throw new Exception("PaymentProcessorInterfaceFactoryInterface is Null")
        }
        return this.paymentProcessorInterfaceFactoryInterface
    }

    def toVector() : BasicArrayList = {
        var vector : BasicArrayList = new BasicArrayListD()
        vector.addAllList(this.getBasicPaymentType().toVector())
        if (this.paymentTransactionInterfaceFactoryInterface != null) {
            vector.add(this.paymentTransactionInterfaceFactoryInterface.getClass().getName())
        }
        if (this.paymentProcessorInterfaceFactoryInterface != null) {
            vector.add(this.paymentProcessorInterfaceFactoryInterface.getClass().getName())
        }
        return vector
    }

    def toHashMap() : HashMap[Object, Object] = {
        var hashMap : HashMap[Object, Object] = StdUtil.getInstance().createHashMap().asInstanceOf[HashMap[Object, Object]]
        hashMap.putAll(this.getBasicPaymentType().toHashMap())
        if (this.paymentTransactionInterfaceFactoryInterface != null) {
            hashMap.put(PaymentGatewayData.PAYMENTTRANSACTIONINTERFACEFACTORYINTERFACE.toString(), this.paymentTransactionInterfaceFactoryInterface.getClass().getName())
        }
        if (this.paymentProcessorInterfaceFactoryInterface != null) {
            hashMap.put(PaymentGatewayData.PAYMENTPROCESSORINTERFACEFACTORYINTERFACE.toString(), this.paymentProcessorInterfaceFactoryInterface.getClass().getName())
        }
        return hashMap
    }

    def getBasicPaymentType() : BasicPaymentType = {
        return this.basicPaymentType
    }

}


