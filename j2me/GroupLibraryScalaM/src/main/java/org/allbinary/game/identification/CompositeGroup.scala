/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.game.identification

import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.logic.string.StringMaker
import _root_.org.allbinary.logic.string.StringUtil
import _root_.org.allbinary.string.CommonStrings
import _root_.org.allbinary.util.BasicArrayList
import _root_.org.allbinary.util.BasicArrayListD

class CompositeGroup(param_groupInterface : Group) {

    val logUtil : LogUtil = LogUtil.getInstance()

    private var groupInterface : Group = null

    private val list : BasicArrayList = new BasicArrayListD()

    //Constructor
    {
        val groupInterface : Group = param_groupInterface
        this.groupInterface = groupInterface
    }

    def clear() : Unit = {
        this.list.clear()
    }

    def add(groupInterface : Group) : Unit = {
        val commonStrings : CommonStrings = CommonStrings.getInstance()
        val groupCommonFactory : GroupCommonFactory = GroupCommonFactory.getInstance()
        val stringBuffer : StringMaker = new StringMaker()
        stringBuffer.append(groupCommonFactory.ADDING_LABEL)
        stringBuffer.append(groupInterface.toString())
        stringBuffer.append(groupCommonFactory.TO_LABEL)
        stringBuffer.append(StringUtil.getInstance().toString(this.groupInterface))
        this.logUtil.putF(stringBuffer.toString(), this, commonStrings.ADD)
        this.list.add(groupInterface)
    }

    def isInGroup(groupInterface : Group) : Boolean = {
        if (this.list.contains(groupInterface)) {
            return true
        } else {
            return false
        }
        throw new IllegalStateException()
    }

    def getGroup() : Group = {
        return this.groupInterface
    }

}


