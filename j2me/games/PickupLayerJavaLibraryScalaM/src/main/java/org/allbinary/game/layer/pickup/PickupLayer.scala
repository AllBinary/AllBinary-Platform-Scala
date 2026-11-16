/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.game.layer.pickup

import _root_.javax.microedition.khronos.opengles.GL
import _root_.javax.microedition.lcdui.Graphics
import _root_.org.allbinary.animation.Animation
import _root_.org.allbinary.animation.NullAnimationFactory
import _root_.org.allbinary.game.collision.CollidableAlwaysPickupNeverCollideBehaviorFactory
import _root_.org.allbinary.game.combat.destroy.DestroyedLayerProcessor
import _root_.org.allbinary.game.identification.BasicGroupFactory
import _root_.org.allbinary.game.multiplayer.layer.MultiPlayerGameLayer
import _root_.org.allbinary.game.multiplayer.layer.RemoteInfo
import _root_.org.allbinary.graphics.Rectangle
import _root_.org.allbinary.image.opengles.OpenGLSurfaceChangedInterface
import _root_.org.allbinary.view.ViewPositionBase

class PickupLayer(param_name : String, param_remoteInfo : RemoteInfo, param_total : Int, param_pickedUpLayerInterfaceFactoryInterface : PickedUpLayerInterfaceFactoryInterface, param_animationInterface : Animation, param_rectangle : Rectangle, param_viewPosition : ViewPositionBase) extends MultiPlayerGameLayer(param_remoteInfo, BasicGroupFactory.getInstance().NONE_ARRAY, param_name, param_rectangle, param_viewPosition) with PickedUpLayerInterface with PickupableInterface {

    private var pickedUpLayerInterfaceFactoryInterface : PickedUpLayerInterfaceFactoryInterface = CountedPickedUpLayerInterfaceFactory.NULL_COUNTED_PICKUP_LAYER_FACTORY

    private var destroyed : Boolean = false

    private var animationInterface : Animation = NullAnimationFactory.getFactoryInstance().getInstance(0)

    //Constructor
    {
        val name : String = param_name
        val remoteInfo : RemoteInfo = param_remoteInfo
        val total : Int = param_total
        val pickedUpLayerInterfaceFactoryInterface : PickedUpLayerInterfaceFactoryInterface = param_pickedUpLayerInterfaceFactoryInterface
        val animationInterface : Animation = param_animationInterface
        val rectangle : Rectangle = param_rectangle
        val viewPosition : ViewPositionBase = param_viewPosition
        //this.setCollidableInferface(new CollidableAlwaysPickupNeverCollideBehavior(this, true));
        this.setCollidableInferface(CollidableAlwaysPickupNeverCollideBehaviorFactory.getInstance().createBehavior())
        this.setLayerWidth(10)
        this.setLayerHeight(10)
        this.init(pickedUpLayerInterfaceFactoryInterface, animationInterface)
    }

    def init(pickedUpLayerInterfaceFactoryInterface : PickedUpLayerInterfaceFactoryInterface, animationInterface : Animation) : Unit = {
        this.pickedUpLayerInterfaceFactoryInterface = pickedUpLayerInterfaceFactoryInterface
        this.animationInterface = animationInterface
        this.setDestroyed(false)
    }

    def initXYZ(x : Int, y : Int, z : Int) : Unit = {
        this.setPosition(x, y, z)
    }

    override def paint(graphics : Graphics) : Unit = {
        val viewPosition : ViewPositionBase = this.getViewPosition()
        val viewX : Int = viewPosition.getX()
        val viewY : Int = viewPosition.getY()
        this.animationInterface.paintXY(graphics, viewX, viewY)
    }

    override def paintThreed(graphics : Graphics) : Unit = {
        val viewPosition : ViewPositionBase = this.getViewPosition()
        val viewX : Int = viewPosition.getX()
        val viewY : Int = viewPosition.getY()
        this.animationInterface.paintThreedXYZ(graphics, viewX, viewY, 3)
    }

    override def getPickedUpLayerInterfaceFactoryInterface() : PickedUpLayerInterfaceFactoryInterface = {
        return this.pickedUpLayerInterfaceFactoryInterface
    }

    override def setPickedUp() : Unit = {
        this.setDestroyed(true)
    }

    override def isDestroyed() : Boolean = {
        return this.destroyed
    }

    def setDestroyed(destroyed : Boolean) : Unit = {
        this.destroyed = destroyed
        if (this.isDestroyed()) {
            DestroyedLayerProcessor.getInstance().add(this)
        }
    }

    override def damage(damage : Int, damageType : Int) : Unit = {
    }

    override def getDamage(damageType : Int) : Int = {
        return 0
    }

    override def set(gl : GL) : Unit = {
        //OpenGLSurfaceChangedInterface
        var openGLSurfaceChangedInterface : OpenGLSurfaceChangedInterface = this.animationInterface.asInstanceOf[OpenGLSurfaceChangedInterface]
        openGLSurfaceChangedInterface.set(gl)
    }

}


