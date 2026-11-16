/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.game.input

import _root_.javax.microedition.lcdui.Canvas
import _root_.javax.microedition.lcdui.Graphics
import _root_.org.allbinary.util.BasicArrayList
import _root_.org.allbinary.game.configuration.feature.Features
import _root_.org.allbinary.game.configuration.feature.InputFeatureFactory
import _root_.org.allbinary.game.input.event.GameKeyEvent
import _root_.org.allbinary.game.layer.AllBinaryGameLayerManager
import _root_.org.allbinary.game.layer.AllBinaryTiledLayer
import _root_.org.allbinary.graphics.displayable.DisplayInfoSingleton
import _root_.org.allbinary.layer.AllBinaryLayerManager
import _root_.org.allbinary.layer.event.ScrollMapEvent
import _root_.org.allbinary.layer.event.ScrollMapEventHandler
import _root_.org.allbinary.media.graphics.geography.map.BasicGeographicMap
import _root_.org.allbinary.util.BasicArrayListD

/**  *  * @author user  */
class ScrollMapPlayerGameInput(param_geographicMapInterface : BasicGeographicMap, param_list : BasicArrayList, param_playerInputId : Int) extends PlayerGameInput(param_list, new BasicArrayListD(), param_playerInputId) {

    val inputProcessorArray : Array[GameInputProcessor] = new Array[GameInputProcessor](InputFactory.getInstance().MAX)

    private val border : Int = 150

    private var inputList : BasicArrayList = null

    val isSingleKeyProcessing : Boolean = Features.getInstance().isFeature(InputFeatureFactory.getInstance().SINGLE_KEY_REPEAT_PRESS) || Features.getInstance().isFeature(InputFeatureFactory.getInstance().SINGLE_KEY_PRESS)

    private var geographicMapInterface : BasicGeographicMap = null

    private var maxBottom : Int = 0

    private var maxRight : Int = 0

    private val scrollMapEvent : ScrollMapEvent = new ScrollMapEvent(this)

    //Constructor
    {
        val geographicMapInterface : BasicGeographicMap = param_geographicMapInterface
        val list : BasicArrayList = param_list
        val playerInputId : Int = param_playerInputId
        this.initInputProcessors()
        this.geographicMapInterface = geographicMapInterface
        this.inputList = list
        this.init()
    }

    private def move(dx : Int, dy : Int) : Unit = {
        var terrainTiledLayer : AllBinaryTiledLayer = this.geographicMapInterface.getAllBinaryTiledLayer()
        terrainTiledLayer.moveDXY(-dx, -dy)
        this.scrollMapEvent.setDxDy(-dx, -dy)
        ScrollMapEventHandler.getInstance().fireEvent(this.scrollMapEvent)
    }

    def init() : Unit = {
        this.maxBottom = this.getSpecialHeight()
        this.maxRight = this.getSpecialWidth()
    }

    def scrollMiddleX() : Unit = {
        var terrainTiledLayer : AllBinaryTiledLayer = this.geographicMapInterface.getAllBinaryTiledLayer()
        var displayInfo : DisplayInfoSingleton = DisplayInfoSingleton.getInstance()
        //PreLogUtil.put(diffX + CommonSeps.getInstance().SPACE + CommonSeps.getInstance().SPACE + terrainTiledLayer.getWidth() + CommonSeps.getInstance().SPACE + displayInfo.getLastWidth(), this, "scrollMiddleX");
        this.move(-terrainTiledLayer.getXP(), 0)
        if (terrainTiledLayer.getWidth() < displayInfo.getLastWidth()) {
            var diffX : Int = ((displayInfo.getLastWidth() - terrainTiledLayer.getWidth()) >> 1)
            this.move(-diffX, 0)
        } else {
            var diffX : Int = ((terrainTiledLayer.getWidth() - displayInfo.getLastWidth()) >> 1)
            this.move(diffX, 0)
        }
    }

