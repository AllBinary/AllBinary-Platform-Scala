/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.logic.java.characters


class CharacterSetData private() {
    import _root_.org.allbinary.logic.java.characters.CharacterSetData.{*}

    val US_ASCII : String = "US-ASCII"

    val ISO_8859_1 : String = "ISO-8859-1"

    val UTF_8 : String = "UTF-8"

    val UTF_16 : String = "UTF-16"

    val UTF_16BE : String = "UTF-16BE"

    val UTF_16LE : String = "UTF-16LE"

}

object CharacterSetData {
    private val instance : CharacterSetData = new CharacterSetData()

    def getInstance() : CharacterSetData = {
        return CharacterSetData.instance
    }

}


