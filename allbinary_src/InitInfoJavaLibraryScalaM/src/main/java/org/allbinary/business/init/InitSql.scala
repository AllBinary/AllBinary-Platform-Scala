/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.business.init

import _root_.java.sql.Connection
import _root_.java.sql.DriverManager
import _root_.java.sql.ResultSet
import _root_.java.sql.ResultSetMetaData
import _root_.java.sql.SQLException
import _root_.java.sql.Statement
import _root_.java.util.HashMap
import _root_.java.util.Set
import _root_.org.allbinary.util.BasicArrayList
import _root_.org.allbinary.util.BasicArrayListD
import _root_.org.allbinary.business.init.db.DatabaseConnectionInfoInterface
import _root_.org.allbinary.business.init.db.DbConnectionInfo
import _root_.org.allbinary.logic.StdUtil
import _root_.org.allbinary.logic.communication.log.PreLogUtil
import _root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory
import _root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes
import _root_.org.allbinary.logic.communication.sql.SqlStrings
import _root_.org.allbinary.logic.communication.sql.SqlTypeStrings
import _root_.org.allbinary.logic.string.StringMaker
import _root_.org.allbinary.logic.string.StringUtil
import _root_.org.allbinary.logic.string.StringValidationUtil
import _root_.org.allbinary.string.CommonSeps
import _root_.org.allbinary.string.CommonStrings

class InitSql(param_databaseConnectionInfoInterface : DbConnectionInfo) {

    //protected final LogUtil logUtil = LogUtil.getInstance();
    val stringUtil : StringUtil = StringUtil.getInstance()

    val commonSeps : CommonSeps = CommonSeps.getInstance()

    val sqlTypeStrings : SqlTypeStrings = SqlTypeStrings.getInstance()

    val sqlStrings : SqlStrings = SqlStrings.getInstance()

    val stdUtil : StdUtil = StdUtil.getInstance()

    val INSERT : String = "insert"

    val UPDATE : String = "update"

    private var databaseConnectionInfoInterface : DbConnectionInfo = null

    private var userid : String = null

    private var password : String = null

    private var tableName : String = null

    private var conn : Connection = null

    private var useridAndPassword : Boolean = false

    val SUCCESS_SQL_STATEMENT : String = "Success\nSQL Statement: "

    val FAILED_SQL_STATEMENT : String = "Failed\nSQL Statement: "

    private val INIT_SQL : String = "InitSql"

    val commonStrings : CommonStrings = CommonStrings.getInstance()

    private val EQUAL_QUOTE : String = "=\""

    //private final String ESCAPE_QUOTES = "\\\"";
    private val METHOD_GET_ROW : String = "getRow()"

    private val METHOD_UPDATE_WHERE : String = "updateWhere()"

    private val ROW_VALUE_LABEL : String = "Row Value: "

    private val NO_RESULTS_IN_RESULT_SET : String = "No Results in ResultSet"

    private val INSERT_END : String = "')"

    //Constructor
    {
        val databaseConnectionInfoInterface : DbConnectionInfo = param_databaseConnectionInfoInterface
        this.setDatabaseConnectionInfoInterface(databaseConnectionInfoInterface)
    }

    def setTable(tableName : String) : Unit = {
        this.tableName = tableName
    }

    def setDatabaseConnectionInfoInterface(databaseConnectionInfoInterface : DbConnectionInfo) : Unit = {
        this.databaseConnectionInfoInterface = databaseConnectionInfoInterface
    }

    def createTable(tableData : String) : Boolean = {
        try {
            val stringBuffer : StringMaker = new StringMaker()
            stringBuffer.append("Creating Table: ")
            stringBuffer.append(tableData)
            PreLogUtil.put(stringBuffer.toString(), INIT_SQL, "createTable()")
            this.executeSQLStatement(tableData)
            return true
        } catch {
            case e : Exception => {
                if (LogConfigTypes.LOGGING.contains(LogConfigTypeFactory.getInstance().SQLLOGGINGERROR)) {
                    PreLogUtil.putOE(this.commonStrings.EXCEPTION, INIT_SQL, "createTable()", e)
                }
                return false
            }
        }
        throw new IllegalStateException()
    }

