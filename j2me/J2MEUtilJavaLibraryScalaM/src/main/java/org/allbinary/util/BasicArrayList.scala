/* Generated Code Do Not Modify */
package org.allbinary.util

import _root_.jsinterop.annotations.JsType
import _root_.org.allbinary.logic.string.StringMaker
import _root_.org.allbinary.string.CommonLabels
import _root_.org.allbinary.string.CommonSeps
import _root_.jsinterop.annotations.JsMethod
import _root_.jsinterop.annotations.JsConstructor
import _root_.jsinterop.annotations.JsProperty

//This is a very fast and simple resizable list.
@JsType
class BasicArrayList(param_objectArray : Array[Object]) {
    import _root_.org.allbinary.util.BasicArrayList.{*}

    private val arrayUtil : ArrayUtil = ArrayUtil.getInstance()

    @JsProperty
    @transient
    var objectArray : Array[Object] = null

    private var currentIndex : Int = 0

    //Constructor
    {
        val objectArray : Array[Object] = param_objectArray
        this.objectArray = objectArray
    }

    //    }
    @JsMethod
    def addAt(index : Int, element : Object) : Unit = {
        if ((index > this.currentIndex) || (index < 0)) {
            val stringBuffer : StringMaker = new StringMaker()
            stringBuffer.append(CommonLabels.getInstance().INDEX_LABEL)
            stringBuffer.appendint(index)
            stringBuffer.append(BasicArrayList.SIZE)
            stringBuffer.appendint(this.currentIndex)
            throw new IndexOutOfBoundsException(stringBuffer.toString())
        }
        this.ensureCapacity(this.currentIndex + 1)
        System.arraycopy(this.objectArray, index, this.objectArray, index + 1, this.currentIndex - index)
        this.objectArray(index) = element
        this.currentIndex += 1
    }

    @JsMethod
    def add(anyType : Object) : Boolean = {
        this.ensureCapacity(this.currentIndex + 1)
        this.objectArray({ val value_N68433 = this.currentIndex; this.currentIndex += 1; value_N68433 }) = anyType
        return true
    }

    @JsMethod
    def removeAt(index : Int) : Object = {
        if (index >= this.currentIndex) {
            val stringBuffer : StringMaker = new StringMaker()
            stringBuffer.append(CommonLabels.getInstance().INDEX_LABEL)
            stringBuffer.appendint(index)
            stringBuffer.append(BasicArrayList.SIZE)
            stringBuffer.appendint(this.currentIndex)
            throw new IndexOutOfBoundsException(stringBuffer.toString())
        }
        var oldValue : Object = this.objectArray(index)
        val numMoved : Int = (this.currentIndex - index) - 1
        if (numMoved > 0) {
            System.arraycopy(this.objectArray, index + 1, this.objectArray, index, numMoved)
        }
        this.objectArray({ this.currentIndex -= 1; this.currentIndex }) = null
        return oldValue
    }

    @JsMethod
    def remove(anyType : Object) : Boolean = {
        if (anyType == null) {

            {
                var index : Int = 0
                while (index < this.currentIndex) {
                    if (this.objectArray(index) == null) {
                        val numMoved : Int = (this.currentIndex - index) - 1
                        if (numMoved > 0) {
                            System.arraycopy(this.objectArray, index + 1, this.objectArray, index, numMoved)
                        }
                        this.objectArray({ this.currentIndex -= 1; this.currentIndex }) = null
                        return true
                    }
                    index += 1
                }
            }
        } else {

            {
                var index : Int = 0
                while (index < this.currentIndex) {
                    //Handle cases like File where the equals does not check for the same object
                    if ((anyType eq this.objectArray(index)) || anyType.equals(this.objectArray(index))) {
                        val numMoved : Int = (this.currentIndex - index) - 1
                        if (numMoved > 0) {
                            System.arraycopy(this.objectArray, index + 1, this.objectArray, index, numMoved)
                        }
                        this.objectArray({ this.currentIndex -= 1; this.currentIndex }) = null
                        return true
                    }
                    index += 1
                }
            }
        }
        return false
    }

    @JsMethod
    def removeAll2(list : BasicArrayList) : Boolean = {
        var result : Boolean = true
        val size : Int = list.size()

        {
            var index : Int = 0
            while (index < size) {
                if (this.remove(list.get(index))) {
                } else {
                    result = false
                }
                index += 1
            }
        }
        return result
    }

    @JsMethod
    def addAll2(list : BasicArrayList) : Boolean = {
        this.ensureCapacity(this.currentIndex + list.currentIndex)
        var listSize : Int = list.currentIndex

        {
            var index : Int = 0
            while (index < listSize) {
                this.objectArray({ val value_N70394 = this.currentIndex; this.currentIndex += 1; value_N70394 }) = list.objectArray(index)
                index += 1
            }
        }
        return true
    }

    @JsMethod
    def addAllList(list : BasicArrayList) : Boolean = {
        val newObjectArray : Array[Object] = list.toArray()
        return this.addAll(newObjectArray)
    }

