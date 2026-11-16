/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.game.midlet


class LicenseLoadingTypeFactory {
    import _root_.org.allbinary.game.midlet.LicenseLoadingTypeFactory.{*}

    val INITIAL_LOADING : LicenseLoadingType = new LicenseLoadingType("Initial Loading")

    val GAME_START : LicenseLoadingType = new LicenseLoadingType("Game Start")

    val LOGIN : LicenseLoadingType = new LicenseLoadingType("Login")

    val OTHER : LicenseLoadingType = new LicenseLoadingType("Other/Usually The First Non Demo Level")

}

object LicenseLoadingTypeFactory {
    private val instance : LicenseLoadingTypeFactory = new LicenseLoadingTypeFactory()

    def getIntance() : LicenseLoadingTypeFactory = {
        return LicenseLoadingTypeFactory.instance
    }

}


