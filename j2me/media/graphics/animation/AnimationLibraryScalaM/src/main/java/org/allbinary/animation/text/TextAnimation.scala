/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.animation.text

import _root_.javax.microedition.lcdui.Font
import _root_.javax.microedition.lcdui.Graphics
import _root_.org.allbinary.animation.AnimationBehavior
import _root_.org.allbinary.animation.IndexedAnimation
import _root_.org.allbinary.graphics.Anchor
import _root_.org.allbinary.graphics.font.MyFontProcessor
import _root_.org.allbinary.graphics.font.UpdateMyFontInterface
import _root_.org.allbinary.graphics.font.UpdateMyFontProcessor
import _root_.org.allbinary.graphics.threed.SWTJOGLProcessor
import _root_.org.allbinary.logic.string.StringMaker
import _root_.org.allbinary.logic.string.StringUtil
import _root_.org.allbinary.util.BasicArrayList
import _root_.org.allbinary.util.BasicArrayListD

class TextAnimation(param_text : String, param_animationBehavior : AnimationBehavior) extends IndexedAnimation(param_animationBehavior) with UpdateMyFontInterface {

    //private final int HEIGHT = 8;
    private val updateMyFontProcessor : MyFontProcessor = new UpdateMyFontProcessor(this)

    var myFontProcessor : MyFontProcessor = this.updateMyFontProcessor

    var textArrayP : Array[String] = StringUtil.getInstance().ONE_EMPTY_STRING_ARRAY

    private var anchor : Int = Anchor.TOP_LEFT

    private var fontHeight : Int = 0

    private var offsetY : Int = 0

    private var textChangeListener : TextChangeListener = TextChangeListener.getInstance()

    //Constructor
    {
        val text : String = param_text
        val animationBehavior : AnimationBehavior = param_animationBehavior
        //this.textArray[0] = text;
        this.setText(text)
    }

    override def updateMeasurement(graphics : Graphics) : Unit = {
        val font : Font = graphics.getFont()
        this.fontHeight = font.getHeight()
        val adjustedFontHeight : Int = (-(this.fontHeight * 2.00)).toInt
        this.offsetY = (if (SWTJOGLProcessor.getInstance().isJOGL()) adjustedFontHeight else 0)
        this.textChangeListener.onMeasure()
        this.textChangeListener = TextChangeListener.getInstance()
        this.myFontProcessor = MyFontProcessor.getInstance()
    }

    override def nextFrame() : Unit = {
    }

    override def paintXY(graphics : Graphics, x : Int, y : Int) : Unit = {
        this.myFontProcessor.process(graphics)
        this.paintXYNoUpdate(graphics, x, y)
    }

    def paintXYNoUpdate(graphics : Graphics, x : Int, y : Int) : Unit = {
        this.basicSetColorUtil.setBasicColorP3(graphics, this.getBasicColorP(), this.getColor())
        val size : Int = this.textArrayP.length

        {
            var index : Int = 0
            while (index < size) {
                //this.logUtil.putF(new StringMaker().append(textArray[index]).append(CommonSeps.getInstance().SPACE).append(x).append(CommonSeps.getInstance().SPACE).append(y).toString(), this, this.commonStrings.PROCESS);
                graphics.drawString(this.textArrayP(index), x, (y + this.offsetY) + (index * this.fontHeight), this.anchor)
                index += 1
            }
        }
    }

    def setTextWithOnMeasure(text : String, textChangeListener : TextChangeListener) : Unit = {
        this.setText(text)
        this.textChangeListener = textChangeListener
    }

    def setText(text : String) : Unit = {
        val list : BasicArrayList = new BasicArrayListD()
        //this.logUtil.putF(new StringMaker().append(" text: ").append(text).toString(), this, this.commonStrings.PROCESS);        
        if (text.length() > 0) {
            var index : Int = 0
            var startIndex : Int = 0
            var endIndex : Int = 0

            {
                scala.util.boundary { (break_N70294 : scala.util.boundary.Label[Unit]) ?=>
                    while (index >= 0) {
                        startIndex = index
                        index = text.indexOf('\n', startIndex)
                        endIndex = index
                        if (index < 0) {
                            endIndex = text.length()
                        }
                        //this.logUtil.putF(new StringMaker().append("startIndex: ").append(startIndex).append(" endIndex: ").append(endIndex).toString(), this, this.commonStrings.PROCESS);
                        list.add(text.substring(startIndex, endIndex))
                        if (index < 0) {
                            scala.util.boundary.break()(using break_N70294)
                        }
                        index += 1
                    }
                }
            }
        }
        if (list.size() > 0) {
            val textArray : Array[String] = new Array[String](list.size())
            val size : Int = list.size()

            {
                var index : Int = 0
                while (index < size) {
                    textArray(index) = list.get(index).asInstanceOf[String]
                    index += 1
                }
            }
            this.textArrayP = textArray
        } else {
            this.textArrayP = StringUtil.getInstance().ONE_EMPTY_STRING_ARRAY
        }
        this.myFontProcessor = this.updateMyFontProcessor
    }

    def getTextArray() : Array[String] = {
        return this.textArrayP
    }

    def getFontHeight() : Int = {
        return this.fontHeight
    }

}


