/*  * AllBinary Open License Version 1  * Copyright (c) 2022 AllBinary  *   * By agreeing to this license you and any business entity you represent are  * legally bound to the AllBinary Open License Version 1 legal agreement.  *   * You may obtain the AllBinary Open License Version 1 legal agreement from  * AllBinary or the root directory of AllBinary's AllBinary Platform repository.  *   * Created By: Travis Berthelot  *   */
/* Generated Code Do Not Modify */
package org.allbinary.emulator.swt


/**  *  * @author User  */
class SWTProcessorUtil {
    import _root_.org.allbinary.emulator.swt.SWTProcessorUtil.{*}

    var swtProcessor : SWTProcessor = SWTProcessor.getInstance()

}

object SWTProcessorUtil {
    private val instance : SWTProcessorUtil = new SWTProcessorUtil()

    /**      * @return the instance      */
    def getInstance() : SWTProcessorUtil = {
        return SWTProcessorUtil.instance
    }

}


