/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.logic.communication.sql

import _root_.java.sql.ResultSet
import _root_.java.sql.ResultSetMetaData
import _root_.java.util.HashMap
import _root_.java.util.Set
import _root_.org.allbinary.util.BasicArrayList
import _root_.org.allbinary.util.BasicArrayListD
import _root_.org.allbinary.business.init.db.DbConnectionInfo
import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.logic.string.StringMaker
import _root_.org.allbinary.logic.string.StringUtil
import _root_.org.allbinary.logic.string.StringValidationUtil
import _root_.org.allbinary.logic.string.regex.replace.Replace

class AbSqlRow(param_databaseConnectionInfoInterface : DbConnectionInfo) extends AbSqlColumn(param_databaseConnectionInfoInterface) {

    val logUtil_AbSqlRow : LogUtil = LogUtil.getInstance()

    private val EQUAL_QUOTE : String = "=\""

    private val ESCAPE_QUOTES : String = "\\\""

    private val GET_ROW : String = "Row Value: "

    private val METHOD_GET_ROW : String = "getRow()"

    private val METHOD_GET_ROWS : String = "getRows()"

    private val METHOD_GET_ALL_ROWS : String = "getAllRows()"

    private val METHOD_UPDATE_WHERE : String = "updateWhere()"

    private val METHOD_GET_ROWS_WHERE_BETWEEN : String = "getRowsWhereBetween()"

    private val METHOD_DELETE_WHERE : String = "deleteWhere()"

    private val ROW_VALUE_LABEL : String = "Row Value: "

    private val ROW_VALUES_LABEL : String = "Row Values: "

    private val NO_RESULTS_IN_RESULT_SET : String = "No Results in ResultSet"

    private val COLUMN_NAME_LABEL : String = "columnName: "

    private val INSERT_END : String = "')"

    //Constructor
    {
        val databaseConnectionInfoInterface : DbConnectionInfo = param_databaseConnectionInfoInterface
    }

    //Don't allow "null"
    private def getValue(value : String) : String = this.synchronized {
        if (StringValidationUtil.getInstance().isEmpty(value)) {
            return this.stringUtil.EMPTY_STRING
        } else {
            return value
        }
        throw new IllegalStateException()
    }

