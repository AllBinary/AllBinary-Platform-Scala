/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.data.generator

import _root_.org.allbinary.globals.PATH_GLOBALS
import _root_.org.allbinary.globals.URLGLOBALS
import _root_.org.allbinary.logic.string.StringMaker

class OrderIdGenerator() extends UniqueIdGenerator {

    private val IDFILE : String = "orderId"

    //Constructor
    {
        var stringBuffer : StringMaker = new StringMaker()
        stringBuffer.append(URLGLOBALS.getMainPath())
        stringBuffer.append(PATH_GLOBALS.getInstance().INIT_PATH)
        stringBuffer.append(this.IDFILE)
        stringBuffer.append(UniqueIdGenerator.EXT)
        super.setFile(stringBuffer.toString(), this.IDFILE)
    }

}


