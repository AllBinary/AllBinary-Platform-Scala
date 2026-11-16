/*  * AllBinary Open License Version 1  * Copyright (c) 2003 AllBinary  *   * By agreeing to this license you and any business entity you represent are  * legally bound to the AllBinary Open License Version 1 legal agreement.  *   * You may obtain the AllBinary Open License Version 1 legal agreement from  * AllBinary or the root directory of AllBinary's AllBinary Platform repository.  *   * Created By: Travis Berthelot  *   */
/* Generated Code Do Not Modify */
package org.allbinary.game.layer.item

import _root_.javax.microedition.lcdui.Font
import _root_.javax.microedition.lcdui.Graphics
import _root_.javax.microedition.lcdui.Image
import _root_.org.allbinary.game.layer.CostLayerInterfaceFactoryInterface
import _root_.org.allbinary.game.rts.technology.event.TechEventListenerInterface
import _root_.org.allbinary.string.CommonStrings
import _root_.org.allbinary.logic.communication.log.ForcedLogUtil
import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.animation.Animation
import _root_.org.allbinary.graphics.font.MyFontProcessor
import _root_.org.allbinary.graphics.font.UpdateMyFontInterface
import _root_.org.allbinary.graphics.font.UpdateMyFontProcessor
import _root_.org.allbinary.logic.NullUtil
import _root_.org.allbinary.logic.util.event.AllBinaryEventObject
import _root_.org.allbinary.logic.math.PrimitiveLongUtil
import _root_.org.allbinary.logic.util.event.EventStrings

class RTSLayerCostAnimation(param_image : Image, param_layerInterfaceFactoryInterface : CostLayerInterfaceFactoryInterface) extends Animation with TechEventListenerInterface with UpdateMyFontInterface {

    val logUtil : LogUtil = LogUtil.getInstance()

    private val primitiveLongUtil : PrimitiveLongUtil = PrimitiveLongUtil.createPowerOfTen(10000)

    private val DOLLAR : String = "$"

    private var image : Image = null

    private var layerInterfaceFactoryInterface : CostLayerInterfaceFactoryInterface = null

    private var myFontProcessor : MyFontProcessor = new UpdateMyFontProcessor(this)

    private var costString : Array[Char] = NullUtil.getInstance().NULL_CHAR_ARRAY

    private var len : Int = 0

    private var adjustedCostX : Int = 0

    private var fontHeight : Int = 0

    //Constructor
    {
        val image : Image = param_image
        val layerInterfaceFactoryInterface : CostLayerInterfaceFactoryInterface = param_layerInterfaceFactoryInterface
        this.image = image
        this.layerInterfaceFactoryInterface = layerInterfaceFactoryInterface
        this.update()
    }

    override def updateMeasurement(graphics : Graphics) : Unit = {
        val font : Font = graphics.getFont()
        this.fontHeight = font.getHeight()
        this.adjustedCostX = font.stringWidth(this.DOLLAR)
        this.myFontProcessor = MyFontProcessor.getInstance()
    }

    override def onEvent(event : AllBinaryEventObject) : Unit = {
        ForcedLogUtil.log(EventStrings.getInstance().PERFORMANCE_MESSAGE, this)
    }

    override def onTechEvent(event : AllBinaryEventObject) : Unit = {
        try {
            this.update()
        } catch {
            case e : Exception => {
                val commonStrings : CommonStrings = CommonStrings.getInstance()
                this.logUtil.put(commonStrings.EXCEPTION, this, "onTechEvent", e)
            }
        }
    }

    def update() : Unit = {
        this.len = 0
        this.costString = this.primitiveLongUtil.getCharArray(this.layerInterfaceFactoryInterface.getCost())
        this.len = this.primitiveLongUtil.getCurrentTotalDigits()
    }

    //-yOffset
    override def paintXY(graphics : Graphics, x : Int, y : Int) : Unit = {
        this.myFontProcessor.process(graphics)
        super.paintXY(graphics, x, y)
        val adjustedCostY : Int = this.image.getHeight() - this.fontHeight
        var xa : Int = x + 2
        graphics.drawString(this.DOLLAR, xa, y + adjustedCostY, 0)
        graphics.drawChars(this.costString, 0, this.len, x + this.adjustedCostX, y + adjustedCostY, 0)
    }

}


