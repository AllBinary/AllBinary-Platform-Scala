/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.game.ag.ai

import _root_.org.allbinary.ai.ArtificialIntelligenceInterface
import _root_.org.allbinary.bounds.TopULayerBounds
import _root_.org.allbinary.game.ai.ArtificialIntelligenceInterfaceFactoryInterface
import _root_.org.allbinary.game.input.GameInput
import _root_.org.allbinary.game.physics.velocity.VelocityInterface
import _root_.org.allbinary.game.physics.velocity.VelocityInterfaceCompositeInterface
import _root_.org.allbinary.graphics.GPoint
import _root_.org.allbinary.graphics.PointFactory
import _root_.org.allbinary.graphics.Rectangle
import _root_.org.allbinary.graphics.displayable.DisplayInfoSingleton
import _root_.org.allbinary.layer.AllBinaryLayer
import _root_.org.allbinary.util.ABHashtable

class TopUBoundBounceAIFactory extends ArtificialIntelligenceInterfaceFactoryInterface {

    override def getInstance(hashtable : ABHashtable[Object, Object], ownerLayerInterface : AllBinaryLayer, gameInput : GameInput) : ArtificialIntelligenceInterface = {
        val velocityInterfaceCompositeInterface : VelocityInterfaceCompositeInterface = ownerLayerInterface.asInstanceOf[VelocityInterfaceCompositeInterface]
        val velocityInterface : VelocityInterface = velocityInterfaceCompositeInterface.getVelocityProperties().asInstanceOf[VelocityInterface]
        val maxDistancePerTick : Int = (velocityInterface.getMaxForwardVelocity() >> velocityInterface.getVelocityXBasicDecimalP().getScaledFactor())
        // / 2;
        val halfWidth : Int = ((ownerLayerInterface.getWidth() * 2) + maxDistancePerTick) + 1
        // / 2;
        val halfHeight : Int = ((ownerLayerInterface.getHeight() * 2) + maxDistancePerTick) + 1
        // + 90 is for DoNotLoseYourBalls
        val point : GPoint = PointFactory.getInstance().createXY(halfWidth, halfHeight + 60)
        val displayInfo : DisplayInfoSingleton = DisplayInfoSingleton.getInstance()
        val rectangle : Rectangle = new Rectangle(point, ((displayInfo.getLastWidth() - halfWidth) - point.getX()), ((displayInfo.getLastHeight() - halfHeight) - point.getY()))
        return new BoundBounceAI(ownerLayerInterface, gameInput, new TopULayerBounds(rectangle), new ReverseVelocityBoundsVisitor(ownerLayerInterface))
    }

}


