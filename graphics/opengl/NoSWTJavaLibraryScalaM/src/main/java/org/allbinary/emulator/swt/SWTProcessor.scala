/*  * AllBinary Open License Version 1  * Copyright (c) 2022 AllBinary  *   * By agreeing to this license you and any business entity you represent are  * legally bound to the AllBinary Open License Version 1 legal agreement.  *   * You may obtain the AllBinary Open License Version 1 legal agreement from  * AllBinary or the root directory of AllBinary's AllBinary Platform repository.  *   * Created By: Travis Berthelot  *   */
/* Generated Code Do Not Modify */
package org.allbinary.emulator.swt

import _root_.org.eclipse.swt.widgets.Display
import _root_.org.allbinary.thread.NullRunnable

/**  *  * @author User  */
class SWTProcessor {
    import _root_.org.allbinary.emulator.swt.SWTProcessor.{*}

    var runnable : Runnable = NullRunnable.getInstance()

    def process(display : Display) : Unit = {
        display.sleep()
    }

}

object SWTProcessor {
    private val instance : SWTProcessor = new SWTProcessor()

    /**      * @return the instance      */
    def getInstance() : SWTProcessor = {
        return SWTProcessor.instance
    }

}


