/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *   */
/* Generated Code Do Not Modify */
package org.allbinary.game.identification

import _root_.org.allbinary.logic.string.StringMaker
import _root_.org.allbinary.logic.string.StringUtil

class Group(param_teamName : String, param_teamId : Short) extends GroupInterface {

    private var name : String = StringUtil.getInstance().EMPTY_STRING

    private var teamId : Short = 0

    private var string : String = StringUtil.getInstance().EMPTY_STRING

    //Constructor
    {
        val teamName : String = param_teamName
        val teamId : Short = param_teamId
        this.teamId = teamId
        this.setName(teamName)
    }

    override def getGroupName() : String = {
        return this.name
    }

    def setName(name : String) : Unit = {
        this.name = name
        val groupCommonFactory : GroupCommonFactory = GroupCommonFactory.getInstance()
        val stringBuffer : StringMaker = new StringMaker()
        stringBuffer.append(groupCommonFactory.GROUP_NAME_LABEL)
        stringBuffer.append(this.name)
        stringBuffer.append(groupCommonFactory.ID_LABEL)
        stringBuffer.appendshort(this.teamId)
        this.string = stringBuffer.toString()
    }

    override def getGroupId() : Short = {
        return this.teamId
    }

    override def toString() : String = {
        return this.string
    }

}


