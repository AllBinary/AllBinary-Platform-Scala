/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.logic.visual.transform.template.customizer.includes.globals

import _root_.org.allbinary.business.context.modules.storefront.StoreFrontFactory
import _root_.org.allbinary.business.context.modules.storefront.StoreFrontInterface
import _root_.org.allbinary.business.context.modules.storefront.StoreFrontView
import _root_.org.allbinary.data.tree.dom.DomNodeInterface
import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.logic.control.validate.Validation
import _root_.org.allbinary.logic.string.StringMaker
import _root_.org.allbinary.string.CommonStrings
import _root_.org.w3c.dom.Document
import _root_.org.w3c.dom.Node

class GlobalsValidation private () extends Validation with DomNodeInterface {

    val logUtil : LogUtil = LogUtil.getInstance()

    private var storeFrontInterface : StoreFrontInterface = null

    //new
    def this(storeName : String) = {
        this()
        this.storeFrontInterface = StoreFrontFactory.getInstance(storeName)
    }

    //from db
    def this(document : Document) = {
        this()
        throw new Exception(CommonStrings.getInstance().NOT_IMPLEMENTED)
    }

    /*    public GlobalsValidation(HashMap hashMap)    {           }      */
    override def isValid() : _root_.java.lang.Boolean = {
        try {
            var valid : _root_.java.lang.Boolean = _root_.java.lang.Boolean.TRUE
            /*          if(!this.isValid().booleanValue() && !this.logo.isValid().booleanValue())          {             valid = Boolean.FALSE;          }          */
            return valid
        } catch {
            case e : Exception => {
                if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().SQLTAGSERROR)) {
                    this.logUtil.put("Failed to validate form", this, this.commonStrings.IS_VALID, e)
                }
                return _root_.java.lang.Boolean.FALSE
            }
        }
        throw new IllegalStateException()
    }

    override def validationInfo() : String = {
        try {
            var stringBuffer : StringMaker = new StringMaker()
            /*          if(!this.isValid().booleanValue() && !this.isValid().booleanValue())          {             stringBuffer.append("Include a title or logo for the header.");          }          */
            return stringBuffer.toString()
        } catch {
            case e : Exception => {
                if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().SQLTAGSERROR)) {
                    this.logUtil.put("Failed to generate validation error info", this, "validationInfo()", e)
                }
                return "Error Validating Form"
            }
        }
        throw new IllegalStateException()
    }

    override def toValidationInfoDoc() : Document = {
        return null
    }

    override def toValidationInfoNode(document : Document) : Node = {
        return null
    }

    def toXmlNode(document : Document) : Node = {
        var node : Node = document.createElement(GlobalsData.NAME)
        node.appendChild(new StoreFrontView(this.storeFrontInterface).toXmlNode(document))
        return node
    }

}


