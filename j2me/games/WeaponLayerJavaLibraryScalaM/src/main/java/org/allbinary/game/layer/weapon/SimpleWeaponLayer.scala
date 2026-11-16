/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.game.layer.weapon

import _root_.org.allbinary.animation.Animation
import _root_.org.allbinary.animation.FeaturedAnimationInterfaceFactoryInterfaceFactory
import _root_.org.allbinary.animation.NullIndexedAnimationFactory
import _root_.org.allbinary.game.combat.damage.ExplosionResources
import _root_.org.allbinary.game.multiplayer.layer.RemoteInfo
import _root_.org.allbinary.graphics.Rectangle
import _root_.org.allbinary.physics.movement.Movement
import _root_.org.allbinary.view.ViewPositionBase

class SimpleWeaponLayer(param_name : String, param_remoteInfo : RemoteInfo, param_multiPlayerType : Int, param_movement : Movement, param_animationInterface : Animation, param_destroyedAnimationInterface : Animation, param_rectangle : Rectangle, param_viewPosition : ViewPositionBase) extends WeaponLayer(param_name, param_remoteInfo, param_multiPlayerType, param_movement, param_animationInterface, param_destroyedAnimationInterface, param_rectangle, param_viewPosition) {
    import _root_.org.allbinary.game.layer.weapon.SimpleWeaponLayer.{*}

    //Constructor
    {
        val name : String = param_name
        val remoteInfo : RemoteInfo = param_remoteInfo
        val multiPlayerType : Int = param_multiPlayerType
        val movement : Movement = param_movement
        val animationInterface : Animation = param_animationInterface
        val destroyedAnimationInterface : Animation = param_destroyedAnimationInterface
        val rectangle : Rectangle = param_rectangle
        val viewPosition : ViewPositionBase = param_viewPosition
        this.setCollidableInferface(new CollidableWeaponBehavior(true))
    }

}

object SimpleWeaponLayer {
    def createDestroyed() : Animation = {
        return FeaturedAnimationInterfaceFactoryInterfaceFactory.getInstance().getProcedural(ExplosionResources.getInstance().THIRD_EXPLOSION_RESOURCE).getInstanceAnimation(NullIndexedAnimationFactory.getFactoryInstance().getInstance(0))
    }

}


