/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.business.time


class Time private () {

    private var timeLong : _root_.java.lang.Long = null

    def this(time : String) = {
        this()
        this.timeLong = new _root_.java.lang.Long(time)
    }

    def this(time : Long) = {
        this()
        this.timeLong = new _root_.java.lang.Long(time)
    }

    def getLong() : _root_.java.lang.Long = {
        return this.timeLong
    }

    def getlong() : Long = {
        return this.timeLong.longValue()
    }

    override def toString() : String = {
        return this.getLong().toString()
    }

}


