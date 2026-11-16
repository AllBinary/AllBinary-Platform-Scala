/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.data.tables.user.commerce.inventory.item

import _root_.java.util.HashMap
import _root_.org.allbinary.util.BasicArrayList
import _root_.org.allbinary.util.BasicArrayListD
import _root_.org.allbinary.business.context.modules.storefront.StoreFrontInterface
import _root_.org.allbinary.business.entry.EntryData
import _root_.org.allbinary.business.init.db.InventoryDbInitInfo
import _root_.org.allbinary.business.user.commerce.inventory.item.BasicItem
import _root_.org.allbinary.business.user.commerce.inventory.item.BasicItemData
import _root_.org.allbinary.business.user.commerce.inventory.item.ItemInterface
import _root_.org.allbinary.business.user.commerce.money.MoneyException
import _root_.org.allbinary.logic.StdUtil
import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.logic.communication.sql.AbSqlBean
import _root_.org.allbinary.logic.string.StringMaker
import _root_.org.allbinary.logic.string.StringValidationUtil

class InventoryEntity() extends AbSqlBean(new InventoryDbInitInfo()) with InventoryEntityInterface {

    val logUtil_InventoryEntity : LogUtil = LogUtil.getInstance()

    val basicItemData : BasicItemData = BasicItemData.getInstance()

    private val tableName : String = "basicinventory"

    //Constructor
    {
        this.setTableName(this.tableName)
    }

