/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.game.init


class BasicBuildGameInitializerFactory extends GameInitializationInterfaceFactoryInterface {
    import _root_.org.allbinary.game.init.BasicBuildGameInitializerFactory.{*}

    //private static GameInitializationInterface STATIC = new BaseGameInitialization(0);
    override def getInstance() : GameInitializationInterface = {
        return BaseGameInitialization.NULL_BASE_GAME_INITIALIZATION
    }

}

object BasicBuildGameInitializerFactory {
    var NULL_BASE_BUILD_GMAE_INITIALIZER_FACTORY : BasicBuildGameInitializerFactory = new BasicBuildGameInitializerFactory()

}


