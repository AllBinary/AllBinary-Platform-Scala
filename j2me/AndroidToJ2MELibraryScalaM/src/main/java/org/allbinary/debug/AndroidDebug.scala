/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.debug

import _root_.android.os.Debug

class AndroidDebug extends DebugInterface {

    private var startTime : Long = _root_.java.lang.Long.MAX_VALUE

    private var running : Boolean = false

    //24 * 1024 * 1024;
    private var bufferSize : Int = (32 * 1024) * 1024

    override def start() : Unit = {
        this.setStartTime(System.currentTimeMillis())
        //depricated: traceview G:\mnt\tmp\trace
        Debug.startMethodTracing("trace", this.bufferSize)
        this.setRunning(true)
    }

    override def stop() : Unit = {
        this.startTime = _root_.java.lang.Long.MAX_VALUE
        Debug.stopMethodTracing()
        this.setRunning(false)
    }

    override def getMaxTime() : Long = {
        return 120000
    }

    private def setStartTime(startTime : Long) : Unit = {
        this.startTime = startTime
    }

    override def getStartTime() : Long = {
        return this.startTime
    }

    private def setRunning(running : Boolean) : Unit = {
        this.running = running
    }

    override def isRunning() : Boolean = {
        return this.running
    }

}


