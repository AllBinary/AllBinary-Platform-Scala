/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.business.user.commerce.inventory.basket

import _root_.java.io.Serializable
import _root_.java.util.HashMap
import _root_.java.util.Set
import _root_.org.allbinary.business.user.commerce.inventory.item.ItemInterface
import _root_.org.allbinary.business.user.commerce.money.Money
import _root_.org.allbinary.business.user.commerce.money.MoneyException
import _root_.org.allbinary.data.tables.user.commerce.inventory.item.InventoryEntity
import _root_.org.allbinary.data.tables.user.commerce.inventory.item.InventoryEntityFactory
import _root_.org.allbinary.logic.StdUtil

class Basket() extends BasketInterface with Serializable {

    private var items : HashMap[Object, Object] = StdUtil.getInstance().createHashMap().asInstanceOf[HashMap[Object, Object]]

    def addItem(id : String, num : String) : Unit = {
        if (this.items.containsKey(id)) {
            var oldNumStr : String = new String(this.items.get(id).asInstanceOf[String])
            var oldNumInt : Integer = Integer.valueOf(oldNumStr)
            var numInt : Integer = Integer.valueOf(num)
            var newNumInt : Integer = new Integer(oldNumInt.intValue() + numInt.intValue())
            this.items.put(id, newNumInt.toString())
        } else {
            this.items.put(id, num)
        }
    }

    def removeItem(id : String) : Unit = {
        this.items.remove(id)
    }

    def adjustItem(id : String, num : String) : Unit = {
        if (Integer.valueOf(num).intValue() > 0) {
            this.items.put(id, num)
        } else {
            this.items.remove(id)
        }
    }

    def getTotalWeight() : String = {
        val itemsAndNumberInBasket : HashMap[Object, Object] = this.getItems().asInstanceOf[HashMap[Object, Object]]
        val totalWeight : Money = new Money()
        if (itemsAndNumberInBasket.size() > 0) {
            val items : Set[Object] = itemsAndNumberInBasket.keySet().asInstanceOf[Set[Object]]
            var product : String = null
            var weightFloat : _root_.java.lang.Float = null
            val itemArray : Array[Object] = items.toArray()
            val size : Int = itemArray.length

            {
                var index : Int = 0
                while (index < size) {
                    product = new String(itemArray(index).asInstanceOf[String])
                    weightFloat = new _root_.java.lang.Float(new InventoryEntity().getWeight(product))
                    weightFloat = new _root_.java.lang.Float(getNumberOf(product).floatValue() * weightFloat.floatValue())
                    totalWeight.add(weightFloat.toString())
                    index += 1
                }
            }
        }
        return totalWeight.toString()
    }

    def getNumberOfItems() : Integer = {
        return new Integer(this.items.size())
    }

    def getIds() : Set[Object] = {
        var set : Set[Object] = this.items.keySet().asInstanceOf[Set[Object]]
        return set
    }

    def getItems() : HashMap[Object, Object] = {
        return this.items
    }

    def getNumberOf(product : String) : Integer = {
        var numStr : String = this.items.get(product).asInstanceOf[String]
        return Integer.valueOf(numStr)
    }

    def getSubTotal() : Money = {
        var itemsAndNumberInBasket : HashMap[Object, Object] = this.getItems().asInstanceOf[HashMap[Object, Object]]
        var subTotal : Money = new Money()
        if (itemsAndNumberInBasket.size() > 0) {
            var items : Set[Object] = itemsAndNumberInBasket.keySet().asInstanceOf[Set[Object]]
            var inventoryEntityFactory : InventoryEntityFactory = InventoryEntityFactory.getInstance()
            var inventoryEntity : InventoryEntity = inventoryEntityFactory.getInventoryEntityInstance().asInstanceOf[InventoryEntity]
            val itemArray : Array[Object] = items.toArray()
            val size : Int = itemArray.length

            {
                var index : Int = 0
                while (index < size) {
                    var product : String = new String(itemArray(index).asInstanceOf[String])
                    var itemInterface : ItemInterface = inventoryEntity.getItem(product)
                    var productTotal : Money = itemInterface.getPrice()
                    productTotal.multiply(getNumberOf(product).intValue())
                    subTotal.add(productTotal.toString())
                    index += 1
                }
            }
        }
        return subTotal
    }

}


