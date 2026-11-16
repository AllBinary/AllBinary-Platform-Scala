/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.game.layer

import _root_.java.util.Enumeration
import _root_.org.allbinary.layer.Layer
import _root_.org.allbinary.logic.math.SmallIntegerSingletonFactory
import _root_.org.allbinary.util.ABHashtable
import _root_.org.allbinary.util.BasicArrayList
import _root_.org.allbinary.util.BasicArrayListD
import _root_.org.allbinary.util.EnumerationUtil

/**  *  * TWB - SmallIntegerSingletonFactory may not be needed  */
class LevelLayersFinder {
    import _root_.org.allbinary.game.layer.LevelLayersFinder.{*}

    private val enumerationUtil : EnumerationUtil = EnumerationUtil.getInstance()

    def get(hashtable : ABHashtable[Object, Object]) : BasicArrayList = {
        val smallIntegerSingletonFactory : SmallIntegerSingletonFactory = SmallIntegerSingletonFactory.getInstance()
        val list : BasicArrayList = new BasicArrayListD()
        val enumeration : Enumeration[? <: Object] = hashtable.keys().asInstanceOf[Enumeration[? <: Object]]
        var layerHashtableCanBeNull : ABHashtable[Object, Object] = null
        var integerCanBeNull : Integer = null
        var cachedIntegerCanBeNull : Integer = null

        {
            while (this.enumerationUtil.hasMoreElements(enumeration)) {
                layerHashtableCanBeNull = hashtable.get(this.enumerationUtil.nextElement(enumeration).asInstanceOf[Object]).asInstanceOf[ABHashtable[Object, Object]]
                integerCanBeNull = layerHashtableCanBeNull.get(Layer.ID.asInstanceOf[Object]).asInstanceOf[Integer]
                cachedIntegerCanBeNull = smallIntegerSingletonFactory.getAt(integerCanBeNull.intValue())
                if (!list.contains(cachedIntegerCanBeNull)) {
                    list.add(cachedIntegerCanBeNull)
                }
            }
        }
        return list
    }

}

object LevelLayersFinder {
    private val instance : LevelLayersFinder = new LevelLayersFinder()

    def getInstance() : LevelLayersFinder = {
        return LevelLayersFinder.instance
    }

}


