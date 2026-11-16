/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package views.generic.advertisement.area

import _root_.org.allbinary.business.advertisement.area.AdvertisementAreaData
import _root_.org.allbinary.business.advertisement.area.AdvertisementAreaInterface
import _root_.org.allbinary.data.tables.advertisement.areas.AdvertisementAreasEntityFactory
import _root_.org.allbinary.data.tables.advertisement.areas.AdvertisementAreasEntityInterface
import _root_.org.allbinary.data.tree.dom.DomNodeInterface
import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.logic.visual.transform.info.TransformInfoInterface
import _root_.org.w3c.dom.Document
import _root_.org.w3c.dom.Node
import _root_.views.business.context.modules.storefront.HttpStoreComponentView

class AdvertisementAreaView(param_transformInfoInterface : TransformInfoInterface) extends HttpStoreComponentView(param_transformInfoInterface) with DomNodeInterface {

    val logUtil_AdvertisementAreaView : LogUtil = LogUtil.getInstance()

    //this.request = (HttpServletRequest) this.getPageContext().getRequest();
    private var advertisementAreaName : String = null

    //Constructor
    {
        val transformInfoInterface : TransformInfoInterface = param_transformInfoInterface
        this.advertisementAreaName = this.getPropertiesHashMap().get(AdvertisementAreaData.getInstance().NAME).asInstanceOf[String]
    }

    def toXmlNode(document : Document) : Node = {
        try {
            //1 get ad area info
            var advertisementAreasEntityInterface : AdvertisementAreasEntityInterface = AdvertisementAreasEntityFactory.getInstance()
            var advertisementAreaInterface : AdvertisementAreaInterface = advertisementAreasEntityInterface.get(this.getTransformInfoInterface().getStoreName(), this.advertisementAreaName)
            //return new AdvertisementView(advertisementInterface).toXmlNode(document);
            return null
        } catch {
            case e : Exception => {
                if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().XSLLOGGINGERROR)) {
                    this.logUtil_AdvertisementAreaView.put(this.commonStrings.FAILURE, this, "toXmlNode", e)
                }
                throw e
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
                    this.logUtil_AdvertisementAreaView.put(this.commonStrings.EXCEPTION, this, "view()", e)
                }
                throw e
            }
        }
        throw new IllegalStateException()
    }

}


