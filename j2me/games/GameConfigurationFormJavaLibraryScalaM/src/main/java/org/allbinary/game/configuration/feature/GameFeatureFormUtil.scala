/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.game.configuration.feature

import _root_.javax.microedition.lcdui.ChoiceGroup
import _root_.javax.microedition.lcdui.Item
import _root_.javax.microedition.lcdui.NullImage
import _root_.org.allbinary.MIDPUtil
import _root_.org.allbinary.game.configuration.GameConfigurationGauge
import _root_.org.allbinary.game.configuration.GameConfigurationUtil
import _root_.org.allbinary.graphics.displayable.screen.CommandForm
import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.logic.string.StringMaker
import _root_.org.allbinary.logic.string.StringUtil
import _root_.org.allbinary.util.ABHashtable
import _root_.org.allbinary.util.BasicArrayList
import _root_.org.allbinary.util.HashtableUtil

class GameFeatureFormUtil {
    import _root_.org.allbinary.game.configuration.feature.GameFeatureFormUtil.{*}

    val logUtil : LogUtil = LogUtil.getInstance()

    private val meUtil : MIDPUtil = MIDPUtil.getInstance()

    def getChoiceGroup(hashtable : ABHashtable[Object, Object], name : String, option : Int) : ChoiceGroup = {
        val stringMaker : StringMaker = new StringMaker()
        val choiceGroup : ChoiceGroup = new ChoiceGroup(name, option, StringUtil.getInstance().getArrayInstance(), NullImage.NULL_IMAGE_ARRAY)
        val list : BasicArrayList = hashtable.get(name.asInstanceOf[Object]).asInstanceOf[BasicArrayList]
        val features : Features = Features.getInstance()
        val ADD_CHOICE : String = ": Adding Choice: "
        val GET_CHOICE_GROUP : String = "getChoiceGroup"
        val size : Int = list.size()

        {
            var index : Int = 0
            while (index < size) {
                val gameFeature : Feature = list.objectArray(index).asInstanceOf[Feature]
                stringMaker.delete(0, stringMaker.length())
                this.logUtil.putF(stringMaker.append(name).append(ADD_CHOICE).append(gameFeature.toString()).toString(), this, GET_CHOICE_GROUP)
                choiceGroup.append(gameFeature.toString(), NullImage.NULL_IMAGE)
                if (features.isFeature(gameFeature)) {
                    choiceGroup.setSelectedIndex(index, true)
                }
                index += 1
            }
        }
        return choiceGroup
    }

    def addChoiceGroup(form : CommandForm, hashtable : ABHashtable[Object, Object], option : Int) : Unit = {
        val stringMaker : StringMaker = new StringMaker()
        val ADDING_CHOICE_GROUP : String = "Adding Choice Group: "
        val ADD_CHOICE_GROUP : String = "addChoiceGroup"
        val size : Int = hashtable.size()
        val objectArray : Array[Object] = HashtableUtil.getInstance().getKeysAsArray(hashtable)
        var name : String = null

        {
            var index : Int = 0
            while (index < size) {
                name = objectArray(index).asInstanceOf[String]
                stringMaker.delete(0, stringMaker.length())
                this.logUtil.putF(stringMaker.append(ADDING_CHOICE_GROUP).append(name).toString(), this, ADD_CHOICE_GROUP)
                this.meUtil.appendItem(form, this.getChoiceGroup(hashtable, name, option))
                index += 1
            }
        }
    }

    def setDefault(form : CommandForm) : Unit = {
        val size : Int = form.size()

        {
            var index : Int = 0
            while (index < size) {
                var item : Item = form.get(index)
                if (item.isInstanceOf[GameConfigurationGauge]) {
                    GameConfigurationUtil.getInstance().setDefault(item.asInstanceOf[GameConfigurationGauge])
                } else if (item.isInstanceOf[ChoiceGroup]) {
                    GameFeatureUtil.getInstance().setDefault(item.asInstanceOf[ChoiceGroup])
                }
                index += 1
            }
        }
    }

}

object GameFeatureFormUtil {
    private val instance : GameFeatureFormUtil = new GameFeatureFormUtil()

    def getInstance() : GameFeatureFormUtil = {
        return GameFeatureFormUtil.instance
    }

}


