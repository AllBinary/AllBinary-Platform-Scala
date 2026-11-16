/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.game.configuration.feature

import _root_.java.util.Enumeration
import _root_.javax.microedition.lcdui.ChoiceGroup
import _root_.org.allbinary.TsUtil
import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.logic.string.StringMaker
import _root_.org.allbinary.string.CommonLabels
import _root_.org.allbinary.util.ABHashtable
import _root_.org.allbinary.util.BasicArrayList
import _root_.org.allbinary.util.EnumerationUtil
import _root_.org.allbinary.util.HashtableUtil

class GameFeatureUtil {
    import _root_.org.allbinary.game.configuration.feature.GameFeatureUtil.{*}

    val logUtil : LogUtil = LogUtil.getInstance()

    private val tsUtil : TsUtil = TsUtil.getInstance()

    private val enumerationUtil : EnumerationUtil = EnumerationUtil.getInstance()

    val ON_GAME_FEATURE_CHANGE : String = "onGameFeatureChange"

    val GAME_FEATURE_CHANGED : String = "Game Feature Changed: "

    def setDefault(choiceGroup : ChoiceGroup) : Unit = {
        var stringBuffer : StringMaker = new StringMaker()
        val METHOD_NAME : String = "setDefault"
        val SELECTED_ARRAY_RETURN : String = "selectedArray_return["
        val SELECTED_SEP : String = "] = "
        var selectedArray_return : Array[Boolean] = new Array[Boolean](choiceGroup.size())
        var total : Int = choiceGroup.getSelectedFlags(selectedArray_return)
        stringBuffer.append("Multiple Total Choices: ")
        stringBuffer.appendint(total)
        this.logUtil.putF(stringBuffer.toString(), this, METHOD_NAME)
        var features : Features = Features.getInstance()

        {
            var index : Int = 0
            while (index < selectedArray_return.length) {
                var isSelected : Boolean = selectedArray_return(index)
                stringBuffer.delete(0, stringBuffer.length())
                stringBuffer.append(SELECTED_ARRAY_RETURN)
                stringBuffer.appendint(index)
                stringBuffer.append(SELECTED_SEP)
                stringBuffer.appendboolean(isSelected)
                this.logUtil.putF(stringBuffer.toString(), this, METHOD_NAME)
                var selectedChoiceLabel : String = choiceGroup.getString(index)
                var gameFeature : Feature = Feature.getInstance(selectedChoiceLabel)
                if (features.isDefault(gameFeature)) {
                    features.add(gameFeature)
                    choiceGroup.setSelectedIndex(index, true)
                } else {
                    features.remove(gameFeature)
                    choiceGroup.setSelectedIndex(index, false)
                }
                index += 1
            }
        }
    }

    def updateMultiple(choiceGroup : ChoiceGroup) : Unit = {
        var stringBuffer : StringMaker = new StringMaker()
        val METHOD_NAME : String = "updateMultiple"
        val SELECTED_ARRAY_RETURN : String = "selectedArray_return["
        val SELECTED_SEP : String = "] = "
        var selectedArray_return : Array[Boolean] = new Array[Boolean](choiceGroup.size())
        var total : Int = choiceGroup.getSelectedFlags(selectedArray_return)
        stringBuffer.append("Multiple Total Choices: ")
        stringBuffer.appendint(total)
        this.logUtil.putF(stringBuffer.toString(), this, METHOD_NAME)
        var features : Features = Features.getInstance()

        {
            var index : Int = 0
            while (index < selectedArray_return.length) {
                var isSelected : Boolean = selectedArray_return(index)
                stringBuffer.delete(0, stringBuffer.length())
                stringBuffer.append(SELECTED_ARRAY_RETURN)
                stringBuffer.appendint(index)
                stringBuffer.append(SELECTED_SEP)
                stringBuffer.appendboolean(isSelected)
                this.logUtil.putF(stringBuffer.toString(), this, METHOD_NAME)
                var selectedChoiceLabel : String = choiceGroup.getString(index)
                var gameFeature : Feature = Feature.getInstance(selectedChoiceLabel)
                if (!isSelected && features.isFeature(gameFeature)) {
                    features.remove(gameFeature)
                } else if (isSelected && !features.isFeature(gameFeature)) {
                    features.add(gameFeature)
                }
                index += 1
            }
        }
    }

