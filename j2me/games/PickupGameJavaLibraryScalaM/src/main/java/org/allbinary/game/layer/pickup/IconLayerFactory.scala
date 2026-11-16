/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.game.layer.pickup

import _root_.org.allbinary.animation.Animation

class IconLayerFactory {
    import _root_.org.allbinary.game.layer.pickup.IconLayerFactory.{*}

}

object IconLayerFactory {
    def getInstance(animationInterface : Animation, width : Int, height : Int) : IconLayer = {
        return new IconLayer(animationInterface, width, height)
    }

}


