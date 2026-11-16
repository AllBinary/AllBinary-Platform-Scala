/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.game.ai.path

import _root_.javax.microedition.lcdui.Canvas
import _root_.org.allbinary.direction.Direction
import _root_.org.allbinary.direction.DirectionFactory
import _root_.org.allbinary.math.AngleIncrementInfo
import _root_.org.allbinary.math.AngleInfo

class BasicDirectionAIHelper(param_name : String, param_angleInfo : AngleInfo) {

    private var name : String = null

    private var angleInfo : AngleInfo = null

    //Constructor
    {
        val name : String = param_name
        val angleInfo : AngleInfo = param_angleInfo
        this.name = name
        this.angleInfo = angleInfo
    }

    private def turnAI(frame : Int) : Int = {
        var keyDirection : Int = -1
        //0-360 - 0-360 = -360-360
        val directionAngle : Int = this.angleInfo.getAngleIncrementInfo().getFrameAngle(frame)
        val angle : Short = this.angleInfo.getAngle()
        val degrees : Int = Math.abs(directionAngle - angle)
        //this.logUtil.putF(this.getName() + " Direction Angle: " + directionAngle + " Angle: " + this.getAngleInfoP().getAngle() + " degrees: " + degrees, this, "turnAI");
        if (degrees < 180) {
            if (angle > directionAngle) {
                keyDirection = Canvas.LEFT
            } else if (angle < directionAngle) {
                keyDirection = Canvas.RIGHT
            }
        } else {
            if (angle > directionAngle) {
                keyDirection = Canvas.RIGHT
            } else if (angle < directionAngle) {
                keyDirection = Canvas.LEFT
            }
        }
        return keyDirection
    }

    private def getAIKeyPressed(frame : Integer) : Int = {
        //this.logUtil.putF("this.getFrameAngle(frame): " + this.getAngleInfoP().getFrameAngle(frame), this, "getAIKeyPressed");
        val angle : Short = this.angleInfo.getAngleIncrementInfo().getFrameAngle(frame.intValue()).toShort
        if (this.angleInfo.getAngle() != angle) {
            //PreLogUtil.put(this.angleInfo.getAngle() + " != " + this.angleInfo.getAngleIncrementInfo().getFrameAngle(frame.intValue()), this, "getAIKeyPressed");
            return this.turnAI(frame.intValue())
        } else {
            //this.logUtil.putF("Accelerate", this, "getAIKeyPressed");
            return Canvas.UP
        }
        throw new IllegalStateException()
    }

    def getAIKeyPressedFromDirection(geographicMapDirectionData : Direction) : Int = {
        var keyDirection : Int = -1
        //this.logUtil.putF(this.getName() + " geographicMapDirectionData: " + geographicMapDirectionData, this, "getAIKeyPressedFromDirection");
        val angleIncrementInfo : AngleIncrementInfo = this.angleInfo.getAngleIncrementInfo()
        val directionFactory : DirectionFactory = DirectionFactory.getInstance()
        if (geographicMapDirectionData eq directionFactory.DOWN) {
            keyDirection = this.getAIKeyPressed(angleIncrementInfo.DOWN_FRAME)
        } else if (geographicMapDirectionData eq directionFactory.UP) {
            keyDirection = this.getAIKeyPressed(angleIncrementInfo.UP_FRAME)
        } else if (geographicMapDirectionData eq directionFactory.LEFT) {
            keyDirection = this.getAIKeyPressed(angleIncrementInfo.LEFT_FRAME)
        } else if (geographicMapDirectionData eq directionFactory.RIGHT) {
            keyDirection = this.getAIKeyPressed(angleIncrementInfo.RIGHT_FRAME)
        }
        return keyDirection
    }

    def getAngleInfoP() : AngleInfo = {
        return this.angleInfo
    }

    //   }
    def getName() : String = {
        return this.name
    }

}


