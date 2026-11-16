/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *   */
/* Generated Code Do Not Modify */
package org.allbinary.logic.visual.transform.generator

import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.logic.io.InputOutputTypeData
import _root_.org.allbinary.logic.system.security.licensing.AbeClientInformationInterface
import _root_.org.allbinary.logic.visual.transform.TransformFactory
import _root_.org.allbinary.logic.visual.transform.TransformInterface
import _root_.org.allbinary.logic.visual.transform.info.TransformInfoDomNode
import _root_.org.allbinary.logic.visual.transform.info.TransformInfoHttpInterface
import _root_.org.allbinary.logic.visual.transform.info.TransformInfoInterface
import _root_.org.allbinary.logic.visual.transform.info.objectConfig.generator.StoreFileGenerator

class TransformGeneratorUtil private() {
    import _root_.org.allbinary.logic.visual.transform.generator.TransformGeneratorUtil.{*}

    val logUtil : LogUtil = LogUtil.getInstance()

    def generate(abeClientInformation : AbeClientInformationInterface, transformInfoInterface : TransformInfoInterface, ownerTransformInfoInterface : TransformInfoInterface) : Unit = {
        try {
            if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().VIEW)) {
                this.logUtil.putF("Generating View: " + transformInfoInterface.getName(), this, "generate()")
            }
            var componentInterface : TransformInterface = TransformFactory.getInstance().getInstance(abeClientInformation, transformInfoInterface.getName(), ownerTransformInfoInterface)
            var result : String = componentInterface.view()
            var httpTransformInfoInterface : TransformInfoHttpInterface = componentInterface.getTransformInfoInterface().asInstanceOf[TransformInfoHttpInterface]
            var inputOutputTypeData : InputOutputTypeData = InputOutputTypeData.getInstance()
            if (result.indexOf("<HTML>") >= 0) {
                httpTransformInfoInterface.getPropertiesHashMap().put(inputOutputTypeData.NAME, inputOutputTypeData.DEFAULT)
            } else {
                httpTransformInfoInterface.getPropertiesHashMap().put(inputOutputTypeData.NAME, inputOutputTypeData.DEFAULT_FRAGMENT)
            }
            new StoreFileGenerator(componentInterface.getTransformInfoInterface()).process(result)
        } catch {
            case e : Exception => {
                if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().SQLTAGSERROR)) {
                    this.logUtil.put("Failed to generate a view", this, "generate()", e)
                }
                throw e
            }
        }
    }

    def generate(abeClientInformation : AbeClientInformationInterface, transformInfoDomNode : TransformInfoDomNode, ownerTransformInfoInterface : TransformInfoInterface) : Unit = {
        this.generate(abeClientInformation, transformInfoDomNode.getTransformInfoInterface(), ownerTransformInfoInterface)
    }

}

object TransformGeneratorUtil {
    private val instance : TransformGeneratorUtil = new TransformGeneratorUtil()

    def getInstance() : TransformGeneratorUtil = {
        return TransformGeneratorUtil.instance
    }

}


