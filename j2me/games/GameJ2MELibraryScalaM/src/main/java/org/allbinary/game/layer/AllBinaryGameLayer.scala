/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.game.layer

import _root_.javax.microedition.khronos.opengles.GL
import _root_.javax.microedition.lcdui.Graphics
import _root_.org.allbinary.graphics.Rectangle
import _root_.org.allbinary.graphics.color.BasicColor
import _root_.org.allbinary.graphics.color.BasicColorFactory
import _root_.org.allbinary.graphics.color.BasicColorSetUtil
import _root_.org.allbinary.graphics.paint.NullPaintable
import _root_.org.allbinary.graphics.paint.Paintable
import _root_.org.allbinary.image.opengles.OpenGLSurfaceChangedInterface
import _root_.org.allbinary.layer.AllBinaryLayer
import _root_.org.allbinary.layer.AllBinaryLayerManager
import _root_.org.allbinary.logic.communication.log.ForcedLogUtil
import _root_.org.allbinary.logic.util.event.AllBinaryEventObject
import _root_.org.allbinary.logic.util.event.EventStrings
import _root_.org.allbinary.string.CommonStrings
import _root_.org.allbinary.util.BasicArrayList
import _root_.org.allbinary.util.BasicArrayListD
import _root_.org.allbinary.view.ViewPositionBase
import _root_.org.allbinary.view.event.ViewPositionEvent
import _root_.org.allbinary.view.event.ViewPositionEventListenerInterface

class AllBinaryGameLayer(param_name : String, param_layerInfo : Rectangle, param_viewPosition : ViewPositionBase) extends AllBinaryLayer(param_name, param_layerInfo, param_viewPosition) with ViewPositionEventListenerInterface with OpenGLSurfaceChangedInterface {
    import _root_.org.allbinary.game.layer.AllBinaryGameLayer.{*}

    //protected final LogUtil logUtil = LogUtil.getInstance();
    val commonStrings : CommonStrings = CommonStrings.getInstance()

    val basicSetColorUtil : BasicColorSetUtil = BasicColorSetUtil.getInstance()

    val RED : BasicColor = BasicColorFactory.getInstance().RED

    private val paintable : Paintable = createPaintable()

    private val gameKeyEventList : BasicArrayList = new BasicArrayListD()

    //Constructor
    {
        val name : String = param_name
        val layerInfo : Rectangle = param_layerInfo
        val viewPosition : ViewPositionBase = param_viewPosition
    }

    override def set(gl : GL) : Unit = {
        //OpenGLSurfaceChangedInterface
        throw new Exception(this.commonStrings.NOT_IMPLEMENTED)
    }

    def move() : Unit = {
    }

    def getGameKeyEventList() : BasicArrayList = {
        return this.gameKeyEventList
    }

    def processInput(allBinaryLayerManager : AllBinaryLayerManager) : Unit = {
        throw new Exception(this.commonStrings.NOT_IMPLEMENTED)
    }

    def processTick(allBinaryLayerManager : AllBinaryLayerManager) : Unit = {
        throw new Exception(this.commonStrings.NOT_IMPLEMENTED)
    }

    override def onEvent(eventObject : AllBinaryEventObject) : Unit = {
        ForcedLogUtil.log(EventStrings.getInstance().PERFORMANCE_MESSAGE, this)
    }

    def onViewPositionChangeEvent() : Unit = {
        this.onChangeEvent(this.viewPositionEvent)
    }

    override def onChangeEvent(layerManagerEvent : ViewPositionEvent) : Unit = {
        //this.logUtil.putF(this.commonStrings.START, this, "onChangeEvent");
        if (GameLayerUtil.isOnScreen(this)) {
            this.setVisible(true)
        } else {
            this.setVisible(false)
        }
    }

    def paintFirst(graphics : Graphics) : Unit = {
        this.paintable.paint(graphics)
    }

    //Should be overridden
    def paintDebug(graphics : Graphics) : Unit = {
        //this.logUtil.putF(this.commonStrings.NOT_IMPLEMENTED, this, canvasStrings.PAINT);
        val viewPosition : ViewPositionBase = this.getViewPosition()
        val viewX : Int = viewPosition.getX()
        val viewY : Int = viewPosition.getY()
        //this.logUtil.putF("viewX: ").append(viewX).append(" viewY: ").append(viewY, this, canvasStrings.PAINT);
        this.basicSetColorUtil.setBasicColorP(graphics, this.RED)
        graphics.drawRect(viewX, viewY, this.getWidth(), this.getHeight())
    }

    def setWidth(width : Int) : Unit = {
        super.setLayerWidth(width)
        this.setHalfWidth(width >> 1)
    }

    def setHeight(height : Int) : Unit = {
        super.setLayerHeight(height)
        this.setHalfHeight(height >> 1)
    }

}

object AllBinaryGameLayer {
    private def createPaintable() : Paintable = {
        if (SWTUtil.isSWT) {
            return new SWTBlackPaintable()
        }
        return NullPaintable.getInstance()
    }

}


