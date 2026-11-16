/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.logic.visual.transform.info

import _root_.java.util.HashMap
import _root_.javax.servlet.jsp.PageContext
import _root_.org.allbinary.logic.visual.transform.info.objectConfig.TransformInfoObjectConfigNoManipulationFactory

/**  *  * @author user  */
class TransformInfoHttpStoreNoManipulation(param_propertiesHashMap : HashMap[Object, Object], param_pageContext : PageContext) extends TransformInfoHttpStore(param_propertiesHashMap, param_pageContext) {

    //TWB - for Inserting transforms into database
    //Constructor
    {
        val propertiesHashMap : HashMap[Object, Object] = param_propertiesHashMap
        val pageContext : PageContext = param_pageContext
    }

    override def setObjectConfigFile(value : String) : Unit = {
        this.setObjectConfigFileName(value)
        this.setObjectConfigInterface(TransformInfoObjectConfigNoManipulationFactory.getInstance().getInstance(this, this.getObjectConfigFilePath()))
    }

    override def setObjectConfig(value : String) : Unit = {
        throw new Exception("Should not set from config")
    }

}


