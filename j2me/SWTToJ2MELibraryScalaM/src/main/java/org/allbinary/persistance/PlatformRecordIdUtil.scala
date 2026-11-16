/*  * AllBinary Open License Version 1  * Copyright (c) 2022 AllBinary  *   * By agreeing to this license you and any business entity you represent are  * legally bound to the AllBinary Open License Version 1 legal agreement.  *   * You may obtain the AllBinary Open License Version 1 legal agreement from  * AllBinary or the root directory of AllBinary's AllBinary Platform repository.  *   * Created By: Travis Berthelot  *   */
/* Generated Code Do Not Modify */
package org.allbinary.persistance

import _root_.org.allbinary.string.CommonSeps
import _root_.org.allbinary.logic.string.StringMaker
import _root_.org.allbinary.logic.system.security.licensing.AbeClientInformationInterface

/**  *  * @author User  */
class PlatformRecordIdUtil {
    import _root_.org.allbinary.persistance.PlatformRecordIdUtil.{*}

    private val PLATFORM_SHORT_NAME : String = "AVN"

    def getRecordId(abeClientInformation : AbeClientInformationInterface, baseRecordId : String) : String = {
        return new StringMaker().append(abeClientInformation.toShortString()).append(CommonSeps.getInstance().UNDERSCORE).append(this.PLATFORM_SHORT_NAME).append(baseRecordId).toString()
    }

}

object PlatformRecordIdUtil {
    private val instance : PlatformRecordIdUtil = new PlatformRecordIdUtil()

    /**      * @return the instance      */
    def getInstance() : PlatformRecordIdUtil = {
        return PlatformRecordIdUtil.instance
    }

}


