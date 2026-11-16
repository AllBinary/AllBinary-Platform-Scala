/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.game.midlet


class LicenseLevelUtil {
    import _root_.org.allbinary.game.midlet.LicenseLevelUtil.{*}

    def getMaxLevel(maxLevel : Int, demoLevel : Int) : Int = {
        //return demoLevel;
        return maxLevel
    }

}

object LicenseLevelUtil {
    private val instance : LicenseLevelUtil = new LicenseLevelUtil()

    def getInstance() : LicenseLevelUtil = {
        return LicenseLevelUtil.instance
    }

}


