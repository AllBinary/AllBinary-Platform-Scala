/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.android


class AndroidInfoFactory {
    import _root_.org.allbinary.android.AndroidInfoFactory.{*}

    private val version : Int = 8

    //https://source.android.com/source/build-numbers
    def getVersion() : Int = {
        return this.version
    }

}

object AndroidInfoFactory {
    private val instance : AndroidInfoFactory = new AndroidInfoFactory()

    def getInstance() : AndroidInfoFactory = {
        return AndroidInfoFactory.instance
    }

}


