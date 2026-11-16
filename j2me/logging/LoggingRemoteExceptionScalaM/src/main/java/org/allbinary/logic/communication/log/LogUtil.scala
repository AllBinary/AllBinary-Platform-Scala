/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *   */
/* Generated Code Do Not Modify */
package org.allbinary.logic.communication.log

import _root_.java.io.IOException
import _root_.org.apache.xmlrpc.XmlRpcException
import _root_.org.allbinary.string.CommonSeps
import _root_.org.allbinary.logic.string.StringMaker
import _root_.org.allbinary.logic.system.security.licensing.AbeClientInformationInterface
import _root_.org.allbinary.canvas.SpecialMessageUtil
import _root_.org.allbinary.string.CommonStrings
import _root_.org.allbinary.time.TimeDelayHelper
import _root_.org.allbinary.util.ABHashtable

//ActualPlatform
class LogUtil private() {
    import _root_.org.allbinary.logic.communication.log.LogUtil.{*}

    //private final LogFormatUtil logFormatUtil = LogFormatUtil.getInstance();
    private val MESSAGE : String = "message"

    private var isFirstException : Boolean = true

    private var timeDelayHelper : TimeDelayHelper = new TimeDelayHelper(200000)

    var abeClientInformation : AbeClientInformationInterface = null

    private val stringBuffer : StringMaker = new StringMaker()

    //ActualPlatform
    def putL(log : Log) : Unit = {
        if (log == null) {
            return
        }
        val specialMessage : String = log.getSpecialMessage()
        val anyType : Object = log.getObject()
        val functionName : String = log.getFunctionName()
        val exception : Object = log.getThrowable()
        this.put(specialMessage, anyType, functionName, exception)
    }

    //ActualPlatform
    def putF(specialMessage : String, anyType : Object, functionName : String) : Unit = {
    }

    //ActualPlatform
    def putFS(specialMessage : String, className : String, functionName : String) : Unit = {
    }

    //ActualPlatform
    def put(specialMessage : String, anyType : Object, functionName : String, exception : Object) : Unit = {
        if (exception != null) {
            //If XmlRpcException then don't try to log it
            if (exception.getClass().getName().compareTo(classOf[XmlRpcException].getName()) == 0) {
                return
            }
            if (exception.getClass().getName().compareTo(classOf[IOException].getName()) == 0) {
                return
            }
            if (this.isFirstException || this.timeDelayHelper.isTimeTNT()) {
                var className : String = CommonStrings.getInstance().EMPTY
                this.isFirstException = false
                if ((anyType != null) && (anyType.getClass().getName() != null)) {
                    className = new String(anyType.getClass().getName())
                }
                val message : String = LogFormatUtil.getInstance().get(className, functionName, specialMessage, exception)
                try {
                    System.out.println("Eeeek")
                    //System.out.println("message: " + message);
                    if (this.abeClientInformation == null) {
                        throw new RuntimeException()
                    }
                    val hashtable : ABHashtable[Object, Object] = this.abeClientInformation.toHashtable()
                    this.stringBuffer.delete(0, this.stringBuffer.length())
                    this.stringBuffer.append(message)
                    this.stringBuffer.append(CommonSeps.getInstance().SPACE)
                    this.stringBuffer.append(SpecialMessageUtil.getInstance().get())
                    hashtable.put(this.MESSAGE, this.stringBuffer.toString())
                    //System.out.println("Sending");
                    new XmlRpcRemoteLogClient(this.abeClientInformation).get(hashtable)
                } catch {
                    case e : Throwable => {
                        //Hmmmm well you will never know
                        System.out.println("Exception")
                        e.printStackTrace()
                    }
                }
            }
        }
    }

}

object LogUtil {
    private val instance : LogUtil = new LogUtil()

    //ActualPlatform
    def getInstance() : LogUtil = {
        return LogUtil.instance
    }

}


