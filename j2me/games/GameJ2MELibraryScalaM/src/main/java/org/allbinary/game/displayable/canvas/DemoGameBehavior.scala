/*  * AllBinary Open License Version 1  * Copyright (c) 2022 AllBinary  *   * By agreeing to this license you and any business entity you represent are  * legally bound to the AllBinary Open License Version 1 legal agreement.  *   * You may obtain the AllBinary Open License Version 1 legal agreement from  * AllBinary or the root directory of AllBinary's AllBinary Platform repository.  *   * Created By: Travis Berthelot  *   */
/* Generated Code Do Not Modify */
package org.allbinary.game.displayable.canvas

import _root_.org.allbinary.game.GameTypeFactory
import _root_.org.allbinary.graphics.paint.NullPaintable
import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.logic.system.security.licensing.AbeClientInformationInterface
import _root_.org.allbinary.string.CommonStrings

/**  *  * @author User  */
class DemoGameBehavior {
    import _root_.org.allbinary.game.displayable.canvas.DemoGameBehavior.{*}

    val logUtil : LogUtil = LogUtil.getInstance()

    def init() : Unit = {
    }

    def pause(allBinaryGameCanvas : AllBinaryGameCanvas) : Unit = {
    }

    def unPause(allBinaryGameCanvas : AllBinaryGameCanvas) : Unit = {
    }

    def updateTouch(allBinaryGameCanvas : AllBinaryGameCanvas) : Unit = {
    }

    // Show/Hide the screen buttons
    def updateScreenButtonPaintable(allBinaryGameCanvas : AllBinaryGameCanvas) : Unit = {
        allBinaryGameCanvas.setTouchPaintableP(NullPaintable.getInstance())
    }

    def setGameState(allBinaryGameCanvas : AllBinaryGameCanvas) : Unit = {
    }

    def removeAllGameKeyInputListeners(allBinaryGameCanvas : AllBinaryGameCanvas) : Unit = {
    }

    def updateEndGameProcessor(allBinaryGameCanvas : AllBinaryGameCanvas) : Unit = {
    }

    def buildGame(allBinaryGameCanvas : AllBinaryGameCanvas) : Unit = {
    }

    //Don't keep running thread if in bot/demo mode
    def run(allBinaryGameCanvas : AllBinaryGameCanvas) : Unit = {
        val commonStrings : CommonStrings = CommonStrings.getInstance()
        this.logUtil.putF(GameTypeFactory.getInstance().BOT.toString(), this, commonStrings.RUN)
    }

    def setHighScore(abeClientInformation : AbeClientInformationInterface, allBinaryGameCanvas : AllBinaryGameCanvas, name : String, score : Long, autoSubmit : Boolean, isLast : Boolean) : Unit = {
    }

}

object DemoGameBehavior {
    private val instance : DemoGameBehavior = new DemoGameBehavior()

    /**      * @return the instance      */
    def getInstance() : DemoGameBehavior = {
        return DemoGameBehavior.instance
    }

}


