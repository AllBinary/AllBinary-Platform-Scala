/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.data.tree.dom

import _root_.java.util.HashMap
import _root_.org.allbinary.data.tables.TableMappingInterface
import _root_.org.allbinary.logic.io.file.AbFile
import _root_.org.w3c.dom.Document
import _root_.org.w3c.dom.Node

class FileDomDataModel(param_file : AbFile) extends DomNodeInterface {

    private var file : AbFile = null

    //Constructor
    {
        val file : AbFile = param_file
        this.file = file
    }

    def toXmlNode(document : Document) : Node = {
        var tableMappingInterface : TableMappingInterface = (new FileTableMapping(this.file)).asInstanceOf[TableMappingInterface]
        var hashMap : HashMap[Object, Object] = tableMappingInterface.toHashMap().asInstanceOf[HashMap[Object, Object]]
        //)createNameValueNodes(
        return ModDomHelper.createNodeWithValueNodes(document, "file", hashMap)
    }

}


