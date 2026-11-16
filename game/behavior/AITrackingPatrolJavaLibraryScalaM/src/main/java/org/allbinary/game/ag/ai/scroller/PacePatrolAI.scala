/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.game.ag.ai.scroller

import _root_.javax.microedition.lcdui.Canvas
import _root_.org.allbinary.direction.Direction
import _root_.org.allbinary.direction.DirectionCompositeInterface
import _root_.org.allbinary.direction.DirectionFactory
import _root_.org.allbinary.game.input.GameInput
import _root_.org.allbinary.game.tracking.TrackingEvent
import _root_.org.allbinary.game.tracking.TrackingEventHandler
import _root_.org.allbinary.game.tracking.TrackingEventListenerInterface
import _root_.org.allbinary.layer.AllBinaryLayer
import _root_.org.allbinary.layer.AllBinaryLayerManager
import _root_.org.allbinary.layer.LayerInterface
import _root_.org.allbinary.logic.communication.log.ForcedLogUtil
import _root_.org.allbinary.logic.util.event.AllBinaryEventObject
import _root_.org.allbinary.logic.util.event.EventStrings
import _root_.org.allbinary.util.ABHashtable
import _root_.org.allbinary.util.BasicArrayList
import _root_.org.allbinary.util.BasicArrayListD

class PacePatrolAI(param_hashtable : ABHashtable[Object, Object], param_ownerLayerInterface : AllBinaryLayer, param_gameInput : GameInput) extends BasePatrolAI(param_hashtable, param_ownerLayerInterface, param_gameInput) with TrackingEventListenerInterface {

    private var trackingList : BasicArrayList = null

    // private final int MIN_DISTANCE = 0;
    private var firingDistance : Int = 0

    var isFollowLimitedByTerrain : Boolean = false

    //Constructor
    {
        val hashtable : ABHashtable[Object, Object] = param_hashtable
        val ownerLayerInterface : AllBinaryLayer = param_ownerLayerInterface
        val gameInput : GameInput = param_gameInput
        TrackingEventHandler.getInstance().addListenerInterface(this)
        this.trackingList = new BasicArrayListD()
    }

    override def processAI(allBinaryLayerManager : AllBinaryLayerManager) : Unit = {
        this.update()
        val direction : Direction = this.setFiringDirectionForTargetIfInRange()
        val directionFactory : DirectionFactory = DirectionFactory.getInstance()
        // this.logUtil.putF("Key: " + this.keyDirection, this, this.commonStrings.PROCESS);
        if (direction eq directionFactory.LEFT) {
            //Turn around before firing or if in follow mode
            if ((this.lastKeyDirection != keyDirection) || !this.isFollowLimitedByTerrain) {
                super.processKeyAI(Canvas.LEFT)
            }
            keyDirection = Canvas.LEFT
            this.lastKeyDirection = keyDirection
            xTotalDistance = 0
            //
            super.processKeyAI(Canvas.KEY_NUM1)
        } else if (direction eq directionFactory.RIGHT) {
            //Turn around before firing
            if ((this.lastKeyDirection != keyDirection) || !this.isFollowLimitedByTerrain) {
                super.processKeyAI(Canvas.RIGHT)
            }
            keyDirection = Canvas.RIGHT
            this.lastKeyDirection = keyDirection
            xTotalDistance = 0
            super.processKeyAI(Canvas.KEY_NUM1)
        } else {
            super.processKeyAI(this.keyDirection)
        }
    }

    private def setFiringDirectionForTargetIfInRange() : Direction = {
        val directionFactory : DirectionFactory = DirectionFactory.getInstance()
        val ownerLayerInterface : AllBinaryLayer = this.getOwnerLayerInterface()
        var direction : Direction = directionFactory.NOT_BORDERED_WITH
        var lastTrackingEvent : TrackingEvent = null
        var lastTrackingLayerInterface : LayerInterface = null
        var directionCompositeInterface : DirectionCompositeInterface = null
        val size : Int = this.trackingList.size()

        {
            var index : Int = 0
            while (index < size) {
                lastTrackingEvent = this.trackingList.get(0).asInstanceOf[TrackingEvent]
                lastTrackingLayerInterface = lastTrackingEvent.getLayerInterface()
                var x : Int = lastTrackingLayerInterface.getXP()
                var y : Int = lastTrackingLayerInterface.getYP()
                var yDistance : Int = (ownerLayerInterface.getYP() - y) - ownerLayerInterface.getHeight()
                var xDistance : Int = (ownerLayerInterface.getXP() - x) - ownerLayerInterface.getWidth()
                // this.logUtil.putF("x: " + x + " y: " + y + " xDistance: " + xDistance + " yDistance: " + yDistance, this, this.commonStrings.PROCESS);
                var absXDistance : Int = Math.abs(xDistance)
                var absYDistance : Int = Math.abs(yDistance)
                //if (absYDistance <= absXDistance)
                if (absYDistance <= 100) {
                    // Range is close enough
                    if (absXDistance < (getFiringDistance() / 2)) {
                        directionCompositeInterface = this.getOwnerLayerInterface().asInstanceOf[DirectionCompositeInterface]
                        // if on the left side and pointing left
                        if ((xDistance < 0) && (directionCompositeInterface.getDirection() eq directionFactory.RIGHT)) {
                            direction = directionFactory.RIGHT
                        } else if ((xDistance > 0) && (directionCompositeInterface.getDirection() eq directionFactory.LEFT)) {
                            direction = directionFactory.LEFT
                        }
                    }
                }
                index += 1
            }
        }
        return direction
    }

    override def disable() : Unit = {
    }

    override def onEvent(eventObject : AllBinaryEventObject) : Unit = {
        ForcedLogUtil.log(EventStrings.getInstance().PERFORMANCE_MESSAGE, this)
    }

    override def onMovement(trackingEvent : TrackingEvent) : Unit = {
        this.trackingList.clear()
        this.trackingList.add(trackingEvent)
    }

    def getFiringDistance() : Int = {
        return this.firingDistance
    }

    def setFiringDistance(firingDistance : Int) : Unit = {
        this.firingDistance = firingDistance
    }

}


