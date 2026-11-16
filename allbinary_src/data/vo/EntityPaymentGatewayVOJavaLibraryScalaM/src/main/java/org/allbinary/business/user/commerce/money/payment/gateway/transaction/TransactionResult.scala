/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.business.user.commerce.money.payment.gateway.transaction

import _root_.java.util.HashMap
import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.logic.string.StringUtil
import _root_.org.allbinary.logic.string.tokens.Tokenizer
import _root_.org.allbinary.string.CommonSeps
import _root_.org.allbinary.string.CommonStrings
import _root_.org.allbinary.util.ABHashtable
import _root_.org.allbinary.util.BasicArrayList
import _root_.org.allbinary.util.BasicArrayListD

class TransactionResult private () extends TransactionResultInterface {

    val logUtil : LogUtil = LogUtil.getInstance()

    val commonStrings : CommonStrings = CommonStrings.getInstance()

    private var keyValuePairs : HashMap[Object, Object] = null

    private var result : String = null

    def this(result : String) = {
        this()
        try {
            this.result = result
            var tokenizer : Tokenizer = new Tokenizer(CommonSeps.getInstance().AMPERSAND)
            var tokens : BasicArrayList = tokenizer.getTokensFromString(result, new BasicArrayListD())
            var tokenizer2 : Tokenizer = new Tokenizer(CommonSeps.getInstance().EQUALS)
            var hashtable : ABHashtable[Object, Object] = tokenizer2.getTokens(tokens)
            //TWB - does this actually work?
            this.keyValuePairs.putAll(hashtable)
        } catch {
            case e : Exception => {
                var exceptionMessage : String = "TransactionResult Constructor Failed"
                //{
                this.logUtil.putF(exceptionMessage, this, this.commonStrings.CONSTRUCTOR)
            }
        }
    }

    def this(param_keyValuePairs : HashMap[Object, Object]) = {
        this()
        var keyValuePairs : HashMap[Object, Object] = param_keyValuePairs
        keyValuePairs = keyValuePairs
        this.result = "Needs to have the hashmap converted to string for other constructor"
    }

    override def toString() : String = {
        return this.result
    }

    def toHashMap() : HashMap[Object, Object] = {
        return this.keyValuePairs
    }

    private def getAllPossibleKeys() : BasicArrayList = {
        var paymentTransactionKeysFactory : PaymentTransactionKeysFactory = PaymentTransactionKeysFactory.getInstance()
        var verisignResponseKeys : BasicArrayList = new BasicArrayListD()
        verisignResponseKeys.add(paymentTransactionKeysFactory.RESULT.toString())
        verisignResponseKeys.add(paymentTransactionKeysFactory.PNREF.toString())
        verisignResponseKeys.add(paymentTransactionKeysFactory.RESPMSG.toString())
        verisignResponseKeys.add(paymentTransactionKeysFactory.AUTHCODE.toString())
        verisignResponseKeys.add(paymentTransactionKeysFactory.AVSADDR.toString())
        verisignResponseKeys.add(paymentTransactionKeysFactory.AVSZIP.toString())
        verisignResponseKeys.add(paymentTransactionKeysFactory.ORIGRESULT.toString())
        verisignResponseKeys.add(paymentTransactionKeysFactory.STATUS.toString())
        verisignResponseKeys.add(paymentTransactionKeysFactory.FRAUDCODE.toString())
        verisignResponseKeys.add(paymentTransactionKeysFactory.FRAUDMSG.toString())
        verisignResponseKeys.add(paymentTransactionKeysFactory.ERRCODE.toString())
        verisignResponseKeys.add(paymentTransactionKeysFactory.SCORE.toString())
        verisignResponseKeys.add(paymentTransactionKeysFactory.REASON1.toString())
        verisignResponseKeys.add(paymentTransactionKeysFactory.REASON2.toString())
        verisignResponseKeys.add(paymentTransactionKeysFactory.REASON3.toString())
        verisignResponseKeys.add(paymentTransactionKeysFactory.EXCEPTION1.toString())
        verisignResponseKeys.add(paymentTransactionKeysFactory.EXCEPTION2.toString())
        verisignResponseKeys.add(paymentTransactionKeysFactory.EXCEPTION3.toString())
        verisignResponseKeys.add(paymentTransactionKeysFactory.EXCEPTION4.toString())
        verisignResponseKeys.add(paymentTransactionKeysFactory.EXCEPTION5.toString())
        verisignResponseKeys.add(paymentTransactionKeysFactory.EXCEPTION6.toString())
        verisignResponseKeys.add(paymentTransactionKeysFactory.EXCEPTION7.toString())
        return verisignResponseKeys
    }

