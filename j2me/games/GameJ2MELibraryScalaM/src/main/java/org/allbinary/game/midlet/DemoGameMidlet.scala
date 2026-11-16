/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.game.midlet

import _root_.org.allbinary.game.displayable.canvas.GameCanvasRunnableInterface
import _root_.org.allbinary.game.layer.AllBinaryGameLayerManager
import _root_.org.allbinary.graphics.canvas.transition.progress.ProgressCanvas
import _root_.org.allbinary.graphics.canvas.transition.progress.ProgressCanvasFactory
import _root_.org.allbinary.logic.StdUtil
import _root_.org.allbinary.logic.system.security.licensing.ClientInformationFactory
import _root_.org.allbinary.thread.PrimaryThreadPool
import _root_.org.allbinary.game.displayable.canvas.NullGameCanvasRunnable
import _root_.org.allbinary.util.ABHashtable

class DemoGameMidlet(param_clientInformationFactory : ClientInformationFactory) extends GameMidlet(param_clientInformationFactory) {

    //Constructor
    {
        val clientInformationFactory : ClientInformationFactory = param_clientInformationFactory
    }

    def isContinue() : Boolean = {
        var hashtable : ABHashtable[Object, Object] = this.getStartStateHashtable()
        if ((hashtable != null) && (hashtable.size() > 0)) {
            return true
        } else {
            return false
        }
        throw new IllegalStateException()
    }

    def getHighestLevel() : Int = {
        return 1
    }

    def createDemoGameCanvasRunnableInterface() : GameCanvasRunnableInterface = {
        this.logUtil.putF(this.commonStrings.NOT_IMPLEMENTED, this, this.commonStrings.CREATE)
        return NullGameCanvasRunnable.NULL_GAME_CANVAS_RUNNABLE
    }

    def createGameCanvasRunnable(allBinaryGameLayerManager : AllBinaryGameLayerManager) : GameCanvasRunnableInterface = {
        throw new Exception(this.commonStrings.NOT_IMPLEMENTED)
    }

    def createGameCanvasRunnableInterface() : GameCanvasRunnableInterface = {
        return this.createGameCanvasRunnable(this.createGameLayerManager())
    }

    /*      * protected void mediaInit() throws Exception { throw new Exception("Not      * Implemented"); }      */
    def demoSetup() : Unit = {
    }

    def postDemoSetup() : Unit = {
    }

    override def setDemo() : Unit = this.synchronized {
        this.logUtil.putF(this.commonStrings.START, this, "setDemo")
        ////TWB - Loading Feature Change - Can remove remark after testing
        val progressCanvas : ProgressCanvas = ProgressCanvasFactory.getInstance()
        progressCanvas.start()
        PrimaryThreadPool.getInstance().runTask(new DemoRunnable(this))
    }

    override def createGame() : Unit = this.synchronized {
        val CREATE_GAME : String = "createGame"
        this.logUtil.putF(this.commonStrings.START, this, CREATE_GAME)
        ////TWB - Loading Feature Change - Can remove remark after testing
        val progressCanvas : ProgressCanvas = ProgressCanvasFactory.getInstance()
        progressCanvas.start()
        var hashtable : ABHashtable[Object, Object] = this.getStartStateHashtable()
        this.setStartStateHashtable(StdUtil.getInstance().NULL_TABLE)
        PrimaryThreadPool.getInstance().runTask(new CreateGameRunnable(this, hashtable))
        this.logUtil.putF(this.commonStrings.END, this, CREATE_GAME)
    }

    def isReady() : Boolean = {
        return true
    }

}


