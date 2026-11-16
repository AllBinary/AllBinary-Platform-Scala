/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *   */
/* Generated Code Do Not Modify */
package org.allbinary.logic.visual.transform

import _root_.java.io.ByteArrayInputStream
import _root_.java.io.ByteArrayOutputStream
import _root_.java.io.InputStream
import _root_.javax.xml.transform.URIResolver
import _root_.org.allbinary.data.tree.dom.BasicUriResolver
import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.logic.control.crypt.jcehelper.AbCrypt
import _root_.org.allbinary.logic.control.crypt.jcehelper.KeySpecFactory
import _root_.org.allbinary.logic.io.AbFileInputStream
import _root_.org.allbinary.logic.io.StreamUtil
import _root_.org.allbinary.logic.io.file.AbFile
import _root_.org.allbinary.logic.io.path.AbPathData
import _root_.org.allbinary.logic.io.path.PathUtil
import _root_.org.allbinary.logic.string.StringMaker
import _root_.org.allbinary.logic.system.security.AbKeys
import _root_.org.allbinary.logic.system.security.licensing.AbeClientInformationInterface
import _root_.org.allbinary.logic.visual.transform.info.TransformInfoInterface
import _root_.org.allbinary.logic.visual.transform.info.template.TransformInfoTemplateData

class BasicTransformer(param_abeClientInformation : AbeClientInformationInterface, param_transformInfoInterface : TransformInfoInterface) extends AbTransformer(param_transformInfoInterface) {

    val logUtil_BasicTransformer : LogUtil = LogUtil.getInstance()

    private val streamUtil : StreamUtil = StreamUtil.getInstance()

    //private InputStream inputStream;
    private var abeClientInformation : AbeClientInformationInterface = null

    //Constructor
    {
        val abeClientInformation : AbeClientInformationInterface = param_abeClientInformation
        val transformInfoInterface : TransformInfoInterface = param_transformInfoInterface
        this.abeClientInformation = abeClientInformation
        this.setTemplateAsInputStream()
    }

