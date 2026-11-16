/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.logic.communication.sql

import _root_.java.sql.Connection
import _root_.java.sql.ResultSet
import _root_.java.sql.SQLException
import _root_.java.sql.Statement
import _root_.org.allbinary.business.init.db.DatabaseConnectionInfoInterface
import _root_.org.allbinary.business.init.db.DbConnectionInfo
import _root_.org.allbinary.logic.StdUtil
import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.logic.communication.sql.connection.pool.SqlConnectionPool
import _root_.org.allbinary.logic.string.StringUtil
import _root_.org.allbinary.string.CommonSeps
import _root_.org.allbinary.string.CommonStrings

class AbSqlBasic(param_databaseConnectionInfoInterface : DbConnectionInfo) {

    val logUtil : LogUtil = LogUtil.getInstance()

    private val sqlConnectionPool : SqlConnectionPool = SqlConnectionPool.getInstance()

    private var databaseConnectionInfoInterface : DbConnectionInfo = null

    private var connectAttemptCounter : Int = 0

    //protected String password;
    var conn : Connection = null

    //protected boolean useridAndPassword;
    val stringUtil : StringUtil = StringUtil.getInstance()

    val commonStrings : CommonStrings = CommonStrings.getInstance()

    val commonSeps : CommonSeps = CommonSeps.getInstance()

    val stdUtil : StdUtil = StdUtil.getInstance()

    val sqlTypeStrings : SqlTypeStrings = SqlTypeStrings.getInstance()

    val sqlStrings : SqlStrings = SqlStrings.getInstance()

    val INSERT : String = "insert"

    val UPDATE : String = "update"

    val FAILED_SQL_STATEMENT : String = "Failed\nSQL Statement: "

    val SUCCESS_SQL_STATEMENT : String = "Success\nSQL Statement: "

    private val METHOD_EXECUTED_SQL_STATEMENT : String = "executedSQLStatement"

    private val METHOD_CREATE : String = "create"

    private val DATABASE_CREATED_LABEL : String = "Database Created: "

    private val DATABASE_CREATION_FAILED_LABEL : String = "Database Creation Failed: "

    private val SQL_CONNECTION_FAILED : String = "SQL Connection Failed"

    private val SQL_CONNECTION_RETRYING : String = "SQL Connection Retrying"

    private val SQL_CONNECTION_RETRY : String = "SQL Connection Retry"

    private val METHOD_CREATE_CONNECTION : String = "createConnection()"

    private val METHOD_INITIALIZE : String = "initialize"

    private val LOAD_JDBC_DRIVER_FAILED_LABEL : String = "Load JDBC Driver Failed: "

    //Constructor
    {
        val databaseConnectionInfoInterface : DbConnectionInfo = param_databaseConnectionInfoInterface
        this.databaseConnectionInfoInterface = databaseConnectionInfoInterface
        this.connectAttemptCounter = 0
        this.conn = null
    }

    /*     public void setUserid(String userid)     {     this.userid = userid;     }      public String getUserid()     {     return userid;     }      public void setPassword(String password)     {     this.password = password;     }      public String getPassword()     {     return password;     }      */
    def executeSQLStatement(statement : String) : ResultSet = {
        try {
            //{
            this.initialize()
            //}
            var stmt : Statement = this.conn.createStatement()
            //TWB- Changes For GAE JIQL
            stmt.execute(statement)
            var rset : ResultSet = stmt.getResultSet()
            stmt.close()
            var tempConnection : Connection = this.conn
            this.conn = null
            this.sqlConnectionPool.add(this.getDatabaseConnectionInfoInterface().getUrl(), tempConnection)
            return rset
        } catch {
            case e : SQLException => {
                if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().SQLLOGGINGERROR)) {
                    this.logUtil.put(this.FAILED_SQL_STATEMENT + statement, this, METHOD_EXECUTED_SQL_STATEMENT, e)
                }
                this.conn.close()
                this.conn = null
                throw e
            }
        }
        throw new IllegalStateException()
    }

    def create(databaseName : String) : String = {
        try {
            this.executeSQLStatement(this.sqlStrings.CREATE_DATABASE + databaseName)
            if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().SQLLOGGING)) {
                this.logUtil.putF(this.DATABASE_CREATED_LABEL + databaseName, this, this.METHOD_CREATE)
            }
            return databaseName + this.sqlStrings.CREATE_RETURN
        } catch {
            case e : Exception => {
                if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().SQLLOGGINGERROR)) {
                    this.logUtil.put(this.DATABASE_CREATION_FAILED_LABEL + databaseName, this, this.METHOD_CREATE, e)
                }
                return this.DATABASE_CREATION_FAILED_LABEL + databaseName
            }
        }
        throw new IllegalStateException()
    }

    private def createConnection() : Unit = {
        try {
            /*             if(useridAndPassword==true)             {             this.conn = SqlConnectionPool.get(this.url, this.userid, this.password);             }             else             {*/
            this.conn = this.sqlConnectionPool.get(this.getDatabaseConnectionInfoInterface().getUrl())
        } catch {
            case se : SQLException => {
                if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().SQLLOGGINGERROR)) {
                    this.logUtil.put(this.SQL_CONNECTION_RETRYING, this, METHOD_CREATE_CONNECTION, se)
                }
                try {
                    //wait and hope mysql catches up
                    _root_.java.lang.Thread.sleep(2000)
                    //give up after 20tries
                    if (this.connectAttemptCounter < 10) {
                        this.connectAttemptCounter += 1
                        this.initialize()
                    }
                } catch {
                    case e : Exception => {
                        if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().SQLLOGGINGERROR)) {
                            this.logUtil.put(this.SQL_CONNECTION_RETRY + se.getMessage(), this, this.METHOD_CREATE_CONNECTION, e)
                        }
                    }
                }
            }
        }
    }

    private def initialize() : Unit = {
        try {
            //if(!this.isInitialized)

            {
                try {
                    var loader : ClassLoader = Thread.currentThread().getContextClassLoader()
                    var jdbcDriverClass : Class[?] = loader.loadClass(this.getDatabaseConnectionInfoInterface().getJdbcDriver()).asInstanceOf[Class[?]]
                    //driver = (Driver)
                    jdbcDriverClass.newInstance()
                } catch {
                    case e : Exception => {
                        if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().SQLLOGGINGERROR)) {
                            this.logUtil.put(this.LOAD_JDBC_DRIVER_FAILED_LABEL + this.getDatabaseConnectionInfoInterface().getJdbcDriver(), this, METHOD_INITIALIZE, e)
                        }
                    }
                }
            }
            /*             if(this.userid == null && this.password == null)             {             this.useridAndPassword=true;             }              */
            this.createConnection()
        } catch {
            case se : Exception => {
                if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().SQLLOGGINGERROR)) {
                    this.logUtil.put(this.SQL_CONNECTION_FAILED, this, this.METHOD_INITIALIZE, se)
                }
            }
        }
    }

    def getDatabaseConnectionInfoInterface() : DatabaseConnectionInfoInterface = {
        return this.databaseConnectionInfoInterface
    }

    def setDatabaseConnectionInfoInterface(databaseConnectionInfoInterface : DbConnectionInfo) : Unit = {
        this.databaseConnectionInfoInterface = databaseConnectionInfoInterface
    }

}


