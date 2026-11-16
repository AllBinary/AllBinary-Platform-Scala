/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.graphics.pipeline

import _root_.org.allbinary.game.rand.MyRandomFactory
import _root_.org.allbinary.util.BasicArrayList

class RandomTranslation {
    import _root_.org.allbinary.graphics.pipeline.RandomTranslation.{*}

}

object RandomTranslation {
    def getInstance(vector : BasicArrayList, howMuch : Int) : BasicArrayList = {
        val myRandomFactory : MyRandomFactory = MyRandomFactory.getInstance()
        var x : Int = -myRandomFactory.getNextInt(howMuch)
        var y : Int = myRandomFactory.getNextInt(howMuch)
        var graphicsPipe : BasicGraphicsPipeline = new BasicGraphicsPipeline(vector)
        graphicsPipe.createMatrix()
        graphicsPipe.translate(x, y)
        return graphicsPipe.getMatrix()
    }

}


