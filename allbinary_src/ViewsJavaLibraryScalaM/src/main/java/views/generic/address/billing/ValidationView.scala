/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package views.generic.address.billing

import _root_.org.allbinary.data.tables.user.address.billing.BillingAddressesEntity
import _root_.org.allbinary.logic.control.validate.ValidationComponentInterface
import _root_.org.allbinary.logic.visual.transform.info.TransformInfoInterface
import _root_.org.w3c.dom.Document
import _root_.org.w3c.dom.Node

class ValidationView(param_transformInfoInterface : TransformInfoInterface) extends BillingAddressesView(param_transformInfoInterface) with ValidationComponentInterface {

    //Constructor
    {
        val transformInfoInterface : TransformInfoInterface = param_transformInfoInterface
    }

    def isValid() : _root_.java.lang.Boolean = {
        var billingAddressesEntity : BillingAddressesEntity = new BillingAddressesEntity(this.getWeblisketSession().getUserName())
        this.streetAddresses = billingAddressesEntity.get()
        if (this.streetAddresses == null) {
            return _root_.java.lang.Boolean.FALSE
        }
        if (this.streetAddresses.size() < 1) {
            return _root_.java.lang.Boolean.FALSE
        }
        return _root_.java.lang.Boolean.TRUE
    }

    def validationInfo() : String = {
        return "No Billing Addresses to display.<br />"
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


