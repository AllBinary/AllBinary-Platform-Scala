/*  * AllBinary Open License Version 1  * Copyright (c) 2025 AllBinary  *   * By agreeing to this license you and any business entity you represent are  * legally bound to the AllBinary Open License Version 1 legal agreement.  *   * You may obtain the AllBinary Open License Version 1 legal agreement from  * AllBinary or the root directory of AllBinary's AllBinary Platform repository.  *   * Created By: Travis Berthelot  *   */
/* Generated Code Do Not Modify */
package org.allbinary.thread


/**  *  * @author User  */
class NullABRunnable extends ABRunnable {
    import _root_.org.allbinary.thread.NullABRunnable.{*}

    override def isRunning() : Boolean = this.synchronized {
        return false
    }

}

object NullABRunnable {
    private val instance : NullABRunnable = new NullABRunnable()

    /**      * @return the instance      */
    def getInstance() : NullABRunnable = {
        return NullABRunnable.instance
    }

}


