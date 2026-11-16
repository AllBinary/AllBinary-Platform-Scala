/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.logic.visual.transform.template.customizer.widgets.title

import _root_.java.util.HashMap
import _root_.org.allbinary.data.tree.dom.DomData
import _root_.org.allbinary.data.tree.dom.DomNodeHelper
import _root_.org.allbinary.data.tree.dom.DomNodeInterface
import _root_.org.allbinary.data.tree.dom.DomSearchHelper
import _root_.org.allbinary.data.tree.dom.ModDomHelper
import _root_.org.allbinary.logic.StdUtil
import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.logic.string.StringValidationUtil
import _root_.org.allbinary.string.CommonStrings
import _root_.org.w3c.dom.Document
import _root_.org.w3c.dom.Node

class TitleView() extends DomNodeInterface {
    import _root_.org.allbinary.logic.visual.transform.template.customizer.widgets.title.TitleView.{*}

    val logUtil : LogUtil = LogUtil.getInstance()

    val commonStrings : CommonStrings = CommonStrings.getInstance()

    private var title : String = null

    //Constructor
    {
        this.title = TitleView.NAME
    }

    def this(node : Node) = {
        this()
        var titleTextNode : Node = DomSearchHelper.getNode(TitleData.getInstance().TEXT, node.getChildNodes())
        var valueNode : Node = DomSearchHelper.getNode(DomData.VALUE, titleTextNode.getChildNodes())
        this.title = DomNodeHelper.getTextNodeValue(valueNode)
        if (StringValidationUtil.getInstance().isEmpty(this.title)) {
            this.title = TitleView.NAME
        }
        if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().VIEW)) {
            this.logUtil.putF("Title: " + this.getTitle(), this, "Consructor()")
        }
    }

    def this(hashMap : HashMap[Object, Object]) = {
        this()
        if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().VIEW)) {
            this.logUtil.putF("HashMap: " + hashMap.toString(), this, this.commonStrings.CONSTRUCTOR)
        }
        this.getFormData(hashMap)
    }

    def getTitle() : String = {
        return this.title
    }

    def getFormData(hashMap : HashMap[Object, Object]) : Unit = {
        this.title = hashMap.get(TitleData.getInstance().TEXT).asInstanceOf[String]
        if (StringValidationUtil.getInstance().isEmpty(this.title)) {
            this.title = TitleView.NAME
        }
    }

    def toHashMap() : HashMap[Object, Object] = {
        var hashMap : HashMap[Object, Object] = StdUtil.getInstance().createHashMap().asInstanceOf[HashMap[Object, Object]]
        hashMap.put(TitleData.getInstance().TEXT, this.getTitle())
        return hashMap
    }

    def toXmlNode(document : Document) : Node = {
        var hashMap : HashMap[Object, Object] = this.toHashMap().asInstanceOf[HashMap[Object, Object]]
        if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().VIEW)) {
            this.logUtil.putF("TitleView HashMap: " + hashMap.toString(), this, "toXmlNode()")
        }
        return ModDomHelper.createNameValueNodes(document, TitleData.getInstance().NAME, hashMap)
    }

}

object TitleView {
    private val NAME : String = "None"

}