    def dropTable() : Boolean = {
        var sqlStatement : String = this.sqlStrings.DROP_TABLE + this.tableName
        try {
            this.executeSQLStatement(sqlStatement)
            return true
        } catch {
            case e : Exception => {
                if (LogConfigTypes.LOGGING.contains(LogConfigTypeFactory.getInstance().SQLLOGGINGERROR)) {
                    PreLogUtil.putOE(this.commonStrings.EXCEPTION, INIT_SQL, "dropTables()", e)
                }
                return false
            }
        }
        throw new IllegalStateException()
    }

    def getRow(keysAndValues : HashMap[Object, Object]) : HashMap[Object, Object] = {
        var stringBuffer : StringMaker = new StringMaker()
        stringBuffer.append(this.sqlStrings.SELECT_ALL_FROM)
        stringBuffer.append(this.tableName)
        stringBuffer.append(this.sqlStrings.WHERE)
        try {
            var result : HashMap[Object, Object] = null
            var set : Set[Object] = keysAndValues.keySet().asInstanceOf[Set[Object]]
            var keyArray : Array[Object] = set.toArray()
            var size : Int = keyArray.length

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
            var sqlStatement : String = stringBuffer.toString()
            if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().SQLLOGGING)) {
                PreLogUtil.put(this.sqlStrings.SQL_STATEMENT_LABEL + sqlStatement, this.INIT_SQL, this.METHOD_GET_ROW)
            }
            var rset : ResultSet = this.executeSQLStatement(sqlStatement)
            var resultSetMetaData : ResultSetMetaData = rset.getMetaData()

