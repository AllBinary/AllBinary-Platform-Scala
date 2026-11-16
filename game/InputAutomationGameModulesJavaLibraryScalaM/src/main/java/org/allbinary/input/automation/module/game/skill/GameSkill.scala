/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.input.automation.module.game.skill

import _root_.java.util.HashMap
import _root_.org.allbinary.util.BasicArrayList
import _root_.org.allbinary.util.BasicArrayListD
import _root_.org.allbinary.logic.StdUtil
import _root_.org.allbinary.logic.string.StringMaker
import _root_.org.allbinary.string.CommonSeps

class GameSkill(param_gameSkillType : GameSkillType, param_extra : String, param_time : Int) {
    import _root_.org.allbinary.input.automation.module.game.skill.GameSkill.{*}

    private var gameSkillType : GameSkillType = null

    private var extra : String = null

    private var time : Int = 0

    private var vector : BasicArrayList = null

    private val GAME_SKILL_LABEL : String = "GameSkill: "

    private val EXTRA_LABEL : String = "Extra: "

    private val TIME_LABEL : String = "Time: "

    //Constructor
    {
        val gameSkillType : GameSkillType = param_gameSkillType
        val extra : String = param_extra
        val time : Int = param_time
        this.setGameSkillType(gameSkillType)
        this.setExtra(extra)
        this.setTime(time)
        this.vector = new BasicArrayListD()
        GameSkill.hashMap.put(new StringMaker().append(this.getGameSkillType().getName()).append(CommonSeps.getInstance().SPACE).append(extra).toString(), this)
    }

    def getGameSkillType() : GameSkillType = {
        return this.gameSkillType
    }

    def setGameSkillType(gameSkillType : GameSkillType) : Unit = {
        this.gameSkillType = gameSkillType
    }

    def getExtra() : String = {
        return this.extra
    }

    def setExtra(extra : String) : Unit = {
        this.extra = extra
    }

    def getTime() : Int = {
        return this.time
    }

    def setTime(time : Int) : Unit = {
        this.time = time
    }

    def addProperty(gameSkillPropertyInterface : GameSkillPropertyInterface) : Unit = {
        this.vector.add(gameSkillPropertyInterface)
    }

    def getProperties() : BasicArrayList = {
        return this.vector
    }

    override def toString() : String = {
        val commonSeps : CommonSeps = CommonSeps.getInstance()
        val stringBuffer : StringMaker = new StringMaker()
        stringBuffer.append(this.GAME_SKILL_LABEL)
        stringBuffer.append(this.getGameSkillType().toString())
        stringBuffer.append(commonSeps.SPACE)
        stringBuffer.append(this.EXTRA_LABEL)
        stringBuffer.append(this.getExtra())
        stringBuffer.append(commonSeps.SPACE)
        stringBuffer.append(this.TIME_LABEL)
        stringBuffer.appendlong(this.getTime())
        return stringBuffer.toString()
    }

}

object GameSkill {
    private var hashMap : HashMap[Object, Object] = StdUtil.getInstance().createHashMap().asInstanceOf[HashMap[Object, Object]]

    def getInstance(gameSkillType : GameSkillType, extra : String) : GameSkill = {
        return GameSkill.hashMap.get(new StringMaker().append(gameSkillType.getName()).append(CommonSeps.getInstance().SPACE).append(extra).toString()).asInstanceOf[GameSkill]
    }

}


