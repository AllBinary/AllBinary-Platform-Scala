/*  * AllBinary Open License Version 1  * Copyright (c) 2011 AllBinary  *   * By agreeing to this license you and any business entity you represent are  * legally bound to the AllBinary Open License Version 1 legal agreement.  *   * You may obtain the AllBinary Open License Version 1 legal agreement from  * AllBinary or the root directory of AllBinary's AllBinary Platform repository.  *   * Created By: Travis Berthelot  *   */
/* Generated Code Do Not Modify */
package org.allbinary.layer

import _root_.org.allbinary.graphics.Rectangle
import _root_.org.allbinary.logic.string.StringUtil
import _root_.org.allbinary.view.ViewPosition

class AllBinaryLayerFactory(param_rectangle : Rectangle) extends AllBinaryLayerFactoryInterface {

    private var rectangle : Rectangle = null

    //Constructor
    {
        val rectangle : Rectangle = param_rectangle
        this.rectangle = rectangle
    }

    override def getInstance() : AllBinaryLayer = {
        return new AllBinaryLayer(StringUtil.getInstance().EMPTY_STRING, this.rectangle, ViewPosition.getInstanceD())
    }

}


