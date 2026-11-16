/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.logic.system.os


//NoPlatform
class SystemProperties private() {
    import _root_.org.allbinary.logic.system.os.SystemProperties.{*}

    /*      public String getJavaVersion()      {         throw new RuntimeException();      }            public String getFileSep()      {         throw new RuntimeException();      }            public String getLineSep()      {          throw new RuntimeException();      }            public String getPathSep()      {          throw new RuntimeException();      }            public String getClassVersion()      {          throw new RuntimeException();      }            public String getVendor()      {                   throw new RuntimeException();      }            public String getVendorUrl()      {          throw new RuntimeException();      }      */
    def getName() : String = {
        throw new RuntimeException()
    }

    def getArch() : String = {
        throw new RuntimeException()
    }

    def getVersion() : String = {
        throw new RuntimeException()
    }

    def getUserHomePath() : String = {
        throw new RuntimeException()
    }

}

object SystemProperties {
    private val instance : SystemProperties = new SystemProperties()

    /**      * @return the instance      */
    def getInstance() : SystemProperties = {
        return SystemProperties.instance
    }

}


