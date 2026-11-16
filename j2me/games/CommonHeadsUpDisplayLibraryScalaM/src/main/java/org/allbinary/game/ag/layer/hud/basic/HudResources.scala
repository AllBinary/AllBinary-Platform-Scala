/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.game.ag.layer.hud.basic


class HudResources private() {
    import _root_.org.allbinary.game.ag.layer.hud.basic.HudResources.{*}

    val RESOURCE_LIFE : String = "/hud_life_10_by_10.png"

    val RESOURCE_HEALTH : String = "/hud_health_10_by_10.png"

}

object HudResources {
    private val instance : HudResources = new HudResources()

    def getInstance() : HudResources = {
        return HudResources.instance
    }

}


