/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.game.input.mapping

import _root_.org.allbinary.game.input.Input
import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.logic.string.StringMaker
import _root_.org.allbinary.logic.string.StringUtil
import _root_.org.allbinary.string.CommonLabels
import _root_.org.allbinary.string.CommonStrings
import _root_.org.allbinary.util.BasicArrayList
import _root_.org.allbinary.util.BasicArrayListD
import _root_.org.allbinary.logic.StdUtil
import _root_.org.allbinary.util.ABHashtable

class InputMapping() {

    val logUtil : LogUtil = LogUtil.getInstance()

    val commonStrings : CommonStrings = CommonStrings.getInstance()

    //TWB - Use MapList someday
    private val hashtable : ABHashtable[Object, Object] = StdUtil.getInstance().createHashtable()

    private val mappedList : BasicArrayList = new BasicArrayListD()

    def getTotalMapped() : Int = {
        return this.hashtable.size()
    }

    def isDefaultNew() : Boolean = {
        return false
    }

    def getDefault() : InputToGameKeyMapping = {
        return InputToGameKeyMapping.getNullInstance()
    }

    def removeAll() : Unit = {
        this.hashtable.clear()
        this.mappedList.clear()
    }

    def remove(input : Input, mappedToInput : Input) : Unit = {
        val stringBuffer : StringMaker = new StringMaker()
        val stringUtil : StringUtil = StringUtil.getInstance()
        stringBuffer.append(CommonLabels.getInstance().START_LABEL)
        stringBuffer.append(stringUtil.toString(input))
        stringBuffer.append(" == ")
        stringBuffer.append(stringUtil.toString(mappedToInput))
        this.logUtil.putF(stringBuffer.toString(), this, "InputMapping::remove")
        val list : BasicArrayList = this.getMappedInput(input)
        if (list.contains(mappedToInput)) {
            list.remove(mappedToInput)
            this.mappedList.remove(mappedToInput)
            stringBuffer.delete(0, stringBuffer.length())
            stringBuffer.append("Removed: ")
            stringBuffer.append(stringUtil.toString(input))
            stringBuffer.append(" == ")
            stringBuffer.append(stringUtil.toString(mappedToInput))
            this.logUtil.putF(stringBuffer.toString(), this, "InputMapping::remove")
        } else {
            stringBuffer.delete(0, stringBuffer.length())
            stringBuffer.append("Not Deleted: ")
            stringBuffer.append(stringUtil.toString(input))
            stringBuffer.append(" == ")
            stringBuffer.append(stringUtil.toString(mappedToInput))
            this.logUtil.putF(stringBuffer.toString(), this, "InputMapping::remove")
        }
    }

    def addMapping(inputToGameKeyMapping : InputToGameKeyMapping) : Unit = {
        throw new Exception(this.commonStrings.NOT_IMPLEMENTED)
    }

    def add(input : Input, mappedToInput : Input) : Unit = {
        //this.logUtil.putF(this.commonStrings.START_LABEL + input + " == " + mappedToInput, this, "InputMapping::add");
        var list : BasicArrayList = this.getMappedInput(input)
        if (!list.contains(mappedToInput)) {
            list.add(mappedToInput)
            this.mappedList.add(mappedToInput)
        }
    }

    def isMapped(input : Input) : Boolean = {
        return this.mappedList.contains(input)
    }

    def getMappedInput(id : Input) : BasicArrayList = {
        val mappingInputCanBeNullList : Object = this.hashtable.get(id)
        if (mappingInputCanBeNullList == null) {
            val list : BasicArrayList = new BasicArrayListD()
            this.hashtable.put(id, list)
            return list
        }
        return mappingInputCanBeNullList.asInstanceOf[BasicArrayList]
    }

    def getHashtable() : ABHashtable[Object, Object] = {
        return this.hashtable
    }

}


