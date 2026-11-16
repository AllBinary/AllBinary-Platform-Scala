/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.game.ag.ai.tactical

import _root_.javax.microedition.lcdui.Canvas
import _root_.org.allbinary.game.ai.BasicAI
import _root_.org.allbinary.game.input.GameInput
import _root_.org.allbinary.graphics.displayable.DisplayInfoSingleton
import _root_.org.allbinary.layer.AllBinaryLayer
import _root_.org.allbinary.layer.AllBinaryLayerManager

class HorizontalManeuverAI(param_ownerLayerInterface : AllBinaryLayer, param_gameInput : GameInput) extends BasicAI(param_ownerLayerInterface, param_gameInput) {

    var currentRelativeAngle : Int = 0

    private var currentSpeed : Int = 0

    //Constructor
    {
        val ownerLayerInterface : AllBinaryLayer = param_ownerLayerInterface
        val gameInput : GameInput = param_gameInput
        this.currentSpeed = 5
    }

    override def processAI(allBinaryLayerManager : AllBinaryLayerManager) : Unit = {
        var ownerLayerInterface : AllBinaryLayer = this.getOwnerLayerInterface()
        //int keyDirection = -1;
        var x : Int = ownerLayerInterface.getXP()
        //this.logUtil.putF("Angle: " + currentAngle + " X: " + x + " Y: " + y, this, this.commonStrings.PROCESS);
        if ((ownerLayerInterface.getXP() - this.currentSpeed) <= 0) {
            this.reverse()
            this.drop()
        }
        if ((ownerLayerInterface.getX2() + this.currentSpeed) > DisplayInfoSingleton.getInstance().getLastWidth()) {
            this.reverse()
            this.accelerate()
            this.drop()
        }
        if (this.currentRelativeAngle == 0) {
            x += this.currentSpeed
        } else if (this.currentRelativeAngle == 180) {
            x -= this.currentSpeed
        }
        //super.processAI(Canvas.UP);
        ownerLayerInterface.setPosition(x, ownerLayerInterface.getYP(), ownerLayerInterface.getZP())
        if (this.currentRelativeAngle == 0) {
            super.processKeyAI(Canvas.KEY_NUM0)
        } else if (this.currentRelativeAngle == 180) {
            super.processKeyAI(Canvas.KEY_POUND)
        }
    }

    def reverse() : Unit = {
        if (this.currentRelativeAngle == 180) {
            this.currentRelativeAngle = 0
        } else if (this.currentRelativeAngle == 0) {
            this.currentRelativeAngle = 180
        }
    }

    private def accelerate() : Unit = {
        if (this.currentSpeed < 20) {
            this.currentSpeed += 1
        }
    }

    private def drop() : Unit = {
        var ownerLayerInterface : AllBinaryLayer = this.getOwnerLayerInterface()
        var y : Int = ownerLayerInterface.getYP()
        if ((ownerLayerInterface.getY2() + ownerLayerInterface.getHeight()) > DisplayInfoSingleton.getInstance().getLastHeight()) {
            y = 0
        } else {
            y += ownerLayerInterface.getHeight() + 1
        }
        ownerLayerInterface.setPosition(ownerLayerInterface.getXP(), y, ownerLayerInterface.getZP())
    }

}


