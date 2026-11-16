/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.game.multiplayer.layer

import _root_.org.allbinary.game.identification.Group
import _root_.org.allbinary.game.layer.special.CollidableDestroyableDamageableLayer
import _root_.org.allbinary.graphics.Rectangle
import _root_.org.allbinary.view.ViewPositionBase

class MultiPlayerGameLayer(param_remoteInfo : RemoteInfo, param_groupInterface : Array[Group], param_name : String, param_layerInfo : Rectangle, param_viewPosition : ViewPositionBase) extends CollidableDestroyableDamageableLayer(param_groupInterface, param_name, param_layerInfo, param_viewPosition) with MultiPlayerGameLayerInterface {

    //Constructor
    {
        val remoteInfo : RemoteInfo = param_remoteInfo
        val groupInterface : Array[Group] = param_groupInterface
        val name : String = param_name
        val layerInfo : Rectangle = param_layerInfo
        val viewPosition : ViewPositionBase = param_viewPosition
    }

    override def getMultiplayerBehavior() : MultiplayerBehavior = {
        return MultiplayerBehavior.NULL_MULTIPLAYER_BEHAVIOR
    }

    def setPingInfo(show : Boolean) : Unit = {
    }

    def setFiring(firing : Short) : Unit = {
    }

    def getFiring() : Short = {
        return 0
    }

}


