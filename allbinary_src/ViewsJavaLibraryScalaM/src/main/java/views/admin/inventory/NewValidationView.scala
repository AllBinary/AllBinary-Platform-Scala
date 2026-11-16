/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package views.admin.inventory

import _root_.org.allbinary.business.user.commerce.inventory.item.BasicItem
import _root_.org.allbinary.business.user.commerce.inventory.item.ItemInterface
import _root_.org.allbinary.logic.control.validate.ValidationComponentInterface
import _root_.org.allbinary.logic.string.StringUtil
import _root_.org.allbinary.logic.visual.transform.info.TransformInfoInterface
import _root_.org.w3c.dom.Document
import _root_.org.w3c.dom.Node

class NewValidationView(param_transformInfoInterface : TransformInfoInterface) extends InventoryItemView(param_transformInfoInterface, StringUtil.getInstance().EMPTY_STRING) with ValidationComponentInterface {

    //Constructor
    {
        val transformInfoInterface : TransformInfoInterface = param_transformInfoInterface
        this.itemInterface = (new BasicItem()).asInstanceOf[ItemInterface]
    }

    def isValid() : _root_.java.lang.Boolean = {
        try {
            return _root_.java.lang.Boolean.TRUE
        } catch {
            case e : Exception => {
                return _root_.java.lang.Boolean.FALSE
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

    def validationInfo() : String = {
        return "Error Creating New Item"
    }

    //Needed for polyglot do not remove
    override def getTransformInfoInterface() : TransformInfoInterface = {
        return super.getTransformInfoInterface()
    }

}


