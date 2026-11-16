/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.business.user.commerce.money.tax

import _root_.org.allbinary.business.DynamicObjectData
import _root_.org.allbinary.business.context.modules.storefront.StoreFrontInterface
import _root_.org.allbinary.business.user.commerce.money.tax.components.TaxData
import _root_.org.allbinary.business.user.commerce.money.tax.modules.SimpleStateTaxModule
import _root_.org.allbinary.business.user.commerce.money.tax.modules.TaxModuleInterface
import _root_.org.allbinary.data.tree.dom.DomNodeHelper
import _root_.org.allbinary.data.tree.dom.DomSearchHelper
import _root_.org.allbinary.data.tree.dom.document.DomDocumentHelper
import _root_.org.allbinary.globals.FREEBLISKET_PATH_GLOBALS
import _root_.org.allbinary.globals.URLGLOBALS
import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.logic.control.crypt.file.CryptFileReader
import _root_.org.allbinary.logic.io.path.AbPath
import _root_.org.allbinary.logic.io.path.AbPathData
import _root_.org.allbinary.logic.string.StringMaker
import _root_.org.allbinary.logic.system.loader.AbeFactory
import _root_.org.allbinary.logic.system.security.licensing.AbeClientInformationInterface
import _root_.org.allbinary.logic.visual.transform.info.objectConfig.TransformInfoObjectConfigData
import _root_.org.allbinary.string.CommonStrings
import _root_.org.w3c.dom.Document
import _root_.org.w3c.dom.Node
import _root_.org.w3c.dom.NodeList

class TaxFactory private() {
    import _root_.org.allbinary.business.user.commerce.money.tax.TaxFactory.{*}

    val logUtil : LogUtil = LogUtil.getInstance()

    val commonStrings : CommonStrings = CommonStrings.getInstance()

    private val TAXATIONFILENAME : String = "taxationMethod.xml"

    //streetAddress, storeFrontInterface
    def getInstance(abeClientInformation : AbeClientInformationInterface, storeFrontInterface : StoreFrontInterface) : TaxModuleInterface = {
        val stringBuffer : StringMaker = new StringMaker()
        stringBuffer.append(URLGLOBALS.getMainPath())
        stringBuffer.append(FREEBLISKET_PATH_GLOBALS.getInstance().XSLPATH)
        stringBuffer.append(storeFrontInterface.getName())
        stringBuffer.append(AbPathData.getInstance().SEPARATOR)
        stringBuffer.append("generic")
        stringBuffer.append(AbPathData.getInstance().SEPARATOR)
        stringBuffer.append("taxes")
        stringBuffer.append(AbPathData.getInstance().SEPARATOR)
        val abPath : AbPath = new AbPath(stringBuffer.toString(), TAXATIONFILENAME)
        val transformInfoObjectConfigData : TransformInfoObjectConfigData = TransformInfoObjectConfigData.getInstance()
        val data : String = new CryptFileReader(transformInfoObjectConfigData.UNCRYPTED_EXTENSION, transformInfoObjectConfigData.ENCRYPTED_EXTENSION).get(abPath)
        val document : Document = DomDocumentHelper.create(data)
        val taxNameNodeList : NodeList = document.getElementsByTagName(TaxData.NAME)

        {
            var index : Int = 0
            while (index < taxNameNodeList.getLength()) {
                //.getElementsByTagName(TaxData.NAME);
                val node : Node = taxNameNodeList.item(index)
                val nodeList : NodeList = node.getChildNodes()
                if (nodeList != null) {
                    val classNameNode : Node = DomSearchHelper.getNode(DynamicObjectData.NAME, nodeList)
                    if (classNameNode != null) {
                        val className : String = DomNodeHelper.getTextNodeValue(classNameNode)
                        return AbeFactory.getInstance().getInstance(abeClientInformation, className).asInstanceOf[TaxModuleInterface]
                    } else {
                        if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().TAX)) {
                            this.logUtil.putF("Class Node Null", this, this.commonStrings.GET_INSTANCE)
                        }
                    }
                } else {
                    if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().TAX)) {
                        this.logUtil.putF("Tax Name Node Node Children", this, this.commonStrings.GET_INSTANCE)
                    }
                }
                index += 1
            }
        }
        //Defaults to simple state tax
        return (new SimpleStateTaxModule()).asInstanceOf[TaxModuleInterface]
    }

}

object TaxFactory {
    private val instance : TaxFactory = new TaxFactory()

    def getInstance() : TaxFactory = {
        return TaxFactory.instance
    }

}


