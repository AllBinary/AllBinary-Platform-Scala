/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.layer

import _root_.org.allbinary.game.identification.GroupInterfaceCompositeInterface
import _root_.org.allbinary.graphics.paint.PaintableInterface

trait LayerInterface extends NamedInterface with PaintableInterface with GroupInterfaceCompositeInterface with PositionInterface {

    def getHeight() : Int

    def getWidth() : Int

    def getHalfHeight() : Int

    def getHalfWidth() : Int

    def getXP() : Int

    def getYP() : Int

    def getZP() : Int

    def getX2() : Int

    def getY2() : Int

    def getZ2() : Int

    def isVisible() : Boolean

    def moveDXYZ(dx : Int, dy : Int, dz : Int) : Unit

    def setVisible(visible : Boolean) : Unit

    def implmentsTickableInterface() : Boolean

    def implmentsCollidableInterface() : Boolean

    def implmentsGameInputInterface() : Boolean

    def implmentsArtificialIntelligenceCompositeInterface() : Boolean

    def getType() : Int

}


