/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.business.init

import _root_.org.allbinary.logic.io.path.AbPath

trait InitInfoInterface {

    def isTesting() : Boolean

    def getTesting() : String

    def getTestHtmlPath() : String

    def getMainPath() : String

    def setTesting(value : String) : Unit

    def setTestHtmlPath(value : AbPath) : Unit

    def setMainPath(value : AbPath) : Unit

    def isTestingValid(testing : String) : Boolean

    def isTestHtmlPathValid(value : AbPath) : Boolean

    def isMainPathValid(value : AbPath) : Boolean

}


