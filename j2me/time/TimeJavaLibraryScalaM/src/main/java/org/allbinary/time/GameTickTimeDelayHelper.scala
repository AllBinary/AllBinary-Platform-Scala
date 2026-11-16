/*  * AllBinary Open License Version 1  * Copyright (c) 2022 AllBinary  *   * By agreeing to this license you and any business entity you represent are  * legally bound to the AllBinary Open License Version 1 legal agreement.  *   * You may obtain the AllBinary Open License Version 1 legal agreement from  * AllBinary or the root directory of AllBinary's AllBinary Platform repository.  *   * Created By: Travis Berthelot  *   */
/* Generated Code Do Not Modify */
package org.allbinary.time


/**  *  * @author User  */
class GameTickTimeDelayHelper(param_startTime : Long) {

    var timeDelta : Long = 0L

    var startTime : Long = 0L

    var lastStartTime : Long = 0L

    //    }
    //Constructor
    {
        val startTime : Long = param_startTime
        this.startTime = startTime
        this.lastStartTime = 0
    }

    def setStartTime() : Long = {
        this.startTime = System.currentTimeMillis()
        return this.startTime
    }

    def loop() : Unit = {
        if (this.lastStartTime == _root_.java.lang.Long.MIN_VALUE) {
            this.timeDelta = 0
        } else {
            this.timeDelta = System.currentTimeMillis() - this.lastStartTime
        }
    }

    def getTimeFromStart() : Long = {
        return this.startTime - this.lastStartTime
    }

}


