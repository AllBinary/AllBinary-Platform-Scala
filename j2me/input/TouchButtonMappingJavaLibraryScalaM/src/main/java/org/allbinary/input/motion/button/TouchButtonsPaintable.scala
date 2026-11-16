/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.input.motion.button

import _root_.javax.microedition.lcdui.Graphics
import _root_.org.allbinary.graphics.color.BasicColor
import _root_.org.allbinary.graphics.color.BasicColorSetUtil
import _root_.org.allbinary.graphics.paint.Paintable
import _root_.org.allbinary.util.BasicArrayList

class TouchButtonsPaintable(param_basicColor : BasicColor) extends Paintable {

    //protected final LogUtil logUtil = LogUtil.getInstance();
    var foregroundBasicColor : BasicColor = null

    var foregroundColor : Int = 0

    val basicSetColorUtil : BasicColorSetUtil = BasicColorSetUtil.getInstance()

    private val touchButtonFactory : TouchButtonFactory = TouchButtonFactory.getInstance()

    //Constructor
    {
        val basicColor : BasicColor = param_basicColor
        this.foregroundBasicColor = basicColor
        this.foregroundColor = basicColor.intValue()
    }

    override def paint(graphics : Graphics) : Unit = {
        val list : BasicArrayList = this.touchButtonFactory.getList()
        //PreLogUtil.put("List " + commonStrings.TOTAL_LABEL + list.size(), this, canvasStrings.PAINT);
        this.basicSetColorUtil.setBasicColorP3(graphics, this.foregroundBasicColor, this.foregroundColor)
        var touchButton : TouchButton = null

        {
            var index : Int = list.size()
            while ({ index -= 1; index } >= 0) {
                touchButton = list.objectArray(index).asInstanceOf[TouchButton]
                touchButton.paint(graphics)
            }
        }

        {
            var index : Int = list.size()
            while ({ index -= 1; index } >= 0) {
                touchButton = list.objectArray(index).asInstanceOf[TouchButton]
                touchButton.paintHint(graphics)
            }
        }
    }

}


