/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.data.tables.advertisement.areas

import _root_.java.util.HashMap
import _root_.org.allbinary.util.BasicArrayList
import _root_.org.allbinary.util.BasicArrayListD
import _root_.org.allbinary.business.advertisement.area.AdvertisementAreaInterface
import _root_.org.allbinary.data.tables.BasicDataTableInterface

trait AdvertisementAreasEntityInterface extends BasicDataTableInterface {

    //AdvertisementAreaInterface
    def get(storeName : String) : BasicArrayList

    def get(storeName : String, advertisementAreaName : String) : AdvertisementAreaInterface

    def delete(value : String) : Unit

    def insert(values : BasicArrayList) : Unit

    def update(updatedValues : HashMap[Object, Object]) : Unit

}


