/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.game.ag.ai

import _root_.org.allbinary.game.ai.BasicAI
import _root_.org.allbinary.game.input.GameInput
import _root_.org.allbinary.graphics.displayable.DisplayInfoSingleton
import _root_.org.allbinary.layer.AllBinaryLayer
import _root_.org.allbinary.layer.AllBinaryLayerManager

class ScrollOverAtEndAI(param_ownerLayerInterface : AllBinaryLayer, param_gameInput : GameInput) extends BasicAI(param_ownerLayerInterface, param_gameInput) {

    //Constructor
    {
        val ownerLayerInterface : AllBinaryLayer = param_ownerLayerInterface
        val gameInput : GameInput = param_gameInput
    }

    override def processAI(allBinaryLayerManager : AllBinaryLayerManager) : Unit = {
        var ownerLayerInterface : AllBinaryLayer = this.getOwnerLayerInterface()
        var x : Int = ownerLayerInterface.getXP()
        var y : Int = ownerLayerInterface.getYP()
        var width : Int = ownerLayerInterface.getWidth()
        var height : Int = ownerLayerInterface.getHeight()
        var displayInfo : DisplayInfoSingleton = DisplayInfoSingleton.getInstance()
        //was x2
        if (x > displayInfo.getLastWidth()) {
            ownerLayerInterface.setPosition(0, y, ownerLayerInterface.getZP())
        }
        if (y > displayInfo.getLastHeight()) {
            //ownerLayerInterface.setPosition(x, height + 1);
            ownerLayerInterface.setPosition(x, 0, ownerLayerInterface.getZP())
        }
        if (x < -width) {
            ownerLayerInterface.setPosition(displayInfo.getLastWidth() - width, y, ownerLayerInterface.getZP())
        }
        if (y < -height) {
            ownerLayerInterface.setPosition(x, displayInfo.getLastHeight() - height, ownerLayerInterface.getZP())
        }
    }

}


