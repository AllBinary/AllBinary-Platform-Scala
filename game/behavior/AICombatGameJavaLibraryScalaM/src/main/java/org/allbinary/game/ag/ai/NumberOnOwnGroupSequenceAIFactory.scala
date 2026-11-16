/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.game.ag.ai

import _root_.org.allbinary.ai.ArtificialIntelligenceInterface
import _root_.org.allbinary.game.input.GameInput
import _root_.org.allbinary.layer.AllBinaryLayer
import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.logic.string.StringMaker
import _root_.org.allbinary.string.CommonStrings
import _root_.org.allbinary.util.ABHashtable
import _root_.org.allbinary.util.BasicArrayList
import _root_.org.allbinary.util.BasicArrayListD

class NumberOnOwnGroupSequenceAIFactory {

    val logUtil : LogUtil = LogUtil.getInstance()

    def getInstance(hashtable : ABHashtable[Object, Object], artificialIntelligenceInterface : Array[ArtificialIntelligenceInterface], ownerLayerInterface : AllBinaryLayer, gameInput : GameInput) : ArtificialIntelligenceInterface = {
        val integerArray : Array[Integer] = NumberInSameGroupSequence.getInstance().NUMBER_ON_SAME_TEAM_SEQUENCE
        val list : BasicArrayList = new BasicArrayListD()

        {
            var index : Int = 0
            scala.util.boundary { (break_N69884 : scala.util.boundary.Label[Unit]) ?=>
                while (index < integerArray.length) {
                    var integerCanBeNull : Object = hashtable.get(integerArray(index).asInstanceOf[Object])
                    if (integerCanBeNull == null) {
                        scala.util.boundary.break()(using break_N69884)
                    }
                    list.add(integerCanBeNull)
                    index += 1
                }
            }
        }
        val stringBuffer : StringMaker = new StringMaker()
        stringBuffer.append("Total AI Properties: ")
        stringBuffer.appendint(list.size())
        stringBuffer.append(" == Total AI: ")
        stringBuffer.appendint(artificialIntelligenceInterface.length)
        stringBuffer.append(" + 1")
        val commonStrings : CommonStrings = CommonStrings.getInstance()
        this.logUtil.putF(stringBuffer.toString(), this, commonStrings.GET_INSTANCE)
        if ((artificialIntelligenceInterface.length - 1) > list.size()) {
            throw new Exception("Not enough AI properties.")
        }
        if ((artificialIntelligenceInterface.length - 1) < list.size()) {
            throw new Exception("Too Many AI properties.")
        }
        var numberOnSameTeam : Array[Integer] = new Array[Integer](list.size())

        {
            var index : Int = 0
            while (index < numberOnSameTeam.length) {
                numberOnSameTeam(index) = list.objectArray(index).asInstanceOf[Integer]
                index += 1
            }
        }
        return new NumberOnOwnGroupSequenceAI(numberOnSameTeam, artificialIntelligenceInterface, ownerLayerInterface, gameInput)
    }

}