    def updateWhere(key : String, value : String, updatedKeyValuePairs : HashMap[Object, Object]) : Unit = this.synchronized {
        val stringBuffer : StringMaker = new StringMaker()
        stringBuffer.append(this.sqlStrings.UPDATE)
        stringBuffer.append(this.getTableName())
        stringBuffer.append(this.sqlStrings.SET)
        try {
            val keyArray : Array[Object] = updatedKeyValuePairs.keySet().toArray()
            val size : Int = keyArray.length

            {
                var i : Int = 0
                while (i < size) {
                    val columnName : String = keyArray(i).toString()
                    stringBuffer.append(this.commonSeps.SPACE)
                    stringBuffer.append(columnName)
                    stringBuffer.append(this.EQUAL_QUOTE)
                    var columnValue : String = updatedKeyValuePairs.get(columnName).asInstanceOf[String]
                    if (columnValue == null) {
                        columnValue = this.stringUtil.EMPTY_STRING
                    } else {
                        columnValue = new Replace(this.sqlStrings.CLOSE_QUOTE, this.ESCAPE_QUOTES).all(columnValue)
                    }
                    stringBuffer.append(this.getValue(columnValue))
                    stringBuffer.append(this.sqlStrings.CLOSE_QUOTE)
                    if (i < (size - 1)) {
                        stringBuffer.append(this.commonSeps.COMMA)
                    }
                    i += 1
                }
            }
            stringBuffer.append(this.sqlStrings.WHERE)
            stringBuffer.append(key)
            stringBuffer.append(this.sqlStrings.EQUAL_QUOTE)
            stringBuffer.append(this.getValue(value))
            stringBuffer.append(this.sqlStrings.CLOSE_QUOTE)
            val sqlStatement : String = stringBuffer.toString()
            this.executeSQLStatement(sqlStatement)
            if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().SQLLOGGING)) {
                this.logUtil_AbSqlRow.putF(this.SUCCESS_SQL_STATEMENT + sqlStatement, this, this.METHOD_UPDATE_WHERE)
            }
        } catch {
            case e : Exception => {
                if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().SQLLOGGINGERROR)) {
                    this.logUtil_AbSqlRow.put(this.FAILED_SQL_STATEMENT + stringBuffer, this, METHOD_UPDATE_WHERE, e)
                }
            }
        }
    }

    def updateWhere(whereKeyValuePairs : HashMap[Object, Object], updatedKeyValuePairs : HashMap[Object, Object]) : Unit = this.synchronized {
        val stringBuffer : StringMaker = new StringMaker()
        stringBuffer.append(this.sqlStrings.UPDATE)
        stringBuffer.append(this.getTableName())
        stringBuffer.append(this.sqlStrings.SET)
        try {
            val keyArray : Array[Object] = updatedKeyValuePairs.keySet().toArray()
            val size : Int = keyArray.length

            {
                var i : Int = 0
                while (i < size) {
                    val columnName : String = keyArray(i).toString()
                    stringBuffer.append(this.commonSeps.SPACE)
                    stringBuffer.append(columnName)
                    stringBuffer.append(this.EQUAL_QUOTE)
                    if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().SQLLOGGING)) {
                        this.logUtil_AbSqlRow.putF(this.COLUMN_NAME_LABEL + columnName, this, this.METHOD_UPDATE_WHERE)
                    }
                    var columnValue : String = updatedKeyValuePairs.get(columnName).asInstanceOf[String]
                    if (columnValue == null) {
                        columnValue = this.stringUtil.EMPTY_STRING
                    } else {
                        columnValue = new Replace(this.sqlStrings.CLOSE_QUOTE, this.ESCAPE_QUOTES).all(columnValue)
                    }
                    stringBuffer.append(this.getValue(columnValue))
                    stringBuffer.append(this.sqlStrings.CLOSE_QUOTE)
                    if (i < (size - 1)) {
                        stringBuffer.append(this.commonSeps.COMMA)
                    }
                    i += 1
                }
            }
            stringBuffer.append(this.sqlStrings.WHERE)
            val set : Set[Object] = whereKeyValuePairs.keySet().asInstanceOf[Set[Object]]
            val keyArray2 : Array[Object] = set.toArray()
            val size2 : Int = keyArray2.length

            {
                var i : Int = 0
                while (i < size2) {
                    val key : String = keyArray2(i).asInstanceOf[String]
                    val value : String = whereKeyValuePairs.get(key).asInstanceOf[String]
                    //if(value!=null && value.compareTo("null")!=0)

                    {
                        stringBuffer.append(key)
                        stringBuffer.append(this.sqlStrings.EQUAL_QUOTE)
                        stringBuffer.append(this.getValue(value))
                        stringBuffer.append(this.sqlStrings.CLOSE_QUOTE)
                        if (i < (size2 - 1)) {
                            stringBuffer.append(this.sqlStrings.AND)
                        }
                    }
                    i += 1
                }
            }
            val sqlStatement : String = stringBuffer.toString()
            this.executeSQLStatement(sqlStatement)
            if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().SQLLOGGING)) {
                this.logUtil_AbSqlRow.putF(this.SUCCESS_SQL_STATEMENT + sqlStatement, this, this.METHOD_UPDATE_WHERE)
            }
        } catch {
            case e : Exception => {
                if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().SQLLOGGINGERROR)) {
                    this.logUtil_AbSqlRow.put(this.FAILED_SQL_STATEMENT + stringBuffer, this, METHOD_UPDATE_WHERE, e)
                }
                throw e
            }
        }
    }

    def deleteWhere(key : String, value : String) : Unit = this.synchronized {
        val stringBuffer : StringMaker = new StringMaker()
        stringBuffer.append(this.sqlStrings.DELETE)
        stringBuffer.append(this.sqlStrings.FROM)
        stringBuffer.append(this.getTableName())
        stringBuffer.append(this.sqlStrings.WHERE)
        stringBuffer.append(key)
        stringBuffer.append(this.sqlStrings.EQUAL_QUOTE)
        stringBuffer.append(value)
        stringBuffer.append(this.sqlStrings.CLOSE_QUOTE)
        try {
            val sqlStatement : String = stringBuffer.toString()
            this.executeSQLStatement(sqlStatement)
            if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().SQLLOGGING)) {
                this.logUtil_AbSqlRow.putF(this.SUCCESS_SQL_STATEMENT + sqlStatement, this, this.METHOD_DELETE_WHERE)
            }
        } catch {
            case e : Exception => {
                if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().SQLLOGGINGERROR)) {
                    this.logUtil_AbSqlRow.put(this.FAILED_SQL_STATEMENT + stringBuffer.toString(), this, this.METHOD_DELETE_WHERE, e)
                }
            }
        }
    }

    def deleteWhere(keysAndValues : HashMap[Object, Object]) : Unit = this.synchronized {
        val stringBuffer : StringMaker = new StringMaker()
        stringBuffer.append(this.sqlStrings.DELETE)
        stringBuffer.append(this.sqlStrings.FROM)
        stringBuffer.append(this.getTableName())
        stringBuffer.append(this.sqlStrings.WHERE)
        try {
            val set : Set[Object] = keysAndValues.keySet().asInstanceOf[Set[Object]]
            val keyArray : Array[Object] = set.toArray()
            val size : Int = keyArray.length

            {
                var i : Int = 0
                while (i < size) {
                    var key : String = keyArray(i).asInstanceOf[String]
                    var value : String = new String(keysAndValues.get(key).asInstanceOf[String])
                    stringBuffer.append(key)
                    stringBuffer.append(this.sqlStrings.EQUAL_QUOTE)
                    stringBuffer.append(this.getValue(value))
                    stringBuffer.append(this.sqlStrings.CLOSE_QUOTE)
                    if (i < (size - 1)) {
                        stringBuffer.append(this.sqlStrings.AND)
                    }
                    i += 1
                }
            }
            val sqlStatement : String = stringBuffer.toString()
            this.executeSQLStatement(sqlStatement)
            if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().SQLLOGGING)) {
                this.logUtil_AbSqlRow.putF(this.SUCCESS_SQL_STATEMENT + sqlStatement, this, this.METHOD_DELETE_WHERE)
            }
        } catch {
            case e : Exception => {
                if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().SQLLOGGINGERROR)) {
                    this.logUtil_AbSqlRow.put(this.FAILED_SQL_STATEMENT + stringBuffer.toString(), this, this.METHOD_DELETE_WHERE, e)
                }
            }
        }
    }

    def insert(values : BasicArrayList) : Unit = {
        val stringBuffer : StringMaker = new StringMaker()
        stringBuffer.append(this.sqlStrings.INSERT_INTO)
        stringBuffer.append(this.getTableName())
        stringBuffer.append(this.sqlStrings.VALUES)
        try {

            {
                var i : Int = 0
                while (i < (values.size() - 1)) {
                    var value : String = this.getValue(values.get(i).asInstanceOf[String])
                    value = new Replace(this.sqlStrings.ESCAPE, this.sqlStrings.DOUBLE_ESCAPE).all(value)
                    stringBuffer.append(value)
                    stringBuffer.append(this.sqlStrings.SINGLE_QUOTE_COMMA_SEP)
                    i += 1
                }
            }
            var value : String = this.getValue(values.get(values.size() - 1).asInstanceOf[String])
            value = new Replace(this.sqlStrings.ESCAPE, this.sqlStrings.DOUBLE_ESCAPE).all(value)
            stringBuffer.append(value)
            stringBuffer.append(this.INSERT_END)
            var sqlStatement : String = stringBuffer.toString()
            this.executeSQLStatement(sqlStatement)
            if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().SQLLOGGING)) {
                this.logUtil_AbSqlRow.putF(this.SUCCESS_SQL_STATEMENT + sqlStatement, this, this.INSERT)
            }
        } catch {
            case e : Exception => {
                if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().SQLLOGGINGERROR)) {
                    this.logUtil_AbSqlRow.put(this.FAILED_SQL_STATEMENT + stringBuffer.toString(), this, INSERT, e)
                }
            }
        }
    }

    def getRow(keysAndValues : HashMap[Object, Object]) : HashMap[Object, Object] = {
        val stringBuffer : StringMaker = new StringMaker()
        stringBuffer.append(this.sqlStrings.SELECT_ALL_FROM)
        stringBuffer.append(this.getTableName())
        stringBuffer.append(this.sqlStrings.WHERE)
        try {
            var result : HashMap[Object, Object] = null
            val set : Set[Object] = keysAndValues.keySet().asInstanceOf[Set[Object]]
            val keyArray : Array[Object] = set.toArray()
            val size : Int = keyArray.length

            {
                var index : Int = 0
                while (index < size) {
                    val key : String = keyArray(index).asInstanceOf[String]
                    val value : String = new String(keysAndValues.get(key).asInstanceOf[String])
                    stringBuffer.append(key)
                    stringBuffer.append(this.sqlStrings.EQUAL_QUOTE)
                    stringBuffer.append(this.getValue(value))
                    stringBuffer.append(this.sqlStrings.CLOSE_QUOTE)
                    if (index < (size - 1)) {
                        stringBuffer.append(this.sqlStrings.AND)
                    }
                    index += 1
                }
            }
            val sqlStatement : String = stringBuffer.toString()
            if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().SQLLOGGING)) {
                this.logUtil_AbSqlRow.putF(this.sqlStrings.SQL_STATEMENT_LABEL + sqlStatement, this, this.METHOD_GET_ROW)
            }
            val rset : ResultSet = this.executeSQLStatement(sqlStatement)
            val resultSetMetaData : ResultSetMetaData = rset.getMetaData()

            {
                while (rset.next()) {
                    result = this.stdUtil.createHashMap().asInstanceOf[HashMap[Object, Object]]
                    //BasicArrayList columnNames = this.stdUtil.createVector();
                    var columnCount : Int = resultSetMetaData.getColumnCount()

                    {
                        var index : Int = 1
                        while (index <= columnCount) {
                            var columnName : String = resultSetMetaData.getColumnName(index)
                            var field : String = rset.getString(columnName)
                            result.put(columnName, field)
                            index += 1
                        }
                    }
                    if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().SQLLOGGING)) {
                        this.logUtil_AbSqlRow.putF(this.ROW_VALUE_LABEL + result.toString(), this, this.METHOD_GET_ROW)
                    }
                    return result
                }
            }
            if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().SQLLOGGINGERROR)) {
                this.logUtil_AbSqlRow.putF(this.NO_RESULTS_IN_RESULT_SET, this, this.METHOD_GET_ROW)
            }
            return null
        } catch {
            case e : Exception => {
                if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().SQLLOGGINGERROR)) {
                    this.logUtil_AbSqlRow.put(this.FAILED_SQL_STATEMENT + stringBuffer, this, this.METHOD_GET_ROW, e)
                }
                return null
            }
        }
        throw new IllegalStateException()
    }

    def getRows(keysAndValues : HashMap[Object, Object]) : BasicArrayList = {
        return this.getRows(keysAndValues, StringUtil.getInstance().EMPTY_STRING)
    }

    def getRows(keysAndValues : HashMap[Object, Object], more : String) : BasicArrayList = {
        val stringBuffer : StringMaker = new StringMaker()
        stringBuffer.append(this.sqlStrings.SELECT_ALL_FROM)
        stringBuffer.append(this.getTableName())
        stringBuffer.append(this.sqlStrings.WHERE)
        try {
            val rows : BasicArrayList = new BasicArrayListD()
            val set : Set[Object] = keysAndValues.keySet().asInstanceOf[Set[Object]]
            val keyArray : Array[Object] = set.toArray()
            val size : Int = keyArray.length

            {
                var index : Int = 0
                while (index < size) {
                    val key : String = keyArray(index).asInstanceOf[String]
                    val value : String = new String(keysAndValues.get(key).asInstanceOf[String])
                    stringBuffer.append(key)
                    stringBuffer.append(this.sqlStrings.EQUAL_QUOTE)
                    stringBuffer.append(this.getValue(value))
                    stringBuffer.append(this.sqlStrings.CLOSE_QUOTE)
                    if (index < (size - 1)) {
                        stringBuffer.append(this.sqlStrings.AND)
                    }
                    index += 1
                }
            }
            if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().SQLLOGGING)) {
                this.logUtil_AbSqlRow.putF(this.sqlStrings.SQL_STATEMENT_LABEL + stringBuffer, this, this.METHOD_GET_ROWS)
            }
            stringBuffer.append(more)
            val sqlStatement : String = stringBuffer.toString()
            val rset : ResultSet = this.executeSQLStatement(sqlStatement)
            val resultSetMetaData : ResultSetMetaData = rset.getMetaData()

            {
                while (rset.next()) {
                    val result : HashMap[Object, Object] = this.stdUtil.createHashMap().asInstanceOf[HashMap[Object, Object]]
                    //BasicArrayList columnNames = this.stdUtil.createVector();
                    val columnCount : Int = resultSetMetaData.getColumnCount()

                    {
                        var index : Int = 1
                        while (index <= columnCount) {
                            val columnName : String = resultSetMetaData.getColumnName(index)
                            val field : String = rset.getString(columnName)
                            result.put(columnName, field)
                            index += 1
                        }
                    }
                    val resultAsString : String = result.toString()
                    if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().SQLLOGGING)) {
                        this.logUtil_AbSqlRow.putF(this.GET_ROW + resultAsString, this, this.METHOD_GET_ROWS)
                    }
                    //this.logUtil.putF(this.GET_ROW + resultAsString, this, this.METHOD_GET_ROWS);
                    rows.add(result)
                }
            }
            return rows
        } catch {
            case e : Exception => {
                if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().SQLLOGGINGERROR)) {
                    this.logUtil_AbSqlRow.put(this.FAILED_SQL_STATEMENT + stringBuffer, this, this.METHOD_GET_ROWS, e)
                }
                return null
            }
        }
        throw new IllegalStateException()
    }

    def getAllRows() : BasicArrayList = {
        val stringBuffer : StringMaker = new StringMaker()
        stringBuffer.append(this.sqlStrings.SELECT_ALL_FROM)
        stringBuffer.append(this.getTableName())
        try {
            if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().SQLLOGGING)) {
                this.logUtil_AbSqlRow.putF(this.sqlStrings.SQL_STATEMENT_LABEL + stringBuffer, this, this.METHOD_GET_ALL_ROWS)
            }
            val rows : BasicArrayList = new BasicArrayListD()
            val sqlStatement : String = stringBuffer.toString()
            val rset : ResultSet = this.executeSQLStatement(sqlStatement)
            val resultSetMetaData : ResultSetMetaData = rset.getMetaData()

            {
                while (rset.next()) {
                    val result : HashMap[Object, Object] = this.stdUtil.createHashMap().asInstanceOf[HashMap[Object, Object]]
                    //final BasicArrayList columnNames = this.stdUtil.createVector();
                    var columnCount : Int = resultSetMetaData.getColumnCount()

                    {
                        var index : Int = 1
                        while (index <= columnCount) {
                            val columnName : String = resultSetMetaData.getColumnName(index)
                            val field : String = rset.getString(columnName)
                            result.put(columnName, field)
                            index += 1
                        }
                    }
                    if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().SQLLOGGING)) {
                        this.logUtil_AbSqlRow.putF(this.ROW_VALUES_LABEL + result.toString(), this, this.METHOD_GET_ALL_ROWS)
                    }
                    rows.add(result)
                }
            }
            return rows
        } catch {
            case e : Exception => {
                if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().SQLLOGGINGERROR)) {
                    this.logUtil_AbSqlRow.put(this.FAILED_SQL_STATEMENT + stringBuffer, this, this.METHOD_GET_ALL_ROWS, e)
                }
                return null
            }
        }
        throw new IllegalStateException()
    }

    /*     public BasicArrayList getRowsWhereLike(HashMap keysAndValues, HashMap likeKeysAndValues)     {         StringMaker stringBuffer = new StringMaker();                  stringBuffer.append(this.sqlStrings.SELECT_ALL);         stringBuffer.append(this.sqlStrings.FROM);         stringBuffer.append(this.getTableName());         stringBuffer.append(this.sqlStrings.WHERE);          try         {             BasicArrayList rows = this.stdUtil.createVector();             Set set = keysAndValues.keySet();             iter = set;              while (iter.hasNext())             {                 String key = (String) iter.next();                 String value = new String((String) keysAndValues.get(key));                  stringBuffer.append(key);                 stringBuffer.append(this.sqlStrings.EQUAL_QUOTE);                  stringBuffer.append(this.getValue(value));                 stringBuffer.append(this.sqlStrings.CLOSE_QUOTE);                  if (iter.hasNext() && likeKeysAndValues.size() == 0)                 {                     stringBuffer.append(this.sqlStrings.AND);                 }             }              set = likeKeysAndValues.keySet();             iter = set;              while (iter.hasNext())             {                 String key = (String) iter.next();                 String value = new String((String) likeKeysAndValues.get(key));                  stringBuffer.append(key);                 stringBuffer.append(this.sqlStrings.LIKE_QUOTE);                  stringBuffer.append(this.getValue(value));                 stringBuffer.append(this.sqlStrings.CLOSE_QUOTE);                  if (iter.hasNext())                 {                     stringBuffer.append(this.sqlStrings.AND);                 }             }              String sqlStatement = stringBuffer.toString();              if (org.allbinary.logic.communication.log.config.type.LogConfigTypes.LOGGING.contains(org.allbinary.logic.communication.log.config.type.LogConfigTypeFactory.getInstance().SQLLOGGING))             {                 this.logUtil.putF(this.sqlStrings.SQL_STATEMENT_LABEL + sqlStatement, this, "getRowsWhereLike");             }              ResultSet rset = this.executeSQLStatement(sqlStatement);             ResultSetMetaData resultSetMetaData = rset.getMetaData();              while (rset.next())             {                 HashMap result = this.stdUtil.createHashMap();                 BasicArrayList columnNames = this.stdUtil.createVector();                 int columnCount = resultSetMetaData.getColumnCount();                 for (int index = 1; index <= columnCount; index++)                 {                     String columnName = resultSetMetaData.getColumnName(index);                     String field = rset.getString(columnName);                     result.put(columnName, field);                 }                  if (org.allbinary.logic.communication.log.config.type.LogConfigTypes.LOGGING.contains(org.allbinary.logic.communication.log.config.type.LogConfigTypeFactory.getInstance().SQLLOGGING))                 {                     this.logUtil.putF(this.ROW_VALUE_LABEL + result.toString(), this, "getRowsWhereLike");                 }                 rows.add(result);             }             return rows;         } catch (Exception e)         {             if (org.allbinary.logic.communication.log.config.type.LogConfigTypes.LOGGING.contains(org.allbinary.logic.communication.log.config.type.LogConfigTypeFactory.getInstance().SQLLOGGINGERROR))             {                 this.logUtil.put(this.FAILED_SQL_STATEMENT + stringBuffer, this, "getRowsWhereLike", e);             }             return this.stdUtil.createVector();         }     }     */
    def getRowsWhereBetween(whereKeyValuePairs : HashMap[Object, Object], betweenColumn : String, smallest : String, largest : String) : BasicArrayList = {
        val stringBuffer : StringMaker = new StringMaker()
        stringBuffer.append(this.sqlStrings.SELECT_ALL_FROM)
        stringBuffer.append(this.getTableName())
        try {
            val rows : BasicArrayList = new BasicArrayListD()
            stringBuffer.append(this.sqlStrings.WHERE)
            val set : Set[Object] = whereKeyValuePairs.keySet().asInstanceOf[Set[Object]]
            var key : String = null
            var value : String = null
            val keyArray : Array[Object] = set.toArray()
            val size : Int = keyArray.length

            {
                var index : Int = 0
                while (index < size) {
                    key = keyArray(index).asInstanceOf[String]
                    value = whereKeyValuePairs.get(key).asInstanceOf[String]
                    stringBuffer.append(key)
                    stringBuffer.append(this.sqlStrings.EQUAL_QUOTE)
                    stringBuffer.append(this.getValue(value))
                    stringBuffer.append(this.sqlStrings.CLOSE_QUOTE)
                    stringBuffer.append(this.sqlStrings.AND)
                    index += 1
                }
            }
            stringBuffer.append(betweenColumn)
            stringBuffer.append(this.sqlStrings.MORE_THAN_QUOTE)
            stringBuffer.append(smallest)
            stringBuffer.append(this.sqlStrings.CLOSE_QUOTE)
            stringBuffer.append(this.sqlStrings.AND)
            stringBuffer.append(betweenColumn)
            stringBuffer.append(this.sqlStrings.LESS_THAN_QUOTE)
            stringBuffer.append(largest)
            stringBuffer.append(this.sqlStrings.CLOSE_QUOTE)
            val sqlStatement : String = stringBuffer.toString()
            if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().SQLLOGGING)) {
                this.logUtil_AbSqlRow.putF(this.sqlStrings.SQL_STATEMENT_LABEL + sqlStatement, this, this.METHOD_GET_ROWS_WHERE_BETWEEN)
            }
            val rset : ResultSet = this.executeSQLStatement(sqlStatement)
            val resultSetMetaData : ResultSetMetaData = rset.getMetaData()
            var result : HashMap[Object, Object] = null
            var columnNames : BasicArrayList = null
            var columnCount : Int = 0
            var columnName : String = null
            var field : String = null

            {
                while (rset.next()) {
                    result = this.stdUtil.createHashMap().asInstanceOf[HashMap[Object, Object]]
                    columnNames = new BasicArrayListD()
                    columnCount = resultSetMetaData.getColumnCount()

                    {
                        var index : Int = 1
                        while (index <= columnCount) {
                            columnName = resultSetMetaData.getColumnName(index)
                            field = rset.getString(columnName)
                            result.put(columnName, field)
                            index += 1
                        }
                    }
                    if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().SQLLOGGING)) {
                        this.logUtil_AbSqlRow.putF(this.ROW_VALUE_LABEL + result.toString(), this, this.METHOD_GET_ROWS_WHERE_BETWEEN)
                    }
                    rows.add(result)
                }
            }
            return rows
        } catch {
            case e : Exception => {
                if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().SQLLOGGINGERROR)) {
                    this.logUtil_AbSqlRow.put(this.FAILED_SQL_STATEMENT + stringBuffer, this, METHOD_GET_ROWS_WHERE_BETWEEN, e)
                }
                return null
            }
        }
        throw new IllegalStateException()
    }

    def getRowsWhereBetween(betweenColumn : String, smallest : String, largest : String) : BasicArrayList = {
        val stringBuffer : StringMaker = new StringMaker()
        stringBuffer.append(this.sqlStrings.SELECT_ALL_FROM)
        stringBuffer.append(this.getTableName())
        try {
            val rows : BasicArrayList = new BasicArrayListD()
            stringBuffer.append(this.sqlStrings.WHERE)
            stringBuffer.append(betweenColumn)
            stringBuffer.append(this.sqlStrings.MORE_THAN_QUOTE)
            stringBuffer.append(smallest)
            stringBuffer.append(this.sqlStrings.CLOSE_QUOTE)
            stringBuffer.append(this.sqlStrings.AND)
            stringBuffer.append(betweenColumn)
            stringBuffer.append(this.sqlStrings.LESS_THAN_QUOTE)
            stringBuffer.append(largest)
            stringBuffer.append(this.sqlStrings.CLOSE_QUOTE)
            val sqlStatement : String = stringBuffer.toString()
            if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().SQLLOGGING)) {
                this.logUtil_AbSqlRow.putF(this.sqlStrings.SQL_STATEMENT_LABEL + sqlStatement, this, this.METHOD_GET_ROWS_WHERE_BETWEEN)
            }
            val rset : ResultSet = this.executeSQLStatement(sqlStatement)
            val resultSetMetaData : ResultSetMetaData = rset.getMetaData()
            var columnName : String = null
            var field : String = null
            var result : HashMap[Object, Object] = null
            var columnNames : BasicArrayList = null
            var columnCount : Int = 0

            {
                while (rset.next()) {
                    result = this.stdUtil.createHashMap().asInstanceOf[HashMap[Object, Object]]
                    columnNames = new BasicArrayListD()
                    columnCount = resultSetMetaData.getColumnCount()

                    {
                        var index : Int = 1
                        while (index <= columnCount) {
                            columnName = resultSetMetaData.getColumnName(index)
                            field = rset.getString(columnName)
                            result.put(columnName, field)
                            index += 1
                        }
                    }
                    if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().SQLLOGGING)) {
                        this.logUtil_AbSqlRow.putF(this.ROW_VALUE_LABEL + result.toString(), this, this.METHOD_GET_ROWS_WHERE_BETWEEN)
                    }
                    rows.add(result)
                }
            }
            return rows
        } catch {
            case e : Exception => {
                if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().SQLLOGGINGERROR)) {
                    this.logUtil_AbSqlRow.put(this.FAILED_SQL_STATEMENT + stringBuffer, this, METHOD_GET_ROWS_WHERE_BETWEEN, e)
                }
                return null
            }
        }
        throw new IllegalStateException()
    }

}


