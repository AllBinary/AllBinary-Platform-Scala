/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package admin.taghelpers

import _root_.java.util.HashMap
import _root_.org.allbinary.util.BasicArrayList
import _root_.org.allbinary.util.BasicArrayListD
import _root_.javax.servlet.jsp.PageContext
import _root_.admin.tags.AbTagData
import _root_.org.allbinary.business.user.commerce.inventory.item.download.DownloadableItem
import _root_.org.allbinary.data.tables.user.commerce.inventory.item.downloads.DownloadItemsEntityFactory
import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.string.CommonSeps
import _root_.tags.HelperTag
import _root_.views.admin.inventory.download.DownloadableInventoryItemView

class DownloadItemsRequestHelper(param_hashMap : HashMap[Object, Object], param_pageContext : PageContext) extends ModifyTable {

    val logUtil : LogUtil = LogUtil.getInstance()

    private var downloadableItem : DownloadableItem = null

    //Constructor
    {
        val hashMap : HashMap[Object, Object] = param_hashMap
        val pageContext : PageContext = param_pageContext
        var inventoryTag : HelperTag = hashMap.get(AbTagData.PARENT).asInstanceOf[HelperTag]
        var inventoryItemViewParentTagHelper : InventoryItemViewParentTagHelper = InventoryItemViewParentTagHelper.getInstance()
        var downloadableInventoryItemView : DownloadableInventoryItemView = inventoryItemViewParentTagHelper.getDownloadableInventoryItemView(inventoryTag)
        this.downloadableItem = downloadableInventoryItemView.getDownloadableItem()
    }

    override def insert() : String = {
        try {
            var vector : BasicArrayList = this.downloadableItem.toVector()
            DownloadItemsEntityFactory.getInstance().getDownloadItemsEntityInstance().insert(vector)
            var success : String = ("Successfully inserted " + this.downloadableItem.getId()) + " into downloaditems table"
            if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().SQLTAGS)) {
                this.logUtil.putF(success, this, "insert()")
            }
            return success
        } catch {
            case e : Exception => {
                var error : String = ("Failed to insert " + this.downloadableItem.getId()) + " into downloaditems table"
                if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().SQLTAGSERROR)) {
                    this.logUtil.put(this.commonStrings.EXCEPTION, this, "inserts()", e)
                }
                return error
            }
        }
        throw new IllegalStateException()
    }

    override def delete() : String = {
        try {
            DownloadItemsEntityFactory.getInstance().getDownloadItemsEntityInstance().delete(this.downloadableItem.getId())
            var success : String = "Successfully deleted"
            if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().SQLTAGS)) {
                this.logUtil.putF(success, this, "delete()")
            }
            return success
        } catch {
            case e : Exception => {
                var error : String = "Failed to delete"
                if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().SQLTAGSERROR)) {
                    this.logUtil.put(this.commonStrings.EXCEPTION, this, "delete()", e)
                }
                return error
            }
        }
        throw new IllegalStateException()
    }

    override def update() : String = {
        try {
            var success : String = "Update Successful"
            var values : HashMap[Object, Object] = this.downloadableItem.toHashMap().asInstanceOf[HashMap[Object, Object]]
            DownloadItemsEntityFactory.getInstance().getDownloadItemsEntityInstance().update(values)
            if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().SQLTAGS)) {
                this.logUtil.putF((this.downloadableItem.getId() + CommonSeps.getInstance().SPACE) + success, this, "update()")
            }
            return success
        } catch {
            case e : Exception => {
                var error : String = "Failed to update: " + this.downloadableItem.getId()
                if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().SQLTAGSERROR)) {
                    this.logUtil.put(this.commonStrings.EXCEPTION, this, "update()", e)
                }
                return error
            }
        }
        throw new IllegalStateException()
    }

}


