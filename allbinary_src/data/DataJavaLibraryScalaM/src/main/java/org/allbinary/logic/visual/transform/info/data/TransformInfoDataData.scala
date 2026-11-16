/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *   */
/* Generated Code Do Not Modify */
package org.allbinary.logic.visual.transform.info.data

import _root_.org.allbinary.logic.io.file.CommonDataFileStrings

class TransformInfoDataData private() {
    import _root_.org.allbinary.logic.visual.transform.info.data.TransformInfoDataData.{*}

    val UNCRYPTED_EXTENSION : String = CommonDataFileStrings.getInstance().UNCRYPTED_EXTENSION

    val ENCRYPTED_EXTENSION : String = CommonDataFileStrings.getInstance().ENCRYPTED_EXTENSION

}

object TransformInfoDataData {
    private val instance : TransformInfoDataData = new TransformInfoDataData()

    def getInstance() : TransformInfoDataData = {
        return TransformInfoDataData.instance
    }

}


