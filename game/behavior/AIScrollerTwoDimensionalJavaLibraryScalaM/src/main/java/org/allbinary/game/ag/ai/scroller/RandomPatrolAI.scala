/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.game.ag.ai.scroller

import _root_.javax.microedition.lcdui.Canvas
import _root_.org.allbinary.game.input.GameInput
import _root_.org.allbinary.game.rand.MyRandomFactory
import _root_.org.allbinary.layer.AllBinaryLayer
import _root_.org.allbinary.layer.AllBinaryLayerManager
import _root_.org.allbinary.util.ABHashtable

class RandomPatrolAI(param_hashtable : ABHashtable[Object, Object], param_ownerLayerInterface : AllBinaryLayer, param_gameInput : GameInput) extends BasePatrolAI(param_hashtable, param_ownerLayerInterface, param_gameInput) {

    private var changedDirection : Boolean = true

    //Constructor
    {
        val hashtable : ABHashtable[Object, Object] = param_hashtable
        val ownerLayerInterface : AllBinaryLayer = param_ownerLayerInterface
        val gameInput : GameInput = param_gameInput
        this.updateRandomDistance()
    }

    private def updateRandomDistance() : Unit = {
        this.currentDistance = MyRandomFactory.getInstance().getAbsoluteNextInt(this.maxDistance.intValue())
    }

    override def processAI(allBinaryLayerManager : AllBinaryLayerManager) : Unit = {
        // this.logUtil.putF(this.commonStrings.START, this, this.commonStrings.PROCESS);
        super.update()
        super.processKeyAI(this.keyDirection)
        if (this.changedDirection) {
            // PreLogUtil.put("Fire", this, this.commonStrings.PROCESS);
            super.processKeyAI(Canvas.KEY_NUM1)
            this.updateRandomDistance()
            this.changedDirection = false
        }
    }

    override def nextDirection() : Unit = {
        super.nextDirection()
        this.changedDirection = true
    }

}


