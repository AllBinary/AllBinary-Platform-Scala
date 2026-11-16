/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.game.ag.layer.pickup

import _root_.org.allbinary.game.multiplayer.layer.RemoteInfo
import _root_.org.allbinary.layer.AllBinaryLayer
import _root_.org.allbinary.layer.AllBinaryLayerFactoryInterface

class FallingPickupLayerFactory extends AllBinaryLayerFactoryInterface {

    override def getInstance() : AllBinaryLayer = {
        return new FallingPickupLayer(RemoteInfo.REMOTE_INFO)
    }

}


