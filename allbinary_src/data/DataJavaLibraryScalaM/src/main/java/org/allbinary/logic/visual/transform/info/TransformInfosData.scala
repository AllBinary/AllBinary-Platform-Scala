/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.logic.visual.transform.info


class TransformInfosData private() {
    import _root_.org.allbinary.logic.visual.transform.info.TransformInfosData.{*}

    val NAME : String = "TRANSFORM_INFOS_NAME"

    //duplicate view components
    val GROUP : String = "TRANSFORM_INFOS_GROUP"

    val ALL : String = "TRANSFORM_INFOS_ALL"

    val PREVIEW : String = "TRANSFORM_INFOS_PREVIEW"

    val SMALL_PREVIEW : String = "TRANSFORM_INFOS_SMALL_PREVIEW"

}

object TransformInfosData {
    private val instance : TransformInfosData = new TransformInfosData()

    def getInstance() : TransformInfosData = {
        return TransformInfosData.instance
    }

}


