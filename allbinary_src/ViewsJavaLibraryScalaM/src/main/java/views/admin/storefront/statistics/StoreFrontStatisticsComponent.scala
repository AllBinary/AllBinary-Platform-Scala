/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package views.admin.storefront.statistics

import _root_.org.allbinary.business.context.modules.storefront.StoreFrontFactory
import _root_.org.allbinary.business.context.modules.storefront.StoreFrontInterface
import _root_.org.allbinary.business.context.modules.storefront.statistics.RealTimeStoreFrontStatistics
import _root_.org.allbinary.business.context.modules.storefront.statistics.RealTimeStoreFrontStatisticsView
import _root_.org.allbinary.data.tree.dom.DomNodeInterface
import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.logic.visual.transform.info.TransformInfoInterface
import _root_.views.business.context.modules.storefront.HttpStoreComponentView

class StoreFrontStatisticsComponent(param_transformInfoInterface : TransformInfoInterface) extends HttpStoreComponentView(param_transformInfoInterface) {

    val logUtil_StoreFrontStatisticsComponent : LogUtil = LogUtil.getInstance()

    var newStoreFrontInterface : StoreFrontInterface = null

    private var domNodeInterface : DomNodeInterface = null

    //Constructor
    {
        val transformInfoInterface : TransformInfoInterface = param_transformInfoInterface
        this.newStoreFrontInterface = StoreFrontFactory.getInstance(transformInfoInterface.getStoreName()).asInstanceOf[StoreFrontInterface]
        this.domNodeInterface = new RealTimeStoreFrontStatisticsView(new RealTimeStoreFrontStatistics(this.newStoreFrontInterface), this.getWeblisketSession().getRole())
    }

    def addDomNodeInterfaces() : Unit = {
        this.addDomNodeInterface(this.domNodeInterface.asInstanceOf[DomNodeInterface])
    }

    override def view() : String = {
        try {
            //Store is already included in store view
            this.addDomNodeInterfaces()
            return super.view()
        } catch {
            case e : Exception => {
                if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().TAGHELPERERROR)) {
                    this.logUtil_StoreFrontStatisticsComponent.put(this.commonStrings.EXCEPTION, this, "view()", e)
                }
                throw e
            }
        }
        throw new IllegalStateException()
    }

}


