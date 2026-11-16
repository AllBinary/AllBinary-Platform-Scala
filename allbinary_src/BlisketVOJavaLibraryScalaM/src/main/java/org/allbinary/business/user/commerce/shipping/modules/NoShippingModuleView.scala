/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.business.user.commerce.shipping.modules

import _root_.org.allbinary.business.user.commerce.shipping.ShippingMethodData
import _root_.org.allbinary.data.tree.dom.DomNodeInterface
import _root_.org.allbinary.data.tree.dom.ModDomHelper
import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.w3c.dom.Node

class NoShippingModuleView() extends NoShippingModule with DomNodeInterface {

    val logUtil : LogUtil = LogUtil.getInstance()

    def isValid() : _root_.java.lang.Boolean = {
        return null
    }

    def toValidationInfoDoc() : _root_.org.w3c.dom.Document = {
        return null
    }

    def toValidationInfoNode(document : _root_.org.w3c.dom.Document) : _root_.org.w3c.dom.Node = {
        return null
    }

    def toXmlDoc() : _root_.org.w3c.dom.Document = {
        return null
    }

    def toXmlNode(document : _root_.org.w3c.dom.Document) : _root_.org.w3c.dom.Node = {
        try {
            var shippingMethodNode : Node = document.createElement(ShippingMethodData.NAME)
            shippingMethodNode.appendChild(ModDomHelper.createNameValueNodes(document, ShippingMethodData.NAME, this.getName()))
            shippingMethodNode.appendChild(ModDomHelper.createNameValueNodes(document, ShippingMethodData.DESCRIPTION, this.getDescription()))
            return shippingMethodNode
        } catch {
            case e : Exception => {
                if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().SQLLOGGING)) {
                    this.logUtil.put(this.commonStrings.EXCEPTION, this, "toXmlNode", e)
                }
                //throw e;
                return null
            }
        }
        throw new IllegalStateException()
    }

    def validationInfo() : String = {
        return null
    }

    def view() : String = {
        return null
    }

}


