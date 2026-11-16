/*  * AllBinary Open License Version 1  * Copyright (c) 2022 AllBinary  *   * By agreeing to this license you and any business entity you represent are  * legally bound to the AllBinary Open License Version 1 legal agreement.  *   * You may obtain the AllBinary Open License Version 1 legal agreement from  * AllBinary or the root directory of AllBinary's AllBinary Platform repository.  *   * Created By: Travis Berthelot  *   */
/* Generated Code Do Not Modify */
package org.allbinary.game.canvas

import _root_.javax.microedition.lcdui.Canvas
import _root_.javax.microedition.lcdui.NullCanvas
import _root_.org.allbinary.game.layer.AllBinaryGameLayerManager

/**  *  * @author User  */
class ABToGBUtil {
    import _root_.org.allbinary.game.canvas.ABToGBUtil.{*}

    var abCanvas : Canvas = NullCanvas.NULL_CANVAS

    var allBinaryGameLayerManager : AllBinaryGameLayerManager = AllBinaryGameLayerManager.getNullInstance()

}

object ABToGBUtil {
    private val instance : ABToGBUtil = new ABToGBUtil()

    /**      * @return the instance      */
    def getInstance() : ABToGBUtil = {
        return ABToGBUtil.instance
    }

}


