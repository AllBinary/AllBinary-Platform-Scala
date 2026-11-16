/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.business.user.commerce.shipping

import _root_.org.allbinary.util.BasicArrayList
import _root_.org.allbinary.util.BasicArrayListD
import _root_.org.allbinary.business.context.modules.storefront.StoreFrontInterface
import _root_.org.allbinary.business.user.commerce.shipping.modules.ShippingInterface
import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.logic.system.security.licensing.AbeClientInformationInterface
import _root_.org.allbinary.string.CommonStrings

class ShippingMethods(param_abeClientInformation : AbeClientInformationInterface, param_storeFrontInterface : StoreFrontInterface) extends ShippingMethodsInterface {

    val logUtil : LogUtil = LogUtil.getInstance()

    val commonStrings : CommonStrings = CommonStrings.getInstance()

    private var shippingVector : BasicArrayList = null

    private var defaultShippingMethodInterface : ShippingInterface = null

    //Constructor
    {
        val abeClientInformation : AbeClientInformationInterface = param_abeClientInformation
        val storeFrontInterface : StoreFrontInterface = param_storeFrontInterface
        this.defaultShippingMethodInterface = new ShippingMethodsFactory(abeClientInformation, storeFrontInterface).getDefaultInstance()
        this.shippingVector = new ShippingMethodsFactory(abeClientInformation, storeFrontInterface).getInstance()
    }

    def get() : BasicArrayList = {
        return this.shippingVector
    }

    def getShippingInterface(name : String) : ShippingInterface = {
        var shipping : ShippingInterface = null
        val size : Int = this.shippingVector.size()

        {
            var index : Int = 0
            while (index < size) {
                shipping = this.shippingVector.get(index).asInstanceOf[ShippingInterface]
                if (name.compareTo(shipping.getName()) == 0) {
                    return shipping
                }
                index += 1
            }
        }
        var error : String = "Error Finding Shipping: " + name
        if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().SHIPPINGERROR)) {
            this.logUtil.putF(this.commonStrings.EXCEPTION, this, "getShippingInterface(String name)")
        }
        throw new Exception(error)
    }

    def getDefault() : ShippingInterface = {
        return this.defaultShippingMethodInterface
    }

}


