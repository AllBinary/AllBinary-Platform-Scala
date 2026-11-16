/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.game.ag.ai

import _root_.javax.microedition.lcdui.Canvas
import _root_.org.allbinary.ai.ArtificialIntelligenceInterface
import _root_.org.allbinary.direction.Direction
import _root_.org.allbinary.direction.DirectionFactory
import _root_.org.allbinary.direction.DirectionalCompositeInterface
import _root_.org.allbinary.direction.DirectionalInterface
import _root_.org.allbinary.game.ai.BasicAI
import _root_.org.allbinary.game.combat.destroy.event.DestroyedEvent
import _root_.org.allbinary.game.combat.destroy.event.DestroyedEventHandler
import _root_.org.allbinary.game.combat.destroy.event.DestroyedEventListenerInterface
import _root_.org.allbinary.game.identification.Group
import _root_.org.allbinary.game.input.GameInput
import _root_.org.allbinary.game.physics.velocity.BasicVelocityProperties
import _root_.org.allbinary.game.physics.velocity.VelocityInterfaceCompositeInterface
import _root_.org.allbinary.game.tracking.TrackingEvent
import _root_.org.allbinary.game.tracking.TrackingEventHandler
import _root_.org.allbinary.game.tracking.TrackingEventListenerInterface
import _root_.org.allbinary.layer.AllBinaryLayer
import _root_.org.allbinary.layer.AllBinaryLayerManager
import _root_.org.allbinary.logic.communication.log.ForcedLogUtil
import _root_.org.allbinary.logic.math.MathUtil
import _root_.org.allbinary.logic.string.StringMaker
import _root_.org.allbinary.logic.string.StringUtil
import _root_.org.allbinary.logic.util.event.AllBinaryEventObject
import _root_.org.allbinary.logic.util.event.EventStrings
import _root_.org.allbinary.logic.util.visitor.Visitor
import _root_.org.allbinary.time.GameTickTimeDelayHelper
import _root_.org.allbinary.time.GameTickTimeDelayHelperFactory
import _root_.org.allbinary.time.TimeDelayHelper
import _root_.org.allbinary.util.BasicArrayList
import _root_.org.allbinary.util.BasicArrayListD

class DiveAndDirectionalTrackingAI(param_ownerLayerInterface : AllBinaryLayer, param_artificialIntelligenceInterface : ArtificialIntelligenceInterface, param_gameInput : GameInput, param_visitor : Visitor) extends BasicAI(param_ownerLayerInterface, param_gameInput) with TrackingEventListenerInterface with DestroyedEventListenerInterface {

    private val mathUtil : MathUtil = MathUtil.getInstance()

    private val directionFactory : DirectionFactory = DirectionFactory.getInstance()

    private val gameTickTimeDelayHelper : GameTickTimeDelayHelper = GameTickTimeDelayHelperFactory.getInstance()

    private val timeDelayHelper : TimeDelayHelper = new TimeDelayHelper(500)

    // private final TimeDelayHelper timeDelayHelper = new TimeDelayHelper(0);
    private val list : BasicArrayList = new BasicArrayListD()

    // Yes really an interface oh the horror
    private var directionalInterface : DirectionalInterface = null

    private var velocityInterface : BasicVelocityProperties = null

    private val directionToKeyMap : Array[Int] = Array[Int](Canvas.LEFT, Canvas.DOWN, Canvas.UP, Canvas.RIGHT)

    private var initialDropped : Boolean = false

    private var diveP : Boolean = false

    // private boolean targeting;
    private var directionOfTarget : Direction = Direction.getInstance(0)

    private val MIN_DISTANCE : Int = 40

    private var lastTrackingLayerInterface : AllBinaryLayer = AllBinaryLayer.NULL_ALLBINARY_LAYER

    // When this AI can't do anything
    private var artificialIntelligenceInterface : ArtificialIntelligenceInterface = null

    private var aiVistor : Visitor = null

    private var lastDirection : Direction = DirectionFactory.getInstance().NO_DIRECTION

    //Constructor
    {
        val ownerLayerInterface : AllBinaryLayer = param_ownerLayerInterface
        val artificialIntelligenceInterface : ArtificialIntelligenceInterface = param_artificialIntelligenceInterface
        val gameInput : GameInput = param_gameInput
        val visitor : Visitor = param_visitor
        this.aiVistor = visitor
        this.artificialIntelligenceInterface = artificialIntelligenceInterface
        var directionalCompositeInterface : DirectionalCompositeInterface = this.getOwnerLayerInterface().asInstanceOf[DirectionalCompositeInterface]
        this.directionalInterface = directionalCompositeInterface.getDirectionalInterface()
        var velocityInterfaceCompositeInterface : VelocityInterfaceCompositeInterface = this.getOwnerLayerInterface().asInstanceOf[VelocityInterfaceCompositeInterface]
        this.velocityInterface = velocityInterfaceCompositeInterface.getVelocityProperties()
        DestroyedEventHandler.getInstance().addListenerInterface(this)
        this.init()
    }

