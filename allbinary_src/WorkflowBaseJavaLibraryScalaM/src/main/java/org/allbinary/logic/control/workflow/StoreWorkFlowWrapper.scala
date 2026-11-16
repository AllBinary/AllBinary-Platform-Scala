/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.logic.control.workflow

import _root_.java.lang.reflect.Method
import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.string.CommonStrings

class StoreWorkFlowWrapper(param_anyType : Object) extends WorkFlowWrapper(param_anyType) {

    val logUtil_StoreWorkFlowWrapper : LogUtil = LogUtil.getInstance()

    //Constructor
    {
        val anyType : Object = param_anyType
    }

    override def getStoreName() : String = {
        try {
            var helperClass : Class[?] = this.getWorkFlowObject().getClass().asInstanceOf[Class[?]]
            var method : Method = helperClass.getMethod("getStoreName", null)
            var result : String = method.invoke(this.getWorkFlowObject(), null).asInstanceOf[String]
            return result
        } catch {
            case e : Exception => {
                var error : String = "Reflection Exception"
                if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().SQLTAGSERROR)) {
                    val commonStrings : CommonStrings = CommonStrings.getInstance()
                    this.logUtil_StoreWorkFlowWrapper.put(commonStrings.EXCEPTION, this, "getStoreName()", e)
                }
                throw new Exception(error)
            }
        }
        throw new IllegalStateException()
    }

}


