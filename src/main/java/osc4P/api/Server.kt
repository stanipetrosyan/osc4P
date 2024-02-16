package osc4P.api

import io.vertx.core.datagram.DatagramSocket

interface Server {
  fun serve(port: Int, host: String): DatagramSocket
}