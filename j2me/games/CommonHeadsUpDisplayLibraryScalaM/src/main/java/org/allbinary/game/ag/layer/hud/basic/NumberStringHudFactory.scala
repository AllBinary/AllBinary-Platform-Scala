/*  * AllBinary Open License Version 1  * Copyright (c) 2025 AllBinary  *   * By agreeing to this license you and any business entity you represent are  * legally bound to the AllBinary Open License Version 1 legal agreement.  *   * You may obtain the AllBinary Open License Version 1 legal agreement from  * AllBinary or the root directory of AllBinary's AllBinary Platform repository.  *   * Created By: Travis Berthelot  *   */
/* Generated Code Do Not Modify */
package org.allbinary.game.ag.layer.hud.basic

import _root_.org.allbinary.game.graphics.hud.BasicHudFactory
import _root_.org.allbinary.graphics.color.BasicColorFactory
import _root_.org.allbinary.logic.NullUtil
import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.logic.string.StringUtil
import _root_.org.allbinary.string.CommonStrings

/**  *  * @author User  */
class NumberStringHudFactory {
    import _root_.org.allbinary.game.ag.layer.hud.basic.NumberStringHudFactory.{*}

    val NULL_NUMBER_STRING_HUD : NumberStringHud = this.createHud()

    def createHud() : NumberStringHud = {
        try {
            return new NumberStringHud(StringUtil.getInstance().EMPTY_STRING, 9, BasicHudFactory.getInstance().ABSOLUTE, 1, 0, BasicColorFactory.getInstance().NULL_COLOR)
        } catch {
            case e : Exception => {
                val logUtil : LogUtil = LogUtil.getInstance()
                val commonStrings : CommonStrings = CommonStrings.getInstance()
                logUtil.put(commonStrings.EXCEPTION, this, commonStrings.CONSTRUCTOR, e)
                throw new RuntimeException()
            }
        }
        throw new IllegalStateException()
    }

}

object NumberStringHudFactory {
    private var instance : Object = NullUtil.getInstance()

    def getInstance() : NumberStringHudFactory = {
        if (NumberStringHudFactory.instance eq NullUtil.getInstance()) {
            NumberStringHudFactory.instance = new NumberStringHudFactory()
        }
        return NumberStringHudFactory.instance.asInstanceOf[NumberStringHudFactory]
    }

}


