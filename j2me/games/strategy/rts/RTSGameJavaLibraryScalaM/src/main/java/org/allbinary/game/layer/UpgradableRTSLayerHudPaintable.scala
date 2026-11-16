/*  * AllBinary Open License Version 1  * Copyright (c) 2003 AllBinary  *   * By agreeing to this license you and any business entity you represent are  * legally bound to the AllBinary Open License Version 1 legal agreement.  *   * You may obtain the AllBinary Open License Version 1 legal agreement from  * AllBinary or the root directory of AllBinary's AllBinary Platform repository.  *   * Created By: Travis Berthelot  *   */
/* Generated Code Do Not Modify */
package org.allbinary.game.layer

import _root_.javax.microedition.lcdui.Font
import _root_.javax.microedition.lcdui.Graphics
import _root_.org.allbinary.game.layer.special.CollidableDestroyableDamageableLayer
import _root_.org.allbinary.logic.java.character.CharArrayFactory
import _root_.org.allbinary.graphics.displayable.DisplayInfoSingleton
import _root_.org.allbinary.graphics.font.MyFontProcessor
import _root_.org.allbinary.input.motion.button.CommonButtons

class UpgradableRTSLayerHudPaintable private() extends SelectionHudPaintable {
    import _root_.org.allbinary.game.layer.UpgradableRTSLayerHudPaintable.{*}

    //private final String PERCENT_COMPLETE = "% Complete";
    private val PERCENT : String = "%"

    private var rtsLayer : CollidableDestroyableDamageableLayer = CollidableDestroyableDamageableLayer.getNullInstance()

    var costY : Int = 0

    var costY1 : Int = 0

    private var percentCompleteX2 : Int = 0

    private var rtsLayerCompositePaintableLateInit : RTSLayerCompositePaintable = null

    private var charHeight : Int = 0

    private var charWidth : Int = 0

    private var percentComplete : Int = 0

    private var percentCompleteX : Int = 0

    //private String percentComplete = StringUtil.getInstance();
    private var percentCompleteArray : Array[Char] = CharArrayFactory.getInstance().getZeroCharArray()

    private var currentTotalDigits : Int = 0

    override def updateMeasurement(graphics : Graphics) : Unit = {
        super.updateMeasurement(graphics)
        val font : Font = graphics.getFont()
        this.charHeight = font.getHeight()
        this.charWidth = MyFontProcessor.defaultCharWidth(font)
    }

    override def update() : Unit = {
        super.update()
        val commonButtons : CommonButtons = CommonButtons.getInstance()
        this.costY = (this.y + commonButtons.STANDARD_BUTTON_SIZE)
        this.costY1 = ((this.y + commonButtons.STANDARD_BUTTON_SIZE) - this.charHeight)
        /*          * probably not needed anymore         if(!AndroidUtil.isAndroid())         {             this.costY1 = this.costY;         } else         {             this.costY1 = (this.y + TouchButtonInput.STANDARD_BUTTON_SIZE - (charHeight));         }         */
        this.percentCompleteX2 = (this.imageX + commonButtons.STANDARD_BUTTON_SIZE) - this.charWidth
        val displayInfoSingleton : DisplayInfoSingleton = DisplayInfoSingleton.getInstance()
        //!AndroidUtil.isAndroid()
        if (displayInfoSingleton.getLastWidth() > 320) {
            this.rtsLayerCompositePaintableLateInit = new UpgradableWideRTSLayerPaintable(this)
        } else {
            this.rtsLayerCompositePaintableLateInit = new RTSLayerCompositePaintable(this)
        }
    }

    override def updateSelectionInfo() : Unit = {
        val rtsLayer : RTSLayer = this.getRtsLayer().asInstanceOf[RTSLayer]
        this.rtsLayerCompositePaintableLateInit.update(rtsLayer)
        this.setAnimationInterface(rtsLayer.getVerticleBuildAnimationInterface())
        this.setName(rtsLayer.getName())
    }

    override def updateInfo() : Unit = {
        val rtsLayer : RTSLayer = this.getRtsLayer().asInstanceOf[RTSLayer]
        this.percentComplete = rtsLayer.getPercentComplete()
        if (this.percentComplete < 10) {
            this.percentCompleteX = 32
        } else if (this.percentComplete < 100) {
            this.percentCompleteX = 24
        } else {
            this.percentCompleteX = 16
        }
        this.percentCompleteArray = this.getPrimitiveLongUtil().getCharArray(this.percentComplete)
        //this.primitiveLongUtil.getString(pc);
        this.currentTotalDigits = this.getPrimitiveLongUtil().getCurrentTotalDigits()
    }

    override def paint(graphics : Graphics) : Unit = {
        super.paint(graphics)
        this.rtsLayerCompositePaintableLateInit.paint(graphics)
        graphics.drawChars(this.percentCompleteArray, 0, this.currentTotalDigits, this.imageX + this.percentCompleteX, this.costY, 0)
        //(myFont.DEFAULT_CHAR_WIDTH * 4)
        graphics.drawString(this.PERCENT, this.percentCompleteX2, this.costY, 0)
        // myFont.DEFAULT_CHAR_HEIGHT), 0);
        this.getAnimationInterface().paintXY(graphics, this.imageX, this.y)
    }

    def setRtsLayer(rtsLayer : RTSLayer) : Unit = {
        this.rtsLayer = rtsLayer
    }

    def getRtsLayer() : CollidableDestroyableDamageableLayer = {
        return this.rtsLayer
    }

}

object UpgradableRTSLayerHudPaintable {
    private val instance : UpgradableRTSLayerHudPaintable = new UpgradableRTSLayerHudPaintable()

    def getInstance() : UpgradableRTSLayerHudPaintable = {
        return UpgradableRTSLayerHudPaintable.instance
    }

}


