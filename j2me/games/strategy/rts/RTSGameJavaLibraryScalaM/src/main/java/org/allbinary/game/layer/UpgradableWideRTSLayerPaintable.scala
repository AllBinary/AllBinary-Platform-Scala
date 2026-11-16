/*  * AllBinary Open License Version 1  * Copyright (c) 2003 AllBinary  *   * By agreeing to this license you and any business entity you represent are  * legally bound to the AllBinary Open License Version 1 legal agreement.  *   * You may obtain the AllBinary Open License Version 1 legal agreement from  * AllBinary or the root directory of AllBinary's AllBinary Platform repository.  *   * Created By: Travis Berthelot  *   */
/* Generated Code Do Not Modify */
package org.allbinary.game.layer

import _root_.javax.microedition.lcdui.Graphics
import _root_.org.allbinary.string.CommonSeps
import _root_.org.allbinary.logic.string.StringMaker
import _root_.org.allbinary.logic.string.StringUtil

class UpgradableWideRTSLayerPaintable(param_upgradableRTSLayerHudPaintable : UpgradableRTSLayerHudPaintable) extends RTSLayerCompositePaintable(param_upgradableRTSLayerHudPaintable) {

    private var cost : String = StringUtil.getInstance().EMPTY_STRING

    //Constructor
    {
        val upgradableRTSLayerHudPaintable : UpgradableRTSLayerHudPaintable = param_upgradableRTSLayerHudPaintable
    }

    override def update(rtsLayer : RTSLayer) : Unit = {
        super.update(rtsLayer)
        this.setCost(new StringMaker().append(this.getUpgradeCost()).append(CommonSeps.getInstance().SPACE).append(this.getDownGradeCost()).toString())
    }

    override def paint(graphics : Graphics) : Unit = {
        graphics.drawString(this.getCost(), this.upgradableRTSLayerHudPaintable.textX, this.upgradableRTSLayerHudPaintable.costY, 0)
    }

    def setCost(cost : String) : Unit = {
        this.cost = cost
    }

    def getCost() : String = {
        return this.cost
    }

}


