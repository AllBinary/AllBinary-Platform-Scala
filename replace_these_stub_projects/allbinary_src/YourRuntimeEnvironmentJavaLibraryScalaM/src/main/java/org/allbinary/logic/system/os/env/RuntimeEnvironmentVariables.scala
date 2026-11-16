/* Generated Code Do Not Modify */
package org.allbinary.logic.system.os.env

import _root_.java.io.BufferedReader
import _root_.java.io.InputStreamReader
import _root_.java.util.Properties
import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.logic.system.os.GenericOperatingSystem
import _root_.org.allbinary.logic.system.os.OperatingSystemFactory
import _root_.org.allbinary.logic.system.os.OperatingSystems
import _root_.org.allbinary.string.CommonStrings

class RuntimeEnvironmentVariables() {

    val logUtil : LogUtil = LogUtil.getInstance()

    val commonStrings : CommonStrings = CommonStrings.getInstance()

    /*    public String getTest() throws Exception    {       return System.getenv("JAVA_HOME");    } */
    def getTest1() : String = {
        return System.getProperty("java.java.home")
    }

    def getVariable(`var` : String) : String = {
        var environmentVariables : Properties = this.get()
        return environmentVariables.getProperty(`var`)
    }

    def get() : Properties = {
        try {
            var process : Process = null
            var environmentVariables : Properties = new Properties()
            var operatingSystemInterface : GenericOperatingSystem = OperatingSystemFactory.getInstance().getOperatingSystemInstance()
            var osName : String = operatingSystemInterface.getName()
            var linuxCommand : String = "env"
            var windowsCommand : String = "cmd.exe /c set"
            var solarisCommand : String = linuxCommand
            var operatingSystems : OperatingSystems = OperatingSystems.getInstance()
            if (osName.compareTo(operatingSystems.LINUX) == 0) {
                process = Runtime.getRuntime().exec(linuxCommand)
            } else if (osName.indexOf(operatingSystems.WINDOWS) >= 0) {
                process = Runtime.getRuntime().exec(windowsCommand)
            } else if (osName.compareTo(operatingSystems.SOLARIS) == 0) {
                process = Runtime.getRuntime().exec(solarisCommand)
            } else {
                throw new Exception()
            }
            var processInputStreamReader : InputStreamReader = new InputStreamReader(process.getInputStream())
            var bufferedReader : BufferedReader = new BufferedReader(processInputStreamReader)
            var keyValuePair : String = null

            {
                while (({ keyValuePair = bufferedReader.readLine(); keyValuePair }) != null) {
                    var index : Int = keyValuePair.indexOf('=')
                    var key : String = keyValuePair.substring(0, index)
                    var value : String = keyValuePair.substring(index + 1)
                    environmentVariables.put(key, value)
                }
            }
            return environmentVariables
        } catch {
            case e : Exception => {
                if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().OSERROR)) {
                    this.logUtil.put(this.commonStrings.EXCEPTION, this, "get()", e)
                }
                return null
            }
        }
        throw new IllegalStateException()
    }

    def getTempDir() : String = {
        try {
            return System.getProperty("java.io.tmpdir")
        } catch {
            case e : Exception => {
                if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().OSERROR)) {
                    this.logUtil.put(this.commonStrings.EXCEPTION, this, "getTempDir()", e)
                }
                return null
            }
        }
        throw new IllegalStateException()
    }

    def getLibraryPath() : String = {
        try {
            return System.getProperty("java.library.path")
        } catch {
            case e : Exception => {
                if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().OSERROR)) {
                    this.logUtil.put(this.commonStrings.EXCEPTION, this, "getLibraryPath()", e)
                }
                return null
            }
        }
        throw new IllegalStateException()
    }

    def getClassPath() : String = {
        try {
            return System.getProperty("java.class.path")
        } catch {
            case e : Exception => {
                if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().OSERROR)) {
                    this.logUtil.put(this.commonStrings.EXCEPTION, this, "getClassPath()", e)
                }
                return null
            }
        }
        throw new IllegalStateException()
    }

    def updateLibraryPath(libPath : String) : Unit = {
        try {
            var existingPath : String = this.getLibraryPath()
            System.setProperty("java.library.path", (libPath + ":") + existingPath)
        } catch {
            case e : Exception => {
                if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().OSERROR)) {
                    this.logUtil.put(this.commonStrings.EXCEPTION, this, "updateLibraryPath()", e)
                }
            }
        }
    }

    def getUserHome() : String = {
        try {
            return System.getProperty("user.home")
        } catch {
            case e : Exception => {
                if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().OSERROR)) {
                    this.logUtil.put(this.commonStrings.EXCEPTION, this, "getUserHome()", e)
                }
                return null
            }
        }
        throw new IllegalStateException()
    }

    def getUserDir() : String = {
        try {
            return System.getProperty("user.dir")
        } catch {
            case e : Exception => {
                if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().OSERROR)) {
                    this.logUtil.put(this.commonStrings.EXCEPTION, this, "getUserDir()", e)
                }
                return null
            }
        }
        throw new IllegalStateException()
    }

    def set() : Unit = {
        try {
        } catch {
            case e : Exception => {
                if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().OSERROR)) {
                    this.logUtil.put(this.commonStrings.EXCEPTION, this, "get()", e)
                }
            }
        }
    }

    def setVariable(`var` : String, `val` : String) : Unit = {
        try {
            var process : Process = null
            var operatingSystemInterface : GenericOperatingSystem = OperatingSystemFactory.getInstance().getOperatingSystemInstance()
            var operatingSystems : OperatingSystems = OperatingSystems.getInstance()
            var osName : String = operatingSystemInterface.getName()
            var windowsCommand : String = (("cmd.exe /c set" + `var`) + "=") + `val`
            if (osName.compareTo(operatingSystems.LINUX) == 0) {
                //runtimeEnvironmentVariablesJni.setVariable(var,val);
                throw new Exception()
            } else if (osName.indexOf(operatingSystems.WINDOWS) >= 0) {
                process = Runtime.getRuntime().exec(windowsCommand)
            } else if (osName.compareTo(operatingSystems.SOLARIS) == 0) {
                //runtimeEnvironmentVariablesJni.setVariable(var,val);            
                throw new Exception()
            } else {
                throw new Exception()
            }
        } catch {
            case e : Exception => {
                if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().OSERROR)) {
                    this.logUtil.put(this.commonStrings.EXCEPTION, this, "setVariable()", e)
                }
            }
        }
    }

}


