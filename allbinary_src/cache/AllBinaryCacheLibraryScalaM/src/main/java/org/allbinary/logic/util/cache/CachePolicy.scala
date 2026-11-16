/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.logic.util.cache


class CachePolicy(param_name : String, param_maxTime : Long, param_maxSize : Long) {

    private var name : String = null

    private var maxTime : Long = 0L

    private var maxSize : Long = 0L

    //Constructor
    {
        val name : String = param_name
        val maxTime : Long = param_maxTime
        val maxSize : Long = param_maxSize
        this.name = name
        this.setMaxTime(maxTime)
        this.setMaxSize(maxSize)
    }

    def getMaxTime() : Long = {
        return this.maxTime
    }

    def setMaxTime(maxTime : Long) : Unit = {
        this.maxTime = maxTime
    }

    def getMaxSize() : Long = {
        return this.maxSize
    }

    def setMaxSize(maxSize : Long) : Unit = {
        this.maxSize = maxSize
    }

    def getName() : String = {
        return this.name
    }

}


