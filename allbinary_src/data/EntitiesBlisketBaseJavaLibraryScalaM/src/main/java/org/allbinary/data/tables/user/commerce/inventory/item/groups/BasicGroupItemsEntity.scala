/*  * AllBinary Open License Version 1  * Copyright (c) 2011 AllBinary  *   * By agreeing to this license you and any business entity you represent are  * legally bound to the AllBinary Open License Version 1 legal agreement.  *   * You may obtain the AllBinary Open License Version 1 legal agreement from  * AllBinary or the root directory of AllBinary's AllBinary Platform repository.  *   * Created By: Travis Berthelot  *   */
/* Generated Code Do Not Modify */
package org.allbinary.data.tables.user.commerce.inventory.item.groups

import _root_.java.util.HashMap
import _root_.org.allbinary.util.BasicArrayList
import _root_.org.allbinary.util.BasicArrayListD
import _root_.org.allbinary.business.entry.EntryData
import _root_.org.allbinary.business.init.db.InventoryDbInitInfo
import _root_.org.allbinary.business.user.commerce.inventory.item.BasicItemData
import _root_.org.allbinary.business.user.commerce.inventory.item.group.BasicGroupItemData
import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.logic.communication.sql.AbSqlBean
import _root_.org.allbinary.logic.string.StringMaker

class BasicGroupItemsEntity() extends AbSqlBean(new InventoryDbInitInfo()) with BasicGroupItemsEntityInterface {

    val logUtil_BasicGroupItemsEntity : LogUtil = LogUtil.getInstance()

    val basicItemData : BasicItemData = BasicItemData.getInstance()

    val tableName : String = "basicgroupeditems"

    //Constructor
    {
        this.setTableName(this.tableName)
    }

    override def insert(values : BasicArrayList) : Unit = {
        try {
            super.insert(values)
            if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().SQLLOGGING)) {
                this.logUtil_BasicGroupItemsEntity.putF(this.commonStrings.SUCCESS, this, INSERT)
            }
        } catch {
            case e : Exception => {
                if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().SQLLOGGING)) {
                    this.logUtil_BasicGroupItemsEntity.put(this.commonStrings.FAILURE, this, INSERT, e)
                }
            }
        }
    }

    def delete(value : String) : Unit = {
        try {
            super.deleteWhere(basicItemData.ID, value)
            if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().SQLLOGGING)) {
                this.logUtil_BasicGroupItemsEntity.putF(this.commonStrings.SUCCESS, this, this.commonStrings.delete)
            }
        } catch {
            case e : Exception => {
                if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().SQLLOGGING)) {
                    this.logUtil_BasicGroupItemsEntity.put(this.commonStrings.FAILURE, this, this.commonStrings.delete, e)
                }
            }
        }
    }

    /*      public String getTable(String itemId)      {      return super.getTableWhere(basicItemData.ID,itemId);      }      */
    final def createTableStatement() : String = {
        var stringBuffer : StringMaker = new StringMaker()
        stringBuffer.append(this.sqlStrings.CREATE_TABLE).append(tableName).append(this.sqlStrings.START).append(basicItemData.ID).append(this.sqlTypeStrings.MAX_BIG_INT_UNSIGNED_NOT_NULL).append(BasicGroupItemData.ITEM_ONE).append(this.sqlTypeStrings.MAX_CHAR_COLUMN_NOT_NULL).append(BasicGroupItemData.ITEM_TWO).append(this.sqlTypeStrings.MAX_CHAR_COLUMN_NOT_NULL).append(BasicGroupItemData.ITEM_THREE).append(this.sqlTypeStrings.MAX_CHAR_COLUMN_NOT_NULL).append(BasicGroupItemData.ITEM_FOUR).append(this.sqlTypeStrings.MAX_CHAR_COLUMN_NOT_NULL).append(BasicGroupItemData.ITEM_FIVE).append(this.sqlTypeStrings.MAX_CHAR_COLUMN_NOT_NULL).append(BasicGroupItemData.ITEM_SIX).append(this.sqlTypeStrings.MAX_CHAR_COLUMN_NOT_NULL).append(BasicGroupItemData.ITEM_SEVEN).append(this.sqlTypeStrings.MAX_CHAR_COLUMN_NOT_NULL).append(BasicGroupItemData.ITEM_EIGHT).append(this.sqlTypeStrings.MAX_CHAR_COLUMN_NOT_NULL).append(BasicGroupItemData.ITEM_NINE).append(this.sqlTypeStrings.MAX_CHAR_COLUMN_NOT_NULL).append(BasicGroupItemData.ITEM_TEN).append(this.sqlTypeStrings.MAX_CHAR_COLUMN_NOT_NULL).append(EntryData.getInstance().TIMECREATED).append(this.sqlTypeStrings.MAX_BIG_INT_UNSIGNED_NOT_NULL).append(EntryData.getInstance().LASTMODIFIED).append(this.sqlTypeStrings.MAX_BIG_INT_UNSIGNED_NOT_NULL).append(this.sqlStrings.PRIMARY_KEY).append(basicItemData.ID).append(this.sqlStrings.END)
        return stringBuffer.toString()
    }

    def createTable() : String = {
        return super.createTable(this.createTableStatement())
    }

    /*         public String getForm(String id)      {      return super.getInputWhere(basicItemData.ID,id);      }      */
    def update(updatedValues : HashMap[Object, Object]) : Unit = {
        super.updateWhere(basicItemData.ID, updatedValues.get(basicItemData.ID).asInstanceOf[String], updatedValues)
    }

    override def dropTable() : String = {
        return super.dropTable()
    }

}


