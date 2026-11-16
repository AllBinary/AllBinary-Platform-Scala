/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package views.business.context.modules.storefront.customizer

import _root_.org.allbinary.util.BasicArrayList
import _root_.org.allbinary.util.BasicArrayListD
import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.logic.string.StringUtil
import _root_.org.allbinary.logic.system.security.licensing.AbeClientInformationInterface
import _root_.org.allbinary.logic.visual.transform.generator.TransformGeneratorUtil
import _root_.org.allbinary.logic.visual.transform.info.TransformInfo
import _root_.org.allbinary.logic.visual.transform.info.TransformInfoInterface

class StoreCustomizerComponentUtil private() {
    import _root_.views.business.context.modules.storefront.customizer.StoreCustomizerComponentUtil.{*}

    val logUtil : LogUtil = LogUtil.getInstance()

    //generateModifiedViews
    def generate(abeClientInformation : AbeClientInformationInterface, transformInfoInterface : TransformInfoInterface) : String = {
        if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().VIEW)) {
            this.logUtil.putF("Generating Modified Views For: " + transformInfoInterface.getName(), this, "generateModifiedViews()")
        }
        val customizerUtil : CustomizerUtil = CustomizerUtil.getInstance()
        var allCustomizedViews : BasicArrayList = customizerUtil.getTransformInfoObjectConfigGroupComponentNodes(transformInfoInterface)
        val size : Int = allCustomizedViews.size()

        {
            var index : Int = 0
            while (index < size) {
                var nextTransformInfoInterface : TransformInfo = allCustomizedViews.get(index).asInstanceOf[TransformInfo]
                var allViewsToBeModified : BasicArrayList = customizerUtil.getTransformInfoObjectConfigComponentNodesToCustomize(transformInfoInterface, nextTransformInfoInterface)
                if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().VIEW)) {
                    this.logUtil.putF("View or component that was modified by a Customizer: " + nextTransformInfoInterface.getName(), this, "generateModifiedViews()")
                }
                this.generate(abeClientInformation, transformInfoInterface, allViewsToBeModified)
                index += 1
            }
        }
        return StringUtil.getInstance().EMPTY_STRING
    }

    final private def generate(abeClientInformation : AbeClientInformationInterface, transformInfoInterface : TransformInfoInterface, allViewsToBeModifiedVector : BasicArrayList) : Unit = {
        val customizerUtil : CustomizerUtil = CustomizerUtil.getInstance()
        val size : Int = allViewsToBeModifiedVector.size()

        {
            var index : Int = 0
            while (index < size) {
                var nextTransformInfoInterface : TransformInfo = allViewsToBeModifiedVector.get(index).asInstanceOf[TransformInfo]
                var specifiedTransformInfoInterface : TransformInfoInterface = customizerUtil.getTransformInfoInterfaceToCustomize(transformInfoInterface, nextTransformInfoInterface)
                if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().VIEW)) {
                    this.logUtil.putF("Retrieved: " + specifiedTransformInfoInterface.getName(), this, "generateModifiedViews()")
                }
                //generate views with the new data
                TransformGeneratorUtil.getInstance().generate(abeClientInformation, nextTransformInfoInterface, specifiedTransformInfoInterface)
                index += 1
            }
        }
    }

}

object StoreCustomizerComponentUtil {
    private val instance : StoreCustomizerComponentUtil = new StoreCustomizerComponentUtil()

    def getInstance() : StoreCustomizerComponentUtil = {
        return StoreCustomizerComponentUtil.instance
    }

}


