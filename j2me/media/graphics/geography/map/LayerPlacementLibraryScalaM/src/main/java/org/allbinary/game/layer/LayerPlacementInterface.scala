/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.game.layer

import _root_.org.allbinary.util.ABHashtable

trait LayerPlacementInterface {

    def getWidth() : Int

    def getHeight() : Int

    def getLayerType() : LayerPlacementType

    def getInstance() : ABHashtable[Object, Object]

}


