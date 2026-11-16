/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.logic.system.security.crypt.jcehelper

import _root_.java.security.Provider
import _root_.java.security.Security
import _root_.java.security.spec.KeySpec
import _root_.javax.crypto.Cipher
import _root_.javax.crypto.SecretKey
import _root_.javax.crypto.SecretKeyFactory
import _root_.org.allbinary.init.crypt.jcehelper.CryptInterface
import _root_.org.allbinary.logic.communication.log.PreLogUtil
import _root_.org.allbinary.string.CommonStrings

class AbBasicCrypt(param_algorithm : String, param_key : String) extends CryptInterface {

    //protected final LogUtil logUtil = LogUtil.getInstance();
    private var cipher : Cipher = null

    private var secretKey : SecretKey = null

    private var algorithm : String = null

    private var key : Array[Byte] = null

    //Constructor
    {
        val algorithm : String = param_algorithm
        val key : String = param_key
        try {
            this.algorithm = algorithm
            this.key = key.getBytes()
            this.init()
        } catch {
            case e : Exception => {
                //{
                val commonStrings : CommonStrings = CommonStrings.getInstance()
                PreLogUtil.putOE(commonStrings.EXCEPTION, this, "AbCrypt(alg,key)", e)
            }
        }
    }

    private def init() : Unit = {
        try {
            var sunJce : Provider = new _root_.com.sun.crypto.provider.SunJCE()
            Security.addProvider(sunJce)
            var keySpec : KeySpec = KeySpecFactory.getInstance().getInstance(this.algorithm, this.key)
            var keyFactory : SecretKeyFactory = SecretKeyFactory.getInstance(this.algorithm)
            this.secretKey = keyFactory.generateSecret(keySpec)
            this.cipher = Cipher.getInstance(this.algorithm)
        } catch {
            case e : Exception => {
                //{
                val commonStrings : CommonStrings = CommonStrings.getInstance()
                PreLogUtil.putOE("init Failed", this, commonStrings.INIT, e)
            }
        }
    }

    def encrypt(array : Array[Byte]) : Array[Byte] = {
        try {
            this.cipher.init(Cipher.ENCRYPT_MODE, secretKey)
            var ivArray : Array[Byte] = this.secretKey.getEncoded()
            var encrypted : Array[Byte] = this.cipher.doFinal(array)
            var result : Array[Byte] = new Array[Byte](ivArray.length + encrypted.length)
            //{
            PreLogUtil.put("ivArray Length: " + ivArray.length, this, "encrypt")
            //}

            {
                var index : Int = 0
                while (index < ivArray.length) {
                    result(index) = ivArray(index)
                    index += 1
                }
            }

            {
                var index : Int = 0
                while (index < encrypted.length) {
                    result(index + ivArray.length) = encrypted(index)
                    index += 1
                }
            }
            return result
        } catch {
            case e : Exception => {
                //{
                PreLogUtil.putOE("Encrypt Failed", this, "encrypt", e)
                //}
                return null
            }
        }
        throw new IllegalStateException()
    }

    def decrypt(array : Array[Byte]) : Array[Byte] = {
        try {
            this.cipher.init(Cipher.DECRYPT_MODE, secretKey)
            var ivArray : Array[Byte] = new Array[Byte](8)

            {
                var index : Int = 0
                while (index < 8) {
                    ivArray(index) = array(index)
                    index += 1
                }
            }
            //{
            PreLogUtil.put("ivArray Length: " + ivArray.length, this, "encrypt")
            //}
            var result : Array[Byte] = new Array[Byte](array.length - ivArray.length)

            {
                var index : Int = ivArray.length
                while (index < array.length) {
                    result(index - ivArray.length) = array(index)
                    index += 1
                }
            }
            var decrypted : Array[Byte] = this.cipher.doFinal(result)
            return result
        } catch {
            case e : Exception => {
                //{
                PreLogUtil.putOE("decrypt Failed", this, "decrypt", e)
                //}
                return null
            }
        }
        throw new IllegalStateException()
    }

}


