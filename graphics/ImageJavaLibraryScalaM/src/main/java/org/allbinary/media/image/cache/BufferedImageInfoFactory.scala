/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.media.image.cache

import _root_.java.util.HashMap
import _root_.org.allbinary.logic.StdUtil
import _root_.org.allbinary.logic.string.StringMaker

class BufferedImageInfoFactory private() {
    import _root_.org.allbinary.media.image.cache.BufferedImageInfoFactory.{*}

}

object BufferedImageInfoFactory {
    private var hashMap : HashMap[Object, Object] = StdUtil.getInstance().createHashMap().asInstanceOf[HashMap[Object, Object]]

    def getInstance(width : Int, height : Int, `type` : Int) : BufferedImageInfo = {
        var stringbuffer : StringMaker = new StringMaker()
        stringbuffer.appendint(width)
        stringbuffer.appendint(height)
        stringbuffer.appendint(`type`)
        var key : String = stringbuffer.toString()
        var bufferedImageInfo : BufferedImageInfo = BufferedImageInfoFactory.hashMap.get(key).asInstanceOf[BufferedImageInfo]
        if (bufferedImageInfo == null) {
            bufferedImageInfo = new BufferedImageInfo(width, height, `type`)
            BufferedImageInfoFactory.hashMap.put(key, bufferedImageInfo)
        }
        return bufferedImageInfo
    }

}


