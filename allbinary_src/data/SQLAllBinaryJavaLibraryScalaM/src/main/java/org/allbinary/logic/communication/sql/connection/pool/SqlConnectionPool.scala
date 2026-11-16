/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.logic.communication.sql.connection.pool

import _root_.java.sql.Connection
import _root_.java.sql.DriverManager
import _root_.java.sql.SQLException
import _root_.java.util.HashMap
import _root_.org.allbinary.util.BasicArrayList
import _root_.org.allbinary.util.BasicArrayListD
import _root_.org.allbinary.logic.StdUtil
import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.logic.string.StringMaker

class SqlConnectionPool private() {
    import _root_.org.allbinary.logic.communication.sql.connection.pool.SqlConnectionPool.{*}

    val logUtil : LogUtil = LogUtil.getInstance()

    val stdUtil : StdUtil = StdUtil.getInstance()

    private var connectionHashMap : HashMap[Object, Object] = null

    private val FIRST_NEW_CONNECTION_CREATED : String = "First New Connection Created: "

    private val FIRST : String = "First "

    private val NEW_CONNECTION_FOR : String = "New Connection For "

    private val CREATED : String = " Created"

    private val NUMBER_OF_SQL_CONNECTIONS_FOR : String = "Number Of Sql Connections for: "

    private val NUMBER_OF_SQL_CONNECTION_VECTORS : String = "Number Of Sql Connection Vectors: "

    private val IS : String = " is "

    private val CONNECTION_ALLREADY_CLOSED : String = "Connection AllReady Closed"

    private val METHOD_GET : String = "get()"

    private val METHOD_ADD : String = "add()"

    /*     public synchronized Connection get(String url, String userid, String password) throws SQLException     {     }      */
    def get(url : String) : Connection = this.synchronized {
        if (this.connectionHashMap == null) {
            this.connectionHashMap = this.stdUtil.createHashMap().asInstanceOf[HashMap[Object, Object]]
            if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().SQLLOGGINGPOOL)) {
                this.logUtil.putF(this.FIRST_NEW_CONNECTION_CREATED + url, this, METHOD_GET)
            }
            return DriverManager.getConnection(url)
        } else {
            var connectionVector : BasicArrayList = this.connectionHashMap.get(url).asInstanceOf[BasicArrayList]
            if (connectionVector == null) {
                connectionVector = new BasicArrayListD()
                if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().SQLLOGGINGPOOL)) {
                    var stringBuffer : StringMaker = new StringMaker()
                    stringBuffer.append(this.FIRST)
                    stringBuffer.append(this.NEW_CONNECTION_FOR)
                    stringBuffer.append(url)
                    stringBuffer.append(this.CREATED)
                    this.logUtil.putF(stringBuffer.toString(), this, this.METHOD_GET)
                }
                return DriverManager.getConnection(url)
            } else if (connectionVector.size() == 0) {
                if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().SQLLOGGINGPOOL)) {
                    this.logUtil.putF(new StringMaker().append(this.NEW_CONNECTION_FOR).append(url).append(this.CREATED).toString(), this, METHOD_GET)
                }
                return DriverManager.getConnection(url)
            } else {
                var stringBuffer : StringMaker = new StringMaker()
                var size : Int = connectionVector.size()

                {
                    var i : Int = 0
                    while (i < size) {
                        var sqlConnection : Connection = connectionVector.get(i).asInstanceOf[Connection]
                        if (!sqlConnection.isClosed()) {
                            connectionVector.remove(sqlConnection)
                            this.connectionHashMap.put(url, connectionVector)
                            if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().SQLLOGGINGPOOL)) {
                                stringBuffer.delete(0, stringBuffer.length())
                                stringBuffer.append(this.NUMBER_OF_SQL_CONNECTIONS_FOR)
                                stringBuffer.append(url)
                                stringBuffer.append(this.IS)
                                stringBuffer.appendint(connectionVector.size())
                                this.logUtil.putF(NUMBER_OF_SQL_CONNECTION_VECTORS + this.connectionHashMap.size(), this, this.METHOD_GET)
                                this.logUtil.putF(stringBuffer.toString(), this, METHOD_GET)
                            }
                            return sqlConnection.asInstanceOf[Connection]
                        }
                        i += 1
                    }
                }
            }
        }
        //Should never happen
        if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().SQLLOGGINGPOOL)) {
            var stringBuffer : StringMaker = new StringMaker()
            stringBuffer.append(this.NEW_CONNECTION_FOR)
            stringBuffer.append(url)
            stringBuffer.append(this.CREATED)
            this.logUtil.putF(stringBuffer.toString(), this, this.METHOD_GET)
        }
        return DriverManager.getConnection(url)
    }

    def add(url : String, sqlConnection : Connection) : Unit = this.synchronized {
        //Connection could be closed
        if (!sqlConnection.isClosed()) {
            var connectionVector : BasicArrayList = null
            if (this.connectionHashMap == null) {
                this.connectionHashMap = this.stdUtil.createHashMap().asInstanceOf[HashMap[Object, Object]]
                connectionVector = new BasicArrayListD()
                connectionVector.add(sqlConnection)
            } else {
                connectionVector = this.connectionHashMap.get(url).asInstanceOf[BasicArrayList]
                if (connectionVector == null) {
                    connectionVector = new BasicArrayListD()
                }
                connectionVector.add(sqlConnection)
                this.connectionHashMap.put(url, connectionVector)
            }
            if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().SQLLOGGINGPOOL)) {
                var stringBuffer : StringMaker = new StringMaker()
                stringBuffer.append(this.NUMBER_OF_SQL_CONNECTIONS_FOR)
                stringBuffer.append(url)
                stringBuffer.append(this.IS)
                stringBuffer.appendint(connectionVector.size())
                this.logUtil.putF(this.NUMBER_OF_SQL_CONNECTION_VECTORS + this.connectionHashMap.size(), this, this.METHOD_ADD)
                this.logUtil.putF(stringBuffer.toString(), this, this.METHOD_ADD)
            }
        }
        if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().SQLLOGGINGPOOL)) {
            this.logUtil.putF(this.CONNECTION_ALLREADY_CLOSED, this, METHOD_ADD)
        }
    }

}

object SqlConnectionPool {
    private val instance : SqlConnectionPool = new SqlConnectionPool()

    def getInstance() : SqlConnectionPool = {
        return SqlConnectionPool.instance
    }

}