    @JsMethod
    def addAll(newObjectArray : Array[Object]) : Boolean = {
        val numSize : Int = newObjectArray.length
        this.ensureCapacity(this.currentIndex + numSize)
        System.arraycopy(newObjectArray, 0, this.objectArray, this.currentIndex, numSize)
        this.currentIndex += numSize
        return numSize != 0
    }

    @JsMethod
    def ensureCapacity(minSize : Int) : Unit = {
        val oldCapacity : Int = this.objectArray.length
        if (minSize > oldCapacity) {
            var newCapacity : Int = ((oldCapacity * 3) >> 1) + 1
            if (newCapacity < minSize) {
                newCapacity = minSize
            }
            this.objectArray = this.arrayUtil.copyOf(this.objectArray, newCapacity)
        }
    }

    @JsMethod
    def trimToSize() : Unit = {
        val oldCapacity : Int = this.objectArray.length
        if (this.currentIndex < oldCapacity) {
            this.objectArray = this.arrayUtil.copyOf(this.objectArray, this.currentIndex)
        }
    }

    @JsMethod
    def indexOf(anyType : Object) : Int = {
        if (anyType == null) {

            {
                var i : Int = 0
                while (i < this.currentIndex) {
                    if (this.objectArray(i) == null) {
                        return i
                    }
                    i += 1
                }
            }
        } else {

            {
                var i : Int = 0
                while (i < this.currentIndex) {
                    if (anyType.equals(this.objectArray(i))) {
                        return i
                    }
                    i += 1
                }
            }
        }
        return -1
    }

    @JsMethod
    def lastIndexOf(anyType : Object) : Int = {
        if (anyType == null) {

            {
                var i : Int = this.currentIndex - 1
                while (i >= 0) {
                    if (this.objectArray(i) == null) {
                        return i
                    }
                    i -= 1
                }
            }
        } else {

            {
                var i : Int = this.currentIndex - 1
                while (i >= 0) {
                    if (anyType.equals(this.objectArray(i))) {
                        return i
                    }
                    i -= 1
                }
            }
        }
        return -1
    }

    @JsMethod
    def get(index : Int) : Object = {
        if (index >= this.currentIndex) {
            val stringBuffer : StringMaker = new StringMaker()
            stringBuffer.append(CommonLabels.getInstance().INDEX_LABEL)
            stringBuffer.appendint(index)
            stringBuffer.append(BasicArrayList.SIZE)
            stringBuffer.appendint(this.currentIndex)
            throw new IndexOutOfBoundsException(stringBuffer.toString())
        }
        return this.objectArray(index)
    }

    @JsMethod
    def set(index : Int, element : Object) : Object = {
        if (index >= this.currentIndex) {
            val stringBuffer : StringMaker = new StringMaker()
            stringBuffer.append(CommonLabels.getInstance().INDEX_LABEL)
            stringBuffer.appendint(index)
            stringBuffer.append(BasicArrayList.SIZE)
            stringBuffer.appendint(this.currentIndex)
            throw new IndexOutOfBoundsException(stringBuffer.toString())
        }
        val oldValue : Object = this.objectArray(index)
        this.objectArray(index) = element
        return oldValue
    }

    @JsMethod
    def clear() : Unit = {

        {
            var i : Int = 0
            while (i < this.currentIndex) {
                this.objectArray(i) = null
                i += 1
            }
        }
        this.currentIndex = 0
    }

    @JsMethod
    def size() : Int = {
        return this.currentIndex
    }

    @JsMethod
    def isEmpty() : Boolean = {
        return this.currentIndex == 0
    }

    @JsMethod
    def contains(anyType : Object) : Boolean = {
        return this.indexOf(anyType) >= 0
    }

    @JsMethod
    def toArray() : Array[Object] = {
        return this.arrayUtil.copyOf(this.objectArray, this.currentIndex)
    }

    @JsMethod
    def toArrayType(objectArray : Array[Object]) : Array[Object] = {
        if (objectArray.length < this.currentIndex) {
            return this.arrayUtil.copyOfType(this.objectArray, this.currentIndex, objectArray.getClass())
        }
        System.arraycopy(this.objectArray, 0, objectArray, 0, this.currentIndex)
        if (objectArray.length > this.currentIndex) {
            objectArray(this.currentIndex) = null
        }
        return objectArray
    }

    @JsMethod
    override def clone() : Object = {
        val size : Int = this.size()
        val list : BasicArrayList = new BasicArrayListS(size)
        var anyType : Object = null

        {
            var index : Int = 0
            while (index < size) {
                anyType = this.objectArray(index)
                list.add(anyType)
                index += 1
            }
        }
        return list
    }

    @JsMethod
    override def toString() : String = {
        val COMMA_SEP : String = CommonSeps.getInstance().COMMA_SEP
        val stringBuffer : StringMaker = new StringMaker()

        {
            var index : Int = 0
            while (index < this.currentIndex) {
                stringBuffer.append(this.objectArray(index).toString())
                stringBuffer.append(COMMA_SEP)
                index += 1
            }
        }
        return stringBuffer.toString()
    }

}

object BasicArrayList {
    private val SIZE : String = ", Size: "

}


