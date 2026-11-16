/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.graphics.color

import _root_.javax.microedition.lcdui.Graphics

class BasicColorSetUtil() {
    import _root_.org.allbinary.graphics.color.BasicColorSetUtil.{*}

    def setBasicColorP(graphics : Graphics, basicColor : BasicColor) : Unit = {
        graphics.setColor(basicColor.intValue())
    }

    def setBasicColorP3(graphics : Graphics, basicColor : BasicColor, value : Int) : Unit = {
        graphics.setColor(value)
    }

}

object BasicColorSetUtil {
    private val instance : BasicColorSetUtil = new BasicColorSetUtil()

    def getInstance() : BasicColorSetUtil = {
        return BasicColorSetUtil.instance
    }

}


