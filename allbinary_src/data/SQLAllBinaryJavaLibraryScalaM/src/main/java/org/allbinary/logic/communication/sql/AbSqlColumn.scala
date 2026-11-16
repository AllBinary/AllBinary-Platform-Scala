/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.logic.communication.sql

import _root_.java.sql.ResultSet
import _root_.org.allbinary.util.BasicArrayList
import _root_.org.allbinary.util.BasicArrayListD
import _root_.org.allbinary.business.init.db.DbConnectionInfo
import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.logic.string.StringMaker

class AbSqlColumn(param_databaseConnectionInfoInterface : DbConnectionInfo) extends AbSqlTable(param_databaseConnectionInfoInterface) {

    val logUtil_AbSqlColumn : LogUtil = LogUtil.getInstance()

    private val LARGEST_INT_VALUE_IN_COLUMN : String = "\nLargest Int Value in column: "

    private val METHOD_GET_LARGETS_INTEGER_IN_COLUMN : String = "getLargestIntegerInColumn"

    private val METHOD_GET_COLUMN : String = "getColumn"

    private val METHOD_GET_COLUMN_WHERE : String = "getColumnWhere"

    private val INVALID_RESULT : String = "-1"

    //Constructor
    {
        val databaseConnectionInfoInterface : DbConnectionInfo = param_databaseConnectionInfoInterface
    }

    def getLargestIntegerInColumnWhere(columnName : String, key : String, value : String) : String = {
        val stringBuffer : StringMaker = new StringMaker()
        stringBuffer.append(this.sqlStrings.SELECT)
        stringBuffer.append(columnName)
        stringBuffer.append(this.sqlStrings.FROM)
        stringBuffer.append(this.getTableName())
        stringBuffer.append(this.sqlStrings.WHERE)
        stringBuffer.append(key)
        stringBuffer.append(this.sqlStrings.EQUAL_QUOTE)
        stringBuffer.append(value)
        stringBuffer.append(this.sqlStrings.CLOSE_QUOTE)
        val sqlStatement : String = stringBuffer.toString()
        try {
            var largest : Int = 0
            val rset : ResultSet = executeSQLStatement(sqlStatement)

            {
                while (rset.next()) {
                    var intValue : Int = rset.getInt(columnName)
                    if (intValue > largest) {
                        largest = intValue
                    }
                }
            }
            var largestAsString : String = new Integer(largest).toString()
            if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().SQLLOGGING)) {
                stringBuffer.delete(0, stringBuffer.length())
                stringBuffer.append(this.sqlStrings.SQL_STATEMENT_LABEL)
                stringBuffer.append(sqlStatement)
                stringBuffer.append(this.LARGEST_INT_VALUE_IN_COLUMN)
                stringBuffer.append(largestAsString)
                this.logUtil_AbSqlColumn.putF(stringBuffer.toString(), this, this.METHOD_GET_LARGETS_INTEGER_IN_COLUMN)
            }
            return largestAsString
        } catch {
            case e : Exception => {
                if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().SQLLOGGINGERROR)) {
                    this.logUtil_AbSqlColumn.put(this.FAILED_SQL_STATEMENT + sqlStatement, this, METHOD_GET_LARGETS_INTEGER_IN_COLUMN, e)
                }
                return this.INVALID_RESULT
            }
        }
        throw new IllegalStateException()
    }

    def getColumn(columnName : String) : BasicArrayList = {
        val column : BasicArrayList = new BasicArrayListD()
        val stringBuffer : StringMaker = new StringMaker()
        stringBuffer.append(this.sqlStrings.SELECT)
        stringBuffer.append(columnName)
        stringBuffer.append(this.sqlStrings.FROM)
        stringBuffer.append(this.getTableName())
        val sqlStatement : String = stringBuffer.toString()
        try {
            val rset : ResultSet = executeSQLStatement(sqlStatement)

            {
                while (rset.next()) {
                    var field : String = rset.getObject(columnName).toString()
                    column.add(field)
                }
            }
            if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().SQLLOGGING)) {
                stringBuffer.delete(0, stringBuffer.length())
                stringBuffer.append(this.sqlStrings.SQL_STATEMENT_LABEL)
                stringBuffer.append(sqlStatement)
                stringBuffer.append(this.sqlStrings.COLUMN_VALUE)
                stringBuffer.append(column.toString())
                this.logUtil_AbSqlColumn.putF(stringBuffer.toString(), this, this.METHOD_GET_COLUMN)
            }
            return column
        } catch {
            case e : Exception => {
                if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().SQLLOGGINGERROR)) {
                    this.logUtil_AbSqlColumn.put(this.FAILED_SQL_STATEMENT + sqlStatement, this, METHOD_GET_COLUMN, e)
                }
                return column
            }
        }
        throw new IllegalStateException()
    }

    def getColumnWhere(columnName : String, key : String, value : String) : BasicArrayList = {
        val stringBuffer : StringMaker = new StringMaker()
        stringBuffer.append(this.sqlStrings.SELECT)
        stringBuffer.append(columnName)
        stringBuffer.append(this.sqlStrings.FROM)
        stringBuffer.append(this.getTableName())
        stringBuffer.append(this.sqlStrings.WHERE)
        stringBuffer.append(key)
        stringBuffer.append(this.sqlStrings.EQUAL_QUOTE)
        stringBuffer.append(value)
        stringBuffer.append(this.sqlStrings.CLOSE_QUOTE)
        val sqlStatement : String = stringBuffer.toString()
        var column : BasicArrayList = new BasicArrayListD()
        var rset : ResultSet = null
        var field : String = null
        try {
            rset = executeSQLStatement(sqlStatement)

            {
                while (rset.next()) {
                    field = rset.getObject(columnName).toString()
                    column.add(field)
                }
            }
            if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().SQLLOGGING)) {
                stringBuffer.delete(0, stringBuffer.length())
                stringBuffer.append(this.sqlStrings.SQL_STATEMENT_LABEL)
                stringBuffer.append(sqlStatement)
                stringBuffer.append(this.sqlStrings.COLUMN_VALUE)
                stringBuffer.append(column.toString())
                this.logUtil_AbSqlColumn.putF(stringBuffer.toString(), this, this.METHOD_GET_COLUMN_WHERE)
            }
            return column
        } catch {
            case e : Exception => {
                if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().SQLLOGGINGERROR)) {
                    this.logUtil_AbSqlColumn.put(this.FAILED_SQL_STATEMENT + sqlStatement, this, this.METHOD_GET_COLUMN_WHERE, e)
                }
                return column
            }
        }
        throw new IllegalStateException()
    }

}


