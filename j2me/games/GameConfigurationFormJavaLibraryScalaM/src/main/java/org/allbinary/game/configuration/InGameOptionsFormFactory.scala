/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.game.configuration

import _root_.javax.microedition.lcdui.CommandListener
import _root_.org.allbinary.graphics.color.BasicColor
import _root_.org.allbinary.graphics.displayable.screen.CommandForm
import _root_.org.allbinary.init.Init
import _root_.org.allbinary.logic.NullUtil
import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.string.CommonStrings

class InGameOptionsFormFactory {
    import _root_.org.allbinary.game.configuration.InGameOptionsFormFactory.{*}

    val logUtil : LogUtil = LogUtil.getInstance()

    private var SINGLETON : CommandForm = CommandForm.getNullCommandForm()

    def init(commandListener : CommandListener, initInterface : Init, title : String, backgrounBasicColor : BasicColor, foregroundBasicColor : BasicColor) : Unit = {
        try {
            if (this.SINGLETON eq CommandForm.getNullCommandForm()) {
                initInterface.init()
                this.SINGLETON = new InGameOptionsForm(commandListener, title, backgrounBasicColor, foregroundBasicColor)
            }
        } catch {
            case e : Exception => {
                val commonStrings : CommonStrings = CommonStrings.getInstance()
                this.logUtil.put(commonStrings.EXCEPTION, this, commonStrings.INIT, e)
            }
        }
    }

    def get() : CommandForm = {
        return this.SINGLETON
    }

}

object InGameOptionsFormFactory {
    private var instance : Object = NullUtil.getInstance().NULL_OBJECT

    def getInstance() : InGameOptionsFormFactory = {
        if (InGameOptionsFormFactory.instance eq NullUtil.getInstance().NULL_OBJECT) {
            InGameOptionsFormFactory.instance = new InGameOptionsFormFactory()
        }
        return InGameOptionsFormFactory.instance.asInstanceOf[InGameOptionsFormFactory]
    }

}


