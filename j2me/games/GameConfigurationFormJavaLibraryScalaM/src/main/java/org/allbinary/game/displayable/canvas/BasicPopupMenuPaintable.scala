/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.game.displayable.canvas

import _root_.javax.microedition.lcdui.Font
import _root_.javax.microedition.lcdui.Graphics
import _root_.org.allbinary.AndroidUtil
import _root_.org.allbinary.J2MEUtil
import _root_.org.allbinary.animation.Animation
import _root_.org.allbinary.animation.NullAnimationFactory
import _root_.org.allbinary.animation.vector.RectangleFilledAnimation
import _root_.org.allbinary.game.configuration.feature.Features
import _root_.org.allbinary.game.layer.SWTUtil
import _root_.org.allbinary.graphics.GPoint
import _root_.org.allbinary.graphics.Rectangle
import _root_.org.allbinary.graphics.color.BasicColor
import _root_.org.allbinary.graphics.color.BasicColorFactory
import _root_.org.allbinary.graphics.color.BasicColorSetUtil
import _root_.org.allbinary.graphics.draw.DrawVerticalStringUtil
import _root_.org.allbinary.graphics.font.MyFontProcessor
import _root_.org.allbinary.graphics.font.UpdateMyFontInterface
import _root_.org.allbinary.graphics.font.UpdateMyFontProcessor
import _root_.org.allbinary.graphics.opengles.OpenGLFeatureFactory
import _root_.org.allbinary.graphics.opengles.OpenGLFeatureUtil
import _root_.org.allbinary.graphics.paint.Paintable
import _root_.org.allbinary.graphics.threed.SWTJOGLProcessor

/**  *  * @author user  */
class BasicPopupMenuPaintable(param_rectangle : Rectangle, param_backgroundBasicColor : BasicColor, param_foregroundBasicColor : BasicColor) extends Paintable with UpdateMyFontInterface {
    import _root_.org.allbinary.game.displayable.canvas.BasicPopupMenuPaintable.{*}

    val basicSetColorUtil : BasicColorSetUtil = BasicColorSetUtil.getInstance()

    private val drawStringUtil : DrawVerticalStringUtil = DrawVerticalStringUtil.getInstance()

    private var label : String = null

    private var foregroundBasicColor : BasicColor = null

    private var myFontProcessor : MyFontProcessor = new UpdateMyFontProcessor(this)

    private var rectangle : Rectangle = null

    private var BORDER : Int = 0

    private var heightOffset : Int = 0

    private var offset : Int = 0

    private var animationInterface : Animation = null

    //Constructor
    {
        val rectangle : Rectangle = param_rectangle
        val backgroundBasicColor : BasicColor = param_backgroundBasicColor
        val foregroundBasicColor : BasicColor = param_foregroundBasicColor
        this.foregroundBasicColor = foregroundBasicColor
        /*         if(AppletUtil.isAppletLoader(this))         {             this.label = BasicPopupMenuPaintable.NAME + " Esc";         }         else         {             this.label = BasicPopupMenuPaintable.NAME + " *";         }  */
        this.label = BasicPopupMenuPaintable.NAME
        this.rectangle = rectangle
        if (J2MEUtil.isJ2ME() || J2MEUtil.isHTML()) {
            //this.animationInterface = new AllBinaryImageAnimation(image);
            this.animationInterface = NullAnimationFactory.getFactoryInstance().getInstance(0)
        } else {
            this.animationInterface = new RectangleFilledAnimation(this.rectangle.getWidth(), this.rectangle.getHeight(), BasicColorFactory.getInstance().TRANSPARENT_GREY)
        }
        this.init(rectangle)
    }

    override def updateMeasurement(graphics : Graphics) : Unit = {
        val font : Font = graphics.getFont()
        val features : Features = Features.getInstance()
        val isOpenGL : Boolean = features.isDefault(OpenGLFeatureFactory.getInstance().OPENGL)
        this.drawStringUtil.updateMeasurement(graphics, this.label)
        var BORDER : Int = 0
        //AndroidUtil.isAndroid() && 
        if (J2MEUtil.isHTML() || isOpenGL) {
            BORDER = MyFontProcessor.defaultCharWidth(font) / 2
        } else if ((AndroidUtil.isAndroid() || J2MEUtil.isJ2SE()) || SWTUtil.isSWT) {
            BORDER = MyFontProcessor.defaultCharWidth(font)
        } else {
            BORDER = MyFontProcessor.defaultCharWidth(font) * 2
        }
        this.BORDER = BORDER
        this.heightOffset = this.rectangle.getHeight() - (font.getHeight() * BasicPopupMenuPaintable.NAME.length())
        if (OpenGLFeatureUtil.getInstance().isAnyThreed()) {
            this.heightOffset -= font.getHeight() + 2
            if (AndroidUtil.isAndroid()) {
                this.heightOffset = font.getHeight()
            } else {
                this.heightOffset -= font.getHeight() + 2
            }
        }
        this.offset = (this.heightOffset >> 1) + ((if (SWTJOGLProcessor.getInstance().isJOGL()) 4 else 0))
        this.myFontProcessor = MyFontProcessor.getInstance()
    }

    def init(rectangle : Rectangle) : Unit = {
        this.rectangle = rectangle
        val width : Int = this.rectangle.getWidth()
        val height : Int = this.rectangle.getHeight()
        if (J2MEUtil.isJ2ME() || J2MEUtil.isHTML()) {
        } else {
            val rectangleFilledAnimation : RectangleFilledAnimation = this.animationInterface.asInstanceOf[RectangleFilledAnimation]
            rectangleFilledAnimation.setWidth(width)
            rectangleFilledAnimation.setHeight(height)
        }
    }

    override def paint(graphics : Graphics) : Unit = {
        this.myFontProcessor.process(graphics)
        val point : GPoint = this.rectangle.getPoint()
        val x : Int = point.getX()
        val y : Int = point.getY()
        val width : Int = this.rectangle.getWidth()
        val height : Int = this.rectangle.getHeight()
        this.animationInterface.paintXY(graphics, x, y)
        this.basicSetColorUtil.setBasicColorP(graphics, this.foregroundBasicColor)
        this.drawStringUtil.paintVerticle(graphics, this.label, x + this.BORDER, y + this.offset, 0)
        graphics.drawRect(x, y, width, height)
    }

}

object BasicPopupMenuPaintable {
    private val NAME : String = "MENU"

}


