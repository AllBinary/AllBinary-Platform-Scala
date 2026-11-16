/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.business.user.commerce.inventory.basket

import _root_.java.util.HashSet
import _root_.java.util.Set
import _root_.org.allbinary.util.BasicArrayList
import _root_.org.allbinary.util.BasicArrayListD
import _root_.org.allbinary.business.user.commerce.inventory.item.Item
import _root_.org.allbinary.business.user.commerce.inventory.item.ItemView
import _root_.org.allbinary.logic.StdUtil
import _root_.org.w3c.dom.Document
import _root_.org.w3c.dom.Node

class BasketReview() {

    var items : BasicArrayList = new BasicArrayListD()

    def isValid() : _root_.java.lang.Boolean = {
        //should run through all items and check validity
        return _root_.java.lang.Boolean.TRUE
    }

    def addItem(item : Item) : Unit = {
        this.items.add(item)
    }

    def getItems() : BasicArrayList = {
        return this.items
    }

    def removeItem(id : String) : Unit = {
        val itemArray : Array[Object] = this.items.toArray()
        val size : Int = itemArray.length

        {
            var index : Int = 0
            while (index < size) {
                var item : Item = itemArray(index).asInstanceOf[Item]
                if (item.getId().compareTo(id) == 0) {
                    this.items.remove(item)
                }
                index += 1
            }
        }
    }

    def adjustItem(id : String, num : String) : Unit = {
        val itemArray : Array[Object] = this.items.toArray()
        val size : Int = itemArray.length

        {
            var index : Int = 0
            while (index < size) {
                var item : Item = itemArray(index).asInstanceOf[Item]
                if (item.getId().compareTo(id) == 0) {
                    item.setNumber(num)
                }
                index += 1
            }
        }
    }

    def getTotalWeight() : String = {
        var weightFloat : Float = 0
        val itemArray : Array[Object] = this.items.toArray()
        val size : Int = itemArray.length

        {
            var index : Int = 0
            while (index < size) {
                var item : Item = itemArray(index).asInstanceOf[Item]
                weightFloat += new _root_.java.lang.Float(item.getWeight()).floatValue()
                index += 1
            }
        }
        return new _root_.java.lang.Float(weightFloat).toString()
    }

    def getNumberOfItems() : Integer = {
        return new Integer(this.items.size())
    }

    def getIds() : Set[Object] = {
        var idSet : HashSet[Object] = new HashSet[Object]()
        val itemArray : Array[Object] = this.items.toArray()
        val size : Int = itemArray.length

        {
            var index : Int = 0
            while (index < size) {
                var item : Item = itemArray(index).asInstanceOf[Item]
                idSet.add(item.getId())
                index += 1
            }
        }
        return idSet.asInstanceOf[Set[Object]]
    }

    def getNumberOf(id : String) : Integer = {
        val itemArray : Array[Object] = this.items.toArray()
        val size : Int = itemArray.length

        {
            var index : Int = 0
            while (index < size) {
                var item : Item = itemArray(index).asInstanceOf[Item]
                if (item.getId().compareTo(id) == 0) {
                    return new Integer(item.getNumber())
                }
                index += 1
            }
        }
        return new Integer(0)
    }

    def toXmlNode(document : Document) : Node = {
        var node : Node = document.createElement(BasketData.BASKET)
        val itemArray : Array[Object] = this.items.toArray()
        val size : Int = itemArray.length

        {
            var index : Int = 0
            while (index < size) {
                var item : Item = itemArray(index).asInstanceOf[Item]
                node.appendChild(new ItemView(item, new BasicArrayListD()).toXmlNode(document))
                index += 1
            }
        }
        return node
    }

}


