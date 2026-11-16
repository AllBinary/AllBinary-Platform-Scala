/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.business.context.modules.storefront

import _root_.org.allbinary.business.context.configuration.ContextConfigurationInterface
import _root_.org.allbinary.data.tables.TableMappingInterface
import _root_.org.allbinary.util.BasicArrayList

trait StoreFrontInterface extends TableMappingInterface {

    def isNameValid() : _root_.java.lang.Boolean

    def isValid() : _root_.java.lang.Boolean

    def nameValidationInfo() : String

    def validationInfo() : String

    def getTestHtmlPath() : String

    def getCurrentHostName() : String

    def getCurrentHostNamePath() : String

    def getCurrentHomeHostName() : String

    def getCurrentHomeHostNamePath() : String

    def getName() : String

    //public String getUserName();
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

    def getContextConfigurationInterface() : ContextConfigurationInterface

    def setContextConfigurationInterface(contextConfigurationInterface : ContextConfigurationInterface) : Unit

    /*    public String getOut();    public String getAge();    public String getSale();    public String getNotification();    public String getOrder();    public String getOrderCancel();     **/
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

    def setName(value : String) : Unit

    def setBasketName(value : String) : Unit

    def setHomeHostName(value : String) : Unit

    def setHomeHostNamePath(value : String) : Unit

    def setHostName(value : String) : Unit

    def setHostNamePath(value : String) : Unit

    def setTestHomeHostName(value : String) : Unit

    def setTestHomeHostNamePath(value : String) : Unit

    def setTestHostName(value : String) : Unit

    def setTestHostNamePath(value : String) : Unit

    def setImagePath(value : String) : Unit

    def setStaticPath(value : String) : Unit

    def setCategoryPath(value : String) : Unit

    def setPackageLocation(value : String) : Unit

    def setInventoryControl(value : String) : Unit

    /*    public void setOut(String value);    public void setAge(String value);    public void setSale(String value);    public void setNotification(String value);    public void setOrder(String value);    public void setOrderCancel(String value);     */
    def setFtp(value : String) : Unit

    def setFtpPath(value : String) : Unit

    def setFtpUserName(value : String) : Unit

    def setFtpPassword(value : String) : Unit

    def setTestFtp(value : String) : Unit

    def setTestFtpPath(value : String) : Unit

    def setTestFtpUserName(value : String) : Unit

    def setTestFtpPassword(value : String) : Unit

    def setTimeCreated(value : String) : Unit

    def setLastModified(value : String) : Unit

    def install(current : Int, total : Int) : Unit

}


