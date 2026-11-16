/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.game.displayable.canvas

import _root_.org.allbinary.graphics.displayable.DisplayInfoSingleton

class GameRunnable() extends Runnable {

    val WAIT : Int = 240

    val FAST : Int = 60

    var waitInMillis : Long = this.WAIT.toLong

    override def run() : Unit = {
        DisplayInfoSingleton.getInstance().process()
    }

    def processLoopSleep() : Unit = {
        Thread.sleep(this.waitInMillis)
    }

}


