/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.game.ag.ai

import _root_.javax.microedition.lcdui.Canvas
import _root_.org.allbinary.game.ai.BasicAI
import _root_.org.allbinary.game.input.GameInput
import _root_.org.allbinary.layer.AllBinaryLayer
import _root_.org.allbinary.layer.AllBinaryLayerManager

class SpinnerAI(param_direction : Array[Int], param_ownerLayerInterface : AllBinaryLayer, param_gameInput : GameInput) extends BasicAI(param_ownerLayerInterface, param_gameInput) {

    private var isEven : Boolean = false

    //private IndexedAnimation rotationAnimationInterface;
    private var direction : Array[Int] = null

    //int fireAngles[],
    //Constructor
    {
        val direction : Array[Int] = param_direction
        val ownerLayerInterface : AllBinaryLayer = param_ownerLayerInterface
        val gameInput : GameInput = param_gameInput
        this.direction = direction
    }

    override def processAI(allBinaryLayerManager : AllBinaryLayerManager) : Unit = {
        if (this.isEven) {
            super.processKeyAI(this.direction(0))
            this.isEven = false
        } else {
            super.processKeyAI(Canvas.KEY_NUM1)
            this.isEven = true
        }
    }

}


