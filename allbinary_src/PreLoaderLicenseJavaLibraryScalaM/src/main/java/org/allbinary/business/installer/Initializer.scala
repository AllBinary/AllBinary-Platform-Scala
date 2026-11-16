/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.business.installer

import _root_.java.util.HashMap
import _root_.java.util.Map
import _root_.java.util.Set
import _root_.org.allbinary.business.init.db.HistoryDbInitInfo
import _root_.org.allbinary.business.init.db.InventoryDbInitInfo
import _root_.org.allbinary.business.init.db.LogDbInitInfo
import _root_.org.allbinary.business.init.db.StaticPagesDbInitInfo
import _root_.org.allbinary.business.init.db.UserDbInitInfo
import _root_.org.allbinary.logic.StdUtil
import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.logic.string.StringMaker
import _root_.org.allbinary.logic.string.StringValidationUtil
import _root_.org.allbinary.string.CommonStrings

class Initializer private () {
    import _root_.org.allbinary.business.installer.Initializer.{*}

    val logUtil : LogUtil = LogUtil.getInstance()

    //private HttpServletRequest request;
    private var userJdbcDriver : String = null

    private var userName : String = null

    private var userUserName : String = null

    private var userPassword : String = null

    private var userSchema : String = null

    private var userServer : String = null

    private var userPort : String = null

    private var historyJdbcDriver : String = null

    private var historyName : String = null

    private var historyUserName : String = null

    private var historyPassword : String = null

    private var historySchema : String = null

    private var historyServer : String = null

    private var historyPort : String = null

    private var logJdbcDriver : String = null

    private var logName : String = null

    private var logUserName : String = null

    private var logPassword : String = null

    private var logSchema : String = null

    private var logServer : String = null

    private var logPort : String = null

    private var inventoryJdbcDriver : String = null

    private var inventoryName : String = null

    private var inventoryUserName : String = null

    private var inventoryPassword : String = null

    private var inventorySchema : String = null

    private var inventoryServer : String = null

    private var inventoryPort : String = null

    private var staticPagesJdbcDriver : String = null

    private var staticPagesName : String = null

    private var staticPagesUserName : String = null

    private var staticPagesPassword : String = null

    private var staticPagesSchema : String = null

    private var staticPagesServer : String = null

    private var staticPagesPort : String = null

