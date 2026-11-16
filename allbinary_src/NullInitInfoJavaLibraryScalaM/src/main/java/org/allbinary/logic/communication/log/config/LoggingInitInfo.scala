/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.logic.communication.log.config

import _root_.org.allbinary.util.BasicArrayList
import _root_.org.allbinary.util.BasicArrayListD

class LoggingInitInfo() {
    import _root_.org.allbinary.logic.communication.log.config.LoggingInitInfo.{*}

    def isValid() : Boolean = {
        try {
            return true
        } catch {
            case e : Exception => {
                return false
            }
        }
        throw new IllegalStateException()
    }

    def getNumberOfLogConfigs() : Int = {
        return LoggingInitInfo.logConfigInfoList.size()
    }

    override def toString() : String = {
        try {
            return null
        } catch {
            case e : Exception => {
                return "Error"
            }
        }
        throw new IllegalStateException()
    }

}

object LoggingInitInfo {
    private var logConfigInfoList : BasicArrayList = null

    private var hasRead : Boolean = false

    //   }
    def write() : Unit = this.synchronized {
        try {
            //write new logConfigFile
            LoggingInitInfo.hasRead = false
        } catch {
            case e : Exception => {
                throw e
            }
        }
    }

    private def read() : Unit = this.synchronized {
        try {
        } catch {
            case e : Exception => {
                throw e
            }
        }
    }

    def setHasRead(value : Boolean) : Unit = this.synchronized {
        LoggingInitInfo.hasRead = value
    }

    private def updateIfNeeded() : Unit = this.synchronized {
        if (!LoggingInitInfo.hasRead) {
            LoggingInitInfo.read()
            LoggingInitInfo.hasRead = true
            if (LoggingInitInfo.logConfigInfoList == null) {
                throw new Exception("Read Failed")
            }
        }
    }

    def set(logConfigInfoList : BasicArrayList) : Unit = this.synchronized {
        LoggingInitInfo.logConfigInfoList = logConfigInfoList
    }

    def get() : BasicArrayList = {
        LoggingInitInfo.updateIfNeeded()
        return LoggingInitInfo.logConfigInfoList
    }

    /*    public static BasicArrayList getTypeNameList() throws Exception    {       LoggingInitInfo.updateIfNeeded();              BasicArrayList allLogTypeVector = new BasicArrayListD();       iter = LoggingInitInfo.logConfigInfoVector;              while(iter.hasNext())       {          LogConfig logConfigInfo = (LogConfig) iter.next();          BasicArrayList logTypeVector = logConfigInfo.getTypeVector();                    if(logConfigInfo.isEnabled())          {             allLogTypeVector.addAll(logTypeVector);          }       }       return allLogTypeVector;    }     */
    def getTypeList() : BasicArrayList = {
        LoggingInitInfo.updateIfNeeded()
        val allLogTypeVector : BasicArrayList = new BasicArrayListD()
        val size : Int = LoggingInitInfo.logConfigInfoList.size()

        {
            var index : Int = 0
            while (index < size) {
                val logConfigInfo : LogConfig = LoggingInitInfo.logConfigInfoList.objectArray(index).asInstanceOf[LogConfig]
                val logTypeVector : BasicArrayList = logConfigInfo.getTypeVector()
                if (logConfigInfo.isEnabled()) {
                    allLogTypeVector.addAllList(logTypeVector)
                }
                index += 1
            }
        }
        return allLogTypeVector
    }

}


