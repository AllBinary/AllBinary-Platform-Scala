/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.business.context.modules.storefront.statistics.advertisements

import _root_.java.util.HashMap
import _root_.org.allbinary.util.BasicArrayList
import _root_.org.allbinary.util.BasicArrayListD
import _root_.org.allbinary.business.context.modules.storefront.StoreFrontInterface
import _root_.org.allbinary.logic.StdUtil

class StoreFrontAdvertisementsStatistics(param_storeFrontInterface : StoreFrontInterface) extends StoreFrontAdvertisementsStatisticsInterface {

    //private Money totalAdvertisementsSaleValue;
    //Constructor
    {
        val storeFrontInterface : StoreFrontInterface = param_storeFrontInterface
    }

    /*    public long getNumberOfAdsShown()    {    }     public Money getTotal()    {    }     */
    def toHashMap() : HashMap[Object, Object] = {
        var hashMap : HashMap[Object, Object] = StdUtil.getInstance().createHashMap().asInstanceOf[HashMap[Object, Object]]
        //hashMap.put();
        return hashMap
    }

    def toVector() : BasicArrayList = {
        return null
    }

    def getKey() : Object = {
        return null
    }

}


