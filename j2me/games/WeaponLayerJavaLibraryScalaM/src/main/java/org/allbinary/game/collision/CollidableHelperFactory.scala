/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.game.collision

import _root_.org.allbinary.game.configuration.feature.Features
import _root_.org.allbinary.game.configuration.feature.GameFeatureFactory
import _root_.org.allbinary.layer.AllBinaryLayer

/**  *  * @author user  */
class CollidableHelperFactory {
    import _root_.org.allbinary.game.collision.CollidableHelperFactory.{*}

}

object CollidableHelperFactory {
    def getInstance() : CollisionHelper = {
        if (Features.getInstance().isFeature(GameFeatureFactory.getInstance().COLLISIONS_WITH_SOURCE)) {
            return new CollisionHelper(AllBinaryLayer.NULL_ALLBINARY_LAYER)
        } else {
            return new SourceCollisionHelper(AllBinaryLayer.NULL_ALLBINARY_LAYER)
        }
        throw new IllegalStateException()
    }

}


