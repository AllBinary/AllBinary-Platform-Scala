/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.business.user.commerce.shipping

import _root_.org.allbinary.util.BasicArrayList
import _root_.org.allbinary.util.BasicArrayListD
import _root_.org.allbinary.business.DynamicObjectData
import _root_.org.allbinary.business.context.modules.storefront.StoreFrontInterface
import _root_.org.allbinary.business.user.commerce.shipping.modules.BasicWeightShippingModuleView
import _root_.org.allbinary.business.user.commerce.shipping.modules.NoShippingModuleView
import _root_.org.allbinary.business.user.commerce.shipping.modules.ShippingInterface
import _root_.org.allbinary.data.tree.dom.DomNodeHelper
import _root_.org.allbinary.data.tree.dom.DomSearchHelper
import _root_.org.allbinary.data.tree.dom.document.DomDocumentHelper
import _root_.org.allbinary.globals.FREEBLISKET_PATH_GLOBALS
import _root_.org.allbinary.globals.URLGLOBALS
import _root_.org.allbinary.logic.StdUtil
import _root_.org.allbinary.logic.control.crypt.file.CryptFileReader
import _root_.org.allbinary.logic.io.path.AbPath
import _root_.org.allbinary.logic.io.path.AbPathData
import _root_.org.allbinary.logic.string.StringMaker
import _root_.org.allbinary.logic.system.loader.AbeFactory
import _root_.org.allbinary.logic.system.security.licensing.AbeClientInformationInterface
import _root_.org.allbinary.logic.visual.transform.info.objectConfig.TransformInfoObjectConfigData
import _root_.org.w3c.dom.Document
import _root_.org.w3c.dom.Node
import _root_.org.w3c.dom.NodeList

class ShippingMethodsFactory(param_abeClientInformation : AbeClientInformationInterface, param_storeFrontInterface : StoreFrontInterface) {
    import _root_.org.allbinary.business.user.commerce.shipping.ShippingMethodsFactory.{*}

    private var defaultShippingMethodInterface : ShippingInterface = null

    private var document : Document = null

    private var shippingVector : BasicArrayList = null

    //Constructor
    {
        val abeClientInformation : AbeClientInformationInterface = param_abeClientInformation
        val storeFrontInterface : StoreFrontInterface = param_storeFrontInterface
        val stringBuffer : StringMaker = new StringMaker()
        val sep : String = AbPathData.getInstance().SEPARATOR
        stringBuffer.append(URLGLOBALS.getMainPath())
        stringBuffer.append(FREEBLISKET_PATH_GLOBALS.getInstance().XSLPATH)
        stringBuffer.append(storeFrontInterface.getName())
        stringBuffer.append(sep)
        stringBuffer.append(ShippingMethodsFactory.SHIPPINGMETHODSFILEPATHSTRING)
        val abPath : AbPath = (new AbPath(stringBuffer.toString(), _root_.org.allbinary.business.user.commerce.shipping.ShippingMethodsFactory.SHIPPINGMETHODSFILENAME)).asInstanceOf[AbPath]
        val data : String = new CryptFileReader(TransformInfoObjectConfigData.getInstance().UNCRYPTED_EXTENSION, TransformInfoObjectConfigData.getInstance().ENCRYPTED_EXTENSION).get(abPath)
        this.document = DomDocumentHelper.create(data)
        this.shippingVector = new BasicArrayListD()
        val nodeList : NodeList = this.document.getElementsByTagName(ShippingMethodsData.NAME)

        {
            var index : Int = 0
            while (index < nodeList.getLength()) {
                val node : Node = nodeList.item(index)
                val shippingMethodNodeChildren : NodeList = node.getChildNodes()
                val shippingMethodNameNode : Node = DomSearchHelper.getNode(ShippingMethodData.NAME, shippingMethodNodeChildren)
                val classNameNode : Node = DomSearchHelper.getNode(DynamicObjectData.NAME, shippingMethodNameNode.getChildNodes())
                val shippingMethodClassName : String = DomNodeHelper.getTextNodeValue(classNameNode)
                val shippingMethodInterface : ShippingInterface = AbeFactory.getInstance().getInstance(abeClientInformation, shippingMethodClassName).asInstanceOf[ShippingInterface]
                this.shippingVector.add(shippingMethodInterface)
                val defaultShippingMethodNameNode : Node = DomSearchHelper.getNode(ShippingMethodData.DEFAULT, shippingMethodNameNode.getChildNodes())
                val defaultShippingMethodNameNodeValue : String = DomNodeHelper.getTextNodeValue(defaultShippingMethodNameNode)
                if ((defaultShippingMethodNameNodeValue != null) && (defaultShippingMethodNameNodeValue.compareTo(ShippingMethodData.DEFAULT) == 0)) {
                    this.defaultShippingMethodInterface = shippingMethodInterface
                }
                index += 1
            }
        }
        //Default Shipping Options
        if (this.shippingVector.size() < 1) {
            this.defaultShippingMethodInterface = new BasicWeightShippingModuleView()
            this.shippingVector.add(this.defaultShippingMethodInterface)
            this.shippingVector.add(new NoShippingModuleView())
        }
    }

    def getInstance() : BasicArrayList = {
        return this.shippingVector
    }

    def getDefaultInstance() : ShippingInterface = {
        return this.defaultShippingMethodInterface
    }

}

object ShippingMethodsFactory {
    //private final String DEFAULTSHIPPING
    private var SHIPPINGMETHODSFILEPATHSTRING : String = null

    {
        val stringBuffer : StringMaker = new StringMaker()
        val sep : String = AbPathData.getInstance().SEPARATOR
        stringBuffer.append(sep)
        stringBuffer.append("generic")
        stringBuffer.append(sep)
        stringBuffer.append("shipping")
        stringBuffer.append(sep)
        SHIPPINGMETHODSFILEPATHSTRING = stringBuffer.toString()
    }

    private val SHIPPINGMETHODSFILENAME : String = "shippingMethods.xml"

}


