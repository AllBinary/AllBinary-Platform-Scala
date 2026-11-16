/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.android.input.motion

import _root_.org.allbinary.game.input.analog.AnalogLocationInput
import _root_.org.allbinary.game.input.analog.AnalogLocationInputFactory
import _root_.org.allbinary.layer.AllBinaryLayerManager
import _root_.org.allbinary.util.BasicArrayList

class AllAnalogControllerVisitor extends AnalogControllerVisitor {

    override def process(allbinaryLayerManager : AllBinaryLayerManager, analogLocationInputProcessor : AnalogLocationInputProcessor) : Unit = {
        val analogLocationInputList : BasicArrayList = AnalogLocationInputFactory.getInstance().getList()
        var analogLocationInput : AnalogLocationInput = null

        {
            var index : Int = analogLocationInputList.size() - 1
            while (index >= 0) {
                analogLocationInput = analogLocationInputList.get(index).asInstanceOf[AnalogLocationInput]
                analogLocationInputProcessor.process(allbinaryLayerManager, analogLocationInput)
                index -= 1
            }
        }
    }

}


