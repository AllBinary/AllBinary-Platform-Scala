/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.game.ag.layer.weapon.mine

import _root_.org.allbinary.layer.AllBinaryLayer
import _root_.org.allbinary.layer.AllBinaryLayerFactoryInterface
import _root_.org.allbinary.view.ViewPositionFactoryInterface

class MineLayerFactory(param_viewPositionFactoryInterface : ViewPositionFactoryInterface) extends AllBinaryLayerFactoryInterface {

    private var viewPositionFactoryInterface : ViewPositionFactoryInterface = null

    //Constructor
    {
        val viewPositionFactoryInterface : ViewPositionFactoryInterface = param_viewPositionFactoryInterface
        this.viewPositionFactoryInterface = viewPositionFactoryInterface
    }

    override def getInstance() : AllBinaryLayer = {
        return new MineLayer(this.viewPositionFactoryInterface.getInstance())
    }

}


