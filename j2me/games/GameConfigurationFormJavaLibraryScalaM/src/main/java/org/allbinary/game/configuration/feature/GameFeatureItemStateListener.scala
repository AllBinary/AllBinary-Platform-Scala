/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.game.configuration.feature

import _root_.javax.microedition.lcdui.ChoiceGroup
import _root_.javax.microedition.lcdui.Item
import _root_.javax.microedition.lcdui.ItemStateListener
import _root_.org.allbinary.game.configuration.GameConfigurationGauge
import _root_.org.allbinary.game.configuration.GameConfigurationUtil
import _root_.org.allbinary.game.configuration.GameOptionsForm
import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.logic.string.StringMaker
import _root_.org.allbinary.string.CommonLabels
import _root_.org.allbinary.string.CommonStrings
import _root_.org.allbinary.util.BasicArrayList
import _root_.org.allbinary.util.BasicArrayListD

class GameFeatureItemStateListener(param_gameOptionsForm : GameOptionsForm) extends ItemStateListener {
    import _root_.org.allbinary.game.configuration.feature.GameFeatureItemStateListener.{*}

    val logUtil : LogUtil = LogUtil.getInstance()

    private var gameOptionsForm : GameOptionsForm = null

    //Constructor
    {
        val gameOptionsForm : GameOptionsForm = param_gameOptionsForm
        this.gameOptionsForm = gameOptionsForm
        // this.logUtil.putF(this.commonStrings.START, this, this.commonStrings.CONSTRUCTOR);
        var gameFeatureFactory : GameFeatureFactory = GameFeatureFactory.getInstance()
        GameFeatureItemStateListener.add(gameFeatureFactory.ARTIFICIAL_INTELLEGENCE_PROCESSOR)
        GameFeatureItemStateListener.add(gameFeatureFactory.COLLIDABLE_INTERFACE_LAYER_PROCESSOR)
        GameFeatureItemStateListener.add(gameFeatureFactory.DAMAGE_FLOATERS)
        GameFeatureItemStateListener.add(gameFeatureFactory.DROPPED_ITEMS)
        GameFeatureItemStateListener.add(gameFeatureFactory.GAME_INPUT_LAYER_PROCESSOR)
        GameFeatureItemStateListener.add(gameFeatureFactory.HEALTH_BARS)
        GameFeatureItemStateListener.add(gameFeatureFactory.SOUND)
        //toggleList.add(GameFeature.OPENGL);
        GameFeatureItemStateListener.add(gameFeatureFactory.TICKABLE_LAYER_PROCESSOR)
    }

    /*     public static GameFeatureItemStateListener getInstance()     {         return gameFeatureItemStateListener;     }     */
    override def itemStateChanged(item : Item) : Unit = {
        try {
            var itemLabel : String = item.getLabel()
            this.logUtil.putF(new StringMaker().append(CommonLabels.getInstance().ITEM_LABEL).append(itemLabel).toString(), this, "itemStateChanged")
            if (item.isInstanceOf[GameConfigurationGauge]) {
                GameConfigurationUtil.getInstance().change(this.gameOptionsForm, item.asInstanceOf[GameConfigurationGauge])
            } else if (item.isInstanceOf[ChoiceGroup]) {
                var gameFeatureUtil : GameFeatureUtil = GameFeatureUtil.getInstance()
                if (gameFeatureUtil.isExclusive(itemLabel)) {
                    gameFeatureUtil.updateExclusiveForChoiceGroup(item.asInstanceOf[ChoiceGroup])
                } else {
                    gameFeatureUtil.updateMultiple(item.asInstanceOf[ChoiceGroup])
                }
            }
        } catch {
            case e : Exception => {
                val commonStrings : CommonStrings = CommonStrings.getInstance()
                this.logUtil.put(commonStrings.EXCEPTION, this, "itemStateChanged", e)
            }
        }
    }

}

object GameFeatureItemStateListener {
    //private static final GameFeatureItemStateListener gameFeatureItemStateListener = new GameFeatureItemStateListener();
    private var toggleList : BasicArrayList = new BasicArrayListD()

    def add(gameFeature : GameFeature) : Unit = {
        if (!GameFeatureItemStateListener.toggleList.contains(gameFeature)) {
            GameFeatureItemStateListener.toggleList.add(gameFeature)
        }
    }

}


