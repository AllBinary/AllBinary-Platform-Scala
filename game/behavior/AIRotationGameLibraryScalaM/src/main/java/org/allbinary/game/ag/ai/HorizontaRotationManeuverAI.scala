/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.game.ag.ai

import _root_.javax.microedition.lcdui.Canvas
import _root_.org.allbinary.ai.ArtificialIntelligence
import _root_.org.allbinary.ai.ArtificialIntelligenceTransitionInterface
import _root_.org.allbinary.animation.IndexedAnimation
import _root_.org.allbinary.animation.RotationAnimationInterface
import _root_.org.allbinary.animation.RotationAnimationInterfaceCompositeInterface
import _root_.org.allbinary.game.ai.BasicAI
import _root_.org.allbinary.game.input.GameInput
import _root_.org.allbinary.game.physics.velocity.BasicVelocityProperties
import _root_.org.allbinary.game.physics.velocity.VelocityInterface
import _root_.org.allbinary.game.physics.velocity.VelocityInterfaceCompositeInterface
import _root_.org.allbinary.graphics.displayable.DisplayInfoSingleton
import _root_.org.allbinary.layer.AllBinaryLayer
import _root_.org.allbinary.layer.AllBinaryLayerManager
import _root_.org.allbinary.math.AngleIncrementInfo
import _root_.org.allbinary.util.CircularIndexUtil

class HorizontaRotationManeuverAI(param_ownerLayerInterface : AllBinaryLayer, param_gameInput : GameInput) extends BasicAI(param_ownerLayerInterface, param_gameInput) with ArtificialIntelligenceTransitionInterface {

    private val circularIndexUtil : CircularIndexUtil = CircularIndexUtil.createInstanceAt(10, Integer.MAX_VALUE)

    private var currentSpeedDivisor : Int = 5

    private var rotationAnimationInterface : IndexedAnimation = null

    private var baseVelocityInterface : BasicVelocityProperties = null

    private var velocityInterface : VelocityInterface = null

    //Constructor
    {
        val ownerLayerInterface : AllBinaryLayer = param_ownerLayerInterface
        val gameInput : GameInput = param_gameInput
        val rotationAnimationInterfaceCompositeInterface : RotationAnimationInterfaceCompositeInterface = this.getOwnerLayerInterface().asInstanceOf[RotationAnimationInterfaceCompositeInterface]
        this.rotationAnimationInterface = rotationAnimationInterfaceCompositeInterface.getRotationAnimationInterface()
        var velocityInterfaceCompositeInterface : VelocityInterfaceCompositeInterface = this.getOwnerLayerInterface().asInstanceOf[VelocityInterfaceCompositeInterface]
        this.baseVelocityInterface = velocityInterfaceCompositeInterface.getVelocityProperties()
        this.velocityInterface = this.baseVelocityInterface.asInstanceOf[VelocityInterface]
        //this.transition();
        val rotationAnimationInterface : RotationAnimationInterface = this.rotationAnimationInterface.asInstanceOf[RotationAnimationInterface]
        val angleIncrementInfo : AngleIncrementInfo = rotationAnimationInterface.getAngleInfoP().getAngleIncrementInfo()
        rotationAnimationInterfaceCompositeInterface.setFrame(angleIncrementInfo.RIGHT_FRAME.intValue())
    }

    override def transition() : Unit = {
        val rotationAnimationInterface : RotationAnimationInterface = this.rotationAnimationInterface.asInstanceOf[RotationAnimationInterface]
        val angleIncrementInfo : AngleIncrementInfo = rotationAnimationInterface.getAngleInfoP().getAngleIncrementInfo()
        val rotationAnimationInterfaceCompositeInterface : RotationAnimationInterfaceCompositeInterface = this.getOwnerLayerInterface().asInstanceOf[RotationAnimationInterfaceCompositeInterface]
        rotationAnimationInterfaceCompositeInterface.setFrame(angleIncrementInfo.RIGHT_FRAME.intValue())
        //TWB - Hack to deal with enemies flying away when off screen
        var allbinaryLayer : AllBinaryLayer = this.getOwnerLayerInterface()
        allbinaryLayer.setPosition(allbinaryLayer.getXP(), 1, allbinaryLayer.getZP())
    }

