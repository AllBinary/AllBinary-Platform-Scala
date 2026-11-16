/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. * II * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.logic.visual.transform.template.customizer.includes.meta

import _root_.org.allbinary.util.BasicArrayList
import _root_.org.allbinary.util.BasicArrayListD
import _root_.org.allbinary.business.context.modules.storefront.StoreFrontFactory
import _root_.org.allbinary.business.context.modules.storefront.StoreFrontInterface
import _root_.org.allbinary.data.tree.dom.DomNodeInterface
import _root_.org.allbinary.logic.StdUtil
import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.logic.control.validate.Validation
import _root_.org.allbinary.logic.string.StringMaker
import _root_.org.allbinary.logic.visual.dhtml.html.head.meta.HtmlMetaAttributeDataFactory
import _root_.org.allbinary.logic.visual.dhtml.html.head.meta.HtmlMetaAttributeValuesData
import _root_.org.allbinary.logic.visual.dhtml.html.head.meta.HtmlMetasData
import _root_.org.allbinary.string.CommonStrings
import _root_.org.w3c.dom.Document
import _root_.org.w3c.dom.Node

class MetasValidation private () extends Validation with DomNodeInterface {

    val logUtil : LogUtil = LogUtil.getInstance()

    private var storeFrontInterface : StoreFrontInterface = null

    private var metaValidationVector : BasicArrayList = null

    //new
    def this(storeName : String) = {
        this()
        this.storeFrontInterface = StoreFrontFactory.getInstance(storeName)
        this.metaValidationVector = new BasicArrayListD()
        var contentValue : String = this.storeFrontInterface.getName() + " E-Commerce Site"
        var keywordsMetaValidation : MetaValidation = new MetaValidation(HtmlMetaAttributeDataFactory.getInstance().NAME, "Keywords", HtmlMetaAttributeValuesData.getInstance().KEYWORDS, contentValue)
        var abstractMetaValidation : MetaValidation = new MetaValidation(HtmlMetaAttributeDataFactory.getInstance().NAME, "Abstract", HtmlMetaAttributeValuesData.getInstance().ABSTRACT, contentValue)
        var descriptionMetaValidation : MetaValidation = new MetaValidation(HtmlMetaAttributeDataFactory.getInstance().NAME, "Description", HtmlMetaAttributeValuesData.getInstance().DESCRIPTION, contentValue)
        this.metaValidationVector.add(keywordsMetaValidation)
        this.metaValidationVector.add(abstractMetaValidation)
        this.metaValidationVector.add(descriptionMetaValidation)
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
        var node : Node = document.createElement(HtmlMetasData.getInstance().NAME)
        var metaArray : Array[MetaValidation] = this.metaValidationVector.toArrayType(new Array[MetaValidation](this.metaValidationVector.size()).asInstanceOf[Array[Object]]).asInstanceOf[Array[MetaValidation]]
        var size : Int = metaArray.length

        {
            var i : Int = 0
            while (i < size) {
                var metaValidation : MetaValidation = metaArray(i)
                node.appendChild(metaValidation.toXmlNode(document))
                i += 1
            }
        }
        // this.storeFrontInterface).toXmlNode(document));
        return node
    }

}


