/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.game.configuration


class GameSpeed {
    import _root_.org.allbinary.game.configuration.GameSpeed.{*}

    final def getSpeed() : Int = {
        var speedGameConfiguration : GameConfiguration = GameConfigurationCentral.getInstance().SPEED
        return ((speedGameConfiguration.getMaxValue().intValue() - speedGameConfiguration.getValue().intValue()) + 1)
    }

    final def getDelay() : Int = {
        var speedGameConfiguration : GameConfiguration = GameConfigurationCentral.getInstance().SPEED
        return 19 * (speedGameConfiguration.getMaxValue().intValue() - speedGameConfiguration.getValue().intValue())
    }

}

object GameSpeed {
    private val instance : GameSpeed = new GameSpeed()

    def getInstance() : GameSpeed = {
        return GameSpeed.instance
    }

}


