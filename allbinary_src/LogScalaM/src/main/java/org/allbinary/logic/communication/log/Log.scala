/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.logic.communication.log

import _root_.org.allbinary.string.CommonStrings
import _root_.org.allbinary.logic.communication.log.LogFormatUtil

class Log(param_specialMessage : String, param_anyType : Object, param_functionName : String, param_exception : Object) {

    private val logFormatUtil : LogFormatUtil = LogFormatUtil.getInstance()

    private var specialMessage : String = null

    private var anyType : Object = null

    private var functionName : String = null

    private var exception : Object = null

    //Constructor
    {
        val specialMessage : String = param_specialMessage
        val anyType : Object = param_anyType
        val functionName : String = param_functionName
        val exception : Object = param_exception
        this.specialMessage = specialMessage
        this.anyType = anyType
        this.functionName = functionName
        this.exception = exception
    }

    def getSpecialMessage() : String = {
        return this.specialMessage
    }

    def getObject() : Object = {
        return this.anyType
    }

    def getFunctionName() : String = {
        return this.functionName
    }

    def getThrowable() : Object = {
        return this.exception
    }

    override def toString() : String = {
        var className : String = CommonStrings.getInstance().EMPTY
        var clazz : Class[?] = this.anyType.getClass().asInstanceOf[Class[?]]
        if (clazz.getName() != null) {
            className = clazz.getName()
        }
        return this.logFormatUtil.get(className, this.functionName, this.specialMessage, this.exception)
    }

}


