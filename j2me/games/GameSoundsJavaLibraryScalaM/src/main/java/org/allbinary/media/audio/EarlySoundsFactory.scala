/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.media.audio


class EarlySoundsFactory extends BaseSoundsFactory {
    import _root_.org.allbinary.media.audio.EarlySoundsFactory.{*}

    override def getSoundInterfaceArray() : Array[Sound] = {
        var soundInterfaceArray : Array[Sound] = new Array[Sound](2)
        var index : Int = 0
        soundInterfaceArray({ val value_N66102 = index; index += 1; value_N66102 }) = SelectSound.getInstance()
        soundInterfaceArray({ val value_N66152 = index; index += 1; value_N66152 }) = ErrorSound.getInstance()
        //soundInterfaceArray[1] = FireworksSound.getInstance();
        return soundInterfaceArray
    }

}

object EarlySoundsFactory {
    private val instance : EarlySoundsFactory = new EarlySoundsFactory()

    def getInstance() : EarlySoundsFactory = {
        return EarlySoundsFactory.instance
    }

}


