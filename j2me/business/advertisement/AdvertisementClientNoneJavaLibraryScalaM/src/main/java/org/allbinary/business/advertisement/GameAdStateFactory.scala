/* Generated Code Do Not Modify */
package org.allbinary.business.advertisement

import _root_.org.allbinary.game.GameAdState
import _root_.org.allbinary.logic.system.SoftwareInformation

class GameAdStateFactory extends GameAdStateFactoryInterface {
    import _root_.org.allbinary.business.advertisement.GameAdStateFactory.{*}

    private val gameAdStateArray : Array[GameAdState] = Array[GameAdState](new GameAdState(new AppNameLicensingAdConfiguration()))

    private var gameAdState : GameAdState = this.gameAdStateArray(0)

    def getCurrentInstance() : GameAdState = {
        return this.gameAdState
    }

    override def getInstanceForApp(softwareInformation : SoftwareInformation) : GameAdStateBase = {
        //{
        this.gameAdState = this.gameAdStateArray(0)
        return this.gameAdStateArray(0)
    }

    def isEnabled() : Boolean = {
        return false
    }

}

object GameAdStateFactory {
    private val instance : GameAdStateFactory = new GameAdStateFactory()

    def getInstance() : GameAdStateFactory = {
        return GameAdStateFactory.instance
    }

}


