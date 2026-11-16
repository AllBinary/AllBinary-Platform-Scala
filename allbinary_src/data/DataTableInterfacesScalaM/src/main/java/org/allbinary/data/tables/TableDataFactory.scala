/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.data.tables

import _root_.org.allbinary.string.CommonPhoneStrings

/**  *  * @author user  */
class TableDataFactory {
    import _root_.org.allbinary.data.tables.TableDataFactory.{*}

    val INTEGER_MAX_VALUE_STRING : String = Integer.toString(Integer.MAX_VALUE)

    val ZERO_STRING : String = CommonPhoneStrings.getInstance().ZERO

}

object TableDataFactory {
    private val instance : TableDataFactory = new TableDataFactory()

    /**      * @return the instance      */
    def getInstance() : TableDataFactory = {
        return TableDataFactory.instance
    }

}


