/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package admin.taghelpers

import _root_.java.util.HashMap
import _root_.org.allbinary.util.BasicArrayList
import _root_.org.allbinary.util.BasicArrayListD
import _root_.javax.servlet.jsp.PageContext
import _root_.admin.tags.AbTagData
import _root_.org.allbinary.business.user.commerce.inventory.item.BasicItemData
import _root_.org.allbinary.business.user.commerce.inventory.item.ItemInterface
import _root_.org.allbinary.data.tables.TableMappingInterface
import _root_.org.allbinary.data.tables.user.commerce.inventory.item.InventoryEntityFactory
import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.logic.string.StringMaker
import _root_.tags.HelperTag
import _root_.views.admin.inventory.InventoryItemView

class InventoryRequestHelper(param_propertiesHashMap : HashMap[Object, Object], param_pageContext : PageContext) extends ModifyTable {

    val logUtil : LogUtil = LogUtil.getInstance()

    val basicItemData : BasicItemData = BasicItemData.getInstance()

    //private final HttpServletRequest request;
    private var itemInterface : ItemInterface = null

    //Constructor
    {
        val propertiesHashMap : HashMap[Object, Object] = param_propertiesHashMap
        val pageContext : PageContext = param_pageContext
        //this.pageContext = pageContext;
        var inventoryTag : HelperTag = propertiesHashMap.get(AbTagData.PARENT).asInstanceOf[HelperTag]
        var itemView : InventoryItemView = InventoryItemViewParentTagHelper.getInstance().getInventoryItemView(inventoryTag)
        this.itemInterface = itemView.getItemInterface()
    }

    override def insert() : String = {
        try {
            var dataMappingInterface : TableMappingInterface = this.getItemInterface().asInstanceOf[TableMappingInterface]
            var values : BasicArrayList = dataMappingInterface.toVector()
            InventoryEntityFactory.getInstance().getInventoryEntityInstance().insert(values)
            var success : String = "Successfully Added Product"
            if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().SQLTAGS)) {
                this.logUtil.putF(success, this, "insert()")
            }
            return success
        } catch {
            case e : Exception => {
                var error : String = "Failed to add item to Inventory"
                if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().SQLTAGSERROR)) {
                    this.logUtil.put(this.commonStrings.EXCEPTION, this, "insert()", e)
                }
                return error
            }
        }
        throw new IllegalStateException()
    }

    override def delete() : String = {
        try {
            var dataMappingInterface : TableMappingInterface = this.getItemInterface().asInstanceOf[TableMappingInterface]
            var id : String = dataMappingInterface.getKey().asInstanceOf[String]
            InventoryEntityFactory.getInstance().getInventoryEntityInstance().deleteWhere(basicItemData.ID, id)
            var stringBuffer : StringMaker = new StringMaker()
            stringBuffer.append("Successfully Removed the item with ")
            stringBuffer.append(basicItemData.ID)
            stringBuffer.append("=")
            stringBuffer.append(id)
            stringBuffer.append(" from to the Inventory table")
            var success : String = stringBuffer.toString()
            if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().SQLTAGS)) {
                this.logUtil.putF(success, this, tagStrings.DO_START_TAG)
            }
            return success
        } catch {
            case e : Exception => {
                var error : String = "Failed to remove item with from Inventory"
                if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().SQLTAGSERROR)) {
                    this.logUtil.put(this.commonStrings.EXCEPTION, this, tagStrings.DO_START_TAG, e)
                }
                return error
            }
        }
        throw new IllegalStateException()
    }

    override def update() : String = {
        try {
            //TWB - JIQL has problem updated with commas so a short fix is to delete and then insert
            this.delete()
            this.insert()
            /*             TableMappingInterface dataMappingInterface =                 (TableMappingInterface) this.getItemInterface();              HashMap hashMap = dataMappingInterface.toHashMap();             InventoryEntityFactory.getInstance().getInventoryEntityInstance().update(hashMap);              String number = this.getItemInterface().getNumber();             if (number != null && !StringValidationUtil.isNumber(number))             {                 Long numberLong = new Long(number);                 long number_long = numberLong.longValue();                 if (number_long == 0)                 {                     //send event when product is unavailable                 } else if (number_long > 0)                 {                     //send event when product is unavailable                 } else                 {                     throw new Exception("Sanity Check On Number Of Items In Stock");                 }             }             */
            var success : String = "Item Successfully Updated"
            if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().SQLTAGS)) {
                this.logUtil.putF(success, this, "update()")
            }
            return success
        } catch {
            case e : Exception => {
                var error : String = "Failed To Update Item"
                if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().SQLTAGSERROR)) {
                    this.logUtil.put(this.commonStrings.EXCEPTION, this, "update()", e)
                }
                return error
            }
        }
        throw new IllegalStateException()
    }

    def getItemInterface() : ItemInterface = {
        return this.itemInterface
    }

}


