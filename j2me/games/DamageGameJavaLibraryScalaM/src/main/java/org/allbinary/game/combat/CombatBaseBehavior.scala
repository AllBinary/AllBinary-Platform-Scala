/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.game.combat

import _root_.org.allbinary.game.combat.damage.DamageableBaseBehavior
import _root_.org.allbinary.game.combat.destroy.DestroyableBaseBehavior

class CombatBaseBehavior(param_damageableBaseBehavior : DamageableBaseBehavior, param_destroyableBaseBehavior : DestroyableBaseBehavior) {
    import _root_.org.allbinary.game.combat.CombatBaseBehavior.{NULL_COMBAT_BEHAVIOR as _, *}
    def NULL_COMBAT_BEHAVIOR : CombatBaseBehavior = _root_.org.allbinary.game.combat.CombatBaseBehavior.NULL_COMBAT_BEHAVIOR

    private var damageableBaseBehavior : DamageableBaseBehavior = null

    private var destroyableBaseBehavior : DestroyableBaseBehavior = null

    private var readyForExplosion : Boolean = false

    //Constructor
    {
        val damageableBaseBehavior : DamageableBaseBehavior = param_damageableBaseBehavior
        val destroyableBaseBehavior : DestroyableBaseBehavior = param_destroyableBaseBehavior
        this.damageableBaseBehavior = damageableBaseBehavior
        this.destroyableBaseBehavior = destroyableBaseBehavior
    }

    def getDamageableBaseBehavior() : DamageableBaseBehavior = {
        return this.damageableBaseBehavior
    }

    def getDestroyableBaseBehavior() : DestroyableBaseBehavior = {
        return this.destroyableBaseBehavior
    }

    final def isReadyForExplosion() : Boolean = {
        return this.readyForExplosion
    }

    final def setReadyForExplosion(readyForExplosion : Boolean) : Unit = {
        this.readyForExplosion = readyForExplosion
    }

}

object CombatBaseBehavior {
    val NULL_COMBAT_BEHAVIOR : CombatBaseBehavior = new CombatBaseBehavior(DamageableBaseBehavior.getInstance(), DestroyableBaseBehavior.getInstance())

}


