/*  * To change this license header, choose License Headers in Project Properties.  * To change this template file, choose Tools | Templates  * and open the template in the editor.  */
/* Generated Code Do Not Modify */
package org.allbinary.logic.communication.sql

import _root_.java.net.InetAddress
import _root_.org.allbinary.business.init.db.DatabaseConnectionInfoInterface
import _root_.org.allbinary.business.init.db.DbConnectionInfo
import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.logic.string.StringMaker
import _root_.org.allbinary.string.CommonStrings

/**  *  * @author user  */
class AbDatabaseManagement private (super_1 : DbConnectionInfo, constructor_ : Unit) extends AbSqlBean(super_1) {

    val logUtil_AbDatabaseManagement : LogUtil = LogUtil.getInstance()

    var commonStrings_AbDatabaseManagement : CommonStrings = CommonStrings.getInstance()

    val sqlCommandLog : StringMaker = new StringMaker()

    private val GRANT_ALL : String = "GRANT SELECT, INSERT, UPDATE, DELETE, CREATE, DROP, INDEX, ALTER ON "

    private val DOT_STAR : String = ".*"

    private val TO : String = " TO "

    private val AT_LOCALHOST : String = "@localhost"

    private val IDENTIFIED_BY : String = " IDENTIFIED BY '"

    private val WITH_GRANT_OPTION : String = "' WITH GRANT OPTION"

    private val FAILED : String = "Failed"

    private val GET_HOST_NAME : String = "getHostName()"

    private val METHOD_ADD_USER : String = "addUser()"

    val METHOD_ADD_USERS : String = "addUsers()"

    private val METHOD_ADD_DB : String = "addDb()"

    val METHOD_ADD_DATABASES : String = "addDatabases()"

    val METHOD_ADD_TABLES : String = "addTables()"

    val UNABLE_TO_CREATE_USER : String = "Unable to Create User: "

    val UNABLE_TO_CREATE_DATABASE : String = "Unable to Create Database: "

    val UNABLE_TO_CREATE_TABLES : String = "Unable to Create Tables"

    val ADD_TABLES_RESULTS_LABEL : String = "Add Table Results: "

    def this(databaseConnectionInfoInterface : DatabaseConnectionInfoInterface) = {
        this(databaseConnectionInfoInterface.asInstanceOf[DbConnectionInfo], ())
    }

    def this(connectionInfo : DbConnectionInfo) = {
        this(connectionInfo, ())
    }

    private def getHostName() : String = {
        try {
            var addr : InetAddress = InetAddress.getLocalHost()
            return addr.getHostName()
        } catch {
            case e : Exception => {
                this.logUtil_AbDatabaseManagement.put(this.FAILED, this, GET_HOST_NAME, e)
                return null
            }
        }
        throw new IllegalStateException()
    }

    def addDbUser(hostName : String, db : String, userName : String, password : String) : Boolean = {
        val stringBuffer : StringMaker = new StringMaker()
        stringBuffer.append(this.GRANT_ALL)
        stringBuffer.append(db)
        stringBuffer.append(this.DOT_STAR)
        stringBuffer.append(this.TO)
        stringBuffer.append(userName)
        stringBuffer.append(hostName)
        stringBuffer.append(this.IDENTIFIED_BY)
        stringBuffer.append(password)
        stringBuffer.append(this.WITH_GRANT_OPTION)
        var sqlStatement : String = stringBuffer.toString()
        this.sqlCommandLog.append(sqlStatement)
        this.sqlCommandLog.append(this.commonSeps.NEW_LINE)
        super.executeSQLStatement(sqlStatement)
        return true
    }

    def addDbUser(db : String, userName : String, password : String) : Boolean = {
        try {
            this.addDbUser(this.AT_LOCALHOST, db, userName, password)
            var hostName : String = this.getHostName()
            if (hostName != null) {
                this.addDbUser(hostName, db, userName, password)
            }
            return true
        } catch {
            case e : Exception => {
                this.logUtil_AbDatabaseManagement.put(this.UNABLE_TO_CREATE_USER + userName, this, this.METHOD_ADD_USER, e)
                return false
            }
        }
        throw new IllegalStateException()
    }

    def addDb(db : String) : _root_.java.lang.Boolean = {
        try {
            var sqlStatement : String = this.sqlStrings.CREATE_DATABASE + db
            this.sqlCommandLog.append(sqlStatement)
            this.sqlCommandLog.append(this.commonSeps.NEW_LINE)
            super.executeSQLStatement(sqlStatement)
            return _root_.java.lang.Boolean.TRUE
        } catch {
            case e : Exception => {
                this.logUtil_AbDatabaseManagement.put(this.UNABLE_TO_CREATE_DATABASE + db, this, this.METHOD_ADD_DB, e)
                return _root_.java.lang.Boolean.FALSE
            }
        }
        throw new IllegalStateException()
    }

}


