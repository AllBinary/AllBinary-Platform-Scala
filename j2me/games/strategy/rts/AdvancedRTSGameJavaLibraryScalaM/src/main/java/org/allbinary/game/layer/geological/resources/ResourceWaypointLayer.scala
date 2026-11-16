/*  * AllBinary Open License Version 1  * Copyright (c) 2006 AllBinary  *   * By agreeing to this license you and any business entity you represent are  * legally bound to the AllBinary Open License Version 1 legal agreement.  *   * You may obtain the AllBinary Open License Version 1 legal agreement from  * AllBinary or the root directory of AllBinary's AllBinary Platform repository.  *   * Created By: Travis Berthelot  *   */
/* Generated Code Do Not Modify */
package org.allbinary.game.layer.geological.resources

import _root_.org.allbinary.game.layer.SelectionHudPaintable
import _root_.org.allbinary.game.layer.waypoint.WaypointLayer
import _root_.org.allbinary.animation.AnimationInterfaceFactoryInterface
import _root_.org.allbinary.animation.ProceduralAnimationInterfaceFactoryInterface
import _root_.org.allbinary.game.identification.Group
import _root_.org.allbinary.game.layer.PathFindingLayerInterface
import _root_.org.allbinary.graphics.Rectangle
import _root_.org.allbinary.game.multiplayer.layer.RemoteInfo

class ResourceWaypointLayer(param_remoteInfo : RemoteInfo, param_parentLayer : PathFindingLayerInterface, param_groupInterface : Array[Group], param_rootName : String, param_name : String, param_animationInterfaceFactoryInterface : AnimationInterfaceFactoryInterface, param_proceduralAnimationInterfaceFactoryInterface : ProceduralAnimationInterfaceFactoryInterface, param_rectangle : Rectangle, param_x : Int, param_y : Int) extends WaypointLayer(param_remoteInfo, param_parentLayer, param_groupInterface, param_rootName, param_name, param_animationInterfaceFactoryInterface, param_proceduralAnimationInterfaceFactoryInterface, param_rectangle, param_x, param_y) {

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
    }

    override def createHudPaintable() : SelectionHudPaintable = {
        var rtsLayerHudPaintable : GeologicalResourceInfoHudPaintable = GeologicalResourceInfoHudPaintableSingleton.getInstance()
        rtsLayerHudPaintable.setBasicColorP(this.allBinaryGameLayerManagerP.getForegroundBasicColor())
        rtsLayerHudPaintable.setRtsLayer(this)
        return rtsLayerHudPaintable
    }

    override def getHudPaintable() : SelectionHudPaintable = {
        var rtsLayerHudPaintable : GeologicalResourceInfoHudPaintable = GeologicalResourceInfoHudPaintableSingleton.getInstance()
        return rtsLayerHudPaintable
    }

}


