package osc4P

import io.vertx.core.Vertx
import io.vertx.core.datagram.DatagramSocketOptions
import osc4P.api.Client

class UdpClient(private val port: Int, private val host: String) : Client {
  private val vertx: Vertx = Vertx.vertx()
  private val socket = vertx.createDatagramSocket(DatagramSocketOptions())

  override fun send(message: String) {
    socket.send(message, port, host)
  }

}