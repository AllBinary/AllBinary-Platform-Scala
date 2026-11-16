/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.business.user.commerce.shipping.modules

import _root_.org.allbinary.business.user.commerce.shipping.ShippingMethodData
import _root_.org.allbinary.data.tree.dom.DomNodeInterface
import _root_.org.allbinary.data.tree.dom.ModDomHelper
import _root_.org.allbinary.data.tree.dom.document.DomDocumentHelper
import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.w3c.dom.Document
import _root_.org.w3c.dom.Node

class BasicWeightShippingModuleView() extends BasicWeightShippingModule with DomNodeInterface {

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

    def validationInfo() : String = {
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

    def toXmlDoc() : _root_.org.w3c.dom.Document = {
        try {
            var document : Document = DomDocumentHelper.create()
            /*          Node contentTypeNode =          document.createElement(this.contentType);          document.appendChild(contentTypeNode);                     contentTypeNode.appendChild(this.storeFrontInterface.toXmlNode(document));          contentTypeNode.appendChild(this.toXmlNode(document));           */
            return document
        } catch {
            case e : Exception => {
                if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().SQLLOGGING)) {
                    this.logUtil.put(this.commonStrings.EXCEPTION, this, "toXmlDoc", e)
                }
                //throw e;
                return null
            }
        }
        throw new IllegalStateException()
    }

    def view() : String = {
        try {
            return commonStrings.NOT_IMPLEMENTED
        } catch {
            case e : Exception => {
                if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().SQLLOGGING)) {
                    this.logUtil.put(this.commonStrings.EXCEPTION, this, "view", e)
                }
                //throw e;
                return null
            }
        }
        throw new IllegalStateException()
    }

}


