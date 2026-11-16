/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.logic.visual.transform.info.template


class TransformInfoTemplateData private() {
    import _root_.org.allbinary.logic.visual.transform.info.template.TransformInfoTemplateData.{*}

    val UNCRYPTED_EXTENSION : String = "xsl"

    val ENCRYPTED_EXTENSION : String = "abv"

}

object TransformInfoTemplateData {
    private val instance : TransformInfoTemplateData = new TransformInfoTemplateData()

    def getInstance() : TransformInfoTemplateData = {
        return TransformInfoTemplateData.instance
    }

}


