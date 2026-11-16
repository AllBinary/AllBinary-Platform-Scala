/*  * AllBinary Open License Version 1  * Copyright (c) 2025 AllBinary  *   * By agreeing to this license you and any business entity you represent are  * legally bound to the AllBinary Open License Version 1 legal agreement.  *   * You may obtain the AllBinary Open License Version 1 legal agreement from  * AllBinary or the root directory of AllBinary's AllBinary Platform repository.  *   * Created By: Travis Berthelot  *   */
/* Generated Code Do Not Modify */
package org.allbinary.graphics.font

import _root_.javax.microedition.lcdui.Graphics

/**  *  * @author User  */
class UpdateMyFontProcessor(param_keyValueDrawCharArray : UpdateMyFontInterface) extends MyFontProcessor {

    private var updateMeasurementProcessor : UpdateMyFontInterface = null

    //Constructor
    {
        val keyValueDrawCharArray : UpdateMyFontInterface = param_keyValueDrawCharArray
        this.updateMeasurementProcessor = keyValueDrawCharArray
    }

    override def process(graphics : Graphics) : Unit = {
        this.updateMeasurementProcessor.updateMeasurement(graphics)
    }

}


