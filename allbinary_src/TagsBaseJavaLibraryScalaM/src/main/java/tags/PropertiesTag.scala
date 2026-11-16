/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package tags

import _root_.java.util.HashMap
import _root_.org.allbinary.logic.StdUtil
import _root_.org.allbinary.logic.communication.log.LogUtil

class PropertiesTag() extends CommandTag {

    val logUtil : LogUtil = LogUtil.getInstance()

    private var propertiesHashMap : HashMap[Object, Object] = null

    //Constructor
    {
        if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().JSPTAG)) {
            this.logUtil.putF(this.commonStrings.START, this, this.commonStrings.CONSTRUCTOR)
        }
        this.propertiesHashMap = StdUtil.getInstance().createHashMap().asInstanceOf[HashMap[Object, Object]]
    }

    def getPropertiesHashMap() : HashMap[Object, Object] = {
        return this.propertiesHashMap
    }

    override def doEndTag() : Int = {
        if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().JSPTAG)) {
            this.logUtil.putF("Tag Ended", this, "doEndTag")
        }
        this.propertiesHashMap = StdUtil.getInstance().createHashMap().asInstanceOf[HashMap[Object, Object]]
        return _root_.javax.servlet.jsp.tagext.Tag.EVAL_PAGE
    }

}


