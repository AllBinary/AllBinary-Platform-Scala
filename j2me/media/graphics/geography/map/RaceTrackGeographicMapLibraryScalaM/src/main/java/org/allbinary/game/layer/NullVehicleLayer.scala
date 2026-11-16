/*  * AllBinary Open License Version 1  * Copyright (c) 2025 AllBinary  *   * By agreeing to this license you and any business entity you represent are  * legally bound to the AllBinary Open License Version 1 legal agreement.  *   * You may obtain the AllBinary Open License Version 1 legal agreement from  * AllBinary or the root directory of AllBinary's AllBinary Platform repository.  *   * Created By: Travis Berthelot  *   */
/* Generated Code Do Not Modify */
package org.allbinary.game.layer

import _root_.javax.microedition.lcdui.Graphics
import _root_.org.allbinary.animation.RotationAnimation
import _root_.org.allbinary.game.identification.Group
import _root_.org.allbinary.logic.math.BasicDecimal
import _root_.org.allbinary.media.graphics.geography.map.GeographicMapCellHistory
import _root_.org.allbinary.media.graphics.geography.map.GeographicMapCellPositionTracking
import _root_.org.allbinary.util.BasicArrayList

/**  *  * @author User  */
class NullVehicleLayer extends VehicleLayerInterface {
    import _root_.org.allbinary.game.layer.NullVehicleLayer.{NULL_VEHICLE_LAYER as _, *}
    def NULL_VEHICLE_LAYER : NullVehicleLayer = _root_.org.allbinary.game.layer.NullVehicleLayer.NULL_VEHICLE_LAYER

    override def getName() : String = {
        throw new RuntimeException()
    }

    override def getGroupInterface() : Array[Group] = {
        throw new RuntimeException()
    }

    override def setPosition(x : Int, y : Int, z : Int) : Unit = {
        throw new RuntimeException()
    }

    override def getHeight() : Int = {
        throw new RuntimeException()
    }

    override def getWidth() : Int = {
        throw new RuntimeException()
    }

    override def getHalfHeight() : Int = {
        throw new RuntimeException()
    }

    override def getHalfWidth() : Int = {
        throw new RuntimeException()
    }

    override def getXP() : Int = {
        throw new RuntimeException()
    }

    override def getYP() : Int = {
        throw new RuntimeException()
    }

    override def getZP() : Int = {
        throw new RuntimeException()
    }

    override def getX2() : Int = {
        throw new RuntimeException()
    }

    override def getY2() : Int = {
        throw new RuntimeException()
    }

    override def getZ2() : Int = {
        throw new RuntimeException()
    }

    override def isVisible() : Boolean = {
        throw new RuntimeException()
    }

    override def moveDXYZ(dx : Int, dy : Int, dz : Int) : Unit = {
        throw new RuntimeException()
    }

    override def setVisible(visible : Boolean) : Unit = {
        throw new RuntimeException()
    }

    override def implmentsTickableInterface() : Boolean = {
        throw new RuntimeException()
    }

    override def implmentsCollidableInterface() : Boolean = {
        throw new RuntimeException()
    }

    override def implmentsGameInputInterface() : Boolean = {
        throw new RuntimeException()
    }

    override def implmentsArtificialIntelligenceCompositeInterface() : Boolean = {
        throw new RuntimeException()
    }

    override def getType() : Int = {
        throw new RuntimeException()
    }

    override def getVehicleProperties() : VehicleProperties = {
        throw new RuntimeException()
    }

    //    }
    override def getGameKeyEventList() : BasicArrayList = {
        throw new RuntimeException()
    }

    override def getSpeedBasicDecimal() : BasicDecimal = {
        throw new RuntimeException()
    }

    override def isReadyForExplosion() : Boolean = {
        throw new RuntimeException()
    }

    override def getRotationAnimationInterface() : RotationAnimation = {
        throw new RuntimeException()
    }

    override def setRotationAnimationInterface(animationInterface : RotationAnimation) : Unit = {
        throw new RuntimeException()
    }

    override def isDestroyed() : Boolean = {
        throw new RuntimeException()
    }

    override def isFinish() : Boolean = {
        throw new RuntimeException()
    }

    override def getFinalPosition() : Int = {
        throw new RuntimeException()
    }

    override def handleFinish() : Unit = {
        throw new RuntimeException()
    }

    override def getGeographicMapCellPositionTracking() : GeographicMapCellPositionTracking = {
        throw new RuntimeException()
    }

    override def getGeographicMapCellHistoryArray() : Array[GeographicMapCellHistory] = {
        throw new RuntimeException()
    }

    override def setGeographicMapCellHistoryArray(geographicMapCellHistory : Array[GeographicMapCellHistory]) : Unit = {
        throw new RuntimeException()
    }

    override def paint(graphics : Graphics) : Unit = {
    }

    override def paintThreed(graphics : Graphics) : Unit = {
    }

}

object NullVehicleLayer {
    val NULL_VEHICLE_LAYER : NullVehicleLayer = new NullVehicleLayer()

}


