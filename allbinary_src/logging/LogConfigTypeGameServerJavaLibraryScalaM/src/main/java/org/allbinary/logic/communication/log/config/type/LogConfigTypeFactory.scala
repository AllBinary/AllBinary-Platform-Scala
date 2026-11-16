/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.logic.communication.log.config.`type`

import _root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes
import _root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory

/**  *  * @author user  */
class LogConfigTypeFactory private() {
    import _root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.{*}

    private val NO_DESCRIPTION : String = "No Description"

    val INIT_SERVER : LogConfigType = new LogConfigType("Init Server", this.NO_DESCRIPTION)

    val LOBBY_SERVER : LogConfigType = new LogConfigType("Lobby Server", this.NO_DESCRIPTION)

    val GAME_SERVER : LogConfigType = new LogConfigType("Game Server", this.NO_DESCRIPTION)

    val GAME_SIMULATOR : LogConfigType = new LogConfigType("Game Simulator", this.NO_DESCRIPTION)

    val CUSTOM_TYPES : LogConfigType = new LogConfigType("Custom Types", this.NO_DESCRIPTION)

    //Constructor
    {
        LogConfigTypes.LOGGING.add(this.INIT_SERVER)
    }

}

object LogConfigTypeFactory {
    private val instance : LogConfigTypeFactory = new LogConfigTypeFactory()

    /**      * @return the instance      */
    def getInstance() : LogConfigTypeFactory = {
        return LogConfigTypeFactory.instance
    }

}


