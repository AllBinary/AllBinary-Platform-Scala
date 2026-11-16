/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.logic.system.loader

import _root_.java.lang.reflect.Constructor
import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.logic.java.anyType.ConstructorUtil
import _root_.org.allbinary.logic.string.StringMaker
import _root_.org.allbinary.logic.system.security.AbKeys
import _root_.org.allbinary.logic.system.security.licensing.AbeClientInformationInterface
import _root_.org.allbinary.logic.system.security.licensing.LicensingException
import _root_.org.allbinary.string.CommonSeps

class AbeFactory private() {
    import _root_.org.allbinary.logic.system.loader.AbeFactory.{*}

    val logUtil : LogUtil = LogUtil.getInstance()

    private var useCustomLoader : Boolean = false

    def getInstance(abeClientInformation : AbeClientInformationInterface, className : String) : Object = this.synchronized {
        try {
            /*          AbKeysInterface abKeysInterface =              AbeFactory.getInstance().getNoLicenseInstance(SECURITYKEYSCLASSPATH);          String key = abKeysInterface.getKey(className);          */
            return this.getClass(abeClientInformation, className).newInstance()
        } catch {
            case e : LicensingException => {
                if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().LOADERERROR)) {
                    this.logUtil.put("Failure for: " + className, this, "getInstance(classname)", e)
                }
                throw e
            }
            case e : Exception => {
                if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().LOADERERROR)) {
                    this.logUtil.put("Failure for: " + className, this, "getInstance(classname)", e)
                }
                return null
            }
        }
        throw new IllegalStateException()
    }

    def getInstance(abeClientInformation : AbeClientInformationInterface, className : String, classes : Array[Class[?]], params : Array[Object]) : Object = this.synchronized {
        var constructor : Constructor[?] = null
        try {
            /*          AbKeysInterface abKeysInterface =              AbeFactory.getInstance().getNoLicenseInstance(SECURITYKEYSCLASSPATH);          String key = abKeysInterface.getKey(className);          */
            var parent : ClassLoader = WebappClassLoaderInfo.getLoader()
            //ClassLoader parent = new Object().getClass().getClassLoader();
            if (this.useCustomLoader) {
                var loader : ClassLoader = new AbeClassLoader(parent, AbKeys.getInstance().getKey(abeClientInformation, className))
                var myClass : Class[?] = loader.loadClass(className).asInstanceOf[Class[?]]
                constructor = myClass.getConstructor(classes*).asInstanceOf[Constructor[?]]
                return constructor.newInstance(params*)
            } else {
                var myClass : Class[?] = parent.loadClass(className).asInstanceOf[Class[?]]
                constructor = myClass.getConstructor(classes*).asInstanceOf[Constructor[?]]
                return constructor.newInstance(params*)
            }
        } catch {
            case e : LicensingException => {
                if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().LOADERERROR)) {
                    var stringBuffer : StringMaker = new StringMaker()
                    stringBuffer.append("Failure for: ")
                    stringBuffer.append(className)
                    stringBuffer.append(CommonSeps.getInstance().SPACE)
                    stringBuffer.append(ConstructorUtil.view(constructor, CommonSeps.getInstance().NEW_LINE))
                    this.logUtil.put(stringBuffer.toString(), this, "getInstance(className,params)", e)
                }
                throw e
            }
            case e : Exception => {
                if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().LOADERERROR)) {
                    var stringBuffer : StringMaker = new StringMaker()
                    stringBuffer.append("Failure for: ")
                    stringBuffer.append(className)
                    stringBuffer.append(CommonSeps.getInstance().SPACE)
                    stringBuffer.append(ConstructorUtil.view(constructor, CommonSeps.getInstance().NEW_LINE))
                    this.logUtil.put(stringBuffer.toString(), this, "getInstance(className,params)", e)
                }
                return null
            }
        }
        throw new IllegalStateException()
    }

    /*    public synchronized static Class loadClassesFromJar(JarFile jarFile)        throws LicensingException    {       try       {          ClassLoader parent = WebappClassLoaderInfo.getLoader();          //ClassLoader parent = new Object().getClass().getClassLoader();                    if(useCustomLoader)          {             AbeClassLoader abeClassLoader =                 new AbeClassLoader(parent, AbKeys.getKey(className));             Class c = loaderloadClass(className);             return c;          }          else          {             Class c = parent.loadClass(className);             return c;          }       }       catch (LicensingException e)       {          if(org.allbinary.logic.communication.log.config.type.LogConfigTypes.LOGGING.contains(org.allbinary.logic.communication.log.config.type.LogConfigTypeFactory.getInstance().LOADERERROR))          {             this.logUtil.put("Failure for: " + className, this,"getClass(className)", e);          }          throw e;       }       catch (Exception e)       {          if(org.allbinary.logic.communication.log.config.type.LogConfigTypes.LOGGING.contains(org.allbinary.logic.communication.log.config.type.LogConfigTypeFactory.getInstance().LOADERERROR))          {             this.logUtil.put("Failure for: " + className, this,"getClass(className)", e);          }          return null;       }    }      */
    def getClass(abeClientInformation : AbeClientInformationInterface, className : String) : Class[?] = this.synchronized {
        try {
            var parent : ClassLoader = WebappClassLoaderInfo.getLoader()
            //ClassLoader parent = new Object().getClass().getClassLoader();
            if (this.useCustomLoader) {
                var loader : ClassLoader = new AbeClassLoader(parent, AbKeys.getInstance().getKey(abeClientInformation, className))
                var c : Class[?] = loader.loadClass(className).asInstanceOf[Class[?]]
                return c
            } else {
                var c : Class[?] = parent.loadClass(className).asInstanceOf[Class[?]]
                return c
            }
        } catch {
            case e : LicensingException => {
                if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().LOADERERROR)) {
                    this.logUtil.put("Failure for: " + className, this, "getClass(className)", e)
                }
                throw e
            }
            case e : Exception => {
                if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().LOADERERROR)) {
                    this.logUtil.put("Failure for: " + className, this, "getClass(className)", e)
                }
                return null
            }
        }
        throw new IllegalStateException()
    }

}

object AbeFactory {
    private val instance : AbeFactory = new AbeFactory()

    def getInstance() : AbeFactory = {
        return AbeFactory.instance
    }

}


