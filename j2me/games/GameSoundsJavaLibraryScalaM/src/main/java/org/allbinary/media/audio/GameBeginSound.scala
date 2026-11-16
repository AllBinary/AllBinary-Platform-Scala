/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.media.audio


//Use 8hz16bitmono for most J2ME
class GameBeginSound private() extends CompositeSound("resource:/wav/begin.wav") {
    import _root_.org.allbinary.media.audio.GameBeginSound.{*}

}

object GameBeginSound {
    private var soundInterface : Sound = new GameBeginSound()

    def getInstance() : Sound = {
        return GameBeginSound.soundInterface
    }

}


