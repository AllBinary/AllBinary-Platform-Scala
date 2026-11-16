/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.logic.system.security.crypt.jcehelper

import _root_.java.security.Security
import _root_.java.security.spec.KeySpec
import _root_.javax.crypto.Cipher
import _root_.javax.crypto.SecretKey
import _root_.javax.crypto.SecretKeyFactory
import _root_.org.allbinary.TsUtil
import _root_.org.allbinary.init.crypt.jcehelper.CryptInterface
import _root_.org.allbinary.logic.NullUtil
import _root_.org.allbinary.logic.communication.log.PreLogUtil
import _root_.org.allbinary.string.CommonStrings
import _root_.org.bouncycastle.jce.provider.BouncyCastleProvider

class AbCrypt(param_algorithm : String) extends CryptInterface {

    //protected final LogUtil logUtil = LogUtil.getInstance();
    private val tsUtil : TsUtil = TsUtil.getInstance()

    private var secretComposite : BaseSecretComposite = BaseSecretComposite.NULL_SECRET_COMPOSITE

    private var algorithm : String = null

    //Constructor
    {
        val algorithm : String = param_algorithm
        this.algorithm = algorithm
    }

    def init(keyAsString : String) : Unit = {
        val commonStrings : CommonStrings = CommonStrings.getInstance()
        try {
            //Security.addProvider(sunJce);
            try {
                Security.addProvider(new BouncyCastleProvider())
            } catch {
                case e : Exception => {
                    PreLogUtil.putOE(commonStrings.EXCEPTION, this, commonStrings.INIT, e)
                }
            }
            val key : Array[Byte] = this.tsUtil.getByteArray(keyAsString)
            val keySpec : KeySpec = KeySpecFactory.getInstance().getInstance(this.algorithm, key)
            val keyFactory : SecretKeyFactory = SecretKeyFactory.getInstance(this.algorithm)
            val secretKey : SecretKey = keyFactory.generateSecret(keySpec)
            val cipher : Cipher = Cipher.getInstance(this.algorithm)
            this.secretComposite = new SecretComposite(secretKey, cipher, key)
        } catch {
            case e : Exception => {
                //{
                PreLogUtil.putOE("init Failed", this, commonStrings.INIT, e)
            }
        }
    }

    override def encrypt(array : Array[Byte]) : Array[Byte] = {
        try {
            return this.secretComposite.encrypt(array)
        } catch {
            case e : Exception => {
                //{
                PreLogUtil.putOE("Encrypt Failed", this, "encrypt", e)
                //}
                return NullUtil.getInstance().NULL_BYTE_ARRAY
            }
        }
        throw new IllegalStateException()
    }

    override def decrypt(array : Array[Byte]) : Array[Byte] = {
        try {
            return this.secretComposite.decrypt(array)
        } catch {
            case e : Exception => {
                //{
                PreLogUtil.putOE("decrypt Failed", this, "decrypt", e)
                //}
                return NullUtil.getInstance().NULL_BYTE_ARRAY
            }
        }
        throw new IllegalStateException()
    }

}


