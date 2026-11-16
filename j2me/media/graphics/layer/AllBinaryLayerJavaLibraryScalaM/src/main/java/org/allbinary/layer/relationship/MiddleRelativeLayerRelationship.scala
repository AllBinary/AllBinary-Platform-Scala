/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.layer.relationship

import _root_.org.allbinary.graphics.PointFactory
import _root_.org.allbinary.layer.AllBinaryLayer
import _root_.org.allbinary.util.BasicArrayListUtil

class MiddleRelativeLayerRelationship(param_layer : AllBinaryLayer) extends RelativeLayerRelationship(param_layer, PointFactory.getInstance().createXY(param_layer.getHalfWidth(), param_layer.getHalfHeight()), BasicArrayListUtil.getInstance().getImmutableInstance()) {

    //Constructor
    {
        val layer : AllBinaryLayer = param_layer
    }

}


