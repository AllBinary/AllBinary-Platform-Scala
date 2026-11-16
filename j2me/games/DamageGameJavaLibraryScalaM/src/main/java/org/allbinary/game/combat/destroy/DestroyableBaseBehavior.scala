/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.game.combat.destroy

import _root_.org.allbinary.string.CommonStrings

class DestroyableBaseBehavior extends DestroyableInterface {
    import _root_.org.allbinary.game.combat.destroy.DestroyableBaseBehavior.{*}

    override def getName() : String = {
        return this.getClass().getName()
    }

    override def isDestroyed() : Boolean = {
        throw new Exception(CommonStrings.getInstance().NOT_IMPLEMENTED)
    }

    def setDestroyed(destroyed : Boolean) : Unit = {
    }

}

object DestroyableBaseBehavior {
    private val instance : DestroyableBaseBehavior = new DestroyableBaseBehavior()

    def getInstance() : DestroyableBaseBehavior = {
        return DestroyableBaseBehavior.instance
    }

}


