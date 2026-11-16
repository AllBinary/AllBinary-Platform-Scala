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
import _root_.org.allbinary.data.tables.user.address.shipping.ShippingAddressesEntity
import _root_.org.allbinary.logic.control.validate.ValidationComponentInterface
import _root_.org.allbinary.logic.visual.transform.info.TransformInfoInterface
import _root_.org.w3c.dom.Document
import _root_.org.w3c.dom.Node

class UpdateTaxValidationView(param_transformInfoInterface : TransformInfoInterface) extends ShippingAddressView(param_transformInfoInterface) with ValidationComponentInterface {

    //Constructor
    {
        val transformInfoInterface : TransformInfoInterface = param_transformInfoInterface
    }

    def isValid() : _root_.java.lang.Boolean = {
        this.streetAddress = new StreetAddress(this.getRequest())
        var storeFrontInterface : StoreFrontInterface = StoreFrontFactory.getInstance(this.getTransformInfoInterface().getStoreName())
        if (TaxFactory.getInstance().getInstance(this.abeClientInformation, storeFrontInterface).isValid(this.streetAddress, storeFrontInterface) == _root_.java.lang.Boolean.FALSE) {
            return _root_.java.lang.Boolean.FALSE
        }
        var billingAddressesEntity : ShippingAddressesEntity = new ShippingAddressesEntity(this.getWeblisketSession().getUserName())
        var streetAddressList : BasicArrayList = billingAddressesEntity.get()
        if (streetAddressList == null) {
            return _root_.java.lang.Boolean.FALSE
        }
        var count : Int = 0
        val size : Int = streetAddressList.size()

        {
            var index : Int = 0
            while (index < size) {
                var aStreetAddress : StreetAddress = streetAddressList.get(index).asInstanceOf[StreetAddress]
                if (aStreetAddress.getName().compareTo(ShippingAddressData.TAX) == 0) {
                    count += 1
                }
                index += 1
            }
        }
        if (count != 1) {
            return _root_.java.lang.Boolean.FALSE
        }
        return _root_.java.lang.Boolean.TRUE
    }

    def validationInfo() : String = {
        return "Unable to update tax location."
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


