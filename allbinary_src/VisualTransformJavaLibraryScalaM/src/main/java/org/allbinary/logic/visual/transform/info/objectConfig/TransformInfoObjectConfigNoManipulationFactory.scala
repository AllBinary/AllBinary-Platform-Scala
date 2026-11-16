/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.logic.visual.transform.info.objectConfig

import _root_.org.allbinary.data.tree.dom.document.DomDocumentHelper
import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.logic.control.crypt.file.CryptFileReader
import _root_.org.allbinary.logic.io.path.AbPath
import _root_.org.allbinary.logic.visual.transform.info.TransformInfoInterface
import _root_.org.allbinary.string.CommonStrings

class TransformInfoObjectConfigNoManipulationFactory private() {
    import _root_.org.allbinary.logic.visual.transform.info.objectConfig.TransformInfoObjectConfigNoManipulationFactory.{*}

    val logUtil : LogUtil = LogUtil.getInstance()

    def getInstance(transformInfoInterface : TransformInfoInterface, objectConfigFileAbPath : AbPath) : TransformInfoObjectConfigInterface = {
        try {
            val transformInfoObjectConfigData : TransformInfoObjectConfigData = TransformInfoObjectConfigData.getInstance()
            var data : String = new CryptFileReader(transformInfoObjectConfigData.UNCRYPTED_EXTENSION, TransformInfoObjectConfigData.getInstance().ENCRYPTED_EXTENSION).get(objectConfigFileAbPath)
            return new TransformInfoObjectConfig(transformInfoInterface, DomDocumentHelper.create(data))
        } catch {
            case e : Exception => {
                val commonStrings : CommonStrings = CommonStrings.getInstance()
                if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().VIEWERROR)) {
                    this.logUtil.put("Could Not Load Object Config", this, commonStrings.GET_INSTANCE, e)
                }
                throw e
            }
        }
        throw new IllegalStateException()
    }

}

object TransformInfoObjectConfigNoManipulationFactory {
    private val instance : TransformInfoObjectConfigNoManipulationFactory = new TransformInfoObjectConfigNoManipulationFactory()

    def getInstance() : TransformInfoObjectConfigNoManipulationFactory = {
        return TransformInfoObjectConfigNoManipulationFactory.instance
    }

}


