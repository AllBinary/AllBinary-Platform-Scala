/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.game.ag.layer.pickup.life


/**  *  * @author Berthelot, Travis  * @version 1.0  */
class LifeResources private() {
    import _root_.org.allbinary.game.ag.layer.pickup.life.LifeResources.{*}

    var RESOURCE : String = "life_drop_20_by_20.png"

}

object LifeResources {
    private val SINGLETON : LifeResources = new LifeResources()

    def getInstance() : LifeResources = {
        return LifeResources.SINGLETON
    }

}


