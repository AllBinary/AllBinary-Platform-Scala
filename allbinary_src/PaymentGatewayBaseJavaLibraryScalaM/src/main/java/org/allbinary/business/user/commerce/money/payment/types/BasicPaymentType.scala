/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.business.user.commerce.money.payment.types

import _root_.java.util.HashMap
import _root_.org.allbinary.util.BasicArrayList
import _root_.org.allbinary.util.BasicArrayListD
import _root_.org.allbinary.business.user.commerce.money.payment.gateway.PaymentGatewayData
import _root_.org.allbinary.business.user.commerce.money.payment.gateway.PaymentGatewayInterfaceFactoryInterface
import _root_.org.allbinary.business.user.commerce.money.payment.gateway.modules.gateway.PaymentGatewayDomNodeFactoryInterface
import _root_.org.allbinary.logic.StdUtil
import _root_.org.allbinary.logic.io.path.AbPathData
import _root_.org.allbinary.logic.string.regex.replace.Replace
import _root_.org.allbinary.string.CommonSeps

class BasicPaymentType private () {

    private var name : String = null

    private var value : String = null

    private var paymentGatewayInterfaceFactoryInterface : PaymentGatewayInterfaceFactoryInterface = null

    private var paymentGatewayDomNodeFactoryInterface : PaymentGatewayDomNodeFactoryInterface = null

    def this(paymentMethod : String, paymentGatewayInterfaceFactoryInterface : PaymentGatewayInterfaceFactoryInterface, paymentGatewayDomNodeFactoryInterface : PaymentGatewayDomNodeFactoryInterface) = {
        this()
        this.init(paymentMethod)
        this.paymentGatewayInterfaceFactoryInterface = paymentGatewayInterfaceFactoryInterface
        this.paymentGatewayDomNodeFactoryInterface = paymentGatewayDomNodeFactoryInterface
    }

    def this(paymentMethod : String) = {
        this()
        this.init(paymentMethod)
    }

    private def init(paymentMethod : String) : Unit = {
        var hashMap : HashMap[Object, Object] = StdUtil.getInstance().createHashMap().asInstanceOf[HashMap[Object, Object]]
        val UNDERSCORE : String = "_"
        hashMap.put(CommonSeps.getInstance().SPACE, UNDERSCORE)
        hashMap.put(AbPathData.getInstance().EXTENSION_SEP, UNDERSCORE)
        hashMap.put("-", UNDERSCORE)
        var replace : Replace = new Replace(hashMap)
        this.name = replace.all(paymentMethod)
        this.value = paymentMethod
        BasicPaymentTypeUtil.getInstance().add(this)
    }

    def getName() : String = {
        return this.name
    }

    def getValue() : String = {
        return this.value
    }

    def getPaymentGatewayInterfaceFactoryInterface() : PaymentGatewayInterfaceFactoryInterface = {
        if (this.paymentGatewayInterfaceFactoryInterface == null) {
            throw new Exception("PaymentGatewayInterfaceFactoryInterface is Null")
        }
        return this.paymentGatewayInterfaceFactoryInterface
    }

    def getPaymentGatewayDomNodeFactoryInterface() : PaymentGatewayDomNodeFactoryInterface = {
        if (this.paymentGatewayDomNodeFactoryInterface == null) {
            throw new Exception("PaymentGatewayDomNodeFactoryInterface is Null")
        }
        return this.paymentGatewayDomNodeFactoryInterface
    }

    def getKey() : Object = {
        return this.getName()
    }

    def toVector() : BasicArrayList = {
        var vector : BasicArrayList = new BasicArrayListD()
        vector.add(this.name)
        vector.add(this.value)
        return vector
    }

    def toHashMap() : HashMap[Object, Object] = {
        var hashMap : HashMap[Object, Object] = StdUtil.getInstance().createHashMap().asInstanceOf[HashMap[Object, Object]]
        hashMap.put(PaymentGatewayData.NAME.toString(), this.name)
        hashMap.put(PaymentGatewayData.VALUE.toString(), this.value)
        return hashMap
    }

    override def toString() : String = {
        return this.name
    }

}


