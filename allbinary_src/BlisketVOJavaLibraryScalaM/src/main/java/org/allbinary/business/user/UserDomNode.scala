/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.business.user

import _root_.java.util.HashMap
import _root_.org.allbinary.business.entry.EntryData
import _root_.org.allbinary.data.tables.TableMappingInterface
import _root_.org.allbinary.data.tree.dom.DomNodeInterface
import _root_.org.allbinary.data.tree.dom.ModDomHelper
import _root_.org.allbinary.logic.string.StringUtil
import _root_.org.w3c.dom.Document
import _root_.org.w3c.dom.Node

class UserDomNode(param_dataMappingInterface : TableMappingInterface) extends DomNodeInterface {

    private var dataMappingInterface : TableMappingInterface = null

    //Constructor
    {
        val dataMappingInterface : TableMappingInterface = param_dataMappingInterface
        this.dataMappingInterface = dataMappingInterface
    }

    def toXmlNode(document : Document) : Node = {
        val EMPTY_STRING : String = StringUtil.getInstance().EMPTY_STRING
        var hashMap : HashMap[Object, Object] = this.dataMappingInterface.toHashMap().asInstanceOf[HashMap[Object, Object]]
        hashMap.put(EntryData.getInstance().LASTMODIFIED, EMPTY_STRING)
        hashMap.put(EntryData.getInstance().ENCRYPTION, EMPTY_STRING)
        hashMap.put(UserData.PASSWORD, EMPTY_STRING)
        return ModDomHelper.createNameValueNodes(document, UserData.NAME, hashMap)
    }

    def toXmlDoc() : Document = {
        return null
    }

    def view() : String = {
        return null
    }

}


