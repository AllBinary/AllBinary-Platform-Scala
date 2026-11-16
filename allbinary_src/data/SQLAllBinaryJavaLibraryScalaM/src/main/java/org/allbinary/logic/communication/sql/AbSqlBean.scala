/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.logic.communication.sql

import _root_.java.sql.ResultSet
import _root_.java.util.HashMap
import _root_.java.util.Set
import _root_.org.allbinary.business.init.db.DbConnectionInfo
import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.logic.string.StringMaker

class AbSqlBean(param_databaseConnectionInfoInterface : DbConnectionInfo) extends AbSqlRow(param_databaseConnectionInfoInterface) {

    val logUtil_AbSqlBean : LogUtil = LogUtil.getInstance()

    private val METHOD_GET_FIELD : String = "getField"

    private val METHOD_IS_SUBSET_OF_ENTRY : String = "isSubsetOfEntry"

    //Constructor
    {
        val databaseConnectionInfoInterface : DbConnectionInfo = param_databaseConnectionInfoInterface
    }

    def getField(key : String, value : String, requestedField : String) : String = {
        val stringBuffer : StringMaker = new StringMaker()
        stringBuffer.append(this.sqlStrings.SELECT)
        stringBuffer.append(requestedField)
        stringBuffer.append(this.sqlStrings.FROM)
        stringBuffer.append(this.getTableName())
        stringBuffer.append(this.sqlStrings.WHERE)
        stringBuffer.append(key)
        stringBuffer.append(this.sqlStrings.EQUAL_QUOTE)
        stringBuffer.append(value)
        stringBuffer.append(this.sqlStrings.CLOSE_QUOTE)
        val sqlStatement : String = stringBuffer.toString()
        try {
            var field : String = this.stringUtil.EMPTY_STRING
            val rset : ResultSet = executeSQLStatement(sqlStatement)

            {
                while (rset.next()) {
                    field = rset.getString(requestedField)
                    if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().SQLLOGGING)) {
                        stringBuffer.delete(0, stringBuffer.length())
                        stringBuffer.append(this.sqlStrings.SQL_STATEMENT_LABEL)
                        stringBuffer.append(sqlStatement)
                        stringBuffer.append(this.sqlStrings.FIELD_VALUE)
                        stringBuffer.append(field)
                        this.logUtil_AbSqlBean.putF(stringBuffer.toString(), this, this.METHOD_GET_FIELD)
                    }
                    return field
                }
            }
            return null
        } catch {
            case e : Exception => {
                if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().SQLLOGGINGERROR)) {
                    this.logUtil_AbSqlBean.put(this.FAILED_SQL_STATEMENT + sqlStatement, this, METHOD_GET_FIELD, e)
                }
                return this.FAILED_SQL_STATEMENT + sqlStatement
            }
        }
        throw new IllegalStateException()
    }

    def getField(keysAndValues : HashMap[Object, Object], requestedField : String) : String = {
        val stringBuffer : StringMaker = new StringMaker()
        stringBuffer.append(this.sqlStrings.SELECT)
        stringBuffer.append(requestedField)
        stringBuffer.append(this.sqlStrings.FROM)
        stringBuffer.append(this.getTableName())
        stringBuffer.append(this.sqlStrings.WHERE)
        try {
            var field : String = this.stringUtil.EMPTY_STRING
            val set : Set[Object] = keysAndValues.keySet().asInstanceOf[Set[Object]]
            val keyArray : Array[Object] = set.toArray()
            val size : Int = keyArray.length
            var key : String = null
            var value : String = null

            {
                var i : Int = 0
                while (i < size) {
                    key = keyArray(i).asInstanceOf[String]
                    value = new String(keysAndValues.get(key).asInstanceOf[String])
                    stringBuffer.append(key)
                    stringBuffer.append(this.sqlStrings.EQUAL_QUOTE)
                    stringBuffer.append(value)
                    stringBuffer.append(this.sqlStrings.CLOSE_QUOTE)
                    if (i < (size - 1)) {
                        stringBuffer.append(this.sqlStrings.AND)
                    }
                    i += 1
                }
            }
            val sqlStatement : String = stringBuffer.toString()
            val rset : ResultSet = executeSQLStatement(sqlStatement)

            {
                while (rset.next()) {
                    field = rset.getString(requestedField)
                    if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().SQLLOGGING)) {
                        stringBuffer.delete(0, stringBuffer.length())
                        stringBuffer.append(this.sqlStrings.SQL_STATEMENT_LABEL)
                        stringBuffer.append(sqlStatement)
                        stringBuffer.append(this.sqlStrings.FIELD_VALUE)
                        stringBuffer.append(field)
                        this.logUtil_AbSqlBean.putF(stringBuffer.toString(), this, this.METHOD_GET_FIELD)
                    }
                    return field
                }
            }
            return null
        } catch {
            case e : Exception => {
                val sqlStatement : String = stringBuffer.toString()
                if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().SQLLOGGINGERROR)) {
                    this.logUtil_AbSqlBean.put(this.FAILED_SQL_STATEMENT + sqlStatement, this, METHOD_GET_FIELD, e)
                }
                return this.FAILED_SQL_STATEMENT + sqlStatement
            }
        }
        throw new IllegalStateException()
    }

    //empty hashmap will cause problems
    def isSubsetOfEntry(key : String, value : String, columnsAndValues : HashMap[Object, Object]) : String = {
        val stringBuffer : StringMaker = new StringMaker()
        stringBuffer.append(this.sqlStrings.SELECT)
        try {
            val keyArray : Array[Object] = columnsAndValues.keySet().toArray()
            val size : Int = keyArray.length
            stringBuffer.append(this.commonSeps.SPACE)
            stringBuffer.append(key)

            {
                var i : Int = 0
                while (i < size) {
                    stringBuffer.append(this.commonSeps.SPACE)
                    stringBuffer.append(keyArray(i).toString())
                    i += 1
                }
            }
            stringBuffer.append(this.sqlStrings.FROM)
            stringBuffer.append(this.getTableName())
            stringBuffer.append(this.sqlStrings.WHERE)
            stringBuffer.append(key)
            stringBuffer.append(this.sqlStrings.EQUAL_QUOTE)
            stringBuffer.append(value)
            stringBuffer.append(this.sqlStrings.CLOSE_QUOTE)
            val sqlStatement : String = stringBuffer.toString()
            val rset : ResultSet = executeSQLStatement(sqlStatement)
            var columnName : String = null
            var field : String = null

            {
                while (rset.next()) {
                    var keyArray2 : Array[Object] = columnsAndValues.keySet().toArray()
                    var size2 : Int = keyArray2.length

                    {
                        var i : Int = 0
                        while (i < size2) {
                            columnName = keyArray2(i).toString()
                            field = rset.getObject(columnName).toString()
                            if (field.compareTo(columnsAndValues.get(columnName).asInstanceOf[String]) != 0) {
                                return _root_.org.allbinary.globals.GLOBALS2.NOTASUBSET
                            }
                            i += 1
                        }
                    }
                }
            }
            if (rset.getRow() != 1) {
                return _root_.org.allbinary.globals.GLOBALS2.NOTASUBSET
            } else {
                return _root_.org.allbinary.globals.GLOBALS2.ISASUBSET
            }
        } catch {
            case e : Exception => {
                val sqlStatement : String = stringBuffer.toString()
                if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().SQLLOGGINGERROR)) {
                    this.logUtil_AbSqlBean.put(this.FAILED_SQL_STATEMENT + sqlStatement, this, METHOD_IS_SUBSET_OF_ENTRY, e)
                }
                return this.FAILED_SQL_STATEMENT + sqlStatement
            }
        }
        throw new IllegalStateException()
    }

}


