/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *   */
/* Generated Code Do Not Modify */
package views.admin.customizers

import _root_.java.util.Arrays
import _root_.org.allbinary.util.BasicArrayList
import _root_.org.allbinary.util.BasicArrayListD
import _root_.org.allbinary.data.tables.transform.info.TransformInfoEntityBuilder
import _root_.org.allbinary.data.tree.dom.DomNodeInterface
import _root_.org.allbinary.data.tree.dom.ModDomHelper
import _root_.org.allbinary.globals.GLOBALS2
import _root_.org.allbinary.logic.StdUtil
import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.logic.control.sort.StringComparator
import _root_.org.allbinary.logic.visual.transform.info.CustomizerTransformInfoData
import _root_.org.allbinary.logic.visual.transform.info.TransformInfoInterface
import _root_.org.allbinary.logic.visual.transform.template.customizer.TransformTemplateCustomizerData
import _root_.org.allbinary.logic.visual.transform.template.customizer.TransformTemplateCustomizersData
import _root_.org.allbinary.logic.visual.transform.template.customizer.bodies.BodyData
import _root_.org.allbinary.logic.visual.transform.template.customizer.widgets.title.TitleData
import _root_.org.allbinary.logic.visual.transform.template.util.TransformTemplateCustomizerUtil
import _root_.org.allbinary.string.CommonStrings
import _root_.org.w3c.dom.Document
import _root_.org.w3c.dom.Node
import _root_.views.business.context.modules.storefront.HttpStoreComponentView

class CustomizersView(param_transformInfoInterface : TransformInfoInterface) extends HttpStoreComponentView(param_transformInfoInterface) with DomNodeInterface {

    val logUtil_CustomizersView : LogUtil = LogUtil.getInstance()

    val commonStrings_CustomizersView : CommonStrings = CommonStrings.getInstance()

    var customizersVector : BasicArrayList = null

    //Constructor
    {
        val transformInfoInterface : TransformInfoInterface = param_transformInfoInterface
        //String storeName = ;
        this.customizersVector = TransformInfoEntityBuilder.getInstance().getNames(this.getWeblisketSession().getStoreName())
    }

    def toXmlNode(document : Document) : Node = {
        try {
            val node : Node = document.createElement(TransformTemplateCustomizersData.NAME)
            val unsortedCustomizerViewVector : BasicArrayList = new BasicArrayListD()
            val size : Int = this.customizersVector.size()

            {
                var index : Int = 0
                while (index < size) {
                    val viewName : String = this.customizersVector.get(index).asInstanceOf[String]
                    if ((((viewName.indexOf(CustomizerTransformInfoData.NAME) > 0) && (viewName.indexOf(GLOBALS2.EDIT) > 0)) && (viewName.indexOf(BodyData.getInstance().VIEWNAMEKEY) > 0)) && (viewName.indexOf(TitleData.getInstance().VIEWNAMEKEY) > 0)) {
                        unsortedCustomizerViewVector.add(viewName)
                    }
                    index += 1
                }
            }
            val objectArray : Array[Object] = unsortedCustomizerViewVector.toArray().asInstanceOf[Array[Object]]
            //String[] customizerViews = (String[]) objectArray;
            Arrays.sort(objectArray, new StringComparator())

            {
                var index : Int = 0
                while (index < objectArray.length) {
                    val viewName : String = objectArray(index).asInstanceOf[String]
                    val viewNameNode : Node = ModDomHelper.createNameValueNodes(document, TransformTemplateCustomizerData.NAME, viewName, TransformTemplateCustomizerUtil.getInstance().getPageNameHack(viewName, this.getWeblisketSession().getStoreName()))
                    //+ " " + TransformInfoObjectConfigData.BODY
                    node.appendChild(viewNameNode)
                    index += 1
                }
            }
            return node
        } catch {
            case e : Exception => {
                if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().XSLLOGGINGERROR)) {
                    this.logUtil_CustomizersView.put(this.commonStrings_CustomizersView.FAILURE, this, "toXmlNode", e)
                }
                return null
            }
        }
        throw new IllegalStateException()
    }

    def addDomNodeInterfaces() : Unit = {
        this.addDomNodeInterface(this.asInstanceOf[DomNodeInterface])
    }

    override def view() : String = {
        try {
            this.addDomNodeInterfaces()
            return super.view()
        } catch {
            case e : Exception => {
                if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().TAGHELPERERROR)) {
                    this.logUtil_CustomizersView.put(this.commonStrings_CustomizersView.EXCEPTION, this, "view()", e)
                }
                throw e
            }
        }
        throw new IllegalStateException()
    }

}