    //Graphics.HCENTER & Graphics.TOP
    def scrollY(anchor : Int) : Unit = {
        var terrainTiledLayer : AllBinaryTiledLayer = this.geographicMapInterface.getAllBinaryTiledLayer()
        var displayInfo : DisplayInfoSingleton = DisplayInfoSingleton.getInstance()
        if (anchor == Graphics.TOP) {
            this.logUtil.putF("Top", this, "scrollY")
        } else if (anchor == Graphics.BOTTOM) {
            this.logUtil.putF("Bottom", this, "scrollY")
            var diffY : Int = (terrainTiledLayer.getHeight() - displayInfo.getLastHeight())
            this.move(0, diffY)
        } else if (anchor == Graphics.VCENTER) {
            this.logUtil.putF("Center", this, "scrollY")
            //Already sees bottom but I want the map at the Center
            var diffY : Int = (terrainTiledLayer.getHeight() - displayInfo.getLastHeight()) / 2
            this.move(0, diffY)
        } else {
            throw new Exception("No Such Anchor Supported")
        }
    }

    def up() : Unit = {
        var y : Int = this.geographicMapInterface.getAllBinaryTiledLayer().getYP() - 10
        if (this.keepOnMapMinY(y)) {
            this.move(0, -10)
        }
    }

    def down() : Unit = {
        var y : Int = -this.geographicMapInterface.getAllBinaryTiledLayer().getYP() + 10
        if (this.keepOnMapMaxY(y)) {
            this.move(0, 10)
        }
    }

    def right() : Unit = {
        var x : Int = this.geographicMapInterface.getAllBinaryTiledLayer().getYP() + 10
        if (this.keepOnMapMinX(x)) {
            this.move(10, 0)
        }
    }

    def left() : Unit = {
        var x : Int = -this.geographicMapInterface.getAllBinaryTiledLayer().getYP() - 10
        if (this.keepOnMapMaxX(x)) {
            this.move(-10, 0)
        }
    }

    def initInputProcessors() : Unit = {
        this.inputProcessorArray(Canvas.UP) = new ScrollMapUpGameInputProcessor(this)
        this.inputProcessorArray(Canvas.DOWN) = new ScrollMapDownGameInputProcessor(this)
        this.inputProcessorArray(Canvas.KEY_NUM9) = new ScrollMapRightGameInputProcessor(this)
        this.inputProcessorArray(Canvas.KEY_NUM7) = new ScrollMapLeftGameInputProcessor(this)
        GameInputProcessorUtil.init(this.inputProcessorArray)
    }

    def processInputKey(key : Int) : Unit = {
        this.inputProcessorArray(key).processEvent(AllBinaryGameLayerManager.getNullInstance(), GameKeyEvent.NONE)
    }

    def processInput(layerManager : AllBinaryLayerManager) : Unit = {
        try {
            var size : Int = this.inputList.size()
            var key : Int = 0

            {
                var index : Int = 0
                while (index < size) {
                    var gameKeyEvent : GameKeyEvent = this.inputList.get(index).asInstanceOf[GameKeyEvent]
                    key = gameKeyEvent.getKey()
                    this.processInputKey(key)
                    index += 1
                }
            }
            if (this.isSingleKeyProcessing) {
                this.clear()
            } else {
                this.update()
            }
        } catch {
            case e : Exception => {
                this.logUtil.put(this.commonStrings.EXCEPTION, this, this.gameInputStrings.PROCESS_INPUT, e)
            }
        }
    }

    private def getSpecialHeight() : Int = {
        var terrainTiledLayer : AllBinaryTiledLayer = this.geographicMapInterface.getAllBinaryTiledLayer()
        var displayInfo : DisplayInfoSingleton = DisplayInfoSingleton.getInstance()
        if (terrainTiledLayer.getHeight() > displayInfo.getLastHeight()) {
            return terrainTiledLayer.getHeight() - displayInfo.getLastHeight()
        } else {
            return (displayInfo.getLastHeight() - terrainTiledLayer.getHeight()) + terrainTiledLayer.getCellHeight()
        }
        throw new IllegalStateException()
    }

    private def getSpecialWidth() : Int = {
        var terrainTiledLayer : AllBinaryTiledLayer = this.geographicMapInterface.getAllBinaryTiledLayer()
        var displayInfo : DisplayInfoSingleton = DisplayInfoSingleton.getInstance()
        if (terrainTiledLayer.getWidth() > displayInfo.getLastWidth()) {
            return terrainTiledLayer.getWidth() - displayInfo.getLastWidth()
        } else {
            return (displayInfo.getLastWidth() - terrainTiledLayer.getWidth()) + terrainTiledLayer.getCellWidth()
        }
        throw new IllegalStateException()
    }

