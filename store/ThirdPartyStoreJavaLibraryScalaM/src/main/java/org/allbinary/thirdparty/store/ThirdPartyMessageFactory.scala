/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.thirdparty.store


class ThirdPartyMessageFactory {
    import _root_.org.allbinary.thirdparty.store.ThirdPartyMessageFactory.{*}

    val AUTHORIZED : String = "Authorized"

    val NOT_AUTHORIZED : String = "Not Authorized"

    val LINKAGE_ERROR : String = "Linkage Error"

}

object ThirdPartyMessageFactory {
    private val instance : ThirdPartyMessageFactory = new ThirdPartyMessageFactory()

    def getInstance() : ThirdPartyMessageFactory = {
        return ThirdPartyMessageFactory.instance
    }

}


