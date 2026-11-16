/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.game.configuration.persistance


class GameDifficultyFactory {
    import _root_.org.allbinary.game.configuration.persistance.GameDifficultyFactory.{*}

    private var level : Int = 0

    def setLevel(level : Int) : Unit = {
        this.level = level
    }

    def getLevel() : Int = {
        return this.level
    }

}

object GameDifficultyFactory {
    private val instance : GameDifficultyFactory = new GameDifficultyFactory()

    def getInstance() : GameDifficultyFactory = {
        return GameDifficultyFactory.instance
    }

}


