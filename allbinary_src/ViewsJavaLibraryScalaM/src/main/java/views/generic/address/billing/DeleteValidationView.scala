/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package views.generic.address.billing

import _root_.org.allbinary.business.user.address.StreetAddressData
import _root_.org.allbinary.data.tables.user.address.billing.BillingAddressesEntity
import _root_.org.allbinary.logic.control.validate.ValidationComponentInterface
import _root_.org.allbinary.logic.visual.transform.info.TransformInfoHttpInterface
import _root_.org.allbinary.logic.visual.transform.info.TransformInfoInterface
import _root_.org.w3c.dom.Document
import _root_.org.w3c.dom.Node

class DeleteValidationView(param_transformInfoInterface : TransformInfoInterface) extends BillingAddressView(param_transformInfoInterface) with ValidationComponentInterface {

    private var value : String = null

    //Constructor
    {
        val transformInfoInterface : TransformInfoInterface = param_transformInfoInterface
        var httpTransformInfoInterface : TransformInfoHttpInterface = this.getTransformInfoInterface().asInstanceOf[TransformInfoHttpInterface]
        this.value = httpTransformInfoInterface.getPageContext().getRequest().getParameter(StreetAddressData.ID)
    }

    def isValid() : _root_.java.lang.Boolean = {
        if (this.getWeblisketSession().getUserName() != null) {
            return _root_.java.lang.Boolean.FALSE
        }
        var billingAddressesEntity : BillingAddressesEntity = new BillingAddressesEntity(this.getWeblisketSession().getUserName())
        this.streetAddress = billingAddressesEntity.get(new Integer(this.value))
        if (this.streetAddress == null) {
            return _root_.java.lang.Boolean.FALSE
        }
        return this.streetAddress.isValid()
    }

    def validationInfo() : String = {
        return this.streetAddress.validationInfo()
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


