/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.game.ag.ai.scroller

import _root_.javax.microedition.lcdui.Canvas
import _root_.org.allbinary.game.ai.BasicAI
import _root_.org.allbinary.game.input.GameInput
import _root_.org.allbinary.layer.AllBinaryLayer
import _root_.org.allbinary.layer.AllBinaryLayerManager
import _root_.org.allbinary.logic.math.SmallIntegerSingletonFactory
import _root_.org.allbinary.time.GameTickTimeDelayHelperFactory
import _root_.org.allbinary.time.TimeDelayHelper

class TimedFireAI(param_delay : Int, param_ownerLayerInterface : AllBinaryLayer, param_gameInput : GameInput) extends BasicAI(param_ownerLayerInterface, param_gameInput) {
    import _root_.org.allbinary.game.ag.ai.scroller.TimedFireAI.{TIME as _, *}
    def TIME : Integer = _root_.org.allbinary.game.ag.ai.scroller.TimedFireAI.TIME

    val maxFireDelayTimeHelper : TimeDelayHelper = new TimeDelayHelper(0)

    private var delay : Int = 0

    //Constructor
    {
        val delay : Int = param_delay
        val ownerLayerInterface : AllBinaryLayer = param_ownerLayerInterface
        val gameInput : GameInput = param_gameInput
        this.delay = delay
    }

    override def processAI(allBinaryLayerManager : AllBinaryLayerManager) : Unit = {
        var timeFiredInterface : TimeFiredInterface = this.getOwnerLayerInterface().asInstanceOf[TimeFiredInterface]
        if (this.maxFireDelayTimeHelper.isTime(GameTickTimeDelayHelperFactory.getInstance().startTime) && ((timeFiredInterface.getLastFireTime() + this.maxFireDelayTimeHelper.delay) < this.maxFireDelayTimeHelper.getStartTime())) {
            super.processKeyAI(Canvas.KEY_NUM1)
            this.maxFireDelayTimeHelper.delay = this.delay
        }
    }

}

object TimedFireAI {
    val TIME : Integer = SmallIntegerSingletonFactory.getInstance().getAt(1)

}


