/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.logic.java.character


class CharArrayFactory {
    import _root_.org.allbinary.logic.java.character.CharArrayFactory.{*}

    private val zeroCharArray : Array[Char] = new Array[Char](0)

    def getZeroCharArray() : Array[Char] = {
        return this.zeroCharArray
    }

}

object CharArrayFactory {
    private val instance : CharArrayFactory = new CharArrayFactory()

    def getInstance() : CharArrayFactory = {
        return CharArrayFactory.instance
    }

}


