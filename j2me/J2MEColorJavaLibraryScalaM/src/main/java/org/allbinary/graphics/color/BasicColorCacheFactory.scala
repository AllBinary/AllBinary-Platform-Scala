/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.graphics.color

import _root_.org.allbinary.logic.StdUtil
import _root_.org.allbinary.util.ABHashtable

class BasicColorCacheFactory private() {
    import _root_.org.allbinary.graphics.color.BasicColorCacheFactory.{*}

    private val hashtable : ABHashtable[Object, Object] = StdUtil.getInstance().createHashtable()

    def add(basicDefaultColor : BasicColor) : Unit = {
        // hashtable.put(Integer.valueOf(value), this);
        this.hashtable.put(new Integer(basicDefaultColor.intValue()), basicDefaultColor)
    }

    def getAndOrCreate(integer : Integer) : BasicColor = this.synchronized {
        var basicColor : BasicColor = this.hashtable.get(integer).asInstanceOf[BasicColor]
        if (basicColor == null) {
            basicColor = BasicColorFactory.getInstance().createInstance(integer.intValue())
            this.hashtable.put(integer, basicColor)
        }
        return basicColor
    }

}

object BasicColorCacheFactory {
    private val instance : BasicColorCacheFactory = new BasicColorCacheFactory()

    def getInstance() : BasicColorCacheFactory = {
        return BasicColorCacheFactory.instance
    }

}


