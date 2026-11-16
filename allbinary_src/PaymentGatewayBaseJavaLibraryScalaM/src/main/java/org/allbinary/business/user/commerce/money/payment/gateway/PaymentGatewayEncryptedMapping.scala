/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.business.user.commerce.money.payment.gateway

import _root_.java.util.HashMap
import _root_.org.allbinary.util.BasicArrayList
import _root_.org.allbinary.util.BasicArrayListD
import _root_.org.allbinary.data.tables.TableMappingInterface

class PaymentGatewayEncryptedMapping(param_paymentGatewayInterface : PaymentGatewayInterface) extends TableMappingInterface {

    private var paymentGatewayInterface : PaymentGatewayInterface = null

    //Constructor
    {
        val paymentGatewayInterface : PaymentGatewayInterface = param_paymentGatewayInterface
        this.paymentGatewayInterface = paymentGatewayInterface
    }

    //This is used to update db entries
    def toHashMap() : HashMap[Object, Object] = {
        return this.paymentGatewayInterface.toHashMap(true)
    }

    //This is used for db updates
    def toVector() : BasicArrayList = {
        return this.paymentGatewayInterface.toVector(true)
    }

    def getKey() : Object = {
        return this.paymentGatewayInterface.getKey().asInstanceOf[Object]
    }

}