    override def insert(values : BasicArrayList) : Unit = {
        try {
            super.insert(values)
            if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().SQLLOGGING)) {
                this.logUtil_InventoryEntity.putF(this.commonStrings.SUCCESS, this, INSERT)
            }
        } catch {
            case e : Exception => {
                if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().SQLLOGGING)) {
                    this.logUtil_InventoryEntity.put(this.commonStrings.FAILURE, this, INSERT, e)
                }
            }
        }
    }

    def delete(value : String) : Unit = {
        try {
            super.deleteWhere(basicItemData.ID, value)
            if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().SQLLOGGING)) {
                this.logUtil_InventoryEntity.putF(this.commonStrings.SUCCESS, this, this.commonStrings.delete)
            }
        } catch {
            case e : Exception => {
                if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().SQLLOGGING)) {
                    this.logUtil_InventoryEntity.put(this.commonStrings.FAILURE, this, this.commonStrings.delete, e)
                }
            }
        }
    }

    //I could create a factory to output the results that excepts a productId and xslt file
    def getItems(storeFrontInterface : StoreFrontInterface) : BasicArrayList = {
        if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().SQLLOGGING)) {
            this.logUtil_InventoryEntity.putF("Getting Items For: " + storeFrontInterface.getName(), this, "getItems")
        }
        var itemVector : BasicArrayList = new BasicArrayListD()
        var keysAndValues : HashMap[Object, Object] = StdUtil.getInstance().createHashMap().asInstanceOf[HashMap[Object, Object]]
        ///////////
        var itemHashMapVector : BasicArrayList = super.getRows(keysAndValues)
        var size : Int = itemHashMapVector.size()

        {
            var i : Int = 0
            while (i < size) {
                var itemHashMap : HashMap[Object, Object] = itemHashMapVector.get(i).asInstanceOf[HashMap[Object, Object]]
                if (itemHashMap != null) {
                    //TWB - GAE upgrade uses JIQL and it doesn't like LIKE in the SQL so I fixed it
                    var category : String = itemHashMap.get(basicItemData.CATEGORY).asInstanceOf[String]
                    if (!StringValidationUtil.getInstance().isEmpty(category) && category.startsWith(storeFrontInterface.getCategoryPath())) {
                        itemVector.add(new BasicItem(itemHashMap))
                    }
                }
                i += 1
            }
        }
        return itemVector
    }

    //I could create a factory to output the results that excepts a productId and xslt file
    def getItem(id : String) : ItemInterface = {
        var keysAndValues : HashMap[Object, Object] = StdUtil.getInstance().createHashMap().asInstanceOf[HashMap[Object, Object]]
        keysAndValues.put(basicItemData.ID, id)
        var itemHashMap : HashMap[Object, Object] = super.getRow(keysAndValues).asInstanceOf[HashMap[Object, Object]]
        if (itemHashMap != null) {
            return new BasicItem(itemHashMap)
        } else {
            return null
        }
        throw new IllegalStateException()
    }

    def getWeight(id : String) : String = {
        return super.getField(basicItemData.ID, id, basicItemData.WEIGHT)
    }

    /*     public String getTable(String itemId)     {     return super.getTableWhere(basicItemData.ID,itemId);     }      */
    final def createTableStatement() : String = {
        var stringBuffer : StringMaker = new StringMaker()
        stringBuffer.append(this.sqlStrings.CREATE_TABLE)
        stringBuffer.append(this.tableName)
        stringBuffer.append(this.sqlStrings.START)
        stringBuffer.append(basicItemData.ID)
        stringBuffer.append(this.sqlTypeStrings.MAX_BIG_INT_UNSIGNED_NOT_NULL)
        stringBuffer.append(basicItemData.NUMBER)
        stringBuffer.append(this.sqlTypeStrings.MAX_BIG_INT_UNSIGNED_NOT_NULL)
        stringBuffer.append(basicItemData.INBASKETS)
        stringBuffer.append(this.sqlTypeStrings.MAX_BIG_INT_UNSIGNED_NOT_NULL)
        stringBuffer.append(basicItemData.WEIGHT)
        //stringBuffer.append(" DECIMAL (11,2) NOT NULL,");
        stringBuffer.append(" VARCHAR(20) NOT NULL,")
        stringBuffer.append(EntryData.getInstance().ENABLE)
        stringBuffer.append(this.sqlTypeStrings.MAX_CHAR_COLUMN_NOT_NULL)
        stringBuffer.append(basicItemData.NEWORUSED)
        stringBuffer.append(this.sqlTypeStrings.MAX_CHAR_COLUMN_NOT_NULL)
        stringBuffer.append(basicItemData.SUMMARY)
        stringBuffer.append(this.sqlTypeStrings.MAX_CHAR_COLUMN_NOT_NULL)
        stringBuffer.append(basicItemData.DISTRIBUTOR)
        stringBuffer.append(this.sqlTypeStrings.MAX_CHAR_COLUMN_NOT_NULL)
        stringBuffer.append(basicItemData.IDUSEDBYDISTRIBUTOR)
        stringBuffer.append(this.sqlTypeStrings.MAX_CHAR_COLUMN_NOT_NULL)
        stringBuffer.append(basicItemData.PRODUCEDBY)
        stringBuffer.append(this.sqlTypeStrings.MAX_CHAR_COLUMN_NOT_NULL)
        stringBuffer.append(basicItemData.PRODUCTIONDATE)
        stringBuffer.append(this.sqlTypeStrings.MAX_CHAR_COLUMN_NOT_NULL)
        stringBuffer.append(basicItemData.STARTPRODUCTIONDATE)
        stringBuffer.append(this.sqlTypeStrings.MAX_CHAR_COLUMN_NOT_NULL)
        stringBuffer.append(basicItemData.DESCRIPTION)
        stringBuffer.append(this.sqlTypeStrings.BLOB_NOT_NULL)
        stringBuffer.append(basicItemData.KEYWORDS)
        stringBuffer.append(this.sqlTypeStrings.MAX_CHAR_COLUMN_NOT_NULL)
        stringBuffer.append(basicItemData.CATEGORY)
        stringBuffer.append(this.sqlTypeStrings.MAX_CHAR_COLUMN_NOT_NULL)
        stringBuffer.append(basicItemData.TYPE)
        stringBuffer.append(this.sqlTypeStrings.MAX_CHAR_COLUMN_NOT_NULL)
        stringBuffer.append(basicItemData.SMALLIMAGE)
        stringBuffer.append(this.sqlTypeStrings.MAX_CHAR_COLUMN_NOT_NULL)
        stringBuffer.append(basicItemData.MEDIUMIMAGE)
        stringBuffer.append(this.sqlTypeStrings.MAX_CHAR_COLUMN_NOT_NULL)
        stringBuffer.append(basicItemData.LARGEIMAGE)
        stringBuffer.append(this.sqlTypeStrings.MAX_CHAR_COLUMN_NOT_NULL)
        stringBuffer.append(EntryData.getInstance().LASTMODIFIED)
        stringBuffer.append(this.sqlTypeStrings.MAX_BIG_INT_UNSIGNED_NOT_NULL)
        stringBuffer.append(EntryData.getInstance().TIMECREATED)
        stringBuffer.append(this.sqlTypeStrings.MAX_BIG_INT_UNSIGNED_NOT_NULL)
        stringBuffer.append(basicItemData.PRICE)
        //stringBuffer.append(" DECIMAL (11,2) NOT NULL,");
        stringBuffer.append(" VARCHAR(20) NOT NULL,")
        stringBuffer.append(basicItemData.COMMENT)
        stringBuffer.append(this.sqlTypeStrings.BLOB_NOT_NULL)
        //Special Inventory Types True or False
        stringBuffer.append(basicItemData.CUSTOMS)
        stringBuffer.append(this.sqlTypeStrings.MAX_BIG_INT_UNSIGNED_NOT_NULL)
        stringBuffer.append(basicItemData.DOWNLOADS)
        stringBuffer.append(this.sqlTypeStrings.MAX_BIG_INT_UNSIGNED_NOT_NULL)
        stringBuffer.append(basicItemData.GROUPS)
        stringBuffer.append(this.sqlTypeStrings.MAX_BIG_INT_UNSIGNED_NOT_NULL)
        stringBuffer.append(basicItemData.OPTIONS)
        stringBuffer.append(this.sqlTypeStrings.MAX_BIG_INT_UNSIGNED_NOT_NULL)
        stringBuffer.append(basicItemData.PERMISSIONS)
        stringBuffer.append(this.sqlTypeStrings.MAX_BIG_INT_UNSIGNED_NOT_NULL)
        stringBuffer.append(basicItemData.SPECIALS)
        stringBuffer.append(this.sqlTypeStrings.MAX_BIG_INT_UNSIGNED_NOT_NULL)
        stringBuffer.append(this.sqlStrings.PRIMARY_KEY)
        stringBuffer.append(basicItemData.ID)
        stringBuffer.append(this.sqlStrings.END)
        return stringBuffer.toString()
    }

    def createTable() : String = {
        return super.createTable(this.createTableStatement())
    }

    /*     public String getItemForm(String id)     {     return super.getInputWhere(basicItemData.ID,id);     }      */
    def update(updatedValues : HashMap[Object, Object]) : Unit = {
        super.updateWhere(basicItemData.ID, updatedValues.get(basicItemData.ID).asInstanceOf[String], updatedValues)
    }

    override def dropTable() : String = {
        return super.dropTable()
    }

    //Needed for polyglot do not remove
    override def deleteWhere(key : String, value : String) : Unit = {
        super.deleteWhere(key, value)
    }

}