    def this(map : Map[Object, Object]) = {
        this()
        val stringBuffer : StringMaker = new StringMaker()
        //this.getFormData(request.getParameterMap());
        var hashMap : HashMap[Object, Object] = StdUtil.getInstance().createHashMap().asInstanceOf[HashMap[Object, Object]]
        var keys : Set[Object] = map.keySet().asInstanceOf[Set[Object]]
        val keyArray : Array[Object] = keys.toArray()
        val size : Int = keyArray.length

        {
            var index : Int = 0
            while (index < size) {
                var key : String = keyArray(index).asInstanceOf[String]
                var values : Array[String] = map.get(key).asInstanceOf[Array[String]]
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
        this.getFormData(hashMap)
    }

    def this(initHashMap : HashMap[Object, Object]) = {
        this()
        this.getFormData(initHashMap)
    }

    def getFormData(hashMap : HashMap[Object, Object]) : Unit = {
        try {
            var initializerData : InitializerData = InitializerData.getInstance()
            this.userJdbcDriver = hashMap.get(initializerData.CUSTOMERJDBCDRIVER).asInstanceOf[String]
            this.userName = hashMap.get(initializerData.CUSTOMERNAME).asInstanceOf[String]
            this.userUserName = hashMap.get(initializerData.CUSTOMERUSERNAME).asInstanceOf[String]
            this.userPassword = hashMap.get(initializerData.CUSTOMERPASSWORD).asInstanceOf[String]
            this.userSchema = hashMap.get(initializerData.CUSTOMERSCHEMA).asInstanceOf[String]
            this.userServer = hashMap.get(initializerData.CUSTOMERSERVER).asInstanceOf[String]
            this.userPort = hashMap.get(initializerData.CUSTOMERPORT).asInstanceOf[String]
            this.historyJdbcDriver = hashMap.get(initializerData.HISTORYJDBCDRIVER).asInstanceOf[String]
            this.historyName = hashMap.get(initializerData.HISTORYNAME).asInstanceOf[String]
            this.historyUserName = hashMap.get(initializerData.HISTORYUSERNAME).asInstanceOf[String]
            this.historyPassword = hashMap.get(initializerData.HISTORYPASSWORD).asInstanceOf[String]
            this.historySchema = hashMap.get(initializerData.HISTORYSCHEMA).asInstanceOf[String]
            this.historyServer = hashMap.get(initializerData.HISTORYSERVER).asInstanceOf[String]
            this.historyPort = hashMap.get(initializerData.HISTORYPORT).asInstanceOf[String]
            this.logJdbcDriver = hashMap.get(initializerData.LOGJDBCDRIVER).asInstanceOf[String]
            this.logName = hashMap.get(initializerData.LOGNAME).asInstanceOf[String]
            this.logUserName = hashMap.get(initializerData.LOGUSERNAME).asInstanceOf[String]
            this.logPassword = hashMap.get(initializerData.LOGPASSWORD).asInstanceOf[String]
            this.logSchema = hashMap.get(initializerData.LOGSCHEMA).asInstanceOf[String]
            this.logServer = hashMap.get(initializerData.LOGSERVER).asInstanceOf[String]
            this.logPort = hashMap.get(initializerData.LOGPORT).asInstanceOf[String]
            this.inventoryJdbcDriver = hashMap.get(initializerData.INVENTORYJDBCDRIVER).asInstanceOf[String]
            this.inventoryName = hashMap.get(initializerData.INVENTORYNAME).asInstanceOf[String]
            this.inventoryUserName = hashMap.get(initializerData.INVENTORYUSERNAME).asInstanceOf[String]
            this.inventoryPassword = hashMap.get(initializerData.INVENTORYPASSWORD).asInstanceOf[String]
            this.inventorySchema = hashMap.get(initializerData.INVENTORYSCHEMA).asInstanceOf[String]
            this.inventoryServer = hashMap.get(initializerData.INVENTORYSERVER).asInstanceOf[String]
            this.inventoryPort = hashMap.get(initializerData.INVENTORYPORT).asInstanceOf[String]
            this.staticPagesJdbcDriver = hashMap.get(initializerData.STATICPAGESJDBCDRIVER).asInstanceOf[String]
            this.staticPagesName = hashMap.get(initializerData.STATICPAGESNAME).asInstanceOf[String]
            this.staticPagesUserName = hashMap.get(initializerData.STATICPAGESUSERNAME).asInstanceOf[String]
            this.staticPagesPassword = hashMap.get(initializerData.STATICPAGESPASSWORD).asInstanceOf[String]
            this.staticPagesSchema = hashMap.get(initializerData.STATICPAGESSCHEMA).asInstanceOf[String]
            this.staticPagesServer = hashMap.get(initializerData.STATICPAGESSERVER).asInstanceOf[String]
            this.staticPagesPort = hashMap.get(initializerData.STATICPAGESPORT).asInstanceOf[String]
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
        if (!this.isJdbcDriverValid(this.userJdbcDriver)) {
            isValid = false
        }
        var stringValidationUtil : StringValidationUtil = StringValidationUtil.getInstance()
        if (!stringValidationUtil.isValidRequired(this.userName, Initializer.MIN, Initializer.MAXDB)) {
            isValid = false
        }
        if (!stringValidationUtil.isValidRequired(this.userUserName, Initializer.MIN, Initializer.MAX)) {
            isValid = false
        }
        if (!stringValidationUtil.isValidNotRequired(this.userPassword, Initializer.MINPASSWORD, Initializer.MAX)) {
            isValid = false
        }
        if (!this.isJdbcDriverValid(this.historyJdbcDriver)) {
            isValid = false
        }
        if (!stringValidationUtil.isValidRequired(this.historyName, Initializer.MIN, Initializer.MAXDB)) {
            isValid = false
        }
        if (!stringValidationUtil.isValidRequired(this.historyUserName, Initializer.MIN, Initializer.MAX)) {
            isValid = false
        }
        if (!stringValidationUtil.isValidNotRequired(this.historyPassword, Initializer.MINPASSWORD, Initializer.MAX)) {
            isValid = false
        }
        if (!this.isJdbcDriverValid(this.logJdbcDriver)) {
            isValid = false
        }
        if (!stringValidationUtil.isValidRequired(this.logName, Initializer.MIN, Initializer.MAXDB)) {
            isValid = false
        }
        if (!stringValidationUtil.isValidRequired(this.logUserName, Initializer.MIN, Initializer.MAX)) {
            isValid = false
        }
        if (!stringValidationUtil.isValidNotRequired(this.logPassword, Initializer.MINPASSWORD, Initializer.MAX)) {
            isValid = false
        }
        if (!this.isJdbcDriverValid(this.inventoryJdbcDriver)) {
            isValid = false
        }
        if (!stringValidationUtil.isValidRequired(this.inventoryName, Initializer.MIN, Initializer.MAXDB)) {
            isValid = false
        }
        if (!stringValidationUtil.isValidRequired(this.inventoryUserName, Initializer.MIN, Initializer.MAX)) {
            isValid = false
        }
        if (!stringValidationUtil.isValidNotRequired(this.inventoryPassword, Initializer.MINPASSWORD, Initializer.MAX)) {
            isValid = false
        }
        if (!this.isJdbcDriverValid(this.staticPagesJdbcDriver)) {
            isValid = false
        }
        if (!stringValidationUtil.isValidRequired(this.staticPagesName, Initializer.MIN, Initializer.MAXDB)) {
            isValid = false
        }
        if (!stringValidationUtil.isValidRequired(this.staticPagesUserName, Initializer.MIN, Initializer.MAX)) {
            isValid = false
        }
        if (!stringValidationUtil.isValidNotRequired(this.staticPagesPassword, Initializer.MINPASSWORD, Initializer.MAX)) {
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

    private def getJdbcDriverSolutionInfo() : String = {
        var stringBuffer : StringMaker = new StringMaker()
        stringBuffer.append("The following describes the possible problems and solutions regarding the Jdbc Driver error(s):<p/>")
        stringBuffer.append("1. A JDBC driver you specified is not in your classpath.<br/>")
        stringBuffer.append("Solution 1: Move the JDBC driver into any directory specified in the existing classpath. <br/>")
        stringBuffer.append("Solution 2: Add the directory that contains the JDBC driver to the classpath.<br/>")
        stringBuffer.append("Solution 3: Add the JDBC driver to the WEB-INF/lib directory where you installed this webapp.<br/>")
        stringBuffer.append("2. The JDBC driver you specified does not exit.<br/>")
        stringBuffer.append("Solution: Get a JDBC driver. <br/>")
        stringBuffer.append("3. The JDBC driver you specified is not valid.<br/>")
        stringBuffer.append("Solution: Use a valid JDBC driver.<p/>")
        return stringBuffer.toString()
    }

    def getInvalidInfo() : String = {
        //boolean isValid = true;
        var isJdbcDriversValid : Boolean = true
        var stringBuffer : StringMaker = new StringMaker()
        if (!this.isJdbcDriverValid(this.userJdbcDriver)) {
            isJdbcDriversValid = false
            stringBuffer.append(this.getJdbcDriverValidationInfo(this.userJdbcDriver))
        }
        var stringValidationUtil : StringValidationUtil = StringValidationUtil.getInstance()
        if (!stringValidationUtil.isValidRequired(this.userName, Initializer.MIN, Initializer.MAXDB)) {
            stringBuffer.append(((("User db name should be < " + Initializer.MAXDB) + " and > ") + Initializer.MIN) + " characters in length.<br />")
        }
        if (!stringValidationUtil.isValidRequired(this.userUserName, Initializer.MIN, Initializer.MAX)) {
            stringBuffer.append(((("User db username should be < " + Initializer.MAX) + " and > ") + Initializer.MIN) + " characters in length.<br />")
        }
        if (!stringValidationUtil.isValidNotRequired(this.userPassword, Initializer.MINPASSWORD, Initializer.MAX)) {
            stringBuffer.append(((("User DB password should be < " + Initializer.MAX) + " and > ") + Initializer.MINPASSWORD) + " characters in length.<br />")
        }
        if (!this.isJdbcDriverValid(this.historyJdbcDriver)) {
            isJdbcDriversValid = false
            stringBuffer.append(this.getJdbcDriverValidationInfo(this.historyJdbcDriver))
        }
        if (!stringValidationUtil.isValidRequired(this.historyName, Initializer.MIN, Initializer.MAXDB)) {
            stringBuffer.append(((("History db should be < " + Initializer.MAXDB) + " and > ") + Initializer.MIN) + " characters in length.<br />")
        }
        if (!stringValidationUtil.isValidRequired(this.historyUserName, Initializer.MIN, Initializer.MAX)) {
            stringBuffer.append(((("History db username should be < " + Initializer.MAX) + " and > ") + Initializer.MIN) + " characters in length.<br />")
        }
        if (!stringValidationUtil.isValidNotRequired(this.historyPassword, Initializer.MINPASSWORD, Initializer.MAX)) {
            stringBuffer.append(((("History db password should be < " + Initializer.MAX) + " and > ") + Initializer.MINPASSWORD) + " characters in length.<br />")
        }
        if (!this.isJdbcDriverValid(this.logJdbcDriver)) {
            isJdbcDriversValid = false
            stringBuffer.append(this.getJdbcDriverValidationInfo(this.logJdbcDriver))
        }
        if (!stringValidationUtil.isValidRequired(this.logName, Initializer.MIN, Initializer.MAXDB)) {
            stringBuffer.append(((("Log db should be < " + Initializer.MAXDB) + " and > ") + Initializer.MIN) + " characters in length.<br />")
        }
        if (!stringValidationUtil.isValidRequired(this.logUserName, Initializer.MIN, Initializer.MAX)) {
            stringBuffer.append(((("Log db username should be < " + Initializer.MAX) + " and > ") + Initializer.MIN) + " characters in length.<br />")
        }
        if (!stringValidationUtil.isValidNotRequired(this.logPassword, Initializer.MINPASSWORD, Initializer.MAX)) {
            stringBuffer.append(((("Log db password should be < " + Initializer.MAX) + " and > ") + Initializer.MINPASSWORD) + " characters in length.<br />")
        }
        if (!this.isJdbcDriverValid(this.inventoryJdbcDriver)) {
            isJdbcDriversValid = false
            stringBuffer.append(this.getJdbcDriverValidationInfo(this.inventoryJdbcDriver))
        }
        if (!stringValidationUtil.isValidRequired(this.inventoryName, Initializer.MIN, Initializer.MAXDB)) {
            stringBuffer.append(((("Inventory db should be < " + Initializer.MAXDB) + " and > ") + Initializer.MIN) + " characters in length.<br />")
        }
        if (!stringValidationUtil.isValidRequired(this.inventoryUserName, Initializer.MIN, Initializer.MAX)) {
            stringBuffer.append(((("Inventory db username should be < " + Initializer.MAX) + " and > ") + Initializer.MIN) + " characters in length.<br />")
        }
        if (!stringValidationUtil.isValidNotRequired(this.inventoryPassword, Initializer.MINPASSWORD, Initializer.MAX)) {
            stringBuffer.append(((("Inventory DB password should be < " + Initializer.MAX) + " and > ") + Initializer.MINPASSWORD) + " characters in length.<br />")
        }
        if (!this.isJdbcDriverValid(this.staticPagesJdbcDriver)) {
            isJdbcDriversValid = false
            stringBuffer.append(this.getJdbcDriverValidationInfo(this.staticPagesJdbcDriver))
        }
        if (!stringValidationUtil.isValidRequired(this.staticPagesName, Initializer.MIN, Initializer.MAXDB)) {
            stringBuffer.append(((("Static Pages db should be < " + Initializer.MAXDB) + " and > ") + Initializer.MIN) + " characters in length.<br />")
        }
        if (!stringValidationUtil.isValidRequired(this.staticPagesUserName, Initializer.MIN, Initializer.MAX)) {
            stringBuffer.append(((("Static Pages db username should be < " + Initializer.MAX) + " and > ") + Initializer.MIN) + " characters in length.<br />")
        }
        if (!stringValidationUtil.isValidNotRequired(this.staticPagesPassword, Initializer.MINPASSWORD, Initializer.MAX)) {
            stringBuffer.append(((("Static Pages DB password should be < " + Initializer.MAX) + " and > ") + Initializer.MINPASSWORD) + " characters in length.<br />")
        }
        if (!isJdbcDriversValid) {
            stringBuffer.append(getJdbcDriverSolutionInfo())
        }
        return stringBuffer.toString()
    }

    /*     private void set(DbInitInfoInterface dbInitInfoInterface, DbConnectionInfo)     {     dbInitInfoInterface.setName(this.userName);     dbInitInfoInterface.setUserName(this.userUserName);     dbInitInfoInterface.setPassword(this.userPassword);     dbInitInfoInterface.setHasRead(true);     dbInitInfoInterface.write();     }      */
    def set() : Unit = {
        this.logUtil.putF("Creating DB connection files", this, "set()")
        var userDbInitInfo : UserDbInitInfo = new UserDbInitInfo(false)
        userDbInitInfo.setJdbcDriver(this.userJdbcDriver)
        userDbInitInfo.setName(this.userName)
        userDbInitInfo.setUserName(this.userUserName)
        userDbInitInfo.setPassword(this.userPassword)
        userDbInitInfo.setSchema(this.userSchema)
        userDbInitInfo.setServer(this.userServer)
        userDbInitInfo.setPort(this.userPort)
        userDbInitInfo.setHasRead(true)
        userDbInitInfo.write()
        var historyDbInitInfo : HistoryDbInitInfo = new HistoryDbInitInfo(false)
        historyDbInitInfo.setJdbcDriver(this.historyJdbcDriver)
        historyDbInitInfo.setName(this.historyName)
        historyDbInitInfo.setUserName(this.historyUserName)
        historyDbInitInfo.setPassword(this.historyPassword)
        historyDbInitInfo.setSchema(this.historySchema)
        historyDbInitInfo.setServer(this.historyServer)
        historyDbInitInfo.setPort(this.historyPort)
        historyDbInitInfo.setHasRead(true)
        historyDbInitInfo.write()
        var logDbInitInfo : LogDbInitInfo = new LogDbInitInfo(false)
        logDbInitInfo.setJdbcDriver(this.logJdbcDriver)
        logDbInitInfo.setName(this.logName)
        logDbInitInfo.setUserName(this.logUserName)
        logDbInitInfo.setPassword(this.logPassword)
        logDbInitInfo.setSchema(this.logSchema)
        logDbInitInfo.setServer(this.logServer)
        logDbInitInfo.setPort(this.logPort)
        logDbInitInfo.setHasRead(true)
        logDbInitInfo.write()
        var staticPagesDbInitInfo : StaticPagesDbInitInfo = new StaticPagesDbInitInfo(false)
        staticPagesDbInitInfo.setJdbcDriver(this.staticPagesJdbcDriver)
        staticPagesDbInitInfo.setName(this.staticPagesName)
        staticPagesDbInitInfo.setUserName(this.staticPagesUserName)
        staticPagesDbInitInfo.setPassword(this.staticPagesPassword)
        staticPagesDbInitInfo.setSchema(this.staticPagesSchema)
        staticPagesDbInitInfo.setServer(this.staticPagesServer)
        staticPagesDbInitInfo.setPort(this.staticPagesPort)
        staticPagesDbInitInfo.setHasRead(true)
        staticPagesDbInitInfo.write()
        var inventoryDbInitInfo : InventoryDbInitInfo = new InventoryDbInitInfo(false)
        inventoryDbInitInfo.setJdbcDriver(this.inventoryJdbcDriver)
        inventoryDbInitInfo.setName(this.inventoryName)
        inventoryDbInitInfo.setUserName(this.inventoryUserName)
        inventoryDbInitInfo.setPassword(this.inventoryPassword)
        inventoryDbInitInfo.setSchema(this.inventorySchema)
        inventoryDbInitInfo.setServer(this.inventoryServer)
        inventoryDbInitInfo.setPort(this.inventoryPort)
        inventoryDbInitInfo.setHasRead(true)
        inventoryDbInitInfo.write()
        this.logUtil.putF("Created DB connection files", this, "set()")
    }

}

object Initializer {
    private val MAXDB : Int = 30

    private val MAX : Int = 16

    private val MIN : Int = 4

    private val MINPASSWORD : Int = 0

}


