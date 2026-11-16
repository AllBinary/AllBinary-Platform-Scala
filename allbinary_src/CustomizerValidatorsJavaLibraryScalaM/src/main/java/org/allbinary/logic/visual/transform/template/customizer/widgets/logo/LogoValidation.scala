/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.logic.visual.transform.template.customizer.widgets.logo

import _root_.java.util.HashMap
import _root_.org.allbinary.data.tree.dom.DomNodeInterface
import _root_.org.allbinary.data.tree.dom.DomSearchHelper
import _root_.org.allbinary.data.tree.dom.ModDomHelper
import _root_.org.allbinary.logic.StdUtil
import _root_.org.allbinary.logic.communication.http.request.HttpRequestUtil
import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.logic.control.validate.Validation
import _root_.org.allbinary.logic.io.file.FileData
import _root_.org.allbinary.logic.io.path.AbPath
import _root_.org.allbinary.logic.string.StringMaker
import _root_.org.allbinary.logic.string.StringUtil
import _root_.org.allbinary.logic.string.StringValidationUtil
import _root_.org.apache.commons.fileupload.FileItem
import _root_.org.w3c.dom.Document
import _root_.org.w3c.dom.Node

class LogoValidation() extends Validation with DomNodeInterface {

    val logUtil : LogUtil = LogUtil.getInstance()

    private var logoFileItem : FileItem = null

    private var logoAbPath : AbPath = null

    private var logoFile : String = null

    private var isFile : Boolean = false

    //Constructor
    {
        this.isFile = false
        this.logoAbPath = null
        this.logoFile = null
    }

    def this(node : Node) = {
        this()
        this.isFile = false
        this.logoAbPath = new AbPath(DomSearchHelper.getNode(LogoData.getInstance().IMAGEPATH, node.getChildNodes()).getNodeValue(), StringUtil.getInstance().EMPTY_STRING)
        this.logoFile = DomSearchHelper.getNode(LogoData.getInstance().IMAGEFILENAME, node.getChildNodes()).getNodeValue()
    }

    def this(hashMap : HashMap[Object, Object]) = {
        this()
        this.isFile = true
        this.getFormData(hashMap)
    }

    def getFormData(hashMap : HashMap[Object, Object]) : Unit = {
        this.logoFileItem = hashMap.get(LogoData.getInstance().IMAGE).asInstanceOf[FileItem]
        this.logoAbPath = new AbPath(hashMap.get(LogoData.getInstance().IMAGEPATH).asInstanceOf[String], StringUtil.getInstance().EMPTY_STRING)
        if (this.logoFileItem != null) {
            this.logoFile = HttpRequestUtil.getInstance().generateFileName(this.logoFileItem.getName())
        }
        if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().VIEW)) {
            var stringBuffer : StringMaker = new StringMaker()
            stringBuffer.append("HashMap: ")
            stringBuffer.append(hashMap.toString())
            stringBuffer.append("\nLogoFileName: ")
            stringBuffer.append(this.logoFile)
            this.logUtil.putF(stringBuffer.toString(), this, "getFormData()")
        }
    }

    override def isValid() : _root_.java.lang.Boolean = {
        try {
            var valid : _root_.java.lang.Boolean = _root_.java.lang.Boolean.TRUE
            var fileData : FileData = FileData.getInstance()
            if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().VIEW)) {
                this.logUtil.putF("LogoValidation", this, this.commonStrings.IS_VALID)
            }
            if (!StringValidationUtil.getInstance().isValidRequired(this.logoAbPath.toString(), 0, 512)) {
                if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().VIEW)) {
                    this.logUtil.putF("logoPath is invalid: " + this.logoAbPath.toString(), this, this.commonStrings.IS_VALID)
                }
                return _root_.java.lang.Boolean.FALSE
            }
            if (!StringValidationUtil.getInstance().isValidRequired(this.logoFile, fileData.MINLEN, fileData.MAXLEN)) {
                if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().VIEW)) {
                    this.logUtil.putF("logoFile is invalid: " + this.logoFile, this, this.commonStrings.IS_VALID)
                }
                return _root_.java.lang.Boolean.FALSE
            }
            //future version may require file for edit
            if (this.isFile) {
                if (this.logoFileItem == null) {
                    return _root_.java.lang.Boolean.FALSE
                }
                if ((this.logoFileItem.getSize() > fileData.MAXIMAGEFILESIZE) || (this.logoFileItem.getSize() < fileData.MINIMAGEFILESIZE)) {
                    if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().VIEW)) {
                        this.logUtil.putF((("Image File Is Not The Right Size. " + fileData.MINIMAGEFILESIZE) + "< > ") + fileData.MAXIMAGEFILESIZE, this, this.commonStrings.IS_VALID)
                    }
                    return _root_.java.lang.Boolean.FALSE
                }
            }
            if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().VIEW)) {
                this.logUtil.putF("Logo Validation: " + valid, this, this.commonStrings.IS_VALID)
            }
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
            stringBuffer.append("Logo is not valid.")
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

    def toHashMap() : HashMap[Object, Object] = {
        val stringUtil : StringUtil = StringUtil.getInstance()
        val hashMap : HashMap[Object, Object] = StdUtil.getInstance().createHashMap().asInstanceOf[HashMap[Object, Object]]
        hashMap.put(LogoData.getInstance().IMAGE, stringUtil.EMPTY_STRING)
        if (this.logoFile != null) {
            hashMap.put(LogoData.getInstance().IMAGEPATH, this.logoAbPath.toString())
            hashMap.put(LogoData.getInstance().IMAGEFILENAME, this.logoFile)
        } else {
            hashMap.put(LogoData.getInstance().IMAGEPATH, null)
            hashMap.put(LogoData.getInstance().IMAGEFILENAME, this.logoFile)
        }
        return hashMap
    }

    def toXmlNode(document : Document) : Node = {
        var hashMap : HashMap[Object, Object] = this.toHashMap().asInstanceOf[HashMap[Object, Object]]
        return ModDomHelper.createNameValueNodes(document, LogoData.getInstance().NAME, hashMap)
    }

    def processLogoFile() : Unit = {
        if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().VIEW)) {
            var stringBuffer : StringMaker = new StringMaker()
            stringBuffer.append("Processing logoFile: ")
            stringBuffer.append(this.logoAbPath.toString())
            stringBuffer.append(this.logoFile)
            this.logUtil.putF(stringBuffer.toString(), this, "processLogoFile()")
        }
        //Do not update image if file was not provided
        new LogoImageFileUtil(this.logoAbPath, this.logoFile).saveFiles(this.logoFileItem)
    }

}


