/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package views.admin.inventory

import _root_.org.allbinary.business.context.modules.storefront.StoreFrontFactory
import _root_.org.allbinary.business.context.modules.storefront.StoreFrontInterface
import _root_.org.allbinary.business.user.commerce.inventory.item.BasicItemData
import _root_.org.allbinary.business.user.commerce.inventory.item.BasicItemValidation
import _root_.org.allbinary.business.user.commerce.money.MoneyException
import _root_.org.allbinary.data.tables.user.commerce.inventory.item.InventoryEntityFactory
import _root_.org.allbinary.globals.GLOBALS2
import _root_.org.allbinary.globals.URLGLOBALS
import _root_.org.allbinary.logic.communication.http.file.upload.HttpFileUploadUtil
import _root_.org.allbinary.logic.communication.http.file.upload.media.UploadMediaSingleton
import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.logic.control.validate.ValidationComponentInterface
import _root_.org.allbinary.logic.io.file.AbFile
import _root_.org.allbinary.logic.io.file.FileData
import _root_.org.allbinary.logic.io.path.AbPathData
import _root_.org.allbinary.logic.string.StringMaker
import _root_.org.allbinary.logic.string.StringUtil
import _root_.org.allbinary.logic.string.StringValidationUtil
import _root_.org.allbinary.logic.visual.transform.info.TransformInfoInterface
import _root_.org.allbinary.string.CommonLabels
import _root_.org.apache.commons.fileupload.FileItem
import _root_.org.w3c.dom.Document
import _root_.org.w3c.dom.Node

class AddFileValidationView(param_transformInfoInterface : TransformInfoInterface) extends InventoryItemView(param_transformInfoInterface) with ValidationComponentInterface {
    import _root_.views.admin.inventory.AddFileValidationView.{*}

    val logUtil_AddFileValidationView : LogUtil = LogUtil.getInstance()

    val basicItemData_AddFileValidationView : BasicItemData = BasicItemData.getInstance()

    //itemInterface = InventoryEntityFactory.getInstance().getItem(id);
    //Constructor
    {
        val transformInfoInterface : TransformInfoInterface = param_transformInfoInterface
    }

