/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.game.displayable.canvas

import _root_.javax.microedition.lcdui.CommandListener
import _root_.javax.microedition.lcdui.Graphics
import _root_.javax.microedition.lcdui.NullCommandListener
import _root_.org.allbinary.game.init.BasicBuildGameInitializerFactory
import _root_.org.allbinary.game.layer.AllBinaryGameLayerManager
import _root_.org.allbinary.game.score.NoHighScoresFactory
import _root_.org.allbinary.logic.NullUtil
import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.string.CommonStrings

class NullGameCanvas(param_gameLayerManager : AllBinaryGameLayerManager) extends AllBinaryGameCanvas(NullCommandListener.NULL_COMMAND_LISTENER, param_gameLayerManager, NoHighScoresFactory.getInstance(), BasicBuildGameInitializerFactory.NULL_BASE_BUILD_GMAE_INITIALIZER_FACTORY, false) {
    import _root_.org.allbinary.game.displayable.canvas.NullGameCanvas.{NO_GAME as _, TYPE as _, *}
    def NO_GAME : String = _root_.org.allbinary.game.displayable.canvas.NullGameCanvas.NO_GAME
    override def TYPE : Int = _root_.org.allbinary.game.displayable.canvas.NullGameCanvas.TYPE

    private var runningNull : Boolean = true

    //Constructor
    {
        val gameLayerManager : AllBinaryGameLayerManager = param_gameLayerManager
        super.setWait(1200)
    }

    override def isGameOver() : Boolean = this.synchronized {
        return false
    }

    override def setRunning(running : Boolean) : Unit = {
        this.runningNull = running
    }

    override def isRunning() : Boolean = this.synchronized {
        return this.runningNull
    }

    override def pause() : Unit = this.synchronized {
        this.setPaused(true)
    }

    override def unPause() : Unit = this.synchronized {
        this.setPaused(false)
    }

    override def initCommands(cmdListener : CommandListener) : Unit = {
        this.removeAllCommands()
        // this.addCommand(GameCommands.RESTART_COMMAND);
        this.setCommandListener(cmdListener)
    }

    override def buildGameInit(isProgress : Boolean) : Unit = {
    }

    override def draw(graphics : Graphics) : Unit = {
    }

    override def run() : Unit = {
        try {
            this.logUtil.putF(this.commonStrings.START_RUNNABLE, this, this.commonStrings.RUN)
            //this.setRunning(false);
            this.logUtil.putF(this.commonStrings.END_RUNNABLE, this, this.commonStrings.RUN)
        } catch {
            case e : Exception => {
                this.logUtil.put(this.commonStrings.EXCEPTION, this, this.commonStrings.RUN, e)
            }
        }
    }

    override def getType() : Int = {
        return NullGameCanvas.TYPE
    }

}

object NullGameCanvas {
    private def createNull() : NullGameCanvas = {
        try {
            return new NullGameCanvas(AllBinaryGameLayerManager.getNullInstance())
        } catch {
            case e : Exception => {
                LogUtil.getInstance().put(CommonStrings.getInstance().EXCEPTION, "NullGameCanvas", CommonStrings.getInstance().GET_INSTANCE, e)
                throw new RuntimeException()
            }
        }
        throw new IllegalStateException()
    }

    private var instance : Object = NullUtil.getInstance().NULL_OBJECT

    def getInstance() : NullGameCanvas = {
        if (NullGameCanvas.instance eq NullUtil.getInstance().NULL_OBJECT) {
            NullGameCanvas.instance = NullGameCanvas.createNull()
        }
        return NullGameCanvas.instance.asInstanceOf[NullGameCanvas]
    }

    def createCanvas(gameLayerManager : AllBinaryGameLayerManager) : NullGameCanvas = {
        val nullGameCanvas : NullGameCanvas = new NullGameCanvas(gameLayerManager)
        nullGameCanvas.setInitialized(true)
        nullGameCanvas.setTitle(NullGameCanvas.NO_GAME)
        return nullGameCanvas
    }

    val NO_GAME : String = "No Background Game"

    val TYPE : Int = 1

}