    //private InputStream getEncryptedTemplateFileAsInputStream(File file)
    private def setEncryptedTemplateFileAsInputStream(file : AbFile) : Unit = {
        var outputStream : ByteArrayOutputStream = null
        var inputStream : AbFileInputStream = null
        try {
            outputStream = new ByteArrayOutputStream()
            inputStream = AbFileInputStream.createFromAbFile(file)
            outputStream = this.streamUtil.get(inputStream, outputStream, new Array[Byte](16384)).asInstanceOf[ByteArrayOutputStream]
            val abCrypt : AbCrypt = new AbCrypt(KeySpecFactory.DESEDE, AbKeys.getInstance().getKey(this.abeClientInformation, file.getAbsolutePath()))
            val decrypted : Array[Byte] = abCrypt.decrypt(outputStream.toByteArray())
            if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().TAGHELPERFACTORY)) {
                this.logUtil_BasicTransformer.putF("Decrypted Template: \n" + new String(decrypted), this, "setEncryptedTemplateFileAsInputStream(file)")
            }
            this.setInputStream((new ByteArrayInputStream(decrypted)).asInstanceOf[InputStream])
            this.setURIResolver((new BasicUriResolver(TransformInfoTemplateData.getInstance().ENCRYPTED_EXTENSION)).asInstanceOf[URIResolver])
        } catch {
            case e : Exception => {
                if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().TAGHELPERFACTORYERROR)) {
                    var stringBuffer : StringMaker = new StringMaker()
                    stringBuffer.append("Failed to get Encrypted File: ")
                    stringBuffer.append(file.getPath())
                    stringBuffer.append(" \nName:")
                    stringBuffer.append(file.getName())
                    this.logUtil_BasicTransformer.put(stringBuffer.toString(), this, "setEncryptedTemplateFileAsInputStream()", e)
                }
                throw e
            }
        } finally {
            this.streamUtil.close(outputStream)
            this.streamUtil.close(inputStream)
        }
    }

    private def setEncryptedTemplateAsInputStream() : Unit = {
        var outputStream : ByteArrayOutputStream = null
        var inputStream : ByteArrayInputStream = null
        try {
            outputStream = new ByteArrayOutputStream()
            inputStream = new ByteArrayInputStream(this.getTransformInfoInterface().getTemplate().getBytes())
            outputStream = this.streamUtil.get(inputStream, outputStream, new Array[Byte](16384)).asInstanceOf[ByteArrayOutputStream]
            val abCrypt : AbCrypt = new AbCrypt(KeySpecFactory.DESEDE, AbKeys.getInstance().getKey(this.abeClientInformation, this.getTransformInfoInterface().getName()))
            val decrypted : Array[Byte] = abCrypt.decrypt(outputStream.toByteArray())
            if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().TAGHELPERFACTORY)) {
                this.logUtil_BasicTransformer.putF("Decrypted Template: \n" + decrypted.toString(), this, "setEncryptedTemplateAsInputStream()")
            }
            this.setInputStream((new ByteArrayInputStream(decrypted)).asInstanceOf[InputStream])
            this.setURIResolver((new BasicUriResolver(TransformInfoTemplateData.getInstance().ENCRYPTED_EXTENSION)).asInstanceOf[URIResolver])
        } catch {
            case e : Exception => {
                if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().TAGHELPERFACTORYERROR)) {
                    this.logUtil_BasicTransformer.put("Failed to set with template: " + this.getTransformInfoInterface().getTemplateFilePath(), this, "setEncryptedTemplateFileAsInputStream()", e)
                }
                throw e
            }
        } finally {
            this.streamUtil.close(outputStream)
            this.streamUtil.close(inputStream)
        }
    }

    //otherwise return the Template as an inputstream
    private def setTemplateAsInputStream() : Unit = {
        var inputStream : AbFileInputStream = null
        var outputStream : ByteArrayOutputStream = null
        try {
            if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().TAGHELPERFACTORY)) {
                this.logUtil_BasicTransformer.putF(this.getTransformInfoInterface().log(), this, "setTemplateAsInputStream()")
            }
            val transformInfoTemplateData : TransformInfoTemplateData = TransformInfoTemplateData.getInstance()
            val pathUtil : PathUtil = PathUtil.getInstance()
            if (this.getTransformInfoInterface().getTemplateFilePath() != null) {
                val extension : String = pathUtil.getExtensionWithAbPath(this.getTransformInfoInterface().getTemplateFilePath())
                val filePath : String = pathUtil.getWithoutExtensionWithAbPath(this.getTransformInfoInterface().getTemplateFilePath())
                if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().TAGHELPERFACTORY)) {
                    this.logUtil_BasicTransformer.putF(this.getTransformInfoInterface().log(), this, "setTemplateAsInputStream()")
                }
                if (extension.compareTo(transformInfoTemplateData.UNCRYPTED_EXTENSION) == 0) {
                    //attempt to load an encrypted version
                    var stringBuffer : StringMaker = new StringMaker()
                    stringBuffer.append(filePath)
                    stringBuffer.append(AbPathData.getInstance().EXTENSION_SEP)
                    stringBuffer.append(transformInfoTemplateData.ENCRYPTED_EXTENSION)
                    val encFile : AbFile = AbFile.createAbFile(stringBuffer.toString())
                    if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().TAGHELPERFACTORY)) {
                        this.logUtil_BasicTransformer.putF(this.getTransformInfoInterface().log(), this, "setTemplateAsInputStream()")
                    }
                    if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().TAGHELPERFACTORY)) {
                        stringBuffer = new StringMaker()
                        //stringBuffer.delete(0, stringBuffer.length());
                        stringBuffer.append("Encrypted Template File isFile=")
                        stringBuffer.appendboolean(encFile.isFile())
                        stringBuffer.append("\nEncTemplateFilePath: ")
                        stringBuffer.append(encFile.getPath())
                        this.logUtil_BasicTransformer.putF(stringBuffer.toString(), this, "setTemplateAsInputStream()")
                    }
                    if (encFile.isFile()) {
                        this.setEncryptedTemplateFileAsInputStream(encFile)
                        return
                    } else {
                        val file : AbFile = AbFile.createAbFileFromAbPath(this.getTransformInfoInterface().getTemplateFilePath())
                        if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().TAGHELPERFACTORY)) {
                            this.logUtil_BasicTransformer.putF(this.getTransformInfoInterface().log(), this, "setTemplateAsInputStream()")
                        }
                        if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().TAGHELPERFACTORY)) {
                            this.logUtil_BasicTransformer.putF("Template File isFile=" + file.isFile(), this, "setTemplateAsInputStream()")
                        }
                        if (file.isFile()) {
                            inputStream = AbFileInputStream.createFromAbFile(file)
                            outputStream = new ByteArrayOutputStream()
                            outputStream = this.streamUtil.get(inputStream, outputStream, new Array[Byte](16384)).asInstanceOf[ByteArrayOutputStream]
                            if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().TAGHELPERFACTORY)) {
                                this.logUtil_BasicTransformer.putF("Template: " + outputStream.toString(), this, "getTemplateAsInputStream()")
                            }
                            this.setInputStream((new ByteArrayInputStream(outputStream.toByteArray())).asInstanceOf[InputStream])
                            this.setURIResolver((new BasicUriResolver(transformInfoTemplateData.UNCRYPTED_EXTENSION)).asInstanceOf[URIResolver])
                            return
                        }
                    }
                } else if (extension.compareTo(transformInfoTemplateData.ENCRYPTED_EXTENSION) == 0) {
                    val stringBuffer : StringMaker = new StringMaker()
                    stringBuffer.append(filePath)
                    stringBuffer.append(AbPathData.getInstance().EXTENSION_SEP)
                    stringBuffer.append(transformInfoTemplateData.ENCRYPTED_EXTENSION)
                    val file : AbFile = AbFile.createAbFile(stringBuffer.toString())
                    if (file.isFile()) {
                        this.setEncryptedTemplateFileAsInputStream(file)
                    }
                } else {
                    throw new Exception("View Template File Type Is Not Recognized: " + this.getTransformInfoInterface().getTemplateFilePath())
                }
            } else {
                this.setEncryptedTemplateAsInputStream()
            }
        } catch {
            case e : Exception => {
                if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().TAGHELPERFACTORYERROR)) {
                    this.logUtil_BasicTransformer.put("Failed to get Template Data", this, "setTemplateAsInputStream()", e)
                }
                throw e
            }
        } finally {
            this.streamUtil.close(outputStream)
            this.streamUtil.close(inputStream)
        }
        throw new Exception("Error setTemplateAsInputStream()")
    }

}