    def getValues() : BasicArrayList = {
        var keyVector : BasicArrayList = this.getAllPossibleKeys()
        var valueVector : BasicArrayList = new BasicArrayListD()
        var size : Int = keyVector.size()

        {
            var i : Int = 0
            while (i < size) {
                var key : String = keyVector.get(i).asInstanceOf[String]
                if (this.keyValuePairs.containsKey(key)) {
                    valueVector.add(this.keyValuePairs.get(key))
                } else {
                    val stringUtil : StringUtil = StringUtil.getInstance()
                    valueVector.add(stringUtil.EMPTY_STRING)
                }
                i += 1
            }
        }
        return valueVector
    }

    def getPnRef() : String = {
        return this.keyValuePairs.get(PaymentTransactionKeysFactory.getInstance().PNREF.toString()).asInstanceOf[String]
    }

    def getRespMsg() : String = {
        return this.keyValuePairs.get(PaymentTransactionKeysFactory.getInstance().RESPMSG.toString()).asInstanceOf[String]
    }

    def getResult() : String = {
        return this.keyValuePairs.get(PaymentTransactionKeysFactory.getInstance().RESULT.toString()).asInstanceOf[String]
    }

    def getScore() : String = {
        return this.keyValuePairs.get(PaymentTransactionKeysFactory.getInstance().SCORE.toString()).asInstanceOf[String]
    }

    def getStatus() : String = {
        return this.keyValuePairs.get(PaymentTransactionKeysFactory.getInstance().STATUS.toString()).asInstanceOf[String]
    }

    def getFraudCode() : String = {
        return this.keyValuePairs.get(PaymentTransactionKeysFactory.getInstance().FRAUDCODE.toString()).asInstanceOf[String]
    }

    def getFraudMsg() : String = {
        return this.keyValuePairs.get(PaymentTransactionKeysFactory.getInstance().FRAUDMSG.toString()).asInstanceOf[String]
    }

    def getOrigResult() : String = {
        return this.keyValuePairs.get(PaymentTransactionKeysFactory.getInstance().ORIGRESULT.toString()).asInstanceOf[String]
    }

    def getAvsAddr() : String = {
        return this.keyValuePairs.get(PaymentTransactionKeysFactory.getInstance().AVSADDR.toString()).asInstanceOf[String]
    }

    def getAvsZip() : String = {
        return this.keyValuePairs.get(PaymentTransactionKeysFactory.getInstance().AVSZIP.toString()).asInstanceOf[String]
    }

    def getErrCode() : String = {
        return this.keyValuePairs.get(PaymentTransactionKeysFactory.getInstance().ERRCODE.toString()).asInstanceOf[String]
    }

    def getException1() : String = {
        return this.keyValuePairs.get(PaymentTransactionKeysFactory.getInstance().EXCEPTION1.toString()).asInstanceOf[String]
    }

    def getException2() : String = {
        return this.keyValuePairs.get(PaymentTransactionKeysFactory.getInstance().EXCEPTION2.toString()).asInstanceOf[String]
    }

    def getException3() : String = {
        return this.keyValuePairs.get(PaymentTransactionKeysFactory.getInstance().EXCEPTION3.toString()).asInstanceOf[String]
    }

    def getException4() : String = {
        return this.keyValuePairs.get(PaymentTransactionKeysFactory.getInstance().EXCEPTION4.toString()).asInstanceOf[String]
    }

    def getException5() : String = {
        return this.keyValuePairs.get(PaymentTransactionKeysFactory.getInstance().EXCEPTION5.toString()).asInstanceOf[String]
    }

    def getException6() : String = {
        return this.keyValuePairs.get(PaymentTransactionKeysFactory.getInstance().EXCEPTION6.toString()).asInstanceOf[String]
    }

    def getException7() : String = {
        return this.keyValuePairs.get(PaymentTransactionKeysFactory.getInstance().EXCEPTION7.toString()).asInstanceOf[String]
    }

    def getReason1() : String = {
        return this.keyValuePairs.get(PaymentTransactionKeysFactory.getInstance().REASON1.toString()).asInstanceOf[String]
    }

    def getReason2() : String = {
        return this.keyValuePairs.get(PaymentTransactionKeysFactory.getInstance().REASON2.toString()).asInstanceOf[String]
    }

    def getReason3() : String = {
        return this.keyValuePairs.get(PaymentTransactionKeysFactory.getInstance().REASON3.toString()).asInstanceOf[String]
    }

}


