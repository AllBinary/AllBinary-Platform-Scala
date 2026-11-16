/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.game.layer

import _root_.javax.microedition.lcdui.Graphics
import _root_.org.allbinary.graphics.color.BasicColor
import _root_.org.allbinary.graphics.color.BasicColorFactory
import _root_.org.allbinary.graphics.color.BasicColorSetUtil
import _root_.org.allbinary.graphics.paint.Paintable

class SWTBlackPaintable extends Paintable {

    private val basicSetColorUtil : BasicColorSetUtil = BasicColorSetUtil.getInstance()

    private val BLACK : BasicColor = BasicColorFactory.getInstance().BLACK

    override def paint(graphics : Graphics) : Unit = {
        this.basicSetColorUtil.setBasicColorP(graphics, this.BLACK)
    }

}


