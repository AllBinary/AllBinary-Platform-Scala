/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.logic.visual.transform.generator

import _root_.org.allbinary.util.BasicArrayList
import _root_.org.allbinary.util.BasicArrayListD
import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.logic.string.StringMaker
import _root_.org.allbinary.logic.system.security.licensing.AbeClientInformationInterface
import _root_.org.allbinary.logic.visual.transform.info.TransformInfoDomNode
import _root_.org.allbinary.logic.visual.transform.info.TransformInfoInterface
import _root_.org.allbinary.logic.visual.transform.info.objectConfig.TransformInfoObjectConfigInterface

class TransformsGeneratorUtil private() {
    import _root_.org.allbinary.logic.visual.transform.generator.TransformsGeneratorUtil.{*}

    val logUtil : LogUtil = LogUtil.getInstance()

    def generateComponentsFromObjectConfig(abeClientInformation : AbeClientInformationInterface, transformInfoInterface : TransformInfoInterface, group : String) : String = {
        if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().VIEW)) {
            this.logUtil.putF("Started Group: " + group, this, "generateComponentsFromObjectConfig(2)")
        }
        var transformInfoObjectConfigInterface : TransformInfoObjectConfigInterface = transformInfoInterface.getObjectConfigInterface()
        var result : String = this.generateComponentsFromObjectConfig(abeClientInformation, transformInfoObjectConfigInterface, transformInfoInterface, group)
        if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().VIEW)) {
            this.logUtil.putF("End Group: " + group, this, "generateComponentsFromObjectConfig(2)")
        }
        return result
    }

    //I.E. the Template replaces it's body component tag with the template form each TransformInfoInterface from the TransformInfoObjectConfigInterface
    def generateComponentsFromObjectConfig(abeClientInformation : AbeClientInformationInterface, transformInfoObjectConfigInterface : TransformInfoObjectConfigInterface, transformInfoInterface : TransformInfoInterface, group : String) : String = {
        if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().VIEW)) {
            this.logUtil.putF("Started Group: " + group, this, "generateComponentsFromObjectConfig()")
        }
        var transformInfoObjectConfigComponentVector : BasicArrayList = transformInfoObjectConfigInterface.getTransformsGroup(group)
        if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().VIEW)) {
            var stringBuffer : StringMaker = new StringMaker()
            stringBuffer.append("Processing ")
            stringBuffer.appendint(transformInfoObjectConfigComponentVector.size())
            stringBuffer.append(" Components Group: ")
            stringBuffer.append(group)
            this.logUtil.putF(stringBuffer.toString(), this, "generateComponentsFromObjectConfig()")
        }
        if (transformInfoObjectConfigComponentVector.size() < 1) {
            throw new Exception("No Pages Generated For Template.")
        }
        val size : Int = transformInfoObjectConfigComponentVector.size()

        {
            var index : Int = 0
            while (index < size) {
                var transformInfoObjectConfigComponent : TransformInfoDomNode = transformInfoObjectConfigComponentVector.get(index).asInstanceOf[TransformInfoDomNode]
                TransformGeneratorUtil.getInstance().generate(abeClientInformation, transformInfoObjectConfigComponent, transformInfoInterface)
                index += 1
            }
        }
        if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().VIEW)) {
            this.logUtil.putF("Done Group: " + group, this, "generateComponentsFromObjectConfig()")
        }
        var stringBuffer : StringMaker = new StringMaker()
        stringBuffer.append("<!-- Generated all template views successfully for View: ")
        stringBuffer.append(transformInfoInterface.getName())
        stringBuffer.append("-->")
        return stringBuffer.toString()
    }

}

object TransformsGeneratorUtil {
    private val instance : TransformsGeneratorUtil = new TransformsGeneratorUtil()

    def getInstance() : TransformsGeneratorUtil = {
        return TransformsGeneratorUtil.instance
    }

}


