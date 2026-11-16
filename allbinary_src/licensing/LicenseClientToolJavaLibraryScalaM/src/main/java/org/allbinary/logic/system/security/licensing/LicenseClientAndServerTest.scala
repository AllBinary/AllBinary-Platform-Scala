/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.logic.system.security.licensing

import _root_.java.io.File
import _root_.java.io.FileReader
import _root_.java.io.LineNumberReader
import _root_.org.allbinary.logic.string.StringMaker
import _root_.org.allbinary.business.init.LicenseInitInfo
import _root_.org.allbinary.business.init.LicenseInitInfoUtil
import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.logic.system.security.licensing.client.XmlRpcAbeLicenseRetrievalClient
import _root_.org.allbinary.globals.PATH_GLOBALS
import _root_.org.allbinary.util.BasicArrayList
import _root_.org.allbinary.string.CommonStrings

class LicenseClientAndServerTest(param_options : Array[String]) {
    import _root_.org.allbinary.logic.system.security.licensing.LicenseClientAndServerTest.{*}

    val logUtil : LogUtil = LogUtil.getInstance()

    private var vector : BasicArrayList = new BasicArrayListD()

    //Constructor
    {
        val options : Array[String] = param_options
        //Globals.init(this.getClass().getClassLoader(), "G:\\mnt\\bc\\mydev\\licenseserver\\testing\\" + PATH_GLOBALS.getInstance().INIT_PATH);
        LicenseInitInfoUtil.getInstance().setFilePath(PrintLicenseInitInfo.PATH + PATH_GLOBALS.getInstance().INIT_PATH)

        {
            var index : Int = 1
            while (index < options.length) {
                this.vector.add(options(index))
                index += 1
            }
        }
        if (options.length < 2) {
            var file : File = new File(PrintLicenseInitInfo.PATH + "testlicenseservers.txt")
            var reader : FileReader = new FileReader(file)
            var lineNumberReader : LineNumberReader = new LineNumberReader(reader)
            //ready instead of a null readLine so languages without null strings stop at the end of the file and not at an empty line

            {
                while (lineNumberReader.ready()) {
                    this.vector.add(lineNumberReader.readLine())
                }
            }
        }
    }

    def test() : Unit = this.synchronized {
        var stringBuffer : StringMaker = new StringMaker()
        try {
            var list : BasicArrayList = new BasicArrayListD()
            val TESTING : String = "Testing with new licence:<br/>"
            val PROCESSING : String = "Processing: <br/>"
            val END : String = "<br/>End<br/>"
            val RESULT : String = "Test Result: "
            val size : Int = this.vector.size()

            {
                var index : Int = 0
                while (index < size) {
                    stringBuffer.append(TESTING)
                    var serverName : String = this.vector.get(index).asInstanceOf[String]
                    try {
                        var licenseInitInfo : LicenseInitInfo = new LicenseInitInfo()
                        licenseInitInfo.addServer(serverName)
                        LicenseInitInfoUtil.getInstance().write(licenseInitInfo)
                        var abeClientInformation : AbeClientInformationInterface = AbeClientInformationInterfaceFactory.getInstance()
                        var xmlRpcAbeLicenseClient : XmlRpcAbeLicenseRetrievalClient = new XmlRpcAbeLicenseRetrievalClient(abeClientInformation)
                        var abeLicenseInterface : AbeLicenseInterface = xmlRpcAbeLicenseClient.get(null).asInstanceOf[AbeLicenseInterface]
                        //Save license id and server list to file
                        if (abeLicenseInterface != null) {
                            stringBuffer.append(PROCESSING)
                            stringBuffer.append(abeLicenseInterface.toString())
                        }
                        stringBuffer.append(END)
                        this.logUtil.putF(RESULT + stringBuffer.toString(), this, "test")
                        stringBuffer.delete(0, stringBuffer.length())
                    } catch {
                        case e : Exception => {
                            list.add(serverName)
                            this.logUtil.put("Test Error: " + stringBuffer.toString(), this, "test", e)
                        }
                    }
                    index += 1
                }
            }
            this.logUtil.putF((("Total Servers Failed: " + list.size()) + " Failed Servers: ") + list.toString(), this, "test")
        } catch {
            case e : Exception => {
                this.logUtil.put("Test Error: " + stringBuffer.toString(), this, "test", e)
            }
        }
    }

}

object LicenseClientAndServerTest {
    /*     public void test()     {     try     {     AbeLicenseClient licenseClient = new AbeLicenseClient();     String licenseInfo = licenseClient.test();     System.out.println(licenseInfo);     } catch (Exception e)     {     this.logUtil.put(this.commonStrings.EXCEPTION, this, "test()", e);     }     }      */
    def main(args : Array[String]) : Unit = {
        try {
            var licensingTest : LicenseClientAndServerTest = new LicenseClientAndServerTest(args)
            licensingTest.test()
        } catch {
            case e : Exception => {
                val logUtil : LogUtil = LogUtil.getInstance()
                logUtil.put(CommonStrings.getInstance().EXCEPTION, "main()", "main()", e)
            }
        }
    }

}


