/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package views.generic.address.shipping

import _root_.org.allbinary.util.BasicArrayList
import _root_.org.allbinary.util.BasicArrayListD
import _root_.org.allbinary.business.context.modules.storefront.StoreFrontFactory
import _root_.org.allbinary.business.context.modules.storefront.StoreFrontInterface
import _root_.org.allbinary.business.user.address.ShippingAddressData
import _root_.org.allbinary.business.user.address.StreetAddress
import _root_.org.allbinary.business.user.commerce.money.tax.TaxFactory
import _root_.org.allbinary.business.user.commerce.money.tax.modules.TaxModuleInterface
import _root_.org.allbinary.data.tables.user.address.shipping.ShippingAddressesEntity
import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.logic.control.validate.ValidationComponentInterface
import _root_.org.allbinary.logic.string.StringMaker
import _root_.org.allbinary.logic.visual.transform.info.TransformInfoInterface
import _root_.org.w3c.dom.Document
import _root_.org.w3c.dom.Node

class AddTaxValidationView(param_transformInfoInterface : TransformInfoInterface) extends ShippingAddressView(param_transformInfoInterface) with ValidationComponentInterface {

    val logUtil_AddTaxValidationView : LogUtil = LogUtil.getInstance()

    //Constructor
    {
        val transformInfoInterface : TransformInfoInterface = param_transformInfoInterface
    }

    def isValid() : _root_.java.lang.Boolean = {
        try {
            this.streetAddress = new StreetAddress(this.getRequest())
            var storeFrontInterface : StoreFrontInterface = StoreFrontFactory.getInstance(this.getTransformInfoInterface().getStoreName())
            var taxInterface : TaxModuleInterface = TaxFactory.getInstance().getInstance(this.abeClientInformation, storeFrontInterface)
            if (taxInterface == null) {
                return _root_.java.lang.Boolean.FALSE
            }
            if (taxInterface.isValid(this.streetAddress, storeFrontInterface) == _root_.java.lang.Boolean.FALSE) {
                return _root_.java.lang.Boolean.FALSE
            }
            var billingAddressesEntity : ShippingAddressesEntity = new ShippingAddressesEntity(this.getWeblisketSession().getUserName())
            //make sure a tax address does not exist
            var streetAddressList : BasicArrayList = billingAddressesEntity.get()
            if (streetAddressList == null) {
                return _root_.java.lang.Boolean.FALSE
            }
            val size : Int = streetAddressList.size()

            {
                var index : Int = 0
                while (index < size) {
                    var aStreetAddress : StreetAddress = streetAddressList.get(index).asInstanceOf[StreetAddress]
                    if (aStreetAddress.getName().compareTo(ShippingAddressData.TAX) == 0) {
                        return _root_.java.lang.Boolean.FALSE
                    }
                    index += 1
                }
            }
            return _root_.java.lang.Boolean.TRUE
        } catch {
            case e : Exception => {
                if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().VIEWERROR)) {
                    this.logUtil_AddTaxValidationView.put("Failed to validate", this, this.commonStrings.IS_VALID, e)
                }
                return _root_.java.lang.Boolean.FALSE
            }
        }
        throw new IllegalStateException()
    }

    def validationInfo() : String = {
        try {
            var stringBuffer : StringMaker = new StringMaker()
            var storeFrontInterface : StoreFrontInterface = StoreFrontFactory.getInstance(this.getTransformInfoInterface().getStoreName())
            var taxInterface : TaxModuleInterface = TaxFactory.getInstance().getInstance(this.abeClientInformation, storeFrontInterface)
            if (taxInterface == null) {
                stringBuffer.append("Unable to Load Tax Component<br/>")
            } else {
                if (taxInterface.isValid(this.streetAddress, storeFrontInterface) == _root_.java.lang.Boolean.FALSE) {
                    stringBuffer.append("Unable to validate address with Tax Component<br/>")
                }
            }
            var billingAddressesEntity : ShippingAddressesEntity = new ShippingAddressesEntity(this.getWeblisketSession().getUserName())
            //make sure a tax address does not exist
            var streetAddressList : BasicArrayList = billingAddressesEntity.get()
            val size : Int = streetAddressList.size()

            {
                var index : Int = 0
                while (index < size) {
                    var aStreetAddress : StreetAddress = streetAddressList.get(index).asInstanceOf[StreetAddress]
                    if (aStreetAddress.getName().compareTo(ShippingAddressData.TAX) == 0) {
                        stringBuffer.append("Not a valid tax location<br/>")
                    }
                    index += 1
                }
            }
            return stringBuffer.toString()
        } catch {
            case e : Exception => {
                if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().VIEWERROR)) {
                    this.logUtil_AddTaxValidationView.put("Failed to create validateInfo", this, "validationInfo()", e)
                }
                return "Error Creating ValidationInfo"
            }
        }
        throw new IllegalStateException()
    }

    def toValidationInfoDoc() : Document = {
        return null
    }

    def toValidationInfoNode(document : Document) : Node = {
        return null
    }

    //Needed for polyglot do not remove
    override def getTransformInfoInterface() : TransformInfoInterface = {
        return super.getTransformInfoInterface()
    }

}


