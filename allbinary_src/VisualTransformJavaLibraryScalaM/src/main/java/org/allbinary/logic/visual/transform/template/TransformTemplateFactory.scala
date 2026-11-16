/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.logic.visual.transform.template

import _root_.java.util.HashMap
import _root_.javax.servlet.jsp.PageContext
import _root_.org.allbinary.data.tables.transform.info.TransformInfoEntity
import _root_.org.allbinary.data.tables.transform.info.TransformInfoEntityBuilder
import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.logic.system.security.licensing.AbeClientInformationInterface
import _root_.org.allbinary.logic.visual.transform.info.TransformInfoInterface
import _root_.org.allbinary.logic.visual.transform.info.TransformInfoObjectFactory

class TransformTemplateFactory private() {
    import _root_.org.allbinary.logic.visual.transform.template.TransformTemplateFactory.{*}

    val logUtil : LogUtil = LogUtil.getInstance()

    //create a root/parent instance from db and/or request
    def getInstance(abeClientInformation : AbeClientInformationInterface, templateName : String, propertiesHashMap : HashMap[Object, Object], pageContext : PageContext) : TransformTemplateInterface = {
        try {
            val transformInfoEntity : TransformInfoEntity = TransformInfoEntityBuilder.getInstance()
            val transformInfoInterface : TransformInfoInterface = transformInfoEntity.get(templateName, propertiesHashMap, pageContext)
            return TransformInfoObjectFactory.getInstance().getInstance(abeClientInformation, transformInfoInterface).asInstanceOf[TransformTemplateInterface]
        } catch {
            case e : Exception => {
                var error : String = "Failed To Get Instance"
                if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().TAGHELPERFACTORYERROR)) {
                    this.logUtil.put((error + templateName) + "->TemplateFactory", this, "getInstance(viewName, HashMap, PageContext)", e)
                }
                throw e
            }
        }
        throw new IllegalStateException()
    }

}

object TransformTemplateFactory {
    private val instance : TransformTemplateFactory = new TransformTemplateFactory()

    /**      * @return the instance      */
    def getInstance() : TransformTemplateFactory = {
        return TransformTemplateFactory.instance
    }

}


