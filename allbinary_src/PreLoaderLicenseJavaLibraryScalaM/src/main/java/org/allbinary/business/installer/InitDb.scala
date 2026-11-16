/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.business.installer

import _root_.java.lang.reflect.Method
import _root_.org.allbinary.business.init.db.DbConnectionInfo
import _root_.org.allbinary.logic.system.security.licensing.LicensingException

//Warning you must have sql root access
class InitDb() {

    private var anyType : Object = null

    private val METHOD_CALL_GET_HOST_NAME : String = "getHostName"

    private val METHOD_CALL_ADD_USERS : String = "addUsers"

    private val METHOD_CALL_ADD_DATABASES : String = "addDatabases"

    private val METHOD_CALL_ADD_TABLES : String = "addTables"

    private val METHOD_CALL_TEMP_MAIN_PATH : String = "useTemporaryMainPath"

    private val METHOD_CALL_MAIN_PATH : String = "useNormalMainPath"

    def this(dbConnectionInfo : DbConnectionInfo) = {
        this()
    }

    def setHelper(anyType : Object) : Unit = {
        this.anyType = anyType
    }

    def getHelper() : Object = {
        return this.anyType
    }

    private def getHostName() : String = {
        try {
            var dynamicClass : Class[?] = this.anyType.getClass().asInstanceOf[Class[?]]
            var method : Method = dynamicClass.getMethod(this.METHOD_CALL_GET_HOST_NAME, null)
            var result : String = method.invoke(this.anyType, null).asInstanceOf[String]
            return result
        } catch {
            case e : Exception => {
                return null
            }
        }
        throw new IllegalStateException()
    }

    def addUsers() : Boolean = {
        try {
            var dynamicClass : Class[?] = this.anyType.getClass().asInstanceOf[Class[?]]
            var method : Method = dynamicClass.getMethod(this.METHOD_CALL_ADD_USERS, null)
            var result : _root_.java.lang.Boolean = method.invoke(this.anyType, null).asInstanceOf[_root_.java.lang.Boolean]
            return result.booleanValue()
        } catch {
            case e : Exception => {
                return false
            }
        }
        throw new IllegalStateException()
    }

    def addDatabases() : Boolean = {
        try {
            var dynamicClass : Class[?] = this.anyType.getClass().asInstanceOf[Class[?]]
            var method : Method = dynamicClass.getMethod(this.METHOD_CALL_ADD_DATABASES, null)
            var result : _root_.java.lang.Boolean = method.invoke(this.anyType, null).asInstanceOf[_root_.java.lang.Boolean]
            return result.booleanValue()
        } catch {
            case e : Exception => {
                return false
            }
        }
        throw new IllegalStateException()
    }

    def addTables() : Boolean = {
        try {
            var dynamicClass : Class[?] = this.anyType.getClass().asInstanceOf[Class[?]]
            var method : Method = dynamicClass.getMethod(this.METHOD_CALL_ADD_TABLES, null)
            var result : _root_.java.lang.Boolean = method.invoke(this.anyType, null).asInstanceOf[_root_.java.lang.Boolean]
            return result.booleanValue()
        } catch {
            case e : Exception => {
                return false
            }
        }
        throw new IllegalStateException()
    }

    def useTemporaryMainPath() : Boolean = {
        try {
            var dynamicClass : Class[?] = this.anyType.getClass().asInstanceOf[Class[?]]
            var method : Method = dynamicClass.getMethod(this.METHOD_CALL_TEMP_MAIN_PATH, null)
            var result : _root_.java.lang.Boolean = method.invoke(this.anyType, null).asInstanceOf[_root_.java.lang.Boolean]
            return result.booleanValue()
        } catch {
            case e : Exception => {
                return false
            }
        }
        throw new IllegalStateException()
    }

    def useNormalMainPath() : Boolean = {
        try {
            var dynamicClass : Class[?] = this.anyType.getClass().asInstanceOf[Class[?]]
            var method : Method = dynamicClass.getMethod(this.METHOD_CALL_MAIN_PATH, null)
            var result : _root_.java.lang.Boolean = method.invoke(this.anyType, null).asInstanceOf[_root_.java.lang.Boolean]
            return result.booleanValue()
        } catch {
            case e : Exception => {
                return false
            }
        }
        throw new IllegalStateException()
    }

}


