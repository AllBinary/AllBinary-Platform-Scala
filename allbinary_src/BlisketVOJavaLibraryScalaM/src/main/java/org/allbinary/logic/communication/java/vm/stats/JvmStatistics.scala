/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.logic.communication.java.vm.stats


class JvmStatistics() {

    private var runtime : Runtime = null

    //Constructor
    {
        this.runtime = Runtime.getRuntime()
    }

    def getFreeMemoryBytes() : Long = {
        return this.runtime.freeMemory()
    }

    def getFreeMemoryKilobytes() : Long = {
        return this.getFreeMemoryBytes() / 1024
    }

    def getFreeMemoryMegabytes() : Long = {
        return this.getFreeMemoryKilobytes() / 1024
    }

    def getMaxMemoryBytes() : Long = {
        return this.runtime.maxMemory()
    }

    def getMaxMemoryKilobytes() : Long = {
        return this.getMaxMemoryBytes() / 1024
    }

    def getMaxMemoryMegabytes() : Long = {
        return this.getMaxMemoryKilobytes() / 1024
    }

    def getTotalMemoryBytes() : Long = {
        return this.runtime.totalMemory()
    }

    def getTotalMemoryKilobytes() : Long = {
        return this.getTotalMemoryBytes() / 1024
    }

    def getTotalMemoryMegabytes() : Long = {
        return this.getTotalMemoryKilobytes() / 1024
    }

    def getFreeMemoryBytesLong() : _root_.java.lang.Long = {
        return new _root_.java.lang.Long(this.getFreeMemoryBytes())
    }

    def getFreeMemoryKilobytesLong() : _root_.java.lang.Long = {
        return new _root_.java.lang.Long(this.getFreeMemoryKilobytes())
    }

    def getFreeMemoryMegabytesLong() : _root_.java.lang.Long = {
        return new _root_.java.lang.Long(this.getFreeMemoryMegabytes())
    }

    def getMaxMemoryBytesLong() : _root_.java.lang.Long = {
        return new _root_.java.lang.Long(this.getMaxMemoryBytes())
    }

    def getMaxMemoryKilobytesLong() : _root_.java.lang.Long = {
        return new _root_.java.lang.Long(this.getMaxMemoryKilobytes())
    }

    def getMaxMemoryMegabytesLong() : _root_.java.lang.Long = {
        return new _root_.java.lang.Long(this.getMaxMemoryMegabytes())
    }

    def getTotalMemoryBytesLong() : _root_.java.lang.Long = {
        return new _root_.java.lang.Long(this.getTotalMemoryBytes())
    }

    def getTotalMemoryKilobytesLong() : _root_.java.lang.Long = {
        return new _root_.java.lang.Long(this.getTotalMemoryKilobytes())
    }

    def getTotalMemoryMegabytesLong() : _root_.java.lang.Long = {
        return new _root_.java.lang.Long(this.getTotalMemoryMegabytes())
    }

    def getFreeMemoryBytesString() : String = {
        return this.getFreeMemoryBytesLong().toString()
    }

    def getFreeMemoryKilobytesString() : String = {
        return this.getFreeMemoryKilobytesLong().toString()
    }

    def getFreeMemoryMegabytesString() : String = {
        return this.getFreeMemoryMegabytesLong().toString()
    }

    def getMaxMemoryBytesString() : String = {
        return this.getMaxMemoryBytesLong().toString()
    }

    def getMaxMemoryKilobytesString() : String = {
        return this.getMaxMemoryKilobytesLong().toString()
    }

    def getMaxMemoryMegabytesString() : String = {
        return this.getMaxMemoryMegabytesLong().toString()
    }

    def getTotalMemoryBytesString() : String = {
        return this.getTotalMemoryBytesLong().toString()
    }

    def getTotalMemoryKilobytesString() : String = {
        return this.getTotalMemoryKilobytesLong().toString()
    }

    def getTotalMemoryMegabytesString() : String = {
        return this.getTotalMemoryMegabytesLong().toString()
    }

    def getNumberOfThreads() : Long = {
        return Thread.activeCount()
    }

    def getNumberOfThreadsLong() : _root_.java.lang.Long = {
        return new _root_.java.lang.Long(this.getNumberOfThreads())
    }

    def getNumberOfThreadsString() : String = {
        return this.getNumberOfThreadsLong().toString()
    }

    def collectGarbage() : Unit = {
        this.runtime.gc()
    }

}


