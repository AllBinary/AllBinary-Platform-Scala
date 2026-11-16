/*  * AllBinary Open License Version 1  * Copyright (c) 2011 AllBinary  *   * By agreeing to this license you and any business entity you represent are  * legally bound to the AllBinary Open License Version 1 legal agreement.  *   * You may obtain the AllBinary Open License Version 1 legal agreement from  * AllBinary or the root directory of AllBinary's AllBinary Platform repository.  *   * Created By: Travis Berthelot  *   */
/* Generated Code Do Not Modify */
package org.allbinary.data.tables.user.commerce.inventory.item.downloads

import _root_.java.util.HashMap
import _root_.org.allbinary.util.BasicArrayList
import _root_.org.allbinary.util.BasicArrayListD
import _root_.org.allbinary.business.entry.EntryData
import _root_.org.allbinary.business.init.db.InventoryDbInitInfo
import _root_.org.allbinary.business.user.commerce.inventory.item.BasicItemData
import _root_.org.allbinary.business.user.commerce.inventory.item.download.DownloadItemData
import _root_.org.allbinary.business.user.commerce.inventory.item.download.DownloadableItem
import _root_.org.allbinary.logic.StdUtil
import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.logic.communication.sql.AbSqlBean
import _root_.org.allbinary.logic.string.StringMaker

class DownloadItemsEntity() extends AbSqlBean(new InventoryDbInitInfo()) with DownloadItemsEntityInterface {

    val logUtil_DownloadItemsEntity : LogUtil = LogUtil.getInstance()

    val basicItemData : BasicItemData = BasicItemData.getInstance()

    val tableName : String = "downloaditems"

    //Constructor
    {
        this.setTableName(this.tableName)
    }

    override def insert(values : BasicArrayList) : Unit = {
        try {
            super.insert(values)
            if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().SQLLOGGING)) {
                this.logUtil_DownloadItemsEntity.putF(this.commonStrings.SUCCESS, this, INSERT)
            }
        } catch {
            case e : Exception => {
                if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().SQLLOGGING)) {
                    this.logUtil_DownloadItemsEntity.put(this.commonStrings.FAILURE, this, INSERT, e)
                }
            }
        }
    }

    def delete(value : String) : Unit = {
        try {
            super.deleteWhere(DownloadItemData.ID, value)
            if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().SQLLOGGING)) {
                this.logUtil_DownloadItemsEntity.putF(this.commonStrings.SUCCESS, this, this.commonStrings.delete)
            }
        } catch {
            case e : Exception => {
                if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().SQLLOGGING)) {
                    this.logUtil_DownloadItemsEntity.put(this.commonStrings.FAILURE, this, this.commonStrings.delete, e)
                }
            }
        }
    }

    def update(updatedValues : HashMap[Object, Object]) : Unit = {
        super.updateWhere(DownloadItemData.ID, updatedValues.get(DownloadItemData.ID).asInstanceOf[String], updatedValues)
    }

    def getForItem(id : String) : BasicArrayList = {
        var returnVector : BasicArrayList = new BasicArrayListD()
        var keysAndValues : HashMap[Object, Object] = StdUtil.getInstance().createHashMap().asInstanceOf[HashMap[Object, Object]]
        keysAndValues.put(basicItemData.ID, id)
        var vector : BasicArrayList = super.getRows(keysAndValues)
        val size : Int = vector.size()

        {
            var index : Int = 0
            while (index < size) {
                var hashMap : HashMap[Object, Object] = vector.get(index).asInstanceOf[HashMap[Object, Object]]
                returnVector.add(new DownloadableItem(hashMap))
                index += 1
            }
        }
        if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().SQLLOGGING)) {
            this.logUtil_DownloadItemsEntity.putF("Found: " + size, this, "getForItem")
        }
        return returnVector
    }

    def getForItem(id : String, downloadItemId : String) : BasicArrayList = {
        var returnVector : BasicArrayList = new BasicArrayListD()
        var keysAndValues : HashMap[Object, Object] = StdUtil.getInstance().createHashMap().asInstanceOf[HashMap[Object, Object]]
        keysAndValues.put(basicItemData.ID, id)
        keysAndValues.put(DownloadItemData.ID, downloadItemId)
        var vector : BasicArrayList = super.getRows(keysAndValues)
        val size : Int = vector.size()

        {
            var index : Int = 0
            while (index < size) {
                var hashMap : HashMap[Object, Object] = vector.get(index).asInstanceOf[HashMap[Object, Object]]
                returnVector.add(new DownloadableItem(hashMap))
                index += 1
            }
        }
        if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().SQLLOGGING)) {
            this.logUtil_DownloadItemsEntity.putF("Found: " + size, this, "getForItem")
        }
        return returnVector
    }

    final def createTableStatement() : String = {
        var stringBuffer : StringMaker = new StringMaker()
        stringBuffer.append(this.sqlStrings.CREATE_TABLE).append(tableName).append(this.sqlStrings.START).append(DownloadItemData.ID).append(this.sqlTypeStrings.MAX_BIG_INT_UNSIGNED_NOT_NULL).append(basicItemData.ID).append(this.sqlTypeStrings.MAX_BIG_INT_UNSIGNED_NOT_NULL).append(EntryData.getInstance().ENABLE).append(this.sqlTypeStrings.MAX_CHAR_COLUMN_NOT_NULL).append(DownloadItemData.SPECIAL_NAME).append(this.sqlTypeStrings.MAX_CHAR_COLUMN_NOT_NULL).append(DownloadItemData.VERSION).append(this.sqlTypeStrings.MAX_CHAR_COLUMN_NOT_NULL).append(DownloadItemData.CHANGES).append(this.sqlTypeStrings.BLOB_NOT_NULL).append(DownloadItemData.SYSTEM).append(this.sqlTypeStrings.MAX_CHAR_COLUMN_NOT_NULL).append(DownloadItemData.PLATFORM).append(this.sqlTypeStrings.MAX_CHAR_COLUMN_NOT_NULL).append(DownloadItemData.LICENSE_FILE).append(this.sqlTypeStrings.MAX_CHAR_COLUMN_NOT_NULL)
        //define the file download time limit and number of retries allowed and license
        stringBuffer.append(DownloadItemData.FILE).append(this.sqlTypeStrings.MAX_CHAR_COLUMN_NOT_NULL).append(DownloadItemData.SIZE).append(this.sqlTypeStrings.MAX_BIG_INT_UNSIGNED_NOT_NULL).append(DownloadItemData.VALID_TIME).append(this.sqlTypeStrings.MAX_BIG_INT_UNSIGNED_NOT_NULL).append(DownloadItemData.RETRIES).append(this.sqlTypeStrings.MAX_BIG_INT_UNSIGNED_NOT_NULL).append(EntryData.getInstance().TIMECREATED).append(this.sqlTypeStrings.MAX_BIG_INT_UNSIGNED_NOT_NULL).append(EntryData.getInstance().LASTMODIFIED).append(this.sqlTypeStrings.MAX_BIG_INT_UNSIGNED_NOT_NULL).append(this.sqlStrings.PRIMARY_KEY).append(DownloadItemData.ID).append(this.sqlStrings.END)
        return stringBuffer.toString()
    }

    def createTable() : String = {
        return super.createTable(this.createTableStatement())
    }

    override def dropTable() : String = {
        return super.dropTable()
    }

}


