/*  * AllBinary Open License Version 1  * Copyright (c) 2011 AllBinary  *   * By agreeing to this license you and any business entity you represent are  * legally bound to the AllBinary Open License Version 1 legal agreement.  *   * You may obtain the AllBinary Open License Version 1 legal agreement from  * AllBinary or the root directory of AllBinary's AllBinary Platform repository.  *   * Created By: Travis Berthelot  *   */
/* Generated Code Do Not Modify */
package org.allbinary.layer

import _root_.javax.microedition.lcdui.Graphics
import _root_.org.allbinary.game.identification.BasicGroupFactory
import _root_.org.allbinary.game.identification.Group
import _root_.org.allbinary.graphics.GPoint
import _root_.org.allbinary.graphics.Rectangle
import _root_.org.allbinary.graphics.RectangleFactory
import _root_.org.allbinary.graphics.opengles.OpenGLFeatureUtil
import _root_.org.allbinary.TsUtil
import _root_.org.allbinary.logic.string.StringMaker
import _root_.org.allbinary.logic.string.StringUtil
import _root_.org.allbinary.math.PositionStrings
import _root_.org.allbinary.string.CommonLabels
import _root_.org.allbinary.string.CommonSeps
import _root_.org.allbinary.view.ViewPositionBase
import _root_.org.allbinary.view.event.ViewPositionEvent

class AllBinaryLayer(param_name : String, param_rectangle : Rectangle, param_viewPosition : ViewPositionBase) extends Layer(param_rectangle.getWidth(), param_rectangle.getHeight()) with LayerInterface {
    import _root_.org.allbinary.layer.AllBinaryLayer.{NULL_ALLBINARY_LAYER as _, *}
    def NULL_ALLBINARY_LAYER : AllBinaryLayer = _root_.org.allbinary.layer.AllBinaryLayer.NULL_ALLBINARY_LAYER

    val viewPositionEvent : ViewPositionEvent = new ViewPositionEvent(this)

    private var halfWidth : Int = 0

    private var halfHeight : Int = 0

    private var name : String = null

    private var viewPosition : ViewPositionBase = ViewPositionBase.NULL_VIEW_POSITION

    //Constructor
    {
        val name : String = param_name
        val rectangle : Rectangle = param_rectangle
        val viewPosition : ViewPositionBase = param_viewPosition
        var localName : String = null
        //        } else {
        localName = new StringMaker().append(name).append(CommonSeps.getInstance().COLON).append(Integer.toHexString(TsUtil.getInstance().hashCode(this))).toString()
        //        }
        this.name = localName
        val point : GPoint = rectangle.getPoint()
        this.setPosition(point.getX(), point.getY(), point.getZ())
        this.setHalfWidth((this.getWidth() >> 1))
        this.setHalfHeight((this.getHeight() >> 1))
        this.viewPosition = viewPosition
        this.viewPosition.setAllbinaryLayer(this)
    }

    //Needed for polyglot do not remove
    override def setPosition(x : Int, y : Int, z : Int) : Unit = {
        super.setPosition(x, y, z)
    }

    //Needed for polyglot do not remove
    override def moveDXYZ(dx : Int, dy : Int, dz : Int) : Unit = {
        super.moveDXYZ(dx, dy, dz)
    }

    //Needed for polyglot do not remove
    override def getXP() : Int = {
        return super.getXP()
    }

    //Needed for polyglot do not remove
    override def getYP() : Int = {
        return super.getYP()
    }

    //Needed for polyglot do not remove
    override def getZP() : Int = {
        return super.getZP()
    }

    //Needed for polyglot do not remove
    override def getWidth() : Int = {
        return super.getWidth()
    }

    //Needed for polyglot do not remove
    override def getHeight() : Int = {
        return super.getHeight()
    }

    //Needed for polyglot do not remove
    override def setVisible(visible : Boolean) : Unit = {
        super.setVisible(visible)
    }