    def isValid() : _root_.java.lang.Boolean = {
        try {
            var command : String = this.getRequestHashMap().get(GLOBALS2.ADMINCOMMAND).asInstanceOf[String]
            if (StringValidationUtil.getInstance().isEmpty(command) || ((command.compareTo(AddFileValidationView.ADDPRODUCT) != 0) && (command.compareTo(NEXTSTEP) != 0))) {
                if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().VIEW)) {
                    var stringBuffer : StringMaker = new StringMaker()
                    stringBuffer.append("Invalid AdminCommand: ")
                    stringBuffer.append(command)
                    stringBuffer.append(" must be: ")
                    stringBuffer.append(AddFileValidationView.ADDPRODUCT)
                    stringBuffer.append(" or ")
                    stringBuffer.append(AddFileValidationView.NEXTSTEP)
                    this.logUtil_AddFileValidationView.putF(stringBuffer.toString(), this, this.commonStrings.IS_VALID)
                }
                return _root_.java.lang.Boolean.FALSE
            }
            var basicItemValidation : BasicItemValidation = new BasicItemValidation(this.itemInterface)
            if (basicItemValidation.isValid() == _root_.java.lang.Boolean.FALSE) {
                if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().VIEW)) {
                    this.logUtil_AddFileValidationView.putF(basicItemValidation.validationInfo(), this, this.commonStrings.IS_VALID)
                }
                return _root_.java.lang.Boolean.FALSE
            }
            var storeFrontInterface : StoreFrontInterface = StoreFrontFactory.getInstance(this.getWeblisketSession().getStoreName())
            //correct category
            this.itemInterface.setCategory(storeFrontInterface.getCategoryPath() + this.itemInterface.getCategory())
            var fullCategory : String = new StringMaker().append(URLGLOBALS.getWebappPath()).append(storeFrontInterface.getCurrentHostNamePath()).append(this.itemInterface.getCategory()).toString()
            //storeFrontInterface.getCategoryPath()
            var categoryFile : AbFile = AbFile.createAbFile(fullCategory)
            if (!categoryFile.isDirectory()) {
                if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().VIEW)) {
                    this.logUtil_AddFileValidationView.putF("Category Does Not Exist: " + fullCategory, this, this.commonStrings.IS_VALID)
                }
                return _root_.java.lang.Boolean.FALSE
            }
            if (InventoryEntityFactory.getInstance().getInventoryEntityInstance().getItem(this.itemInterface.getId()) != null) {
                if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().VIEW)) {
                    this.logUtil_AddFileValidationView.putF("Item Already Exists", this, this.commonStrings.IS_VALID)
                }
                return _root_.java.lang.Boolean.FALSE
            }
            var imageFileItemObject : Object = this.getRequestHashMap().get(basicItemData_AddFileValidationView.IMAGE)
            if (HttpFileUploadUtil.getInstance().isValid(imageFileItemObject)) {
                var fileItem : FileItem = imageFileItemObject.asInstanceOf[FileItem]
                var fileName : String = fileItem.getName()
                var size : Long = fileItem.getSize()
                HttpFileUploadUtil.log(fileItem)
                if (this.isValid(fileName, size) == _root_.java.lang.Boolean.FALSE) {
                    return _root_.java.lang.Boolean.FALSE
                }
            }
            return _root_.java.lang.Boolean.TRUE
        } catch {
            case e : Exception => {
                if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().VIEWERROR)) {
                    this.logUtil_AddFileValidationView.put("Exception in validation", this, this.commonStrings.IS_VALID, e)
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
        try {
            var stringBuffer : StringMaker = new StringMaker()
            var command : String = this.getRequestHashMap().get(GLOBALS2.ADMINCOMMAND).asInstanceOf[String]
            if (StringValidationUtil.getInstance().isEmpty(command) || ((command.compareTo(AddFileValidationView.ADDPRODUCT) != 0) && (command.compareTo(NEXTSTEP) != 0))) {
                return StringUtil.getInstance().EMPTY_STRING
            }
            var basicItemValidation : BasicItemValidation = new BasicItemValidation(this.itemInterface)
            if (basicItemValidation.isValid() == _root_.java.lang.Boolean.FALSE) {
                stringBuffer.append(basicItemValidation.validationInfo())
                stringBuffer.append("<br/>")
            }
            var storeFrontInterface : StoreFrontInterface = StoreFrontFactory.getInstance(this.getWeblisketSession().getStoreName())
            var fullCategory : String = new StringMaker().append(URLGLOBALS.getWebappPath()).append(storeFrontInterface.getCurrentHostNamePath()).append(this.itemInterface.getCategory()).toString()
            if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().VIEW)) {
                this.logUtil_AddFileValidationView.putF("Category: " + fullCategory, this, "validationInfo()")
            }
            var categoryFile : AbFile = AbFile.createAbFile(fullCategory)
            if (!categoryFile.isDirectory()) {
                stringBuffer.append("Category ")
                stringBuffer.append(this.itemInterface.getCategory())
                stringBuffer.append(" does not exist.<br />")
            }
            try {
                if (InventoryEntityFactory.getInstance().getInventoryEntityInstance().getItem(this.itemInterface.getId()) != null) {
                    stringBuffer.append("Id is already in use. Refresh the page for a valid id.<br/>")
                }
            } catch {
                case e : MoneyException => {
                    if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().VIEW)) {
                        this.logUtil_AddFileValidationView.putF("Existing Item With MoneyException", this, "validationInfo()")
                    }
                }
            }
            var anyType : Object = this.getRequestHashMap().get(basicItemData_AddFileValidationView.IMAGE)
            if (HttpFileUploadUtil.getInstance().isValid(anyType)) {
                var fileItem : FileItem = anyType.asInstanceOf[FileItem]
                var fileName : String = fileItem.getName()
                var fileItemFieldName : String = fileItem.getFieldName()
                var size : Long = fileItem.getSize()
                this.validationInfo(stringBuffer, fileName, fileItemFieldName, size)
            }
            return stringBuffer.toString()
        } catch {
            case e : Exception => {
                if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().VIEWERROR)) {
                    this.logUtil_AddFileValidationView.put("Failed to generate validation error info", this, "validationInfo()", e)
                }
                return "Error Getting Validation Info"
            }
        }
        throw new IllegalStateException()
    }

    private def isValid(fileName : String, size : Long) : _root_.java.lang.Boolean = {
        val fileData : FileData = FileData.getInstance()
        if (size > fileData.MINIMAGEFILESIZE) {
            if (size < fileData.MAXIMAGEFILESIZE) {
                if (!StringValidationUtil.getInstance().isValidRequired(fileName, fileData.MINLEN, fileData.MAXLEN)) {
                    return _root_.java.lang.Boolean.FALSE
                } else {
                    val pathData : AbPathData = AbPathData.getInstance()
                    val extension : String = pathData.getExtension(fileName)
                    val uploadMedia : UploadMediaSingleton = UploadMediaSingleton.getInstance()
                    if (!uploadMedia.isWriterSupported(extension) && !uploadMedia.isReaderSupported(extension)) {
                        return _root_.java.lang.Boolean.FALSE
                    }
                }
            } else {
                if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().VIEW)) {
                    val stringBuffer : StringMaker = new StringMaker()
                    stringBuffer.append("File Size To Large: ")
                    stringBuffer.appendlong(size)
                    stringBuffer.append(">")
                    stringBuffer.appendint(fileData.MAXIMAGEFILESIZE)
                    this.logUtil_AddFileValidationView.putF(stringBuffer.toString(), this, this.commonStrings.IS_VALID)
                }
                return _root_.java.lang.Boolean.FALSE
            }
            this.processImageFiles()
        } else {
            if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().VIEW)) {
                val stringBuffer : StringMaker = new StringMaker()
                stringBuffer.append("File Size To Small: ")
                stringBuffer.appendlong(size)
                stringBuffer.append(">")
                stringBuffer.appendint(fileData.MINIMAGEFILESIZE)
                this.logUtil_AddFileValidationView.putF(stringBuffer.toString(), this, this.commonStrings.IS_VALID)
            }
            return _root_.java.lang.Boolean.FALSE
        }
        return _root_.java.lang.Boolean.TRUE
    }

    private def validationInfo(stringBuffer : StringMaker, fileName : String, fileItemFieldName : String, size : Long) : Unit = {
        val fileData : FileData = FileData.getInstance()
        if (size > fileData.MINIMAGEFILESIZE) {
            if (fileItemFieldName.compareTo(basicItemData_AddFileValidationView.IMAGE) == 0) {
                if (size < fileData.MAXIMAGEFILESIZE) {
                    if (!StringValidationUtil.getInstance().isValidRequired(fileName, fileData.MINLEN, fileData.MAXLEN)) {
                        stringBuffer.append("FileName must be >")
                        stringBuffer.appendint(fileData.MINLEN)
                        stringBuffer.append(" and <")
                        stringBuffer.appendint(fileData.MAXLEN)
                        stringBuffer.append("<br/>")
                    } else {
                        val pathData : AbPathData = AbPathData.getInstance()
                        var extension : String = pathData.getExtension(fileName)
                        val uploadMedia : UploadMediaSingleton = UploadMediaSingleton.getInstance()
                        if (!uploadMedia.isWriterSupported(extension) && !uploadMedia.isReaderSupported(extension)) {
                            stringBuffer.append("Image type: ")
                            stringBuffer.append(extension)
                            stringBuffer.append(" not supported.<br />")
                        }
                    }
                } else {
                    stringBuffer.append("Image File Is To Large. ")
                    stringBuffer.appendint(fileData.MINIMAGEFILESIZE)
                    stringBuffer.append(" < > ")
                    stringBuffer.appendint(fileData.MAXIMAGEFILESIZE)
                    stringBuffer.append("<br/>")
                }
            }
        } else {
            stringBuffer.append("Image File Is To Small. ")
            stringBuffer.appendint(fileData.MINIMAGEFILESIZE)
            stringBuffer.append(" < > ")
            stringBuffer.appendint(fileData.MAXIMAGEFILESIZE)
            stringBuffer.append("<br/>")
        }
    }

    //Needed for polyglot do not remove
    override def getTransformInfoInterface() : TransformInfoInterface = {
        return super.getTransformInfoInterface()
    }

}

object AddFileValidationView {
    private val ADDPRODUCT : String = "Add Product"

    private val NEXTSTEP : String = CommonLabels.getInstance().NEXT + " Step"

}