    override def processAI(allBinaryLayerManager : AllBinaryLayerManager) : Unit = {
        // Should Re-Target
        if (this.isBeyondTarget()) {
            this.init()
            this.velocityInterface.zero()
        }
        if (!this.diveP) {
            this.target(allBinaryLayerManager)
        } else {
            this.dive()
            this.attack()
        }
        this.list.clear()
    }

    private def init() : Unit = {
        this.diveP = false
        // this.targeting = true;
        this.directionOfTarget = DirectionFactory.getInstance().NOT_BORDERED_WITH
        TrackingEventHandler.getInstance().addListenerInterface(this)
    }

    private def target(allBinaryLayerManager : AllBinaryLayerManager) : Unit = {
        if (this.list.size() == 0) {
            return
        }
        var lastTrackingEvent : TrackingEvent = this.list.removeAt(0).asInstanceOf[TrackingEvent]
        this.lastTrackingLayerInterface = lastTrackingEvent.getLayerInterface()
        // this.lastTrackingLayerInterface, this, "target");
        var layerInterface : AllBinaryLayer = this.lastTrackingLayerInterface
        var ownerLayerInterface : AllBinaryLayer = this.getOwnerLayerInterface()
        val groupArray : Array[Group] = layerInterface.getGroupInterface()
        val ownerGroupArray : Array[Group] = ownerLayerInterface.getGroupInterface()
        if (groupArray eq ownerGroupArray) {
            return
        }
        var x : Int = this.lastTrackingLayerInterface.getXP()
        var y : Int = this.lastTrackingLayerInterface.getYP()
        // If yDistance is positive then going up
        var yDistance : Int = (ownerLayerInterface.getYP() - y) - ownerLayerInterface.getHeight()
        // If xDistance is positive then going left
        var xDistance : Int = (ownerLayerInterface.getXP() - x) - ownerLayerInterface.getWidth()
        val directionFactory : DirectionFactory = DirectionFactory.getInstance()
        if (this.mathUtil.abs(yDistance) > this.mathUtil.abs(xDistance)) {
            if (yDistance > this.MIN_DISTANCE) {
                this.directionOfTarget = directionFactory.UP
            } else if (yDistance < -this.MIN_DISTANCE) {
                this.directionOfTarget = directionFactory.DOWN
            }
        } else {
            if (xDistance > this.MIN_DISTANCE) {
                this.directionOfTarget = directionFactory.LEFT
            } else if (xDistance < -this.MIN_DISTANCE) {
                this.directionOfTarget = directionFactory.RIGHT
            }
        }
        if (!this.initialDropped && (this.directionOfTarget ne directionFactory.NOT_BORDERED_WITH)) {
            this.drop()
        }
        // Don't do anything until drop occurs
        if (this.initialDropped) {
            if ((this.directionOfTarget eq directionFactory.UP) || (this.directionOfTarget eq directionFactory.DOWN)) {
                this.verticalTargeting(x)
            } else if ((this.directionOfTarget eq directionFactory.LEFT) || (this.directionOfTarget eq directionFactory.RIGHT)) {
                this.horizontalTargeting(y)
            } else {
                this.artificialIntelligenceInterface.processAI(allBinaryLayerManager)
            }
        }
    }

    private def verticalTargeting(x : Int) : Unit = {
        var ownerLayerInterface : AllBinaryLayer = this.getOwnerLayerInterface()
        if (ownerLayerInterface.getXP() < x) {
            this.moveRight()
        }
        if (ownerLayerInterface.getXP() > x) {
            this.moveLeft()
        }
        if ((ownerLayerInterface.getXP() > (x - 3)) && (ownerLayerInterface.getXP() < (x + 3))) {
            this.setDive()
        }
    }

    private def horizontalTargeting(y : Int) : Unit = {
        var ownerLayerInterface : AllBinaryLayer = this.getOwnerLayerInterface()
        if (ownerLayerInterface.getYP() < y) {
            this.moveDown()
        }
        if (ownerLayerInterface.getYP() > y) {
            this.moveUp()
        }
        if ((ownerLayerInterface.getYP() > (y - 3)) && (ownerLayerInterface.getYP() < (y + 3))) {
            this.setDive()
        }
    }

    private def setDive() : Unit = {
        this.diveP = true
        // this.targeting = false;
        this.velocityInterface.zero()
        TrackingEventHandler.getInstance().removeListener(this)
    }

    private def moveRight() : Unit = {
        this.setLastDirection(this.directionFactory.RIGHT)
        this.directionalInterface.setFrameByDirection(this.lastDirection)
        this.aiVistor.visit(this)
    }

    private def moveLeft() : Unit = {
        this.setLastDirection(this.directionFactory.LEFT)
        this.directionalInterface.setFrameByDirection(this.lastDirection)
        this.aiVistor.visit(this)
    }

