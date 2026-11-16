/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.game.configuration

import _root_.javax.microedition.lcdui.CommandListener
import _root_.org.allbinary.graphics.color.BasicColor
import _root_.org.allbinary.graphics.displayable.screen.CommandForm
import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.string.CommonStrings

class GameOptionsFormFactory private() {
    import _root_.org.allbinary.game.configuration.GameOptionsFormFactory.{*}

    val logUtil : LogUtil = LogUtil.getInstance()

    def init(commandListener : CommandListener, title : String, backgrounBasicColor : BasicColor, foregroundBasicColor : BasicColor) : CommandForm = {
        try {
            //}
            return new GameOptionsForm(commandListener, title, backgrounBasicColor, foregroundBasicColor)
        } catch {
            case e : Exception => {
                val commonStrings : CommonStrings = CommonStrings.getInstance()
                this.logUtil.put(commonStrings.EXCEPTION, this, commonStrings.INIT, e)
                return CommandForm.getNullCommandForm()
            }
        }
        throw new IllegalStateException()
    }

}

object GameOptionsFormFactory {
    private val instance : GameOptionsFormFactory = new GameOptionsFormFactory()

    def getInstance() : GameOptionsFormFactory = {
        return GameOptionsFormFactory.instance
    }

}


