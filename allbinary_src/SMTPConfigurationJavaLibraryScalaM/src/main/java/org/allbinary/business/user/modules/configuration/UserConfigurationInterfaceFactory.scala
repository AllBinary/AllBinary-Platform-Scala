/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.business.user.modules.configuration

import _root_.org.allbinary.business.user.role.UserRole
import _root_.org.allbinary.data.tree.dom.DomSearchHelper
import _root_.org.allbinary.data.tree.dom.document.DomDocumentHelper
import _root_.org.allbinary.globals.FREEBLISKET_PATH_GLOBALS
import _root_.org.allbinary.globals.URLGLOBALS
import _root_.org.allbinary.logic.control.crypt.file.CryptFileReader
import _root_.org.allbinary.logic.io.path.AbPath
import _root_.org.allbinary.logic.io.path.AbPathData
import _root_.org.w3c.dom.Document
import _root_.org.w3c.dom.Node

class UserConfigurationInterfaceFactory private() {
    import _root_.org.allbinary.business.user.modules.configuration.UserConfigurationInterfaceFactory.{*}

}

object UserConfigurationInterfaceFactory {
    private val configurationName : String = "DefaultUserConfiguration"

    def getInstance(document : Document) : UserConfigurationInterface = {
        var configurationNode : Node = DomSearchHelper.getNode(UserConfigurationData.NAME, document.getChildNodes())
        return new UserConfigurationView(configurationNode).getUserConfigurationInterface().asInstanceOf[UserConfigurationInterface]
    }

    def getInstance(userRole : UserRole) : UserConfigurationInterface = {
        //user business object key as configuration file name
        var abPath : AbPath = new AbPath(URLGLOBALS.getMainPath() + FREEBLISKET_PATH_GLOBALS.getInstance().USERCONFIGURATIONPATH, ((UserConfigurationInterfaceFactory.configurationName + userRole.toString()) + AbPathData.getInstance().EXTENSION_SEP) + UserConfigurationData.UNCRYPTED_EXTENSION)
        var documentString : String = new CryptFileReader(UserConfigurationData.UNCRYPTED_EXTENSION, UserConfigurationData.ENCRYPTED_EXTENSION).get(abPath)
        var document : Document = DomDocumentHelper.create(documentString)
        return UserConfigurationInterfaceFactory.getInstance(document)
    }

    //Default User Configuration
    def getInstance() : UserConfigurationInterface = {
        return new UserConfiguration()
    }

}


