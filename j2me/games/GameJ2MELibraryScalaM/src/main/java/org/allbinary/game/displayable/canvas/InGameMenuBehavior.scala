/*  * AllBinary Open License Version 1  * Copyright (c) 2022 AllBinary  *   * By agreeing to this license you and any business entity you represent are  * legally bound to the AllBinary Open License Version 1 legal agreement.  *   * You may obtain the AllBinary Open License Version 1 legal agreement from  * AllBinary or the root directory of AllBinary's AllBinary Platform repository.  *   * Created By: Travis Berthelot  *   */
/* Generated Code Do Not Modify */
package org.allbinary.game.displayable.canvas

import _root_.org.allbinary.graphics.displayable.event.DisplayChangeEvent

/**  *  * @author User  */
class InGameMenuBehavior extends BaseMenuBehavior {
    import _root_.org.allbinary.game.displayable.canvas.InGameMenuBehavior.{*}

    override def onDisplayChangeEvent(allBinaryGameCanvas : AllBinaryGameCanvas, displayChangeEvent : DisplayChangeEvent) : Unit = {
        allBinaryGameCanvas.updateMenuFromEvent(displayChangeEvent)
    }

    override def initSpecialPaint(allBinaryGameCanvas : AllBinaryGameCanvas) : Unit = {
        allBinaryGameCanvas.setNonBotPaintableP(new GameCanvasNonBotPaintable(allBinaryGameCanvas))
    }

    override def initMenu(allBinaryGameCanvas : AllBinaryGameCanvas) : Unit = {
        allBinaryGameCanvas.initMenu2()
    }

    override def updateMenu(allBinaryGameCanvas : AllBinaryGameCanvas) : Unit = {
        allBinaryGameCanvas.initMenu2()
    }

    override def popupMenu(allBinaryGameCanvas : AllBinaryGameCanvas) : Unit = {
        allBinaryGameCanvas.popupMenu2()
    }

    override def closeMenu(allBinaryGameCanvas : AllBinaryGameCanvas) : Unit = {
        allBinaryGameCanvas.closeMenu2()
    }

}

object InGameMenuBehavior {
    private val instanceC : InGameMenuBehavior = new InGameMenuBehavior()

    /**      * @return the instance      */
    def getInstance() : InGameMenuBehavior = {
        return InGameMenuBehavior.instanceC
    }

}


