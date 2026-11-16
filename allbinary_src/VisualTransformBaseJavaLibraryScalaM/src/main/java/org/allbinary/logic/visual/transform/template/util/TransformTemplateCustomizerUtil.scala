/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.logic.visual.transform.template.util

import _root_.java.util.HashMap
import _root_.org.allbinary.globals.GLOBALS2
import _root_.org.allbinary.logic.StdUtil
import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.logic.string.StringUtil
import _root_.org.allbinary.logic.string.regex.replace.Replace
import _root_.org.allbinary.logic.visual.transform.info.CustomizerTransformInfoData
import _root_.org.allbinary.logic.visual.transform.template.customizer.bodies.BodyData
import _root_.org.allbinary.logic.visual.transform.template.customizer.widgets.title.TitleData
import _root_.org.allbinary.string.CommonSeps
import _root_.org.allbinary.string.CommonStrings

class TransformTemplateCustomizerUtil private() {
    import _root_.org.allbinary.logic.visual.transform.template.util.TransformTemplateCustomizerUtil.{*}

    val logUtil : LogUtil = LogUtil.getInstance()

    private var CUSTOMIZER_NAME : String = null

    private var BODY_VIEWNAMEKEY : String = null

    private var TITLE_VIEWNAMEKEY : String = null

    private var GLOBALS_NEW : String = null

    private var GLOBALS_INSERT : String = null

    private var GLOBALS_DELETE : String = null

    private var GLOBALS_EDIT : String = null

    private var GLOBALS_UPDATE : String = null

    //Constructor
    {
        val commonStrings : CommonStrings = CommonStrings.getInstance()
        val SPACE : String = CommonSeps.getInstance().SPACE
        this.CUSTOMIZER_NAME = SPACE + CustomizerTransformInfoData.NAME
        this.BODY_VIEWNAMEKEY = SPACE + BodyData.getInstance().VIEWNAMEKEY
        this.TITLE_VIEWNAMEKEY = SPACE + TitleData.getInstance().VIEWNAMEKEY
        this.GLOBALS_NEW = GLOBALS2.NEW + SPACE
        this.GLOBALS_INSERT = commonStrings.INSERT + SPACE
        this.GLOBALS_DELETE = commonStrings.DELETE + SPACE
        this.GLOBALS_EDIT = GLOBALS2.EDIT + SPACE
        this.GLOBALS_UPDATE = commonStrings.UPDATE + SPACE
    }

    def getPageNameHack(viewName : String, storeName : String) : String = {
        val SPACE : String = CommonSeps.getInstance().SPACE
        //Convert to: nextPage
        val ONE_EMPTY_STRING_ARRAY : Array[String] = StringUtil.getInstance().ONE_EMPTY_STRING_ARRAY
        var hashMap : HashMap[Object, Object] = StdUtil.getInstance().createHashMap().asInstanceOf[HashMap[Object, Object]]
        //hashMap.put(selectedTemplate + SPACE, EMPTY_STRING);
        hashMap.put(Array[String](viewName + SPACE), ONE_EMPTY_STRING_ARRAY)
        hashMap.put(Array[String](storeName + SPACE), ONE_EMPTY_STRING_ARRAY)
        //Customizer
        hashMap.put(Array[String](this.CUSTOMIZER_NAME), ONE_EMPTY_STRING_ARRAY)
        //Body
        hashMap.put(Array[String](this.BODY_VIEWNAMEKEY), ONE_EMPTY_STRING_ARRAY)
        //Title
        hashMap.put(Array[String](this.TITLE_VIEWNAMEKEY), ONE_EMPTY_STRING_ARRAY)
        //Remove Prefix
        hashMap.put(Array[String](this.GLOBALS_NEW), ONE_EMPTY_STRING_ARRAY)
        hashMap.put(Array[String](this.GLOBALS_INSERT), ONE_EMPTY_STRING_ARRAY)
        hashMap.put(Array[String](this.GLOBALS_DELETE), ONE_EMPTY_STRING_ARRAY)
        hashMap.put(Array[String](this.GLOBALS_EDIT), ONE_EMPTY_STRING_ARRAY)
        hashMap.put(Array[String](this.GLOBALS_UPDATE), ONE_EMPTY_STRING_ARRAY)
        //new Replace(hashMap);
        var replace : Replace = null
        var rootViewName : String = replace.all(viewName)
        if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().VIEW)) {
            this.logUtil.putF("RootViewName for ObjectConfig: " + rootViewName, this, "getPageNameHack")
        }
        return rootViewName
    }

}

object TransformTemplateCustomizerUtil {
    private val instance : TransformTemplateCustomizerUtil = new TransformTemplateCustomizerUtil()

    def getInstance() : TransformTemplateCustomizerUtil = {
        return TransformTemplateCustomizerUtil.instance
    }

}


