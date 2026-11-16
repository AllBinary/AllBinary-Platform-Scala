/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.game.combat.damage


class ExplosionResources private() {
    import _root_.org.allbinary.game.combat.damage.ExplosionResources.{*}

    val EXPLOSION_90_RESOURCE : String = "/explosion_sprite_90_by_90.png"

    val EXPLOSION_60_RESOURCE : String = "/explosion_sprite_60_by_60.png"

    val HALF_EXPLOSION_RESOURCE : String = "/explosion_sprite_30_by_30.png"

    val THIRD_EXPLOSION_RESOURCE : String = "/explosion_sprite_15_by_15.png"

}

object ExplosionResources {
    private val instance : ExplosionResources = new ExplosionResources()

    def getInstance() : ExplosionResources = {
        return ExplosionResources.instance
    }

}


