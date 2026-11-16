/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.game.collision

import _root_.javax.microedition.lcdui.Graphics
import _root_.org.allbinary.game.layer.CollidableCompositeLayer
import _root_.org.allbinary.layer.AllBinaryLayer
import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.logic.string.StringMaker
import _root_.org.allbinary.string.CommonLabels
import _root_.org.allbinary.string.CommonStrings

class CollidableBaseBehavior(param_collidable : Boolean) extends CollidableInterface {

    val logUtil : LogUtil = LogUtil.getInstance()

    val commonStrings : CommonStrings = CommonStrings.getInstance()

    val layerCollisionUtil : LayerCollisionUtil = LayerCollisionUtil.getInstance()

    //TWB - move to CollidableCompositeLayer
    private var collidable : Boolean = true

    //Constructor
    {
        val collidable : Boolean = param_collidable
        this.collidable = collidable
    }

    def update() : Unit = {
    }

    override def getName() : String = {
        return this.getClass().getName()
    }

    def setCollidable(collidable : Boolean) : Unit = {
        this.collidable = collidable
    }

    // If visible and a collidable object then
    override def isCollidable(ownerLayer : CollidableCompositeLayer) : Boolean = {
        return this.collidable
    }

    // TODO TWB Special Super Efficient Collision Processing
    override def collide(ownerLayer : CollidableCompositeLayer, allbinaryCollidableLayer : CollidableCompositeLayer) : Unit = {
        throw new Exception(new StringMaker().append(this.commonStrings.NOT_IMPLEMENTED).append(CommonLabels.getInstance().COLON_SEP).append(this.getClass().getName()).toString())
    }

    // TODO TWB Special Super Efficient Collision Processing
    override def isCollision(ownerLayer : CollidableCompositeLayer, collisionLayer : CollidableCompositeLayer) : Boolean = {
        return this.layerCollisionUtil.isCollision(ownerLayer, collisionLayer)
    }

    def isCollisionInterface(ownerLayer : CollidableCompositeLayer, collidableInterfaceCompositeInterface : CollidableInterfaceCompositeInterface) : Boolean = {
        return this.layerCollisionUtil.isCollision(ownerLayer, collidableInterfaceCompositeInterface.asInstanceOf[AllBinaryLayer])
    }

    def collideInterface(ownerLayer : CollidableCompositeLayer, collidableInterfaceCompositeInterface : CollidableInterfaceCompositeInterface) : Unit = {
        throw new Exception(this.commonStrings.NOT_IMPLEMENTED)
    }

    def paint(ownerLayer : CollidableCompositeLayer, graphics : Graphics) : Unit = {
    }

    override def getCollisionTypeWith(layerInterface : AllBinaryLayer) : CollisionType = {
        return CollisionTypeFactory.getInstance().NONE
    }

}


