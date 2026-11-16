/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.game.collision

import _root_.org.allbinary.game.layer.CollidableCompositeLayer
import _root_.org.allbinary.layer.AllBinaryLayer
import _root_.org.allbinary.layer.NamedInterface

/**  *  * @author USER  */
trait CollidableInterface extends NamedInterface {

    def isCollidable(ownerLayer : CollidableCompositeLayer) : Boolean

    def isCollision(ownerLayer : CollidableCompositeLayer, collidableInterfaceCompositeInterface : CollidableCompositeLayer) : Boolean

    def collide(ownerLayer : CollidableCompositeLayer, collidableInterfaceCompositeInterface : CollidableCompositeLayer) : Unit

    def getCollisionTypeWith(layerInterface : AllBinaryLayer) : CollisionType

}