    private def moveDown() : Unit = {
        this.setLastDirection(this.directionFactory.DOWN)
        this.directionalInterface.setFrameByDirection(this.lastDirection)
        this.aiVistor.visit(this)
    }

    private def moveUp() : Unit = {
        this.setLastDirection(this.directionFactory.UP)
        this.directionalInterface.setFrameByDirection(this.lastDirection)
        this.aiVistor.visit(this)
    }

    private def dive() : Unit = {
        this.directionalInterface.setFrameByDirection(this.directionOfTarget)
        this.aiVistor.visit(this)
    }

    private def attack() : Unit = {
        super.processKeyAI(Canvas.KEY_NUM1)
    }

    private def drop() : Unit = {
        // Don't start dives so quickly
        if (this.timeDelayHelper.isTime(this.gameTickTimeDelayHelper.startTime)) {
            this.initialDropped = true
            this.aiVistor.visit(this)
        }
    }

    private def isBeyondTarget() : Boolean = {
        if (this.directionOfTarget eq this.directionFactory.DOWN) {
            if (this.getOwnerLayerInterface().getYP() > (this.lastTrackingLayerInterface.getYP() + this.MIN_DISTANCE)) {
                return true
            } else {
                return false
            }
        } else if (this.directionOfTarget eq this.directionFactory.UP) {
            if (this.getOwnerLayerInterface().getYP() < (this.lastTrackingLayerInterface.getYP() + this.MIN_DISTANCE)) {
                return true
            } else {
                return false
            }
        } else if (this.directionOfTarget eq this.directionFactory.RIGHT) {
            if (this.getOwnerLayerInterface().getXP() > (this.lastTrackingLayerInterface.getXP() + this.MIN_DISTANCE)) {
                return true
            } else {
                return false
            }
        } else if (this.directionOfTarget eq this.directionFactory.LEFT) {
            if (this.getOwnerLayerInterface().getXP() < (this.lastTrackingLayerInterface.getXP() + this.MIN_DISTANCE)) {
                return true
            } else {
                return false
            }
        } else {
            return false
        }
        throw new IllegalStateException()
    }

    override def onEvent(eventObject : AllBinaryEventObject) : Unit = {
        ForcedLogUtil.log(EventStrings.getInstance().PERFORMANCE_MESSAGE, this)
    }

    override def onMovement(trackingEvent : TrackingEvent) : Unit = {
        this.list.add(trackingEvent)
    }

    override def onDestroyed(destroyedEvent : DestroyedEvent) : Unit = {
        if (this.getOwnerLayerInterface() eq destroyedEvent.getLayerInterface()) {
            TrackingEventHandler.getInstance().removeListener(this)
            DestroyedEventHandler.getInstance().removeListener(this)
        }
    }

    /*      * public String getDebug() { StringMaker stringBuffer = new      * StringMaker(); stringBuffer.append(" Dp: ");      * stringBuffer.append(this.initialDropped); stringBuffer.append(" Dv: ");      * stringBuffer.append(this.dive); stringBuffer.append(" T: ");      * stringBuffer.append(this.targeting); stringBuffer.append(" D: ");      * stringBuffer.append(this.direction); return stringBuffer.toString(); }      * public String toString() { StringMaker stringBuffer = new      * StringMaker(); stringBuffer.append(" Dropped: ");      * stringBuffer.append(this.initialDropped);      * stringBuffer.append(" Diving: "); stringBuffer.append(this.dive);      * stringBuffer.append(" Targeting: "); stringBuffer.append(this.targeting);      * stringBuffer.append(" Direction: "); stringBuffer.append(this.direction);      * return stringBuffer.toString(); }      */
    def setLastDirection(lastDirection : Direction) : Unit = {
        this.lastDirection = lastDirection
        var value : Int = this.getLastDirection().getValue()
        if (value < 4) {
            super.setLastKey(this.directionToKeyMap(value))
        }
    }

    override def setLastKey(lastKey : Int) : Unit = {
        super.setLastKey(lastKey)
        if (this.getLastKey() == Canvas.LEFT) {
            this.lastDirection = DirectionFactory.getInstance().LEFT
        } else if (this.getLastKey() == Canvas.DOWN) {
            this.lastDirection = DirectionFactory.getInstance().DOWN
        } else if (this.getLastKey() == Canvas.UP) {
            this.lastDirection = DirectionFactory.getInstance().UP
        } else if (this.getLastKey() == Canvas.RIGHT) {
            this.lastDirection = DirectionFactory.getInstance().RIGHT
        }
    }

    def getLastDirection() : Direction = {
        return this.lastDirection
    }

    override def toString() : String = {
        var stringBuffer : StringMaker = new StringMaker()
        stringBuffer.append(super.toString())
        stringBuffer.append(" LastDirection: ")
        stringBuffer.append(StringUtil.getInstance().toString(this.getLastDirection()))
        return stringBuffer.toString()
    }

}


