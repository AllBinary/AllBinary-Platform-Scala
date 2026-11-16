/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package views.admin.inventory.download

import _root_.java.util.HashMap
import _root_.org.allbinary.business.context.modules.storefront.StoreFrontFactory
import _root_.org.allbinary.business.context.modules.storefront.StoreFrontInterface
import _root_.org.allbinary.business.user.commerce.inventory.item.BasicItemData
import _root_.org.allbinary.business.user.commerce.inventory.item.BasicItemValidation
import _root_.org.allbinary.business.user.commerce.inventory.item.download.DownloadItemData
import _root_.org.allbinary.business.user.commerce.inventory.item.download.DownloadableItem
import _root_.org.allbinary.business.user.commerce.inventory.item.download.DownloadableItemValidation
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
import _root_.org.allbinary.logic.string.StringUtil
import _root_.org.allbinary.logic.string.StringValidationUtil
import _root_.org.allbinary.logic.visual.transform.info.TransformInfoInterface
import _root_.org.allbinary.string.CommonStrings
import _root_.org.apache.commons.fileupload.FileItem
import _root_.org.w3c.dom.Document
import _root_.org.w3c.dom.Node

class UpdateFileValidationView(param_transformInfoInterface : TransformInfoInterface) extends DownloadableInventoryItemView(param_transformInfoInterface) with ValidationComponentInterface {

    val logUtil_UpdateFileValidationView : LogUtil = LogUtil.getInstance()

    private val commonStrings_UpdateFileValidationView : CommonStrings = CommonStrings.getInstance()

    //Constructor
    {
        val transformInfoInterface : TransformInfoInterface = param_transformInfoInterface
    }