    def updateExclusiveForChoiceGroup(choiceGroup : ChoiceGroup) : Unit = {
        var stringBuffer : StringMaker = new StringMaker()
        val METHOD_NAME : String = "updateExclusive"
        val SELECTED_ARRAY_RETURN : String = "selectedArray_return["
        val SELECTED_SEP : String = "] = "
        var selectedArray_return : Array[Boolean] = new Array[Boolean](choiceGroup.size())
        var total : Int = choiceGroup.getSelectedFlags(selectedArray_return)
        stringBuffer.append("Exclusive Total Choices: 1==")
        stringBuffer.appendint(total)
        this.logUtil.putF(stringBuffer.toString(), this, METHOD_NAME)

        {
            var index : Int = 0
            while (index < selectedArray_return.length) {
                var isSelected : Boolean = selectedArray_return(index)
                stringBuffer.delete(0, stringBuffer.length())
                stringBuffer.append(SELECTED_ARRAY_RETURN)
                stringBuffer.appendint(index)
                stringBuffer.append(SELECTED_SEP)
                stringBuffer.appendboolean(isSelected)
                this.logUtil.putF(stringBuffer.toString(), this, METHOD_NAME)
                if (isSelected) {
                    var selectedChoiceLabel : String = choiceGroup.getString(index)
                    this.updateExclusive(selectedChoiceLabel)
                }
                index += 1
            }
        }
    }

    def isExclusive(itemLabel : String) : Boolean = {
        val enumeration : Enumeration[? <: Object] = GameFeatureChoiceGroups.getExclusiveInstance().get().keys().asInstanceOf[Enumeration[? <: Object]]
        var name : String = null

        {
            while (this.enumerationUtil.hasMoreElements(enumeration)) {
                name = this.enumerationUtil.nextElement(enumeration).asInstanceOf[String]
                if (this.tsUtil.compareTo(itemLabel, name) == 0) {
                    return true
                }
            }
        }
        return false
    }

    private def updateExclusive(selectedChoiceLabel : String) : Unit = {
        this.logUtil.putF(new StringMaker().append(CommonLabels.getInstance().ITEM_LABEL).append(selectedChoiceLabel).toString(), this, "updateExclusive")
        val gameFeature : Feature = Feature.getInstance(selectedChoiceLabel)
        val hashtable : ABHashtable[Object, Object] = GameFeatureChoiceGroups.getExclusiveInstance().get()
        val objectArray : Array[Object] = HashtableUtil.getInstance().getKeysAsArray(hashtable)
        var basicArrayList : BasicArrayList = null
        var anyType : Object = null
        var size : Int = objectArray.length

        {
            var index : Int = 0
            while (index < size) {
                anyType = objectArray(index).asInstanceOf[Object]
                basicArrayList = hashtable.get(anyType).asInstanceOf[BasicArrayList]
                this.updateExclusiveList(gameFeature, basicArrayList)
                index += 1
            }
        }
    }

    def updateExclusiveList(gameFeature : Feature, list : BasicArrayList) : Unit = {
        if (list.contains(gameFeature)) {
            var features : Features = Features.getInstance()
            var addIndex : Int = list.indexOf(gameFeature)
            var size : Int = list.size()

            {
                var index : Int = 0
                while (index < size) {
                    if (addIndex != index) {
                        features.remove(list.objectArray(index).asInstanceOf[Feature])
                    } else {
                        features.add(list.objectArray(index).asInstanceOf[Feature])
                    }
                    index += 1
                }
            }
        }
    }

}

object GameFeatureUtil {
    private val instance : GameFeatureUtil = new GameFeatureUtil()

    def getInstance() : GameFeatureUtil = {
        return GameFeatureUtil.instance
    }

}


