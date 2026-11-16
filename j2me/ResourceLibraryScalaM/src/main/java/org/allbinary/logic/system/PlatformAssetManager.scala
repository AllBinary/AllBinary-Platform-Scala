/*  * AllBinary Open License Version 1  * Copyright (c) 2022 AllBinary  *   * By agreeing to this license you and any business entity you represent are  * legally bound to the AllBinary Open License Version 1 legal agreement.  *   * You may obtain the AllBinary Open License Version 1 legal agreement from  * AllBinary or the root directory of AllBinary's AllBinary Platform repository.  *   * Created By: Travis Berthelot  *   */
/* Generated Code Do Not Modify */
package org.allbinary.logic.system

import _root_.java.io.InputStream
import _root_.org.allbinary.data.resource.ResourceUtil

/**  *  * @author User  */
class PlatformAssetManager {
    import _root_.org.allbinary.logic.system.PlatformAssetManager.{*}

    def getResourceAsStream(resource : String) : InputStream = {
        val resourceUtil : ResourceUtil = ResourceUtil.getInstance()
        val inputStream : InputStream = resourceUtil.getResourceAsStream(resource)
        return inputStream
    }

}

object PlatformAssetManager {
    private val instance : PlatformAssetManager = new PlatformAssetManager()

    /**      * @return the instance      */
    def getInstance() : PlatformAssetManager = {
        return PlatformAssetManager.instance
    }

}


