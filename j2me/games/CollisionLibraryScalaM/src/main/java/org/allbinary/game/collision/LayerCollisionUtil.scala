/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.game.collision

import _root_.org.allbinary.game.configuration.feature.Features
import _root_.org.allbinary.game.configuration.feature.GameFeatureFactory
import _root_.org.allbinary.graphics.opengles.OpenGLFeatureUtil
import _root_.org.allbinary.layer.AllBinaryLayer

class LayerCollisionUtil private() {
    import _root_.org.allbinary.game.collision.LayerCollisionUtil.{*}

    private var collisionProcessor : CollisionProcessor = null

    //Constructor
    {
        var features : Features = Features.getInstance()
        var gameFeatureFactory : GameFeatureFactory = GameFeatureFactory.getInstance()
        if (OpenGLFeatureUtil.getInstance().isAnyThreed() && !features.isFeature(gameFeatureFactory.COLLISIONS_FORCED_TWO_DIMENSIONAL)) {
            this.collisionProcessor = new CollisionThreedProcessor()
        } else {
            this.collisionProcessor = new Collision2DProcessor()
        }
    }

    def isCollision(myLayer : AllBinaryLayer, myLayer2 : AllBinaryLayer) : Boolean = {
        return this.collisionProcessor.isCollision(myLayer, myLayer2)
    }

}

object LayerCollisionUtil {
    private val instance : LayerCollisionUtil = new LayerCollisionUtil()

    def getInstance() : LayerCollisionUtil = {
        return LayerCollisionUtil.instance
    }

}


