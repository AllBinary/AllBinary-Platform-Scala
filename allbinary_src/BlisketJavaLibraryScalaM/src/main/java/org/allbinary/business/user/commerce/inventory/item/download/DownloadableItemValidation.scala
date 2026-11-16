/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.business.user.commerce.inventory.item.download

import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.logic.communication.sql.AbSqlData
import _root_.org.allbinary.logic.control.validate.Validation
import _root_.org.allbinary.logic.string.StringMaker
import _root_.org.allbinary.logic.string.StringValidationUtil
import _root_.org.w3c.dom.Document
import _root_.org.w3c.dom.Node

class DownloadableItemValidation(param_downloadableItem : DownloadableItem) extends Validation {

    val logUtil : LogUtil = LogUtil.getInstance()

    private var downloadableItem : DownloadableItem = null

    //Constructor
    {
        val downloadableItem : DownloadableItem = param_downloadableItem
        this.downloadableItem = downloadableItem
    }

    override def isValid() : _root_.java.lang.Boolean = {
        try {
            if (((this.downloadableItem.getId() == null) || (this.downloadableItem.getId().length() < 1)) || (this.downloadableItem.getId().length() > AbSqlData.MAXNUM)) {
                return _root_.java.lang.Boolean.FALSE
            }
            if ((this.downloadableItem.getId() != null) && !StringValidationUtil.getInstance().isNumber(this.downloadableItem.getId())) {
                return _root_.java.lang.Boolean.FALSE
            }
            if (((this.downloadableItem.getSystem() == null) || (this.downloadableItem.getSystem().length() < 1)) || (this.downloadableItem.getSystem().length() > AbSqlData.MAXSTRING)) {
                return _root_.java.lang.Boolean.FALSE
            }
            if (((this.downloadableItem.getPlatform() == null) || (this.downloadableItem.getPlatform().length() < 1)) || (this.downloadableItem.getPlatform().length() > AbSqlData.MAXSTRING)) {
                return _root_.java.lang.Boolean.FALSE
            }
            if (((this.downloadableItem.getSpecialName() == null) || (this.downloadableItem.getSpecialName().length() < 0)) || (this.downloadableItem.getSpecialName().length() > AbSqlData.MAXSTRING)) {
                return _root_.java.lang.Boolean.FALSE
            }
            if (((this.downloadableItem.getVersion() == null) || (this.downloadableItem.getVersion().length() < 1)) || (this.downloadableItem.getVersion().length() > AbSqlData.MAXSTRING)) {
                return _root_.java.lang.Boolean.FALSE
            }
            if (((this.downloadableItem.getChanges() == null) || (this.downloadableItem.getChanges().length() < 1)) || (this.downloadableItem.getChanges().length() > AbSqlData.MAXBLOB)) {
                return _root_.java.lang.Boolean.FALSE
            }
            //file;
            if (this.downloadableItem.getSize() == null) {
                return _root_.java.lang.Boolean.FALSE
            } else {
                var size : String = this.downloadableItem.getSize().toString()
                if ((size.length() < 1) || (size.length() > AbSqlData.MAXNUM)) {
                    return _root_.java.lang.Boolean.FALSE
                }
            }
            if (this.downloadableItem.getValidTime() == null) {
                return _root_.java.lang.Boolean.FALSE
            } else {
                var size : String = this.downloadableItem.getValidTime().toString()
                if ((size.length() < 1) || (size.length() > AbSqlData.MAXNUM)) {
                    return _root_.java.lang.Boolean.FALSE
                }
            }
            if (this.downloadableItem.getRetries() == null) {
                return _root_.java.lang.Boolean.FALSE
            } else {
                var size : String = this.downloadableItem.getRetries().toString()
                if ((size.length() < 1) || (size.length() > AbSqlData.MAXNUM)) {
                    return _root_.java.lang.Boolean.FALSE
                }
            }
            return _root_.java.lang.Boolean.TRUE
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
            if (((this.downloadableItem.getId() == null) || (this.downloadableItem.getId().length() < 1)) || (this.downloadableItem.getId().length() > AbSqlData.MAXNUM)) {
                stringBuffer.append("Id is invalid. Must be number < ")
                stringBuffer.appendint(AbSqlData.MAXNUM)
                stringBuffer.append(" and > 0 digits.<br/>")
            }
            if ((this.downloadableItem.getId() != null) && !StringValidationUtil.getInstance().isNumber(this.downloadableItem.getId())) {
                stringBuffer.append("Id is invalid. Must be > 0.<br/>")
            }
            if (((this.downloadableItem.getSystem() == null) || (this.downloadableItem.getSystem().length() < 1)) || (this.downloadableItem.getSystem().length() > AbSqlData.MAXSTRING)) {
                stringBuffer.append("System value is invalid. Must be < ")
                stringBuffer.appendint(AbSqlData.MAXSTRING)
                stringBuffer.append(" and > 0 characters long.<br/>")
            }
            if (((this.downloadableItem.getPlatform() == null) || (this.downloadableItem.getPlatform().length() < 1)) || (this.downloadableItem.getPlatform().length() > AbSqlData.MAXSTRING)) {
                stringBuffer.append("Platform value is invalid. Must be < ")
                stringBuffer.appendint(AbSqlData.MAXSTRING)
                stringBuffer.append(" and > 0 characters long.<br/>")
            }
            if (((this.downloadableItem.getSpecialName() == null) || (this.downloadableItem.getSpecialName().length() < 0)) || (this.downloadableItem.getSpecialName().length() > AbSqlData.MAXSTRING)) {
                stringBuffer.append("Special Name value is invalid. Must be < ")
                stringBuffer.appendint(AbSqlData.MAXSTRING)
                stringBuffer.append(" and > 0 characters long.<br/>")
            }
            if (((this.downloadableItem.getVersion() == null) || (this.downloadableItem.getVersion().length() < 1)) || (this.downloadableItem.getVersion().length() > AbSqlData.MAXSTRING)) {
                stringBuffer.append("Version value is invalid. Must be < ")
                stringBuffer.appendint(AbSqlData.MAXSTRING)
                stringBuffer.append(" and > 0 characters long.<br/>")
            }
            if (((this.downloadableItem.getChanges() == null) || (this.downloadableItem.getChanges().length() < 0)) || (this.downloadableItem.getChanges().length() > AbSqlData.MAXBLOB)) {
                stringBuffer.append("Changes value is invalid. Must be < ")
                stringBuffer.appendint(AbSqlData.MAXBLOB)
                stringBuffer.append(" and >= 0 characters long.<br/>")
            }
            //file;
            if (this.downloadableItem.getSize() == null) {
                stringBuffer.append("File Size is null")
            } else {
                var size : String = this.downloadableItem.getSize().toString()
                if ((size.length() < 1) || (size.length() > AbSqlData.MAXNUM)) {
                    stringBuffer.append("File Size is invalid. Must be number < ")
                    stringBuffer.appendint(AbSqlData.MAXNUM)
                    stringBuffer.append(" and > 0 digits.<br/>")
                }
            }
            if (this.downloadableItem.getValidTime() == null) {
                stringBuffer.append("Valid Time is null")
            } else {
                var size : String = this.downloadableItem.getValidTime().toString()
                if ((size.length() < 1) || (size.length() > AbSqlData.MAXNUM)) {
                    stringBuffer.append("Valid Time is invalid. Must be number < ")
                    stringBuffer.appendint(AbSqlData.MAXNUM)
                    stringBuffer.append(" and > 0 digits.<br/>")
                }
            }
            if (this.downloadableItem.getRetries() == null) {
                stringBuffer.append("Retries is null")
            } else {
                var size : String = this.downloadableItem.getRetries().toString()
                if ((size.length() < 1) || (size.length() > AbSqlData.MAXNUM)) {
                    stringBuffer.append("Retries is invalid. Must be number < ")
                    stringBuffer.appendint(AbSqlData.MAXNUM)
                    stringBuffer.append(" and > 0 digits.<br/>")
                }
            }
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

}


