/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.business.context.configuration

import _root_.org.allbinary.data.tree.dom.DomSearchHelper
import _root_.org.allbinary.data.tree.dom.document.DomDocumentHelper
import _root_.org.allbinary.logic.control.crypt.file.CryptFileReader
import _root_.org.allbinary.logic.io.path.AbPath
import _root_.org.w3c.dom.Document
import _root_.org.w3c.dom.Node

class ContextConfigurationInterfaceFactory private() {
    import _root_.org.allbinary.business.context.configuration.ContextConfigurationInterfaceFactory.{*}

    def getInstance(document : Document) : ContextConfigurationInterface = {
        val contextConfigurationData : ContextConfigurationData = ContextConfigurationData.getInstance()
        val contextConfigurationNode : Node = DomSearchHelper.getNode(contextConfigurationData.NAME, document.getChildNodes())
        return new ContextConfigurationView(contextConfigurationNode).getContextConfigurationInterface().asInstanceOf[ContextConfigurationInterface]
    }

    def getInstance(contextName : String) : ContextConfigurationInterface = {
        //user business object key as configuration file name
        val abPath : AbPath = ContextConfigurationPathUtil.getAbPath(contextName)
        val contextConfigurationData : ContextConfigurationData = ContextConfigurationData.getInstance()
        val documentString : String = new CryptFileReader(contextConfigurationData.UNCRYPTED_EXTENSION, contextConfigurationData.ENCRYPTED_EXTENSION).get(abPath)
        val document : Document = DomDocumentHelper.create(documentString)
        return this.getInstance(document)
    }

}

object ContextConfigurationInterfaceFactory {
    private val instance : ContextConfigurationInterfaceFactory = new ContextConfigurationInterfaceFactory()

    /**      * @return the instance      */
    def getInstance() : ContextConfigurationInterfaceFactory = {
        return ContextConfigurationInterfaceFactory.instance
    }

}


