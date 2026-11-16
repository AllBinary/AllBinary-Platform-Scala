/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package views.admin.inventory

import _root_.org.allbinary.business.context.modules.storefront.StoreFrontFactory
import _root_.org.allbinary.business.context.modules.storefront.StoreFrontInterface
import _root_.org.allbinary.business.user.commerce.inventory.item.BasicItemData
import _root_.org.allbinary.business.user.commerce.inventory.item.BasicItemValidation
import _root_.org.allbinary.business.user.commerce.money.MoneyException
import _root_.org.allbinary.data.tables.user.commerce.inventory.item.InventoryEntity
import _root_.org.allbinary.data.tables.user.commerce.inventory.item.InventoryEntityFactory
import _root_.org.allbinary.globals.GLOBALS2
import _root_.org.allbinary.globals.URLGLOBALS
import _root_.org.allbinary.logic.communication.http.file.upload.HttpFileUploadUtil
import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.logic.control.validate.ValidationComponentInterface
import _root_.org.allbinary.logic.io.file.AbFile
import _root_.org.allbinary.logic.io.file.FileData
import _root_.org.allbinary.logic.string.StringMaker
import _root_.org.allbinary.logic.string.StringValidationUtil
import _root_.org.allbinary.logic.visual.transform.info.TransformInfoInterface
import _root_.org.allbinary.string.CommonSeps
import _root_.org.allbinary.string.CommonStrings
import _root_.org.apache.commons.fileupload.FileItem
import _root_.org.w3c.dom.Document
import _root_.org.w3c.dom.Node

class UpdateFileValidationView(param_transformInfoInterface : TransformInfoInterface) extends InventoryItemView(param_transformInfoInterface) with ValidationComponentInterface {
    import _root_.views.admin.inventory.UpdateFileValidationView.{*}

    val logUtil_UpdateFileValidationView : LogUtil = LogUtil.getInstance()

    //itemInterface = InventoryEntityFactory.getInstance().getItem(id);
    //Constructor
    {
        val transformInfoInterface : TransformInfoInterface = param_transformInfoInterface
    }

