/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.business.context.modules.storefronts

import _root_.org.allbinary.util.BasicArrayList

trait BasicStoreFrontInterface {

    def getTestHtmlPath() : String

    def getCurrentHostName() : String

    def getCurrentHostNamePath() : String

    def getCurrentHomeHostName() : String

    def getCurrentHomeHostNamePath() : String

    def getName() : String

    def getUserName() : String

    def getBasketName() : String

    def getHomeHostName() : String

    def getHomeHostNamePath() : String

    def getHostName() : String

    def getHostNamePath() : String

    def getTestHomeHostName() : String

    def getTestHomeHostNamePath() : String

    def getTestHostName() : String

    def getTestHostNamePath() : String

    //public String getImagePath();
    def getStaticPath() : String

    def getCategoryPath() : String

    def getSubStores() : BasicArrayList

    def getTagLocation() : String

    def getPackageLocation() : String

    def getInventoryControl() : String

    def getFtp() : String

    def getFtpPath() : String

    def getFtpUserName() : String

    def getFtpPassword() : String

    def getTestFtp() : String

    def getTestFtpPath() : String

    def getTestFtpUserName() : String

    def getTestFtpPassword() : String

    def getTimeCreated() : String

    def getLastModified() : String

}


