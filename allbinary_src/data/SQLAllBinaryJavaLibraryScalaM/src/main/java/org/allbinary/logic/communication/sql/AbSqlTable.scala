/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.logic.communication.sql

import _root_.org.allbinary.business.init.db.DbConnectionInfo
import _root_.org.allbinary.logic.communication.log.LogUtil

class AbSqlTable(param_databaseConnectionInfoInterface : DbConnectionInfo) extends AbSqlBasic(param_databaseConnectionInfoInterface) {

    val logUtil_AbSqlTable : LogUtil = LogUtil.getInstance()

    private var tableName : String = null

    private val METHOD_CREATED_TABLE : String = "createTable()"

    private val METHOD_DROP_TABLE : String = "dropTable()"

    private val TABLE_CREATION_SUCCESS : String = "Table Creation Successful: "

    private val DROPPED_SUCCESS : String = " Dropped Successfully"

    //Constructor
    {
        val databaseConnectionInfoInterface : DbConnectionInfo = param_databaseConnectionInfoInterface
    }

    def setTableName(tableName : String) : Unit = {
        this.tableName = tableName
    }

    def getTableName() : String = {
        return this.tableName
    }

    def createTable(data : String) : String = this.synchronized {
        try {
            this.executeSQLStatement(data)
            if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().SQLLOGGING)) {
                this.logUtil_AbSqlTable.putF(((this.TABLE_CREATION_SUCCESS + this.tableName) + " with statement: ") + data, this, this.METHOD_CREATED_TABLE)
            }
            return this.tableName + this.sqlStrings.CREATE_RETURN
        } catch {
            case e : Exception => {
                if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().SQLLOGGINGERROR)) {
                    this.logUtil_AbSqlTable.put((("Table Creation Failed: " + this.tableName) + " with statement: ") + data, this, this.METHOD_CREATED_TABLE, e)
                }
                return ("Failed to Create " + this.tableName) + " table."
            }
        }
        throw new IllegalStateException()
    }

    def dropTable() : String = this.synchronized {
        var sqlStatement : String = this.sqlStrings.DROP_TABLE + this.tableName
        try {
            this.executeSQLStatement(sqlStatement)
            if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().SQLLOGGING)) {
                this.logUtil_AbSqlTable.putF(this.SUCCESS_SQL_STATEMENT + sqlStatement, this, this.METHOD_DROP_TABLE)
            }
            return tableName + this.DROPPED_SUCCESS
        } catch {
            case e : Exception => {
                if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().SQLLOGGINGERROR)) {
                    this.logUtil_AbSqlTable.put(this.FAILED_SQL_STATEMENT + sqlStatement, this, this.METHOD_DROP_TABLE, e)
                }
                return ("Failed to Drop " + tableName) + " table."
            }
        }
        throw new IllegalStateException()
    }

}


