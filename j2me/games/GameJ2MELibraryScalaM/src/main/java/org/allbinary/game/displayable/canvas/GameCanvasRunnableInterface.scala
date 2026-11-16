/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.game.displayable.canvas

import _root_.javax.microedition.lcdui.CommandListener
import _root_.javax.microedition.lcdui.ItemStateListener
import _root_.org.allbinary.game.state.GameStateCompositeInterface
import _root_.org.allbinary.graphics.paint.PaintableInterface
import _root_.org.allbinary.thread.RunnableInterface
import _root_.org.allbinary.util.ABHashtable

trait GameCanvasRunnableInterface extends RunnableInterface with PaintableInterface with ItemStateListener with GameStateCompositeInterface {

    def getTitle() : String

    def isInitialized() : Boolean

    def isPaused() : Boolean

    def unPause() : Unit

    def pause() : Unit

    def isHighScoreSubmitted() : Boolean

    def setHighScoreSubmitted(highScoreSubmitted : Boolean) : Unit

    def processGameOver() : Unit

    def isGameOver() : Boolean

    def initCommands(cmdListener : CommandListener) : Unit

    def getCurrentStateHashtable() : ABHashtable[Object, Object]

    def getLoadStateHashtable() : ABHashtable[Object, Object]

    def setLoadStateHashtable(hashtable : ABHashtable[Object, Object]) : Unit

    //void addCommand(Command command);
    def getType() : Int

}


