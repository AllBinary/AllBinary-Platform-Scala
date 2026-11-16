/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.business.advertisement

import _root_.org.allbinary.direction.Direction
import _root_.org.allbinary.game.state.GameState

class AdConfiguration(param_advertIdArray : Array[Object]) {

    var INNERACTIVE : String = null

    var LEADBOLT : String = null

    var ADMOB : String = null

    //Constructor
    {
        val advertIdArray : Array[Object] = param_advertIdArray
        this.INNERACTIVE = advertIdArray(0).asInstanceOf[String]
        this.ADMOB = advertIdArray(1).asInstanceOf[String]
        this.LEADBOLT = advertIdArray(2).asInstanceOf[String]
    }

    def getValidAdSpots() : Array[Direction] = {
        return new Array[Direction](0)
    }

    //Special in gamestate based processing
    def process(gameState : GameState) : Unit = {
    }

    //Special Demo processing
    def processDemo(state : Int) : Unit = {
    }

    def setShowAds() : Unit = {
    }

    def setToggleAds(showAds : Boolean) : Unit = {
    }

    def isShowAds() : Boolean = {
        return true
    }

}


