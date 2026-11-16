/* Generated Code Do Not Modify */
package org.platform

import _root_.java.io.InputStream

/**  *  * @author User  */
class OpenGLResources {
    import _root_.org.platform.OpenGLResources.{*}

    def init() : Unit = {
    }

    def isExcluded(name : String) : Boolean = {
        throw new RuntimeException()
    }

    def getIdentifier(name : String, defType : String, defPackage : String) : Int = {
        throw new RuntimeException()
    }

    def openRawResource(id : Int) : InputStream = {
        throw new RuntimeException()
    }

    def openRawResourceFromName(resourceName : String) : InputStream = {
        throw new RuntimeException()
    }

    def getResourceAsStream(resourceName : String) : InputStream = {
        throw new RuntimeException()
    }

    def getPackageName() : String = {
        throw new RuntimeException()
    }

}

object OpenGLResources {
    private val instance : OpenGLResources = new OpenGLResources()

    /**      * @return the instance      */
    def getInstance() : OpenGLResources = {
        return OpenGLResources.instance
    }

}


