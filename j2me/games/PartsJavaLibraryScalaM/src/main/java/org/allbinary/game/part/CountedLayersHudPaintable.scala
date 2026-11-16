/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *   */
/* Generated Code Do Not Modify */
package org.allbinary.game.part

import _root_.javax.microedition.lcdui.Font
import _root_.javax.microedition.lcdui.Graphics
import _root_.org.allbinary.game.layer.pickup.PickedUpLayerInterfaceFactoryInterface
import _root_.org.allbinary.graphics.displayable.DisplayInfoSingleton
import _root_.org.allbinary.graphics.font.MyFontProcessor
import _root_.org.allbinary.graphics.font.UpdateMyFontInterface
import _root_.org.allbinary.graphics.font.UpdateMyFontProcessor
import _root_.org.allbinary.graphics.paint.PaintableInterface
import _root_.org.allbinary.layer.AllBinaryLayer

/**  *  * @author user  */
class CountedLayersHudPaintable(param_partInterfaceArray : Array[PartInterface], param_dropSize : Int, param_startIndex : Int, param_countedTotalStringColor : Int, param_countedPartsBorder : Int) extends PaintableInterface with UpdateMyFontInterface {
    import _root_.org.allbinary.game.part.CountedLayersHudPaintable.{*}

    private val displayInfoSingleton : DisplayInfoSingleton = DisplayInfoSingleton.getInstance()

    private var partInterfaceArray : Array[PartInterface] = null

    private var countedTotalStringColor : Int = 0

    private var countedPartsBorder : Int = 0

    private var startIndex : Int = 0

    private var dropSize : Int = 0

    private var myFontProcessor : MyFontProcessor = new UpdateMyFontProcessor(this)

    private var height : Int = 0

    //Constructor
    {
        val partInterfaceArray : Array[PartInterface] = param_partInterfaceArray
        val dropSize : Int = param_dropSize
        val startIndex : Int = param_startIndex
        val countedTotalStringColor : Int = param_countedTotalStringColor
        val countedPartsBorder : Int = param_countedPartsBorder
        this.partInterfaceArray = partInterfaceArray
        this.startIndex = startIndex
        this.countedTotalStringColor = countedTotalStringColor
        this.countedPartsBorder = countedPartsBorder
        this.dropSize = dropSize
    }

    override def updateMeasurement(graphics : Graphics) : Unit = {
        val font : Font = graphics.getFont()
        this.height = font.getHeight()
        if (this.dropSize > font.getHeight()) {
            this.height = this.dropSize
        }
        if (CountedLayersHudPaintable.XXStringWidth == 0) {
            val XXString : String = "XX"
            CountedLayersHudPaintable.XXStringWidth = font.stringWidth(XXString)
        }
        this.myFontProcessor = MyFontProcessor.getInstance()
    }

    override def paint(graphics : Graphics) : Unit = {
        this.myFontProcessor.process(graphics)
        val lastWidth : Int = this.displayInfoSingleton.getLastWidth()
        val widthEdge : Int = lastWidth - this.dropSize
        val size : Int = this.partInterfaceArray.length
        var count : Int = 0
        var y : Int = 0
        var countedLayerInterfaceFactory : CountedLayerInterfaceFactoryPart = null
        var pickedUpLayerInterfaceFactoryInterface : PickedUpLayerInterfaceFactoryInterface = null
        var layerInterface : AllBinaryLayer = null
        var charArray : Array[Char] = null

        {
            var index : Int = this.startIndex
            while (index < size) {
                countedLayerInterfaceFactory = this.partInterfaceArray(index).asInstanceOf[CountedLayerInterfaceFactoryPart]
                if (countedLayerInterfaceFactory.getTotal() > 0) {
                    pickedUpLayerInterfaceFactoryInterface = countedLayerInterfaceFactory.getCountedPickedUpLayerInterfaceFactory()
                    layerInterface = pickedUpLayerInterfaceFactoryInterface.getIconLayer()
                    y = 40 + (count * this.height)
                    layerInterface.setPosition(widthEdge, y, layerInterface.getZP())
                    layerInterface.paint(graphics)
                    graphics.setColor(this.countedTotalStringColor)
                    countedLayerInterfaceFactory.paint(graphics)
                    //graphics.drawString(countedLayerInterfaceFactory.getTotalString(),
                    charArray = countedLayerInterfaceFactory.getTotalString()
                    graphics.drawChars(charArray, 0, charArray.length, widthEdge - countedLayerInterfaceFactory.getXOffset(), y, 0)
                    count += 1
                }
                index += 1
            }
        }
        if (count > 0) {
            graphics.setColor(this.countedPartsBorder)
            graphics.drawRect(lastWidth - (CountedLayersHudPaintable.XXStringWidth + this.dropSize), 40, CountedLayersHudPaintable.XXStringWidth + this.dropSize, (count * this.height) + 3)
        }
    }

    override def paintThreed(graphics : Graphics) : Unit = {
    }

}

object CountedLayersHudPaintable {
    private var XXStringWidth : Int = 0

}


