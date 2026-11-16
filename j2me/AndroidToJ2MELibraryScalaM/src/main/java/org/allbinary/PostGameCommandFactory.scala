/*  * AllBinary Open License Version 1  * Copyright (c) 2022 AllBinary  *   * By agreeing to this license you and any business entity you represent are  * legally bound to the AllBinary Open License Version 1 legal agreement.  *   * You may obtain the AllBinary Open License Version 1 legal agreement from  * AllBinary or the root directory of AllBinary's AllBinary Platform repository.  *   * Created By: Travis Berthelot  *   */
/* Generated Code Do Not Modify */
package org.allbinary

import _root_.org.allbinary.game.commands.GameCommandsFactory
import _root_.org.allbinary.game.configuration.feature.MultiPlayerGameFeatureFactory
import _root_.org.allbinary.graphics.displayable.MyCanvas
import _root_.org.allbinary.logic.system.os.GenericOperatingSystem
import _root_.org.allbinary.logic.system.os.OperatingSystemFactory

/**  *  * @author User  */
class PostGameCommandFactory {
    import _root_.org.allbinary.PostGameCommandFactory.{*}

    def addCommands(canvas : MyCanvas) : Unit = {
        val operatingSystemInterface : GenericOperatingSystem = OperatingSystemFactory.getInstance().getOperatingSystemInstance()
        val gameCommandsFactory : GameCommandsFactory = GameCommandsFactory.getInstance()
        if (!operatingSystemInterface.isOverScan()) {
            canvas.addCommand(gameCommandsFactory.TOGGLE_KEYBOARD)
        }
        MultiPlayerGameFeatureFactory.getInstance().addCommands(canvas)
    }

}

object PostGameCommandFactory {
    private val instance : PostGameCommandFactory = new PostGameCommandFactory()

    /**      * @return the instance      */
    def getInstance() : PostGameCommandFactory = {
        return PostGameCommandFactory.instance
    }

}


