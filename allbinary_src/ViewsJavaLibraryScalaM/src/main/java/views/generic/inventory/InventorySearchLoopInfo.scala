/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package views.generic.inventory

import _root_.org.allbinary.logic.string.StringMaker

/**  *  * @author user  */
class InventorySearchLoopInfo {

    var lastPage : Int = -1

    var currentPage : Int = -1

    var numberOfResultsOnCurrentPage : Int = 0

    var numberOfResults : Int = 0

    private val CURRENT : String = "current: "

    private val NUM : String = " num: "

    private val LAST : String = " last: "

    override def toString() : String = {
        var stringBuffer : StringMaker = new StringMaker()
        stringBuffer.append(this.CURRENT)
        stringBuffer.appendint(this.currentPage)
        stringBuffer.append(this.NUM)
        stringBuffer.appendint(this.numberOfResults)
        stringBuffer.append(this.LAST)
        stringBuffer.appendint(this.lastPage)
        return stringBuffer.toString()
    }

}


