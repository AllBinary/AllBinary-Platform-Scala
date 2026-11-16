/*  * AllBinary Open License Version 1  * Copyright (c) 2022 AllBinary  *   * By agreeing to this license you and any business entity you represent are  * legally bound to the AllBinary Open License Version 1 legal agreement.  *   * You may obtain the AllBinary Open License Version 1 legal agreement from  * AllBinary or the root directory of AllBinary's AllBinary Platform repository.  *   * Created By: Travis Berthelot  *   */
/* Generated Code Do Not Modify */
package org.allbinary.game.displayable.canvas

import _root_.org.allbinary.business.advertisement.GameAdStateFactory
import _root_.org.allbinary.game.GameAdState
import _root_.org.allbinary.game.configuration.feature.Features
import _root_.org.allbinary.graphics.opengles.CurrentDisplayableFactory
import _root_.org.allbinary.graphics.opengles.OpenGLFeatureFactory
import _root_.org.allbinary.logic.system.security.licensing.AbeClientInformationInterface

/**  *  * @author User  */
class BaseGameBehavior extends DemoGameBehavior {
    import _root_.org.allbinary.game.displayable.canvas.BaseGameBehavior.{*}

    override def init() : Unit = {
        val gameAdState : GameAdState = GameAdStateFactory.getInstance().getCurrentInstance()
        gameAdState.playingAdState()
    }

    override def pause(allBinaryGameCanvas : AllBinaryGameCanvas) : Unit = {
        val features : Features = Features.getInstance()
        //        } else 
        if (features.isDefault(OpenGLFeatureFactory.getInstance().OPENGL_AS_GAME_THREAD)) {
            //this.logUtil.putF("pause", this, METHOD_NAME);
            val currentDisplayableFactory : CurrentDisplayableFactory = CurrentDisplayableFactory.getInstance()
            currentDisplayableFactory.setRunnable(allBinaryGameCanvas.gamePauseRunnable)
        }
    }

    override def unPause(allBinaryGameCanvas : AllBinaryGameCanvas) : Unit = {
        //        } else 
        if (Features.getInstance().isDefault(OpenGLFeatureFactory.getInstance().OPENGL_AS_GAME_THREAD)) {
            //this.logUtil.putF(gameStrings.UNPAUSE, this, gameStrings.UNPAUSE);
            val currentDisplayableFactory : CurrentDisplayableFactory = CurrentDisplayableFactory.getInstance()
            currentDisplayableFactory.setRunnable(allBinaryGameCanvas.gameRunnable)
            currentDisplayableFactory.setDisplayable(allBinaryGameCanvas)
        }
    }

    override def updateTouch(allBinaryGameCanvas : AllBinaryGameCanvas) : Unit = {
        allBinaryGameCanvas.updateTouch2()
    }

    // Show/Hide the screen buttons
    override def updateScreenButtonPaintable(allBinaryGameCanvas : AllBinaryGameCanvas) : Unit = {
        allBinaryGameCanvas.updateScreenButtonPaintable2()
    }

    override def setGameState(allBinaryGameCanvas : AllBinaryGameCanvas) : Unit = {
        allBinaryGameCanvas.updateGameState()
    }

    override def removeAllGameKeyInputListeners(allBinaryGameCanvas : AllBinaryGameCanvas) : Unit = {
        allBinaryGameCanvas.removeAllGameKeyInputListeners2()
    }

    override def updateEndGameProcessor(allBinaryGameCanvas : AllBinaryGameCanvas) : Unit = {
        allBinaryGameCanvas.updateEndGameProcessor2()
    }

    override def buildGame(allBinaryGameCanvas : AllBinaryGameCanvas) : Unit = {
        allBinaryGameCanvas.buildGame2()
    }

    override def run(allBinaryGameCanvas : AllBinaryGameCanvas) : Unit = {
        allBinaryGameCanvas.run2()
    }

    override def setHighScore(abeClientInformation : AbeClientInformationInterface, allBinaryGameCanvas : AllBinaryGameCanvas, name : String, score : Long, autoSubmit : Boolean, isLast : Boolean) : Unit = {
        allBinaryGameCanvas.setHighScore2(abeClientInformation, name, score, autoSubmit, isLast)
    }

}

object BaseGameBehavior {
    //protected final LogUtil logUtil = LogUtil.getInstance();
    private val instanceC : BaseGameBehavior = new BaseGameBehavior()

    /**      * @return the instance      */
    def getInstance() : DemoGameBehavior = {
        return BaseGameBehavior.instanceC
    }

}


