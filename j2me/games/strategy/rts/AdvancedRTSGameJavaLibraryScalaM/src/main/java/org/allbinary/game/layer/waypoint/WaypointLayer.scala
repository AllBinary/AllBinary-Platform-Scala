/*  * AllBinary Open License Version 1  * Copyright (c) 2006 AllBinary  *   * By agreeing to this license you and any business entity you represent are  * legally bound to the AllBinary Open License Version 1 legal agreement.  *   * You may obtain the AllBinary Open License Version 1 legal agreement from  * AllBinary or the root directory of AllBinary's AllBinary Platform repository.  *   * Created By: Travis Berthelot  *   */
/* Generated Code Do Not Modify */
package org.allbinary.game.layer.waypoint

import _root_.javax.microedition.lcdui.Graphics
import _root_.org.allbinary.animation.AnimationInterfaceFactoryInterface
import _root_.org.allbinary.animation.ProceduralAnimationInterfaceFactoryInterface
import _root_.org.allbinary.game.health.Health
import _root_.org.allbinary.game.identification.Group
import _root_.org.allbinary.game.input.form.NullRTSFormInputFactory
import _root_.org.allbinary.game.layer.AdvancedRTSGameLayer
import _root_.org.allbinary.game.layer.AdvancedRTSProperties
import _root_.org.allbinary.game.layer.PathFindingLayerInterface
import _root_.org.allbinary.game.view.TileLayerPositionIntoViewPosition
import _root_.org.allbinary.graphics.Rectangle
import _root_.org.allbinary.layer.AllBinaryLayerManager
import _root_.org.allbinary.game.layer.RTSPlayerLayerInterface
import _root_.org.allbinary.game.multiplayer.layer.RemoteInfo
import _root_.org.allbinary.media.audio.AttackSound

/**  *  * @author user  */
class WaypointLayer(param_remoteInfo : RemoteInfo, param_parentLayer : PathFindingLayerInterface, param_groupInterface : Array[Group], param_rootName : String, param_name : String, param_animationInterfaceFactoryInterface : AnimationInterfaceFactoryInterface, param_proceduralAnimationInterfaceFactoryInterface : ProceduralAnimationInterfaceFactoryInterface, param_rectangle : Rectangle, param_x : Int, param_y : Int) extends AdvancedRTSGameLayer(param_remoteInfo, param_parentLayer, AdvancedRTSProperties.createProperties(), param_groupInterface, param_rootName, param_name, new Health(1000), NullRTSFormInputFactory.getInstance(), param_animationInterfaceFactoryInterface, param_animationInterfaceFactoryInterface, param_animationInterfaceFactoryInterface, param_animationInterfaceFactoryInterface, param_animationInterfaceFactoryInterface, param_proceduralAnimationInterfaceFactoryInterface, param_rectangle, param_x, param_y, new TileLayerPositionIntoViewPosition()) {
    import _root_.org.allbinary.game.layer.waypoint.WaypointLayer.{*}

    //Constructor
    {
        val remoteInfo : RemoteInfo = param_remoteInfo
        val parentLayer : PathFindingLayerInterface = param_parentLayer
        val groupInterface : Array[Group] = param_groupInterface
        val rootName : String = param_rootName
        val name : String = param_name
        val animationInterfaceFactoryInterface : AnimationInterfaceFactoryInterface = param_animationInterfaceFactoryInterface
        val proceduralAnimationInterfaceFactoryInterface : ProceduralAnimationInterfaceFactoryInterface = param_proceduralAnimationInterfaceFactoryInterface
        val rectangle : Rectangle = param_rectangle
        val x : Int = param_x
        val y : Int = param_y
        //this.logUtil.putF(this.commonStrings.START, this, this.commonStrings.CONSTRUCTOR);
        this.setCollidableInferface(new CollidableWaypointBehavior(true))
        this.getWaypointBehavior().setWaypoint(new Waypoint(this, AttackSound.getInstance()))
        this.setAnimationInterface(this.indexedButShouldBeRotationAnimationInterface)
    }

    /*     public WaypointLayer()         throws Exception     {         super();     }     */
    override def construct(rtsPlayerLayerInterface : RTSPlayerLayerInterface) : Unit = {
        this.percentCompleteP = 100
        //Bots don't show waypoints
        this.initVisibility(rtsPlayerLayerInterface)
    }

    override def paint(graphics : Graphics) : Unit = {
        if (this.isVisible()) {
            super.paint(graphics)
        }
    }

    override def processTick(allBinaryLayerManager : AllBinaryLayerManager) : Unit = {
        try {
            this.indexedButShouldBeRotationAnimationInterface.nextFrame()
        } catch {
            case e : Exception => {
                this.logUtil.put(this.commonStrings.EXCEPTION, this, "processTick", e)
            }
        }
    }

    override def damage(damage : Int, damageType : Int) : Unit = {
    }

    override def getDamage(damageType : Int) : Int = {
        return 0
    }

    override def setDestroyed(destroyed : Boolean) : Unit = {
        super.setDestroyed(destroyed)
        if (this.isDestroyed()) {
            WaypointCellPositionHistory.getInstance().removeLayer(this)
        }
    }

    override def getType() : Int = {
        return WaypointLayer.getStaticType()
    }

    override def isSelfUpgradeable() : Boolean = {
        return false
    }

}

object WaypointLayer {
    def getStaticType() : Int = {
        return 4
    }

}


