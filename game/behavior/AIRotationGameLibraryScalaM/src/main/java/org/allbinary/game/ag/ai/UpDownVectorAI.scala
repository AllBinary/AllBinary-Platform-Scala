/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.game.ag.ai

import _root_.org.allbinary.game.ai.BasicAI
import _root_.org.allbinary.game.input.GameInput
import _root_.org.allbinary.game.physics.velocity.BasicVelocityProperties
import _root_.org.allbinary.game.physics.velocity.VelocityInterfaceCompositeInterface
import _root_.org.allbinary.layer.AllBinaryLayer
import _root_.org.allbinary.layer.AllBinaryLayerManager
import _root_.org.allbinary.logic.math.BasicDecimal

class UpDownVectorAI(param_ownerLayerInterface : AllBinaryLayer, param_gameInput : GameInput) extends BasicAI(param_ownerLayerInterface, param_gameInput) {

    private var velocityInterface : BasicVelocityProperties = null

    private var index : Int = 0

    //Constructor
    {
        val ownerLayerInterface : AllBinaryLayer = param_ownerLayerInterface
        val gameInput : GameInput = param_gameInput
        val velocityInterfaceCompositeInterface : VelocityInterfaceCompositeInterface = this.getOwnerLayerInterface().asInstanceOf[VelocityInterfaceCompositeInterface]
        this.velocityInterface = velocityInterfaceCompositeInterface.getVelocityProperties()
        this.velocityInterface.getVelocityYBasicDecimalP().setint(0)
    }

    override def processAI(allBinaryLayerManager : AllBinaryLayerManager) : Unit = {
        //this.logUtil.putF(this.commonStrings.START, this, this.commonStrings.PROCESS);
        val y : Int = this.getOwnerLayerInterface().getHeight() * 270
        if (this.index < 5) {
            val basicDecimal : BasicDecimal = this.velocityInterface.getVelocityYBasicDecimalP()
            basicDecimal.setint(0)
            basicDecimal.addint(y)
            this.index += 1
        } else if (this.index < 10) {
            val basicDecimal : BasicDecimal = this.velocityInterface.getVelocityYBasicDecimalP()
            basicDecimal.setint(0)
            basicDecimal.subtractint(y)
            this.index += 1
        } else {
            this.index = 0
            this.processAI(allBinaryLayerManager)
        }
    }

}


