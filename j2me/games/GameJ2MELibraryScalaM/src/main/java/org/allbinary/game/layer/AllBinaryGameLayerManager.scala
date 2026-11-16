/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.game.layer

import _root_.org.allbinary.game.GameInfo
import _root_.org.allbinary.game.input.NullPlayerGameInputComposite
import _root_.org.allbinary.game.input.PlayerGameInputCompositeInterface
import _root_.org.allbinary.graphics.ItemColorFactory
import _root_.org.allbinary.graphics.color.BasicColor
import _root_.org.allbinary.graphics.color.BasicColorFactory
import _root_.org.allbinary.layer.AllBinaryLayerManager
import _root_.org.allbinary.layer.LayerProcessor
import _root_.org.allbinary.logic.NullUtil
import _root_.org.allbinary.logic.math.SmallIntegerSingletonFactory
import _root_.org.allbinary.util.BasicArrayList

class AllBinaryGameLayerManager(param_backgroundBasicColor : BasicColor, param_foregroundBasicColor : BasicColor, param_gameInfo : GameInfo) extends AllBinaryLayerManager {
    import _root_.org.allbinary.game.layer.AllBinaryGameLayerManager.{ID as _, *}
    def ID : Integer = _root_.org.allbinary.game.layer.AllBinaryGameLayerManager.ID

    private var backgroundBasicColor : BasicColor = null

    private var foregroundBasicColor : BasicColor = null

    private var gameInfo : GameInfo = null

    private var playerGameInputCompositeInterface : PlayerGameInputCompositeInterface = NullPlayerGameInputComposite.NULL_PLAYER_GAME_INPUT_COMPOSITE

    //Constructor
    {
        val backgroundBasicColor : BasicColor = param_backgroundBasicColor
        val foregroundBasicColor : BasicColor = param_foregroundBasicColor
        val gameInfo : GameInfo = param_gameInfo
        this.backgroundBasicColor = backgroundBasicColor
        this.foregroundBasicColor = foregroundBasicColor
        var itemColorFactory : ItemColorFactory = ItemColorFactory.getInstance()
        itemColorFactory.INVERT_PAINT = this.backgroundBasicColor.intValue()
        itemColorFactory.PAINT = this.foregroundBasicColor.intValue()
        this.gameInfo = gameInfo
    }

    def getLayerManager() : AllBinaryLayerManager = {
        return this
    }

    def init() : Unit = {
    }

    def getBackgroundBasicColor() : BasicColor = {
        return this.backgroundBasicColor
    }

    def setBackgroundBasicColor(backgroundBasicColor : BasicColor) : Unit = {
        this.backgroundBasicColor = backgroundBasicColor
        ItemColorFactory.getInstance().INVERT_PAINT = this.backgroundBasicColor.intValue()
    }

    def getForegroundBasicColor() : BasicColor = {
        return this.foregroundBasicColor
    }

    def setForegroundBasicColor(foregroundBasicColor : BasicColor) : Unit = {
        this.foregroundBasicColor = foregroundBasicColor
        ItemColorFactory.getInstance().PAINT = this.foregroundBasicColor.intValue()
    }

    def getGameInfo() : GameInfo = {
        return this.gameInfo
    }

    def setGameInfo(gameInfo : GameInfo) : Unit = {
        this.gameInfo = gameInfo
    }

    def setLayerProcessorList(list : BasicArrayList) : Unit = {
        val layerProcessorInterfaceArray : Array[LayerProcessor] = new Array[LayerProcessor](list.size())
        var size : Int = layerProcessorInterfaceArray.length

        {
            var index : Int = 0
            while (index < size) {
                layerProcessorInterfaceArray(index) = list.objectArray(index).asInstanceOf[LayerProcessor]
                index += 1
            }
        }
        this.setLayerProcessorArray(layerProcessorInterfaceArray)
    }

    def setPlayerGameInputCompositeInterface(playerGameInputCompositeInterface : PlayerGameInputCompositeInterface) : Unit = {
        this.playerGameInputCompositeInterface = playerGameInputCompositeInterface
    }

    def getPlayerGameInputCompositeInterface() : PlayerGameInputCompositeInterface = {
        return this.playerGameInputCompositeInterface
    }

}

object AllBinaryGameLayerManager {
    private var NULL_ALLBINARY_LAYER_MANAGER : Object = NullUtil.getInstance().NULL_OBJECT

    def getNullInstance() : AllBinaryGameLayerManager = {
        if (AllBinaryGameLayerManager.NULL_ALLBINARY_LAYER_MANAGER eq NullUtil.getInstance().NULL_OBJECT) {
            AllBinaryGameLayerManager.NULL_ALLBINARY_LAYER_MANAGER = new AllBinaryGameLayerManager(BasicColorFactory.getInstance().BLACK, BasicColorFactory.getInstance().WHITE, GameInfo.NONE)
        }
        return AllBinaryGameLayerManager.NULL_ALLBINARY_LAYER_MANAGER.asInstanceOf[AllBinaryGameLayerManager]
    }

    val ID : Integer = SmallIntegerSingletonFactory.getInstance().getAt(22)

}


