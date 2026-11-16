/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.game.combat.damage

import _root_.org.allbinary.game.layer.CollidableCompositeLayer
import _root_.org.allbinary.game.layer.special.CollidableDestroyableDamageableLayer
import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.logic.string.StringMaker

class DamageUtil private() {
    import _root_.org.allbinary.game.combat.damage.DamageUtil.{*}

    val logUtil : LogUtil = LogUtil.getInstance()

    val COLLIDE : String = "collide"

    def process(damageableInterface : DamageableInterface, damageableInterface2 : DamageableInterface) : Unit = {
        damageableInterface.damage(damageableInterface2.getDamage(0), 0)
    }

    def debugDamage(collidableInterfaceCompositeInterface1 : CollidableCompositeLayer, collidableInterfaceCompositeInterface : CollidableCompositeLayer) : Unit = {
        val collidableDestroyableDamageableLayer : CollidableDestroyableDamageableLayer = collidableInterfaceCompositeInterface.asInstanceOf[CollidableDestroyableDamageableLayer]
        var damage : Int = collidableDestroyableDamageableLayer.getDamage(0)
        if (damage > 20000) {
            var stringBuffer : StringMaker = new StringMaker()
            stringBuffer.append("Collision ")
            stringBuffer.append(collidableInterfaceCompositeInterface1.toString())
            stringBuffer.append(" with: ")
            stringBuffer.append(collidableInterfaceCompositeInterface.toString())
            stringBuffer.append(" damage: ")
            stringBuffer.appendint(damage)
            this.logUtil.putF(stringBuffer.toString(), collidableInterfaceCompositeInterface1, this.COLLIDE)
        }
    }

}

object DamageUtil {
    private val instance : DamageUtil = new DamageUtil()

    /**      * @return the instance      */
    def getInstance() : DamageUtil = {
        return DamageUtil.instance
    }

}


