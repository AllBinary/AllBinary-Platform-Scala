/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.business.advertisement

import _root_.org.allbinary.game.GameAdState
import _root_.org.allbinary.graphics.displayable.DisplayInfoSingleton

class BottomLimiter private() {
    import _root_.org.allbinary.business.advertisement.BottomLimiter.{*}

    private var bottom : Int = 0

    private var deltaY : Int = 0

    private var lower : Int = 0

    private var higher : Int = 0

    def init(lower : Int, higher : Int) : Unit = {
        this.lower = lower
        this.higher = higher
    }

    def update() : Unit = {
        var displayInfo : DisplayInfoSingleton = DisplayInfoSingleton.getInstance()
        //deltaY = 68;
        var gameAdState : GameAdState = GameAdStateFactory.getInstance().getCurrentInstance()
        if (gameAdState.isShowingAt()) {
            //PreLogUtil.put("Ad Showing Bottom", this, GameStrings.getInstance().PROCESS_TICK);
            this.deltaY = this.higher
        } else {
            //PreLogUtil.put("No Ad Bottom", this, GameStrings.getInstance().PROCESS_TICK);
            this.deltaY = this.lower
        }
        this.bottom = displayInfo.getLastHeight() - this.deltaY
    }

    def getDeltaY() : Int = {
        return this.deltaY
    }

    def getBottom() : Int = {
        return this.bottom
    }

}

object BottomLimiter {
    //protected final LogUtil logUtil = LogUtil.getInstance();
    private val instance : BottomLimiter = new BottomLimiter()

    def getInstance() : BottomLimiter = {
        return BottomLimiter.instance
    }

}


