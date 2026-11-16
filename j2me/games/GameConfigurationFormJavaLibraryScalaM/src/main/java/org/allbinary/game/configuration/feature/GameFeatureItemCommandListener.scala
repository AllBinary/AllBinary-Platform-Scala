/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.game.configuration.feature

import _root_.javax.microedition.lcdui.Command
import _root_.javax.microedition.lcdui.Item
import _root_.javax.microedition.lcdui.ItemCommandListener
import _root_.org.allbinary.game.configuration.GameConfigurationGauge
import _root_.org.allbinary.game.configuration.GameConfigurationUtil
import _root_.org.allbinary.game.configuration.GameOptionsForm
import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.logic.string.StringMaker
import _root_.org.allbinary.midlet.MidletStrings
import _root_.org.allbinary.string.CommonLabels
import _root_.org.allbinary.string.CommonStrings

class GameFeatureItemCommandListener(param_gameOptionsForm : GameOptionsForm) extends ItemCommandListener {

    val logUtil : LogUtil = LogUtil.getInstance()

    /*private static final GameFeatureItemCommandListener gameFeatureItemStateListener = new GameFeatureItemCommandListener();      public static GameFeatureItemCommandListener getInstance()     {         return gameFeatureItemStateListener;     }     */
    private var gameOptionsForm : GameOptionsForm = null

    //Constructor
    {
        val gameOptionsForm : GameOptionsForm = param_gameOptionsForm
        this.gameOptionsForm = gameOptionsForm
    }

    override def commandAction(command : Command, item : Item) : Unit = {
        try {
            var itemLabel : String = item.getLabel()
            this.logUtil.putF(new StringMaker().append(CommonLabels.getInstance().ITEM_LABEL).append(itemLabel).toString(), this, MidletStrings.getInstance().COMMAND_ACTION)
            if (item.isInstanceOf[GameConfigurationGauge]) {
                GameConfigurationUtil.getInstance().change(this.gameOptionsForm, item.asInstanceOf[GameConfigurationGauge])
            }
        } catch {
            case e : Exception => {
                val commonStrings : CommonStrings = CommonStrings.getInstance()
                this.logUtil.put(commonStrings.EXCEPTION, this, MidletStrings.getInstance().COMMAND_ACTION, e)
            }
        }
    }

}


