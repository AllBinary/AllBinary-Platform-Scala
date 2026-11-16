/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.game


class BasicHighScoresGameInfoFactory {
    import _root_.org.allbinary.game.BasicHighScoresGameInfoFactory.{*}

    //  new GameInfo(GameType.MULTI_PLAYER, GameMode.CLIENT, 0, 0);
    val MULTI_PLAYER_SERVER : GameInfo = new GameInfo(GameTypeFactory.getInstance().MULTI_PLAYER, GameMode.SERVER, PlayerTypesFactory.getInstance().PLAYER_TYPE_ONE, 0, 0)

    //  new GameInfo(GameType.SINGLE_PLAYER, GameMode.CLIENT, 0, 0);
    val SINGLE_PLAYER_SERVER : GameInfo = new GameInfo(GameTypeFactory.getInstance().SINGLE_PLAYER, GameMode.SERVER, PlayerTypesFactory.getInstance().PLAYER_TYPE_ONE, 0, 0)

}

object BasicHighScoresGameInfoFactory {
    private val SINGLETON : BasicHighScoresGameInfoFactory = new BasicHighScoresGameInfoFactory()

    def getInstance() : BasicHighScoresGameInfoFactory = {
        return BasicHighScoresGameInfoFactory.SINGLETON
    }

}


