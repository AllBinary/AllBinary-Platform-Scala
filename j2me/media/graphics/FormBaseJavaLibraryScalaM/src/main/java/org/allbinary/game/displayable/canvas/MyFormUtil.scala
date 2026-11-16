/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.game.displayable.canvas

import _root_.javax.microedition.lcdui.Font
import _root_.javax.microedition.lcdui.Graphics
import _root_.org.allbinary.game.configuration.feature.Features
import _root_.org.allbinary.graphics.PointFactory
import _root_.org.allbinary.graphics.Rectangle
import _root_.org.allbinary.graphics.RectangleFactory
import _root_.org.allbinary.graphics.displayable.DisplayInfoSingleton
import _root_.org.allbinary.graphics.font.MyFontProcessor
import _root_.org.allbinary.graphics.opengles.OpenGLFeatureFactory
import _root_.org.allbinary.graphics.threed.SWTJOGLProcessor
import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.string.CommonStrings

class MyFormUtil {
    import _root_.org.allbinary.game.displayable.canvas.MyFormUtil.{*}

    val logUtil : LogUtil = LogUtil.getInstance()

    private val commonStrings : CommonStrings = CommonStrings.getInstance()

    // Popup Menu Tab Init
    private var popupMenuRectangle : Rectangle = RectangleFactory.SINGLETON

    def updateMeasurement(graphics : Graphics) : Unit = {
        val font : Font = graphics.getFont()
        val displayInfo : DisplayInfoSingleton = DisplayInfoSingleton.getInstance()
        val features : Features = Features.getInstance()
        val isOpenGL : Boolean = features.isDefault(OpenGLFeatureFactory.getInstance().OPENGL)
        val TOTAL_CHAR_WIDTH : Int = (if (SWTJOGLProcessor.getInstance().isJOGL() && isOpenGL) 2 else 3)
        val width : Int = MyFontProcessor.defaultStringWidth(font, TOTAL_CHAR_WIDTH)
        val pointFactory : PointFactory = PointFactory.getInstance()
        // Popup Menu Tab Init
        if (displayInfo.getLastHeight() < 320) {
            // Make a smaller button for QVGA and move it to the top
            this.popupMenuRectangle = new Rectangle(pointFactory.createXY(0, 25), width, (font.getHeight() * 4) + 2)
        } else {
            this.popupMenuRectangle = new Rectangle(pointFactory.createXY(0, displayInfo.getLastHalfHeight() - 70), width, (font.getHeight() * 5))
        }
    }

    def getPopupMenuRectangle() : Rectangle = {
        //this.logUtil.putF("return popupMenuRectangle: " + this.popupMenuRectangle.toString(), this, this.commonStrings.PROCESS);
        return this.popupMenuRectangle
    }

}

object MyFormUtil {
    private val instance : MyFormUtil = new MyFormUtil()

    def getInstance() : MyFormUtil = {
        return MyFormUtil.instance
    }

}


