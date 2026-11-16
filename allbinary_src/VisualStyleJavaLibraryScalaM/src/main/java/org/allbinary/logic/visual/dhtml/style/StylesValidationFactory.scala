/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *   */
/* Generated Code Do Not Modify */
package org.allbinary.logic.visual.dhtml.style

import _root_.java.util.HashMap
import _root_.org.allbinary.util.BasicArrayList
import _root_.org.allbinary.util.BasicArrayListD
import _root_.org.allbinary.data.tree.dom.DomSearchHelper
import _root_.org.allbinary.data.tree.dom.document.XmlDocumentHelper
import _root_.org.allbinary.logic.communication.http.request.NameSpaceRequestParamData
import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.logic.visual.dhtml.style.css.CssElementData
import _root_.org.allbinary.logic.visual.dhtml.style.css.CssElementsValidationFactory
import _root_.org.allbinary.string.CommonStrings
import _root_.org.w3c.dom.Document
import _root_.org.w3c.dom.Node
import _root_.org.w3c.dom.NodeList

class StylesValidationFactory private() {
    import _root_.org.allbinary.logic.visual.dhtml.style.StylesValidationFactory.{*}

    val logUtil : LogUtil = LogUtil.getInstance()

    def getInstance(document : Document) : BasicArrayList = {
        val commonStrings : CommonStrings = CommonStrings.getInstance()
        //Get all styles nodes
        var nodeList : NodeList = document.getElementsByTagName(StylesData.getInstance().NAME)
        if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().VIEW)) {
            this.logUtil.putF("Style Present: " + XmlDocumentHelper.toString(document), this, commonStrings.GET_INSTANCE)
        }
        if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().VIEW)) {
            this.logUtil.putF("Styles Present: " + nodeList.getLength(), this, commonStrings.GET_INSTANCE)
        }

        {
            var index : Int = 0
            while (index < nodeList.getLength()) {
                var stylesNode : Node = nodeList.item(index)
                //Get all style nodes
                var styleNodeList : BasicArrayList = DomSearchHelper.getAllNodes(StyleData.getInstance().NAME, stylesNode.getChildNodes())
                if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().VIEW)) {
                    this.logUtil.putF("Number Of Style Nodes Present: " + styleNodeList.size(), this, commonStrings.GET_INSTANCE)
                }

                {
                    var styleNodesIndex : Int = 0
                    while (styleNodesIndex < styleNodeList.size()) {
                        //Nodes with StyleData.NAME
                        var styleNode : Node = styleNodeList.get(styleNodesIndex).asInstanceOf[Node]
                        //Nodes with CssElementData.NAME
                        var cssElementStyleNodeList : BasicArrayList = DomSearchHelper.getAllNodes(CssElementData.getInstance().NAME, styleNode.getChildNodes())
                        if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().VIEW)) {
                            this.logUtil.putF("Number Of Element Nodes Present: " + cssElementStyleNodeList.size(), this, commonStrings.GET_INSTANCE)
                        }
                        return CssElementsValidationFactory.getInstance(cssElementStyleNodeList)
                        styleNodesIndex += 1
                    }
                }
                index += 1
            }
        }
        if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().VIEW)) {
            this.logUtil.putF("No Style Present", this, commonStrings.GET_INSTANCE)
        }
        return new BasicArrayListD()
    }

}

object StylesValidationFactory {
    private val instance : StylesValidationFactory = new StylesValidationFactory()

    def getInstance() : StylesValidationFactory = {
        return StylesValidationFactory.instance
    }

    def getInstance(hashMap : HashMap[Object, Object]) : BasicArrayList = {
        //BasicArrayList styles = new BasicArrayListD();
        var stylesDocument : Document = hashMap.get(NameSpaceRequestParamData.DOCUMENT).asInstanceOf[Document]
        return StylesValidationFactory.getInstance().getInstance(stylesDocument)
    }

}


