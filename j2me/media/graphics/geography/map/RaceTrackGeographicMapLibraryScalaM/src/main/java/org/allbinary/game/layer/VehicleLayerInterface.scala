/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.game.layer

import _root_.org.allbinary.util.BasicArrayList
import _root_.org.allbinary.animation.RotationAnimation
import _root_.org.allbinary.layer.LayerInterface
import _root_.org.allbinary.logic.math.BasicDecimal
import _root_.org.allbinary.media.graphics.geography.map.GeographicMapCellHistory
import _root_.org.allbinary.media.graphics.geography.map.GeographicMapCellPositionTracking

trait VehicleLayerInterface extends LayerInterface with VehiclePropertiesCompositeInterface {

    def getGameKeyEventList() : BasicArrayList

    def getSpeedBasicDecimal() : BasicDecimal

    def isReadyForExplosion() : Boolean

    def getRotationAnimationInterface() : RotationAnimation

    def setRotationAnimationInterface(animationInterface : RotationAnimation) : Unit

    def isDestroyed() : Boolean

    def isFinish() : Boolean

    def getFinalPosition() : Int

    def handleFinish() : Unit

    def getGeographicMapCellPositionTracking() : GeographicMapCellPositionTracking

    def getGeographicMapCellHistoryArray() : Array[GeographicMapCellHistory]

    def setGeographicMapCellHistoryArray(geographicMapCellHistory : Array[GeographicMapCellHistory]) : Unit

}


