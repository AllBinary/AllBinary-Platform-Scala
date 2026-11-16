/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.business.category.properties.root.store.theme

import _root_.java.util.HashMap
import _root_.javax.servlet.http.HttpServletRequest
import _root_.org.allbinary.business.category.properties.root.store.RootStoreCategoryProperties
import _root_.org.allbinary.business.context.modules.storefront.StoreFrontFactory
import _root_.org.allbinary.business.context.modules.storefront.StoreFrontInterface
import _root_.org.allbinary.globals.FREEBLISKET_PATH_GLOBALS
import _root_.org.allbinary.globals.URLGLOBALS
import _root_.org.allbinary.logic.io.path.AbPath
import _root_.org.allbinary.logic.io.path.AbPathData
import _root_.org.allbinary.logic.string.StringMaker
import _root_.org.allbinary.logic.string.StringUtil
import _root_.org.allbinary.logic.visual.transform.info.TransformInfoHttpStoreInterface
import _root_.org.allbinary.logic.visual.transform.info.TransformInfoInterface
import _root_.org.w3c.dom.Node

class RootStoreThemeCategoryProperties private (super_1 : TransformInfoInterface, super_2 : AbPath, constructor_ : Unit) extends RootStoreCategoryProperties(super_1, super_2) {

    def this(transformInfoInterface : TransformInfoInterface, abPath : AbPath) = {
        this(transformInfoInterface, abPath, ())
    }

    def this(transformInfoInterface : TransformInfoInterface, node : Node) = {
        this(transformInfoInterface, node, ())
    }

    def this(transformInfoInterface : TransformInfoInterface, categoryPropertiesHashMap : HashMap[Object, Object]) = {
        this(transformInfoInterface, categoryPropertiesHashMap, ())
    }

    //implements RootCategoryPropertiesInterface, CategoryPropertiesInterface
    def this(transformInfoInterface : TransformInfoInterface) = {
        this(transformInfoInterface, null, ())
    }

    override def initPath() : Unit = {
        var transformInfoHttpStoreInterface : TransformInfoHttpStoreInterface = this.transformInfoInterface.asInstanceOf[TransformInfoHttpStoreInterface]
        var storeFrontInterface : StoreFrontInterface = StoreFrontFactory.getInstance(transformInfoHttpStoreInterface.getStoreName())
        var stringBuffer : StringMaker = new StringMaker()
        stringBuffer.append(AbPathData.getInstance().SEPARATOR)
        stringBuffer.append(FREEBLISKET_PATH_GLOBALS.getInstance().XSLPATH)
        stringBuffer.append(storeFrontInterface.getName())
        stringBuffer.append(AbPathData.getInstance().SEPARATOR)
        stringBuffer.append(FREEBLISKET_PATH_GLOBALS.getInstance().THEMEPATH)
        var abPath : AbPath = new AbPath(stringBuffer.toString(), StringUtil.getInstance().EMPTY_STRING)
        //storeFrontInterface.getCurrentHostNamePath() + 
        var httpServletRequest : HttpServletRequest = transformInfoHttpStoreInterface.getPageContext().getRequest().asInstanceOf[HttpServletRequest]
        this.webAppAbPath = new AbPath(httpServletRequest.getContextPath() + abPath.toString(), StringUtil.getInstance().EMPTY_STRING)
        this.setRootFilePath(new AbPath(URLGLOBALS.getMainPath() + abPath.toString(), StringUtil.getInstance().EMPTY_STRING))
    }

}


