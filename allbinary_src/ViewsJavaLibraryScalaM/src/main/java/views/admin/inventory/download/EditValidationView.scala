/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package views.admin.inventory.download

import _root_.java.util.HashMap
import _root_.org.allbinary.util.BasicArrayList
import _root_.org.allbinary.util.BasicArrayListD
import _root_.org.allbinary.business.user.commerce.inventory.item.BasicItemData
import _root_.org.allbinary.business.user.commerce.inventory.item.download.DownloadItemData
import _root_.org.allbinary.business.user.commerce.inventory.item.download.DownloadableItem
import _root_.org.allbinary.business.user.commerce.money.MoneyException
import _root_.org.allbinary.data.tables.user.commerce.inventory.item.InventoryEntityFactory
import _root_.org.allbinary.data.tables.user.commerce.inventory.item.downloads.DownloadItemsEntity
import _root_.org.allbinary.data.tables.user.commerce.inventory.item.downloads.DownloadItemsEntityFactory
import _root_.org.allbinary.logic.communication.http.request.RequestParams
import _root_.org.allbinary.logic.control.validate.ValidationComponentInterface
import _root_.org.allbinary.logic.string.StringMaker
import _root_.org.allbinary.logic.string.StringUtil
import _root_.org.allbinary.logic.string.StringValidationUtil
import _root_.org.allbinary.logic.visual.transform.info.TransformInfoInterface
import _root_.org.w3c.dom.Document
import _root_.org.w3c.dom.Node

class EditValidationView(param_transformInfoInterface : TransformInfoInterface) extends DownloadableInventoryItemView(param_transformInfoInterface, StringUtil.getInstance().EMPTY_STRING) with ValidationComponentInterface {

    private var downloadItemId : String = null

    //Constructor
    {
        val transformInfoInterface : TransformInfoInterface = param_transformInfoInterface
        this.getFormData()
    }

    override def getFormData() : Unit = {
        var hashMap : HashMap[Object, Object] = new RequestParams(request).toHashMap().asInstanceOf[HashMap[Object, Object]]
        if (hashMap == null) {
            throw new Exception("No Request Params Found")
        }
        this.id = hashMap.get(basicItemData.ID).asInstanceOf[String]
        this.downloadItemId = hashMap.get(DownloadItemData.ID).asInstanceOf[String]
    }

    def isValid() : _root_.java.lang.Boolean = {
        if ((id == null) || !StringValidationUtil.getInstance().isNumber(this.id)) {
            return _root_.java.lang.Boolean.FALSE
        }
        this.itemInterface = InventoryEntityFactory.getInstance().getInventoryEntityInstance().getItem(this.id)
        if (this.itemInterface == null) {
            return _root_.java.lang.Boolean.FALSE
        }
        var downloadable : Int = Integer.parseInt(this.itemInterface.getDownloads())
        //Load downloadable Item if it is downloadable
        if (downloadable != 0) {
            var downloadItemsEntity : DownloadItemsEntity = DownloadItemsEntityFactory.getInstance().getDownloadItemsEntityInstance()
            var vector : BasicArrayList = downloadItemsEntity.getForItem(this.id, this.downloadItemId)
            if (vector.size() != 1) {
                return _root_.java.lang.Boolean.FALSE
            }
            this.downloadableItem = vector.get(0).asInstanceOf[DownloadableItem]
        } else {
            return _root_.java.lang.Boolean.FALSE
        }
        return _root_.java.lang.Boolean.TRUE
    }

    def toValidationInfoDoc() : Document = {
        return null
    }

    def toValidationInfoNode(document : Document) : Node = {
        return null
    }

    def validationInfo() : String = {
        var stringBuffer : StringMaker = new StringMaker()
        if ((this.id == null) || !StringValidationUtil.getInstance().isNumber(this.id)) {
            stringBuffer.append("Id is not valid.<br />")
        }
        if (InventoryEntityFactory.getInstance().getInventoryEntityInstance().getItem(this.id) == null) {
            stringBuffer.append("Item does not exist.<br />")
        }
        var downloadable : Int = Integer.parseInt(this.itemInterface.getDownloads())
        if (downloadable != 0) {
            if (this.downloadableItem == null) {
                stringBuffer.append("DownloadableItem does not exist for item.<br />")
            }
        } else {
            stringBuffer.append("Item should not have DownloadableItem.<br />")
        }
        return stringBuffer.toString()
    }

    //Needed for polyglot do not remove
    override def getTransformInfoInterface() : TransformInfoInterface = {
        return super.getTransformInfoInterface()
    }

}


