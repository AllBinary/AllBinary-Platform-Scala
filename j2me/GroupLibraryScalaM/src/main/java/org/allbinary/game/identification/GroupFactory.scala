/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *   */
/* Generated Code Do Not Modify */
package org.allbinary.game.identification

import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.logic.string.StringMaker
import _root_.org.allbinary.logic.string.StringUtil
import _root_.org.allbinary.util.BasicArrayList
import _root_.org.allbinary.util.BasicArrayListD

class GroupFactory {
    import _root_.org.allbinary.game.identification.GroupFactory.{*}

    val logUtil : LogUtil = LogUtil.getInstance()

    val NULL_GROUP_ARRAY : Array[Group] = new Array[Group](0)

    private val list : BasicArrayList = new BasicArrayListD()

    private var index : Int = 0

    def getNextGroup() : Group = {
        //        }
        val group : Group = this.list.objectArray(this.index).asInstanceOf[Group]
        //this.logUtil.putF(new StringMaker().append("group: ").append(group).append(" index: ").append(index).toString(), this, "getNextGroup");
        this.index += 1
        return group
    }

    def getNextGroupByName(name : String) : Group = {
        val group : Group = this.getNextGroup()
        //this.logUtil.putF(new StringMaker().append("group: ").append(group).append(" name: ").append(name).toString(), this, "getNextGroup");
        group.setName(name)
        return group
    }

    def init(groups : Short, nameArray : Array[String]) : Unit = {
        val stringMaker : StringMaker = new StringMaker()
        val stringUtil : StringUtil = StringUtil.getInstance()
        val TEAM : String = "Team "
        this.list.clear()
        this.index = 0
        var size : Int = this.list.size()
        var name : String = null

        {
            while (size < groups) {
                name = stringUtil.EMPTY_STRING
                if (size < nameArray.length) {
                    name = nameArray(size)
                } else {
                    stringMaker.delete(0, stringMaker.length())
                    name = stringMaker.append(TEAM).appendint(size).toString()
                }
                this.list.add(new Group(name, (size + 3).toShort))
                size += 1
            }
        }
    }

}

object GroupFactory {
    private val instance : GroupFactory = new GroupFactory()

    def getInstance() : GroupFactory = {
        return GroupFactory.instance
    }

}


