/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.logic.system.loader

import _root_.java.io.FileInputStream
import _root_.java.io.IOException
import _root_.java.util.Map
import _root_.org.allbinary.logic.StdUtil
import _root_.org.allbinary.logic.communication.log.LogBuffer
import _root_.org.allbinary.logic.communication.log.LogFactory
import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.logic.io.StreamUtil
import _root_.org.allbinary.logic.io.path.AbPathData
import _root_.org.allbinary.logic.string.StringUtil
import _root_.org.allbinary.logic.system.security.AbCryptUtil

class AbeClassLoader(param_parent : ClassLoader, param_key : String) extends ClassLoader(param_parent) {
    import _root_.org.allbinary.logic.system.loader.AbeClassLoader.{*}

    //extends WebappClassLoader
    val logUtil : LogUtil = LogUtil.getInstance()

    private val abCryptUtil : AbCryptUtil = AbCryptUtil.getInstance()

    private val LOAD_CLASS : String = "loadClass"

    private val ENCRYPTED_EXTENSION : String = AbPathData.getInstance().EXTENSION_SEP + "abc"

    private var key : String = null

    //private ClassLoader parent;
    //Constructor
    {
        val parent : ClassLoader = param_parent
        val key : String = param_key
        this.key = key
        //super();
        AbeClassLoader.PATH = String.valueOf(_root_.org.allbinary.globals.URLGLOBALS.getWebappPath()) + "WEB-INF/classes/"
    }

    /*    public AbeClassLoader(String key)    {       super(null);            //super();       this.key = key;            AbeClassLoader.PATH = allbinary.globals.URLGLOBALS.getWebappPath() + "WEB-INF/classes/";            if(org.allbinary.logic.communication.log.config.type.LogConfigTypes.LOGGING.contains(org.allbinary.logic.communication.log.config.type.LogConfigTypeFactory.getInstance().LOADER))       {          this.logUtil.putF("Path: " + AbeClassLoader.PATH, this,"AbeClassLoader(key)");       }    }     */
    def findLoadedClass1(name : String) : Class[?] = {
        return AbeClassLoader.classes.get(name).asInstanceOf[Class[?]]
    }

    override def loadClass(name : String) : Class[?] = this.synchronized {
        return this.loadClass(name, false)
    }

