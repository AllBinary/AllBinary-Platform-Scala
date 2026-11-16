/* Generated Code Do Not Modify */
package org.allbinary.media.graphics.geography.pathfinding

import _root_.org.allbinary.util.BasicArrayList
import _root_.org.allbinary.logic.util.cache.BaseBasicArrayListCache
import _root_.org.allbinary.util.BasicArrayListS

class BasicGeographicMapExtractedPathsCacheFactory private() extends BaseBasicArrayListCache {
    import _root_.org.allbinary.media.graphics.geography.pathfinding.BasicGeographicMapExtractedPathsCacheFactory.{*}

    private var maxConcurrentPaths : Int = 0

    private var maxPaths : Int = 0

    def init(maxConcurrentPaths : Int, maxPaths : Int) : Unit = {
        //maxPaths = 0;
        if (maxConcurrentPaths != this.maxConcurrentPaths) {

            {
                var index : Int = maxConcurrentPaths
                while (index >= this.maxConcurrentPaths) {
                    this.list.add(new BasicArrayListS(maxPaths))
                    index -= 1
                }
            }
            this.maxConcurrentPaths = maxConcurrentPaths
        }
        this.maxPaths = maxPaths
    }

    def getPaths() : BasicArrayList = {
        if (this.list.size() > 0) {
            return this.list.removeAt(0).asInstanceOf[BasicArrayList]
        } else {
            return new BasicArrayListS(this.maxPaths)
        }
        throw new IllegalStateException()
    }

    def release(list : BasicArrayList) : Unit = {
        //PreLogUtil.put("paths: " + BasicArrayListUtil.log(list), this, "release");

        {
            var index : Int = list.size() - 1
            while (index >= 0) {
                BasicGeographicMapExtractedPathCacheFactory.getInstance().release(list.get(index).asInstanceOf[BasicArrayList])
                index -= 1
            }
        }
        list.clear()
        this.list.add(list)
    }

}

object BasicGeographicMapExtractedPathsCacheFactory {
    //protected final LogUtil logUtil = LogUtil.getInstance();
    private val instance : BasicGeographicMapExtractedPathsCacheFactory = new BasicGeographicMapExtractedPathsCacheFactory()

    /**      * @return the instance      */
    def getInstance() : BasicGeographicMapExtractedPathsCacheFactory = {
        return BasicGeographicMapExtractedPathsCacheFactory.instance
    }

}


