/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package views.admin.inventory.download

import _root_.java.io.ByteArrayInputStream
import _root_.java.util.HashMap
import _root_.org.allbinary.util.BasicArrayList
import _root_.org.allbinary.util.BasicArrayListD
import _root_.javax.servlet.http.HttpServletRequest
import _root_.org.allbinary.business.context.modules.storefront.StoreFrontFactory
import _root_.org.allbinary.business.context.modules.storefront.StoreFrontInterface
import _root_.org.allbinary.business.user.commerce.inventory.item.BasicItemData
import _root_.org.allbinary.business.user.commerce.inventory.item.BasicItemView
import _root_.org.allbinary.business.user.commerce.inventory.item.ItemInterface
import _root_.org.allbinary.business.user.commerce.inventory.item.download.DownloadableItem
import _root_.org.allbinary.business.user.commerce.inventory.item.download.DownloadableItemView
import _root_.org.allbinary.globals.URLGLOBALS
import _root_.org.allbinary.logic.StdUtil
import _root_.org.allbinary.logic.communication.http.request.MultipartRequestParams
import _root_.org.allbinary.logic.communication.http.request.RequestMapInterface
import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.logic.io.file.AbFile
import _root_.org.allbinary.logic.io.file.FilePathData
import _root_.org.allbinary.logic.io.file.FileUtil
import _root_.org.allbinary.logic.io.file.zip.ZipFileUtil
import _root_.org.allbinary.logic.string.StringMaker
import _root_.org.allbinary.logic.visual.transform.info.TransformInfoInterface
import _root_.org.apache.commons.fileupload.FileItem
import _root_.views.business.context.modules.storefront.HttpStoreComponentView

class DownloadableInventoryItemView private (super_1 : TransformInfoInterface, constructor_ : Unit) extends HttpStoreComponentView(super_1) with RequestMapInterface {
    import _root_.views.admin.inventory.download.DownloadableInventoryItemView.{*}

    val logUtil_DownloadableInventoryItemView : LogUtil = LogUtil.getInstance()

    val basicItemData : BasicItemData = BasicItemData.getInstance()

    var request : HttpServletRequest = null

    var id : String = null

    var itemInterface : ItemInterface = null

    var downloadableItem : DownloadableItem = null

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
        return DownloadableInventoryItemView.TYPE_ID
    }

    private def getFormData() : Unit = {
        this.setRequestHashMap(new MultipartRequestParams(this.request).toHashMap())
        this.id = this.getRequestHashMap().get(basicItemData.ID).asInstanceOf[String]
    }

    def addDomNodeInterfaces() : Unit = {
        var vector : BasicArrayList = new BasicArrayListD()
        if (this.downloadableItem != null) {
            vector.add(new DownloadableItemView(this.downloadableItem))
        }
        this.addDomNodeInterface(new BasicItemView(this.itemInterface, vector))
    }

    override def view() : String = {
        try {
            this.addDomNodeInterfaces()
            return super.view()
        } catch {
            case e : Exception => {
                if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().VIEWERROR)) {
                    this.logUtil_DownloadableInventoryItemView.put(this.commonStrings.EXCEPTION, this, "view()", e)
                }
                throw e
            }
        }
        throw new IllegalStateException()
    }

    /*     protected void processFile(String fileKey) throws Exception     {     //Do not update image if file was not provided     final Set set = this.getRequestHashMap().keySet();     iter = set;     while (iter.hasNext())     {     String fieldName = (String) iter.next();      if (fieldName.compareTo(fileKey) == 0)     {     FileItem fileItem = (FileItem)     this.getRequestHashMap().get(fileKey);      this.processFile(fileItem);      //byteArray.length;     }     //if(!imageFile.isFile()) throw new Exception("Image File Did Not Save");     }     //return new int;     }      */
    def processFile(fileItem : FileItem) : Unit = {
        val fileName : String = fileItem.getName()
        val fullPath : String = this.getItemFilePath()
        //Make inventory item resource directory if not already there
        val itemResourceFile : AbFile = AbFile.createAbFile(fullPath)
        itemResourceFile.mkdir()
        val stringBuffer : StringMaker = new StringMaker()
        stringBuffer.append(fullPath)
        stringBuffer.append(fileName)
        this.logUtil_DownloadableInventoryItemView.putF("FileName: " + fileName, this, "processFile()")
        val file : AbFile = AbFile.createAbFile(stringBuffer.toString())
        this.logUtil_DownloadableInventoryItemView.putF(file.getPath(), this, "processFiles()")
        file.createNewFile()
        var byteArray : Array[Byte] = fileItem.get()
        FileUtil.getInstance().write(new ByteArrayInputStream(byteArray), file)
    }

    def unzip(fileItem : FileItem) : Unit = {
        val fileName : String = fileItem.getName()
        val fullPath : String = this.getItemFilePath()
        //AbFile itemResourceFile = AbFile.createAbFile(fullPath);
        val stringBuffer : StringMaker = new StringMaker()
        stringBuffer.append(fullPath)
        stringBuffer.append(fileName)
        this.logUtil_DownloadableInventoryItemView.putF("FileName: " + fileName, this, "unzip()")
        val file : AbFile = AbFile.createAbFile(stringBuffer.toString())
        this.logUtil_DownloadableInventoryItemView.putF(file.getPath(), this, "unzip()")
        ZipFileUtil.getInstance().unzip(fullPath, file, fileName)
    }

    private def getItemFilePath() : String = {
        val storeFrontInterface : StoreFrontInterface = StoreFrontFactory.getInstance(this.getWeblisketSession().getStoreName())
        val filePathData : FilePathData = FilePathData.getInstance()
        val stringBuffer : StringMaker = new StringMaker()
        stringBuffer.append(URLGLOBALS.getWebappPath())
        stringBuffer.append(storeFrontInterface.getCurrentHostNamePath())
        stringBuffer.append(this.itemInterface.getCategory())
        stringBuffer.appendchar(filePathData.SEPARATORCHAR)
        stringBuffer.append(this.itemInterface.getId())
        stringBuffer.appendchar(filePathData.SEPARATORCHAR)
        stringBuffer.append(this.downloadableItem.getId())
        stringBuffer.appendchar(filePathData.SEPARATORCHAR)
        return stringBuffer.toString()
    }

    private def setRequestHashMap(requestHashMap : HashMap[Object, Object]) : Unit = {
        this.requestHashMap = requestHashMap
    }

    def getRequestHashMap() : HashMap[Object, Object] = {
        return this.requestHashMap
    }

    /**      * @return the downloadableItem      */
    def getDownloadableItem() : DownloadableItem = {
        return this.downloadableItem
    }

}

object DownloadableInventoryItemView {
    var TYPE_ID : Int = 11

}


