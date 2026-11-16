/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.canvas

import _root_.org.allbinary.logic.string.StringMaker

//ActualPlatform
class GameStatisticsFactory extends BaseGameStatistics {
    import _root_.org.allbinary.canvas.GameStatisticsFactory.{*}

    private var stringBuffer : StringMaker = new StringMaker()

    override def add(string : String) : Unit = {
        if (this.stringBuffer.length() > 12000) {
            this.stringBuffer.delete(0, this.stringBuffer.length())
            this.stringBuffer.append("Old Stats Cleared")
        }
        this.stringBuffer.append(string)
    }

    //ActualPlatform
    override def toString() : String = {
        return new StringMaker().append(super.toString()).append(this.stringBuffer.toString()).toString()
    }

}

object GameStatisticsFactory {
    private val instance : GameStatisticsFactory = new GameStatisticsFactory()

    //ActualPlatform
    def getInstance() : GameStatisticsFactory = {
        return GameStatisticsFactory.instance
    }

}


