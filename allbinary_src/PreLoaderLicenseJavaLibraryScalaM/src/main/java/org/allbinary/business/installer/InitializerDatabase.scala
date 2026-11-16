/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.business.installer

import _root_.java.util.HashMap
import _root_.java.util.Map
import _root_.java.util.Set
import _root_.org.allbinary.business.init.db.DatabaseConnectionInfoInterface
import _root_.org.allbinary.business.init.db.DbConnectionInfo
import _root_.org.allbinary.logic.StdUtil
import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.logic.string.StringMaker
import _root_.org.allbinary.logic.string.StringUtil
import _root_.org.allbinary.logic.string.StringValidationUtil
import _root_.org.allbinary.logic.system.security.licensing.AbeClientInformationInterface
import _root_.org.allbinary.string.CommonStrings

class InitializerDatabase private () {
    import _root_.org.allbinary.business.installer.InitializerDatabase.{*}

    val logUtil : LogUtil = LogUtil.getInstance()

    //private HttpServletRequest request;
    private var adminDbUserName : String = null

    private var adminDbPassword : String = null

    private var adminJdbcDriver : String = null

    private var adminSchema : String = null

    private var adminServer : String = null

    private var adminPort : String = null

    private var initDb : DynamicInitDb = null

    def this(abeClientInformation : AbeClientInformationInterface, map : Map[Object, Object]) = {
        this()
        val stringBuffer : StringMaker = new StringMaker()
        //this.getFormData(request.getParameterMap());
        val hashMap : HashMap[Object, Object] = StdUtil.getInstance().createHashMap().asInstanceOf[HashMap[Object, Object]]
        val keys : Set[Object] = map.keySet().asInstanceOf[Set[Object]]
        val keyArray : Array[Object] = keys.toArray()
        val size : Int = keyArray.length

        {
            var index : Int = 0
            while (index < size) {
                val key : String = keyArray(index).asInstanceOf[String]
                val values : Array[String] = map.get(key).asInstanceOf[Array[String]]
                hashMap.put(new String(key), new String(values(0)))
                stringBuffer.delete(0, stringBuffer.length())
                stringBuffer.append("key: ")
                stringBuffer.append(key)
                stringBuffer.append(" Value: ")
                stringBuffer.append(values(0))
                this.logUtil.putF(stringBuffer.toString(), this, "getFormData()")
                index += 1
            }
        }
        this.getFormData(abeClientInformation, hashMap)
    }

    def this(abeClientInformation : AbeClientInformationInterface, initHashMap : HashMap[Object, Object]) = {
        this()
        this.getFormData(abeClientInformation, initHashMap)
    }

    def getFormData(abeClientInformation : AbeClientInformationInterface, hashMap : HashMap[Object, Object]) : Unit = {
        try {
            var initializerData : InitializerData = InitializerData.getInstance()
            this.setAdminDbUserName(hashMap.get(initializerData.DBUSER).asInstanceOf[String])
            this.setAdminDbPassword(hashMap.get(initializerData.DBPASSWORD).asInstanceOf[String])
            this.setAdminJdbcDriver(hashMap.get(initializerData.ADMINJDBCDRIVER).asInstanceOf[String])
            this.setAdminSchema(hashMap.get(initializerData.ADMINSCHEMA).asInstanceOf[String])
            this.setAdminServer(hashMap.get(initializerData.ADMINSERVER).asInstanceOf[String])
            this.setAdminPort(hashMap.get(initializerData.ADMINPORT).asInstanceOf[String])
            var dbConnectionInfo : DbConnectionInfo = new DbConnectionInfo()
            var adminDbName : String = StringUtil.getInstance().EMPTY_STRING
            dbConnectionInfo.setJdbcDriver(getAdminJdbcDriver())
            dbConnectionInfo.setName(adminDbName)
            dbConnectionInfo.setUserName(getAdminDbUserName())
            dbConnectionInfo.setPassword(getAdminDbPassword())
            dbConnectionInfo.setSchema(getAdminSchema())
            dbConnectionInfo.setServer(getAdminServer())
            dbConnectionInfo.setPort(getAdminPort())
            this.initDb = new DynamicInitDb(abeClientInformation, dbConnectionInfo.asInstanceOf[DatabaseConnectionInfoInterface])
        } catch {
            case e : Exception => {
                this.logUtil.put("Unable to get form data", this, "getFormData()", e)
            }
        }
    }

