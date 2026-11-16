/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.logic.communication.sql

import _root_.org.allbinary.business.installer.Portion
import _root_.org.allbinary.logic.string.StringMaker
import _root_.org.allbinary.logic.string.StringUtil
import _root_.org.allbinary.string.CommonSeps
import _root_.org.allbinary.string.CommonStrings

class AbSqlTableUtil {
    import _root_.org.allbinary.logic.communication.sql.AbSqlTableUtil.{*}

    private val TABLE_LABEL : String = "Table: "

    val stringUtil : StringUtil = StringUtil.getInstance()

    val commonStrings : CommonStrings = CommonStrings.getInstance()

    val commonSeps : CommonSeps = CommonSeps.getInstance()

    val sqlStrings : SqlStrings = SqlStrings.getInstance()

    //This is not good for large data
    def backupTable(abSqlTable : AbSqlTable) : String = this.synchronized {
        val tableName : String = abSqlTable.getTableName()
        return (this.TABLE_LABEL + tableName) + " Backup Failed"
    }

    def restoreTable(abSqlTable : AbSqlTable, portion : Portion) : String = this.synchronized {
        val tableName : String = abSqlTable.getTableName()
        val stringBuffer : StringMaker = new StringMaker()
        stringBuffer.append(this.TABLE_LABEL)
        stringBuffer.append(tableName)
        stringBuffer.append(" Restoration Failed")
        return stringBuffer.toString()
    }

}

object AbSqlTableUtil {
    private val instance : AbSqlTableUtil = new AbSqlTableUtil()

    /**      * @return the instance      */
    def getInstance() : AbSqlTableUtil = {
        return AbSqlTableUtil.instance
    }

}


