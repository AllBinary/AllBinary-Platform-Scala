/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package views.generic.inventory

import _root_.java.util.HashMap
import _root_.org.allbinary.util.BasicArrayList
import _root_.org.allbinary.util.BasicArrayListD
import _root_.org.allbinary.business.user.commerce.inventory.item.BasicItemData
import _root_.org.allbinary.data.tables.user.commerce.inventory.item.InventoryEntity
import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.logic.string.StringValidationUtil

class InventoryColumnUtil {
    import _root_.views.generic.inventory.InventoryColumnUtil.{*}

    val logUtil : LogUtil = LogUtil.getInstance()

    val basicItemData : BasicItemData = BasicItemData.getInstance()

    //Doesn't really get keywords
    def getColumnWhereLike(inventoryEntity : InventoryEntity, category : String, column : String) : BasicArrayList = {
        this.logUtil.putF("Start Category: " + category, this, "getKeywords")
        // storeFront.getCategoryPath() + AbSqlData.ANYMULTICHARACTERMATCH);
        var keywords : BasicArrayList = new BasicArrayListD()
        var vectorOfHashMaps : BasicArrayList = inventoryEntity.getAllRows()
        var size : Int = vectorOfHashMaps.size()

        {
            var index : Int = 0
            while (index < size) {
                var hashMap : HashMap[Object, Object] = vectorOfHashMaps.get(index).asInstanceOf[HashMap[Object, Object]]
                var categoryName : String = hashMap.get(basicItemData.CATEGORY).asInstanceOf[String]
                //this.logUtil.putF(NEXTCATEGORY + categoryName, this, "getKeywords");
                if (!StringValidationUtil.getInstance().isEmpty(categoryName) && categoryName.startsWith(category)) {
                    //Add next ID
                    keywords.add(hashMap.get(column))
                }
                index += 1
            }
        }
        /////////
        return keywords
    }

}

object InventoryColumnUtil {
    private val instance : InventoryColumnUtil = new InventoryColumnUtil()

    def getInstance() : InventoryColumnUtil = {
        return InventoryColumnUtil.instance
    }

}