    private def isJdbcDriverValid(jdbcDriverClassPathString : String) : Boolean = {
        try {
            Class.forName(jdbcDriverClassPathString).newInstance()
            return true
        } catch {
            case e : Exception => {
                if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().PRELOADERERROR)) {
                    val commonStrings : CommonStrings = CommonStrings.getInstance()
                    this.logUtil.put(commonStrings.EXCEPTION, this, commonStrings.IS_VALID, e)
                }
                return false
            }
        }
        throw new IllegalStateException()
    }

    def isValid() : Boolean = {
        var isValid : Boolean = true
        if (!this.isJdbcDriverValid(this.adminJdbcDriver)) {
            isValid = false
        }
        var stringValidationUtil : StringValidationUtil = StringValidationUtil.getInstance()
        if (!stringValidationUtil.isValidRequired(this.adminDbUserName, InitializerDatabase.MIN, InitializerDatabase.MAX)) {
            isValid = false
        }
        if (!stringValidationUtil.isValidNotRequired(this.adminDbPassword, InitializerDatabase.MINPASSWORD, InitializerDatabase.MAX)) {
            isValid = false
        }
        return isValid
    }

    private def getJdbcDriverValidationInfo(jdbcDriver : String) : String = {
        var stringBuffer : StringMaker = new StringMaker()
        stringBuffer.append("The JDBC driver (")
        stringBuffer.append(jdbcDriver)
        stringBuffer.append(") you have provided is not valid.<br/>")
        return stringBuffer.toString()
    }

    def getInvalidInfo() : String = {
        var isValid : Boolean = true
        var isJdbcDriversValid : Boolean = true
        var stringBuffer : StringMaker = new StringMaker()
        if (!this.isJdbcDriverValid(this.adminJdbcDriver)) {
            isJdbcDriversValid = false
            stringBuffer.append(this.getJdbcDriverValidationInfo(this.getAdminJdbcDriver()))
        }
        var stringValidationUtil : StringValidationUtil = StringValidationUtil.getInstance()
        if (!stringValidationUtil.isValidRequired(this.adminDbUserName, InitializerDatabase.MIN, InitializerDatabase.MAX)) {
            stringBuffer.append(((("Admin username should be < " + InitializerDatabase.MAX) + " and > ") + InitializerDatabase.MIN) + " characters in length.<br />")
        }
        if (!stringValidationUtil.isValidNotRequired(this.adminDbPassword, InitializerDatabase.MINPASSWORD, InitializerDatabase.MAX)) {
            stringBuffer.append(((("Admin password should be < " + InitializerDatabase.MAX) + " and > ") + InitializerDatabase.MINPASSWORD) + " characters in length.<br />")
        }
        if (!isJdbcDriversValid) {
            stringBuffer.append(InitializerData.getInstance().getJdbcDriverSolutionInfo())
        }
        return stringBuffer.toString()
    }

    def createUsers() : Boolean = {
        try {
            this.initDb.addUsers()
            //initDb.addDatabases();
            return true
        } catch {
            case e : Exception => {
                this.logUtil.put("Unable to Create Users", this, "createUsers()", e)
                return false
            }
        }
        throw new IllegalStateException()
    }

    def createDatabases() : Boolean = {
        try {
            this.initDb.addDatabases()
            return true
        } catch {
            case e : Exception => {
                this.logUtil.put("Unable to Create Databases", this, "createDatabases()", e)
                return false
            }
        }
        throw new IllegalStateException()
    }

    def createTables() : Boolean = {
        try {
            this.initDb.addTables()
            return true
        } catch {
            case e : Exception => {
                this.logUtil.put("Unable to Create Tables", this, "createTables()", e)
                return false
            }
        }
        throw new IllegalStateException()
    }

    /**      * @return the adminDbUserName      */
    def getAdminDbUserName() : String = {
        return this.adminDbUserName
    }

    /**      * @param adminDbUserName the adminDbUserName to set      */
    def setAdminDbUserName(adminDbUserName : String) : Unit = {
        this.adminDbUserName = adminDbUserName
    }

    /**      * @return the adminDbPassword      */
    def getAdminDbPassword() : String = {
        return this.adminDbPassword
    }

    /**      * @param adminDbPassword the adminDbPassword to set      */
    def setAdminDbPassword(adminDbPassword : String) : Unit = {
        this.adminDbPassword = adminDbPassword
    }

    /**      * @return the adminJdbcDriver      */
    def getAdminJdbcDriver() : String = {
        return this.adminJdbcDriver
    }

    /**      * @param adminJdbcDriver the adminJdbcDriver to set      */
    def setAdminJdbcDriver(adminJdbcDriver : String) : Unit = {
        this.adminJdbcDriver = adminJdbcDriver
    }

    /**      * @return the adminSchema      */
    def getAdminSchema() : String = {
        return this.adminSchema
    }

    /**      * @param adminSchema the adminSchema to set      */
    def setAdminSchema(adminSchema : String) : Unit = {
        this.adminSchema = adminSchema
    }

    /**      * @return the adminServer      */
    def getAdminServer() : String = {
        return this.adminServer
    }

    /**      * @param adminServer the adminServer to set      */
    def setAdminServer(adminServer : String) : Unit = {
        this.adminServer = adminServer
    }

    /**      * @return the adminPort      */
    def getAdminPort() : String = {
        return this.adminPort
    }

    /**      * @param adminPort the adminPort to set      */
    def setAdminPort(adminPort : String) : Unit = {
        this.adminPort = adminPort
    }

}

object InitializerDatabase {
    private val MAXDB : Int = 30

    private val MAX : Int = 16

    private val MIN : Int = 4

    private val MINPASSWORD : Int = 0

}


