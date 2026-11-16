/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package views.admin.inventory

import _root_.java.util.HashMap
import _root_.org.allbinary.business.user.commerce.inventory.item.BasicItemData
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

class EditValidationView(param_transformInfoInterface : TransformInfoInterface) extends InventoryItemView(param_transformInfoInterface, StringUtil.getInstance().EMPTY_STRING) with ValidationComponentInterface {

    //private TransformInfoInterface transformInfoInterface;
    private var id_EditValidationView : String = null

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
        this.id_EditValidationView = hashMap.get(basicItemData.ID).asInstanceOf[String]
    }

    def isValid() : _root_.java.lang.Boolean = {
        if ((this.id_EditValidationView == null) || !StringValidationUtil.getInstance().isNumber(this.id_EditValidationView)) {
            return _root_.java.lang.Boolean.FALSE
        }
        this.itemInterface = InventoryEntityFactory.getInstance().getInventoryEntityInstance().getItem(this.id_EditValidationView)
        if (this.itemInterface == null) {
            return _root_.java.lang.Boolean.FALSE
        }
        var downloadable : Int = Integer.parseInt(this.itemInterface.getDownloads())
        //Load downloadable Item if it is downloadable
        if (downloadable != 0) {
            var downloadItemsEntity : DownloadItemsEntity = DownloadItemsEntityFactory.getInstance().getDownloadItemsEntityInstance()
            this.downloadableItemVector = downloadItemsEntity.getForItem(this.itemInterface.getId())
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
        if ((this.id_EditValidationView == null) || !StringValidationUtil.getInstance().isNumber(this.id_EditValidationView)) {
            stringBuffer.append("Id is not valid.<br />")
        }
        if (InventoryEntityFactory.getInstance().getInventoryEntityInstance().getItem(this.id_EditValidationView) == null) {
            stringBuffer.append("Item does not exist.<br />")
        }
        return stringBuffer.toString()
    }

    //Needed for polyglot do not remove
    override def getTransformInfoInterface() : TransformInfoInterface = {
        return super.getTransformInfoInterface()
    }

}


