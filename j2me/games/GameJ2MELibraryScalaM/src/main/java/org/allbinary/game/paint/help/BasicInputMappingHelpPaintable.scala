/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.game.paint.help

import _root_.org.allbinary.game.input.GameKey
import _root_.org.allbinary.game.input.GameKeyFactory
import _root_.org.allbinary.game.input.Input
import _root_.org.allbinary.game.input.PlatformInputMappingFactory
import _root_.org.allbinary.game.input.mapping.GameInputMapping
import _root_.org.allbinary.game.input.mapping.PersistentInputMapping
import _root_.org.allbinary.graphics.color.BasicColor
import _root_.org.allbinary.graphics.color.BasicColorFactory
import _root_.org.allbinary.logic.string.StringMaker
import _root_.org.allbinary.string.CommonSeps
import _root_.org.allbinary.util.BasicArrayList

class BasicInputMappingHelpPaintable(param_gameInputMappingArray : Array[GameInputMapping], param_basicColor : BasicColor) extends HelpPaintable("Help Screen", BasicColorFactory.getInstance().BLACK, param_basicColor) {

    private var gameInputMappingArray : Array[GameInputMapping] = null

    private val NONE : GameKey = GameKeyFactory.getInstance().NONE

    //Constructor
    {
        val gameInputMappingArray : Array[GameInputMapping] = param_gameInputMappingArray
        val basicColor : BasicColor = param_basicColor
        this.gameInputMappingArray = gameInputMappingArray
        this.update(this.NONE, this.NONE)
    }

    def update(selectedGameKey : GameKey, selectedInput : Input) : Unit = {
        val gameKeyMapping : PersistentInputMapping = PlatformInputMappingFactory.getInstance().getPersistentInputMappingInstance()
        val EQUAL : String = " = "
        val stringMaker : StringMaker = new StringMaker()
        val size : Int = this.gameInputMappingArray.length
        val keyInfo : Array[String] = new Array[String](size)
        var gameInputMapping : GameInputMapping = null
        var gameKey : GameKey = null
        var list : BasicArrayList = null

        {
            var index : Int = 0
            while (index < size) {
                gameInputMapping = this.gameInputMappingArray(index)
                gameKey = gameInputMapping.getGameKey()
                list = gameKeyMapping.getInputMapping().getMappedInput(gameKey)
                stringMaker.delete(0, stringMaker.length())
                keyInfo(index) = stringMaker.append(gameInputMapping.getName()).append(EQUAL).append(this.get(list)).toString()
                index += 1
            }
        }
        super.setInputInfoP(keyInfo)
    }

    private def get(keyList : BasicArrayList) : String = {
        val commonSeps : CommonSeps = CommonSeps.getInstance()
        val stringBuffer : StringMaker = new StringMaker()
        val AND : String = "and "
        var key : Input = null
        val size : Int = keyList.size()

        {
            var index : Int = 0
            while (index < size) {
                key = keyList.objectArray(index).asInstanceOf[Input]
                //Get system platform key(s) mapped to gamekey
                stringBuffer.append(key.getName())
                if ((index + 1) < keyList.size()) {
                    if (keyList.size() == 2) {
                        stringBuffer.append(commonSeps.SPACE).append(AND)
                    } else {
                        if ((index + 2) == keyList.size()) {
                            stringBuffer.append(commonSeps.COMMA_SEP)
                            stringBuffer.append(AND)
                        } else {
                            stringBuffer.append(commonSeps.COMMA_SEP)
                        }
                    }
                }
                index += 1
            }
        }
        return stringBuffer.toString()
    }

}


