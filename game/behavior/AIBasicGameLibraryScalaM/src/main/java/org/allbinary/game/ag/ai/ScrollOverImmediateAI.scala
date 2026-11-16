/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *   */
/* Generated Code Do Not Modify */
package org.allbinary.game.ag.ai

import _root_.org.allbinary.game.ai.BasicAI
import _root_.org.allbinary.game.input.GameInput
import _root_.org.allbinary.graphics.displayable.DisplayInfoSingleton
import _root_.org.allbinary.layer.AllBinaryLayer
import _root_.org.allbinary.layer.AllBinaryLayerManager

class ScrollOverImmediateAI(param_ownerLayerInterface : AllBinaryLayer, param_gameInput : GameInput) extends BasicAI(param_ownerLayerInterface, param_gameInput) {

    //Constructor
    {
        val ownerLayerInterface : AllBinaryLayer = param_ownerLayerInterface
        val gameInput : GameInput = param_gameInput
    }

    override def processAI(allBinaryLayerManager : AllBinaryLayerManager) : Unit = {
        val ownerLayerInterface : AllBinaryLayer = this.getOwnerLayerInterface()
        val x : Int = ownerLayerInterface.getXP()
        val y : Int = ownerLayerInterface.getYP()
        val x2 : Int = ownerLayerInterface.getX2()
        val y2 : Int = ownerLayerInterface.getY2()
        val width : Int = ownerLayerInterface.getWidth()
        val height : Int = ownerLayerInterface.getHeight()
        var displayInfo : DisplayInfoSingleton = DisplayInfoSingleton.getInstance()
        if (x2 > displayInfo.getLastWidth()) {
            ownerLayerInterface.setPosition(0, y, ownerLayerInterface.getZP())
        }
        if (y2 > displayInfo.getLastHeight()) {
            //ownerLayerInterface.setPosition(x, height + 1);
            ownerLayerInterface.setPosition(x, 0, ownerLayerInterface.getZP())
        }
        if (x < 0) {
            ownerLayerInterface.setPosition(displayInfo.getLastWidth() - width, y, ownerLayerInterface.getZP())
        }
        if (y < 0) {
            ownerLayerInterface.setPosition(x, displayInfo.getLastHeight() - height, ownerLayerInterface.getZP())
        }
    }

}


