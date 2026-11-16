/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.business.user.commerce.money.payment.gateway

import _root_.org.allbinary.business.context.modules.storefront.StoreFront
import _root_.org.allbinary.logic.string.StringMaker
import _root_.org.allbinary.string.CommonSeps

class PaymentGatewayPrimaryKey(param_storeName : String, param_gatewayName : String) extends _root_.java.io.Serializable {

    private var storeName : String = null

    private var name : String = null

    //Constructor
    {
        val storeName : String = param_storeName
        val gatewayName : String = param_gatewayName
        this.setStoreName(storeName)
        this.setName(gatewayName)
    }

    def getStoreName() : String = {
        return this.storeName
    }

    def setStoreName(storeName : String) : Unit = {
        this.storeName = storeName
    }

    def getName() : String = {
        return this.name
    }

    def setName(name : String) : Unit = {
        this.name = name
    }

    override def toString() : String = {
        var stringBuffer : StringMaker = new StringMaker()
        stringBuffer.append(classOf[PaymentGatewayPrimaryKey].getName())
        stringBuffer.append(classOf[StoreFront].getName())
        stringBuffer.append(" =")
        stringBuffer.append(this.getStoreName())
        stringBuffer.append(CommonSeps.getInstance().SPACE)
        stringBuffer.append(classOf[PaymentGateway].getName())
        stringBuffer.append("=")
        stringBuffer.append(this.getName())
        return stringBuffer.toString()
    }

}


