/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.graphics.pipeline

import _root_.org.allbinary.game.rand.MyRandomFactory
import _root_.org.allbinary.math.AngleFactory
import _root_.org.allbinary.util.BasicArrayList

class RandomRotationFactory {
    import _root_.org.allbinary.graphics.pipeline.RandomRotationFactory.{*}

    private val myRandomFactory : MyRandomFactory = MyRandomFactory.getInstance()

    private val angleFactory : AngleFactory = AngleFactory.getInstance()

    def getInstanceList(vector : BasicArrayList, howMuch : Int) : BasicArrayList = {
        val graphicsPipe : BasicGraphicsPipeline = new BasicGraphicsPipeline(vector)
        graphicsPipe.createMatrix()
        graphicsPipe.rotateToAngle(this.angleFactory.getAt(this.getNextRandomAngle(howMuch)))
        return graphicsPipe.getMatrix()
    }

    def getNextRandomAngle(howMuch : Int) : Int = {
        // / (Integer.MAX_VALUE / ());
        return this.myRandomFactory.getNextInt(howMuch * 10)
    }

}

object RandomRotationFactory {
    private val instance : RandomRotationFactory = new RandomRotationFactory()

    def getInstance() : RandomRotationFactory = {
        return RandomRotationFactory.instance
    }

}


