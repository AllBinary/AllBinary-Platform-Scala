/* Generated Code Do Not Modify */
package org.allbinary.game.layer.weapon

import _root_.org.allbinary.animation.Animation
import _root_.org.allbinary.game.combat.weapon.WeaponProperties
import _root_.org.allbinary.game.multiplayer.layer.RemoteInfo
import _root_.org.allbinary.graphics.Rectangle
import _root_.org.allbinary.layer.AllBinaryLayerManager
import _root_.org.allbinary.physics.movement.Movement
import _root_.org.allbinary.time.GameTickTimeDelayHelperFactory
import _root_.org.allbinary.time.TimeDelayHelper
import _root_.org.allbinary.view.ViewPositionBase

class TempExplosionWeaponLayer(param_name : String, param_movement : Movement, param_animationInterface : Animation, param_rectangle : Rectangle, param_viewPosition : ViewPositionBase, param_timeDelay : Int) extends SimpleWeaponLayer(param_name, RemoteInfo.REMOTE_INFO, -1, param_movement, param_animationInterface, SimpleWeaponLayer.createDestroyed(), param_rectangle, param_viewPosition) {

    //protected final LogUtil logUtil = LogUtil.getInstance();
    val weaponProperties : WeaponProperties = new WeaponProperties(-1L, -1L, 0, 1000, (0).toShort)

    private val timeDelayHelper : TimeDelayHelper = new TimeDelayHelper(0)

    //Constructor
    {
        val name : String = param_name
        val movement : Movement = param_movement
        val animationInterface : Animation = param_animationInterface
        val rectangle : Rectangle = param_rectangle
        val viewPosition : ViewPositionBase = param_viewPosition
        val timeDelay : Int = param_timeDelay
        this.timeDelayHelper.delay = timeDelay
    }

    override def processTick(allBinaryLayerManager : AllBinaryLayerManager) : Unit = {
        if (this.timeDelayHelper.isTime(GameTickTimeDelayHelperFactory.getInstance().startTime)) {
            this.getCollidableInferface().collide(this, this)
            this.totalDamage = this.getInitDamage() + 1
        }
        super.processTick(allBinaryLayerManager)
    }

}


