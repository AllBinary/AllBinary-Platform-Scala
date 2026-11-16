/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.game.ag.layer.weapon.mine

import _root_.org.allbinary.ag.weapon.media.audio.DropWeaponSound
import _root_.org.allbinary.animation.FeaturedAnimationInterfaceFactoryInterfaceFactory
import _root_.org.allbinary.game.layer.weapon.SimpleWeaponLayer
import _root_.org.allbinary.game.multiplayer.layer.RemoteInfo
import _root_.org.allbinary.graphics.PointFactory
import _root_.org.allbinary.graphics.Rectangle
import _root_.org.allbinary.layer.AllBinaryLayer
import _root_.org.allbinary.media.audio.SecondaryPlayerQueueFactory
import _root_.org.allbinary.physics.movement.NoMovementFactory
import _root_.org.allbinary.view.ViewPositionBase
import _root_.org.allbinary.view.event.ViewPositionEventHandler

class MineLayer(param_viewPosition : ViewPositionBase) extends SimpleWeaponLayer(MineLayer.NAME, RemoteInfo.REMOTE_INFO, -1, NoMovementFactory.getInstance().getMovmentInstance(), FeaturedAnimationInterfaceFactoryInterfaceFactory.getInstance().get(MineWeaponResources.getInstance().RESOURCE).getInstance(0), SimpleWeaponLayer.createDestroyed(), new Rectangle(PointFactory.getInstance().ZERO_ZERO, 10, 10), param_viewPosition) {
    import _root_.org.allbinary.game.ag.layer.weapon.mine.MineLayer.{*}

    /*    public MineLayer(LayerInterface sourceLayerInterface, int x, int y, ViewPositionBase viewPosition, short angle, int damage, ScoreableInterface scoreable)            throws Exception    {       super(sourceLayerInterface,               NoMovementFactory,          //new BasicConstantVelocityMovement(SPEED),          new VectorRotationAnimation(MineVectorData.points, BasicColor.GREY),          new Rectangle(PointFactory.getInstance(x + HALF_SIZEX, y + HALF_SIZEY), SIZEX, SIZEY),            angle, damage, scoreable);              DropWeaponSound.getInstance().getPlayerP().start();    }    */
    private val viewPositionEventHandler : ViewPositionEventHandler = ViewPositionEventHandler.getInstance()

    //private static final BasicDecimal SPEED = new BasicDecimal(0);
    //Constructor
    {
        val viewPosition : ViewPositionBase = param_viewPosition
    }

    override def initXYZ(x : Int, y : Int, z : Int) : Unit = {
        this.setPosition(x + 5, y + 5, z)
        this.viewPositionEventHandler.addListener(this.asInstanceOf[AllBinaryLayer])
        SecondaryPlayerQueueFactory.getInstance().add(DropWeaponSound.getInstance())
    }

    override def damage(damage : Int, damageType : Int) : Unit = {
        this.totalDamage = this.getInitDamage() + 1
    }

    override def getDamage(damageType : Int) : Int = {
        super.getDamage(damageType)
        return this.getInitDamage()
    }

    override def setDestroyed(destroyed : Boolean) : Unit = {
        super.setDestroyed(destroyed)
        if (this.isDestroyed()) {
            this.viewPositionEventHandler.removeListener(this)
        }
    }

}

object MineLayer {
    private val NAME : String = "MineLayer"

}