    //Needed for polyglot do not remove
    override def isVisible() : Boolean = {
        return super.isVisible()
    }

    //Needed for polyglot do not remove
    override def paint(graphics : Graphics) : Unit = {
        super.paint(graphics)
    }

    def onChangeEvent(layerManagerEvent : ViewPositionEvent) : Unit = {
    }

    override def paintThreed(graphics : Graphics) : Unit = {
    }

    override def getX2() : Int = {
        return this.getXP() + this.getWidth()
    }

    override def getY2() : Int = {
        return this.getYP() + this.getHeight()
    }

    override def getZ2() : Int = {
        return (this.getZP() + this.getDepth()).toInt
    }

    override def getName() : String = {
        return this.name
    }

    def setHalfWidth(halfWidth : Int) : Unit = {
        this.halfWidth = halfWidth
    }

    override def getHalfWidth() : Int = {
        return this.halfWidth
    }

    def setHalfHeight(halfHeight : Int) : Unit = {
        this.halfHeight = halfHeight
    }

    override def getHalfHeight() : Int = {
        return this.halfHeight
    }

    def getHalfDepth() : Int = {
        return this.getDepth().toInt / 2
    }

    def getViewPosition() : ViewPositionBase = {
        return this.viewPosition
    }

    def setViewPosition(viewPosition : ViewPositionBase) : Unit = {
        this.viewPosition = viewPosition
    }

    override def getGroupInterface() : Array[Group] = {
        return BasicGroupFactory.getInstance().NONE_ARRAY
    }

    override def implmentsTickableInterface() : Boolean = {
        return false
    }

    override def implmentsGameInputInterface() : Boolean = {
        return false
    }

    override def implmentsArtificialIntelligenceCompositeInterface() : Boolean = {
        return false
    }

    override def implmentsCollidableInterface() : Boolean = {
        return false
    }

    def implementsThreedInterface() : Boolean = {
        return OpenGLFeatureUtil.getInstance().isAnyThreed()
    }

    override def getType() : Int = {
        return -1
    }

    def getMultiPlayerType() : Int = {
        return -1
    }

    override def toStringAppend(stringBuffer : StringMaker) : Unit = {
        val commonSeps : CommonSeps = CommonSeps.getInstance()
        val positionStrings : PositionStrings = PositionStrings.getInstance()
        val commonLabels : CommonLabels = CommonLabels.getInstance()
        stringBuffer.append(this.getName())
        stringBuffer.append(commonSeps.COLON)
        stringBuffer.append(AllBinaryLayer.TYPE)
        stringBuffer.appendint(this.getType())
        stringBuffer.append(commonSeps.SPACE)
        stringBuffer.append(positionStrings.X_LABEL)
        stringBuffer.appendint(this.getXP())
        stringBuffer.append(commonSeps.SPACE)
        stringBuffer.append(positionStrings.Y_LABEL)
        stringBuffer.appendint(this.getYP())
        stringBuffer.append(commonSeps.SPACE)
        stringBuffer.append(positionStrings.Z_LABEL)
        stringBuffer.appendint(this.getZP())
        stringBuffer.append(commonSeps.SPACE)
        stringBuffer.append(commonLabels.WIDTH_LABEL)
        stringBuffer.appendint(this.getWidth())
        stringBuffer.append(commonSeps.SPACE)
        stringBuffer.append(commonLabels.HEIGHT_LABEL)
        stringBuffer.appendint(this.getHeight())
    }

    override def toString() : String = {
        val stringBuffer : StringMaker = new StringMaker()
        this.toStringAppend(stringBuffer)
        return stringBuffer.toString()
    }

}

object AllBinaryLayer {
    val NULL_ALLBINARY_LAYER : AllBinaryLayer = new AllBinaryLayer(StringUtil.getInstance().EMPTY_STRING, RectangleFactory.SINGLETON, ViewPositionBase.NULL_VIEW_POSITION)

    private val TYPE : String = "Type: "

}


