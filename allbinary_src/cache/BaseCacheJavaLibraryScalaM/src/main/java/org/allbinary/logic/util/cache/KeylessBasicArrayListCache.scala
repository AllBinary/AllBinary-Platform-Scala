/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.logic.util.cache

import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.logic.string.StringMaker
import _root_.org.allbinary.util.BasicArrayList
import _root_.org.allbinary.util.BasicArrayListUtil

/**  *  * @author user  */
class KeylessBasicArrayListCache() extends IndexedBasicArrayListCache {

    val logUtil : LogUtil = LogUtil.getInstance()

    val basicArrayListUtil : BasicArrayListUtil = BasicArrayListUtil.getInstance()

    def get() : BasicArrayList = {
        try {
            if (this.index >= this.list.size()) {
                this.addDefault()
            }
            val list : BasicArrayList = this.getAt({ val value_N68374 = this.index; this.index += 1; value_N68374 }).asInstanceOf[BasicArrayList]
            return list
        } catch {
            case e : Exception => {
                this.logUtil.put(this.commonStrings.EXCEPTION, this, this.commonStrings.GET, e)
                return this.basicArrayListUtil.getImmutableInstance()
            }
        }
        throw new IllegalStateException()
    }

    override def clear() : Unit = {
        super.clear()
        var basicArrayList : BasicArrayList = null

        {
            var index : Int = this.list.size() - 1
            while (index >= 0) {
                basicArrayList = (this.list.objectArray(index).asInstanceOf[BasicArrayList])
                basicArrayList.clear()
                index -= 1
            }
        }
    }

    override def log() : String = {
        val stringBuffer : StringMaker = new StringMaker()
        stringBuffer.append("S: ")
        stringBuffer.appendint(this.list.size())
        val S_LABEL : String = " s: "
        var basicArrayList : BasicArrayList = null

        {
            var index : Int = this.list.size() - 1
            while (index >= 0) {
                stringBuffer.append(S_LABEL)
                basicArrayList = (this.list.objectArray(index).asInstanceOf[BasicArrayList])
                stringBuffer.appendint(basicArrayList.size())
                index -= 1
            }
        }
        return stringBuffer.toString()
    }

}


