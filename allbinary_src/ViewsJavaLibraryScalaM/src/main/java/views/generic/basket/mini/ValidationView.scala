/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package views.generic.basket.mini

import _root_.org.allbinary.globals.MESSAGES
import _root_.org.allbinary.logic.control.validate.ValidationComponentInterface
import _root_.org.allbinary.logic.visual.transform.info.TransformInfoInterface

class ValidationView(param_transformInfoInterface : TransformInfoInterface) extends MiniBasketView(param_transformInfoInterface) with ValidationComponentInterface {

    //Constructor
    {
        val transformInfoInterface : TransformInfoInterface = param_transformInfoInterface
    }

    def isValid() : _root_.java.lang.Boolean = {
        return _root_.java.lang.Boolean.TRUE
    }

    def toValidationInfoDoc() : _root_.org.w3c.dom.Document = {
        return null
    }

    def toValidationInfoNode(document : _root_.org.w3c.dom.Document) : _root_.org.w3c.dom.Node = {
        return null
    }

    def validationInfo() : String = {
        return MESSAGES.CONTACTADMIN
    }

    //Needed for polyglot do not remove
    override def getTransformInfoInterface() : TransformInfoInterface = {
        return super.getTransformInfoInterface()
    }

}


