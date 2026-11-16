/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.game.ag.ai

import _root_.org.allbinary.animation.IndexedAnimation
import _root_.org.allbinary.animation.RotationAnimationInterface
import _root_.org.allbinary.animation.RotationAnimationInterfaceCompositeInterface
import _root_.org.allbinary.game.ag.ai.tactical.LurchAI
import _root_.org.allbinary.game.input.GameInput
import _root_.org.allbinary.layer.AllBinaryLayer
import _root_.org.allbinary.math.AngleIncrementInfo

class LurchRotationAI(param_ownerLayerInterface : AllBinaryLayer, param_gameInput : GameInput) extends LurchAI(param_ownerLayerInterface, param_gameInput) {

    private var rotationAnimationInterface : IndexedAnimation = null

    //Constructor
    {
        val ownerLayerInterface : AllBinaryLayer = param_ownerLayerInterface
        val gameInput : GameInput = param_gameInput
        val rotationAnimationInterfaceCompositeInterface : RotationAnimationInterfaceCompositeInterface = this.getOwnerLayerInterface().asInstanceOf[RotationAnimationInterfaceCompositeInterface]
        this.rotationAnimationInterface = rotationAnimationInterfaceCompositeInterface.getRotationAnimationInterface()
        this.update()
    }

    override def reverse() : Unit = {
        super.reverse()
        this.update()
    }

    private def update() : Unit = {
        //this.logUtil.putF("Angle: " + currentAngle, this, "reverse");
        if (this.currentRelativeAngle == 0) {
            val rotationAnimationInterface : RotationAnimationInterface = this.rotationAnimationInterface.asInstanceOf[RotationAnimationInterface]
            val angleIncrementInfo : AngleIncrementInfo = rotationAnimationInterface.getAngleInfoP().getAngleIncrementInfo()
            val rotationAnimationInterfaceCompositeInterface : RotationAnimationInterfaceCompositeInterface = this.getOwnerLayerInterface().asInstanceOf[RotationAnimationInterfaceCompositeInterface]
            rotationAnimationInterfaceCompositeInterface.setFrame(angleIncrementInfo.RIGHT_FRAME.intValue())
        } else if (this.currentRelativeAngle == 180) {
            val rotationAnimationInterface : RotationAnimationInterface = this.rotationAnimationInterface.asInstanceOf[RotationAnimationInterface]
            val angleIncrementInfo : AngleIncrementInfo = rotationAnimationInterface.getAngleInfoP().getAngleIncrementInfo()
            val rotationAnimationInterfaceCompositeInterface : RotationAnimationInterfaceCompositeInterface = this.getOwnerLayerInterface().asInstanceOf[RotationAnimationInterfaceCompositeInterface]
            rotationAnimationInterfaceCompositeInterface.setFrame(angleIncrementInfo.LEFT_FRAME.intValue())
        }
    }

}


