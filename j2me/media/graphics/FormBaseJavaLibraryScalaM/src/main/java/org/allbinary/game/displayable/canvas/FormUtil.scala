/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.game.displayable.canvas

import _root_.org.allbinary.graphics.PointFactory
import _root_.org.allbinary.graphics.Rectangle
import _root_.org.allbinary.graphics.displayable.DisplayInfoSingleton
import _root_.org.allbinary.logic.communication.log.LogUtil

class FormUtil {
    import _root_.org.allbinary.game.displayable.canvas.FormUtil.{*}

    def createFormRectangle() : Rectangle = {
        //final CommonStrings commonStrings = CommonStrings.getInstance();
        val displayInfo : DisplayInfoSingleton = DisplayInfoSingleton.getInstance()
        val pointFactory : PointFactory = PointFactory.getInstance()
        val rectangle : Rectangle = new Rectangle(pointFactory.createXY(30, 10), displayInfo.getLastWidth() - 30, displayInfo.getLastHeight() - 35)
        //this.logUtil.putF("form menu rectangle: " + rectangle.toString(), this, commonStrings.PROCESS);
        return rectangle
    }

}

object FormUtil {
    //protected final LogUtil logUtil = LogUtil.getInstance();
    private val instance : FormUtil = new FormUtil()

    def getInstance() : FormUtil = {
        return FormUtil.instance
    }

}


