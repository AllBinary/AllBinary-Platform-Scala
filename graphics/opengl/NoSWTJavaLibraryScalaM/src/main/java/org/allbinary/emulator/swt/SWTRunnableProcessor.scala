/*  * AllBinary Open License Version 1  * Copyright (c) 2022 AllBinary  *   * By agreeing to this license you and any business entity you represent are  * legally bound to the AllBinary Open License Version 1 legal agreement.  *   * You may obtain the AllBinary Open License Version 1 legal agreement from  * AllBinary or the root directory of AllBinary's AllBinary Platform repository.  *   * Created By: Travis Berthelot  *   */
/* Generated Code Do Not Modify */
package org.allbinary.emulator.swt

import _root_.org.eclipse.swt.widgets.Display

/**  *  * @author User  */
class SWTRunnableProcessor extends SWTProcessor {
    import _root_.org.allbinary.emulator.swt.SWTRunnableProcessor.{*}

    override def process(display : Display) : Unit = {
    }

}

object SWTRunnableProcessor {
    private val instanceR : SWTRunnableProcessor = new SWTRunnableProcessor()

    /**      * @return the instance      */
    def getInstance() : SWTRunnableProcessor = {
        return SWTRunnableProcessor.instanceR
    }

}


