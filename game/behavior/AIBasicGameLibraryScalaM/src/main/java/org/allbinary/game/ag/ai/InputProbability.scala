/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.game.ag.ai

import _root_.org.allbinary.logic.StdUtil
import _root_.org.allbinary.logic.math.SmallIntegerSingletonFactory
import _root_.org.allbinary.time.TimeDelayHelper
import _root_.org.allbinary.util.ABHashtable

class InputProbability(param_likelyhoodIntegerArray : Array[Array[Integer]], param_repeatLikelyhoodIntegerArray : Array[Integer], param_max : Int, param_timeDelayHelper : TimeDelayHelper) {
    import _root_.org.allbinary.game.ag.ai.InputProbability.{*}

    private var likelyhoodIntegerArray : Array[Array[Integer]] = null

    private var repeatLikelyhoodIntegerArray : Array[Integer] = null

    private var max : Int = 0

    private var timeDelayHelper : TimeDelayHelper = null

    //Constructor
    {
        val likelyhoodIntegerArray : Array[Array[Integer]] = param_likelyhoodIntegerArray
        val repeatLikelyhoodIntegerArray : Array[Integer] = param_repeatLikelyhoodIntegerArray
        val max : Int = param_max
        val timeDelayHelper : TimeDelayHelper = param_timeDelayHelper
        this.likelyhoodIntegerArray = likelyhoodIntegerArray
        this.repeatLikelyhoodIntegerArray = repeatLikelyhoodIntegerArray
        this.max = max
        this.timeDelayHelper = timeDelayHelper
    }

    def getLikelyhoodIntegerArray() : Array[Array[Integer]] = {
        return this.likelyhoodIntegerArray
    }

    def getRepeatLikelyhoodIntegerArray() : Array[Integer] = {
        return this.repeatLikelyhoodIntegerArray
    }

    def getMax() : Int = {
        return this.max
    }

    def getTimeDelayHelper() : TimeDelayHelper = {
        return this.timeDelayHelper
    }

    def toHashtable() : ABHashtable[Object, Object] = {
        var hashtable : ABHashtable[Object, Object] = StdUtil.getInstance().createHashtable()
        hashtable.put(InputProbability.INPUT_PROBABILITY, this)
        return hashtable
    }

}

object InputProbability {
    var INPUT_PROBABILITY : Integer = SmallIntegerSingletonFactory.getInstance().getAt(0)

}


