/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.game.score

import _root_.org.allbinary.logic.math.SmallIntegerSingletonFactory

class Scoreable(param_points : Int) extends ScoreableInterface {
    import _root_.org.allbinary.game.score.Scoreable.{*}

    private var points : Int = 0

    //Constructor
    {
        val points : Int = param_points
        this.points = points
    }

    override def addPoints(points : Int) : Unit = {
        this.points += points
    }

    override def removePoints(points : Int) : Unit = {
        this.points -= points
    }

    def setPoints(points : Int) : Unit = {
        this.points = points
    }

    override def getPoints() : Int = {
        return this.points
    }

}

object Scoreable {
    var ID : Integer = SmallIntegerSingletonFactory.getInstance().getAt(3)

}


