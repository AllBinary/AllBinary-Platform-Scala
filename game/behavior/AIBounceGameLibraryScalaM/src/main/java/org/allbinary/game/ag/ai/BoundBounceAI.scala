/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.game.ag.ai

import _root_.javax.microedition.lcdui.Graphics
import _root_.org.allbinary.bounds.BoundsVisitorInterface
import _root_.org.allbinary.bounds.LayerBounds
import _root_.org.allbinary.game.ai.BasicAI
import _root_.org.allbinary.game.input.GameInput
import _root_.org.allbinary.graphics.Rectangle
import _root_.org.allbinary.layer.AllBinaryLayer
import _root_.org.allbinary.layer.AllBinaryLayerManager

class BoundBounceAI(param_ownerLayerInterface : AllBinaryLayer, param_gameInput : GameInput, param_layerBounds : LayerBounds, param_boundsVisitorInterface : BoundsVisitorInterface) extends BasicAI(param_ownerLayerInterface, param_gameInput) {

    var currentRelativeAngle : Int = 0

    //private int currentSpeed;
    private var layerBounds : LayerBounds = null

    private var boundsVisitorInterface : BoundsVisitorInterface = null

    //Constructor
    {
        val ownerLayerInterface : AllBinaryLayer = param_ownerLayerInterface
        val gameInput : GameInput = param_gameInput
        val layerBounds : LayerBounds = param_layerBounds
        val boundsVisitorInterface : BoundsVisitorInterface = param_boundsVisitorInterface
        this.layerBounds = layerBounds
        this.boundsVisitorInterface = boundsVisitorInterface
    }

    def paint(graphics : Graphics) : Unit = {
        val rectange : Rectangle = this.layerBounds.getRectangleP()
        graphics.drawRect(rectange.getPoint().getX(), rectange.getPoint().getY(), rectange.getWidth(), rectange.getHeight())
    }

    override def processAI(allBinaryLayerManager : AllBinaryLayerManager) : Unit = {
        this.layerBounds.visit(this.boundsVisitorInterface)
    }

}


