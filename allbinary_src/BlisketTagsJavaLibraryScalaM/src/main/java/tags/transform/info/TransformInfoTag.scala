/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package tags.transform.info

import _root_.javax.servlet.jsp.JspTagException
import _root_.admin.taghelpers.TagHelperFactoryInterface
import _root_.org.allbinary.business.context.modules.storefront.StoreFrontData
import _root_.org.allbinary.logic.communication.http.request.AbResponseHandler
import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.logic.io.OutputTypeData
import _root_.org.allbinary.logic.visual.transform.info.TransformInfoData
import _root_.taghelpers.transform.info.TransformInfoRequestHelperFactory
import _root_.tags.ModifyTag

class TransformInfoTag private (super_1 : TransformInfoRequestHelperFactory, constructor_ : Unit) extends ModifyTag(super_1) {

    val logUtil_TransformInfoTag : LogUtil = LogUtil.getInstance()

    private var name : String = null

    private var storeName : String = null

    //view object that implements the view interface
    private var objectFile : String = null

    private var anyType : String = null

    private var objectConfigFile : String = null

    //inserted into database instead of file path   
    private var objectConfig : String = null

    private var templateFile : String = null

    //inserted into database instead of file path
    private var template : String = null

    private var dataFile : String = null

    //inserted into database instead of file path
    private var data : String = null

    //like jsp, asp, pdf, and so on
    private var `type` : String = null

    def this(tagHelperFactoryInterface : TagHelperFactoryInterface) = {
        this(tagHelperFactoryInterface, ())
    }

    def this() = {
        this(new TransformInfoRequestHelperFactory(), ())
    }

    def setName(value : String) : Unit = {
        this.name = value
        this.getPropertiesHashMap().put(TransformInfoData.getInstance().NAME, this.name)
    }

    def setStoreName(value : String) : Unit = {
        this.storeName = value
        this.getPropertiesHashMap().put(StoreFrontData.getInstance().NAME, this.storeName)
    }

    def setObjectFile(value : String) : Unit = {
        this.objectFile = value
        this.getPropertiesHashMap().put(TransformInfoData.getInstance().OBJECTFILENAME, this.objectFile)
    }

    def setObject(value : String) : Unit = {
        this.anyType = value
        this.getPropertiesHashMap().put(TransformInfoData.getInstance().OBJECT, this.anyType)
    }

    def setTemplateFile(value : String) : Unit = {
        this.templateFile = value
        this.getPropertiesHashMap().put(TransformInfoData.getInstance().TEMPLATEFILENAME, this.templateFile)
    }

    def setTemplate(value : String) : Unit = {
        this.template = value
        this.getPropertiesHashMap().put(TransformInfoData.getInstance().TEMPLATE, this.template)
    }

    def setDataFile(value : String) : Unit = {
        this.dataFile = value
        this.getPropertiesHashMap().put(TransformInfoData.getInstance().DATAFILENAME, this.dataFile)
    }

    def setData(value : String) : Unit = {
        this.data = value
        this.getPropertiesHashMap().put(TransformInfoData.getInstance().DATA, this.data)
    }

    def setObjectConfigFile(value : String) : Unit = {
        this.objectConfigFile = value
        this.getPropertiesHashMap().put(TransformInfoData.getInstance().OBJECTCONFIGFILENAME, this.objectConfigFile)
    }

    def setObjectConfig(value : String) : Unit = {
        this.objectConfig = value
        this.getPropertiesHashMap().put(TransformInfoData.getInstance().OBJECTCONFIG, this.objectConfig)
    }

    def setType(value : String) : Unit = {
        this.`type` = value
        this.getPropertiesHashMap().put(OutputTypeData.getInstance().NAME, this.`type`)
        if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().JSPTAG)) {
            this.logUtil_TransformInfoTag.putF("TransformInfoTag type set: " + this.`type`, this, "setType")
        }
    }

    def getName() : String = {
        return this.name
    }

    def getObjectFile() : String = {
        return this.objectFile
    }

    override def doStartTag() : Int = {
        try {
            return super.doStartTag()
        } catch {
            case e : Exception => {
                AbResponseHandler.sendJspTagRedirect(this.pageContext, e)
                return _root_.javax.servlet.jsp.tagext.Tag.SKIP_BODY
            }
        }
        throw new IllegalStateException()
    }

}


