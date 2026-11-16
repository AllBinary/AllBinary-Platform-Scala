/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.ag.weapon.media.audio

import _root_.org.allbinary.media.audio.CompositeSound
import _root_.org.allbinary.media.audio.Sound

class DropWeaponSound private() extends CompositeSound("resource:/wav/mine.wav") {
    import _root_.org.allbinary.ag.weapon.media.audio.DropWeaponSound.{*}

}

object DropWeaponSound {
    private var soundInterface : Sound = new DropWeaponSound()

    def getInstance() : Sound = {
        return DropWeaponSound.soundInterface
    }

}


