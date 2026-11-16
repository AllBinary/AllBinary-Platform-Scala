/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.game.midlet


class DemoGameMidletStateFactory private() {
    import _root_.org.allbinary.game.midlet.DemoGameMidletStateFactory.{*}

    val NONE : DemoGameMidletState = new DemoGameMidletState()

    val START_DEMO : DemoGameMidletState = new DemoGameMidletState()

    val START_GAME : DemoGameMidletState = new DemoGameMidletState()

    val START_INPUT_MAPPING : DemoGameMidletState = new DemoGameMidletState()

}

object DemoGameMidletStateFactory {
    private var STATE : DemoGameMidletStateFactory = new DemoGameMidletStateFactory()

    def getInstance() : DemoGameMidletStateFactory = {
        return DemoGameMidletStateFactory.STATE
    }

}


