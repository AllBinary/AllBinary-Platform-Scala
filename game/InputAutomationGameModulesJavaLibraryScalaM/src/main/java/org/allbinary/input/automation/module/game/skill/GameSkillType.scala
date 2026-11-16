/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.input.automation.module.game.skill


class GameSkillType private(param_name : String) {
    import _root_.org.allbinary.input.automation.module.game.skill.GameSkillType.{*}

    private val SPELL_GAME_SKILL_TYPE : String = "SpellGameSkillType: "

    private var name : String = null

    //Constructor
    {
        val name : String = param_name
        this.setName(name)
    }

    def getName() : String = {
        return this.name
    }

    def setName(name : String) : Unit = {
        this.name = name
    }

    override def toString() : String = {
        return this.SPELL_GAME_SKILL_TYPE + this.getName()
    }

}

object GameSkillType {
    var MANA : GameSkillType = new GameSkillType("Mana")

    var REPLENISH : GameSkillType = new GameSkillType("Replenish")

    var TIMED : GameSkillType = new GameSkillType("Timed")

    var ATTACK : GameSkillType = new GameSkillType("Attack")

    //  new GameSkillType("Ranged");
    var TRANSPORT : GameSkillType = new GameSkillType("Transport")

}


