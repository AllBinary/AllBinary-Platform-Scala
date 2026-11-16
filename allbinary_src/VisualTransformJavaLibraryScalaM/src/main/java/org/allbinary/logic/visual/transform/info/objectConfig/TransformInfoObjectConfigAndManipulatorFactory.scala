/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.logic.visual.transform.info.objectConfig

import _root_.org.allbinary.data.tree.dom.document.DomDocumentHelper
import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.logic.control.crypt.file.CryptFileReader
import _root_.org.allbinary.logic.io.path.AbPath
import _root_.org.allbinary.logic.string.StringValidationUtil
import _root_.org.allbinary.logic.system.security.licensing.AbeClientInformationInterface
import _root_.org.allbinary.logic.visual.transform.info.TransformInfoInterface
import _root_.org.w3c.dom.Document

class TransformInfoObjectConfigAndManipulatorFactory private() extends TransformInfoObjectConfigAndManipulatorFactoryBase {
    import _root_.org.allbinary.logic.visual.transform.info.objectConfig.TransformInfoObjectConfigAndManipulatorFactory.{*}

    val logUtil : LogUtil = LogUtil.getInstance()

    override def getInstance(abeClientInformation : AbeClientInformationInterface, transformInfoInterface : TransformInfoInterface, objectConfigFileAbPath : AbPath) : TransformInfoObjectConfigInterface = {
        try {
            var data : String = new CryptFileReader(TransformInfoObjectConfigData.getInstance().UNCRYPTED_EXTENSION, TransformInfoObjectConfigData.getInstance().ENCRYPTED_EXTENSION).get(objectConfigFileAbPath)
            return this.getInstance(abeClientInformation, transformInfoInterface, DomDocumentHelper.create(data))
        } catch {
            case e : Exception => {
                if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().VIEWERROR)) {
                    this.logUtil.put("Could Not Load Object Config", getInstance(), this.commonStrings.GET_INSTANCE, e)
                }
                throw e
            }
        }
        throw new IllegalStateException()
    }

    override def getInstance(abeClientInformation : AbeClientInformationInterface, transformInfoInterface : TransformInfoInterface) : TransformInfoObjectConfigInterface = {
        try {
            //DynamicObjectData.NAME
            var stringValidationUtil : StringValidationUtil = StringValidationUtil.getInstance()
            //Maybe not the best way to create the correct object
            if ((transformInfoInterface != null) && !stringValidationUtil.isEmpty(transformInfoInterface.getStoreName())) {
                return (new GenericStoreTransformInfoObjectConfig(abeClientInformation, transformInfoInterface)).asInstanceOf[TransformInfoObjectConfigInterface]
            } else {
                return (new TransformInfoObjectConfig(transformInfoInterface)).asInstanceOf[TransformInfoObjectConfigInterface]
            }
        } catch {
            case e : Exception => {
                var error : String = "Failed To Get Instance: "
                if (transformInfoInterface != null) {
                    error = error + transformInfoInterface.getName()
                }
                if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().TAGHELPERFACTORYERROR)) {
                    this.logUtil.put(commonStrings.EXCEPTION, getInstance(), commonStrings.GET_INSTANCE, e)
                }
                throw e
            }
        }
        throw new IllegalStateException()
    }

    override def getInstance(abeClientInformation : AbeClientInformationInterface, transformInfoInterface : TransformInfoInterface, document : Document) : TransformInfoObjectConfigInterface = {
        try {
            var stringValidationUtil : StringValidationUtil = StringValidationUtil.getInstance()
            //Maybe not the best way to create the correct object
            if ((transformInfoInterface != null) && !stringValidationUtil.isEmpty(transformInfoInterface.getStoreName())) {
                return (new GenericStoreTransformInfoObjectConfig(abeClientInformation, transformInfoInterface, document)).asInstanceOf[TransformInfoObjectConfigInterface]
            } else {
                return (new TransformInfoObjectConfig(transformInfoInterface, document)).asInstanceOf[TransformInfoObjectConfigInterface]
            }
        } catch {
            case e : Exception => {
                var error : String = "Failed To Get Instance: "
                if (transformInfoInterface != null) {
                    error = error + transformInfoInterface.getName()
                }
                if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().TAGHELPERFACTORYERROR)) {
                    this.logUtil.put(commonStrings.EXCEPTION, getInstance(), "getInstance(document)", e)
                }
                throw e
            }
        }
        throw new IllegalStateException()
    }

}

object TransformInfoObjectConfigAndManipulatorFactory {
    private val instance : TransformInfoObjectConfigAndManipulatorFactory = new TransformInfoObjectConfigAndManipulatorFactory()

    /**      * @return the instance      */
    def getInstance() : TransformInfoObjectConfigAndManipulatorFactory = {
        return TransformInfoObjectConfigAndManipulatorFactory.instance
    }

}


