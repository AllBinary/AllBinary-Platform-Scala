/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.audio


class AudioContentTypeDataFactory private() {
    import _root_.org.allbinary.audio.AudioContentTypeDataFactory.{*}

    val MIME_AUDIO_TONE : AudioContentTypeData = new AudioContentTypeData("audio/x-tone-seq")

    val MIME_AUDIO_AMR : AudioContentTypeData = new AudioContentTypeData("audio/amr")

    val MIME_AUDIO_AMR_WB : AudioContentTypeData = new AudioContentTypeData("audio/amr-wb")

    val MIME_AUDIO_WAV : AudioContentTypeData = new AudioContentTypeData("audio/x-wav")

    val MIME_AUDIO_MIDI : AudioContentTypeData = new AudioContentTypeData("audio/midi")

    val MIME_AUDIO_SP_MIDI : AudioContentTypeData = new AudioContentTypeData("audio/sp-midi")

}

object AudioContentTypeDataFactory {
    private val instance : AudioContentTypeDataFactory = new AudioContentTypeDataFactory()

    def getInstance() : AudioContentTypeDataFactory = {
        return AudioContentTypeDataFactory.instance
    }

}


