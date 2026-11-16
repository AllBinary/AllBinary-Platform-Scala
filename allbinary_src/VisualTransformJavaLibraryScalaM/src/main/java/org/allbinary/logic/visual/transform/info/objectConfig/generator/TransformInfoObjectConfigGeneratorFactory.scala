/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.logic.visual.transform.info.objectConfig.generator

import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.logic.io.InputOutputTypeData
import _root_.org.allbinary.logic.visual.transform.info.TransformInfoInterface
import _root_.org.allbinary.string.CommonStrings

class TransformInfoObjectConfigGeneratorFactory private() extends TransformInfoObjectConfigGeneratorFactoryInterface {
    import _root_.org.allbinary.logic.visual.transform.info.objectConfig.generator.TransformInfoObjectConfigGeneratorFactory.{*}

    val logUtil : LogUtil = LogUtil.getInstance()

    def getInstance(transformInfoInterface : TransformInfoInterface) : TransformInfoObjectConfigGenerator = {
        var `type` : String = transformInfoInterface.getObjectConfigInterface().getOutputTypeName().asInstanceOf[String]
        if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().VIEW)) {
            val commonStrings : CommonStrings = CommonStrings.getInstance()
            this.logUtil.putF("Generating Instance for type: " + `type`, this, commonStrings.GET_INSTANCE)
        }
        if (((`type` == null) || (`type`.compareTo(InputOutputTypeData.getInstance().RESPONSE) == 0)) || transformInfoInterface.isChild()) {
            //without parents can use the generator
            return new BasicGenerator()
        } else if (`type`.compareTo(InputOutputTypeData.getInstance().FILE) == 0) {
            //, propertiesHashMap, pageContext
            return new StoreFileGenerator(transformInfoInterface)
        } else {
            throw new Exception("No Such TransformInfoObjectConfigGenerator Type")
        }
        throw new IllegalStateException()
    }

}

object TransformInfoObjectConfigGeneratorFactory {
    private val instance : TransformInfoObjectConfigGeneratorFactory = new TransformInfoObjectConfigGeneratorFactory()

    /**      * @return the instance      */
    def getInstance() : TransformInfoObjectConfigGeneratorFactory = {
        return TransformInfoObjectConfigGeneratorFactory.instance
    }

}


