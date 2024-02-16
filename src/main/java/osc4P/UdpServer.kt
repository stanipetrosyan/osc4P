package osc4P

import io.vertx.core.Vertx
import io.vertx.core.datagram.DatagramSocket
import io.vertx.core.datagram.DatagramSocketOptions
import osc4P.api.Server


class UdpServer(private val vertx: Vertx = Vertx.vertx()): Server {
  override fun serve(port: Int, host: String): DatagramSocket {
    return vertx.createDatagramSocket(DatagramSocketOptions())
  }
}