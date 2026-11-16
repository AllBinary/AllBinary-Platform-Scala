/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.game


class PlayerTypesFactory {
    import _root_.org.allbinary.game.PlayerTypesFactory.{*}

    val PLAYER_TYPE_ONE : PlayerType = new PlayerType("Player Type One", 0)

    val PLAYER_TYPE_TWO : PlayerType = new PlayerType("Player Type Two", 1)

    val PLAYER_TYPE_THREE : PlayerType = new PlayerType("Player Type Three", 2)

}

object PlayerTypesFactory {
    private val SINGLETON : PlayerTypesFactory = new PlayerTypesFactory()

    def getInstance() : PlayerTypesFactory = {
        return PlayerTypesFactory.SINGLETON
    }

}


