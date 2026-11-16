/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.game.health

import _root_.javax.microedition.khronos.opengles.GL10
import _root_.javax.microedition.lcdui.Graphics
import _root_.min3d.core.ColorBufferList
import _root_.min3d.core.Number3dBufferList
import _root_.min3d.objectPrimitives.Rectangle
import _root_.min3d.vos.Number3d
import _root_.org.allbinary.device.OpenGLESGraphics
import _root_.org.allbinary.graphics.threed.min3d.renderer.Object3dProcessor
import _root_.org.allbinary.graphics.threed.min3d.renderer.Object3dProcessorUtil
import _root_.org.allbinary.graphics.color.BasicColorFactory
import _root_.org.allbinary.layer.AllBinaryLayer
import _root_.org.allbinary.view.ViewPositionBase

class HealthBarThreedAnimation(param_layerInterface : AllBinaryLayer, param_location : Int) extends HealthBarAnimation(param_layerInterface, param_location) {

    //protected final LogUtil logUtil = LogUtil.getInstance();
    private var rectangle : Rectangle = null

    private val basicColorFactory : BasicColorFactory = BasicColorFactory.getInstance()

    private val object3dProcessor : Object3dProcessor = Object3dProcessorUtil.getInstance().getInstanceObject3dProcessor()

    //Constructor
    {
        val layerInterface : AllBinaryLayer = param_layerInterface
        val location : Int = param_location
        this.basicColor = this.basicColorFactory.GREEN
        this.colorP = this.basicColor.intValue()
        this.rectangle = new Rectangle(0, 0, 1, 1, this.basicColor)
        this.rectangle.setDoubleSidedEnabled(true)
        this.rectangle.setNormalsEnabled(false)
        this.rectangle.setTexturesEnabled(false)
    }

    private def updateColor() : Unit = {
        var colorBufferList : ColorBufferList = this.rectangle.getVertices().getColor4BufferList()
        var size : Int = colorBufferList.size()

        {
            var index : Int = size
            while ({ index -= 1; index } >= 0) {
                colorBufferList.set(index, this.basicColor)
            }
        }
    }

    private def updateSize() : Unit = {
        val number3dBufferList : Number3dBufferList = this.rectangle.getVertices().getPointsOnFacesNumber3dBufferList()
        var width : Int = this.x2
        var height : Int = this.thickness * 2
        var segsH : Int = 1
        var segsW : Int = 1
        var row : Int = 0
        var col : Int = 0
        var w : Float = width / segsW
        var h : Float = height / segsH
        var width5 : Float = width / 2f
        var height5 : Float = height / 2f
        var index : Int = 0

        {
            row = 0
            while (row <= segsH) {

                {
                    col = 0
                    while (col <= segsW) {
                        number3dBufferList.set({ val value_N70866 = index; index += 1; value_N70866 }, (col.toFloat * w) - width5, (row.toFloat * h) - height5, 0f)
                        col += 1
                    }
                }
                row += 1
            }
        }
    }

    override def onHealthChange(newX2 : Int) : Unit = {
        super.onHealthChange(newX2)
        this.updateColor()
        this.updateSize()
    }

    override def paintThreedXYZ(graphics : Graphics, x : Int, y : Int, z : Int) : Unit = {
        val openGLESGraphics : OpenGLESGraphics = graphics.asInstanceOf[OpenGLESGraphics]
        val gl : GL10 = openGLESGraphics.getGl10()
        val viewPosition : ViewPositionBase = this.allbinaryLayer.getViewPosition()
        val positionNumber3d : Number3d = this.rectangle.getPosition()
        //positionNumber3d.y = viewPosition.getZ() + 12;
        positionNumber3d.x = -(viewPosition.getX().toFloat)
        positionNumber3d.z = -(viewPosition.getY().toFloat)
        positionNumber3d.y = viewPosition.getZ() + this.allbinaryLayer.getHeight()
        this.object3dProcessor.drawObject(gl, this.rectangle)
    }

}


