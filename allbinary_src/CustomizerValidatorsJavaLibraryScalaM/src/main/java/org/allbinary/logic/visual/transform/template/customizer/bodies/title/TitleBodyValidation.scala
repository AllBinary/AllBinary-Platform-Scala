/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 leIIgal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.logic.visual.transform.template.customizer.bodies.title

import _root_.java.util.HashMap
import _root_.org.allbinary.data.tree.dom.DomData
import _root_.org.allbinary.data.tree.dom.DomNodeHelper
import _root_.org.allbinary.data.tree.dom.DomNodeInterface
import _root_.org.allbinary.data.tree.dom.DomSearchHelper
import _root_.org.allbinary.data.tree.dom.ModDomHelper
import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.logic.communication.sql.AbSqlData
import _root_.org.allbinary.logic.control.validate.Validation
import _root_.org.allbinary.logic.string.StringMaker
import _root_.org.allbinary.logic.string.StringUtil
import _root_.org.allbinary.logic.string.StringValidationUtil
import _root_.org.allbinary.logic.visual.transform.template.customizer.bodies.BodyData
import _root_.org.allbinary.logic.visual.transform.template.customizer.widgets.title.TitleData
import _root_.org.allbinary.logic.visual.transform.template.customizer.widgets.title.TitleNotRequiredValidation
import _root_.org.w3c.dom.Document
import _root_.org.w3c.dom.Node
import _root_.org.w3c.dom.NodeList

class TitleBodyValidation() extends Validation with DomNodeInterface {

    val logUtil : LogUtil = LogUtil.getInstance()

    private var body : String = null

    private var titleValidation : TitleNotRequiredValidation = null

    //Constructor
    {
        if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().VIEW)) {
            this.logUtil.putF(this.commonStrings.START, this, this.commonStrings.CONSTRUCTOR)
        }
        val stringUtil : StringUtil = StringUtil.getInstance()
        this.body = stringUtil.EMPTY_STRING
        this.titleValidation = new TitleNotRequiredValidation()
    }

    def this(document : Document) = {
        this()
        if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().VIEW)) {
            this.logUtil.putF(this.commonStrings.CONSTRUCTOR, this, "Constructor(document)")
        }
        var nodeList : NodeList = document.getElementsByTagName(BodyData.getInstance().NAME)

        {
            var index : Int = 0
            while (index < nodeList.getLength()) {
                var aBodyNode : Node = nodeList.item(index)
                var aBodyValueNode : Node = DomSearchHelper.getNode(DomData.VALUE, aBodyNode.getChildNodes())
                this.body = DomNodeHelper.getTextNodeValue(aBodyValueNode)
                var titleNode : Node = DomSearchHelper.getNode(TitleData.getInstance().NAME, aBodyNode.getChildNodes())
                this.titleValidation = new TitleNotRequiredValidation(titleNode)
                if (index > 1) {
                    if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().VIEW)) {
                        this.logUtil.putF("To Many Body Nodes", this, this.commonStrings.CONSTRUCTOR)
                    }
                }
                index += 1
            }
        }
    }

    def this(hashMap : HashMap[Object, Object]) = {
        this()
        if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().VIEW)) {
            this.logUtil.putF(this.commonStrings.START, this, "Constructor(hashmap)")
        }
        this.getFormData(hashMap)
    }

    def getFormData(hashMap : HashMap[Object, Object]) : Unit = {
        this.body = hashMap.get(BodyData.getInstance().NAME).asInstanceOf[String]
        this.titleValidation = new TitleNotRequiredValidation(hashMap)
    }

    override def isValid() : _root_.java.lang.Boolean = {
        try {
            var isValid : _root_.java.lang.Boolean = _root_.java.lang.Boolean.TRUE
            if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().VIEW)) {
                this.logUtil.putF("TitleBodyValidation", this, this.commonStrings.IS_VALID)
            }
            if (!StringValidationUtil.getInstance().isValidNotRequired(this.body, BodyData.getInstance().MIN, AbSqlData.MAXBLOB)) {
                isValid = _root_.java.lang.Boolean.FALSE
            }
            if (!this.titleValidation.isValid().booleanValue()) {
                isValid = _root_.java.lang.Boolean.FALSE
            }
            if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().VIEW)) {
                this.logUtil.putF("TitleBodyValidation: " + isValid, this, this.commonStrings.IS_VALID)
            }
            return isValid
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
            //Boolean isValid = Boolean.TRUE;
            var stringBuffer : StringMaker = new StringMaker()
            //if(!isValid.booleanValue())

            {
                stringBuffer.append("Error: Data submitted is < ")
                stringBuffer.appendint(BodyData.getInstance().MIN)
                stringBuffer.append(" or > ")
                stringBuffer.appendint(AbSqlData.MAXBLOB)
            }
            return stringBuffer.toString()
        } catch {
            case e : Exception => {
                if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().VIEWERROR)) {
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
        if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().VIEW)) {
            this.logUtil.putF("Title Body: " + this.body, this, "toXmlNode(document)")
        }
        var node : Node = ModDomHelper.createNameValueNodes(document, BodyData.getInstance().NAME, this.body)
        node.appendChild(this.titleValidation.toXmlNode(document))
        return node
    }

}


