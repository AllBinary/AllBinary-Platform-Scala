/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package views.generic.address.shipping

import _root_.org.allbinary.business.user.address.StreetAddress
import _root_.org.allbinary.logic.control.validate.ValidationComponentInterface
import _root_.org.allbinary.logic.visual.transform.info.TransformInfoInterface
import _root_.org.w3c.dom.Document
import _root_.org.w3c.dom.Node

class UpdateValidationView(param_transformInfoInterface : TransformInfoInterface) extends ShippingAddressView(param_transformInfoInterface) with ValidationComponentInterface {

    //Constructor
    {
        val transformInfoInterface : TransformInfoInterface = param_transformInfoInterface
    }

    def isValid() : _root_.java.lang.Boolean = {
        this.streetAddress = new StreetAddress(this.getRequest())
        if (this.streetAddress.isValid() == _root_.java.lang.Boolean.FALSE) {
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


