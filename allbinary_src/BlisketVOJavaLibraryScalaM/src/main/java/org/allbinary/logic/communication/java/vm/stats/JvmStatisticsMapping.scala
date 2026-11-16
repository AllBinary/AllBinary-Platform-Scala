/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.logic.communication.java.vm.stats

import _root_.java.util.HashMap
import _root_.org.allbinary.util.BasicArrayList
import _root_.org.allbinary.util.BasicArrayListD
import _root_.org.allbinary.data.tables.TableMappingInterface
import _root_.org.allbinary.logic.StdUtil

class JvmStatisticsMapping() extends JvmStatistics() with TableMappingInterface {

    def toHashMap() : HashMap[Object, Object] = {
        var hashMap : HashMap[Object, Object] = StdUtil.getInstance().createHashMap().asInstanceOf[HashMap[Object, Object]]
        hashMap.put(JvmStatisticsData.FREE_MEMORY_BYTES, this.getFreeMemoryBytesString())
        hashMap.put(JvmStatisticsData.FREE_MEMORY_KILOBYTES, this.getFreeMemoryKilobytesString())
        hashMap.put(JvmStatisticsData.FREE_MEMORY_MEGABYTES, this.getFreeMemoryMegabytesString())
        hashMap.put(JvmStatisticsData.MAX_MEMORY_BYTES, this.getMaxMemoryBytesString())
        hashMap.put(JvmStatisticsData.MAX_MEMORY_KILOBYTES, this.getMaxMemoryKilobytesString())
        hashMap.put(JvmStatisticsData.MAX_MEMORY_MEGABYTES, this.getMaxMemoryMegabytesString())
        hashMap.put(JvmStatisticsData.NUMBER_OF_THREADS, this.getNumberOfThreadsString())
        hashMap.put(JvmStatisticsData.TOTAL_MEMORY_BYTES, this.getTotalMemoryBytesString())
        hashMap.put(JvmStatisticsData.TOTAL_MEMORY_KILOBYTES, this.getTotalMemoryKilobytesString())
        hashMap.put(JvmStatisticsData.TOTAL_MEMORY_MEGABYTES, this.getTotalMemoryMegabytesString())
        return hashMap
    }

    def getKey() : Object = {
        return JvmStatisticsData.NAME
    }

    def toVector() : BasicArrayList = {
        var vector : BasicArrayList = new BasicArrayListD()
        vector.add(this.getFreeMemoryBytesString())
        vector.add(this.getFreeMemoryKilobytesString())
        vector.add(this.getFreeMemoryMegabytesString())
        vector.add(this.getMaxMemoryBytesString())
        vector.add(this.getMaxMemoryKilobytesString())
        vector.add(this.getMaxMemoryMegabytesString())
        vector.add(this.getNumberOfThreadsString())
        vector.add(this.getTotalMemoryBytesString())
        vector.add(this.getTotalMemoryKilobytesString())
        vector.add(this.getTotalMemoryMegabytesString())
        return vector
    }

}


