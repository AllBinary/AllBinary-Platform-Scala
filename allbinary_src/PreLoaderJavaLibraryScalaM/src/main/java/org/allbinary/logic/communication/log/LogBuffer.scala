/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.logic.communication.log

import _root_.org.allbinary.util.BasicArrayList
import _root_.org.allbinary.util.BasicArrayListD
import _root_.org.allbinary.logic.StdUtil

class LogBuffer() {

    val logUtil : LogUtil = LogUtil.getInstance()

    var logEntryVector : BasicArrayList = null

    //Constructor
    {
        this.logEntryVector = new BasicArrayListD()
    }

    def add(log : Log) : Unit = {
        this.logEntryVector.add(log)
    }

    /*    public void add(          String specialMessage,          Object object,          String functionName,          Exception exception)    {       this.logEntryVector.add(          LogFactory.getInstance(specialMessage, object, functionName, exception));    }     public void add(          String specialMessage,          String className,          String functionName,          Exception exception)    {       this.logEntryVector.add(          LogFactory.getInstance(specialMessage, className, functionName, exception));    }     */
    def logAll() : Unit = {
        val size : Int = this.logEntryVector.size()

        {
            var index : Int = 0
            while (index < size) {
                var log : Log = this.logEntryVector.get(index).asInstanceOf[Log]
                this.logUtil.putL(log)
                index += 1
            }
        }
    }

}


