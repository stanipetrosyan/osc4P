package osc4P.api

import io.vertx.core.datagram.DatagramSocket
import osc4P.UdpServer

interface Server {

  companion object {
    @JvmStatic
    fun create(port: Int, host: String): Server = UdpServer(port, host)
  }

  fun serve(): DatagramSocket
}