/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.game.configuration.persistance


class GameConfigurationPersistanceSingleton private() extends KeyValuePersistance(GamePersistanceStrings.getInstance().SAVED_GAME_CONFIGURATION_RECORD_ID) {
    import _root_.org.allbinary.game.configuration.persistance.GameConfigurationPersistanceSingleton.{*}

}

object GameConfigurationPersistanceSingleton {
    private var GAME_PERSISTANCE : GameConfigurationPersistanceSingleton = new GameConfigurationPersistanceSingleton()

    def getInstance() : GameConfigurationPersistanceSingleton = {
        return GameConfigurationPersistanceSingleton.GAME_PERSISTANCE
    }

}


