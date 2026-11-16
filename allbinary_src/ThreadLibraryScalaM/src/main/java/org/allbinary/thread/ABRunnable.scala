/*  * AllBinary Open License Version 1  * Copyright (c) 2022 AllBinary  *   * By agreeing to this license you and any business entity you represent are  * legally bound to the AllBinary Open License Version 1 legal agreement.  *   * You may obtain the AllBinary Open License Version 1 legal agreement from  * AllBinary or the root directory of AllBinary's AllBinary Platform repository.  *   * Created By: Travis Berthelot  *   */
/* Generated Code Do Not Modify */
package org.allbinary.thread


/**  *  * @author User  */
class ABRunnable extends RunnableInterface {

    private var running : Boolean = false

    override def setThread(thread : Thread) : Unit = {
    }

    override def isRunning() : Boolean = this.synchronized {
        return this.running
    }

    override def setRunning(running : Boolean) : Unit = this.synchronized {
        this.running = running
    }

    override def run() : Unit = {
    }

    def getType() : Int = {
        return -1
    }

}


