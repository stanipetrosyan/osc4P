package osc4P

import io.vertx.core.Vertx
import io.vertx.core.datagram.DatagramSocket
import io.vertx.core.datagram.DatagramSocketOptions
import osc4P.api.Server


class UdpServer(private val port: Int, private val host: String): Server {
  private val vertx: Vertx = Vertx.vertx()

  override fun serve(): DatagramSocket {
    return vertx.createDatagramSocket(DatagramSocketOptions())
  }
}