    def isValid() : _root_.java.lang.Boolean = {
        try {
            var command : String = this.getRequestHashMap().get(GLOBALS2.ADMINCOMMAND).asInstanceOf[String]
            if ((command == null) || (command.compareTo(UpdateFileValidationView.UPDATEPRODUCT) != 0)) {
                if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().VIEW)) {
                    this.logUtil_UpdateFileValidationView.putF("Invalid AdminCommand=" + command, this, this.commonStrings.IS_VALID)
                }
                return _root_.java.lang.Boolean.FALSE
            }
            if (new BasicItemValidation(this.itemInterface).isValid() == _root_.java.lang.Boolean.FALSE) {
                if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().VIEW)) {
                    this.logUtil_UpdateFileValidationView.putF("BasicItem is not valid", this, this.commonStrings.IS_VALID)
                }
                return _root_.java.lang.Boolean.FALSE
            }
            var storeFrontInterface : StoreFrontInterface = StoreFrontFactory.getInstance(this.getWeblisketSession().getStoreName())
            var stringBuffer : StringMaker = new StringMaker()
            stringBuffer.append(URLGLOBALS.getWebappPath())
            stringBuffer.append(storeFrontInterface.getCurrentHostNamePath())
            //storeFrontInterface.getCategoryPath() +
            stringBuffer.append(this.itemInterface.getCategory())
            var fullCategory : String = stringBuffer.toString()
            var categoryFile : AbFile = AbFile.createAbFile(fullCategory)
            if (!categoryFile.isDirectory()) {
                if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().VIEW)) {
                    this.logUtil_UpdateFileValidationView.putF("Category Does Not Exist: " + fullCategory, this, this.commonStrings.IS_VALID)
                }
                return _root_.java.lang.Boolean.FALSE
            }
            var inventoryEntity : InventoryEntity = InventoryEntityFactory.getInstance().getInventoryEntityInstance()
            if (inventoryEntity.getItem(this.itemInterface.getId()) == null) {
                return _root_.java.lang.Boolean.FALSE
            }
            var anyType : Object = this.getRequestHashMap().get(basicItemData.IMAGE)
            if (HttpFileUploadUtil.getInstance().isValid(anyType)) {
                var fileItem : FileItem = anyType.asInstanceOf[FileItem]
                var size : Long = fileItem.getSize()
                var fileName : String = fileItem.getName()
                HttpFileUploadUtil.log(fileItem)
                if (this.isValid(fileName, size) == _root_.java.lang.Boolean.FALSE) {
                    return _root_.java.lang.Boolean.FALSE
                }
            }
            return _root_.java.lang.Boolean.TRUE
        } catch {
            case e : Exception => {
                if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().VIEW)) {
                    this.logUtil_UpdateFileValidationView.put("Exception in validation", this, this.commonStrings.IS_VALID, e)
                }
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
        var stringBuffer : StringMaker = new StringMaker()
        var command : String = this.getRequestHashMap().get(GLOBALS2.ADMINCOMMAND).asInstanceOf[String]
        if ((command == null) || (command.compareTo(UpdateFileValidationView.UPDATEPRODUCT) != 0)) {
            return CommonSeps.getInstance().SPACE
        }
        stringBuffer.append(new BasicItemValidation(this.itemInterface).validationInfo())
        var storeFrontInterface : StoreFrontInterface = StoreFrontFactory.getInstance(this.getWeblisketSession().getStoreName())
        var fullCategory : String = (URLGLOBALS.getWebappPath().asInstanceOf[String] + storeFrontInterface.getCurrentHostNamePath()) + this.itemInterface.getCategory()
        if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().VIEW)) {
            this.logUtil_UpdateFileValidationView.putF("Category: " + fullCategory, this, "validationInfo()")
        }
        try {
            if (InventoryEntityFactory.getInstance().getInventoryEntityInstance().getItem(this.itemInterface.getId()) == null) {
                stringBuffer.append("Item does not exist.<br>")
            }
        } catch {
            case e : MoneyException => {
                if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().VIEW)) {
                    this.logUtil_UpdateFileValidationView.putF("Existing Item With MoneyException", this, "validationInfo()")
                }
            }
        }
        var anyType : Object = this.getRequestHashMap().get(basicItemData.IMAGE)
        if (HttpFileUploadUtil.getInstance().isValid(anyType)) {
            var fileItem : FileItem = anyType.asInstanceOf[FileItem]
            var size : Long = fileItem.getSize()
            var fileName : String = fileItem.getName()
            var fileItemFieldName : String = fileItem.getFieldName()
            this.validationInfo(stringBuffer, fileName, fileItemFieldName, size)
        }
        //else stringBuffer.append("Image File Form Data Error");
        return stringBuffer.toString()
    }

    private def isValid(fileName : String, size : Long) : _root_.java.lang.Boolean = {
        var fileData : FileData = FileData.getInstance()
        if (size > fileData.MINIMAGEFILESIZE) {
            if (size < fileData.MAXIMAGEFILESIZE) {
                if (!StringValidationUtil.getInstance().isValidRequired(fileName, fileData.MINLEN, fileData.MAXLEN)) {
                    return _root_.java.lang.Boolean.FALSE
                }
            } else {
                if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().VIEW)) {
                    var stringBuffer : StringMaker = new StringMaker()
                    stringBuffer.append("File Size To Large: ")
                    stringBuffer.appendlong(size)
                    stringBuffer.append(">")
                    stringBuffer.appendint(fileData.MAXIMAGEFILESIZE)
                    this.logUtil_UpdateFileValidationView.putF(stringBuffer.toString(), this, this.commonStrings.IS_VALID)
                }
                return _root_.java.lang.Boolean.FALSE
            }
            this.processImageFiles()
        }
        return _root_.java.lang.Boolean.TRUE
    }

    private def validationInfo(stringBuffer : StringMaker, fileName : String, fileItemFieldName : String, size : Long) : Unit = {
        var fileData : FileData = FileData.getInstance()
        if (size > fileData.MINIMAGEFILESIZE) {
            if (fileItemFieldName.compareTo(basicItemData.IMAGE) == 0) {
                if (size < fileData.MAXIMAGEFILESIZE) {
                    if (!StringValidationUtil.getInstance().isValidRequired(fileName, fileData.MINLEN, fileData.MAXLEN)) {
                        stringBuffer.append("FileName must be >")
                        stringBuffer.appendint(fileData.MINLEN)
                        stringBuffer.append("and <")
                        stringBuffer.appendint(fileData.MAXLEN)
                        stringBuffer.append("<br />")
                    }
                } else {
                    stringBuffer.append("Image File Is Not The Right Size. ")
                    stringBuffer.appendint(fileData.MINIMAGEFILESIZE)
                    stringBuffer.append("< > ")
                    stringBuffer.appendint(fileData.MAXIMAGEFILESIZE)
                    stringBuffer.append("<br />")
                }
            }
        }
    }

    //Needed for polyglot do not remove
    override def getTransformInfoInterface() : TransformInfoInterface = {
        return super.getTransformInfoInterface()
    }

}

object UpdateFileValidationView {
    private val UPDATEPRODUCT : String = CommonStrings.getInstance().UPDATE

}


