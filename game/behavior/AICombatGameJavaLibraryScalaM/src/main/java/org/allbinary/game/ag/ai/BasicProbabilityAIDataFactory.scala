/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.game.ag.ai

import _root_.javax.microedition.lcdui.Canvas
import _root_.org.allbinary.logic.math.SmallIntegerSingletonFactory
import _root_.org.allbinary.time.NoTimeDelayHelper
import _root_.org.allbinary.util.ABHashtable

class BasicProbabilityAIDataFactory {

    def getInstance() : ABHashtable[Object, Object] = {
        val likelyhoodIntegerArray : Array[Array[Integer]] = Array.ofDim[Integer](Canvas.KEY_NUM9 + 1, 2)
        val smallIntegerSingletonFactory : SmallIntegerSingletonFactory = SmallIntegerSingletonFactory.getInstance()
        likelyhoodIntegerArray(Canvas.UP)(0) = smallIntegerSingletonFactory.getAt(0)
        likelyhoodIntegerArray(Canvas.UP)(1) = smallIntegerSingletonFactory.getAt(10)
        likelyhoodIntegerArray(Canvas.DOWN)(0) = smallIntegerSingletonFactory.getAt(10)
        likelyhoodIntegerArray(Canvas.DOWN)(1) = smallIntegerSingletonFactory.getAt(14)
        likelyhoodIntegerArray(Canvas.LEFT)(0) = smallIntegerSingletonFactory.getAt(14)
        likelyhoodIntegerArray(Canvas.LEFT)(1) = smallIntegerSingletonFactory.getAt(18)
        likelyhoodIntegerArray(Canvas.RIGHT)(0) = smallIntegerSingletonFactory.getAt(18)
        likelyhoodIntegerArray(Canvas.RIGHT)(1) = smallIntegerSingletonFactory.getAt(22)
        likelyhoodIntegerArray(Canvas.KEY_NUM7)(0) = smallIntegerSingletonFactory.getAt(22)
        likelyhoodIntegerArray(Canvas.KEY_NUM7)(1) = smallIntegerSingletonFactory.getAt(26)
        likelyhoodIntegerArray(Canvas.KEY_NUM9)(0) = smallIntegerSingletonFactory.getAt(26)
        likelyhoodIntegerArray(Canvas.KEY_NUM9)(1) = smallIntegerSingletonFactory.getAt(30)
        likelyhoodIntegerArray(Canvas.KEY_NUM1)(0) = smallIntegerSingletonFactory.getAt(30)
        likelyhoodIntegerArray(Canvas.KEY_NUM1)(1) = smallIntegerSingletonFactory.getAt(40)
        val repeatLikelyhoodIntegerArray : Array[Integer] = new Array[Integer](Canvas.KEY_NUM9 + 1)
        repeatLikelyhoodIntegerArray(Canvas.UP) = smallIntegerSingletonFactory.getAt(0)
        repeatLikelyhoodIntegerArray(Canvas.DOWN) = smallIntegerSingletonFactory.getAt(0)
        repeatLikelyhoodIntegerArray(Canvas.LEFT) = smallIntegerSingletonFactory.getAt(0)
        repeatLikelyhoodIntegerArray(Canvas.RIGHT) = smallIntegerSingletonFactory.getAt(0)
        repeatLikelyhoodIntegerArray(Canvas.KEY_NUM7) = smallIntegerSingletonFactory.getAt(0)
        repeatLikelyhoodIntegerArray(Canvas.KEY_NUM9) = smallIntegerSingletonFactory.getAt(0)
        repeatLikelyhoodIntegerArray(Canvas.KEY_NUM1) = smallIntegerSingletonFactory.getAt(10)
        val inputProbability : InputProbability = new InputProbability(likelyhoodIntegerArray, repeatLikelyhoodIntegerArray, 42, NoTimeDelayHelper.SINGLETON)
        return inputProbability.toHashtable()
    }

}


