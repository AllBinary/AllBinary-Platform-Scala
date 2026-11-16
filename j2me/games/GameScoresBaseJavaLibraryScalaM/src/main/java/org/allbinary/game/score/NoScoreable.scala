/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.game.score


class NoScoreable private() extends Scoreable(0) {
    import _root_.org.allbinary.game.score.NoScoreable.{*}

    override def addPoints(points : Int) : Unit = {
    }

    override def removePoints(points : Int) : Unit = {
    }

}

object NoScoreable {
    private val SINGLETON : NoScoreable = new NoScoreable()

    def getInstance() : NoScoreable = {
        return NoScoreable.SINGLETON
    }

}


