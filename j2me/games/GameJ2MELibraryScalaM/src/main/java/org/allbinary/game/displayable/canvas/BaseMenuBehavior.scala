/*  * AllBinary Open License Version 1  * Copyright (c) 2022 AllBinary  *   * By agreeing to this license you and any business entity you represent are  * legally bound to the AllBinary Open License Version 1 legal agreement.  *   * You may obtain the AllBinary Open License Version 1 legal agreement from  * AllBinary or the root directory of AllBinary's AllBinary Platform repository.  *   * Created By: Travis Berthelot  *   */
/* Generated Code Do Not Modify */
package org.allbinary.game.displayable.canvas

import _root_.org.allbinary.graphics.displayable.event.DisplayChangeEvent
import _root_.org.allbinary.graphics.paint.NullPaintable

/**  *  * @author User  */
class BaseMenuBehavior {
    import _root_.org.allbinary.game.displayable.canvas.BaseMenuBehavior.{*}

    def onDisplayChangeEvent(allBinaryGameCanvas : AllBinaryGameCanvas, displayChangeEvent : DisplayChangeEvent) : Unit = {
    }

    def initSpecialPaint(allBinaryGameCanvas : AllBinaryGameCanvas) : Unit = {
        allBinaryGameCanvas.setNonBotPaintableP(NullPaintable.getInstance())
    }

    def initMenu(allBinaryGameCanvas : AllBinaryGameCanvas) : Unit = {
    }

    def updateMenu(allBinaryGameCanvas : AllBinaryGameCanvas) : Unit = {
    }

    def popupMenu(allBinaryGameCanvas : AllBinaryGameCanvas) : Unit = {
    }

    def closeMenu(allBinaryGameCanvas : AllBinaryGameCanvas) : Unit = {
    }

}

object BaseMenuBehavior {
    private val instance : BaseMenuBehavior = new BaseMenuBehavior()

    /**      * @return the instance      */
    def getInstance() : BaseMenuBehavior = {
        return BaseMenuBehavior.instance
    }

}


