/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.canvas


//NoPlatform
class GameStatisticsFactory extends BaseGameStatistics {
    import _root_.org.allbinary.canvas.GameStatisticsFactory.{*}

    override def add(string : String) : Unit = {
    }

    override def toString() : String = {
        throw new RuntimeException()
    }

}

object GameStatisticsFactory {
    private val instance : GameStatisticsFactory = new GameStatisticsFactory()

    def getInstance() : GameStatisticsFactory = {
        return GameStatisticsFactory.instance
    }

}


