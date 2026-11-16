/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.logic.communication.log

import _root_.org.allbinary.globals.Globals
import _root_.org.allbinary.string.CommonStrings

/**  *  * @author user  */
class TestRemoteLogUtil() {
    import _root_.org.allbinary.logic.communication.log.TestRemoteLogUtil.{PATH as _, *}
    def PATH : String = _root_.org.allbinary.logic.communication.log.TestRemoteLogUtil.PATH

    //Constructor
    {
        Globals.getInstance().init(this.getClass().getClassLoader(), TestRemoteLogUtil.PATH)
        val logUtil : LogUtil = LogUtil.getInstance()
        val commonStrings : CommonStrings = CommonStrings.getInstance()
        logUtil.put(commonStrings.EXCEPTION, "Test", "TestClass", new Exception("Pretend Exception"))
    }

}

object TestRemoteLogUtil {
    //protected final LogUtil logUtil = LogUtil.getInstance();
    val PATH : String = "G:\\mnt\\bc\\mydev\\work\\allbinary_src\\licensing\\data\\"

    /**      * @param args the command line arguments      */
    def main(args : Array[String]) : Unit = {
        // TODO code application logic here
        new TestRemoteLogUtil()
    }

}


