/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package tags.generic

import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.logic.io.InputOutputTypeData
import _root_.tags.TransformTag

class GenericViewTag() extends TransformTag {

    val logUtil_GenericViewTag : LogUtil = LogUtil.getInstance()

    private var output : String = null

    //defines the storage name/location for results and/or data submission type
    private var file : String = null

    //Constructor
    {
        if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().JSPTAG)) {
            this.logUtil_GenericViewTag.putF(this.commonStrings.START, this, this.commonStrings.CONSTRUCTOR)
        }
    }

    def setOutput(value : String) : Unit = {
        this.output = value
        this.getPropertiesHashMap().put(InputOutputTypeData.getInstance().NAME, this.output)
    }

    def setFile(value : String) : Unit = {
        this.file = value
        this.getPropertiesHashMap().put(InputOutputTypeData.getInstance().FILE, this.file)
    }

}


