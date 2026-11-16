/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.input.automation.module.game

import _root_.java.awt.image.BufferedImage
import _root_.org.allbinary.logic.string.StringMaker
import _root_.org.allbinary.string.CommonSeps

class MagicGameObject(param_bufferedImage : Array[BufferedImage], param_minX : Integer, param_maxX : Integer, param_y : Integer) extends MeteredGameObject(param_bufferedImage, param_minX, param_maxX, param_y) with MagicGameObjectInterface {

    private val MP_LABEL : String = "MP:"

    //Constructor
    {
        val bufferedImage : Array[BufferedImage] = param_bufferedImage
        val minX : Integer = param_minX
        val maxX : Integer = param_maxX
        val y : Integer = param_y
    }

    override def toString() : String = {
        var stringBuffer : StringMaker = new StringMaker()
        stringBuffer.append(CommonSeps.getInstance().NEW_LINE)
        stringBuffer.append(this.MP_LABEL)
        stringBuffer.append(super.toString())
        return stringBuffer.toString()
    }

}


