/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package views.business.context.modules.storefront.customizer.bodies.generic.title

import _root_.org.allbinary.business.page.PageData
import _root_.org.allbinary.data.tree.dom.DomNodeInterface
import _root_.org.allbinary.data.tree.dom.ModDomHelper
import _root_.org.allbinary.data.tree.dom.document.XmlDocumentHelper
import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.logic.string.StringValidationUtil
import _root_.org.allbinary.logic.visual.transform.StoreTransformer
import _root_.org.allbinary.logic.visual.transform.info.TransformInfoInterface
import _root_.org.allbinary.logic.visual.transform.template.customizer.bodies.title.TitleBodyValidation
import _root_.org.allbinary.logic.visual.transform.template.util.TransformTemplateCustomizerUtil
import _root_.org.apache.commons.lang3.StringEscapeUtils
import _root_.org.w3c.dom.Document
import _root_.org.w3c.dom.Node
import _root_.views.business.context.modules.storefront.HttpStoreComponentView

class TitleBodyCustomizerView(param_transformInfoInterface : TransformInfoInterface) extends HttpStoreComponentView(param_transformInfoInterface) with DomNodeInterface {
    import _root_.views.business.context.modules.storefront.customizer.bodies.generic.title.TitleBodyCustomizerView.{*}

    val logUtil_TitleBodyCustomizerView : LogUtil = LogUtil.getInstance()

    var titleBody : TitleBodyValidation = null

    //Constructor
    {
        val transformInfoInterface : TransformInfoInterface = param_transformInfoInterface
    }

    def addDomNodeInterfaces() : Unit = {
        this.addDomNodeInterface(this.titleBody.asInstanceOf[DomNodeInterface])
        this.addDomNodeInterface(this.asInstanceOf[DomNodeInterface])
    }

    def toXmlNode(document : Document) : Node = {
        var pageName : String = TransformTemplateCustomizerUtil.getInstance().getPageNameHack(this.getTransformInfoInterface().getName(), this.getWeblisketSession().getStoreName())
        if (StringValidationUtil.getInstance().isEmpty(pageName)) {
            pageName = TitleBodyCustomizerView.NAME
        }
        return ModDomHelper.createNameValueNodes(document, PageData.getInstance().NAME, pageName)
    }

    override def view() : String = {
        try {
            var success : String = XmlDocumentHelper.toString(this.getDoc())
            var result : String = new StoreTransformer(this.abeClientInformation, this.getTransformInfoInterface()).translate(success)
            return StringEscapeUtils.unescapeHtml3(result)
        } catch {
            case e : Exception => {
                if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().TAGHELPERERROR)) {
                    this.logUtil_TitleBodyCustomizerView.put(this.commonStrings.EXCEPTION, this, "view()", e)
                }
                throw e
            }
        }
        throw new IllegalStateException()
    }

}

object TitleBodyCustomizerView {
    private val NAME : String = "None"

}


