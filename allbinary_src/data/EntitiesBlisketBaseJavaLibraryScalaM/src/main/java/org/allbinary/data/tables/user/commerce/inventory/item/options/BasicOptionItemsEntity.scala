/*  * AllBinary Open License Version 1  * Copyright (c) 2011 AllBinary  *   * By agreeing to this license you and any business entity you represent are  * legally bound to the AllBinary Open License Version 1 legal agreement.  *   * You may obtain the AllBinary Open License Version 1 legal agreement from  * AllBinary or the root directory of AllBinary's AllBinary Platform repository.  *   * Created By: Travis Berthelot  *   */
/* Generated Code Do Not Modify */
package org.allbinary.data.tables.user.commerce.inventory.item.options

import _root_.java.util.HashMap
import _root_.org.allbinary.util.BasicArrayList
import _root_.org.allbinary.util.BasicArrayListD
import _root_.org.allbinary.business.entry.EntryData
import _root_.org.allbinary.business.init.db.InventoryDbInitInfo
import _root_.org.allbinary.business.user.commerce.inventory.item.BasicItemData
import _root_.org.allbinary.business.user.commerce.inventory.item.option.BasicOptionItemData
import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.logic.communication.sql.AbSqlBean
import _root_.org.allbinary.logic.string.StringMaker

class BasicOptionItemsEntity() extends AbSqlBean(new InventoryDbInitInfo()) with BasicOptionItemsEntityInterface {

    val logUtil_BasicOptionItemsEntity : LogUtil = LogUtil.getInstance()

    val basicItemData : BasicItemData = BasicItemData.getInstance()

    val tableName : String = "basicoptionitems"

    //Constructor
    {
        this.setTableName(this.tableName)
    }

