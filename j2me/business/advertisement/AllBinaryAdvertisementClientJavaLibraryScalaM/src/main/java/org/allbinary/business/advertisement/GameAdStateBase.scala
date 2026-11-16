/*  * AllBinary Open License Version 1  * Copyright (c) 2025 AllBinary  *   * By agreeing to this license you and any business entity you represent are  * legally bound to the AllBinary Open License Version 1 legal agreement.  *   * You may obtain the AllBinary Open License Version 1 legal agreement from  * AllBinary or the root directory of AllBinary's AllBinary Platform repository.  *   * Created By: Travis Berthelot  *   */
/* Generated Code Do Not Modify */
package org.allbinary.business.advertisement

import _root_.org.allbinary.game.GameType
import _root_.org.allbinary.game.state.GameState
import _root_.org.allbinary.logic.communication.log.ForcedLogUtil
import _root_.org.allbinary.logic.util.event.AllBinaryEventObject
import _root_.org.allbinary.logic.util.event.EventStrings

/**  *  * @author User  */
class GameAdStateBase(param_adConfiguration : AdConfiguration) {

    //protected final LogUtil logUtil = LogUtil.getInstance();
    var adConfigurationP : AdConfiguration = null

    val advertisementsP : Advertisements = new Advertisements()

    var okayToShowAdsP : Boolean = false

    //Constructor
    {
        val adConfiguration : AdConfiguration = param_adConfiguration
        this.adConfigurationP = adConfiguration
    }

    def initViewArray(viewArray : Array[Object]) : Unit = {
    }

    def onStart(anyType : Object) : Unit = {
        this.init()
    }

    def init() : Unit = {
    }

    def isShowingAtLocation(location : Int) : Boolean = {
        return false
    }

    def isShowingAt() : Boolean = {
        return false
    }

    def show() : Unit = {
    }

    def hide() : Unit = {
    }

    def onEvent(eventObject : AllBinaryEventObject) : Unit = {
        ForcedLogUtil.log(EventStrings.getInstance().PERFORMANCE_MESSAGE, this)
    }

    def processAdState(gameState : GameState, gameType : GameType) : Unit = {
    }

    def processPageAdState() : Unit = {
    }

    def playingAdState() : Unit = {
    }

    //Paying players don't need to see the adverts in game
    def playingAdStateWH(width : Int, height : Int) : Unit = {
    }

    def notPlayingAdState() : Unit = {
    }

    def setGameIsReady(gameIsReady : Boolean) : Unit = {
    }

    def isGameIsReady() : Boolean = {
        return false
    }

    def getAdvertisements() : Advertisements = {
        return this.advertisementsP
    }

    def getAdConfiguration() : AdConfiguration = {
        return this.adConfigurationP
    }

    def isOkayToShowPageAd() : Boolean = {
        return false
    }

    def setOkayToShowAds(okayToShowAds : Boolean) : Unit = {
        this.okayToShowAdsP = okayToShowAds
    }

    def isOkayToShowAds() : Boolean = {
        return this.okayToShowAdsP
    }

    def isEnabled() : Boolean = {
        return false
    }

}


