/*  * AllBinary Open License Version 1  * Copyright (c) 2011 AllBinary  *   * By agreeing to this license you and any business entity you represent are  * legally bound to the AllBinary Open License Version 1 legal agreement.  *   * You may obtain the AllBinary Open License Version 1 legal agreement from  * AllBinary or the root directory of AllBinary's AllBinary Platform repository.  *   * Created By: Travis Berthelot  *   */
/* Generated Code Do Not Modify */
package org.allbinary.data.tables.staticpages

import _root_.java.util.HashMap
import _root_.org.allbinary.util.BasicArrayList
import _root_.org.allbinary.util.BasicArrayListD
import _root_.org.allbinary.business.context.modules.storefront.StoreFrontData
import _root_.org.allbinary.business.init.db.StaticPagesDbInitInfo
import _root_.org.allbinary.business.user.commerce.inventory.item.BasicItemData
import _root_.org.allbinary.logic.StdUtil
import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.logic.communication.sql.AbSqlBean
import _root_.org.allbinary.logic.control.search.SearchData
import _root_.org.allbinary.logic.string.StringMaker
import _root_.org.allbinary.string.CommonSeps

class StaticPagesEntity() extends AbSqlBean(new StaticPagesDbInitInfo()) with StaticPagesEntityInterface {

    val logUtil_StaticPagesEntity : LogUtil = LogUtil.getInstance()

    val basicItemData : BasicItemData = BasicItemData.getInstance()

    private val TABLENAME : String = "staticpages"

    //Constructor
    {
        this.setTableName(this.TABLENAME)
    }

    override def insert(values : BasicArrayList) : Unit = {
        try {
            super.insert(values)
            if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().SQLLOGGING)) {
                this.logUtil_StaticPagesEntity.putF(this.commonStrings.SUCCESS, this, INSERT)
            }
        } catch {
            case e : Exception => {
                if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().SQLLOGGING)) {
                    this.logUtil_StaticPagesEntity.put(this.commonStrings.FAILURE, this, INSERT, e)
                }
            }
        }
    }

    def getFile(store : String, keywords : String) : String = {
        var whereHashMap : HashMap[Object, Object] = StdUtil.getInstance().createHashMap().asInstanceOf[HashMap[Object, Object]]
        whereHashMap.put(StoreFrontData.getInstance().NAME, store)
        whereHashMap.put(basicItemData.KEYWORDS, keywords)
        var file : String = super.getField(whereHashMap, SearchData.PAGE)
        return file
    }

    /*      public String getTable()      {      return super.getTable();      }      */
    def delete(keywords : String) : Unit = {
        super.deleteWhere(basicItemData.KEYWORDS, keywords)
    }

    override def dropTable() : String = {
        var returnStr : String = super.dropTable()
        return returnStr
    }

    /*      public String getInputForm(String keywords)      {      return super.getInputWhere(SearchData.KEYWORDS, keywords);      }      */
    def update(updatedValues : HashMap[Object, Object]) : Unit = {
        super.updateWhere(basicItemData.KEYWORDS, updatedValues.get(basicItemData.KEYWORDS).asInstanceOf[String], updatedValues)
    }

    final def createTableStatement() : String = {
        var stringBuffer : StringMaker = new StringMaker()
        stringBuffer.append(this.sqlStrings.CREATE_TABLE).append(TABLENAME).append(this.sqlStrings.START).append(StoreFrontData.getInstance().NAME).append(this.sqlTypeStrings.SIXTY_CHAR_COLUMN_NOT_NULL).append(basicItemData.KEYWORDS).append(this.sqlTypeStrings.MAX_CHAR_COLUMN_NOT_NULL).append(SearchData.PAGE).append(this.sqlTypeStrings.MAX_CHAR_COLUMN_NOT_NULL).append(this.sqlStrings.PRIMARY_KEY).append(StoreFrontData.getInstance().NAME).append(CommonSeps.getInstance().COMMA_SEP).append(basicItemData.KEYWORDS).append(this.sqlStrings.END)
        return stringBuffer.toString()
    }

    //return super.createTable("CREATE TABLE " + super.getTableName() + tableData);
    def createTable() : String = {
        return super.createTable(this.createTableStatement())
    }

}


