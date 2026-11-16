/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.game.physics.velocity

import _root_.org.allbinary.direction.Direction
import _root_.org.allbinary.logic.math.BasicDecimal
import _root_.org.allbinary.math.Angle

trait BasicVelocityInterface {

    def getVelocityXBasicDecimalP() : BasicDecimal

    def getVelocityYBasicDecimalP() : BasicDecimal

    def zero() : Unit

    //void setVelocityYBasicDecimal(BasicDecimal velocityYBasicDecimal);
    def setVelocityWithBigDecimalAndDirection(magnitudeBasicDecimal : BasicDecimal, direction : Direction, otherDirection : Direction) : Unit

    def addVelocityWithBigDecimalAndDirection(magnitudeBasicDecimal : BasicDecimal, direction : Direction, otherDirection : Direction) : Unit

    def setVelocityWithDirection(magnitude : Long, direction : Direction, otherDirection : Direction) : Unit

    def addVelocityWithDirection(magnitude : Long, direction : Direction, otherDirection : Direction) : Unit

    def setVelocityWithBigDecimal(magnitudeBasicDecimal : BasicDecimal, angle : Angle, otherAngle : Angle) : Unit

    def addVelocityWithBigDecimal(magnitudeBasicDecimal : BasicDecimal, angle : Angle, otherAngle : Angle) : Unit

    def setVelocity(magnitude : Long, angle : Angle, otherAngle : Angle) : Unit

    def addVelocity(magnitude : Long, angle : Angle, otherAngle : Angle) : Unit

    def addVelocityi(magnitude : Long, angle : Int, otherAngle : Int) : Unit

}