    def keepOnMapMaxY(newY : Int) : Boolean = {
        /*         AllBinaryTiledLayer tiledLayer = this.geographicMapInterface.getAllBinaryTiledLayer();                  //int mapBorderBufferHeight = terrainTiledLayer.getCellHeight();          StringMaker stringBuffer = new StringMaker();                  stringBuffer.append("Y Bottom: > ");         stringBuffer.append(this.maxBottom + this.border);          stringBuffer.append(" X: ");         stringBuffer.append(tiledLayer.getXP());         stringBuffer.append(" Y: ");         stringBuffer.append(tiledLayer.getYP());                  //this.logUtil.putF(stringBuffer.toString(), this, "keepOnMapMaxY");         PreLogUtil.put(stringBuffer.toString(), this, "keepOnMapMaxY");         */
        var y : Int = this.geographicMapInterface.getAllBinaryTiledLayer().getYP()
        if (y > (this.maxBottom + this.border)) {
            return false
        } else {
            return true
        }
        throw new IllegalStateException()
    }

    def keepOnMapMinY(newY : Int) : Boolean = {
        /*         AllBinaryTiledLayer tiledLayer = this.geographicMapInterface.getAllBinaryTiledLayer();          //int mapBorderBufferHeight = tiledLayer.getCellHeight();          StringMaker stringBuffer = new StringMaker();          stringBuffer.append("Y Top: < ");                  stringBuffer.append(-this.border);         //stringBuffer.append(mapBorderBufferHeight);                  stringBuffer.append(" X: ");         stringBuffer.append(tiledLayer.getXP());         stringBuffer.append(" Y: ");         stringBuffer.append(tiledLayer.getYP());          //this.logUtil.putF(stringBuffer.toString(), this, "keepOnMapMinY");         PreLogUtil.put(stringBuffer.toString(), this, "keepOnMapMinY");         */
        var y : Int = this.geographicMapInterface.getAllBinaryTiledLayer().getYP()
        if (y < -this.border) {
            return false
        } else {
            return true
        }
        throw new IllegalStateException()
    }

    def keepOnMapMaxX(newX : Int) : Boolean = {
        /*         //int mapBorderBufferWidth = terrainTiledLayer.getCellWidth();          AllBinaryTiledLayer tiledLayer = this.geographicMapInterface.getAllBinaryTiledLayer();          StringMaker stringBuffer = new StringMaker();         stringBuffer.append("X Right: < ");                  stringBuffer.append(-this.maxRight - this.border);          stringBuffer.append(" X: ");         stringBuffer.append(tiledLayer.getXP());         stringBuffer.append(" Y: ");         stringBuffer.append(tiledLayer.getYP());          //this.logUtil.putF(stringBuffer.toString(), this, "keepOnMapMaxX");         PreLogUtil.put(stringBuffer.toString(), this, "keepOnMapMaxX");         */
        var x : Int = this.geographicMapInterface.getAllBinaryTiledLayer().getXP()
        if (x < (-this.maxRight - this.border)) {
            return false
        } else {
            return true
        }
        throw new IllegalStateException()
    }

    def keepOnMapMinX(newX : Int) : Boolean = {
        /*         AllBinaryTiledLayer tiledLayer = this.geographicMapInterface.getAllBinaryTiledLayer();          //int mapBorderBufferWidth = terrainTiledLayer.getCellWidth();          StringMaker stringBuffer = new StringMaker();         stringBuffer.append("X Left: > ");         stringBuffer.append(this.border);         //stringBuffer.append(mapBorderBufferWidth);          stringBuffer.append(" X: ");         stringBuffer.append(tiledLayer.getXP());         stringBuffer.append(" Y: ");         stringBuffer.append(tiledLayer.getYP());          //this.logUtil.putF(stringBuffer.toString(), this, "keepOnMapMinX");         //PreLogUtil.put(stringBuffer.toString(), this, "keepOnMapMinX");         */
        var x : Int = this.geographicMapInterface.getAllBinaryTiledLayer().getXP()
        if (x > this.border) {
            return false
        } else {
            return true
        }
        throw new IllegalStateException()
    }

}


