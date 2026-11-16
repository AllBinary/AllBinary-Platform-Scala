/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.media.graphics.geography.pathfinding

import _root_.org.allbinary.logic.StdUtil
import _root_.org.allbinary.util.ABHashtable
import _root_.org.allbinary.util.BasicArrayList
import _root_.org.allbinary.util.BasicArrayListUtil

class PathCacheFactory private() {
    import _root_.org.allbinary.media.graphics.geography.pathfinding.PathCacheFactory.{*}

    private val basicArrayListUtil : BasicArrayListUtil = BasicArrayListUtil.getInstance()

    private val hashtable : ABHashtable[Object, Object] = StdUtil.getInstance().createHashtable()

    def getSize() : Int = {
        return this.hashtable.size()
    }

    def add(pathId : Integer, list : BasicArrayList) : Unit = {
        this.hashtable.put(pathId, list)
    }

    def remove(pathId : Integer) : Unit = {
        this.hashtable.remove(pathId)
    }

    def removeAll() : Unit = {
        this.hashtable.clear()
        if (this.hashtable.size() > 0) {
            throw new Exception("Did not clear")
        }
    }

    def getOrCreate(pathIdInteger : Integer) : BasicArrayList = {
        var listCanBeNull : Object = this.hashtable.get(pathIdInteger)
        if (listCanBeNull == null) {
            listCanBeNull = this.basicArrayListUtil.getImmutableInstance()
        }
        return listCanBeNull.asInstanceOf[BasicArrayList]
    }

}

object PathCacheFactory {
    private var pathFactory : PathCacheFactory = new PathCacheFactory()

    def getInstance() : PathCacheFactory = {
        return PathCacheFactory.pathFactory
    }

}


