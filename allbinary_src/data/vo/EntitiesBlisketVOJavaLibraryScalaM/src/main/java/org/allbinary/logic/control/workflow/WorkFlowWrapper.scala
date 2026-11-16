/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.logic.control.workflow

import _root_.java.lang.reflect.Method
import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.string.CommonStrings

class WorkFlowWrapper(param_anyType : Object) extends WorkFlowInterface {

    val logUtil : LogUtil = LogUtil.getInstance()

    val commonStrings : CommonStrings = CommonStrings.getInstance()

    private var anyType : Object = null

    //Constructor
    {
        val anyType : Object = param_anyType
        this.anyType = anyType
    }

    def getWorkFlowObject() : Object = {
        return this.anyType
    }

    def getName() : String = {
        try {
            var helperClass : Class[?] = this.anyType.getClass().asInstanceOf[Class[?]]
            var method : Method = helperClass.getMethod("getName", null)
            var result : String = method.invoke(this.anyType, null).asInstanceOf[String]
            return result
        } catch {
            case e : Exception => {
                var error : String = "Reflection Exception"
                if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().SQLTAGSERROR)) {
                    this.logUtil.put(this.commonStrings.EXCEPTION, this, "getName()", e)
                }
                throw new Exception(error)
            }
        }
        throw new IllegalStateException()
    }

    def getStoreName() : String = {
        try {
            var helperClass : Class[?] = this.anyType.getClass().asInstanceOf[Class[?]]
            var method : Method = helperClass.getMethod("getStoreName", null)
            var result : String = method.invoke(this.anyType, null).asInstanceOf[String]
            return result
        } catch {
            case e : Exception => {
                var error : String = "Reflection Exception"
                if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().SQLTAGSERROR)) {
                    this.logUtil.put(this.commonStrings.EXCEPTION, this, "getStoreName()", e)
                }
                throw new Exception(error)
            }
        }
        throw new IllegalStateException()
    }

    def process() : Integer = {
        try {
            var helperClass : Class[?] = this.anyType.getClass().asInstanceOf[Class[?]]
            var method : Method = helperClass.getMethod(this.commonStrings.PROCESS, null)
            var result : Integer = method.invoke(this.anyType, null).asInstanceOf[Integer]
            return result
        } catch {
            case e : Exception => {
                var error : String = "Reflection Exception"
                if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().SQLTAGSERROR)) {
                    this.logUtil.put(this.commonStrings.EXCEPTION, this, this.commonStrings.PROCESS, e)
                }
                throw new Exception(error)
            }
        }
        throw new IllegalStateException()
    }

}


