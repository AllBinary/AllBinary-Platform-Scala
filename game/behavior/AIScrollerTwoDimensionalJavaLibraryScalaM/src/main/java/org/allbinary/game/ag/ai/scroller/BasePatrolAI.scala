/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.game.ag.ai.scroller

import _root_.javax.microedition.lcdui.Canvas
import _root_.org.allbinary.game.ai.BasicAI
import _root_.org.allbinary.game.input.GameInput
import _root_.org.allbinary.game.physics.velocity.BasicVelocityProperties
import _root_.org.allbinary.game.physics.velocity.VelocityInterfaceCompositeInterface
import _root_.org.allbinary.layer.AllBinaryLayer
import _root_.org.allbinary.logic.math.MathUtil
import _root_.org.allbinary.logic.math.SmallIntegerSingletonFactory
import _root_.org.allbinary.util.ABHashtable

class BasePatrolAI(param_hashtable : ABHashtable[Object, Object], param_ownerLayerInterface : AllBinaryLayer, param_gameInput : GameInput) extends BasicAI(param_ownerLayerInterface, param_gameInput) {
    import _root_.org.allbinary.game.ag.ai.scroller.BasePatrolAI.{MAX_DISTANCE as _, DIRECTION_ARRAY as _, FIRING_DISTANCE as _, *}
    def MAX_DISTANCE : Integer = _root_.org.allbinary.game.ag.ai.scroller.BasePatrolAI.MAX_DISTANCE
    def DIRECTION_ARRAY : Integer = _root_.org.allbinary.game.ag.ai.scroller.BasePatrolAI.DIRECTION_ARRAY
    def FIRING_DISTANCE : Integer = _root_.org.allbinary.game.ag.ai.scroller.BasePatrolAI.FIRING_DISTANCE

    var maxDistance : Integer = null

    var currentDistance : Int = 0

    //private Integer[] directionArray;
    var xTotalDistance : Int = 0

    //private int yTotalDistance;
    var lastKeyDirection : Int = Canvas.RIGHT

    var keyDirection : Int = Canvas.RIGHT

    //Constructor
    {
        val hashtable : ABHashtable[Object, Object] = param_hashtable
        val ownerLayerInterface : AllBinaryLayer = param_ownerLayerInterface
        val gameInput : GameInput = param_gameInput
        this.maxDistance = hashtable.get(BasePatrolAI.MAX_DISTANCE).asInstanceOf[Integer]
        this.currentDistance = this.maxDistance.intValue()
    }

    def update() : Unit = {
        this.updateTotalDistance()
        this.changeDirectionIfReachedPacingAreaMax()
    }

    private def updateTotalDistance() : Unit = {
        val velocityInterfaceCompositeInterface : VelocityInterfaceCompositeInterface = this.getOwnerLayerInterface().asInstanceOf[VelocityInterfaceCompositeInterface]
        val velocityProperties : BasicVelocityProperties = velocityInterfaceCompositeInterface.getVelocityProperties()
        this.xTotalDistance += velocityProperties.getVelocityXBasicDecimalP().getScaled()
    }

    // Limit pacing to a maximum distance
    private def changeDirectionIfReachedPacingAreaMax() : Unit = {
        val mathUtil : MathUtil = MathUtil.getInstance()
        val totalDistance : Int = mathUtil.abs(this.xTotalDistance)
        if (totalDistance > this.currentDistance) {
            this.nextDirection()
        }
    }

    def nextDirection() : Unit = {
        // for(int index = 0; index < directionArray.length; index++)
        if (this.lastKeyDirection == Canvas.LEFT) {
            this.keyDirection = Canvas.RIGHT
            this.lastKeyDirection = this.keyDirection
            this.xTotalDistance = 0
        } else if (this.lastKeyDirection == Canvas.RIGHT) {
            this.keyDirection = Canvas.LEFT
            this.lastKeyDirection = this.keyDirection
            this.xTotalDistance = 0
        }
    }

    def disable() : Unit = {
    }

}

object BasePatrolAI {
    val MAX_DISTANCE : Integer = SmallIntegerSingletonFactory.getInstance().getAt(2)

    val DIRECTION_ARRAY : Integer = SmallIntegerSingletonFactory.getInstance().getAt(3)

    val FIRING_DISTANCE : Integer = SmallIntegerSingletonFactory.getInstance().getAt(4)

    var SPEED : Integer = SmallIntegerSingletonFactory.getInstance().getAt(5)

}


