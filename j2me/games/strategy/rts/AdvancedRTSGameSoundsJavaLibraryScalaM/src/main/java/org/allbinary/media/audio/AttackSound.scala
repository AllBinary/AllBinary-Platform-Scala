/*  * AllBinary Open License Version 1  * Copyright (c) 2002 AllBinary  *   * By agreeing to this license you and any business entity you represent are  * legally bound to the AllBinary Open License Version 1 legal agreement.  *   * You may obtain the AllBinary Open License Version 1 legal agreement from  * AllBinary or the root directory of AllBinary's AllBinary Platform repository.  *   * Created By: Travis Berthelot  */
/* Generated Code Do Not Modify */
package org.allbinary.media.audio


class AttackSound private() extends CompositeSound("resource:/wav/attack.wav") {
    import _root_.org.allbinary.media.audio.AttackSound.{*}

}

object AttackSound {
    private var soundInterface : Sound = new AttackSound()

    def getInstance() : Sound = {
        return AttackSound.soundInterface
    }

}


