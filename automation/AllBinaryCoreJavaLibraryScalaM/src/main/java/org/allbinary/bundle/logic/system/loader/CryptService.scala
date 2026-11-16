/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.bundle.logic.system.loader

import _root_.java.io.ByteArrayInputStream
import _root_.java.io.InputStream
import _root_.org.allbinary.globals.Globals
import _root_.org.allbinary.globals.URLGLOBALS
import _root_.org.allbinary.gui.dialog.BasicTextJDialog
import _root_.org.allbinary.gui.dialog.ExitCloseListener
import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.logic.system.security.AbCryptUtil
import _root_.org.allbinary.logic.system.security.AbKeys
import _root_.org.allbinary.logic.system.security.licensing.AbeClientInformationInterface
import _root_.org.allbinary.logic.system.security.licensing.AbeLicenseInterface
import _root_.org.allbinary.logic.system.security.licensing.AbeLicenseInterfaceFactory
import _root_.org.allbinary.logic.system.security.licensing.AbeNoLicense
import _root_.org.allbinary.logic.system.security.licensing.LicensingException
import _root_.org.allbinary.string.CommonStrings

class CryptService() {

    val logUtil : LogUtil = LogUtil.getInstance()

    private val commonStrings : CommonStrings = CommonStrings.getInstance()

    private val abCryptUtil : AbCryptUtil = AbCryptUtil.getInstance()

    //Constructor
    {
        Globals.getInstance().init(this.getClass().getClassLoader(), "./")
        this.logUtil.putF("Set Globals: " + URLGLOBALS.getWebappPath(), this, this.commonStrings.CONSTRUCTOR)
    }

    def getDecryptedInputStream(abeClientInformation : AbeClientInformationInterface, name : String, inputStream : InputStream) : InputStream = {
        try {
            val key : String = AbKeys.getInstance().getKey(abeClientInformation, name)
            val decrypted : Array[Byte] = this.abCryptUtil.decrypt(inputStream, key)
            /*          //TWB - test decryption          ByteArrayInputStream byteArrayInputStream =          new ByteArrayInputStream(decrypted);          DataInputStream dataInputStream =          new DataInputStream(byteArrayInputStream);          byte[] bytes = new byte[decrypted.length];          dataInputStream.readFully(bytes);           */
            return new ByteArrayInputStream(decrypted)
        } catch {
            case e : LicensingException => {
                this.showLicenseDialog(abeClientInformation, e)
            }
            case e : Exception => {
                this.showLicenseDialog(abeClientInformation, e)
            }
        }
        return null
    }

    private def showLicenseDialog(abeClientInformation : AbeClientInformationInterface, e : Exception) : Unit = {
        try {
            this.logUtil.put(this.commonStrings.EXCEPTION, this, this.commonStrings.INIT, e)
            val basicTextJDialog : BasicTextJDialog = new BasicTextJDialog(e.getMessage())
            try {
                val abeLicenseInterface : AbeLicenseInterface = AbeLicenseInterfaceFactory.getInstance().getLicenseInstance(abeClientInformation)
                if (abeLicenseInterface ne AbeNoLicense.getInstance()) {
                    if (abeLicenseInterface.isValid()) {
                        basicTextJDialog.setText("Subscription Invalid")
                    }
                }
            } catch {
                case e2 : LicensingException => {
                    this.logUtil.put(this.commonStrings.EXCEPTION, this, this.commonStrings.INIT, e2)
                }
            }
            basicTextJDialog.addCloseListener(new ExitCloseListener())
            basicTextJDialog.setVisible(true)
        } catch {
            case e3 : Exception => {
                this.logUtil.put(this.commonStrings.EXCEPTION, this, this.commonStrings.INIT, e3)
            }
        }
    }

}


