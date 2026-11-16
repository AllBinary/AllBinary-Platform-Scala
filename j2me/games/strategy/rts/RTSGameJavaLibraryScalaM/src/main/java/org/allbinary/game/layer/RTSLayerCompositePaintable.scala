/*  * AllBinary Open License Version 1  * Copyright (c) 2003 AllBinary  *   * By agreeing to this license you and any business entity you represent are  * legally bound to the AllBinary Open License Version 1 legal agreement.  *   * You may obtain the AllBinary Open License Version 1 legal agreement from  * AllBinary or the root directory of AllBinary's AllBinary Platform repository.  *   * Created By: Travis Berthelot  *   */
/* Generated Code Do Not Modify */
package org.allbinary.game.layer

import _root_.javax.microedition.lcdui.Graphics
import _root_.org.allbinary.logic.string.StringUtil
import _root_.org.allbinary.graphics.paint.Paintable
import _root_.org.allbinary.logic.string.StringMaker

class RTSLayerCompositePaintable(param_upgradableRTSLayerHudPaintable : UpgradableRTSLayerHudPaintable) extends Paintable {

    private var upgradeCost : String = StringUtil.getInstance().EMPTY_STRING

    private var downGradeCost : String = StringUtil.getInstance().EMPTY_STRING

    private val UPGRADE : String = "Up: $"

    private val DOWNGRADE : String = "Down: $-"

    var upgradableRTSLayerHudPaintable : UpgradableRTSLayerHudPaintable = null

    //Constructor
    {
        val upgradableRTSLayerHudPaintable : UpgradableRTSLayerHudPaintable = param_upgradableRTSLayerHudPaintable
        this.upgradableRTSLayerHudPaintable = upgradableRTSLayerHudPaintable
    }

    def update(rtsLayer : RTSLayer) : Unit = {
        if (rtsLayer.isUpgradeable()) {
            this.setUpgradeCost(new StringMaker().append(this.UPGRADE).appendint(rtsLayer.getUpgradeCost()).toString())
        } else {
            this.setUpgradeCost(StringUtil.getInstance().EMPTY_STRING)
        }
        if (rtsLayer.isDowngradeable()) {
            this.setDownGradeCost(new StringMaker().append(this.DOWNGRADE).appendint(rtsLayer.getDowngradeCost()).toString())
        } else {
            this.setDownGradeCost(StringUtil.getInstance().EMPTY_STRING)
        }
    }

    override def paint(graphics : Graphics) : Unit = {
        graphics.drawString(this.getDownGradeCost(), this.upgradableRTSLayerHudPaintable.textX, this.upgradableRTSLayerHudPaintable.costY1, 0)
        graphics.drawString(this.getUpgradeCost(), this.upgradableRTSLayerHudPaintable.textX, this.upgradableRTSLayerHudPaintable.costY, 0)
    }

    def setUpgradeCost(upgradeCost : String) : Unit = {
        this.upgradeCost = upgradeCost
    }

    def getUpgradeCost() : String = {
        return this.upgradeCost
    }

    def setDownGradeCost(downGradeCost : String) : Unit = {
        this.downGradeCost = downGradeCost
    }

    def getDownGradeCost() : String = {
        return this.downGradeCost
    }

}


