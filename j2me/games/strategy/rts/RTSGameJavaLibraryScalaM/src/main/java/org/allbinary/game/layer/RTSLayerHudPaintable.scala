/*  * AllBinary Open License Version 1  * Copyright (c) 2003 AllBinary  *   * By agreeing to this license you and any business entity you represent are  * legally bound to the AllBinary Open License Version 1 legal agreement.  *   * You may obtain the AllBinary Open License Version 1 legal agreement from  * AllBinary or the root directory of AllBinary's AllBinary Platform repository.  *   * Created By: Travis Berthelot  *   */
/* Generated Code Do Not Modify */
package org.allbinary.game.layer

import _root_.javax.microedition.lcdui.Font
import _root_.javax.microedition.lcdui.Graphics
import _root_.org.allbinary.logic.string.StringUtil
import _root_.org.allbinary.AndroidUtil
import _root_.org.allbinary.game.layer.special.CollidableDestroyableDamageableLayer
import _root_.org.allbinary.game.part.weapon.BasicWeaponPart
import _root_.org.allbinary.graphics.font.UpdateMyFontInterface

/**  *  * @author user  */
class RTSLayerHudPaintable private() extends SelectionHudPaintable with UpdateMyFontInterface {
    import _root_.org.allbinary.game.layer.RTSLayerHudPaintable.{*}

    private var weaponProperties : Array[String] = StringUtil.getInstance().getArrayInstance()

    private var rtsLayer : CollidableDestroyableDamageableLayer = CollidableDestroyableDamageableLayer.getNullInstance()

    var costY : Int = 0

    var costY1 : Int = 0

    private var fontHeight : Int = 0

    override def updateMeasurement(graphics : Graphics) : Unit = {
        super.updateMeasurement(graphics)
        val font : Font = graphics.getFont()
        this.fontHeight = font.getHeight()
        this.costY1 = (this.y + ((this.weaponProperties.length + 1) * this.fontHeight))
        if (!AndroidUtil.isAndroid()) {
            this.costY = this.costY1
        } else {
            this.costY = (this.y + ((this.weaponProperties.length + 2) * this.fontHeight))
        }
    }

    override def updateSelectionInfo() : Unit = {
        this.setName(this.getRtsLayer().getName())
        val partInterface : BasicWeaponPart = this.getRtsLayer().getPartInterfaceArray()(0).asInstanceOf[BasicWeaponPart]
        this.weaponProperties = partInterface.getWeaponProperties().toStringArray()
        this.myFontProcessor = this.updateMyFontProcessor
    }

    override def paint(graphics : Graphics) : Unit = {
        super.paint(graphics)
        val size : Int = this.weaponProperties.length

        {
            var index : Int = 0
            while (index < size) {
                graphics.drawString(this.weaponProperties(index), this.textX, this.y + ((index + 1) * this.fontHeight), 0)
                index += 1
            }
        }
    }

    def setRtsLayer(rtsLayer : RTSLayer) : Unit = {
        this.rtsLayer = rtsLayer
    }

    private def getRtsLayer() : CollidableDestroyableDamageableLayer = {
        return this.rtsLayer
    }

}

object RTSLayerHudPaintable {
    private val instance : RTSLayerHudPaintable = new RTSLayerHudPaintable()

    def getInstance() : RTSLayerHudPaintable = {
        return RTSLayerHudPaintable.instance
    }

}


