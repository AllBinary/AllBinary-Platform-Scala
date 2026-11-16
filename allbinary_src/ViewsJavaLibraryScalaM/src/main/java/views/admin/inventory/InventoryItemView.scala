/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package views.admin.inventory

import _root_.java.util.HashMap
import _root_.java.util.Set
import _root_.org.allbinary.util.BasicArrayList
import _root_.org.allbinary.util.BasicArrayListD
import _root_.javax.servlet.http.HttpServletRequest
import _root_.org.allbinary.business.context.modules.storefront.StoreFrontFactory
import _root_.org.allbinary.business.context.modules.storefront.StoreFrontInterface
import _root_.org.allbinary.business.user.commerce.inventory.item.BasicItem
import _root_.org.allbinary.business.user.commerce.inventory.item.BasicItemData
import _root_.org.allbinary.business.user.commerce.inventory.item.BasicItemView
import _root_.org.allbinary.business.user.commerce.inventory.item.ItemInterface
import _root_.org.allbinary.business.user.commerce.inventory.item.download.DownloadableItem
import _root_.org.allbinary.business.user.commerce.inventory.item.download.DownloadableItemView
import _root_.org.allbinary.logic.StdUtil
import _root_.org.allbinary.logic.communication.http.file.upload.HttpFileUploadUtil
import _root_.org.allbinary.logic.communication.http.request.HttpRequestUtil
import _root_.org.allbinary.logic.communication.http.request.MultipartRequestParams
import _root_.org.allbinary.logic.communication.http.request.RequestMapInterface
import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.logic.io.path.AbPathData
import _root_.org.allbinary.logic.io.path.PathUtil
import _root_.org.allbinary.logic.string.StringMaker
import _root_.org.allbinary.logic.visual.media.MediaData
import _root_.org.allbinary.logic.visual.transform.info.TransformInfoInterface
import _root_.org.apache.commons.fileupload.FileItem
import _root_.views.business.context.modules.storefront.HttpStoreComponentView

class InventoryItemView private (super_1 : TransformInfoInterface, constructor_ : Unit) extends HttpStoreComponentView(super_1) with RequestMapInterface {
    import _root_.views.admin.inventory.InventoryItemView.{*}

    val logUtil_InventoryItemView : LogUtil = LogUtil.getInstance()

    val basicItemData : BasicItemData = BasicItemData.getInstance()

    var request : HttpServletRequest = null

    private var imageFileName : String = null

    private var mediaData : MediaData = null

    var itemInterface : ItemInterface = null

    var downloadableItemVector : BasicArrayList = null

    private var requestHashMap : HashMap[Object, Object] = null

    //Hack TWB - Edit, New, Delete
    def this(transformInfoInterface : TransformInfoInterface, empty : String) = {
        this(transformInfoInterface, ())
        this.request = this.getPageContext().getRequest().asInstanceOf[HttpServletRequest]
    }

    def this(transformInfoInterface : TransformInfoInterface) = {
        this(transformInfoInterface, ())
        this.request = this.getPageContext().getRequest().asInstanceOf[HttpServletRequest]
        this.getFormData()
    }

    override def getTypeId() : Int = {
        return InventoryItemView.TYPE_ID
    }

    private def getFormData() : Unit = {
        this.setRequestHashMap(new MultipartRequestParams(this.request).toHashMap())
        var imageFileItemObject : Object = this.getRequestHashMap().get(basicItemData.IMAGE)
        if (HttpFileUploadUtil.getInstance().isValid(imageFileItemObject)) {
            var fileItem : FileItem = imageFileItemObject.asInstanceOf[FileItem]
            if ((fileItem != null) && (fileItem.getSize() > 1)) {
                this.imageFileName = HttpRequestUtil.getInstance().generateFileName(fileItem.getName())
                val pathData : AbPathData = AbPathData.getInstance()
                val pathUtil : PathUtil = PathUtil.getInstance()
                this.mediaData = MediaData.get(pathData.getExtension(this.imageFileName))
                this.imageFileName = pathUtil.getWithoutExtension(this.imageFileName)
                if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().VIEWERROR)) {
                    var stringBuffer : StringMaker = new StringMaker()
                    stringBuffer.append("Uploaded File Data: ")
                    stringBuffer.append(this.imageFileName)
                    stringBuffer.append(" Extension: ")
                    stringBuffer.append(this.mediaData.getName())
                    this.logUtil_InventoryItemView.putF(stringBuffer.toString(), this, "getFormData()")
                }
            }
        }
        this.itemInterface = (new BasicItem(this.getRequestHashMap())).asInstanceOf[ItemInterface]
    }

    def addDomNodeInterfaces() : Unit = {
        var vector : BasicArrayList = new BasicArrayListD()
        var downloadableItem : DownloadableItem = null
        val size : Int = this.downloadableItemVector.size()

        {
            var index : Int = 0
            while (index < size) {
                downloadableItem = this.downloadableItemVector.get(index).asInstanceOf[DownloadableItem]
                vector.add(new DownloadableItemView(downloadableItem))
                index += 1
            }
        }
        this.addDomNodeInterface(new BasicItemView(this.itemInterface, vector))
    }

    def getItemInterface() : ItemInterface = {
        return this.itemInterface
    }

    override def view() : String = {
        try {
            this.addDomNodeInterfaces()
            return super.view()
        } catch {
            case e : Exception => {
                if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().VIEWERROR)) {
                    this.logUtil_InventoryItemView.put(this.commonStrings.EXCEPTION, this, "view()", e)
                }
                throw e
            }
        }
        throw new IllegalStateException()
    }

    def processImageFiles() : Unit = {
        //Do not update image if file was not provided
        var set : Set[Object] = this.getRequestHashMap().keySet().asInstanceOf[Set[Object]]
        val fieldNameArray : Array[Object] = set.toArray()
        val size : Int = fieldNameArray.length

        {
            var index : Int = 0
            while (index < size) {
                var fieldName : String = fieldNameArray(index).asInstanceOf[String]
                if (fieldName.compareTo(basicItemData.IMAGE) == 0) {
                    var storeFrontInterface : StoreFrontInterface = StoreFrontFactory.getInstance(this.getWeblisketSession().getStoreName())
                    var inventoryUploadMediaUtil : InventoryUploadMediaUtil = new InventoryUploadMediaUtil(storeFrontInterface, this.itemInterface)
                    var fileItem : FileItem = this.getRequestHashMap().get(basicItemData.IMAGE).asInstanceOf[FileItem]
                    this.itemInterface = inventoryUploadMediaUtil.saveFiles(fileItem.get(), this.imageFileName, this.mediaData)
                }
                index += 1
            }
        }
    }

    private def setRequestHashMap(requestHashMap : HashMap[Object, Object]) : Unit = {
        this.requestHashMap = requestHashMap
    }

    def getRequestHashMap() : HashMap[Object, Object] = {
        return this.requestHashMap
    }

}

object InventoryItemView {
    var TYPE_ID : Int = 10

}


