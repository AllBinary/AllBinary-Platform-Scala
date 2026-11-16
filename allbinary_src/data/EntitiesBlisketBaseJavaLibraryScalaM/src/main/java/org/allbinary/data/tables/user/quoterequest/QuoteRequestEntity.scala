/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.data.tables.user.quoterequest

import _root_.java.util.HashMap
import _root_.org.allbinary.util.BasicArrayList
import _root_.org.allbinary.util.BasicArrayListD
import _root_.org.allbinary.business.entry.EntryData
import _root_.org.allbinary.business.init.db.UserDbInitInfo
import _root_.org.allbinary.business.quoterequest.QuoteRequestData
import _root_.org.allbinary.business.user.UserData
import _root_.org.allbinary.business.user.quoterequest.QuoteRequest
import _root_.org.allbinary.logic.StdUtil
import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.logic.communication.sql.AbSqlBean
import _root_.org.allbinary.logic.string.StringMaker

class QuoteRequestEntity() extends AbSqlBean(new UserDbInitInfo()) with QuoteRequestEntityInterface {

    val logUtil_QuoteRequestEntity : LogUtil = LogUtil.getInstance()

    private val tableName : String = "quoterequest"

    //Constructor
    {
        this.setTableName(this.tableName)
    }

    override def insert(values : BasicArrayList) : Unit = {
        try {
            super.insert(values)
            if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().SQLLOGGING)) {
                this.logUtil_QuoteRequestEntity.putF(this.commonStrings.SUCCESS, this, INSERT)
            }
        } catch {
            case e : Exception => {
                if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().SQLLOGGING)) {
                    this.logUtil_QuoteRequestEntity.put(this.commonStrings.FAILURE, this, INSERT, e)
                }
            }
        }
    }

    def get(userName : String, id : Int) : QuoteRequest = {
        var row : HashMap[Object, Object] = StdUtil.getInstance().createHashMap().asInstanceOf[HashMap[Object, Object]]
        row.put(UserData.USERNAME, userName)
        row.put(QuoteRequestData.getInstance().ID, Integer.toString(id))
        var quoteRequestHashMap : HashMap[Object, Object] = super.getRow(row).asInstanceOf[HashMap[Object, Object]]
        if (quoteRequestHashMap != null) {
            return new _root_.org.allbinary.business.user.quoterequest.QuoteRequest(quoteRequestHashMap)
        } else {
            return null
        }
        throw new IllegalStateException()
    }

    def getIds(userName : String) : BasicArrayList = {
        return super.getColumnWhere(QuoteRequestData.getInstance().ID, UserData.USERNAME, userName)
    }

    override def deleteWhere(key : String, value : String) : Unit = {
        try {
            super.deleteWhere(key, value)
            if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().SQLLOGGING)) {
                this.logUtil_QuoteRequestEntity.putF(this.commonStrings.SUCCESS, this, "deleteWhere")
            }
        } catch {
            case e : Exception => {
                if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().SQLLOGGING)) {
                    this.logUtil_QuoteRequestEntity.put(this.commonStrings.FAILURE, this, "deleteWhere", e)
                }
            }
        }
    }

    /*    public String getTable()    {                   return super.getTable();    }    */
    final def createTableStatement() : String = {
        var quoteRequestData : QuoteRequestData = QuoteRequestData.getInstance()
        val stringBuffer : StringMaker = new StringMaker()
        stringBuffer.append(this.sqlStrings.CREATE_TABLE).append(tableName).append(this.sqlStrings.START)
        stringBuffer.append(quoteRequestData.ID).append(this.sqlTypeStrings.MAX_BIG_INT_UNSIGNED_NOT_NULL)
        stringBuffer.append(UserData.USERNAME)
        stringBuffer.append(this.sqlTypeStrings.MAX_CHAR_COLUMN_NOT_NULL)
        stringBuffer.append(quoteRequestData.PROJECT_INFO)
        stringBuffer.append(this.sqlTypeStrings.BLOB_NOT_NULL)
        stringBuffer.append(quoteRequestData.CUSTOMER_COMMENTS)
        stringBuffer.append(this.sqlTypeStrings.BLOB_NOT_NULL)
        stringBuffer.append(quoteRequestData.BUDGET)
        stringBuffer.append(this.sqlTypeStrings.BLOB_NOT_NULL)
        stringBuffer.append(quoteRequestData.TIMEFRAME)
        stringBuffer.append(this.sqlTypeStrings.BLOB_NOT_NULL)
        stringBuffer.append(quoteRequestData.COMMENTS)
        stringBuffer.append(this.sqlTypeStrings.BLOB_NOT_NULL)
        stringBuffer.append(EntryData.getInstance().TIMECREATED)
        stringBuffer.append(this.sqlTypeStrings.MAX_BIG_INT_UNSIGNED_NOT_NULL)
        stringBuffer.append(EntryData.getInstance().LASTMODIFIED)
        stringBuffer.append(this.sqlTypeStrings.MAX_BIG_INT_UNSIGNED_NOT_NULL)
        stringBuffer.append(this.sqlStrings.PRIMARY_KEY)
        stringBuffer.append(quoteRequestData.ID)
        stringBuffer.append(this.sqlStrings.END)
        return stringBuffer.toString()
    }

    def createTable() : String = {
        return super.createTable(this.createTableStatement())
    }

    override def dropTable() : String = {
        var result : String = new String(super.dropTable())
        return result
    }

    /*       public String getForm(String userName, String id)    {       return super.getInputWhere(UserData.USERNAME,userName);    } */
    def update(userName : String, updatedValues : HashMap[Object, Object]) : Unit = {
        super.updateWhere(UserData.USERNAME, userName, updatedValues)
    }

}


