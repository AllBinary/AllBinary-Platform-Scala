/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.game.combat.damage


class DamageableBaseBehavior extends DamageableInterface {
    import _root_.org.allbinary.game.combat.damage.DamageableBaseBehavior.{*}

    override def getName() : String = {
        return this.getClass().getName()
    }

    override def damage(damage : Int, damageType : Int) : Unit = {
    }

    //Gives out damage that would be expected of a blunt object
    override def getDamage(damageType : Int) : Int = {
        return 6000
    }

}

object DamageableBaseBehavior {
    private val instance : DamageableBaseBehavior = new DamageableBaseBehavior()

    def getInstance() : DamageableBaseBehavior = {
        return DamageableBaseBehavior.instance
    }

}


