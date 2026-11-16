/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package tags

import _root_.admin.taghelpers.TagHelperFactoryInterface
import _root_.org.allbinary.logic.communication.log.LogUtil

class HelperTag(param_tagHelperFactoryInterface : TagHelperFactoryInterface) extends PropertiesTag {

    val logUtil_HelperTag : LogUtil = LogUtil.getInstance()

    private var tagHelperFactoryInterface : TagHelperFactoryInterface = null

    private var anyType : Object = null

    //Constructor
    {
        val tagHelperFactoryInterface : TagHelperFactoryInterface = param_tagHelperFactoryInterface
        if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().JSPTAG)) {
            this.logUtil_HelperTag.putF(this.commonStrings.START, this, this.commonStrings.CONSTRUCTOR)
        }
        this.tagHelperFactoryInterface = tagHelperFactoryInterface
    }

    //This must occur in do start tag after properties are set
    def setHelper() : Unit = {
        if (this.anyType == null) {
            if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().JSPTAG)) {
                this.logUtil_HelperTag.putF("Creating TagHelper with: \n" + this.getPropertiesHashMap().toString(), this, "doStartTag")
            }
            this.anyType = this.tagHelperFactoryInterface.getInstance(this.getPropertiesHashMap(), this.pageContext)
        }
    }

    //Used after set helper for calling methods with reflection
    def getHelper() : Object = {
        return this.anyType
    }

    override def doEndTag() : Int = {
        if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().JSPTAG)) {
            this.logUtil_HelperTag.putF("Tag Ended", this, "doEndTag")
        }
        this.anyType = null
        return super.doEndTag()
    }

}


