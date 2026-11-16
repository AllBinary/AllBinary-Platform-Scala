/*  * AllBinary Open License Version 1  * Copyright (c) 2002 AllBinary  *   * By agreeing to this license you and any business entity you represent are  * legally bound to the AllBinary Open License Version 1 legal agreement.  *   * You may obtain the AllBinary Open License Version 1 legal agreement from  * AllBinary or the root directory of AllBinary's AllBinary Platform repository.  *   * Created By: Travis Berthelot  *   */
/* Generated Code Do Not Modify */
package org.allbinary.game.layer.capital

import _root_.org.allbinary.game.ag.layer.hud.basic.NumberStringHud

class HudCapital(param_moneyGraphic : NumberStringHud) extends Capital {

    private var capitalGraphic : NumberStringHud = null

    //Constructor
    {
        val moneyGraphic : NumberStringHud = param_moneyGraphic
        this.capitalGraphic = moneyGraphic
    }

    override def removeMoney(points : Int) : Unit = {
        super.removeMoney(points)
        this.capitalGraphic.reduce(points)
    }

    override def getTotalMoney() : Int = {
        return this.capitalGraphic.get()
    }

    override def addMoney(points : Int) : Unit = {
        super.addMoney(points)
        this.capitalGraphic.add(points)
    }

}