    def isValid() : _root_.java.lang.Boolean = {
        try {
            var command : String = this.getRequestHashMap().get(GLOBALS2.ADMINCOMMAND).asInstanceOf[String]
            if (StringValidationUtil.getInstance().isEmpty(command) || (command.compareTo(this.commonStrings_UpdateFileValidationView.UPDATE) != 0)) {
                if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().VIEW)) {
                    this.logUtil_UpdateFileValidationView.putF("Invalid AdminCommand=" + command, this, this.commonStrings_UpdateFileValidationView.IS_VALID)
                }
                return _root_.java.lang.Boolean.FALSE
            }
            try {
                var inventoryEntity : InventoryEntity = InventoryEntityFactory.getInstance().getInventoryEntityInstance()
                this.itemInterface = inventoryEntity.getItem(this.id)
            } catch {
                case e : MoneyException => {
                    if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().VIEW)) {
                        this.logUtil_UpdateFileValidationView.put("Existing Item With MoneyException", this, this.commonStrings_UpdateFileValidationView.IS_VALID, e)
                    }
                }
            }
            if (this.itemInterface == null) {
                if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().VIEW)) {
                    this.logUtil_UpdateFileValidationView.putF("Item Does Not Exist", this, this.commonStrings_UpdateFileValidationView.IS_VALID)
                }
                return _root_.java.lang.Boolean.FALSE
            }
            if (new BasicItemValidation(this.itemInterface).isValid() == _root_.java.lang.Boolean.FALSE) {
                if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().VIEW)) {
                    this.logUtil_UpdateFileValidationView.putF("BasicItem is not valid", this, this.commonStrings_UpdateFileValidationView.IS_VALID)
                }
                return _root_.java.lang.Boolean.FALSE
            }
            var storeFrontInterface : StoreFrontInterface = StoreFrontFactory.getInstance(this.getWeblisketSession().getStoreName())
            //+ this.itemInterface.getCategory());
            var fullCategory : String = new StringMaker().append(URLGLOBALS.getWebappPath()).append(storeFrontInterface.getCurrentHostNamePath()).append(this.itemInterface.getCategory()).toString()
            //storeFrontInterface.getCategoryPath()
            var categoryFile : AbFile = AbFile.createAbFile(fullCategory)
            if (!categoryFile.isDirectory()) {
                if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().VIEW)) {
                    this.logUtil_UpdateFileValidationView.putF("Category Does Not Exist: " + fullCategory, this, this.commonStrings_UpdateFileValidationView.IS_VALID)
                }
                return _root_.java.lang.Boolean.FALSE
            }
            var downloadableFileObject : Object = this.getRequestHashMap().get(DownloadItemData.FILE)
            if (HttpFileUploadUtil.getInstance().isValid(downloadableFileObject)) {
                var fileItem : FileItem = downloadableFileObject.asInstanceOf[FileItem]
                var fileName : String = fileItem.getName()
                var size : Long = fileItem.getSize()
                HttpFileUploadUtil.log(fileItem)
                if (this.isValid(fileName, size) == _root_.java.lang.Boolean.FALSE) {
                    return _root_.java.lang.Boolean.FALSE
                } else {
                    //this.processFile(DownloadItemData.FILE);
                    this.processFile(fileItem)
                    this.getRequestHashMap().put(DownloadItemData.SIZE, _root_.java.lang.Long.toString(size))
                }
            } else {
                this.getRequestHashMap().remove(DownloadItemData.FILE)
            }
            var licenseFileObject : Object = this.getRequestHashMap().get(DownloadItemData.LICENSE_FILE)
            if (HttpFileUploadUtil.getInstance().isValid(licenseFileObject)) {
                var fileItem : FileItem = licenseFileObject.asInstanceOf[FileItem]
                var fileName : String = fileItem.getName()
                var size : Long = fileItem.getSize()
                HttpFileUploadUtil.log(fileItem)
                if (this.isValid(fileName, size) == _root_.java.lang.Boolean.FALSE) {
                } else {
                    this.processFile(fileItem)
                }
            } else {
                this.getRequestHashMap().remove(DownloadItemData.LICENSE_FILE)
            }
            var extraFilesObject : Object = this.getRequestHashMap().get(DownloadItemData.EXTRA_FILES)
            if (HttpFileUploadUtil.getInstance().isValid(extraFilesObject)) {
                var fileItem : FileItem = extraFilesObject.asInstanceOf[FileItem]
                var fileName : String = fileItem.getName()
                var size : Long = fileItem.getSize()
                HttpFileUploadUtil.log(fileItem)
                if (this.isValid(fileName, size) == _root_.java.lang.Boolean.FALSE) {
                } else {
                    this.processFile(fileItem)
                    this.unzip(fileItem)
                }
            } else {
                this.getRequestHashMap().remove(DownloadItemData.EXTRA_FILES)
            }
            var hashMap : HashMap[Object, Object] = this.getRequestHashMap().asInstanceOf[HashMap[Object, Object]]
            hashMap.put(basicItemData.ID, this.itemInterface.getId())
            var licenseObject : Object = hashMap.get(DownloadItemData.LICENSE_FILE)
            if (licenseObject != null) {
                hashMap.put(DownloadItemData.LICENSE_FILE, (licenseObject.asInstanceOf[FileItem]).getName())
            } else {
                hashMap.put(DownloadItemData.LICENSE_FILE, StringUtil.getInstance().EMPTY_STRING)
            }
            var fileObject : Object = hashMap.get(DownloadItemData.FILE)
            if (fileObject != null) {
                hashMap.put(DownloadItemData.FILE, (fileObject.asInstanceOf[FileItem]).getName())
            } else {
                hashMap.put(DownloadItemData.FILE, StringUtil.getInstance().EMPTY_STRING)
            }
            this.downloadableItem = new DownloadableItem(hashMap)
            var downloadableItemValidation : DownloadableItemValidation = new DownloadableItemValidation(this.downloadableItem)
            if (downloadableItemValidation.isValid() == _root_.java.lang.Boolean.FALSE) {
                if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().VIEW)) {
                    this.logUtil_UpdateFileValidationView.putF("DownloadableItem is not valid", this, this.commonStrings_UpdateFileValidationView.IS_VALID)
                }
                return _root_.java.lang.Boolean.FALSE
            }
            return _root_.java.lang.Boolean.TRUE
        } catch {
            case e : Exception => {
                if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().VIEWERROR)) {
                    this.logUtil_UpdateFileValidationView.put("Exception in validation", this, this.commonStrings_UpdateFileValidationView.IS_VALID, e)
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
            if (StringValidationUtil.getInstance().isEmpty(command) || (command.compareTo(this.commonStrings_UpdateFileValidationView.UPDATE) != 0)) {
                //stringBuffer.append("Invalid Command<br/>");
                return StringUtil.getInstance().EMPTY_STRING
            }
            if (this.itemInterface == null) {
                val ITEM_NOT_FOUND : String = "Item Does Not Exist"
                if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().VIEW)) {
                    this.logUtil_UpdateFileValidationView.putF(ITEM_NOT_FOUND, this, "validationInfo()")
                }
                return ITEM_NOT_FOUND
            }
            var basicItemValidation : BasicItemValidation = new BasicItemValidation(this.itemInterface)
            if (basicItemValidation.isValid() == _root_.java.lang.Boolean.FALSE) {
                stringBuffer.append(basicItemValidation.validationInfo())
                stringBuffer.append("<br/>")
            }
            var storeFrontInterface : StoreFrontInterface = StoreFrontFactory.getInstance(this.getWeblisketSession().getStoreName())
            var fullCategory : String = new StringMaker().append(URLGLOBALS.getWebappPath()).append(storeFrontInterface.getCurrentHostNamePath()).append(this.itemInterface.getCategory()).toString()
            if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().VIEW)) {
                this.logUtil_UpdateFileValidationView.putF("Category: " + fullCategory, this, "validationInfo()")
            }
            var categoryFile : AbFile = AbFile.createAbFile(fullCategory)
            if (!categoryFile.isDirectory()) {
                stringBuffer.append("Category ")
                stringBuffer.append(this.itemInterface.getCategory())
                stringBuffer.append(" does not exist.")
                stringBuffer.append("<br />")
            }
            var downloadableFileObject : Object = this.getRequestHashMap().get(DownloadItemData.FILE)
            if (HttpFileUploadUtil.getInstance().isValid(downloadableFileObject)) {
                var fileItem : FileItem = downloadableFileObject.asInstanceOf[FileItem]
                var fileName : String = fileItem.getName()
                var size : Long = fileItem.getSize()
                this.validationInfo(stringBuffer, fileName, size)
            } else {
                stringBuffer.append("Download File Missing")
                stringBuffer.append("<br/>")
            }
            var licenseFileObject : Object = this.getRequestHashMap().get(DownloadItemData.LICENSE_FILE)
            if (HttpFileUploadUtil.getInstance().isValid(licenseFileObject)) {
                var fileItem : FileItem = licenseFileObject.asInstanceOf[FileItem]
                var fileName : String = fileItem.getName()
                var size : Long = fileItem.getSize()
                this.validationInfo(stringBuffer, fileName, size)
            } else {
            }
            var extraFilesObject : Object = this.getRequestHashMap().get(DownloadItemData.EXTRA_FILES)
            if (HttpFileUploadUtil.getInstance().isValid(extraFilesObject)) {
                var fileItem : FileItem = extraFilesObject.asInstanceOf[FileItem]
                var fileName : String = fileItem.getName()
                var size : Long = fileItem.getSize()
                this.validationInfo(stringBuffer, fileName, size)
            } else {
            }
            if (this.downloadableItem != null) {
                var downloadableItemValidation : DownloadableItemValidation = new DownloadableItemValidation(this.downloadableItem)
                if (downloadableItemValidation.isValid() == _root_.java.lang.Boolean.FALSE) {
                    val log : String = downloadableItemValidation.validationInfo()
                    if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().VIEW)) {
                        this.logUtil_UpdateFileValidationView.putF(log, this, this.commonStrings_UpdateFileValidationView.IS_VALID)
                    }
                    stringBuffer.append(log)
                    stringBuffer.append("<br/>")
                }
            }
            return stringBuffer.toString()
        } catch {
            case e : Exception => {
                if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().VIEWERROR)) {
                    this.logUtil_UpdateFileValidationView.put("Failed to generate validation error info", this, "validationInfo()", e)
                }
                return "Error Getting Validation Info"
            }
        }
        throw new IllegalStateException()
    }

    private def isValid(fileName : String, size : Long) : _root_.java.lang.Boolean = {
        var fileData : FileData = FileData.getInstance()
        if (size > fileData.MINDOWNLOADABLEFILESIZE) {
            if (size < fileData.MAXDOWNLOADABLEFILESIZE) {
                if (!StringValidationUtil.getInstance().isValidRequired(fileName, fileData.MINLEN, fileData.MAXLEN)) {
                    if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().VIEW)) {
                        var stringBuffer : StringMaker = new StringMaker()
                        stringBuffer.append("File name is not valid: ")
                        stringBuffer.append(fileName)
                        this.logUtil_UpdateFileValidationView.putF(stringBuffer.toString(), this, this.commonStrings_UpdateFileValidationView.IS_VALID)
                    }
                    return _root_.java.lang.Boolean.FALSE
                } else {
                }
            } else {
                if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().VIEW)) {
                    var stringBuffer : StringMaker = new StringMaker()
                    stringBuffer.append("File Size To Large: ")
                    stringBuffer.appendlong(size)
                    stringBuffer.append(">")
                    stringBuffer.appendint(fileData.MAXDOWNLOADABLEFILESIZE)
                    this.logUtil_UpdateFileValidationView.putF(stringBuffer.toString(), this, this.commonStrings_UpdateFileValidationView.IS_VALID)
                }
                return _root_.java.lang.Boolean.FALSE
            }
        } else {
            if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().VIEW)) {
                var stringBuffer : StringMaker = new StringMaker()
                stringBuffer.append("File Size To Small: ")
                stringBuffer.appendlong(size)
                stringBuffer.append(">")
                stringBuffer.appendint(fileData.MINDOWNLOADABLEFILESIZE)
                this.logUtil_UpdateFileValidationView.putF(stringBuffer.toString(), this, this.commonStrings_UpdateFileValidationView.IS_VALID)
            }
            return _root_.java.lang.Boolean.FALSE
        }
        return _root_.java.lang.Boolean.TRUE
    }

    private def validationInfo(stringBuffer : StringMaker, fileName : String, size : Long) : Unit = {
        var fileData : FileData = FileData.getInstance()
        if (size > fileData.MINDOWNLOADABLEFILESIZE) {
            if (size < fileData.MAXDOWNLOADABLEFILESIZE) {
                if (!StringValidationUtil.getInstance().isValidRequired(fileName, fileData.MINLEN, fileData.MAXLEN)) {
                    stringBuffer.append("File Name must be more than ")
                    stringBuffer.appendint(fileData.MINLEN)
                    stringBuffer.append(" and less than ")
                    stringBuffer.appendint(fileData.MAXLEN)
                    stringBuffer.append(" characters in length: ")
                    stringBuffer.append(fileName)
                    stringBuffer.append("<br/>")
                } else {
                }
            } else {
                stringBuffer.append("File Is Not The Right Size. ")
                stringBuffer.appendint(fileData.MINDOWNLOADABLEFILESIZE)
                stringBuffer.append("< >")
                stringBuffer.appendint(fileData.MAXDOWNLOADABLEFILESIZE)
                stringBuffer.append("<br/>")
            }
        }
    }

    //Needed for polyglot do not remove
    override def getTransformInfoInterface() : TransformInfoInterface = {
        return super.getTransformInfoInterface()
    }

}


