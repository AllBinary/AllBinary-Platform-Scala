/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.input.automation.module.generic.configuration.profile

import _root_.java.util.HashMap
import _root_.org.allbinary.data.tree.dom.DomNodeHelper
import _root_.org.allbinary.data.tree.dom.ModDomHelper
import _root_.org.allbinary.input.media.image.InputImageType
import _root_.org.allbinary.logic.StdUtil
import _root_.org.w3c.dom.Document
import _root_.org.w3c.dom.Node

class GenericProfileDataWorkerType(param_name : String) extends GenericProfileDataWorkerTypeInterface {
    import _root_.org.allbinary.input.automation.module.generic.configuration.profile.GenericProfileDataWorkerType.{*}

    private var name : String = null

    //Constructor
    {
        val name : String = param_name
        this.setName(name)
        GenericProfileDataWorkerType.hashMap.put(this.getName(), this)
    }

    def getName() : String = {
        return this.name
    }

    def setName(name : String) : Unit = {
        this.name = name
    }

    def toXmlNode(document : Document) : Node = {
        var node : Node = ModDomHelper.createTextNode(document, GenericProfileDataWorkerData.NAME, this.name)
        return node
    }

    override def toString() : String = {
        return "GenericProfileDataWorkerType: " + this.getName()
    }

}

object GenericProfileDataWorkerType {
    private var hashMap : HashMap[Object, Object] = StdUtil.getInstance().createHashMap().asInstanceOf[HashMap[Object, Object]]

    var SAVED_CAPTURE : GenericProfileDataWorkerType = SavedCaptureGenericProfileDataWorkerType.SAVED_CAPTURE

    var SCREEN_CAPTURE : GenericProfileDataWorkerType = new GenericProfileDataWorkerType("Screen " + InputImageType.CAPTURE.getName())

    var COMPARISON : GenericProfileDataWorkerType = new GenericProfileDataWorkerType(InputImageType.COMPARISON.getName())

    var MOTION : GenericProfileDataWorkerType = new GenericProfileDataWorkerType(InputImageType.MOTION.getName())

    def getInstance(node : Node) : GenericProfileDataWorkerType = {
        var name : String = DomNodeHelper.getTextNodeValue(node)
        return GenericProfileDataWorkerType.hashMap.get(name).asInstanceOf[GenericProfileDataWorkerType]
    }

}


