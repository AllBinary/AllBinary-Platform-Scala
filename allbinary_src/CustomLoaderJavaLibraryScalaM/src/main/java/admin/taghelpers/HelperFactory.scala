/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package admin.taghelpers

import _root_.java.util.HashMap
import _root_.javax.servlet.http.HttpServletRequest
import _root_.javax.servlet.jsp.PageContext
import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.logic.system.loader.AbeFactory
import _root_.org.allbinary.logic.system.security.licensing.AbeClientInformationInterface
import _root_.org.allbinary.logic.system.security.licensing.LicensingException
import _root_.org.allbinary.string.CommonStrings

class HelperFactory() {
    import _root_.admin.taghelpers.HelperFactory.{*}

    val logUtil : LogUtil = LogUtil.getInstance()

}

object HelperFactory {
    def getInstance(abeClientInformation : AbeClientInformationInterface, factoryName : String, className : String, hashMap : HashMap[Object, Object], httpServletRequest : HttpServletRequest) : Object = {
        val logUtil : LogUtil = LogUtil.getInstance()
        try {
            var params : Array[Object] = new Array[Object](2)
            var classes : Array[Class[?]] = new Array[Class[?]](2)
            val abeFactory : AbeFactory = AbeFactory.getInstance()
            //Add param types
            classes(0) = hashMap.getClass()
            classes(1) = abeFactory.getClass(abeClientInformation, "javax.servlet.http.HttpServletRequest")
            //Add arguments
            params(0) = hashMap.asInstanceOf[Object]
            params(1) = httpServletRequest.asInstanceOf[Object]
            var anyType : Object = abeFactory.getInstance(abeClientInformation, className, classes, params)
            return anyType
        } catch {
            case e : LicensingException => {
                var error : String = (("Failed To Get Instance Args: HashMap=" + hashMap.toString()) + " HttpServletRequest=") + httpServletRequest
                if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().TAGHELPERFACTORYERROR)) {
                    logUtil.put(error, factoryName + "->HelperFactory", "getInstance(String, String, HashMap, PageContext)", e)
                }
                throw e
            }
            case e : Exception => {
                var error : String = "Failed To Get Instance"
                if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().TAGHELPERFACTORYERROR)) {
                    logUtil.put(error, factoryName + "->HelperFactory", "getInstance(String, String, HashMap, PageContext)", e)
                }
                return null
            }
        }
        throw new IllegalStateException()
    }

    def getInstance(abeClientInformation : AbeClientInformationInterface, factoryName : String, className : String, hashMap : HashMap[Object, Object], pageContext : PageContext) : Object = {
        val logUtil : LogUtil = LogUtil.getInstance()
        try {
            var params : Array[Object] = new Array[Object](2)
            var classes : Array[Class[?]] = new Array[Class[?]](2)
            val abeFactory : AbeFactory = AbeFactory.getInstance()
            //Add param types
            classes(0) = hashMap.getClass()
            classes(1) = abeFactory.getClass(abeClientInformation, "javax.servlet.jsp.PageContext")
            //Add arguments
            params(0) = hashMap.asInstanceOf[Object]
            params(1) = pageContext.asInstanceOf[Object]
            var anyType : Object = abeFactory.getInstance(abeClientInformation, className, classes, params)
            return anyType
        } catch {
            case e : LicensingException => {
                if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().TAGHELPERFACTORYERROR)) {
                    var error : String = (("Failed To Get Instance Args: HashMap=" + hashMap.toString()) + " PageContext=") + pageContext
                    logUtil.put(error, factoryName + "->HelperFactory", "getInstance(String, String, HashMap, PageContext)", e)
                }
                throw e
            }
            case e : Exception => {
                if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().TAGHELPERFACTORYERROR)) {
                    val commonStrings : CommonStrings = CommonStrings.getInstance()
                    logUtil.put(commonStrings.EXCEPTION, factoryName + "->HelperFactory", "getInstance(String, String, HashMap, PageContext)", e)
                }
                return null
            }
        }
        throw new IllegalStateException()
    }

    def getInstance(abeClientInformation : AbeClientInformationInterface, factoryName : String, className : String, hashMap : HashMap[Object, Object], specialhashMap : HashMap[Object, Object], pageContext : PageContext) : Object = {
        val logUtil : LogUtil = LogUtil.getInstance()
        try {
            var params : Array[Object] = new Array[Object](3)
            var classes : Array[Class[?]] = new Array[Class[?]](3)
            val abeFactory : AbeFactory = AbeFactory.getInstance()
            //Add param types
            classes(0) = hashMap.getClass()
            classes(1) = specialhashMap.getClass()
            classes(2) = abeFactory.getClass(abeClientInformation, "javax.servlet.jsp.PageContext")
            //Add arguments
            params(0) = hashMap.asInstanceOf[Object]
            params(1) = specialhashMap.asInstanceOf[Object]
            params(2) = pageContext.asInstanceOf[Object]
            var anyType : Object = abeFactory.getInstance(abeClientInformation, className, classes, params)
            return anyType
        } catch {
            case e : LicensingException => {
                if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().TAGHELPERFACTORYERROR)) {
                    var error : String = (("Failed To Get Instance Args: HashMap=" + hashMap.toString()) + " PageContext=") + pageContext
                    logUtil.put(error, factoryName + "->HelperFactory", "getInstance(String, String, HashMap, PageContext)", e)
                }
                throw e
            }
            case e : Exception => {
                if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().TAGHELPERFACTORYERROR)) {
                    val commonStrings : CommonStrings = CommonStrings.getInstance()
                    logUtil.put(commonStrings.EXCEPTION, factoryName + "->HelperFactory", "getInstance(String, String, HashMap, PageContext)", e)
                }
                return null
            }
        }
        throw new IllegalStateException()
    }

    def getInstance(abeClientInformation : AbeClientInformationInterface, factoryName : String, className : String) : Object = {
        val logUtil : LogUtil = LogUtil.getInstance()
        try {
            var anyType : Object = AbeFactory.getInstance().getInstance(abeClientInformation, className)
            return anyType
        } catch {
            case e : LicensingException => {
                if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().TAGHELPERFACTORYERROR)) {
                    val commonStrings : CommonStrings = CommonStrings.getInstance()
                    logUtil.put(commonStrings.EXCEPTION, factoryName + "->HelperFactory", "getInstance(String, String, HashMap, PageContext)", e)
                }
                throw e
            }
            case e : Exception => {
                if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().TAGHELPERFACTORYERROR)) {
                    val commonStrings : CommonStrings = CommonStrings.getInstance()
                    logUtil.put(commonStrings.EXCEPTION, factoryName + "->HelperFactory", "getInstance(String, String, HashMap, PageContext)", e)
                }
                return null
            }
        }
        throw new IllegalStateException()
    }

}