            {
                while (rset.next()) {
                    result = stdUtil.createHashMap().asInstanceOf[HashMap[Object, Object]]
                    //BasicArrayList columnNames = new BasicArrayListD();
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
                        PreLogUtil.put(this.ROW_VALUE_LABEL + result.toString(), this.INIT_SQL, this.METHOD_GET_ROW)
                    }
                    return result
                }
            }
            if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().SQLLOGGINGERROR)) {
                PreLogUtil.put(this.NO_RESULTS_IN_RESULT_SET, this.INIT_SQL, this.METHOD_GET_ROW)
            }
            return null
        } catch {
            case e : Exception => {
                if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().SQLLOGGINGERROR)) {
                    PreLogUtil.putOE(this.FAILED_SQL_STATEMENT + stringBuffer, this.INIT_SQL, this.METHOD_GET_ROW, e)
                }
                return null
            }
        }
        throw new IllegalStateException()
    }

    def updateWhere(key : String, value : String, updatedKeyValuePairs : HashMap[Object, Object]) : Unit = this.synchronized {
        var stringBuffer : StringMaker = new StringMaker()
        stringBuffer.append(this.sqlStrings.UPDATE)
        stringBuffer.append(this.tableName)
        stringBuffer.append(this.sqlStrings.SET)
        try {
            var columnArray : Array[Object] = updatedKeyValuePairs.keySet().toArray()
            var size : Int = columnArray.length

            {
                var i : Int = 0
                while (i < size) {
                    var columnName : String = columnArray(i).toString()
                    stringBuffer.append(this.commonSeps.SPACE)
                    stringBuffer.append(columnName)
                    stringBuffer.append(this.EQUAL_QUOTE)
                    var columnValue : String = updatedKeyValuePairs.get(columnName).asInstanceOf[String]
                    if (columnValue == null) {
                        columnValue = this.stringUtil.EMPTY_STRING
                    } else {
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
            var sqlStatement : String = stringBuffer.toString()
            this.executeSQLStatement(sqlStatement)
            if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().SQLLOGGING)) {
                PreLogUtil.put(this.SUCCESS_SQL_STATEMENT + sqlStatement, this.INIT_SQL, METHOD_UPDATE_WHERE)
            }
        } catch {
            case e : Exception => {
                if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().SQLLOGGINGERROR)) {
                    PreLogUtil.putOE(this.FAILED_SQL_STATEMENT + stringBuffer, this.INIT_SQL, METHOD_UPDATE_WHERE, e)
                }
            }
        }
    }

    def insert(values : BasicArrayList) : Unit = {
        val stringBuffer : StringMaker = new StringMaker()
        stringBuffer.append(this.sqlStrings.INSERT_INTO)
        stringBuffer.append(this.tableName)
        stringBuffer.append(this.sqlStrings.VALUES)
        try {
            val size : Int = values.size()

            {
                var i : Int = 0
                while (i < (size - 1)) {
                    var value : String = this.getValue(values.get(i).asInstanceOf[String])
                    //value = new Replace(this.sqlStrings.ESCAPE, this.sqlStrings.DOUBLE_ESCAPE).all(value);
                    stringBuffer.append(value)
                    stringBuffer.append(this.sqlStrings.SINGLE_QUOTE_COMMA_SEP)
                    i += 1
                }
            }
            val value : String = this.getValue(values.get(values.size() - 1).asInstanceOf[String])
            //value = new Replace(this.sqlStrings.ESCAPE, this.sqlStrings.DOUBLE_ESCAPE).all(value);
            stringBuffer.append(value)
            stringBuffer.append(this.INSERT_END)
            val sqlStatement : String = stringBuffer.toString()
            this.executeSQLStatement(sqlStatement)
            if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().SQLLOGGING)) {
                PreLogUtil.put(this.SUCCESS_SQL_STATEMENT + sqlStatement, this.INIT_SQL, INSERT)
            }
        } catch {
            case e : Exception => {
                if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().SQLLOGGINGERROR)) {
                    PreLogUtil.putOE(this.FAILED_SQL_STATEMENT + stringBuffer.toString(), this.INIT_SQL, INSERT, e)
                }
            }
        }
    }

    private def getValue(value : String) : String = this.synchronized {
        if (StringValidationUtil.getInstance().isEmpty(value)) {
            return this.stringUtil.EMPTY_STRING
        } else {
            return value
        }
        throw new IllegalStateException()
    }

    def executeSQLStatement(statement : String) : ResultSet = {
        try {
            if (this.conn == null) {
                this.initialize()
            }
            var stmt : Statement = this.conn.createStatement()
            //TWB- Changes For GAE JIQL
            stmt.execute(statement)
            var rset : ResultSet = stmt.getResultSet()
            stmt.close()
            return rset
        } catch {
            case e : SQLException => {
                if (LogConfigTypes.LOGGING.contains(LogConfigTypeFactory.getInstance().SQLLOGGINGERROR)) {
                    PreLogUtil.putOE(this.commonStrings.EXCEPTION, INIT_SQL, "executeSQLStatement()", e)
                }
                throw e
            }
            case e : Exception => {
                if (LogConfigTypes.LOGGING.contains(LogConfigTypeFactory.getInstance().SQLLOGGINGERROR)) {
                    PreLogUtil.putOE(this.commonStrings.EXCEPTION, INIT_SQL, "executeSQLStatement()", e)
                }
                throw e
            }
        }
        throw new IllegalStateException()
    }

    private def createConnection() : Unit = {
        try {
            if (this.useridAndPassword == true) {
                this.conn = DriverManager.getConnection(this.databaseConnectionInfoInterface.getUrl(), this.userid, this.password)
            } else {
                this.conn = DriverManager.getConnection(this.databaseConnectionInfoInterface.getUrl())
            }
        } catch {
            case se : SQLException => {
                PreLogUtil.putOE(this.commonStrings.EXCEPTION, INIT_SQL, "createConnection()", se)
                throw se
            }
        }
    }

    private def initialize() : Unit = {
        try {
            try {
                val jdbcDriver : String = this.databaseConnectionInfoInterface.getJdbcDriver()
                PreLogUtil.put(new StringMaker().append("Loading DbConnnectionInfo: ").append(this.databaseConnectionInfoInterface.getClass().getName()).append(" Driver: ").append(jdbcDriver).toString(), this.INIT_SQL, "initialize()")
                Class.forName(jdbcDriver).newInstance()
            } catch {
                case e : Exception => {
                    if (LogConfigTypes.LOGGING.contains(LogConfigTypeFactory.getInstance().SQLLOGGINGERROR)) {
                        PreLogUtil.putOE("LoadDriver Failed: " + this.databaseConnectionInfoInterface.getJdbcDriver(), this.INIT_SQL, "initialize()", e)
                    }
                    throw e
                }
            }
            if ((this.userid == null) && (this.password == null)) {
                this.useridAndPassword = true
            }
            this.createConnection()
        } catch {
            case se : Exception => {
                if (LogConfigTypes.LOGGING.contains(LogConfigTypeFactory.getInstance().SQLLOGGINGERROR)) {
                    PreLogUtil.putOE(this.commonStrings.EXCEPTION, INIT_SQL, "initialize()", se)
                }
                throw se
            }
        }
    }

    def getDatabaseConnectionInfoInterface() : DatabaseConnectionInfoInterface = {
        return this.databaseConnectionInfoInterface
    }

}


