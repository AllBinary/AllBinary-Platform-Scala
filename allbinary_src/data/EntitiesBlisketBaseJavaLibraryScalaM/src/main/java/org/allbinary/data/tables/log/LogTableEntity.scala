/*  * AllBinary Open License Version 1  * Copyright (c) 2011 AllBinary  *   * By agreeing to this license you and any business entity you represent are  * legally bound to the AllBinary Open License Version 1 legal agreement.  *   * You may obtain the AllBinary Open License Version 1 legal agreement from  * AllBinary or the root directory of AllBinary's AllBinary Platform repository.  *   * Created By: Travis Berthelot  *   */
/* Generated Code Do Not Modify */
package org.allbinary.data.tables.log

import _root_.org.allbinary.business.entry.EntryData
import _root_.org.allbinary.business.init.db.LogDbInitInfo
import _root_.org.allbinary.logic.communication.http.request.AbeHttpRequestInfoData
import _root_.org.allbinary.logic.communication.sql.AbSqlBean
import _root_.org.allbinary.logic.string.StringMaker
import _root_.org.allbinary.util.BasicArrayList

class LogTableEntity() extends AbSqlBean(new LogDbInitInfo()) with LogTableEntityInterface {

    private val tableName : String = "log"

    //Constructor
    {
        this.setTableName(this.tableName)
    }

    final def createTableStatement() : String = {
        val abeHttpRequestInfoData : AbeHttpRequestInfoData = AbeHttpRequestInfoData.getInstance()
        var stringBuffer : StringMaker = new StringMaker()
        stringBuffer.append(this.sqlStrings.CREATE_TABLE).append(tableName).append(this.sqlStrings.START).append(this.sqlStrings.ID).append(this.sqlTypeStrings.MAX_CHAR_COLUMN_NOT_NULL).append(abeHttpRequestInfoData.HTTP_USER_AGENT).append(this.sqlTypeStrings.MAX_CHAR_COLUMN_NOT_NULL).append(abeHttpRequestInfoData.REMOTE_HOST).append(this.sqlTypeStrings.MAX_CHAR_COLUMN).append(abeHttpRequestInfoData.REMOTE_ADDRESS).append(this.sqlTypeStrings.MAX_CHAR_COLUMN_NOT_NULL).append(abeHttpRequestInfoData.REQUEST_FILE_PATH).append(this.sqlTypeStrings.MAX_CHAR_COLUMN_NOT_NULL).append(abeHttpRequestInfoData.REMOTE_PORT).append(this.sqlTypeStrings.MAX_INT_UNSIGNED_NOT_NULL).append(EntryData.getInstance().TIMECREATED).append(this.sqlTypeStrings.MAX_BIG_INT_UNSIGNED_NOT_NULL).append(this.sqlStrings.PRIMARY_KEY).append(this.sqlStrings.ID).append(this.sqlStrings.END)
        return stringBuffer.toString()
    }

    //return super.createTable("CREATE TABLE " + super.getTableName() + tableData);
    def createTable() : String = {
        return super.createTable(this.createTableStatement())
    }

    //Needed for polyglot do not remove
    override def deleteWhere(key : String, value : String) : Unit = {
        super.deleteWhere(key, value)
    }

    //Needed for polyglot do not remove
    override def insert(values : BasicArrayList) : Unit = {
        super.insert(values)
    }

    //Needed for polyglot do not remove
    override def dropTable() : String = {
        return super.dropTable()
    }

}


