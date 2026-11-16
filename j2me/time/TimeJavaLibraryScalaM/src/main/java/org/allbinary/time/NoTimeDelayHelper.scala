/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.time


/**  *  * @author user  */
class NoTimeDelayHelper() extends TimeDelayHelper(0) {
    import _root_.org.allbinary.time.NoTimeDelayHelper.{SINGLETON as _, *}
    def SINGLETON : NoTimeDelayHelper = _root_.org.allbinary.time.NoTimeDelayHelper.SINGLETON

    override def isTimeTNT() : Boolean = {
        return true
    }

    override def isTimeSinceTNT(delay : Int) : Boolean = {
        return true
    }

    override def isTime(currentTime : Long) : Boolean = {
        return true
    }

    override def isTimeSince(delay : Int, currentTime : Long) : Boolean = {
        return true
    }

}

object NoTimeDelayHelper {
    val SINGLETON : NoTimeDelayHelper = new NoTimeDelayHelper()

}


