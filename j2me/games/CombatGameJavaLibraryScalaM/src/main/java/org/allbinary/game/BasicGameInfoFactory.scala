/* Generated Code Do Not Modify */
package org.allbinary.game


/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
class BasicGameInfoFactory private() {
    import _root_.org.allbinary.game.BasicGameInfoFactory.{*}

    var currentReleaseIndex : Int = 0

    var currentDestroyIndex : Int = 0

    var total : Int = 0

    def init(total : Int) : Unit = {
        this.currentReleaseIndex = 0
        this.currentDestroyIndex = 0
        this.total = total
    }

    def isPeaked() : Boolean = {
        if (this.currentDestroyIndex >= this.total) {
            return true
        } else {
            return false
        }
        throw new IllegalStateException()
    }

    def howManyLeft() : Int = {
        return this.total - this.currentDestroyIndex
    }

}

object BasicGameInfoFactory {
    private val SINGLETON : BasicGameInfoFactory = new BasicGameInfoFactory()

    def getInstance() : BasicGameInfoFactory = {
        return BasicGameInfoFactory.SINGLETON
    }

}