    override def insert(values : BasicArrayList) : Unit = {
        try {
            super.insert(values)
            if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().SQLLOGGING)) {
                this.logUtil_BasicOptionItemsEntity.putF(this.commonStrings.SUCCESS, this, INSERT)
            }
        } catch {
            case e : Exception => {
                if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().SQLLOGGING)) {
                    this.logUtil_BasicOptionItemsEntity.put(this.commonStrings.FAILURE, this, INSERT, e)
                }
            }
        }
    }

    def delete(value : String) : Unit = {
        try {
            super.deleteWhere(basicItemData.ID, value)
            if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().SQLLOGGING)) {
                this.logUtil_BasicOptionItemsEntity.putF(this.commonStrings.SUCCESS, this, this.commonStrings.delete)
            }
        } catch {
            case e : Exception => {
                if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().SQLLOGGING)) {
                    this.logUtil_BasicOptionItemsEntity.put(this.commonStrings.FAILURE, this, this.commonStrings.delete, e)
                }
            }
        }
    }

    /*      public String getTable(String itemId)      {      return super.getTableWhere(basicItemData.ID,itemId);      }      */
    final def createTableStatement() : String = {
        var stringBuffer : StringMaker = new StringMaker()
        stringBuffer.append(this.sqlStrings.CREATE_TABLE).append(tableName).append(this.sqlStrings.START).append(basicItemData.ID).append(this.sqlTypeStrings.MAX_BIG_INT_UNSIGNED_NOT_NULL)
        //Option title like color or size
        stringBuffer.append(BasicOptionItemData.OPTION_ONE_TITLE).append(this.sqlTypeStrings.MAX_CHAR_COLUMN_NOT_NULL).append(BasicOptionItemData.DEFAULT_OPTION_ITEM).append(this.sqlTypeStrings.MAX_BIG_INT_UNSIGNED_NOT_NULL).append(BasicOptionItemData.DEFAULT_OPTION_VALUE).append(this.sqlTypeStrings.MAX_CHAR_COLUMN_NOT_NULL)
        //Available options
        stringBuffer.append(BasicOptionItemData.OPTION_ONE_ONE_ITEM).append(this.sqlTypeStrings.MAX_BIG_INT_UNSIGNED_NOT_NULL).append(BasicOptionItemData.OPTION_ONE_ONE_VALUE).append(this.sqlTypeStrings.MAX_CHAR_COLUMN_NOT_NULL).append(BasicOptionItemData.OPTION_ONE_TWO_ITEM).append(this.sqlTypeStrings.MAX_BIG_INT_UNSIGNED_NOT_NULL).append(BasicOptionItemData.OPTION_ONE_TWO_VALUE).append(this.sqlTypeStrings.MAX_CHAR_COLUMN_NOT_NULL).append(BasicOptionItemData.OPTION_ONE_THREE_ITEM).append(this.sqlTypeStrings.MAX_BIG_INT_UNSIGNED_NOT_NULL).append(BasicOptionItemData.OPTION_ONE_THREE_VALUE).append(this.sqlTypeStrings.MAX_CHAR_COLUMN_NOT_NULL).append(BasicOptionItemData.OPTION_ONE_FOUR_ITEM).append(this.sqlTypeStrings.MAX_BIG_INT_UNSIGNED_NOT_NULL).append(BasicOptionItemData.OPTION_ONE_FOUR_VALUE).append(this.sqlTypeStrings.MAX_CHAR_COLUMN_NOT_NULL).append(BasicOptionItemData.OPTION_ONE_FIVE_ITEM).append(this.sqlTypeStrings.MAX_BIG_INT_UNSIGNED_NOT_NULL).append(BasicOptionItemData.OPTION_ONE_FIVE_VALUE).append(this.sqlTypeStrings.MAX_CHAR_COLUMN_NOT_NULL).append(BasicOptionItemData.OPTION_ONE_SIX_ITEM).append(this.sqlTypeStrings.MAX_BIG_INT_UNSIGNED_NOT_NULL).append(BasicOptionItemData.OPTION_ONE_SIX_VALUE).append(this.sqlTypeStrings.MAX_CHAR_COLUMN_NOT_NULL).append(BasicOptionItemData.OPTION_ONE_SEVEN_ITEM).append(this.sqlTypeStrings.MAX_BIG_INT_UNSIGNED_NOT_NULL).append(BasicOptionItemData.OPTION_ONE_SEVEN_VALUE).append(this.sqlTypeStrings.MAX_CHAR_COLUMN_NOT_NULL).append(BasicOptionItemData.OPTION_ONE_EIGHT_ITEM).append(this.sqlTypeStrings.MAX_BIG_INT_UNSIGNED_NOT_NULL).append(BasicOptionItemData.OPTION_ONE_EIGHT_VALUE).append(this.sqlTypeStrings.MAX_CHAR_COLUMN_NOT_NULL).append(BasicOptionItemData.OPTION_ONE_NINE_ITEM).append(this.sqlTypeStrings.MAX_BIG_INT_UNSIGNED_NOT_NULL).append(BasicOptionItemData.OPTION_ONE_NINE_VALUE).append(this.sqlTypeStrings.MAX_CHAR_COLUMN_NOT_NULL).append(EntryData.getInstance().TIMECREATED).append(this.sqlTypeStrings.MAX_BIG_INT_UNSIGNED_NOT_NULL).append(EntryData.getInstance().LASTMODIFIED).append(this.sqlTypeStrings.MAX_BIG_INT_UNSIGNED_NOT_NULL).append(this.sqlStrings.PRIMARY_KEY).append(basicItemData.ID).append(this.sqlStrings.END)
        return stringBuffer.toString()
    }

    def createTable() : String = {
        return super.createTable(this.createTableStatement())
    }

    /*      public String getForm(String id)      {      return super.getInputWhere(basicItemData.ID,id);      }      */
    def update(updatedValues : HashMap[Object, Object]) : Unit = {
        super.updateWhere(basicItemData.ID, updatedValues.get(basicItemData.ID).asInstanceOf[String], updatedValues)
    }

    override def dropTable() : String = {
        return super.dropTable()
    }

}


