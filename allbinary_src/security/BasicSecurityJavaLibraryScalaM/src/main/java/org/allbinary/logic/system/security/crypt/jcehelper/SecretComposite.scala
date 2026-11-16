/*  * AllBinary Open License Version 1  * Copyright (c) 2025 AllBinary  *   * By agreeing to this license you and any business entity you represent are  * legally bound to the AllBinary Open License Version 1 legal agreement.  *   * You may obtain the AllBinary Open License Version 1 legal agreement from  * AllBinary or the root directory of AllBinary's AllBinary Platform repository.  *   * Created By: Travis Berthelot  *   */
/* Generated Code Do Not Modify */
package org.allbinary.logic.system.security.crypt.jcehelper

import _root_.javax.crypto.Cipher
import _root_.javax.crypto.SecretKey
import _root_.org.allbinary.logic.java.byteutil.ByteUtil

/**  *  * @author User  */
class SecretComposite(param_secretKey : SecretKey, param_cipher : Cipher, param_key : Array[Byte]) extends BaseSecretComposite {

    private val byteUtil : ByteUtil = ByteUtil.getInstance()

    private var cipher : Cipher = null

    private var secretKey : SecretKey = null

    private var key : Array[Byte] = null

    //Constructor
    {
        val secretKey : SecretKey = param_secretKey
        val cipher : Cipher = param_cipher
        val key : Array[Byte] = param_key
        this.secretKey = secretKey
        this.cipher = cipher
        this.key = key
    }

    override def encrypt(param_array : Array[Byte]) : Array[Byte] = {
        var array : Array[Byte] = param_array
        array = this.mutilate(array)
        this.cipher.init(Cipher.ENCRYPT_MODE, this.secretKey)
        return this.cipher.doFinal(array)
    }

    override def decrypt(array : Array[Byte]) : Array[Byte] = {
        this.cipher.init(Cipher.DECRYPT_MODE, this.secretKey)
        return this.mutilate(this.cipher.doFinal(array))
    }

    private def mutilate(param_array : Array[Byte]) : Array[Byte] = {
        var array : Array[Byte] = param_array

        {
            var index : Int = 0
            while (index < this.key.length) {
                var value : Byte = this.key(index)
                if ((value < 8) && (value > 0)) {
                    array = this.byteUtil.xorByte(array, value.toInt)
                }
                index += 1
            }
        }
        return array
    }

}


