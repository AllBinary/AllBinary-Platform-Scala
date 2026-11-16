/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.game.layer

import _root_.javax.microedition.lcdui.Graphics
import _root_.org.allbinary.game.input.PlayerGameInput
import _root_.org.allbinary.game.input.PlayerGameInputCompositeInterface
import _root_.org.allbinary.graphics.PointFactory
import _root_.org.allbinary.graphics.Rectangle
import _root_.org.allbinary.graphics.displayable.CanvasStrings
import _root_.org.allbinary.layer.AllBinaryLayerManager
import _root_.org.allbinary.logic.string.StringUtil
import _root_.org.allbinary.util.BasicArrayListD
import _root_.org.allbinary.view.StaticViewPosition

class PlayerGameInputGameLayer(param_playerInputId : Int) extends AllBinaryGameLayer(StringUtil.getInstance().EMPTY_STRING, new Rectangle(PointFactory.getInstance().ZERO_ZERO, 0, 0), new StaticViewPosition(0, 0, 0)) with PlayerGameInputCompositeInterface {

    private var playerGameInput : PlayerGameInput = null

    //Constructor
    {
        val playerInputId : Int = param_playerInputId
        this.playerGameInput = new PlayerGameInput(this.getGameKeyEventList(), new BasicArrayListD(), playerInputId)
        val canvasStrings : CanvasStrings = CanvasStrings.getInstance()
        this.logUtil.putF("Danger Danger Danger: Should Not Be Called Except For Testing Input", this, canvasStrings.PAINT)
    }

    override def getPlayerGameInput() : PlayerGameInput = {
        return this.playerGameInput
    }

    override def initInputProcessors() : Unit = {
    }

    override def processInput(myManager : AllBinaryLayerManager) : Unit = {
    }

    override def paint(graphics : Graphics) : Unit = {
    }

}


