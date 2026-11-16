/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.debug


class NoDebug extends DebugInterface {
    import _root_.org.allbinary.debug.NoDebug.{*}

    override def start() : Unit = {
    }

    override def stop() : Unit = {
    }

    override def getMaxTime() : Long = {
        return 10000
    }

    override def getStartTime() : Long = {
        return 0
    }

    override def isRunning() : Boolean = {
        return false
    }

}

object NoDebug {
    private var SINGLETON : DebugInterface = new NoDebug()

    def getInstance() : DebugInterface = {
        return NoDebug.SINGLETON
    }

}