    override def processAI(allBinaryLayerManager : AllBinaryLayerManager) : Unit = {
        //this.logUtil.putF("Angle: " + currentAngle + " X: " + x + " Y: " + y, this, this.commonStrings.PROCESS);
        val rotationAnimationInterface : RotationAnimationInterface = (this.rotationAnimationInterface.asInstanceOf[RotationAnimationInterface])
        val angleIncrementInfo : AngleIncrementInfo = rotationAnimationInterface.getAngleInfoP().getAngleIncrementInfo()
        val frame : Int = this.rotationAnimationInterface.getFrame()
        val ownerLayerInterface : AllBinaryLayer = this.getOwnerLayerInterface()
        if (((ownerLayerInterface.getXP() - ownerLayerInterface.getWidth()) <= 0) && (frame == angleIncrementInfo.LEFT_FRAME.intValue())) {
            this.reverse()
            this.drop()
        }
        val displayInfo : DisplayInfoSingleton = DisplayInfoSingleton.getInstance()
        if (((ownerLayerInterface.getX2() + ownerLayerInterface.getWidth()) > displayInfo.getLastWidth()) && (frame == angleIncrementInfo.RIGHT_FRAME.intValue())) {
            this.reverse()
            this.accelerate()
            this.drop()
        }
        val index : Int = this.circularIndexUtil.getIndex()
        if (((index % this.currentSpeedDivisor) == 0) && ((index % 2) == 0)) {
            super.processKeyAI(Canvas.UP)
            this.velocityInterface.limitMaxXYVelocity(this.velocityInterface.getMaxForwardVelocity() / this.currentSpeedDivisor)
        }
        this.circularIndexUtil.next()
        if (frame == angleIncrementInfo.LEFT_FRAME.intValue()) {
            super.processKeyAI(Canvas.KEY_NUM0)
        } else if (frame == angleIncrementInfo.RIGHT_FRAME.intValue()) {
            super.processKeyAI(Canvas.KEY_POUND)
        }
    }

    def reverse() : Unit = {
        val rotationAnimationInterface : RotationAnimationInterface = this.rotationAnimationInterface.asInstanceOf[RotationAnimationInterface]
        val angleIncrementInfo : AngleIncrementInfo = rotationAnimationInterface.getAngleInfoP().getAngleIncrementInfo()
        val frame : Int = this.rotationAnimationInterface.getFrame()
        if (frame == angleIncrementInfo.LEFT_FRAME.intValue()) {
            val rotationAnimationInterfaceCompositeInterface : RotationAnimationInterfaceCompositeInterface = this.getOwnerLayerInterface().asInstanceOf[RotationAnimationInterfaceCompositeInterface]
            rotationAnimationInterfaceCompositeInterface.setFrame(angleIncrementInfo.RIGHT_FRAME.intValue())
            this.baseVelocityInterface.zero()
        } else if (frame == angleIncrementInfo.RIGHT_FRAME.intValue()) {
            val rotationAnimationInterfaceCompositeInterface : RotationAnimationInterfaceCompositeInterface = this.getOwnerLayerInterface().asInstanceOf[RotationAnimationInterfaceCompositeInterface]
            rotationAnimationInterfaceCompositeInterface.setFrame(angleIncrementInfo.LEFT_FRAME.intValue())
            this.baseVelocityInterface.zero()
        }
    }

    private def accelerate() : Unit = {
        if (this.currentSpeedDivisor > 1) {
            this.currentSpeedDivisor -= 1
        }
    }

    private def drop() : Unit = {
        val displayInfo : DisplayInfoSingleton = DisplayInfoSingleton.getInstance()
        val ownerLayerInterface : AllBinaryLayer = this.getOwnerLayerInterface()
        var y : Int = ownerLayerInterface.getYP()
        if ((ownerLayerInterface.getY2() + ownerLayerInterface.getHeight()) > displayInfo.getLastHeight()) {
            y = 0
        } else {
            y += ownerLayerInterface.getHeight() + 1
        }
        ownerLayerInterface.setPosition(ownerLayerInterface.getXP(), y, ownerLayerInterface.getZP())
    }

    override def getId() : Int = {
        return ArtificialIntelligence.AI_ID
    }

}


