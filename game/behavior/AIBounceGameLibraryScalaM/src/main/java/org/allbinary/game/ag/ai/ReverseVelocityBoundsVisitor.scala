/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.game.ag.ai

import _root_.org.allbinary.bounds.BoundsVisitorInterface
import _root_.org.allbinary.game.physics.velocity.VelocityInterface
import _root_.org.allbinary.game.physics.velocity.VelocityInterfaceCompositeInterface
import _root_.org.allbinary.layer.LayerInterface
import _root_.org.allbinary.logic.communication.log.LogUtil

class ReverseVelocityBoundsVisitor(param_layerInterface : LayerInterface) extends BoundsVisitorInterface {

    val logUtil : LogUtil = LogUtil.getInstance()

    //private GPoint point;
    var velocityInterface : VelocityInterface = null

    //private RotationAnimationInterface rotationAnimationInterface;
    private var layerInterface : LayerInterface = null

    //GPoint point,
    //Constructor
    {
        val layerInterface : LayerInterface = param_layerInterface
        this.layerInterface = layerInterface
        //this.rotationAnimationInterface = rotationAnimationInterfaceCompositeInterface.getRotationAnimationInterface();
        var velocityInterfaceCompositeInterface : VelocityInterfaceCompositeInterface = layerInterface.asInstanceOf[VelocityInterfaceCompositeInterface]
        this.velocityInterface = velocityInterfaceCompositeInterface.getVelocityProperties().asInstanceOf[VelocityInterface]
    }

    override def getX() : Int = {
        return this.layerInterface.getXP()
    }

    override def getY() : Int = {
        return this.layerInterface.getYP()
    }

    override def minX() : Unit = {
        //this.refract();
        if (this.velocityInterface.getVelocityXBasicDecimalP().getUnscaled() < 0) {
            this.velocityInterface.getVelocityXBasicDecimalP().multiplyint(-1)
        }
    }

    override def maxX() : Unit = {
        //this.refract();
        if (this.velocityInterface.getVelocityXBasicDecimalP().getUnscaled() > 0) {
            this.velocityInterface.getVelocityXBasicDecimalP().multiplyint(-1)
        }
    }

    override def minY() : Unit = {
        //this.refract();
        if (this.velocityInterface.getVelocityYBasicDecimalP().getUnscaled() < 0) {
            this.velocityInterface.getVelocityYBasicDecimalP().multiplyint(-1)
        }
    }

    override def maxY() : Unit = {
        //this.refract();
        if (this.velocityInterface.getVelocityYBasicDecimalP().getUnscaled() > 0) {
            this.velocityInterface.getVelocityYBasicDecimalP().multiplyint(-1)
        }
    }

}