    /*     public synchronized void loadClassesFromJar(JarFile jarFile)          throws Exception     {         return jarClass;     }          public synchronized Class loadClass(InputStream inputStream,         String className, boolean resolve) throws Exception     {         byte[] data = this.getByteArrayOutputStream(inputStream).toByteArray();                  Class jarClass = defineClass(className, data, 0, data.length);                  //if (resolve)         resolveClass(jarClass);                  return jarClass;     }     */
    override def loadClass(name : String, resolve : Boolean) : Class[?] = this.synchronized {
        var loadedWith : String = "findLoadedClass1"
        var logBuffer : LogBuffer = new LogBuffer()
        try {
            //Step 1 = Check to see if encrypted class is already loaded
            var myClass : Class[?] = this.findLoadedClass1(name).asInstanceOf[Class[?]]
            if (myClass == null) {
                //Step 3 = Try to load class with normal classloader
                try {
                    loadedWith = "super.loadClass"
                    var normalClass : Class[?] = super.loadClass(name, resolve).asInstanceOf[Class[?]]
                    /*                if(org.allbinary.logic.communication.log.config.type.LogConfigTypes.LOGGING.contains(org.allbinary.logic.communication.log.config.type.LogConfigTypeFactory.getInstance().LOADER))                {                   this.logUtil.putF("Loaded Class: " + name + " with: " + loadedWith , this, this.LOAD_CLASS);                }                 */
                    if (normalClass != null) {
                        return normalClass
                    }
                } catch {
                    case e : ClassNotFoundException => {
                        logBuffer.add(LogFactory.getInstance((("Failed to Load Class: " + name) + "\nwith: ") + loadedWith, this, this.LOAD_CLASS, e))
                    }
                    case e : Exception => {
                        logBuffer.add(LogFactory.getInstance((("Failed to Load Class: " + name) + "\nwith: ") + loadedWith, this, this.LOAD_CLASS, e))
                    }
                    case e : NoClassDefFoundError => {
                        logBuffer.add(LogFactory.getInstanceF((("NoClassDefFoundError Failed Loaded Class: " + name) + "\nwith: ") + loadedWith, this, this.LOAD_CLASS))
                    }
                }
                //Step 4 = Try to load an encrypted class
                var classBytes : Array[Byte] = this.loadClassBytesFromFile(name)
                if (classBytes == null) {
                    throw new ClassNotFoundException((("My Bytes not loaded for: " + name) + "\nwith: ") + "loadClassBytes")
                }
                myClass = defineClass(name, classBytes, 0, classBytes.length).asInstanceOf[Class[?]]
                if (myClass == null) {
                    throw new ClassNotFoundException((("My Class Not Defineable for: " + name) + "\nwith: ") + "loadClassBytes")
                }
                AbeClassLoader.classes.put(name, myClass)
            } else {
                logBuffer.add(LogFactory.getInstanceF((("Already Loaded: " + name) + "\nwith: ") + loadedWith, this, this.LOAD_CLASS))
            }
            //if (resolve)
            resolveClass(myClass)
            return myClass
        } catch {
            case e : Exception => {
                if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().LOADERERROR)) {
                    logBuffer.logAll()
                    this.logUtil.put((("Failure loading: " + name) + "\nwith: ") + loadedWith, this, this.LOAD_CLASS, e)
                }
                return null
            }
        }
        throw new IllegalStateException()
    }

    private def loadClassBytesFromFile(name : String) : Array[Byte] = {
        var in : FileInputStream = null
        var cname : String = StringUtil.getInstance().EMPTY_STRING
        try {
            cname = (AbeClassLoader.PATH + name.replace('.', AbPathData.getInstance().SEPARATORCHAR)) + this.ENCRYPTED_EXTENSION
            /*          if(org.allbinary.logic.communication.log.config.type.LogConfigTypes.LOGGING.contains(org.allbinary.logic.communication.log.config.type.LogConfigTypeFactory.getInstance().LOADER))          {             this.logUtil.putF("Crypted Class name: " + name + " path: " + cname , this, "loadClassBytes");          }           */
            in = new FileInputStream(cname)
            val decrypted : Array[Byte] = this.abCryptUtil.decrypt(in, this.key)
            /*          if(org.allbinary.logic.communication.log.config.type.LogConfigTypes.LOGGING.contains(org.allbinary.logic.communication.log.config.type.LogConfigTypeFactory.getInstance().LOADER))          {             this.logUtil.putF("Decrypted with: " + this.key, this, "loadClassBytes");          }           */
            return decrypted
        } catch {
            case e : IOException => {
                if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().LOADERERROR)) {
                    this.logUtil.put((("(Before LogBuffer Output) Failure loading Encrypted: " + name) + " File: ") + cname, "AbeClassLoader", "loadClassBytes", e)
                }
                StreamUtil.getInstance().close(in)
            }
            case e : Exception => {
                val loadedWith : String = "loadClassBytes"
                if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().LOADERERROR)) {
                    this.logUtil.put((((("(Before LogBuffer Output) Failed to Loaded Class: " + name) + " File: ") + cname) + "\nwith: ") + loadedWith, this, "loadClassBytes", e)
                }
            }
            case e : NoClassDefFoundError => {
                val loadedWith : String = "loadClassBytes"
                if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().LOADERERROR)) {
                    this.logUtil.putF((((("(Before LogBuffer Output) NoClassDefFoundError Failed Loaded Class: " + name) + " File: ") + cname) + "\nwith: ") + loadedWith, this, "loadClassBytes")
                }
            }
        }
        return null
    }

    /*    private byte[] loadClassBytesNotCrypted(String name)    {       FileInputStream in = null;       try       {          String cname = AbeClassLoader.PATH + name.replace('.', AbPathData.getInstance().SEPARATORCHAR) + ".class";          in = new FileInputStream(cname);                  ByteArrayOutputStream buffer = new ByteArrayOutputStream();           outputStream = (ByteArrayOutputStream)               StreamUtil.get(inputStream, outputStream);                      return buffer.toByteArray();       }       catch (IOException e)       {          return null;       }       finally       {       StreamUtil.getInstance().close(in);       }    }     */
    def oldLoadClass(name : String, resolve : Boolean) : Class[?] = this.synchronized {
        var loadedWith : String = "findLoadedClass1"
        try {
            //Step 1 = Check to see if encrypted class is already loaded
            var myClass : Class[?] = this.findLoadedClass1(name).asInstanceOf[Class[?]]
            if (myClass == null) {
                //Step 3 = Try to load class with normal classloader
                try {
                    loadedWith = "super.loadClass"
                    var normalClass : Class[?] = super.loadClass(name, resolve).asInstanceOf[Class[?]]
                    /*                if(org.allbinary.logic.communication.log.config.type.LogConfigTypes.LOGGING.contains(org.allbinary.logic.communication.log.config.type.LogConfigTypeFactory.getInstance().LOADER))                {                   this.logUtil.putF("Loaded Class: " + name + " with: " + loadedWith , this, this.LOAD_CLASS);                }                 */
                    if (normalClass != null) {
                        return normalClass
                    }
                } catch {
                    case e : ClassNotFoundException => {
                        if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().LOADER)) {
                            this.logUtil.putF((("Failed Loaded Class: " + name) + " with: ") + loadedWith, this, this.LOAD_CLASS)
                        }
                    }
                    case e : Exception => {
                        if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().LOADER)) {
                            this.logUtil.putF((("Failed Loaded Class: " + name) + " with: ") + loadedWith, this, this.LOAD_CLASS)
                        }
                    }
                    case e : NoClassDefFoundError => {
                        if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().LOADER)) {
                            this.logUtil.putF((("Failed Loaded Class: " + name) + " with: ") + loadedWith, this, this.LOAD_CLASS)
                        }
                    }
                }
                //Step 4 = Try to load an encrypted class
                loadedWith = "loadClassBytes"
                var classBytes : Array[Byte] = this.loadClassBytesFromFile(name)
                /*             if (classBytes == null)             {                //Step 4 = Try to load an nonencrypted class - This should really occur at step 2                loadedWith = "loadClassBytesNotCrypted";                classBytes = this.loadClassBytesNotCrypted(name);             }              */
                if (classBytes == null) {
                    throw new ClassNotFoundException("Bytes not loaded for: " + name)
                }
                myClass = defineClass(name, classBytes, 0, classBytes.length).asInstanceOf[Class[?]]
                /*             if (myClass == null)             {                loadedWith = "super.loadClass";                              Class normalClass = super.loadClass(name,resolve);                              if(org.allbinary.logic.communication.log.config.type.LogConfigTypes.LOGGING.contains(org.allbinary.logic.communication.log.config.type.LogConfigTypeFactory.getInstance().LOADER))                {                   this.logUtil.putF("Loaded Class: " + name + " with: " + loadedWith , this,this.LOAD_CLASS);                }                              return normalClass;             }              */
                if (myClass == null) {
                    throw new ClassNotFoundException("Class Not Defineable for: " + name)
                }
                AbeClassLoader.classes.put(name, myClass)
            } else {
                if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().LOADER)) {
                    this.logUtil.putF((("Already Loaded: " + name) + " with: ") + loadedWith, this, this.LOAD_CLASS)
                }
            }
            //if (resolve)
            resolveClass(myClass)
            return myClass
        } catch {
            case e : Exception => {
                if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().LOADERERROR)) {
                    this.logUtil.put("Failure loading: " + name, "AbeClassLoader", this.LOAD_CLASS, e)
                }
                return null
            }
        }
        throw new IllegalStateException()
    }

}

object AbeClassLoader {
    private var classes : Map[Object, Object] = StdUtil.getInstance().createHashMap().asInstanceOf[Map[Object, Object]]

    private var PATH : String = null

}


