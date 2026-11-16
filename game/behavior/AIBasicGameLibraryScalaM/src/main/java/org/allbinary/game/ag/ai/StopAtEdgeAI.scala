/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.game.ag.ai

import _root_.org.allbinary.game.ai.BasicAI
import _root_.org.allbinary.game.input.GameInput
import _root_.org.allbinary.game.physics.velocity.BasicVelocityProperties
import _root_.org.allbinary.game.physics.velocity.VelocityInterfaceCompositeInterface
import _root_.org.allbinary.graphics.displayable.DisplayInfoSingleton
import _root_.org.allbinary.layer.AllBinaryLayer
import _root_.org.allbinary.layer.AllBinaryLayerManager

class StopAtEdgeAI(param_ownerLayerInterface : AllBinaryLayer, param_gameInput : GameInput) extends BasicAI(param_ownerLayerInterface, param_gameInput) {

    //Constructor
    {
        val ownerLayerInterface : AllBinaryLayer = param_ownerLayerInterface
        val gameInput : GameInput = param_gameInput
    }

    override def processAI(allBinaryLayerManager : AllBinaryLayerManager) : Unit = {
        val ownerLayerInterface : AllBinaryLayer = this.getOwnerLayerInterface()
        val velocityInterfaceCompositeInterface : VelocityInterfaceCompositeInterface = (ownerLayerInterface.asInstanceOf[VelocityInterfaceCompositeInterface])
        val velocityProperties : BasicVelocityProperties = velocityInterfaceCompositeInterface.getVelocityProperties()
        val x : Int = ownerLayerInterface.getXP()
        val y : Int = ownerLayerInterface.getYP()
        val x2 : Int = ownerLayerInterface.getX2()
        val y2 : Int = ownerLayerInterface.getY2()
        val width : Int = ownerLayerInterface.getWidth()
        val height : Int = ownerLayerInterface.getHeight()
        val displayInfo : DisplayInfoSingleton = DisplayInfoSingleton.getInstance()
        if ((x2 + velocityProperties.getVelocityXBasicDecimalP().getScaled()) > displayInfo.getLastWidth()) {
            ownerLayerInterface.setPosition(displayInfo.getLastWidth() - width, y, ownerLayerInterface.getZP())
            //ownerLayerInterface.setPosition(width + 1, y);
            velocityProperties.getVelocityYBasicDecimalP().setint(0)
        }
        if ((y2 + velocityProperties.getVelocityYBasicDecimalP().getScaled()) > displayInfo.getLastHeight()) {
            //ownerLayerInterface.setPosition(x, height + 1);
            ownerLayerInterface.setPosition(x, displayInfo.getLastHeight() - height, ownerLayerInterface.getZP())
            velocityProperties.getVelocityXBasicDecimalP().setint(0)
        }
        if ((x + velocityProperties.getVelocityXBasicDecimalP().getScaled()) < 0) {
            ownerLayerInterface.setPosition(0, y, ownerLayerInterface.getZP())
            velocityProperties.getVelocityYBasicDecimalP().setint(0)
        }
        if ((y + velocityProperties.getVelocityYBasicDecimalP().getScaled()) < 0) {
            ownerLayerInterface.setPosition(x, 0, ownerLayerInterface.getZP())
            velocityProperties.getVelocityXBasicDecimalP().setint(0)
        }
    }

}


